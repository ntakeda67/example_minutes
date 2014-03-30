package org.example.minutes.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.example.minutes.dao.DaoBase;
import org.example.minutes.dao.MeetingTypeDao;
import org.example.minutes.entity.MeetingType;

@Stateless
@LocalBean
public class MeetingTypeDaoImpl extends DaoBase<MeetingType> implements MeetingTypeDao {

	public List<MeetingType> findAll() {
		EntityManager em = super.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MeetingType> query = builder.createQuery(MeetingType.class);
		Root<MeetingType> m = query.from(MeetingType.class);
		query.select(m);
		@SuppressWarnings("unchecked")
		List<MeetingType> meetingList = (List<MeetingType>) findListByQuery(query);
		
		em.clear();
		return meetingList;
	}

	public MeetingType find(BigDecimal rid) {
		EntityManager em = super.getEntityManager();
		return em.find(MeetingType.class, rid);
	}

}
