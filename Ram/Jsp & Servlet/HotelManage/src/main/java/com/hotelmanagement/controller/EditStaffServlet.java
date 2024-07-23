package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.bean.FrontStaff;
import com.hotelmanagement.bean.Staff;
import com.hotelmanagement.dao.FrontStaffDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditStaffServlet
 */
public class EditStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FrontStaffDao staffDAO;

    public void init() {
        staffDAO = new FrontStaffDao();
    }
    public EditStaffServlet() {
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  int id = Integer.parseInt(request.getParameter("id"));
		  String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");

	        Staff staff = new Staff();
	        staff.setName(name);
	        staff.setEmail(email);
	        staff.setPhone(phone);

	        try {
	            staffDAO.updateStaff(staff);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        response.sendRedirect("ListStaffServlet");
	        
	}

}
