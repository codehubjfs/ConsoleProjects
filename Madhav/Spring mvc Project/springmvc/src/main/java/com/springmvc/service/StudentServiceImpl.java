package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.StudentMapper;
import com.springmvc.model.Student;


@Service
public class StudentServiceImpl implements StudentService{
	



		@Autowired
		StudentMapper studentMapper;
		
		@Autowired
		Student student;
		
		
		@Override
		public List<Student> getStudent() {
			
			List<Student> student = studentMapper.getStudent(); 
			return student;
	
	
		}
		public List<Student>getProfile(String maildid){
			List<Student>profile=studentMapper.getProfile(maildid);
			return profile;
		}
		
		public boolean editProfile(Student student) {
			boolean updated= studentMapper.editProfile(student);
			return updated;
		}

}
