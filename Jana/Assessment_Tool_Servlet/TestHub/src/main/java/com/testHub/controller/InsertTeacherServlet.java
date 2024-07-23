package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.testHub.bean.Educator;
import com.testHub.dao.TeacherDAO;

/**
 * Servlet implementation class InsertTeacherServlet
 */
public class InsertTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        teacherDao = new TeacherDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertTeacher(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        System.out.println(email+password+fname+lname+city+country+gender);
        Educator newTeacher = new Educator();
        newTeacher.setEmail(email);
        newTeacher.setPassword(password);
        newTeacher.setFname(fname);
        newTeacher.setLname(lname);
        newTeacher.setGender(gender);
        newTeacher.setCity(city);
        newTeacher.setCountry(country);
        teacherDao.insertTeacher(newTeacher);
        response.sendRedirect("ListTeacherServlet");
    }

}
