package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Vendor;
import com.letsbuy.dao.SellerDAO;

/**
 * Servlet implementation class SellerManagementController
 */
public class SellerManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerManagementController() {
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
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin!=null) {
		System.out.println("Inside seller");
		List<Vendor> sellers;
		
		SellerDAO sellerDAO = new SellerDAO();
		sellers = sellerDAO.getAllSellers();
		
		request.getSession().setAttribute("seller", sellers);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/admin/vendormanagement.jsp");
		requestDispatcher.forward(request, response);
		}else {
				response.sendRedirect("views/admin/index.jsp");
		}
	}

}
