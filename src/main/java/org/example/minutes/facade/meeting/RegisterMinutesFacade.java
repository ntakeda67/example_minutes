package org.example.minutes.facade.meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.meeting.RegisterMinutesRequestDto;
import org.example.minutes.dto.meeting.SearchMeetingListDto;
import org.example.minutes.dto.meeting.SearchMeetingResultDto;

@Path("/registerMinutes")
public class RegisterMinutesFacade {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String registerMinutes(RegisterMinutesRequestDto dto) {
	
		
		
		return "success";
	}
	
	
}
