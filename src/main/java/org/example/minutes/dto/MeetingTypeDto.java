package org.example.minutes.dto;

import java.math.BigDecimal;

public class MeetingTypeDto {
	private BigDecimal rid;
	private String name;
	public BigDecimal getRid() {
		return rid;
	}
	public void setRid(BigDecimal rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
