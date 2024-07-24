package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.dao.AuthenticationDAO;

/**
 * Servlet implementation class AdminLoginServelet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		String userName = request.getParameter("name");
		System.out.println(userName);
		String password = request.getParameter("password");
        Customer guest = new Customer();
        guest.setUserName(userName);
        guest.setPassword(password);
        try {
            Customer customer = new AuthenticationDAO().login(guest);
            if (customer == null) {
                request.setAttribute("error", "Invalid Username or Password");
                request.getRequestDispatcher("view/Admin/adminlogin.jsp").forward(request, response); // Forward to the login page with error
            } else {
                request.getSession().setAttribute("userName", customer);
                request.setAttribute("loginSuccess", true); // Set login success attribute
                request.getRequestDispatcher("view/Admin/adminlogin.jsp").forward(request, response); // Forward to the login page to show modal
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
