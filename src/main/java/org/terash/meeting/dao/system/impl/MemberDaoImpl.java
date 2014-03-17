package org.terash.meeting.dao.system.impl;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.terash.meeting.dao.MeetingDao;
import org.terash.meeting.dao.system.MemberDao;
import org.terash.meeting.entity.Member;

@Stateless
@LocalBean
public class MemberDaoImpl extends MeetingDao implements MemberDao  {

	@PersistenceContext(unitName = "meeting")
	private EntityManager em;
	
	public Member findMemberByLoginIdAndPassword(String loginId, String password) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Member> query = builder.createQuery(Member.class);
		Root<Member> m = query.from(Member.class);
		query.select(m).where(builder.equal(m.get("loginId"), loginId),
				builder.equal(m.get("password"), password));
		
		Member member = (Member)findByQuery(query);
		em.clear();
		return member;
	}
	
}

