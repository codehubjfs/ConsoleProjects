package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hotelmanagement.bean.Keeper;
import com.hotelmanagement.dao.KeeperDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditKeeperServlet
 */
public class EditKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditKeeperServlet() {
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
		 System.out.println("INSIDE COMEE");
		 String email = request.getParameter("email");
	        if (email == null || email.trim().isEmpty()) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email cannot be empty");
	            return;
	        }

	        try {
	            String name = request.getParameter("keeperName");
	            String phone = request.getParameter("phoneNo");
	            String status = request.getParameter("status");

	            Keeper keeper = new Keeper();
	            keeper.setEmail(email);
	            keeper.setKeeperName(name);
	            keeper.setPhoneNo(phone);
	            keeper.setStatus(status);

	            KeeperDao keeperDAO = new KeeperDao();
	            keeperDAO.updateHousekeeperByEmail(keeper);


	            response.sendRedirect("ListKeeperServlet");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
	        }
	    }
}

