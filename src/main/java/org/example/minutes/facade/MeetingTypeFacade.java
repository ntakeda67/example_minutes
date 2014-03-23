package org.example.minutes.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.minutes.entity.MeetingType;
import org.example.minutes.service.MeetingTypeService;

@Path("/meetingTypes")
public class MeetingTypeFacade {
	
	@EJB
	private MeetingTypeService meetingTypeService;
	
	@POST
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MeetingType> inquireMeetingTypeList(){
		return meetingTypeService.findMeetingTypeList();
	}

}
