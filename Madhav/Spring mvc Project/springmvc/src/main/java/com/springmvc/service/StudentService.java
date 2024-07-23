package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Student;

public interface StudentService {
	
	List<Student> getStudent();
	List<Student> getProfile(String mailid);
	boolean editProfile(Student student);

}
