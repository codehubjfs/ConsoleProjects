package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.testHub.bean.Educator;
import com.testHub.dao.TeacherDAO;

/**
 * Servlet implementation class EditTeacherServlet
 */
public class EditTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeacherDAO teacherDao;
	
	public void init() {
	teacherDao = new TeacherDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeacherServlet() {
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
		int eid = Integer.parseInt(request.getParameter("eid"));
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        Educator educator = new Educator();
        educator.setEid(eid);
        educator.setEmail(email);
        educator.setFname(fname);
        educator.setLname(lname);
        educator.setGender(gender);
        educator.setCity(city);
        educator.setCountry(country);
        
        System.out.println("Reached EditSErv");
        
        try {
            teacherDao.updateTeacher(educator);
            response.sendRedirect("ListTeacherServlet");
           } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
	}

}
