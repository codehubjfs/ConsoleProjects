package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Vendor;

import com.letsbuy.dao.SellerDAO;

/**
 * Servlet implementation class SellerManagementDeleteController
 */
public class SellerManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerManagementDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("Inside seller delete");
		System.out.println("Hiii");
		int vId = Integer.parseInt(request.getParameter("vId"));
		Vendor vendor = new Vendor();
		vendor.setVendorId(vId);
		Account account = new Account();
		account.setAccountStatus("DELETED");
		vendor.setAccount(account);
		SellerDAO vendorDAO = new SellerDAO();
		
		vendorDAO.updateAccountStatus(vendor);
		response.sendRedirect("SellerManagementController");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("SellerManagementController");
//		requestDispatcher.forward(request, response);
	}

}
