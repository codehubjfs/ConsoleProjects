package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.testHub.bean.Assessment;
import com.testHub.dao.AssessmentDAO;

/**
 * Servlet implementation class TeacherAssessmentServlet
 */
public class TeacherAssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssessmentDAO assessmentDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAssessmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
        assessmentDAO = new AssessmentDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check for courseId and courseName parameters
        String courseIdStr = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");

        if (courseIdStr == null || courseName == null) {
            // If parameters are not present, check session attributes
            Integer courseIdAttr = (Integer) request.getSession().getAttribute("courseId");
            courseName = (String) request.getSession().getAttribute("courseName");


            // Use session attributes
            courseIdStr = String.valueOf(courseIdAttr);
        }

        int courseId = Integer.parseInt(courseIdStr);
        
        // Store courseId and courseName in session for subsequent requests
        request.getSession().setAttribute("courseId", courseId);
        request.getSession().setAttribute("courseName", courseName);

        List<Assessment> assessments = assessmentDAO.getAssessmentsByCourseId(courseId);
        request.setAttribute("assessments", assessments);
        request.setAttribute("courseId", courseId);
        request.setAttribute("courseName", courseName);
        request.getRequestDispatcher("views/Teacher/teacherAssessment.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
