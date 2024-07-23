package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.testHub.dao.CalculateMarkDAO;

/**
 * Servlet implementation class CalculateTotalMarksServlet
 */
public class CalculateTotalMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateTotalMarksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        Integer studentId = (Integer) session.getAttribute("sid");
	        String assessmentIdStr = request.getParameter("assessmentId");

	        if (studentId == null || assessmentIdStr == null) {
	            response.sendRedirect("error.jsp");
	            return;
	        }

	        int assessmentId = Integer.parseInt(assessmentIdStr);

	        try {
	        	CalculateMarkDAO.calculateAndStoreTotalMarks(studentId, assessmentId);
	            response.sendRedirect("views/Student/studentHome.jsp");
	        } catch (SQLException e) {
	            throw new ServletException("Database error", e);
	        }
	}

}
