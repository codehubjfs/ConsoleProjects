package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.testHub.dao.StudentDao;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDAO;

    public void init() {
        studentDAO = new StudentDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
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
        try {
            studentDAO.deleteStudent(sid);
            response.sendRedirect("ListStudentServlet");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
