package org.example.minutes.facade.system;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.AuthenticationDto;
import org.example.minutes.entity.MemberSession;
import org.example.minutes.service.system.LoginService;


@Path("/doLogout")
public class LogoutFacade {

	@EJB
	private LoginService loginService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void doLogout(AuthenticationDto authenticationDto) {

		MemberSession memberSession = loginService.findMemberSessionByTicketId(authenticationDto.getTicketId());
		if (memberSession != null) {
			loginService.deleteMemberSession(memberSession);
		}
	}

}
