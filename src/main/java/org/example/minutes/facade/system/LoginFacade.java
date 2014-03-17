package org.example.minutes.facade.system;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.LoginDto;
import org.example.minutes.entity.Member;
import org.example.minutes.service.system.LoginService;


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
