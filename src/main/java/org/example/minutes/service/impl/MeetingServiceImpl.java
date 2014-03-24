package org.example.minutes.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.MeetingDao;
import org.example.minutes.entity.Meeting;
import org.example.minutes.service.MeetingService;

@Stateless
@LocalBean
public class MeetingServiceImpl implements MeetingService {
	
	@EJB
	private MeetingDao meetingDao;

	public List<Meeting> findMeetingList() {
		return meetingDao.findAll();
	}

}
