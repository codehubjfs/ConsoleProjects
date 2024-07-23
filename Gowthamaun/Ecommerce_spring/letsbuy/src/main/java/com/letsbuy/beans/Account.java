package com.letsbuy.beans;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private String userName;
	private String password;
	private String accountType;
	private String accountStatus;
	
	public Account() {
		
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + "]";
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
