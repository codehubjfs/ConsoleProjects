package com.person;

public class Receptionist {
	private String name;
	private int employee_id;
	private String password;
	private String email;
	private long phone_no;
	
	public Receptionist() {
		
	}
	
	public Receptionist(String name, int employee_id, String password, String email, long phone_no) {
		super();
		this.name = name;
		this.employee_id = employee_id;
		this.password = password;
		this.email = email;
		this.phone_no = phone_no;
	}
	
	public Receptionist(String email2, String password2, String name2, long phoneNumber) {
		this.email=email2;
		this.password=password2;
		this.name=name2;
		this.phone_no=phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	
	 @Override
	    public String toString() {
	        return String.format("| %-15s | %-14s | %-11d | %-12s | %-12s |",
	                email, name, employee_id, password, phone_no);
	    }

}
