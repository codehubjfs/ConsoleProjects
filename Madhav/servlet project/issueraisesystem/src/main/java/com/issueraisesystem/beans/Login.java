package com.issueraisesystem.beans;

import java.io.Serializable;

public class Login implements Serializable{
	
	private String mailid;
	private String password;
	private String role;
	public Login() {
		super();
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
