package org.terash.meeting.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
@LocalBean
public class MeetingDao {
	
	@PersistenceContext(unitName = "meeting")
	private EntityManager em;
	
	public <T> Object findByQuery(CriteriaQuery<T> query) {
		
		Object o = null;
		
		try {
    	    o = em.createQuery(query).getSingleResult();
		} catch (NoResultException ne) {
			return null;
		}
		
		return o;
		
	}
	

}
