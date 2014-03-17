package org.terash.meeting.facade.system;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.terash.meeting.dto.LoginDto;
import org.terash.meeting.entity.Member;
import org.terash.meeting.service.system.LoginService;


@Path("/doLogin")
public class LoginFacade {

	@EJB
	private LoginService loginService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String doLogin(LoginDto loginDto) {
	
		Member member = loginService.findMemberByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());
		
		
		return "Hello, " + member.getSurName();
	}
	
	
	
}
