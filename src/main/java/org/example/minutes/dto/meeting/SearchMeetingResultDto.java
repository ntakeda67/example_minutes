package org.example.minutes.dto.meeting;

import java.util.Date;

public class SearchMeetingResultDto {

	private String rid;
	private String purpose;
	private String startDate;
	private String place;
	
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
}
