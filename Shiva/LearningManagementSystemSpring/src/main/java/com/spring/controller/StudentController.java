package com.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mapper.StudentMapper;
import com.spring.model.AssessmentBean;
import com.spring.model.Courses;
import com.spring.model.Marks;
import com.spring.model.ModulesBean;
import com.spring.model.Student;
import com.spring.model.Students;
import com.spring.model.TestBean;
import com.spring.model.TopicsBean;
import com.spring.service.StudentService;
import com.spring.util.DAOFactory;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@PostMapping("/studentLogIn")
	public ModelAndView StudentLogIn(@RequestParam("username")String username,@RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response)
	{
		
		int flg=0;
		List<Students> studentList=studentService.studentList();
		//System.out.println(studentList);
		for(int i=0;i<studentList.size();i++)
		{
			System.out.println();
			if(studentList.get(i).getUsername().equals(username)&&studentList.get(i).getPassword().equals(password))
			{
				flg++;
				HttpSession session=request.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("user", studentList.get(i));
				System.out.println("user id studentLogIn "+studentList.get(i).getStudentId());
				return viewCourses(request,response);
			}
		}
		if(flg<=0)
		{
			ModelAndView mv=new ModelAndView();
			mv.addObject("errmsg","Username or Password not found");
			mv.setViewName("Student/LogIn");
			return mv;
		}
		return null;
	}
	
	@GetMapping("courses")
	public ModelAndView viewCourses(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		List<Courses> courseList=studentService.studentViewCourses();
		for(int i=0;i<courseList.size();i++)
		{
			System.out.println("This is studentController");
			System.out.println(courseList.get(i).getCoursename());
		}
		//request.setAttribute("coursesList", courseList);
		ModelAndView modelAndView=new ModelAndView();
		session.setAttribute("coursesList", courseList);
		modelAndView.addObject("coursesList", courseList);
		modelAndView.setViewName("Student/Courses");
		return modelAndView;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	
	@GetMapping("/modules")
	public ModelAndView viewModules(@RequestParam("courseId") int courseId,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		Courses course=new Courses();
		course.setCourseId(courseId);
		List<ModulesBean> moduleList=studentService.studentViewModules(course);
		/*for(int i=0;i<moduleList.size();i++)
		{
			System.out.println("Modules "+moduleList.get(i).getModuleName());
		}*/
		//System.out.println("Student Controller : courseId "+courseId);
		//System.out.println(moduleList);
		List<Courses> courseList=(List<Courses>)session.getAttribute("coursesList");
		List<Courses> course1= (List<Courses>) courseList.stream().filter(x->x.getCourseId()==courseId).toList();
		LocalDate startDate=course1.get(0).getStartDate();
		System.out.println("StartDate "+startDate);
		LocalDate endDate=course1.get(0).getEndDate();
		System.out.println("End Date "+endDate);
		ModelAndView modelAndView=new ModelAndView();
		session.setAttribute("courseid", courseId);
		session.setAttribute("coursename", course1.get(0).getCoursename());
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate",endDate);
		session.setAttribute("moduleList", moduleList);
		modelAndView.addObject("moduleList",moduleList);
		session.setAttribute("moduleList", moduleList);
		modelAndView.setViewName("Student/Module1");
		return modelAndView;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("/topics")
	public ModelAndView viewTopics(@RequestParam("moduleId") int moduleId,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		ModulesBean module=new ModulesBean();
		module.setModuleId(moduleId);
		List<ModulesBean> moduleList=((List<ModulesBean>)session.getAttribute("moduleList")).stream().filter((x)->x.getModuleId()==moduleId).collect(Collectors.toList());
		List<TopicsBean> topicList=studentService.studentViewTopics(module);
		//System.out.println(" topicList "+topicList);
		ModelAndView modelAndView=new ModelAndView();
		session.setAttribute("moduleName", moduleList.get(0).getModuleName());
		session.setAttribute("modules",moduleList.get(0));
		session.setAttribute("moduleid", moduleId);
		//modelAndView.addObject("topicList", topicList);
		//modelAndView.setViewName("Student/Topic");
		//List<ModulesBean> moduleList=((List<ModulesBean>)session.getAttribute("moduleList")).stream().filter((x)->x.getModuleId()==moduleId).toList();
		//session.setAttribute("module", moduleList.get(0).getModuleName());
		System.out.println("TopicList "+topicList);
		return viewAssessments(topicList,request,response);
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	public ModelAndView viewAssessments(List<TopicsBean> topicList,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		//TopicsBean topic=new TopicsBean();
		//topic.setTopicId(topicId);
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		List<AssessmentBean> assessmentList=studentService.studentViewAssessments();
		session.setAttribute("assessmentList",assessmentList);
		System.out.println("assessment list "+assessmentList);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("topicList",topicList);
		modelAndView.addObject("assessmentList",assessmentList);
		modelAndView.setViewName("Student/Topic");
		return modelAndView;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("/test")
	public ModelAndView viewTest(@RequestParam("assessmentId") int assessmentId,HttpServletRequest request,HttpServletResponse response)
	{	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		System.out.println("This is test getmapping studentController "+assessmentId);
		AssessmentBean assessment=new AssessmentBean();
		assessment.setAssessmentId(assessmentId);
		session.setAttribute("assessmentid", assessmentId);
		
		List<Marks>marksList=studentService.viewMarksService();
		System.out.println("Marks List "+marksList);
		int flg=0;
		for(int i=0;i<marksList.size();i++)
		{
			if(marksList.get(i).getStudentid()==((Students)session.getAttribute("user")).getStudentId()&&assessmentId==marksList.get(i).getAssessmentid())
			{
				ModelAndView modelAndView=new ModelAndView();		
				session.setAttribute("testAttempt",1);
				return viewTopics((int)session.getAttribute("moduleid"),request,response);
			}
		}
		
		List<TestBean> testList=studentService.studentViewTests(assessment);
		List<TestBean> testQuestions=testList.stream().filter((x)->x.getAssessmentid()==assessmentId).collect(Collectors.toList());
		System.out.println("Test list "+testList.size());
		ModelAndView modelAndView=new ModelAndView();
		session.setAttribute("assessmentId",assessmentId);
		session.setAttribute("questionsList", testQuestions);
		modelAndView.addObject("questionsList",testQuestions);
		modelAndView.setViewName("Student/Test");
		return modelAndView;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("StudentMarkCalc")
	public ModelAndView viewScore(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		List<TestBean> questionList=(List<TestBean>)session.getAttribute("questionsList");
		int score=0;
		for(int i=0;i<questionList.size();i++)
		{
			String studentAnswer=(request.getParameter(""+questionList.get(i).getQuestionId()+""));
			if(studentAnswer==null)
			{
				continue;
			}
			if(studentAnswer.equals(questionList.get(i).getAnswer()))
			{
				score++;
				
			}
		}
		System.out.println("The score of the student is "+score);
		Marks mark=new Marks();
		mark.setAssessmentid((int)session.getAttribute("assessmentid"));
		System.out.println("mark id "+mark.getAssessmentid());
		mark.setMarks(score);
		System.out.println("mark marks"+mark.getMarks());
		mark.setStudentid(((Students)session.getAttribute("user")).getStudentId());
		System.out.println("marks student id "+mark.getStudentid());
		int status=studentService.insertMarkService(mark);
		System.out.println("Student marks insert "+status);
		//
		List<Marks>marksList=studentService.viewMarksService();
		System.out.println("Marks List "+marksList);
		//
		ModelAndView mv=new ModelAndView();
		mv.addObject("score", score);
		mv.setViewName("Student/ScoreCard");
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	
	@GetMapping("Profile")
	public ModelAndView viewProfile(HttpServletRequest request,HttpServletResponse response)
	{
//		HttpSession session=request.getSession(false);
//		if(session.getAttribute("username")!=null)
//		{
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("Student/Profile");
//			return mv;
//		}
//		else
//		{
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("index");
//			return mv;
//		}
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			Students user=(Students)session.getAttribute("user");
			System.out.println("user "+user);
			System.out.println("user id "+user.getStudentId());
//			Students student=new Students();
//			student.setStudentId(user.get(0).getStudentId());
//			student.setDepartment(user.get(0).getDepartment());
//			student.setDob(user.get(0).getDob());
//			student.setFirstname(user.get(0).getFirstname());
//			student.setLastname(user.get(0).getLastname());
//			student.setPassword(user.get(0).getPassword());
//			student.setUsername(user.get(0).getUsername());
			ModelAndView mv=new ModelAndView();
			mv.addObject("studentProfile", user);
			mv.setViewName("Student/Profile");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("DashBoard")
	public ModelAndView viewDashBoard(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/DashBoard");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("Chatting")
	public ModelAndView viewChat(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/Chatting");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("editProfile")
	public ModelAndView editProfile(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			int studentId=Integer.parseInt(request.getParameter("studentid"));
			System.out.println("Student id"+studentId);
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String department=request.getParameter("department");
			LocalDate dob=LocalDate.parse(request.getParameter("dob"));
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Students student=new Students();
			student.setStudentId(studentId);
			student.setFirstname(firstname);
			student.setLastname(lastname);
			student.setDepartment(department);
			student.setDob(dob);
			student.setUsername(username);
			student.setPassword(password);
			//edit username
			//session.setAttribute("username", student.getUsername());
			int status=studentService.editStudentService(student);
			return viewProfile(request,response);
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("testtotopic")
	public ModelAndView topicRedirect(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView mv=new ModelAndView();
			int moduleId=((ModulesBean)session.getAttribute("modules")).getModuleId();
			System.out.println("Test to topic "+moduleId);
			return viewTopics(moduleId,request,response);
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("topicToModule")
	public ModelAndView topictoModule(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView mv=new ModelAndView();
			return viewModules((int)session.getAttribute("courseid"),request,response);
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	@GetMapping("viewMarks")
	public ModelAndView viewMarks(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			List<Marks>marksList=studentService.viewMarksService();
			System.out.println("Marks List "+marksList);
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
		return null;
		
	}
	
	@GetMapping("Results")
	public ModelAndView Results(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			ModelAndView mv=new ModelAndView();
			//return viewModules((int)session.getAttribute("courseid"),request,response);
			List<Marks>markList=studentService.viewMarksService();
			List<AssessmentBean> assessmentList=studentService.studentViewAssessments();
			mv.addObject("assessmentList",assessmentList);
			mv.addObject("marksList",markList);
			mv.setViewName("Student/Result");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
	
	@GetMapping("SLogOut")
	public ModelAndView LogOut(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		HttpSession session= request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
			session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Student/LogIn");
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("Student/LogIn");
			return mv;
		}
	}
}
