package org.terash.meeting.entity;

// Generated 2014/02/17 1:32:41 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * MemberType generated by hbm2java
 */
public class MemberType implements java.io.Serializable {

	private BigDecimal rid;
	private String type;
	private String name;
	private boolean available;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String comments;

	public MemberType() {
	}

	public MemberType(BigDecimal rid, String type, String name,
			boolean available, Date createDate, String createUser,
			Date updateDate, String updateUser) {
		this.rid = rid;
		this.type = type;
		this.name = name;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public MemberType(BigDecimal rid, String type, String name,
			boolean available, Date createDate, String createUser,
			Date updateDate, String updateUser, String comments) {
		this.rid = rid;
		this.type = type;
		this.name = name;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

}
