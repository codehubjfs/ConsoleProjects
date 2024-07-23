package com.spring.service;

import java.util.List;

import com.spring.model.AssessmentBean;
import com.spring.model.Courses;
import com.spring.model.Marks;
import com.spring.model.ModulesBean;
import com.spring.model.Students;
import com.spring.model.TestBean;
import com.spring.model.TopicsBean;

public interface StudentService {
	List<Students> studentList();
	List<Courses>studentViewCourses();
	List<ModulesBean> studentViewModules(Courses course);
	List<TopicsBean> studentViewTopics(ModulesBean module);
	List<AssessmentBean> studentViewAssessments();
	List<TestBean> studentViewTests(AssessmentBean assessment);
	int editStudentService(Students student);
	int insertMarkService(Marks mark);
	List<Marks>viewMarksService();
}
