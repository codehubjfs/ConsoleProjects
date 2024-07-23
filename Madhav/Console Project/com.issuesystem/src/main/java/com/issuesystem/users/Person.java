package com.issuesystem.users;

public class Person {
	
	private String username;
	private String password;
	private String name;
	private String role;
	private int superid;
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

	public int getSuperid() {
		return superid;
	}

	public void setSuperid(int superid) {
		this.superid = superid;
	}

	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Person(String name, String role,int superid) {
		super();
		this.name = name;
		this.role = role;
		this.superid=superid;
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
