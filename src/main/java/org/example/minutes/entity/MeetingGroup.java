package org.example.minutes.entity;

// Generated 2014/02/17 1:32:41 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MeetingGroup generated by hbm2java
 */
public class MeetingGroup implements java.io.Serializable {

	private BigDecimal rid;
	private String code;
	private String name;
	private boolean available;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String comments;
	private Set meetingGroupMembers = new HashSet(0);

	public MeetingGroup() {
	}

	public MeetingGroup(BigDecimal rid, String code, String name,
			boolean available, Date createDate, String createUser,
			Date updateDate, String updateUser) {
		this.rid = rid;
		this.code = code;
		this.name = name;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public MeetingGroup(BigDecimal rid, String code, String name,
			boolean available, Date createDate, String createUser,
			Date updateDate, String updateUser, String comments,
			Set meetingGroupMembers) {
		this.rid = rid;
		this.code = code;
		this.name = name;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.comments = comments;
		this.meetingGroupMembers = meetingGroupMembers;
	}

	public BigDecimal getRid() {
		return this.rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getMeetingGroupMembers() {
		return this.meetingGroupMembers;
	}

	public void setMeetingGroupMembers(Set meetingGroupMembers) {
		this.meetingGroupMembers = meetingGroupMembers;
	}

}