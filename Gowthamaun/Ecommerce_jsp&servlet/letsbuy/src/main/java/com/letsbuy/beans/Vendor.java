package com.letsbuy.beans;

import java.io.Serializable;

public class Vendor extends Person implements Serializable{
	private int vendorId;
	private String registeredNumber;
	private Account account;
	private long aadharNumber;
	
	
	
	public Vendor() {
		super();
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getRegisteredNumber() {
		return registeredNumber;
	}
	public void setRegisteredNumber(String registeredNumber) {
		this.registeredNumber = registeredNumber;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	
}
