package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hotelmanagement.bean.Admin;
import com.hotelmanagement.dao.AdminDao;
import com.hotelmanagement.utilities.DbUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class EditAccountServlet
 */
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private AdminDao adminDAO;

	    public void init() {
	        adminDAO = new AdminDao();
	    }

    public EditAccountServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Display edit form if needed, for example:
        request.getRequestDispatcher("/views/admin/editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Admin ad = new Admin();
		ad.setName(name);
		ad.setAddress(address);
		ad.setEmail(email);
		ad.setPhoneNo(phone);
		
		adminDAO.updateAdmin(ad);
		response.sendRedirect("views/admin/viewProfile.jsp");
			}

}
