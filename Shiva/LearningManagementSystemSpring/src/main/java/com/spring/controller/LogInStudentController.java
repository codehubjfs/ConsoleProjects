package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Students;
import com.spring.service.StudentService;
import com.spring.service.StudentServiceImp;

@Controller
public class LogInStudentController {
	@Autowired
	StudentService studentList;
	@GetMapping("/list")
	public ModelAndView StudentLoginRedirect()
	{
		/*List<Students> ListOfStudents= new StudentServiceImp().studentList();
		System.out.print(" -- "+ListOfStudents);*/
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Student/LogIn");
		return modelAndView;
	}
}
