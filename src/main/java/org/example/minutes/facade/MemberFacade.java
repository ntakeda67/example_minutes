package org.example.minutes.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.MemberDetailDto;
import org.example.minutes.service.MemberService;

@Path("/member")
public class MemberFacade {
	
	@EJB
	private MemberService memberService;
	
	@POST
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MemberDetailDto> inquireMembers(){
		return memberService.findMemberList();
	}
	
	@PUT
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public void registgerMember(MemberDetailDto dto){
		if(dto.getRid() == null) {
			memberService.registerMember(dto);
		} else {
			memberService.modifyMember(dto);
		}
	}
}
