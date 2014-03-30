package org.example.minutes.entity;

import java.util.Date;

public class EntityBase {
	private boolean available;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String comments;
	
	protected void setBaseColumnsValue(boolean available, Date createDate, String createUser, 
			Date updateDate, String updateUser){
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}
	
	protected void setBaseColumnsValue(boolean available, Date createDate, String createUser, 
			Date updateDate, String updateUser, String comments){
		
		this.comments = comments;
		setBaseColumnsValue(available, createDate, createUser,
				updateDate, updateUser);
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
