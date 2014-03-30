package org.example.minutes.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.MeetingType;

@Local
public interface MeetingTypeDao {
	List<MeetingType> findAll();
	MeetingType find(BigDecimal rid);
}
