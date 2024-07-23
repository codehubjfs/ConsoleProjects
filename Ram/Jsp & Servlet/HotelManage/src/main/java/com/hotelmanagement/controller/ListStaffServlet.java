package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hotelmanagement.bean.Staff;
import com.hotelmanagement.dao.FrontStaffDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListStaffServlet
 */
public class ListStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private FrontStaffDao staffDAO;

	    public void init() {
	        staffDAO = new FrontStaffDao();
	    }
	    
    public ListStaffServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        
        
        if(request.getSession().getAttribute("username")==null)
        {
        	response.sendRedirect("LogoutAdminServlet");
        }
        if(request.getSession().getAttribute("username")!=null)
        {
        	request.setAttribute("emailError", "Email already exists");
          
            request.setAttribute("phoneError", "Phone number already exists");
         
        	List<Staff> listStaff = null;
	        listStaff = staffDAO.selectAllStaff();
	        request.setAttribute("listStaff", listStaff);
//	        request.getSession().setAttribute("listStaff", listStaff);
//	        response.sendRedirect("views/admin/staff.jsp");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/staff.jsp");
	        dispatcher.forward(request, response);
	        
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/staff.jsp");
//	        dispatcher.forward(request, response);
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
