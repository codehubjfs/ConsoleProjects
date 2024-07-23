package com.jobportal.bean;


public class Jobs {
	private int jobId;
	private int employerId;
	private String employerEmail;
	private String jobTitle;
	private String jobDescription;
	private String location;
	private String requiredSkills;
	private String jobType;
	private String experienceLevel;
	private String applicationDeadline;
	private int numberOfOpenings;
	private String companyName;
	private String Status;
	 public int getApplicationId() {
		return applicationId;
	}
	public String getEducationQualification() {
		return educationQualification;
	}
	public String getGender() {
		return gender;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public String getJobPosted() {
		return jobPosted;
	}
	public String getAddress() {
		return address;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", employerId=" + employerId + ", employerEmail=" + employerEmail
				+ ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", location=" + location
				+ ", requiredSkills=" + requiredSkills + ", jobType=" + jobType + ", experienceLevel=" + experienceLevel
				+ ", applicationDeadline=" + applicationDeadline + ", numberOfOpenings=" + numberOfOpenings
				+ ", companyName=" + companyName + ", Status=" + Status + ", applicationId=" + applicationId
				+ ", educationQualification=" + educationQualification + ", gender=" + gender + ", jobStatus="
				+ jobStatus + ", jobPosted=" + jobPosted + ", address=" + address + "]";
	}
	public void setJobPosted(String jobPosted) {
		this.jobPosted = jobPosted;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int applicationId;
	 private String educationQualification;
	 private String gender;
	 private String jobStatus;
	  private String jobPosted;
	  private String address;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Jobs() {
		
		
		
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	public String getEmployerEmail() {
		return employerEmail;
	}
	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public String getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(String applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}
	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
