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
 * Servlet implementation class InsertKeeperServlet
 */
public class InsertKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  private KeeperDao keeperDao;
	    
	    public void init() {
	        keeperDao = new KeeperDao();
	    }

    public InsertKeeperServlet() {
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
		String keeperName = request.getParameter("keeperName");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
       
        
     
        
        Keeper newKeeper = new Keeper();
        newKeeper.setKeeperName(keeperName);
        newKeeper.setEmail(email);
        newKeeper.setPhoneNo(phoneNo);
 
        
        // Set common password for all keepers
        newKeeper.setPassword("Welcome@123");
        newKeeper.setStatus("Available");
        try {
            keeperDao.insertHousekeeper(newKeeper);
            response.sendRedirect("ListKeeperServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error inserting new housekeeper", e);
        }
	}

}
