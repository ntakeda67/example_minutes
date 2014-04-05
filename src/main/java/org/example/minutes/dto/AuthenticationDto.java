package org.example.minutes.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "authenticationDto")
public class AuthenticationDto {

	private String ticketId;

	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
