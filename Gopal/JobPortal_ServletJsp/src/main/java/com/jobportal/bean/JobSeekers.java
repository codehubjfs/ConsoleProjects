package com.jobportal.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JobSeekers {
  private String name;
  private String email;
  private String password;
  private String objective;
private String companyName;


  public String getCompanyName() {
	return companyName;
}
private String additionalQualification;
  private long experience;
  private String technicalSkills;
private String phone ;
private String resumeFileName;
public String getResumeFileName() {
	return resumeFileName;
}
public void setResumeFileName(String resumeFileName) {
	this.resumeFileName = resumeFileName;
}
private String dob;
private String state;
private String district;
private String pincode;
private String Address;
private String gender;
private String shortProfile;
private String education;
private String course;
private int seeker_id;
private int job_id;
private String eduQualification;


private String specialization;
private String passingYear;
private String institute;
private String cgpa;

private String status;
private String courseType;

//Experience Information
private String yearsExperience;
private String designation;

//Languages Known
private String language;
private String proficiencyRead;
private String proficiencyWrite;
private String proficiencySpeak;

//Certification Information
private String certification;
private String certificationYear;
private String certificationInstitute;

	
	
  public String getObjective() {
	return objective;
}
public void setObjective(String objective) {
	this.objective = objective;
}




  public int getJob_id() {
	return job_id;
}
public void setJob_id(int job_id) {
	this.job_id = job_id;
}
public JobSeekers() {
	  
	  
	  
  }
  public int getSeeker_id() {
	return seeker_id;
}
public void setSeeker_id(int seeker_id) {
	this.seeker_id = seeker_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getShortProfile() {
	return shortProfile;
}
public void setShortProfile(String shortProfile) {
	this.shortProfile = shortProfile;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
public String getPassingYear() {
	return passingYear;
}
public void setPassingYear(String passingYear) {
	this.passingYear = passingYear;
}
public String getCgpa() {
	return cgpa;
}
public void setCgpa(String cgpa) {
	this.cgpa = cgpa;
}
public String getAdditionalQualification() {
	return additionalQualification;
}
public void setAdditionalQualification(String additionalQualification) {
	this.additionalQualification = additionalQualification;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public long getExperience() {
	return experience;
}
public void setExperience(long experience) {
	this.experience = experience;
}
public String getTechnicalSkills() {
	return technicalSkills;
}
public void setTechnicalSkills(String technicalSkills) {
	this.technicalSkills = technicalSkills;
}

private byte[] resume;

// Other getters and setters...

public byte[] getResume() {
    return resume;
}

public void setResume(byte[] resume) {
    this.resume = resume;
}

public InputStream getResumeInputStream() {
    return new ByteArrayInputStream(resume);
}



// Education Information

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getEduQualification() {
	return eduQualification;
}
public void setEduQualification(String eduQualification) {
	this.eduQualification = eduQualification;
}
public String getInstitute() {
	return institute;
}
public void setInstitute(String institute) {
	this.institute = institute;
}
public String getCourseType() {
	return courseType;
}
public void setCourseType(String courseType) {
	this.courseType = courseType;
}
public String getYearsExperience() {
	return yearsExperience;
}
public void setYearsExperience(String yearsExperience) {
	this.yearsExperience = yearsExperience;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getProficiencyRead() {
	return proficiencyRead;
}
public void setProficiencyRead(String proficiencyRead) {
	this.proficiencyRead = proficiencyRead;
}
public String getProficiencyWrite() {
	return proficiencyWrite;
}
public void setProficiencyWrite(String proficiencyWrite) {
	this.proficiencyWrite = proficiencyWrite;
}
public String getProficiencySpeak() {
	return proficiencySpeak;
}
public void setProficiencySpeak(String proficiencySpeak) {
	this.proficiencySpeak = proficiencySpeak;
}
public String getCertification() {
	return certification;
}
public void setCertification(String certification) {
	this.certification = certification;
}
public String getCertificationYear() {
	return certificationYear;
}
public void setCertificationYear(String certificationYear) {
	this.certificationYear = certificationYear;
}
public String getCertificationInstitute() {
	return certificationInstitute;
}
public void setCertificationInstitute(String certificationInstitute) {
	this.certificationInstitute = certificationInstitute;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}





}
