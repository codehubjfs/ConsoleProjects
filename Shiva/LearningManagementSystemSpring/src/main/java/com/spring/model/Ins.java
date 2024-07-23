package com.spring.model;

import java.time.LocalDate;

public class Ins {
	private int insid;
	private String firstname;
	private String lastname;
	private String department;
	private LocalDate dob;
	private String username;
	private String password;
	public Ins() {
		super();
	}
	public int getInsid() {
		return insid;
	}
	public void setInsid(int insid) {
		this.insid = insid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
