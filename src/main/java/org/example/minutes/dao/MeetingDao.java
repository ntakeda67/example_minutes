package org.example.minutes.dao;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.Meeting;

@Local
public interface MeetingDao {
	List<Meeting> findAll();

	Meeting find(Long rid);
	
	void insert(Meeting entity);
}
