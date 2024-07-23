package com.spring.service;

import java.util.List;

import com.spring.model.Admin;
import com.spring.model.Courses;
import com.spring.model.Ins;
import com.spring.model.Instructor;
import com.spring.model.ModulesBean;
import com.spring.model.Student;

public interface AdminService {
	List<Admin> getAdminList();
	List<Courses> getCourses();
	List<Instructor> getInstructors();
	int addCourseService(Courses course);
	int editCourse(Courses course);
	int deleteCourseService(Courses course);
	List<ModulesBean> viewModuleService();
	int editModulesService(ModulesBean module);
	int addModuleService(ModulesBean module);
	int deleteModuleService(ModulesBean module); 
	List<Student> studentListService();
	int addStudentService(Student student);
	int editStudentsService(Student student);
	int deleteStudents(Student student);
	List<Ins>insService();
	int addinsService(Ins ins);
	int editinsService(Ins ins);
	int deleteinsService(Ins ins);
}
