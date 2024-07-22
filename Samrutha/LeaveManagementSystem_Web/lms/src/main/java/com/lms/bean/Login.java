package com.lms.bean;

public class Login {
	private String username;
	private String password;
	private Role userType;
	
	
	//Default Constructor
	public Login() {
		super();
	}


	//Getters and Setters
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


	public Role getUserType() {
		return userType;
	}


	public void setUserType(Role userType) {
		this.userType = userType;
	}
	
	
	//Map to Enum
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
}
