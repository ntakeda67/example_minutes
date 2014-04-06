package org.example.minutes.facade.system;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.LoginDto;
import org.example.minutes.entity.Member;
import org.example.minutes.entity.MemberSession;
import org.example.minutes.service.system.LoginService;


@Path("/doLogin")
public class LoginFacade {

	@EJB
	private LoginService loginService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String doLogin(LoginDto loginDto) {

		Member member = loginService.findMemberByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());
		if (member == null) {
			//TODO エラー　エラークラス、エラーメッセージ定義クラスなど共通実装後
			return new RuntimeException("ログインIDまたはパスワードが不正です").getMessage();
		}

		MemberSession memberSession = loginService.registerMemberSession(member);

		return memberSession.getTicketId();
	}

}
