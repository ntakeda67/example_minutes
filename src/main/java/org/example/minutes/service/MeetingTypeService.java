package org.example.minutes.service;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.MeetingType;

@Local
public interface MeetingTypeService {
	List<MeetingType> findMeetingTypeList();
}
