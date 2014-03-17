package org.terash.meeting.service.system;

import javax.ejb.Local;

import org.terash.meeting.entity.Member;

@Local
public interface LoginService {
	
	Member findMemberByLoginIdAndPassword(String loginId, String password);

}
