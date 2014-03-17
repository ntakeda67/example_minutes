package org.example.minutes.dao.system;

import javax.ejb.Local;

import org.example.minutes.entity.Member;

@Local
public interface MemberDao {
	
	Member findMemberByLoginIdAndPassword(String loginId, String password);
}
