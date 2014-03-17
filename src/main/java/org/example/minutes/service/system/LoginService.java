package org.example.minutes.service.system;

import javax.ejb.Local;

import org.example.minutes.entity.Member;

@Local
public interface LoginService {
	
	Member findMemberByLoginIdAndPassword(String loginId, String password);

}
