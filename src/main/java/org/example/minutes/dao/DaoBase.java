package org.example.minutes.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
@LocalBean
public class DaoBase {
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
	
	public List<?> findListByQuery(CriteriaQuery<?> query) {
		List<?> o = null;

		o = em.createQuery(query).getResultList();

		return o;
	}
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	protected <T> void insert(T entity){
		em.persist(entity);
	}
}
