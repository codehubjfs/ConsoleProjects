package com.testPortal.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.testPortal.model.Assessment;
import com.testPortal.model.Course;
import com.testPortal.model.Question;
import com.testPortal.model.QuestionAnalytics;
import com.testPortal.model.Result;
import com.testPortal.model.Teacher;
import com.testPortal.service.AssessmentService;
import com.testPortal.service.QuestionService;
import com.testPortal.service.TeacherService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AssessmentService assessmentService;

//	@Autowired
//    ModelAndView modelAndView;

	@Autowired
	Teacher teacher;

	@Autowired
	Question question;

	@Autowired
	Assessment assessment;

	@RequestMapping("/home")
	public ModelAndView teacherHome(HttpSession session, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		ModelAndView modelAndView = new ModelAndView();

		String email = (String) session.getAttribute("email");

		if (email == null) {

			modelAndView.setViewName("redirect:/logout");

		} else {
			Teacher t = teacherService.getTeacherIdByEmail(email);
			int eid = t.getEid();
			session.setAttribute("eid", eid);
			System.out.println("eid:" + eid);
			List<Course> courses = teacherService.getCoursesByTeacherId(eid);
			for (Course course : courses) {
				if (course.getStart_date() != null && course.getStart_date().length() > 10) {
					course.setStart_date(course.getStart_date().substring(0, 10));
				}
				if (course.getEnd_date() != null && course.getEnd_date().length() > 10) {
					course.setEnd_date(course.getEnd_date().substring(0, 10));
				}
			}
			System.out.println(courses);
			modelAndView.setViewName("Teacher/teacherHome");
			modelAndView.addObject("courses", courses);
			modelAndView.addObject("email", email);
			modelAndView.addObject("teacher", t);
		}
		return modelAndView;
	}

	@PostMapping("/updateTeacher")
	public String updateTeacher(@RequestParam("eid") int eid, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("gender") String gender,
			@RequestParam("city") String city, @RequestParam("country") String country, HttpSession session) {

		String sessionEmail = (String) session.getAttribute("email");
		if (sessionEmail == null) {
			return "redirect:/login";
		}

		teacher.setEid(eid);
		teacher.setEmail(email);
		teacher.setPassword(password);
		teacher.setFname(fname);
		teacher.setLname(lname);
		teacher.setGender(gender);
		teacher.setCity(city);
		teacher.setCountry(country);

		teacherService.updateStudent(teacher);
		return "redirect:/instructor/home";
	}

	@RequestMapping("/assessments")
	public ModelAndView viewAssessments(@RequestParam("courseId") int courseId,
			@RequestParam("courseName") String courseName, HttpSession session, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
//	        ModelAndView modelAndView = new ModelAndView();
		ModelAndView modelAndView = new ModelAndView();

		String email = (String) session.getAttribute("email");

		if (email == null) {

			modelAndView.setViewName("redirect:/logout");

		}

		else {

			List<Assessment> assessments = teacherService.getAssessmentsByCourseId(courseId);
			int eid = (int) session.getAttribute("eid");
			System.out.println("eid:" + eid);

			session.setAttribute("courseId", courseId);
			session.setAttribute("courseName", courseName);

			for (Assessment assessment : assessments) {
				// Parse the date into LocalDate
				LocalDate adate = LocalDate.parse(assessment.getAdate().substring(0, 10),
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				// Parse the start time into LocalTime
				LocalTime startTime = LocalTime.parse(assessment.getSttime(), DateTimeFormatter.ofPattern("HH:mm"));
				LocalTime endTime = LocalTime.parse(assessment.getEndtime(), DateTimeFormatter.ofPattern("HH:mm"));
				// Combine LocalDate and LocalTime to create startTime
				LocalDateTime assessmentStartTime = LocalDateTime.of(adate, startTime);

				// Calculate endTime by adding duration to startTime
				LocalDateTime assessmentEndTime = LocalDateTime.of(adate, endTime);

				// Get current time
				LocalDateTime now = LocalDateTime.now();
//	            int aid = assessment.getAid();

				// Set the status based on the current time and assessment times
				if (now.isAfter(assessmentEndTime)) {
					assessment.setStatus("completed");
				} else if (now.isAfter(assessmentStartTime) && now.isBefore(assessmentEndTime)) {
					assessment.setStatus("ongoing");
				} else if (now.isBefore(assessmentStartTime)) {
					assessment.setStatus("notyetstarted");
				}
			}

			System.out.println(assessments);

			modelAndView.setViewName("Teacher/teacherAssessment");
			modelAndView.addObject("assessments", assessments);
			modelAndView.addObject("courseName", courseName);
		}
		return modelAndView;
	}

	@RequestMapping("/fetchQuestion")
	public ModelAndView getAssessmentQuestions(@RequestParam(value = "aid", required = false) Integer aid,
			@RequestParam(value = "aname", required = false) String aname, HttpSession session,
			HttpServletResponse response) {

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		ModelAndView modelAndView = new ModelAndView();
		String email = (String) session.getAttribute("email");

		if (email == null) {

			modelAndView.setViewName("redirect:/logout");

		} else {

			session.setAttribute("aname", aname);

			if (aid == null) {
//	         ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("error");
				modelAndView.addObject("message", "Assessment ID not provided");
				return modelAndView;
			}

			List<Question> allQuestions = questionService.getAllQuestions();
			List<Question> assessmentQuestions = questionService.getQuestionsByAssessmentId(aid);

			// Create a set of assigned question IDs
			Set<Integer> assignedQuestionIds = assessmentQuestions.stream().map(Question::getQid)
					.collect(Collectors.toSet());

			// Filter out the assigned questions
			List<Question> unassignedQuestions = allQuestions.stream()
					.filter(question -> !assignedQuestionIds.contains(question.getQid())).collect(Collectors.toList());

//	     ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("questions", unassignedQuestions);
			modelAndView.addObject("assessmentQuestions", assessmentQuestions);
			modelAndView.addObject("aname", aname);
			modelAndView.addObject("aid", aid);
			modelAndView.setViewName("Teacher/assessmentQuestions");
		}

		return modelAndView;
	}

	@RequestMapping("/assignQuestion")
	public ModelAndView assignQuestion(@RequestParam(value = "aid", required = false) Integer aid,
			@RequestParam(value = "qid", required = false) Integer qid, RedirectAttributes redirectAttributes,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();

		if (aid == null || qid == null) {
//	         ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error");
			modelAndView.addObject("message", "Assessment ID or Question ID not provided");
			return modelAndView;
		}

		int result = questionService.assignQuestion(aid, qid);
		String aname = (String) session.getAttribute("aname");
		if (result == 1) {
			redirectAttributes.addAttribute("aid", aid);
			redirectAttributes.addAttribute("aname", aname); // Add 'aname' as needed
			return new ModelAndView("redirect:/instructor/fetchQuestion");
		} else {
//	         ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error");
			modelAndView.addObject("message", "Failed to assign question");
			return modelAndView;
		}
	}

	@RequestMapping("/addQuestion")
	public ModelAndView addQuestion(@RequestParam("questionText") String questionText,
			@RequestParam("option1") String option1, @RequestParam("option2") String option2,
			@RequestParam("option3") String option3, @RequestParam("option4") String option4,
			@RequestParam("correctAnswer") String correctAnswer, @RequestParam("mark") int mark,
			@RequestParam("aid") int aid, RedirectAttributes redirectAttributes, HttpSession session) {

		// Create a new Question object
		ModelAndView modelAndView = new ModelAndView();

		question.setQuestions(questionText);
		question.setC1(option1);
		question.setC2(option2);
		question.setC3(option3);
		question.setC4(option4);
		question.setAnswer(correctAnswer);
		question.setMark(mark);

		// Add the question and retrieve the qid
		int qid = questionService.addNewQuestion(question);

		// Assign the question to the assessment
		questionService.assignQuestion(aid, qid);

		// Redirect to the assignQuestion method with parameters
//	     ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/instructor/fetchQuestion");
		String aname = (String) session.getAttribute("aname");
		redirectAttributes.addAttribute("aid", aid);
		System.out.println("add");
		redirectAttributes.addAttribute("aname", aname); // Add 'aname' as needed
//	     modelAndView.addObject("aid", aid);
//	     modelAndView.addObject("qid", qid);

		return modelAndView;
	}

	@RequestMapping("/addAssessment")
	public String addAssessment(@RequestParam("aName") String aName, @RequestParam("startTime") String stTime,
			@RequestParam("endTime") String endTime, @RequestParam("duration") int duration,
			@RequestParam("totalMarks") int totalMarks, @RequestParam("cid") int cid,
			@RequestParam("aDate") String aDateStr, @RequestParam("eid") int eid, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {

		// Convert the date string to LocalDate
		LocalDate aDate = LocalDate.parse(aDateStr, DateTimeFormatter.ISO_DATE);
		System.out.println(aDate);

		// Create the Assessment object

		assessment.setAname(aName);
		assessment.setSttime(stTime);
		assessment.setEndtime(endTime);
		assessment.setDuration(duration);
		assessment.setTot_mark(totalMarks);
		assessment.setCid(cid);
		assessment.setAdate(aDate.toString());
		assessment.setEid(eid);

		// Call the service method to add the assessment
		assessmentService.addAssessment(assessment);

		int courseId = (int) session.getAttribute("courseId");
		String courseName = (String) session.getAttribute("courseName");

		redirectAttributes.addAttribute("courseName", courseName);
		redirectAttributes.addAttribute("courseId", courseId);

		return "redirect:/instructor/assessments";

	}

	@PostMapping("/editAssessment")
	public String editAssessment(@ModelAttribute("assessment") Assessment assessment, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {

		String aDateStr = assessment.getAdate();
		LocalDate aDate = LocalDate.parse(aDateStr, DateTimeFormatter.ISO_DATE);
		assessment.setAdate(aDate.toString());
		System.out.println(assessment);
		assessmentService.updateAssessmentById(assessment);
		String courseName = (String) session.getAttribute("courseName");
		return "redirect:/instructor/assessments?courseId=" + assessment.getCid() + "&courseName=" + courseName;
	}

	@PostMapping("/deleteAssessment")
	public String deleteAssessment(@RequestParam("aid") int aid, Model model, RedirectAttributes redirectAttributes,
			HttpSession session) {

		System.out.println("reached d:" + aid);
		assessmentService.deleteAssessmentById(aid);
		int courseId = (int) session.getAttribute("courseId");
		String courseName = (String) session.getAttribute("courseName");

		redirectAttributes.addAttribute("courseName", courseName);
		redirectAttributes.addAttribute("courseId", courseId);
		return "redirect:/instructor/assessments"; // Redirect to assessments page
	}

	@RequestMapping("/fetchResults")
	public String fetchResults(@RequestParam("assessmentId") int assessmentId,
			@RequestParam("assessmentName") String assessmentName, Model model, HttpSession session,
			HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		String email = (String) session.getAttribute("email");

		if (email == null) {

			return "redirect:/logout";

		}
		List<Result> results = assessmentService.getResultsByAssessmentId(assessmentId);
		List<QuestionAnalytics> questions = assessmentService.getQuestionsAnalytics(assessmentId);

		List<Question> allquestions = questionService.getQuestionsByAssessmentId(assessmentId);
		Map<Integer, String> studentAnswers = new HashMap<>();
		for (Result result : results) {
			studentAnswers = assessmentService.getStudentAnswers(result.getStudentId(), assessmentId);
			result.setStudentAnswers(studentAnswers);
		}
		System.out.println("Map");
		System.out.println(studentAnswers);
		System.out.println("r:" + results);
		System.out.println("q:" + questions);
		System.out.println("all:" + allquestions);

		model.addAttribute("results", results);
		model.addAttribute("questions", questions);
		model.addAttribute("allquestions", allquestions);
		model.addAttribute("assessmentId", assessmentId);
		model.addAttribute("assessmentName", assessmentName);

		return "Teacher/viewResults";
	}

	@PostMapping("/deleteQuestion")
	public String deleteQuestion(@RequestParam("qid") int qid, @RequestParam("aid") int aid, HttpSession session,
			RedirectAttributes redirectAttributes) {
		System.out.println("Received qid: " + qid + ", aid: " + aid); // Debugging line
		String aname = (String) session.getAttribute("aname");
		System.out.println("aname: " + aname); // Debugging line
		questionService.deleteQuestionFromAssessment(qid, aid);
		redirectAttributes.addAttribute("aid", aid);
		redirectAttributes.addAttribute("aname", aname);
		return "redirect:/instructor/fetchQuestion";
	}

}
