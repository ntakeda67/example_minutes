package org.example.minutes.service.meeting;

import javax.ejb.Local;

import org.example.minutes.dto.meeting.RegisterMinutesRequestDto;

@Local
public interface RegisterMinutesService {

	public void registerMinutes(RegisterMinutesRequestDto dto);
	
}
