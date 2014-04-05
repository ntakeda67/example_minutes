package org.example.minutes.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.Meeting;

@Local
public interface MeetingDao {
	List<Meeting> findAll();

	Meeting find(BigDecimal rid);
	
	Meeting findLock(BigDecimal rid);
	
	void insert(Meeting entity);
	
	void update(Meeting entity);
}
