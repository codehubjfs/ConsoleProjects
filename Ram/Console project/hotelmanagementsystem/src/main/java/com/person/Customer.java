package com.person;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private  int customer_id;
	private String fName;
	private String lName;
	private  String email;
	private long phoneNo;
	private String address;
//	private String username;
	private String password;
//	private List<Customer> hs=new ArrayList<>();
	public Customer(int customer_id,String fName, String lName, String email, long phoneNo, String address,
			 String password) {
		super();
		this.customer_id=customer_id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		
		this.password = password;
	}
	
	
	public Customer(int customerId, String firstName, String email2, String email3) {
		
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public  int getCustomer_id() {
		return customer_id;
	}


	public  void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public  String getEmail() {
		return email;
	}


	public  void setEmail(String email) {
		this.email = email;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

}
