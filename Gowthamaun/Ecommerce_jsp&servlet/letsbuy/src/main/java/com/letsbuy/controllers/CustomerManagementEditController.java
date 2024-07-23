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
import com.letsbuy.dao.CustomerDAO;

/**
 * Servlet implementation class CustomerManagementEditController
 */
public class CustomerManagementEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManagementEditController() {
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
		
//		System.out.println("I am in edit Controller");
		// TODO Auto-generated method stub
		System.out.println("Inside customer edit");
		Customer customer = new Customer();
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		Account account = new Account();
		account.setAccountStatus(request.getParameter("customer"));
		customer.setAccount(account);
//		System.out.println("I am in edit Controller set");
		String cid =  request.getParameter("cid");
		System.out.println(cid);
		customer.setCustomerId(Integer.parseInt(cid));
		customerDAO.updateAccountStatus(customer);
		response.sendRedirect("CustomerManagementController");
//		System.out.println("I am in edit Controller set update");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerManagementController");
//		requestDispatcher.forward(request, response);
//		doGet(request, response);
	}

}
