package com.letsbuy.beans;

import java.io.Serializable;

public class Account implements Serializable{
	private String userName;
	private String password;
	private String accountType;
	private String accountStatus;
	
	public Account() {
		
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
}
