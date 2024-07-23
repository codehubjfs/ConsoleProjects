package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.Admin;
import com.hotelmanagement.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginAdminServlet
 */
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginAdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        AdminDao adminDao = new AdminDao();
	        Admin admin = adminDao.getAdminByUsername(username,password);

	        if (admin != null) {
	            System.out.println("Admin found: " + admin.getUsername());
	            if (admin.getPassword().equals(password)) {
	                System.out.println("Password matches");
	                HttpSession session = request.getSession();
	                session.setAttribute("username", "username");
	                response.sendRedirect("views/admin/dashboard.jsp");
	            } else {
	                System.out.println("Password does not match");
	                request.setAttribute("errorMessage", "Invalid username or password");
	                request.getRequestDispatcher("${pageContext.request.contextPath}/views/admin/index.jsp").forward(request, response);
	            }
	        } else {
	            System.out.println("Admin not found");
	            request.setAttribute("errorMessage", "Invalid username or password");
	            request.getRequestDispatcher("views/admin/index.jsp").forward(request, response);
	        }
	    
	}
}
