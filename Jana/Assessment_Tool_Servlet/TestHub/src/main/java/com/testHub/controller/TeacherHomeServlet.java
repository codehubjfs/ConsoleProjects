package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.testHub.bean.Course;
import com.testHub.bean.TeacherCoursesResult;
import com.testHub.dao.TeacherCourseDAO;

/**
 * Servlet implementation class TeacherHomeServlet
 */
public class TeacherHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private TeacherCourseDAO teacherCourseDAO;

	    public void init() {
	        teacherCourseDAO = new TeacherCourseDAO();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherHomeServlet() {
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
	        TeacherCoursesResult result = teacherCourseDAO.selectCoursesByTeacherEmail(email);
	        int eid = result.getEid();
	        List<Course> courses = result.getCourses();

	        session.setAttribute("eid", eid); // Add sid to the session
	        request.setAttribute("courses", courses);
	        request.getRequestDispatcher("views/Teacher/teacherHome.jsp").forward(request, response);
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
