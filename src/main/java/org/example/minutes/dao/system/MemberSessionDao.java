package org.example.minutes.dao.system;

import javax.ejb.Local;

import org.example.minutes.entity.MemberSession;

@Local
public interface MemberSessionDao {

	void insert(MemberSession memberSession);

	MemberSession findMemberSessionByTicketId(String ticketId);

	MemberSession findMemberSessionByTicketIdOnlyIsValid(String ticketId);

	void delete(MemberSession memberSession);

}
