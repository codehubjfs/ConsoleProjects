package com.issueraisesystem.beans;

public class WardenDetails {
	
	private int wardenid;
	private String mailid;
	private String password;
	
	private String name;
	private String role;
	
	public WardenDetails() {
		
	}

	public int getWardenid() {
		return wardenid;
	}

	public void setWardenid(int wardenid) {
		this.wardenid = wardenid;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
