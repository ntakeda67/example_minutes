package org.example.minutes.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "loginDto")
public class LoginDto {

	private String loginId;
	private String password;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
