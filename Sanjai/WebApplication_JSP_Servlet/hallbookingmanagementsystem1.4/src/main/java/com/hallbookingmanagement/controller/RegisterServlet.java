package com.hallbookingmanagement.controller;

import com.hallbookingmanagement.dao.AuthenticationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		 String name = request.getParameter("name");
		 String gender = request.getParameter("gender");
		 String email = request.getParameter("email");
		 String phone = request.getParameter("phone");
		 String address = request.getParameter("address");
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 Customer guest = new Customer();
		 guest.setName(name);
		 guest.setGender(gender);
		 guest.setEmailId(email);
		 guest.setAddress(address);
		 guest.setNumber(phone);
		 guest.setUserName(username);
		 guest.setPassword(password);
		 try {
			 Customer customer = AuthenticationDAO.register(guest);
			 if (customer == null) {
				 if (!AuthenticationDAO.uniqueMailChecker(guest.getEmailId())) {
					 request.setAttribute("emailError", "Email already exists.");
				 }
				 if (!AuthenticationDAO.uniqueNumberChecker(guest.getNumber())) {
					 request.setAttribute("phoneError", "Phone number already exists.");
				 }
				 if (!AuthenticationDAO.uniqueUserNameChecker(guest.getUserName())) {
					 request.setAttribute("usernameError", "Username already exists.");
				 }
				  request.getRequestDispatcher("view/register.jsp").forward(request, response); // Forward to the login page with error
			 } else {
				 request.getRequestDispatcher("index.jsp").forward(request, response); 
			 }
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
}
