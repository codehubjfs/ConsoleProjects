package com.letsbuy.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Login implements Serializable {
	private long mobileNumber;
	
	private String password;
	
	public Login() {
		
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
