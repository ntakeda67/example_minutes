package org.example.minutes.service.meeting;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.dto.meeting.SearchMeetingResultDto;

@Local
public interface SearchMeetingService {

	List<SearchMeetingResultDto> searchMeetingList(String loginId);
	
	
}
