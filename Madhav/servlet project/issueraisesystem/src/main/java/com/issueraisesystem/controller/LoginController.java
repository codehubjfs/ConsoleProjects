package com.issueraisesystem.controller;
import com.issueraisesystem.dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.Login;
import com.issueraisesystem.beans.StudentDetails;

/**
 * Servlet implementation class LoginController
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		String mailid=request.getParameter("email");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		Login login=new Login();
		login.setMailid(mailid);
		login.setPassword(password);
		login.setRole(role);
		
		boolean hasError = false;
        if (mailid == null || mailid.isEmpty()) {
            request.setAttribute("emailError", "Please enter your email.");
            hasError = true;
        }
        if (password == null || password.isEmpty()) {
            request.setAttribute("passwordError", "Please enter your password.");
            hasError = true;
            
        }

        if (hasError) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
		
		
		System.out.println(mailid);
		LoginDAO logindao=new LoginDAO();
		
		//Check the user role
		int checkRole=0;
		if(role.equals("Student")) {
			checkRole=1;
		}
		else if(role.equals("Admin")) {
			checkRole=2;
		}
		else if(role.equals("Warden")){
			checkRole=3;
		}
		
		
		
		//According to the user the page will redirect into other page
		switch(checkRole) {
			case 1:
				try {
		            // Check if user is valid
		            boolean isValidUser = logindao.isValidUser(login,login.getRole());

		            if (isValidUser) {
		                // Set a session attribute indicating the user is logged in
		            	 HttpSession session = request.getSession();
		                 session.setAttribute("mailid", mailid);
		            	 
		            	 response.sendRedirect(request.getContextPath() + "/Sdashboard");
//		            	response.sendRedirect("views/Student/dashboard.jsp");
		            	
		            } else {
		                // Set an error attribute to display on the login page
		                request.setAttribute("error", "Invalid email or password ");

		               
		                request.getRequestDispatcher("/index.jsp").forward(request, response);
		                System.out.println("bad");
		            }
		        } catch (SQLException e) {
		            // Handle database errors
		            e.getMessage();
		            throw new ServletException("Database access error", e);
		        }
				break;
			case 2:
				try {
		            // Check if user is valid
		            boolean isValidUser = logindao.isValidUser(login,login.getRole());
		            
		            if (isValidUser) {
		                // Set a session attribute indicating the user is logged in
		            	 HttpSession session = request.getSession();
		                 session.setAttribute("mailid", mailid);
		            	request.getRequestDispatcher("AdminDashboardController").forward(request, response);
		            	
		            } else {
		                // Set an error attribute to display on the login page
		                request.setAttribute("error", "Invalid email or password ");

		                // Forward back to the login page with the error message
		                request.getRequestDispatcher("/index.jsp").forward(request, response);
		                System.out.println("bad");
		            }
		        } catch (SQLException e) {
		            // Handle database errors
		            e.getMessage();
		            throw new ServletException("Database access error", e);
		        }
				break;
				
			case 3:
				try {
		            // Check if user is valid
		            boolean isValidUser = logindao.isValidUser(login,login.getRole());
		            
		            if (isValidUser) {
		                // Set a session attribute indicating the user is logged in
		            	 HttpSession session = request.getSession();
		                 session.setAttribute("mailid", mailid);
		            	request.getRequestDispatcher("WardenDashBoardController").forward(request, response);
		            	
		            } else {
		                // Set an error attribute to display on the login page
		                request.setAttribute("error", "Invalid email or password ");

		                // Forward back to the login page with the error message
		                request.getRequestDispatcher("/index.jsp").forward(request, response);
		                System.out.println("bad");
		            }
		        } catch (SQLException e) {
		            // Handle database errors
		            e.getMessage();
		            throw new ServletException("Database access error", e);
		        }
				break;
				
		}
		
		
		
	}

}
