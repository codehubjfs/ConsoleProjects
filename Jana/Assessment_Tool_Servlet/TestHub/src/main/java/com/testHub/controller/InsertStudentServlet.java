package com.testHub.controller;

import java.io.IOException;

import com.testHub.bean.Student;
import com.testHub.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertStudentServlet
 */

public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

    /**
     * Default constructor. 
     */
    public InsertStudentServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        studentDao = new StudentDao();
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
		// TODO Auto-generated method stub
		try {
			insertStudent(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        System.out.println(email+password+fname+lname+city+country+gender);
        Student newStudent = new Student();
        newStudent.setEmail(email);
        newStudent.setPassword(password);
        newStudent.setFname(fname);
        newStudent.setLname(lname);
        newStudent.setGender(gender);
        newStudent.setCity(city);
        newStudent.setCountry(country);
        studentDao.insertStudent(newStudent);
        response.sendRedirect("ListStudentServlet");
    }

}
