package org.example.minutes.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.example.minutes.dao.DaoBase;
import org.example.minutes.dao.MeetingDao;
import org.example.minutes.entity.Meeting;

@Stateless
@LocalBean
public class MeetingDaoImpl extends DaoBase<Meeting> implements MeetingDao {

	public List<Meeting> findAll() {
		EntityManager em = super.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Meeting> query = builder.createQuery(Meeting.class);
		Root<Meeting> m = query.from(Meeting.class);
		query.select(m);
		@SuppressWarnings("unchecked")
		List<Meeting> meetingList = (List<Meeting>) findListByQuery(query);
		
		em.clear();
		return meetingList;
	}

	public Meeting find(Long rid) {
		EntityManager em = super.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Meeting> query = builder.createQuery(Meeting.class);
		Root<Meeting> m = query.from(Meeting.class);
		query.select(m).where(builder.equal(m.get("rid"), rid));
		
		Meeting meeting = (Meeting)findByQuery(query);
		em.clear();
		return meeting;
	}

	public void insert(Meeting entity) {
		super.insert(entity);
	}

}
