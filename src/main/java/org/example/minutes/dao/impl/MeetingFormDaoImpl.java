package org.example.minutes.dao.impl;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.example.minutes.dao.DaoBase;
import org.example.minutes.dao.MeetingFormDao;
import org.example.minutes.entity.MeetingForm;

@Stateless
@LocalBean
public class MeetingFormDaoImpl extends DaoBase<MeetingForm> implements MeetingFormDao {

	public void insert(MeetingForm entity) {
		super.insert(entity);
	}
	
	public MeetingForm find(BigDecimal rid){
		EntityManager em = super.getEntityManager();
		return em.find(MeetingForm.class, rid);
	}
}
