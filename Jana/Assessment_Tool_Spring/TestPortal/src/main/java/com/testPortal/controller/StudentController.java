package com.testPortal.controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.testPortal.model.Assessment;
import com.testPortal.model.Course;
import com.testPortal.model.Question;
import com.testPortal.model.Student;
import com.testPortal.service.AssessmentService;
import com.testPortal.service.QuestionService;
import com.testPortal.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {

//	@Autowired
//	ModelAndView modelAndView;

	@Autowired
	private StudentService studentService;
	@Autowired
	private AssessmentService assessmentService;

	@RequestMapping("/home")
	public ModelAndView studentHome(HttpSession session, HttpServletResponse response) {

		String email = (String) session.getAttribute("email");
		ModelAndView modelAndView = new ModelAndView();

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			modelAndView.setViewName("redirect:/logout");

		} else {
			Student s = studentService.getStudentIdByEmail(email);
			int sid = s.getSid();
			session.setAttribute("sid", sid);
			List<Course> courses = studentService.getCoursesByStudentId(sid);

			// Trim the start_date and end_date fields
			for (Course course : courses) {
				if (course.getStart_date() != null && course.getStart_date().length() > 10) {
					course.setStart_date(course.getStart_date().substring(0, 10));
				}
				if (course.getEnd_date() != null && course.getEnd_date().length() > 10) {
					course.setEnd_date(course.getEnd_date().substring(0, 10));
				}
			}

			System.out.println(courses);

			modelAndView.setViewName("Student/studentHome");
			modelAndView.addObject("courses", courses);
			modelAndView.addObject("email", email);
			modelAndView.addObject("student", s);

		}
		return modelAndView;
	}

	@RequestMapping("/assessments")
	public ModelAndView viewAssessments(@RequestParam("courseId") int courseId,
			@RequestParam("courseName") String courseName, HttpSession session, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String email = (String) session.getAttribute("email");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			modelAndView.setViewName("redirect:/logout");

		} else {
			List<Assessment> assessments = assessmentService.getAssessmentsByCourseId(courseId);
			int sid = (int) session.getAttribute("sid");
			System.out.println("sid:" + sid);

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
				int aid = assessment.getAid();

				// Check if the assessment is already taken
				boolean isTaken = assessmentService.checkAssessmentAlreadyTaken(sid, aid);

				// Set the status based on the current time and assessment times
				if (isTaken) {
					assessment.setStatus("completed");
				} else if (now.isAfter(assessmentEndTime)) {
					assessment.setStatus("missed");
				} else if (now.isAfter(assessmentStartTime) && now.isBefore(assessmentEndTime)) {
					assessment.setStatus("started");
				} else if (now.isBefore(assessmentStartTime)) {
					assessment.setStatus("not yet started");
				}
			}

			modelAndView.setViewName("Student/assessments");
			modelAndView.addObject("assessments", assessments);
			modelAndView.addObject("courseName", courseName);
		}
		return modelAndView;
	}

	@Autowired
	private QuestionService questionService; // Inject QuestionDAO

	@RequestMapping("/fetchQuestions")
	public String fetchQuestions(@RequestParam("assessmentId") int assessmentId,
			@RequestParam("AssessmentName") String assessmentName, @RequestParam("duration") String duration,
			Model model, HttpSession session, HttpServletResponse response) {

		String email = (String) session.getAttribute("email");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			return "redirect:/logout";

		}
		session.setAttribute("assessmentId", assessmentId);

		// Fetch questions from DAO
		System.out.println("AId: " + assessmentId);
		System.out.println("anmae:" + assessmentName);

		List<Question> questions = questionService.getQuestionsByAssessmentId(assessmentId);
		System.out.println(questions);

		// Add fetched data to the model
		model.addAttribute("duration", duration);
		model.addAttribute("questions", questions);
		model.addAttribute("assessmentId", assessmentId);
		model.addAttribute("assessmentName", assessmentName);

		// Return view name (logical view name to resolve to actual view)
		return "Student/test"; // Assuming "test.jsp" is under "views/Student/"
	}

	@RequestMapping("/StoreQuestionServlet")
	public String storeQuestion(@SessionAttribute("sid") Integer studentId,
			@SessionAttribute("assessmentId") Integer assessmentId, @RequestParam("answerMap") String answerMapJson,
			HttpSession session, HttpServletResponse response) {
		String email = (String) session.getAttribute("email");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			return "redirect:/logout";

		}
		if (studentId == null || answerMapJson == null) {
			return "error"; // Assuming error.jsp is mapped to the logical view name "error"
		}
		System.out.println("sid" + studentId);
		System.out.println("aid" + assessmentId);

		// Deserialize the JSON into a Map with Integer keys
		Type type = new TypeToken<Map<String, String>>() {
		}.getType();
		Gson gson = new Gson();
		Map<String, String> stringKeyedMap = gson.fromJson(answerMapJson, type);

		Map<Integer, String> answers = new HashMap<>();
		for (Map.Entry<String, String> entry : stringKeyedMap.entrySet()) {
			answers.put(Integer.parseInt(entry.getKey()), entry.getValue());
			System.out.println(Integer.parseInt(entry.getKey()) + entry.getValue());
		}

		studentService.saveStudentAnswers(studentId, answers, assessmentId);
		studentService.calculateAndStoreTotalMarks(studentId, assessmentId);
		return "Student/thankYou"; // Redirect to thank you page
	}

	@RequestMapping("/AssessmentScore")
	public String showAssessmentScore(@RequestParam("assessmentId") int assessmentId, HttpSession session, Model model,
			HttpServletResponse response) {
		String email = (String) session.getAttribute("email");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			return "redirect:/logout";

		}
		int studentId = (int) session.getAttribute("sid");
		System.out.println("assessId" + assessmentId);

		List<Question> questions = questionService.getQuestionsByAssessmentId(assessmentId);
		Assessment assessment = assessmentService.fetchAssessmentData(assessmentId);
		Map<Integer, String> correctAnswers = assessmentService.fetchCorrectAnswers(assessmentId);
		Map<Integer, String> studentAnswers = assessmentService.fetchStudentAnswers(studentId, assessmentId);
		int totalScore = assessmentService.fetchTotalScore(studentId, assessmentId);
		System.out.println(assessment);
		System.out.println("Correct Answers: " + correctAnswers);
		System.out.println("Student Answers: " + studentAnswers);
		model.addAttribute("assessment", assessment);
		model.addAttribute("questions", questions);
		model.addAttribute("correctAnswers", correctAnswers);
		model.addAttribute("studentAnswers", studentAnswers);
		model.addAttribute("totalScore", totalScore);

		return "Student/displayScore";
	}

	@RequestMapping("/editProfile")
	public String fetchQuestions(@RequestParam("assessmentId") int assessmentId,
			@RequestParam("AssessmentName") String assessmentName, Model model, HttpSession session,
			HttpServletResponse response) {
		String email = (String) session.getAttribute("email");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (email == null) {

			return "redirect:/logout";

		}
		session.setAttribute("assessmentId", assessmentId);

		// Fetch questions from DAO
		System.out.println("AId: " + assessmentId);
		System.out.println("anmae:" + assessmentName);

		List<Question> questions = questionService.getQuestionsByAssessmentId(assessmentId);
		System.out.println(questions);

		// Add fetched data to the model
		model.addAttribute("questions", questions);
		model.addAttribute("assessmentId", assessmentId);
		model.addAttribute("assessmentName", assessmentName);

		// Return view name (logical view name to resolve to actual view)
		return "Student/test"; // Assuming "test.jsp" is under "views/Student/"
	}

}
