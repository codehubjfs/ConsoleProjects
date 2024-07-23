package com.persondetails;

//  The Person class represents a personal details such as first name, last name, username, password, email, phone number, and gender.
public class Person {
		String firstName;
		String lastName;
		String userName;
		String password;
		String email;
		String phoneNumber;
		String gender;

		public Person(String firstName, String lastName, String userName, String password, String email, String phoneNumber,
				String gender) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.gender = gender;
		}
		
		public Person(String firstName, String lastName, String userName, String password, String email, String phoneNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
			//this.gender = gender;
		}
		public Person(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}
		public Person() {
			
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="+ password + ", Email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
	}
}


