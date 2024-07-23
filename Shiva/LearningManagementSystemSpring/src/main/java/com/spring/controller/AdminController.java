package com.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mapper.AdminMapper;
import com.spring.model.Admin;
import com.spring.model.Courses;
import com.spring.model.Ins;
import com.spring.model.Instructor;
import com.spring.model.ModulesBean;
import com.spring.model.Student;
import com.spring.service.AdminService;
import com.spring.util.DAOFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/adminRedirect")
	public ModelAndView redirect(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Admin/LogIn");
		return modelAndView;
	}
	@GetMapping("/hello")
	public ModelAndView indexcontroller(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		List<Admin> adminList=adminService.getAdminList();
		//System.out.println("AdminList "+adminList);
		int flg=0;
		String userName="";
		for(int i=0;i<adminList.size();i++)
		{
			if(adminList.get(i).getUsername().equals(username)&&adminList.get(i).getPassword().equals(password))
			{
				userName=adminList.get(i).getUsername();
				flg++;
			}
		}
		if(flg>0)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("username", userName);
			return viewCourses(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	public ModelAndView viewCourses(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		List<Courses> coursesList=adminService.getCourses();
		//System.out.println("CoursesList "+coursesList);
		session.setAttribute("coursesL", coursesList);
		List<Student> studentList=adminService.studentListService();
		session.setAttribute("sList", studentList);
		ModelAndView modelAndView=new ModelAndView();
		return viewInstructors(coursesList,request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	public ModelAndView viewInstructors(List<Courses> courses,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		List<Instructor> instructorList=adminService.getInstructors();
		ModelAndView modelAndView=new ModelAndView();
		List<Ins> inslist=adminService.insService();
		System.out.println("Ins "+inslist);
		session.setAttribute("insList", inslist);
		modelAndView.addObject("coursesList", courses);
		modelAndView.addObject("instructorList",instructorList);
		session.setAttribute("instructorList", instructorList);
		modelAndView.setViewName("Admin/Courses");
		return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("addCourse")
	public ModelAndView addCourse(@RequestParam("courseName") String courseName,@RequestParam("instructorName") String instructorId,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			System.out.println("Inside course ");
		Courses course=new Courses();
		int courseid=100;
		course.setCourseId(++courseid);
		course.setCoursename(courseName);
		//System.out.println("CourseName "+courseName);
		course.setInstructorId(Integer.parseInt(instructorId));
		//System.out.println("instructorID "+instructorId);
		System.out.println("start date "+startDate);
		System.out.println("End date "+endDate);
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		course.setStartDate(LocalDate.parse(startDate,df));
		course.setEndDate(LocalDate.parse(endDate,df));
		int status=adminService.addCourseService(course);
		System.out.println("Status "+status);
		return viewCourses(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("editCourse")
	public ModelAndView editCourse(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		System.out.println("The course id is "+courseId);
		String courseName=request.getParameter("courseName");
		int instructorId=Integer.parseInt(request.getParameter("instructorName"));
		System.out.println("Instructor name "+instructorId);
		System.out.println(request.getParameter("startDate"));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate=LocalDate.parse(request.getParameter("startDate"),dateTimeFormatter);
		LocalDate endDate=LocalDate.parse(request.getParameter("endDate"),dateTimeFormatter);
		//System.out.println(courseName+" "+instructorId+" "+" "+startDate+" "+endDate);
		Courses course=new Courses();
		course.setCourseId(courseId);
		course.setCoursename(courseName);
		course.setInstructorId(instructorId);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		System.out.println("AdminEditController "+" "+courseName+" "+instructorId+" "+startDate+" "+endDate);
		//AdminEditCoursesDao adminEditCoursesDao=new AdminEditCoursesDao();
		
		try {
			//boolean status= adminEditCoursesDao.adminEditCourses(course);
			//System.out.println("The status "+status);
//			RequestDispatcher rd=request.getRequestDispatcher("ViewCoursesController");
//			rd.forward(request, response);
			//response.sendRedirect("ViewCoursesController");	
			int updated=adminService.editCourse(course);
			System.out.println("updated "+updated);
			return viewCourses(request,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
		return null;
	}
	
	@GetMapping("deleteCourse")
	public ModelAndView deleteCourse(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		Courses course=new Courses();
		course.setCourseId(courseId);
		int status=adminService.deleteCourseService(course);
		System.out.println("delete Course "+status);
		ModelAndView modelAndView=new ModelAndView();
		return viewCourses(request,response);
	}
	@GetMapping("AdminViewModules")
	public ModelAndView viewModules(@RequestParam("courseId") int courseId,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		//int courseId=Integer.parseInt(request.getParameter("courseId"));
		System.out.println("view modules "+courseId);
		session.setAttribute("courseId", courseId);
		List<Courses> course=(List<Courses>) DAOFactory.getAdminDao().viewCourses().stream().filter((x)->x.getCourseId()==courseId).collect(Collectors.toList());
		session.setAttribute("course", course);
		session.setAttribute("coursename",course.get(0).getCoursename());
		List<ModulesBean> moduleList=DAOFactory.getAdminDao().viewModules().stream().filter((x)->x.getCourseId()==courseId).collect(Collectors.toList());
		System.out.println(moduleList);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("moduleList",moduleList);
		modelAndView.setViewName("Admin/Module1");
		return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("AdminEditModule")
	public ModelAndView editModule(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		String moduleName=request.getParameter("moduleName");
    	int moduleId=Integer.parseInt(request.getParameter("moduleId"));
    	ModulesBean module=new ModulesBean();
    	module.setModuleName(moduleName);
    	module.setModuleId(moduleId);
		int status=adminService.editModulesService(module);
		System.out.println("Module edit status "+status);
		ModelAndView modelAndView=new ModelAndView();
		return  viewModules((int) session.getAttribute("courseId"), request,response) ;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("addModule")
	public ModelAndView addModules(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		String name=request.getParameter("moduleName");
		System.out.println("Module name "+name);
		int courseId=(int) session.getAttribute("courseId");
		System.out.println("Module courseId "+courseId);
		//System.out.println("Module Name "+name+"  course id "+courseId+" instructor id "+(int) session.getAttribute("instructorid"));
		ModulesBean module=new ModulesBean();
		module.setModuleName(name);
		module.setCourseId(courseId);
		module.setInstructorId((int) ((List<Courses>) session.getAttribute("course")).get(0).getInstructorId());
		System.out.println((int) ((List<Courses>) session.getAttribute("course")).get(0).getInstructorId());
		int status=adminService.addModuleService(module);
		System.out.println("Controller addModule"+status);
		ModelAndView modelAndView=new ModelAndView();
		return  viewModules((int) session.getAttribute("courseId"), request,response) ;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
		
	}
	
	@GetMapping("deleteModule")
	public ModelAndView deleteModule(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			System.out.println("Delete module enter");
			int moduleId=Integer.parseInt(request.getParameter("moduleId"));
			System.out.println("delete module "+moduleId);
			ModulesBean module=new ModulesBean();
			module.setModuleId(moduleId);
			int status=adminService.deleteModuleService(module);
			System.out.println("Delete Module status "+status);
			ModelAndView modelAndView=new ModelAndView();
			return  viewModules((int) session.getAttribute("courseId"), request,response) ;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("users")
	public ModelAndView viewUsers(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/Users");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("viewStudents")
	public ModelAndView viewStudents(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			List<Student> studentList=adminService.studentListService();
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("studentList", studentList);
			modelAndView.setViewName("Admin/Student");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	
	@GetMapping("addStudent")
	public ModelAndView addStudent(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			System.out.println("Add student");
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String department=request.getParameter("department");
			LocalDate dob= LocalDate.parse(request.getParameter("dob"));
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Student student=new Student();
			student.setFirstname(firstname);
			student.setLastname(lastname);
			student.setDepartment(department);
			student.setdob(dob);
			student.setUsername(username);
			student.setPassword(password);
			System.out.println("Student bean "+student.toString());
			int status=adminService.addStudentService(student);
			System.out.println("Controller add student "+status);
			ModelAndView modelAndView=new ModelAndView();
			return viewStudents(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
		
	}
	
	@GetMapping("editStudent")
	public ModelAndView editStudent(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");

		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String department=request.getParameter("department");
		LocalDate dob=LocalDate.parse(request.getParameter("dob"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("this is admin edit student id "+studentId+" "+firstname+" "+lastname+" "+dob+" "+username+" "+password);
		Student student=new Student();
		student.setStudentId(studentId);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setDepartment(department);
		student.setdob(dob);
		student.setUsername(username);
		student.setPassword(password);
		int status=adminService.editStudentsService(student);
		System.out.println("Controller editStudent "+status);
		return viewStudents(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("DeleteStudent")
	public ModelAndView deleteStudent(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");

		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		System.out.println("delete Student id "+studentId);
		Student student=new Student();
		student.setStudentId(studentId);
		int status=adminService.deleteStudents(student);
		System.out.println("Student delete "+status);
		return viewStudents(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	
	
	@GetMapping("viewInstructors")
	public ModelAndView viewInstructors(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
//		HttpSession session=request.getSession(false);
//		if(session.getAttribute("username")!=null)
//		{
//			List<Student> studentList=adminService.studentListService();
//			List<Ins> insList=adminService.insService();
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.addObject("studentList", studentList);
//			modelAndView.setViewName("Admin/Instructor");
//			return modelAndView;
//		}
//		else
//		{
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("Admin/LogIn");
//			return modelAndView;
//		}
        HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			//List<Student> studentList=adminService.studentListService();
			//List<Ins> inslist=adminService.insService();
			List<Ins>inslist=adminService.insService();
			System.out.println("Ins list"+inslist);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("insList", inslist);
			modelAndView.setViewName("Admin/Instructor");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	
	@GetMapping("editInstructor")
	public ModelAndView editInstructors(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
//        HttpSession session=request.getSession(false);
//		if(session.getAttribute("username")!=null)
//		{
//		int studentId=Integer.parseInt(request.getParameter("studentId"));
//		String firstname=request.getParameter("firstname");
//		String lastname=request.getParameter("lastname");
//		String department=request.getParameter("department");
//		LocalDate dob=LocalDate.parse(request.getParameter("dob"));
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		System.out.println("this is admin edit student id "+studentId+" "+firstname+" "+lastname+" "+dob+" "+username+" "+password);
//		Student student=new Student();
//		student.setStudentId(studentId);
//		student.setFirstname(firstname);
//		student.setLastname(lastname);
//		student.setDepartment(department);
//		student.setdob(dob);
//		student.setUsername(username);
//		student.setPassword(password);
//		int status=adminService.editStudentsService(student);
//		System.out.println("Controller editStudent "+status);
//		return viewInstructors(request,response);
//		}
//		else
//		{
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("Admin/LogIn");
//			return modelAndView;
//		}
        
        HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String department=request.getParameter("department");
		LocalDate dob=LocalDate.parse(request.getParameter("dob"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("this is admin edit student id "+studentId+" "+firstname+" "+department+" "+lastname+" "+dob+" "+username+" "+password);
		Ins ins=new Ins();
		ins.setInsid(studentId);
		ins.setFirstname(firstname);
		ins.setLastname(lastname);
		ins.setDepartment(department);
		ins.setDob(dob);
		ins.setUsername(username);
		ins.setPassword(password);
		int status=adminService.editinsService(ins);
		System.out.println("Controller editStudent "+status);
		return viewInstructors(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("addInstructor")
	public ModelAndView addInstructor(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
//		HttpSession session=request.getSession(false);
//		if(session.getAttribute("username")!=null)
//		{
//			System.out.println("Add student");
//			String firstname=request.getParameter("firstname");
//			String lastname=request.getParameter("lastname");
//			String department=request.getParameter("department");
//			LocalDate dob= LocalDate.parse(request.getParameter("dob"));
//			String username=request.getParameter("username");
//			String password=request.getParameter("password");
//			Student student=new Student();
//			student.setFirstname(firstname);
//			student.setLastname(lastname);
//			student.setDepartment(department);
//			student.setdob(dob);
//			student.setUsername(username);
//			student.setPassword(password);
//			System.out.println("Student bean "+student.toString());
//			int status=adminService.addStudentService(student);
//			System.out.println("Controller add student "+status);
//			ModelAndView modelAndView=new ModelAndView();
//			return viewInstructors(request,response);
//		}
//		else
//		{
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("Admin/LogIn");
//			return modelAndView;
//		}
        HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			System.out.println("Add student");
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String department=request.getParameter("department");
			LocalDate dob= LocalDate.parse(request.getParameter("dob"));
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Ins ins=new Ins();
			int cnt=0;
			ins.setInsid(++cnt);
			ins.setFirstname(firstname);
			ins.setLastname(lastname);
			ins.setDepartment(department);
			ins.setDob(dob);;
			ins.setUsername(username);
			ins.setPassword(password);
			//System.out.println("Student bean "+ins.toString());
			int status=adminService.addinsService(ins);
			System.out.println("Controller ins  "+status);
			ModelAndView modelAndView=new ModelAndView();
			return viewInstructors(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	
	@GetMapping("DeleteInstructors")
	public ModelAndView deleteInstructor(HttpServletRequest request,HttpServletResponse response)
	{

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");

//		HttpSession session=request.getSession(false);
//		if(session.getAttribute("username")!=null)
//		{
//		int studentId=Integer.parseInt(request.getParameter("studentId"));
//		System.out.println("delete Student id "+studentId);
//		Student student=new Student();
//		student.setStudentId(studentId);
//		int status=adminService.deleteStudents(student);
//		System.out.println("Student delete "+status);
//		return viewInstructors(request,response);
//		}
//		else
//		{
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("Admin/LogIn");
//			return modelAndView;
//		}
        
        HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		System.out.println("delete ins id "+studentId);
		Ins ins=new Ins();
		ins.setInsid(studentId);
		int status=adminService.deleteinsService(ins);
		System.out.println("Student ins delete "+status);
		return viewInstructors(request,response);
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("logOut")
	public ModelAndView logOut(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");

		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			session.invalidate();
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
		}
	}
	@GetMapping("redirectCourses")
	public ModelAndView courseRedirect(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        HttpSession session=request.getSession(false);
        if(session.getAttribute("username")!=null)
        {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Admin/Courses");
		return viewCourses(request,response);
        }
        else
        {
        	ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
        }
	}
	@GetMapping("redirectChatting")
	public ModelAndView chatting(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        HttpSession session=request.getSession(false);
        if(session.getAttribute("username")!=null)
        {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Admin/Chatting");
		return viewCourses(request,response);
        }
        else
        {
        	ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
        }
	}
	
	//	@GetMapping("Chatting")
	//	public ModelAndView chatting(HttpServletRequest request,HttpServletResponse response)
	//	{
	//		ModelAndView modelAndView=new ModelAndView();
	//		modelAndView.setViewName("Admin/Chatting");
	//		return modelAndView;
	//	}
	@GetMapping("dash")
	public ModelAndView dashb(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        HttpSession session=request.getSession(false);
        if(session.getAttribute("username")!=null)
        {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Admin/DashBoard");
		return modelAndView;
        }
        else
        {
        	ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Admin/LogIn");
			return modelAndView;
        }
	}
}
