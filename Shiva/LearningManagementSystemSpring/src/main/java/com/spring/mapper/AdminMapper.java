package com.spring.mapper;

import java.util.List;

import com.spring.model.Admin;
import com.spring.model.Courses;
import com.spring.model.Ins;
import com.spring.model.Instructor;
import com.spring.model.ModulesBean;
import com.spring.model.Student;

public interface AdminMapper {
	List<Admin> loginAuthentication();
	List<Courses> viewCourses();
	List<Instructor> viewInstructors();
	int addCourse(Courses course);
	int editCourses(Courses course);
	int deleteCourses(Courses course);
	List<ModulesBean> viewModules();
	int editModules(ModulesBean module);
	int addModules(ModulesBean module);
	int deleteModule(ModulesBean module);
	List<Student> getStudents();
	int addStudents(Student student);
	int editStudents(Student student);
	int deleteStudents(Student student);
	List<Ins>viewIns();
	int addins(Ins ins);
	int editins(Ins ins);
	int deleteins(Ins ins);
}
