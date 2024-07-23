package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.testHub.dao.TeacherDAO;

/**
 * Servlet implementation class DeleteTeacherServlet
 */
public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDao;

    public void init() {
        teacherDao = new TeacherDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("sid"));
		System.out.println("Eid="+eid);
        try {
            teacherDao.deleteTeacher(eid);
            response.sendRedirect("ListTeacherServlet");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
