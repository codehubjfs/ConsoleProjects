package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.ProductDAO;

/**
 * Servlet implementation class ProductManagementController
 */
public class ProductManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagementController() {
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
	     if(admin==null) {
	    	 response.sendRedirect("views/admin/index.jsp");
	     }else {
	    		 System.out.println("Inside product");
		ProductDAO productDAO = new ProductDAO();
		System.out.println("h1");
			List<Product> products = productDAO.getAllProducts();
			
			request.getSession().setAttribute("productList", products);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/admin/productmanagement.jsp");
			System.out.println("ready");
			requestDispatcher.forward(request, response);
	     }
		
	}

}
