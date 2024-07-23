package com.letsbuy.beans;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	private int adminId;
	private String userName;
	private String password;
	
	public Admin() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getPassowrd() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
