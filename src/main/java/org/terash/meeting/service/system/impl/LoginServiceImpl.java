package org.terash.meeting.service.system.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.terash.meeting.dao.system.MemberDao;
import org.terash.meeting.entity.Member;
import org.terash.meeting.service.system.LoginService;

@Stateless
@LocalBean
public class LoginServiceImpl implements LoginService {

	@EJB
	private MemberDao memberDao;

	public Member findMemberByLoginIdAndPassword(String loginId, String password) {
		return memberDao.findMemberByLoginIdAndPassword(loginId, password);
	}

}
