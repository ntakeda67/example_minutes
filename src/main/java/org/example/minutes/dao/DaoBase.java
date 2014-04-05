package org.example.minutes.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.example.minutes.entity.EntityBase;

@Stateless
@LocalBean
public class DaoBase<T extends EntityBase> {
	@PersistenceContext(unitName = "meeting")
	private EntityManager em;
	
	protected static final LockModeType lockMode = LockModeType.PESSIMISTIC_READ;
	
	public DaoBase(){}
	public Object findByQuery(CriteriaQuery<T> query) {

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

	public void insert(T entity) {
		entity.setCreateDate(new Date());
		entity.setCreateUser("SYSTEM");
		entity.setUpdateDate(new Date());
		entity.setUpdateUser("SYSTEM");
		entity.setAvailable(true);
		em.persist(entity);
	}

	public void update(T entity) {
		entity.setUpdateDate(new Date());
		entity.setUpdateUser("SYSTEM");
		em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	protected EntityManager getEntityManager(){
		return em;
	}
}
