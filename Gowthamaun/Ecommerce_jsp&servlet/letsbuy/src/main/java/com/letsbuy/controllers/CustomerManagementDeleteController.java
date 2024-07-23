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
 * Servlet implementation class CustomerManagementDeleteController
 */
public class CustomerManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManagementDeleteController() {
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
		System.out.println("Inside customer delete");
		int cId = Integer.parseInt(request.getParameter("cId"));
		System.out.println(cId);
		Customer customer = new Customer();
		customer.setCustomerId(cId);
		Account account = new Account();
		account.setAccountStatus("DELETED");
		customer.setAccount(account);
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.updateAccountStatus(customer);
		response.sendRedirect("CustomerManagementController");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerManagementController");
//		requestDispatcher.forward(request, response);
	}

}
