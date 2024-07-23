package com.testPortal.service;

import java.util.List;
import java.util.Map;

import com.testPortal.model.Course;
import com.testPortal.model.Student;

public interface StudentService {

	Student getStudentIdByEmail(String email);

	List<Course> getCoursesByStudentId(int sid);

	void saveStudentAnswers(int studentId, Map<Integer, String> answers, int assessmentId);

	void calculateAndStoreTotalMarks(int studentId, int assessmentId);

}
