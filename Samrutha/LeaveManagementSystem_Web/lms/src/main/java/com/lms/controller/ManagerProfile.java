package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lms.bean.Employee;
import com.lms.dao.EmployeeDao;

/**
 * Servlet implementation class ManagerProfile
 */
@WebServlet("/mprofile")
public class ManagerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        if (username==null) {
        	response.sendRedirect("Logout");
            
        } 
	        
	        if (emp != null) {
	            String oldPassword = request.getParameter("oldPassword");
	            String newPassword = request.getParameter("newPassword");
	            String CfPassword = request.getParameter("CfPassword");
	            System.out.println(oldPassword);
	            System.out.println(newPassword);
	            System.out.println(CfPassword);
	            if(emp.getPassword().equals(oldPassword) && newPassword.equals(CfPassword)) {
	            	EmployeeDao.updatePassword(newPassword, emp);
	            	request.setAttribute("successMessage", "Updated Successfully...!");
	            }
	            else {
	            	request.setAttribute("errorMessage", "Enter valid password");
	            }
	            
	            request.getRequestDispatcher("views/Manager/Profile.jsp").forward(request, response);
	            
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
