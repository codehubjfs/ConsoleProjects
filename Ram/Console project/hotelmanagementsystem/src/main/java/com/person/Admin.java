package com.person;

public class Admin {
	private int admin_id ;
	private String username;
	private String password;
	private String email;
	private String phone_no;
	public Admin(int admin_id, String username, String password, String email, String phone_no) {
		super();
		this.admin_id = admin_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_no = phone_no;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	

}
