package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.dao.WardenDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddWardenController
 */
public class AddWardenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddWardenController() {
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
		String adminmailid = (String) request.getSession().getAttribute("mailid");
    	if (adminmailid == null) {
            // Handle case where username is not found in session, perhaps redirect to login
            request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
    	
    	String mailid=request.getParameter("mailid");
    	String wardenName=request.getParameter("wardenName");
    	String password=request.getParameter("password");
    	
    	WardenDetails warden=new WardenDetails();
    	warden.setMailid(mailid);
    	warden.setName(wardenName);
    	warden.setPassword(password);
    	
    	WardenDAO wardenDao=new WardenDAO();
    	boolean inserted=false;
    	try {
			inserted=wardenDao.addWarden(warden);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	request.getRequestDispatcher("/WardenManagementController").forward(request, response);
    	
    	
	}

}
