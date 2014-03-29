package org.example.minutes.facade.meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.example.minutes.dto.meeting.SearchMeetingListDto;
import org.example.minutes.dto.meeting.SearchMeetingResultDto;

@Path("/searchMeetingList")
public class SearchMeetingFacade {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SearchMeetingResultDto> searchMeetingList(SearchMeetingListDto searchMeetingListDto) {
	
		List<SearchMeetingResultDto> resultDtoList = new ArrayList<SearchMeetingResultDto>();
		
		SearchMeetingResultDto resultDto = new SearchMeetingResultDto();
		
		resultDto.setRid("1");
		resultDto.setPurpose("目的1");
		resultDto.setPlace("場所1");
		resultDto.setStartDate("2014/04/05 15:00");
		
		resultDtoList.add(resultDto);
		
        resultDto = new SearchMeetingResultDto();
		
		resultDto.setRid("2");
		resultDto.setPurpose("目的2");
		resultDto.setPlace("場所2");
		resultDto.setStartDate("2014/04/05 16:00");
		
		resultDtoList.add(resultDto);
		
		return resultDtoList;
	}
	
	
}
