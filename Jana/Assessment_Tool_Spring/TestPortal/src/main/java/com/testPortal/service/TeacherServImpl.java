package com.testPortal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testPortal.mapper.TeacherMapper;
import com.testPortal.model.Assessment;
import com.testPortal.model.Course;
import com.testPortal.model.Teacher;

@Service
public class TeacherServImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public Teacher getTeacherIdByEmail(String email) {
		return teacherMapper.findEidByEmail(email);
	}

	@Override
	public List<Course> getCoursesByTeacherId(int eid) {

		return teacherMapper.findCoursesByTeacherId(eid);
	}

	@Override
	public List<Assessment> getAssessmentsByCourseId(int courseId) {

		return teacherMapper.getAssessmentsByCourseId(courseId);

	}

	@Override
	public void updateStudent(Teacher teacher) {
		teacherMapper.updateTeacher(teacher);

	}

}
