package org.terash.meeting.dao.system;

import javax.ejb.Local;

import org.terash.meeting.entity.Member;

@Local
public interface MemberDao {
	
	Member findMemberByLoginIdAndPassword(String loginId, String password);
}
