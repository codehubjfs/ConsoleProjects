package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Admin;
import com.hotelmanagement.bean.Customer;
import com.hotelmanagement.dao.AdminDao;
import com.hotelmanagement.utilities.DbUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private AdminDao adminDAO;

	    public void init() {
	        adminDAO = new AdminDao();
	    }

    public ViewProfileServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   listAdmin(request, response);
	}

	private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admin = null;
		try {
			admin = adminDAO.getAllAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("admins", admin);
		request.getRequestDispatcher("views/admin/viewProfile.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
