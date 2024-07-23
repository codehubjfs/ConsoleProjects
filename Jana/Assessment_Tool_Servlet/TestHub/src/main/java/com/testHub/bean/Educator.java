package com.testHub.bean;

public class Educator {
	
	private int eid;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private String gender;
	private String city;
	private String country;
	
	public Educator() {
		
	}
	
	public Educator(int eid, String email, String password, String fname, String lname, String city,
			String country, String gender) {
		// TODO Auto-generated constructor stub
		this.eid = eid;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.country = country;
		this.gender = gender;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
