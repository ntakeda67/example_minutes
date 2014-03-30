package org.example.minutes.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.MeetingDao;
import org.example.minutes.dao.MeetingFormDao;
import org.example.minutes.dao.MeetingTypeDao;
import org.example.minutes.dto.MeetingDetailDto;
import org.example.minutes.entity.Meeting;
import org.example.minutes.entity.MeetingForm;
import org.example.minutes.service.MeetingService;

@Stateless
@LocalBean
public class MeetingServiceImpl implements MeetingService {
	
	@EJB
	private MeetingDao meetingDao;
	
	@EJB
	private MeetingTypeDao meetingTypeDao;
	
	@EJB
	private MeetingFormDao meetingFormDao;
	
	// FIXME Jacksonにやらせる
	private static String datetimeFormat = "yyyy-MM-dd'T'HH:mm";
	private static DateFormat formatter = new SimpleDateFormat(datetimeFormat);

	public List<MeetingDetailDto> findMeetingList() {
		List<Meeting> meetingList = meetingDao.findAll();
		return convertToMeetingEntity(meetingList);
	}
	
	public List<MeetingDetailDto> convertToMeetingEntity(List<Meeting> entityList){
		List<MeetingDetailDto> dtoList = new ArrayList<MeetingDetailDto>();
		
		for(Meeting entity : entityList){
			dtoList.add(convertToDetailDto(entity));
		}
		return dtoList;
	}
	
	private MeetingDetailDto convertToDetailDto(Meeting entity){
		MeetingDetailDto dto = new MeetingDetailDto();
		//MeetingForm form = meetingFormDao.find(entity.getRid());
		
		dto.setRid(entity.getRid());
		dto.setPurpose(entity.getPurpose());
		dto.setPeriod(Short.valueOf(entity.getPeriod()));
		//FIXME 関連テーブルがSetででマークされてるのでややこしくなってる。 FKで存在が約束されてないと闇
		dto.setMeetingTypeRid(((MeetingForm) entity.getMeetingForms().iterator().next()).getMeetingType().getRid());
		// FIXME 
		dto.setStartDate(formatDate(entity.getStartDate()));
		dto.setEndDate(formatDate(entity.getEndDate()));
		dto.setPlace(entity.getPlace());
		dto.setTopic(entity.getTopic());
		dto.setGoal(entity.getGoal());
		dto.setPreparation(entity.getPreparation());
		dto.setRegisterDate(formatDate(entity.getRegisterDate()));
		dto.setModifyDate(formatDate(entity.getModifyDate()));
		dto.setCancelDate(formatDate(entity.getCancelDate()));
		dto.setUpdateDate(entity.getUpdateDate().getTime());
		
		return dto;
	}
	
	private String formatDate(Date date){
		if(date == null){
			return "";
		}
		
		return formatter.format(date);
	}

	public void registerMeeting(MeetingDetailDto dto) {
		Date transactionDate = new Date();
		
		Meeting entity = convertToEntity(dto);
		entity.setRegisterDate(transactionDate);
		
		meetingDao.insert(entity);
		
		MeetingForm form = new MeetingForm();
		form.setMeeting(entity);
		// FIXME
		form.setMeetingType(meetingTypeDao.find(dto.getMeetingTypeRid()));
		meetingFormDao.insert(form);
	}
	
	private Meeting convertToEntity(MeetingDetailDto dto){
		Meeting entity = new Meeting();
		
		Date startDate = parseDate(dto.getStartDate());
		Date endDate = parseDate(dto.getEndDate());

		entity.setRid(dto.getRid());
		entity.setPurpose(dto.getPurpose());
		entity.setPeriod(calcPeriod(startDate, endDate));
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		entity.setPlace(dto.getPlace());
		entity.setTopic(dto.getTopic());
		entity.setGoal(dto.getGoal());
		entity.setPreparation(dto.getPreparation());
		entity.setRegisterDate(parseDate(dto.getRegisterDate()));
		entity.setModifyDate(parseDate(dto.getModifyDate()));
		entity.setCancelDate(parseDate(dto.getCancelDate()));
		
		return entity;
	}
	
	private Short calcPeriod(Date startDate, Date endDate){
		if( (startDate == null) || (endDate == null)) {
			return null;
		}
		Long period = ( endDate.getTime() - startDate.getTime() ) / 1000 / 60;
		return period.shortValue();
	}
	
	private Date parseDate(String dateString){
		// FIXME StringUtilsかなんかが入ったら
		if(dateString == null || "".equals(dateString)){
			return null;
		}
		try {
			return formatter.parse(dateString);
		} catch(ParseException e){
			throw new IllegalArgumentException("パース対象の日付文字列(" + dateString + ") のフォーマットが規定のフォーマット(" + datetimeFormat + ")に従っていません。");
		}
	}

	public void modifyMeeting(MeetingDetailDto dto) {
		Meeting entity = convertToEntity(dto);
		
	}

}
