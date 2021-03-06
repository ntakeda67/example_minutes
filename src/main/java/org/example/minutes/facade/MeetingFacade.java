package org.example.minutes.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.minutes.entity.Meeting;
import org.example.minutes.service.MeetingService;

@Path("/meetings")
public class MeetingFacade {
	
	@EJB
	private MeetingService meetingService;
	
	@POST
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Meeting> inquireMeetings(){
		return meetingService.findMeetingList();
	}
}
