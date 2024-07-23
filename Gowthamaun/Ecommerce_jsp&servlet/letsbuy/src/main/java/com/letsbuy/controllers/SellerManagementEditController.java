package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Vendor;
import com.letsbuy.dao.CustomerDAO;
import com.letsbuy.dao.SellerDAO;

/**
 * Servlet implementation class SellerManagementEditController
 */
public class SellerManagementEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerManagementEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside seller edit");
		Vendor seller = new Vendor();
		
		SellerDAO sellerDAO = new SellerDAO();
		
		Account account = new Account();
		account.setAccountStatus(request.getParameter("status"));
		seller.setAccount(account);
//		System.out.println("I am in edit Controller set");
		String vid =  request.getParameter("vid");
		System.out.println(vid);
		seller.setVendorId(Integer.parseInt(vid));
		sellerDAO.updateAccountStatus(seller);
		response.sendRedirect("SellerManagementController");
//		System.out.println("I am in edit Controller set update");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("SellerManagementController");
//		requestDispatcher.forward(request, response);
	}

}
