package org.example.minutes.service;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.dto.MeetingTypeDto;

@Local
public interface MeetingTypeService {
	List<MeetingTypeDto> findMeetingTypeList();
}
