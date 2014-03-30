package org.example.minutes.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.MeetingDetailDto;
import org.example.minutes.service.MeetingService;

@Path("/meetings")
public class MeetingFacade {
	
	@EJB
	private MeetingService meetingService;
	
	@POST
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MeetingDetailDto> inquireMeetings(){
		return meetingService.findMeetingList();
	}
	
	@PUT
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public void registgerMeeting(MeetingDetailDto dto){
		if(dto.getRid() == null) {
			meetingService.registerMeeting(dto);
		}
		
		meetingService.modifyMeeting(dto);
	}
}
