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
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	protected void insert(T entity){
		// FIXME リクエスト受信時刻にするか、systimestamp にする。
		// FIXME リクエストユーザを設定する・
		entity.setCreateDate(new Date());
		entity.setCreateUser("TEST");
		entity.setUpdateDate(new Date());
		entity.setUpdateUser("TEST");
		entity.setAvailable(true);
		em.persist(entity);
		
	}
	
	protected void update(T entity){
		entity.setUpdateDate(new Date());
		entity.setUpdateUser("TEST");
		// FIXME テストが必要
		if(em.contains(entity)){
			em.merge(entity);
		}
		
		em.merge(entity);
	}

}
