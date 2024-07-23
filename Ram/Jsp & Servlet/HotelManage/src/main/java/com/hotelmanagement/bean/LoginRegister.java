package com.hotelmanagement.bean;

import java.io.Serializable;

public class LoginRegister implements Serializable {
	
	 private String firstName;
	    private String lastName;
	    private String email;
	    private long phoneNo;
	    private String address;
	    private String password;
	    private int age;
	    private String state;
	    private String gender;
	    // Getters and Setters
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
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
