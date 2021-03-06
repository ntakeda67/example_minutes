package org.example.minutes.entity;

// Generated 2014/02/17 1:32:41 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

/**
 * MemberSession generated by hbm2java
 */
public class MemberSession extends EntityBase implements java.io.Serializable {

	private Member member;
	private String ticketId;
	private Date expirationDate;

	public MemberSession() {
	}

	public MemberSession(BigDecimal rid, Member member, String ticketId,
			Date expirationDate, boolean available, Date createDate,
			String createUser, Date updateDate, String updateUser) {
		this.member = member;
		this.ticketId = ticketId;
		this.expirationDate = expirationDate;
		setBaseColumnsValue(rid, available, createDate, createUser,
				updateDate, updateUser);
	}

	public MemberSession(BigDecimal rid, Member member, String ticketId,
			Date expirationDate, boolean available, Date createDate,
			String createUser, Date updateDate, String updateUser, String comments) {
		this.member = member;
		this.ticketId = ticketId;
		this.expirationDate = expirationDate;
		setBaseColumnsValue(rid, available, createDate, createUser,
				updateDate, updateUser);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
