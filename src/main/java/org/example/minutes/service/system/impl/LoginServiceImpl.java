package org.example.minutes.service.system.impl;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.minutes.dao.system.MemberDao;
import org.example.minutes.dao.system.MemberSessionDao;
import org.example.minutes.entity.Member;
import org.example.minutes.entity.MemberSession;
import org.example.minutes.service.system.LoginService;

@Stateless
@LocalBean
public class LoginServiceImpl implements LoginService {

	@EJB
	private MemberDao memberDao;

	@EJB
	private MemberSessionDao memberSessionDao;

	public Member findMemberByLoginIdAndPassword(String loginId, String password) {
		return memberDao.findMemberByLoginIdAndPassword(loginId, password);
	}

	public MemberSession registerMemberSession(Member member) {
		MemberSession memberSession = new MemberSession();
		memberSession.setMember(member);

		StringBuilder ticketId = new StringBuilder();
		ticketId.append(member.getLoginId());
		ticketId.append("_");
		ticketId.append(new Date().getTime());
		ticketId.append("_");
		ticketId.append(RandomStringUtils.randomAlphanumeric(64));
		memberSession.setTicketId(ticketId.toString());

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 60);
		memberSession.setExpirationDate(calendar.getTime());

		memberSessionDao.insert(memberSession);

		return memberSession;
	}

	public void doLogout(String ticketId) {
		MemberSession memberSession = memberSessionDao.findMemberSessionByTicketId(ticketId);
		if(memberSession == null){
			return;
		}
		memberSessionDao.delete(memberSession);
	}

}
