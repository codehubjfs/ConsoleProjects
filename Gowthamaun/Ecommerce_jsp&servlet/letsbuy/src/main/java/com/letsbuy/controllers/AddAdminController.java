package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Admin;
import com.letsbuy.dao.AdminDAO;

/**
 * Servlet implementation class AddAdminController
 */
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = new AdminDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0);
		System.out.println("This is a add admin servlet");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null) {
			response.sendRedirect("views/admin/index.jsp");
		}
		admin.setPassword("admin@123");//Setting the default password for a new admin
		admin.setUserName(request.getParameter("add-admin-username"));
		System.out.println(admin.getUserName());
		boolean status = adminDAO.addAdmin(admin);
		if(status) {
			System.out.println("New admin has been added Sucessfully");
		}
		response.sendRedirect("AdminManagementController");
	}

}
