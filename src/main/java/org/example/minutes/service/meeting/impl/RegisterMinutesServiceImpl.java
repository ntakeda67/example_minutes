package org.example.minutes.service.meeting.impl;

import java.math.BigDecimal;

import javax.ejb.EJB;

import org.example.minutes.dao.meeting.MinutesDao;
import org.example.minutes.dto.meeting.RegisterMinutesRequestDto;
import org.example.minutes.entity.Meeting;
import org.example.minutes.entity.Minutes;
import org.example.minutes.service.meeting.RegisterMinutesService;

public class RegisterMinutesServiceImpl implements RegisterMinutesService {

	@EJB
	private MinutesDao minutesDao;

	
	
	public void registerMinutes(RegisterMinutesRequestDto dto) {
		
		Minutes minutes = new Minutes();
		
		// TODO 要修正	
		Meeting meeting = new Meeting();
		meeting.setRid(new BigDecimal("1"));
		minutes.setMeeting(meeting);
		
	}

}
