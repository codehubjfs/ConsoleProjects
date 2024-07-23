package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.model.Admin;
import com.spring.model.Courses;
import com.spring.model.Ins;
import com.spring.model.Instructor;
import com.spring.model.ModulesBean;
import com.spring.model.Student;
import com.spring.util.DAOFactory;

@Service
public class AdminServiceImp implements AdminService{
	
	
	
	
	public List<Admin> getAdminList() {
		try
		{
		List<Admin> adminList=DAOFactory.getAdminDao().loginAuthentication();
		System.out.println("AdminService "+adminList);
		return adminList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}

	
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		try
		{
		List<Courses> coursesList=DAOFactory.getAdminDao().viewCourses();
		return coursesList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	public List<Instructor> getInstructors()
	{
		try
		{
			List<Instructor> instructorList=DAOFactory.getAdminDao().viewInstructors();
			System.out.println("instructorList "+instructorList);
			return instructorList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}

	public int addCourseService(Courses course) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Service "+course);
			int status=DAOFactory.getAdminDao().addCourse(course);
			System.out.println("Courses "+course.getCourseId()+course.getCoursename()+" "+course.getInstructorId()+" "+course.getStartDate()+" "+course.getEndDate());
			System.out.print("Status :"+status);
			return status;
		}
		catch(Exception e)
		{
			System.out.println("Catch service"+e);
			e.getStackTrace();
		}
		return -1;
	}
	public int editCourse(Courses course)
	{
		try
		{
			int status=DAOFactory.getAdminDao().editCourses(course);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return 0;
	}
	public int deleteCourseService(Courses course)
	{
		try
		{
			int status=DAOFactory.getAdminDao().deleteCourses(course);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}
	public List<ModulesBean> viewModuleService()
	{
		try
		{
			List<ModulesBean> moduleList=DAOFactory.getAdminDao().viewModules();
			return moduleList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	
	public int editModulesService(ModulesBean module)
	{
		System.out.println("welcome");
		try
		{
			System.out.println("hello");
			int status=DAOFactory.getAdminDao().editModules(module);
			System.out.println("status");
			//return status;
		}
		catch(Exception e)
		{
			System.out.println("hi");
			e.getStackTrace();
		}
		return -1;
	}
	public int addModuleService(ModulesBean module)
	{
		try
		{
			int status=DAOFactory.getAdminDao().addModules(module);
			System.out.println("Add modules service "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}
	public int deleteModuleService(ModulesBean module)
	{
		try
		{
			int status=DAOFactory.getAdminDao().deleteModule(module);
			System.out.println("Delete services status "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}
	public List<Student> studentListService()
	{
		try
		{
			List<Student> studentList=DAOFactory.getAdminDao().getStudents();
			return studentList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}


	@Override
	public int addStudentService(Student student) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().addStudents(student);
			System.out.println("Student add service "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}


	@Override
	public int editStudentsService(Student student) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().editStudents(student);
			System.out.println("Student edit service "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}


	@Override
	public int deleteStudents(Student student) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().deleteStudents(student);
			System.out.println("Student delete service "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}


	@Override
	public List<Ins> insService() {
		// TODO Auto-generated method stub
		try
		{
		List<Ins> insList=DAOFactory.getAdminDao().viewIns();
		System.out.println("Ins "+insList);
		return insList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}


	@Override
	public int addinsService(Ins ins) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().addins(ins);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}


	@Override
	public int editinsService(Ins ins) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().editins(ins);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}


	@Override
	public int deleteinsService(Ins ins) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getAdminDao().deleteins(ins);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}
	
}
