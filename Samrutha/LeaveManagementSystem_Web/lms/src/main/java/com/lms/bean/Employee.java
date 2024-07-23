package com.lms.bean;

import java.time.LocalDate;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private Department dept;
	private int managerId;
	private LocalDate joinDate;
	private int salaray;
	private Gender gender;
	private Role role;
	private Status status;
	private String userName;
	private String password;
	
	//default constructor
	public Employee() {
		super();
	}

	//Getters and Setters
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public int getSalaray() {
		return salaray;
	}

	public void setSalaray(int salaray) {
		this.salaray = salaray;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	public Role mapToEnum(String value) {
        if ("EMPLOYEE".equalsIgnoreCase(value)) {
            return Role.EMPLOYEE;
        } 
        else if ("MANAGER".equalsIgnoreCase(value)) {
        	return Role.MANAGER;
        }
        else if ("HR".equalsIgnoreCase(value)){
        	return Role.HR;
        }
        else {
        	return Role.ADMIN;
        }
    }
	
	public Status mapToStatus(String value) {
        if ("ACTIVE".equalsIgnoreCase(value)) {
            return Status.ACTIVE;
        } 
        else {
        	return Status.INACTIVE;
        }
    }
	
	public Gender mapToGender(String value) {
		if("MALE".equalsIgnoreCase(value)) {
			return Gender.MALE;
		}
		else {
			return Gender.FEMALE;
		}
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dept=" + dept + ", managerId=" + managerId + ", joinDate=" + joinDate + ", salaray=" + salaray
				+ ", gender=" + gender + ", role=" + role + ", status=" + status + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
}
