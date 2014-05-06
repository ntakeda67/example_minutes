package org.example.minutes.dto.meeting;

import java.util.Date;

public class RegisterMinutesRequestDto {

	private String purpose;
	private Date startDate;
	private Date endDate;
	private String place;
	private String decision;
	private String todo;
	private Date nextStartDate;
	private String nextPlace;
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getNextStartDate() {
		return nextStartDate;
	}
	public void setNextStartDate(Date nextStartDate) {
		this.nextStartDate = nextStartDate;
	}
	public String getNextPlace() {
		return nextPlace;
	}
	public void setNextPlace(String nextPlace) {
		this.nextPlace = nextPlace;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
}
