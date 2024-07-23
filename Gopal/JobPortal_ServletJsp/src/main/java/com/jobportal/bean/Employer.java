package com.jobportal.bean;




public class Employer {
	
	private String name;
	private String email;
	private String password;
	private String companyName;
	private String number;
	private String gender;
	private String address;
	private String state;
	private String district;
	private String registerdate;
	private long pincode;
	private String aboutCompany;
	private  int emp_id;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Employer() {
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employer [name=" + name + ", email=" + email + ", password=" + password + ", companyName=" + companyName
				+ ", number=" + number + ", gender=" + gender + ", address=" + address + ", state=" + state
				+ ", district=" + district + ", registerdate=" + registerdate + ", pincode=" + pincode
				+ ", aboutCompany=" + aboutCompany + ", emp_id=" + emp_id + ", status=" + status + "]";
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String string) {
		this.number = string;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getAboutCompany() {
		return aboutCompany;
	}
	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	

}
