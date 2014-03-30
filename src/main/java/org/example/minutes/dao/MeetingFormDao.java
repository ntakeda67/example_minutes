package org.example.minutes.dao;

import java.math.BigDecimal;

import javax.ejb.Local;

import org.example.minutes.entity.MeetingForm;

@Local
public interface MeetingFormDao {
	void insert(MeetingForm entity);
	MeetingForm find(BigDecimal rid);
}
