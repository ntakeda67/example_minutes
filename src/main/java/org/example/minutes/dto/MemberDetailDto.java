package org.example.minutes.dto;

import java.math.BigDecimal;

public class MemberDetailDto {
	private BigDecimal rid;
	private String surName;
	private String firstName;
	private String mailAddress;
	private String loginId;
	private String comments;
	Long updateDate;
	public BigDecimal getRid() {
		return rid;
	}
	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Long updateDate) {
		this.updateDate = updateDate;
	}
}
