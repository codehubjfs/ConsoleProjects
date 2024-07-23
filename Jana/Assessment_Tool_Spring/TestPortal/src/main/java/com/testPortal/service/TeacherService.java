package com.testPortal.service;

import java.util.List;

import com.testPortal.model.Assessment;
import com.testPortal.model.Course;
import com.testPortal.model.Teacher;

public interface TeacherService {

	Teacher getTeacherIdByEmail(String email);

	List<Course> getCoursesByTeacherId(int eid);

	List<Assessment> getAssessmentsByCourseId(int courseId);

	void updateStudent(Teacher teacher);

}
