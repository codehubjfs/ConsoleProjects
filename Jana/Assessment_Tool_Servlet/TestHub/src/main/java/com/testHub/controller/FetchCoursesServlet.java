package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.testHub.bean.Course;
import com.testHub.dao.AssignTeacherCourse;

/**
 * Servlet implementation class FetchCoursesServlet
 */
public class FetchCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherId = request.getParameter("teacherId");
		AssignTeacherCourse assignTeacherCourse = new AssignTeacherCourse();
        List<Course> courses = assignTeacherCourse.getUnassignedCoursesForTeacher(teacherId);
        
        String json = new Gson().toJson(courses);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
