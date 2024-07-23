package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.Exception;

import com.spring.model.AssessmentBean;
import com.spring.model.Courses;
import com.spring.model.Marks;
import com.spring.model.ModulesBean;
import com.spring.model.Students;
import com.spring.model.TestBean;
import com.spring.model.TopicsBean;
import com.spring.util.DAOFactory;

@Service
public class StudentServiceImp implements StudentService  {
	
	public List<Students> studentList()  {
		// TODO Auto-generated method stub
		try
		{
			List<Students> studentList=DAOFactory.getStudentDao().getStudentsList();
		return studentList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Courses> studentViewCourses()  {
		// TODO Auto-generated method stub
		try
		{
		List<Courses> courseList=DAOFactory.getStudentDao().studentViewCourses();
		return courseList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	public List<ModulesBean> studentViewModules(Courses course)
	{
		try
		{
			List<ModulesBean> moduleList=DAOFactory.getStudentDao().studentViewModules(course);
			return moduleList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	public List<TopicsBean> studentViewTopics(ModulesBean module)
	{
		try
		{
			List<TopicsBean> topicList=DAOFactory.getStudentDao().studentViewTopics(module);
			return topicList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}

	public List<AssessmentBean> studentViewAssessments() {
		// TODO Auto-generated method stub
		try
		{
			List<AssessmentBean> assessmentList=DAOFactory.getStudentDao().studentViewAssessments();
			//System.out.println("AssessmentList "+assessmentList);
			return assessmentList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	public List<TestBean> studentViewTests(AssessmentBean assessment)
	{
		try
		{
			int assessmentId=assessment.getAssessmentId();
			System.out.println("assmentId "+assessmentId );
			List<TestBean> testList=DAOFactory.getStudentDao().studentViewTest();
			testList.stream().filter((x)->x.getAssessmentid()==assessmentId).collect(Collectors.toList()).forEach((x)->System.out.println(x.getQuestion()));
			System.out.println("This is test service");
			System.out.println("is testList null:"+testList.isEmpty());
			return testList;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return null;
	}
	public int editStudentService(Students student)
	{
		try
		{
			int status=DAOFactory.getStudentDao().editStudent(student);
			System.out.println("Student edit "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}

	@Override
	public int insertMarkService(Marks mark) {
		// TODO Auto-generated method stub
		try
		{
			int status=DAOFactory.getStudentDao().insertMarks(mark);
			System.out.println("Student marks status service "+status);
			return status;
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return -1;
	}

	@Override
	public List<Marks> viewMarksService() {
		// TODO Auto-generated method stub
		try {
			List<Marks> marksList=DAOFactory.getStudentDao().viewMarks();
			return marksList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
