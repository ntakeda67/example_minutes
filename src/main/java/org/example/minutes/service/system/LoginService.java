package org.example.minutes.service.system;

import javax.ejb.Local;

import org.example.minutes.entity.Member;
import org.example.minutes.entity.MemberSession;

@Local
public interface LoginService {

	Member findMemberByLoginIdAndPassword(String loginId, String password);

	MemberSession registerMemberSession(Member member);

	MemberSession findMemberSessionByTicketId(String ticketId);

	MemberSession findMemberSessionByTicketIdOnlyIsValid(String ticketId);

	void deleteMemberSession(MemberSession memberSession);
}
