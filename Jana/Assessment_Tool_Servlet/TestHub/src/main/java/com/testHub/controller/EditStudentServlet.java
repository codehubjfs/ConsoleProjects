package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.testHub.bean.Student;
import com.testHub.dao.StudentDao;

/**
 * Servlet implementation class EditStudentServlet
 */
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDAO;

    public void init() {
        studentDAO = new StudentDao();
    }

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int sid = Integer.parseInt(request.getParameter("sid"));
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        Student student = new Student();
        student.setSid(sid);
        student.setEmail(email);
        student.setFname(fname);
        student.setLname(lname);
        student.setGender(gender);
        student.setCity(city);
        student.setCountry(country);
        
        System.out.println("Reached EditSErv");
        
        try {
            studentDAO.updateStudent(student);
            response.sendRedirect("ListStudentServlet");
           } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    
	}

}
