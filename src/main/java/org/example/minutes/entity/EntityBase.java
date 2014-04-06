package org.example.minutes.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EntityBase {
	private BigDecimal rid;
	private boolean available;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private String comments;
	
	protected void setBaseColumnsValue(BigDecimal rid, boolean available, Date createDate, String createUser, 
			Date updateDate, String updateUser){
		this.rid = rid;
		this.available = available;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}
	
	protected void setBaseColumnsValue(BigDecimal rid, boolean available, Date createDate, String createUser, 
			Date updateDate, String updateUser, String comments){
		
		this.comments = comments;
		setBaseColumnsValue(rid, available, createDate, createUser,
				updateDate, updateUser);
	}
	public BigDecimal getRid() {
		return rid;
	}

	public void setRid(BigDecimal rid) {
		this.rid = rid;
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

/**	
	@PreUpdate
	public void onUpdate(){
		// FIXME リクエスト受信時刻にするか、systimestamp にする。
		// FIXME リクエストユーザを設定する・

		this.updateDate = new Date();
		this.updateUser = "TEST";
	}
	
	@PrePersist
	public void onInsert(){
		onUpdate();
		this.createDate = this.updateDate;
		this.createUser = this.updateUser;
		this.available = true;
	}
*/
}
