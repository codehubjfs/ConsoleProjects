package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.testHub.bean.Course;
import com.testHub.dao.StudentCourseDAO;

/**
 * Servlet implementation class StudentHomeServlet
 */
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private StudentCourseDAO studentCourseDAO;

	    public void init() {
	        studentCourseDAO = new StudentCourseDAO();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        String email = (String) session.getAttribute("email");
	        System.out.println(email);

	        if (email != null) {
	            List<Course> courses = studentCourseDAO.selectCoursesByStudentEmail(email);
	            request.setAttribute("courses", courses);
	            request.getRequestDispatcher("views/Student/studentHome.jsp").forward(request, response);
	        } else {
	            response.sendRedirect("views/Login/login.jsp");
	        }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
