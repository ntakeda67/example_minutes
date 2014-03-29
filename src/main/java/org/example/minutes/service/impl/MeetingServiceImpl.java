package org.example.minutes.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.MeetingDao;
import org.example.minutes.dto.MeetingDetailDto;
import org.example.minutes.entity.Meeting;
import org.example.minutes.service.MeetingService;

@Stateless
@LocalBean
public class MeetingServiceImpl implements MeetingService {
	
	@EJB
	private MeetingDao meetingDao;
	
	// FIXME Jacksonにやらせる
	private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public List<MeetingDetailDto> findMeetingList() {
		List<Meeting> meetingList = meetingDao.findAll();
		return convertToMeetingEntity(meetingList);
	}
	
	public List<MeetingDetailDto> convertToMeetingEntity(List<Meeting> entityList){
		List<MeetingDetailDto> dtoList = new ArrayList<MeetingDetailDto>();
		
		for(Meeting entity : entityList){
			dtoList.add(convertToMeetingEntity(entity));
		}
		return dtoList;
	}
	
	public MeetingDetailDto convertToMeetingEntity(Meeting entity){
		MeetingDetailDto dto = new MeetingDetailDto();
		
		dto.setRid(entity.getRid());
		dto.setPurpose(entity.getPurpose());
		dto.setPeriod(Short.valueOf(entity.getPeriod()));
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
		System.out.println(date);
		if(date == null){
			return "";
		}
		
		return formatter.format(date);
	}
	

}
