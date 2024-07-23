package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.bean.Staff;
import com.hotelmanagement.dao.FrontStaffDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertStaffServlet
 */
public class InsertStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private FrontStaffDao staffDAO;

	    public void init() {
	        staffDAO = new FrontStaffDao();
	    }
	
    public InsertStaffServlet() {
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
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String password = request.getParameter("password");
//	        String password = "Welcome@123";

	        Staff newStaff = new Staff();
	        newStaff.setName(name);
	        newStaff.setEmail(email);
	        newStaff.setPhone(phone);
	        newStaff.setPassword(password);

	        try {
	            boolean hasErrors = false;
	            if (staffDAO.emailExists(email)) {
	                request.setAttribute("emailError", "Email already exists");
	                hasErrors = true;
	            }
	            if (staffDAO.phoneExists(phone)) {
	                request.setAttribute("phoneError", "Phone number already exists");
	                hasErrors = true;
	            }

	            if (hasErrors) {
	                request.setAttribute("name", name);
	                request.setAttribute("email", email);
	                request.setAttribute("phone", phone);
	                request.getRequestDispatcher("ListStaffServlet").forward(request, response);
//	                response.sendRedirect("ListStaffServlet");
	                return;
	            }

	        
	        
				staffDAO.insertStaff(newStaff);
				System.out.println("Inserted Success");
			
	        System.out.println("Inserted Failesd");
	        
	        // Redirecting to the list page to show all staff members
	        response.sendRedirect("ListStaffServlet");
	}
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        }       
	}
}
