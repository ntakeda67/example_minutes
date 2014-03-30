package org.example.minutes.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.MeetingTypeDao;
import org.example.minutes.dto.MeetingTypeDto;
import org.example.minutes.entity.MeetingType;
import org.example.minutes.service.MeetingTypeService;

@Stateless
@LocalBean
public class MeetingTypeServiceImpl implements MeetingTypeService {
	
	@EJB
	private MeetingTypeDao meetingTypeDao;

	public List<MeetingTypeDto> findMeetingTypeList() {
		List<MeetingType> meetingTypeList = meetingTypeDao.findAll();
		return convertToDtoList(meetingTypeList);
	}
	
	private List<MeetingTypeDto> convertToDtoList(List<MeetingType> entityList){
		List<MeetingTypeDto> dtoList = new ArrayList<MeetingTypeDto>();
		for(MeetingType entity : entityList){
			dtoList.add(convertToDto(entity));
		}
		return dtoList;
	}

	private MeetingTypeDto convertToDto(MeetingType entity) {
		MeetingTypeDto meetingTypeDto = new MeetingTypeDto();
		meetingTypeDto.setRid(entity.getRid());
		meetingTypeDto.setName(entity.getName());
		return meetingTypeDto;
	}
	


}
