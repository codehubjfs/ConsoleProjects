package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.dao.FrontStaffDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private FrontStaffDao staffDao;
    public void init() {
    	staffDao = new FrontStaffDao();
    }
    
    public DeleteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("email");
		try {
			staffDao.deleteStaff(mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ListStaffServlet");
	}

}
