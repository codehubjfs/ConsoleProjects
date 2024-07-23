package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.letsbuy.beans.Account;
import com.letsbuy.beans.Customer;
import com.letsbuy.dao.CustomerDAO;
import com.letsbuy.dao.RegisterDAO;

/**
 * Servlet implementation class CustomerRegisterController
 */
public class CustomerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private static final long serialVersionUID = 1L;
    private static CustomerDAO l = new CustomerDAO();
    
	private static List<Customer> customers = l.getAllCustomers();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterController() {
        super();
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
		long MobileNumber = Long.parseLong(request.getParameter("mobile_no").trim());
		String emailId = request.getParameter("emailid").trim();
		String firstName = request.getParameter("first_name").trim();
		String lastName = request.getParameter("last_name").trim();
		String address = request.getParameter("address").trim();
		String gender = request.getParameter("gender");
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password");
		String accountType = "CUSTOMER";
		String accountStatus = "ACTIVE";
		
		Customer customer = new Customer();
		Account account = new Account();
		account.setAccountStatus(accountStatus);
		account.setAccountType(accountType);
		account.setPassword(password);
		account.setUserName(userName);
		customer.setAccount(account);
		customer.setAddress(address);
		customer.setEmail(emailId);
		customer.setFirstName(firstName);
		customer.setGender(gender);
		customer.setLastName(lastName);
		customer.setMobileNumber(MobileNumber);
		
	        
//		boolean isMobileNumberExist = customers.stream().anyMatch(c->c.getMobileNumber()==customer.getMobileNumber());
//		boolean isUsernameExist = customers.stream().anyMatch(c->c.getAccount().getUserName().equals(customer.getAccount().getUserName()));
//		boolean isEmailExist = customers.stream().anyMatch(c->c.getEmail().equals(customer.getEmail()));
		
		RegisterDAO reg = new RegisterDAO();

			boolean success = reg.registerCustomer(customer);
			if(success) {
				customers.add(customer);
				request.setAttribute("customers", customer);
				System.out.println("Customer has been registered sucessfully.");
				request.getRequestDispatcher("views/customer/login.jsp").forward(request, response);
			}else {
				System.out.println("There is some error occured while trying to register.");
				response.sendRedirect("views/customer/register.jsp");
			}
	}

}
