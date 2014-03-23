package org.example.minutes.service;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.Meeting;

@Local
public interface MeetingService {
	List<Meeting> findMeetingList();
}
