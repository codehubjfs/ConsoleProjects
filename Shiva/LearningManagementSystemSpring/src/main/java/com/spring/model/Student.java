package com.spring.model;

import java.time.LocalDate;

public class Student {
	private int studentId;
	private String firstname;
	private String lastname;
	private String department;
	private LocalDate dob;
	private String username;
	private String password;
	public Student()
	{
		
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public LocalDate getdob() {
		return dob;
	}
	public void setdob(LocalDate dob) {
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", department=" + department + ", dob=" + dob + ", username=" + username + ", password=" + password
				+ "]";
	}
	
}
