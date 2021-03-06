package org.example.minutes.entity;

// Generated 2014/02/17 1:32:41 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * Minutes generated by hbm2java
 */
public class Minutes implements java.io.Serializable {

	private BigDecimal rid;
	private Meeting meeting;
	private String purpose;
	private Date startDate;
	private Date endDate;
	private String place;
	private String decision;
	private String todo;
	private Date nextStartDate;
	private String nextPlace;
	private Date registerDate;
	private Date modifyDate;
	private boolean available;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String comments;

	public Minutes() {
	}

	public Minutes(BigDecimal rid, Meeting meeting, String purpose,
			Date startDate, Date endDate, String place, String decision,
			String todo, Date registerDate, boolean available, Date createDate,
			String createUser, Date updateDate, String updateUser) {
		this.rid = rid;
		this.meeting = meeting;
		this.purpose = purpose;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.decision = decision;
		this.todo = todo;
		this.registerDate = registerDate;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public Minutes(BigDecimal rid, Meeting meeting, String purpose,
			Date startDate, Date endDate, String place, String decision,
			String todo, Date nextStartDate, String nextPlace,
			Date registerDate, Date modifyDate, boolean available,
			Date createDate, String createUser, Date updateDate,
			String updateUser, String comments) {
		this.rid = rid;
		this.meeting = meeting;
		this.purpose = purpose;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.decision = decision;
		this.todo = todo;
		this.nextStartDate = nextStartDate;
		this.nextPlace = nextPlace;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.comments = comments;
	}

	public BigDecimal getRid() {
		return this.rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}

	public Meeting getMeeting() {
		return this.meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDecision() {
		return this.decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getTodo() {
		return this.todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Date getNextStartDate() {
		return this.nextStartDate;
	}

	public void setNextStartDate(Date nextStartDate) {
		this.nextStartDate = nextStartDate;
	}

	public String getNextPlace() {
		return this.nextPlace;
	}

	public void setNextPlace(String nextPlace) {
		this.nextPlace = nextPlace;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
