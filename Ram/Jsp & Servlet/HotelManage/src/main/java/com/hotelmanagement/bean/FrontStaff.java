package com.hotelmanagement.bean;

import java.io.Serializable;

public class FrontStaff implements Serializable {
	 private String name;
	    private int employeeId;
	    private String password;
	    private String email;
	    private String phoneNo;
	    
	    
	    public FrontStaff() {
	    }


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getEmployeeId() {
			return employeeId;
		}


		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
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


		public String getPhoneNo() {
			return phoneNo;
		}


		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}


		@Override
		public String toString() {
			return "FrontStaff [name=" + name + ", employeeId=" + employeeId + ", password=" + password + ", email="
					+ email + ", phoneNo=" + phoneNo + "]";
		}

		
}
