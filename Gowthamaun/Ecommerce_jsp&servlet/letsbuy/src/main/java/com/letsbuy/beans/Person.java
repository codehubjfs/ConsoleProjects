package com.letsbuy.beans;

import java.io.Serializable;

public class Person implements Serializable{
	
	private String address;
	private String email;
	private long mobileNumber;
	
	public Person() {
		
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
}
