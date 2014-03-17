package org.example.minutes.service.system.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.system.MemberDao;
import org.example.minutes.entity.Member;
import org.example.minutes.service.system.LoginService;

@Stateless
@LocalBean
public class LoginServiceImpl implements LoginService {

	@EJB
	private MemberDao memberDao;

	public Member findMemberByLoginIdAndPassword(String loginId, String password) {
		return memberDao.findMemberByLoginIdAndPassword(loginId, password);
	}

}
