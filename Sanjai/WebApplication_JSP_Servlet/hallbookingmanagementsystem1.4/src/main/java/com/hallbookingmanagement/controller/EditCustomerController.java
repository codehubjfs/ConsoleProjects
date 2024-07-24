package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.dao.CustomerDAO;

/**
 * Servlet implementation class EditCustomerController
 */
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String status = request.getParameter("status");
		System.out.println("User ID "+ userId);
		System.out.print("Status "+status);
		Customer customer = new Customer();
		customer.setAccountStatus(status);
		customer.setUserId(userId);
		boolean isUpdated;
		try {
			isUpdated = new CustomerDAO().updateStatus(customer);
			if(isUpdated){
				System.out.println("Customer status Updated Successfully");
				request.getRequestDispatcher("CustomerManagementServlet").forward(request, response);
			}
			else {
				System.out.println("Not updated ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
