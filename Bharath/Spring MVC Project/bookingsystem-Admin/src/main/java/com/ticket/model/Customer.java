package com.ticket.model;

public class Customer {
	  private int customer_Id;
		private String firstName;
	    private String lastName;
	    private String gender;
	    private String email;
	    private String username;
	    private String password;
	    private String status;
	    private String phoneNumber;
	    private String Available;
	    public Customer() {
			
		}
		
		public int getCustomer_Id() {
			return customer_Id;
		}

		public void setCustomer_Id(int customer_Id) {
			this.customer_Id = customer_Id;
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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAvailable() {
			return Available;
		}
		public void setAvailable(String available) {
			Available = available;
		}
}
	    
	    