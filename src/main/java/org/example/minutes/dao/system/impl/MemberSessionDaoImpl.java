package org.example.minutes.dao.system.impl;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.example.minutes.dao.DaoBase;
import org.example.minutes.dao.system.MemberSessionDao;
import org.example.minutes.entity.MemberSession;

@Stateless
@LocalBean
public class MemberSessionDaoImpl extends DaoBase<MemberSession> implements MemberSessionDao {

	@PersistenceContext(unitName = "meeting")
	private EntityManager em;

	public MemberSession findMemberSessionByTicketId(String ticketId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MemberSession> query = builder.createQuery(MemberSession.class);
		Root<MemberSession> m = query.from(MemberSession.class);
		query.select(m).where(builder.equal(m.get("ticketId"), ticketId));

		MemberSession memberSession = (MemberSession)findByQuery(query);

		return memberSession;
	}

	public MemberSession findMemberSessionByTicketIdOnlyIsValid(String ticketId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MemberSession> query = builder.createQuery(MemberSession.class);
		Root<MemberSession> m = query.from(MemberSession.class);
		query.select(m).where(builder.equal(m.get("ticketId"), ticketId), builder.greaterThan(m.<Date>get("expirationDate"), new Date()));

		MemberSession memberSession = (MemberSession)findByQuery(query);

		return memberSession;
	}

	public void insert(MemberSession memberSession) {
		super.insert(memberSession);
	}

}
