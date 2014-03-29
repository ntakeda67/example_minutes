package org.example.minutes.service;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.dto.MeetingDetailDto;

@Local
public interface MeetingService {
	List<MeetingDetailDto> findMeetingList();

	void registerMeeting(MeetingDetailDto dto);
}
