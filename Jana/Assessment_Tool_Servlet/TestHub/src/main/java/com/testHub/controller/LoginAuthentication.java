package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.testHub.bean.User;
import com.testHub.dao.LoginDao;

/**
 * Servlet implementation class Login
 */

public class LoginAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String userType = request.getParameter("user-type");
	        PrintWriter out = response.getWriter();
	        
	        User user = new User();
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setUser(userType);
	        
//	        System.out.println(email+password+userType);
	        
	        LoginDao log = new LoginDao();
	        boolean result=log.validateLogin(user);
	        HttpSession session = request.getSession();
	        
	        if (result) {
	        	session.setAttribute("email", email);
	            switch (userType) {
	                case "Admin":
	                	
	                	response.sendRedirect("ListStudentServlet");
//	                    response.sendRedirect("views/Admin/admin.jsp");
	                    break;
	                case "Instructor":
	                	
	                    response.sendRedirect("StudentHomeServlet");
	                    break;
	                case "Student":
	                	
	                    response.sendRedirect("StudentHomeServlet");
	                    break;
	            }
	        } else {
	            request.setAttribute("errorMessage", "Invalid email or password");
	            request.getRequestDispatcher("views/Login/login.jsp").forward(request, response);
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
