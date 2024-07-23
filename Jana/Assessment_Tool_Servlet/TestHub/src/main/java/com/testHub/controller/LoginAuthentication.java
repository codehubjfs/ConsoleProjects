package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
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
		    String email = request.getAttribute("email") != null ? request.getAttribute("email").toString() : request.getParameter("email");
	        String password = request.getAttribute("password") != null ? request.getAttribute("password").toString() : request.getParameter("password");
	        String userType = request.getAttribute("userType") != null ? request.getAttribute("userType").toString() : request.getParameter("user-type");
	        
	        User user = new User();
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setUser(userType);
	        
	        System.out.println(email+password+userType);
	        
	        LoginDao log = new LoginDao();
	        boolean result=log.validateLogin(user);
	        HttpSession session = request.getSession();
	        
	        if (result) {
	        	session.setAttribute("email", email);
	        	session.setAttribute("password", password);
	        	session.setAttribute("userType", userType);
	            switch (userType) {
	                case "Admin":
	                	
	                	response.sendRedirect("ListStudentServlet");
//	                    response.sendRedirect("views/Admin/admin.jsp");
	                    break;
	                case "Instructor":
	                	
	                    response.sendRedirect("TeacherHomeServlet");
	                    break;
	                case "Student":
	                	
	                    response.sendRedirect("StudentHomeServlet");
	                    break;
	            }
	        } else {
	            request.setAttribute("errorMessage", "Invalid Credentials!");
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
