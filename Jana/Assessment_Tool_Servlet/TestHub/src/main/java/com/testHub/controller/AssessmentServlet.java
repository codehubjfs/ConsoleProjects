package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.testHub.bean.Assessment;
import com.testHub.dao.AssessmentDAO;

/**
 * Servlet implementation class AssessmentServlet
 */
public class AssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private AssessmentDAO assessmentDAO;

	    @Override
	    public void init() {
	        assessmentDAO = new AssessmentDAO();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssessmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int courseId = Integer.parseInt(request.getParameter("courseId"));
	        List<Assessment> assessments = assessmentDAO.getAssessmentsByCourseId(courseId);
	        request.setAttribute("assessments", assessments);
	        request.getRequestDispatcher("views/Student/assessments.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
