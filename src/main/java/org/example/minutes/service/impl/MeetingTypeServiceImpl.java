package org.example.minutes.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.MeetingTypeDao;
import org.example.minutes.entity.MeetingType;
import org.example.minutes.service.MeetingTypeService;

@Stateless
@LocalBean
public class MeetingTypeServiceImpl implements MeetingTypeService {
	
	@EJB
	private MeetingTypeDao meetingTypeDao;

	public List<MeetingType> findMeetingTypeList() {
		return meetingTypeDao.findAll();
	}

}
