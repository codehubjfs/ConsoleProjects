package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Product;
import com.letsbuy.beans.Vendor;
import com.letsbuy.dao.ProductDAO;
import com.letsbuy.dao.SellerDAO;

/**
 * Servlet implementation class ProductManagementDeleteController
 */
public class ProductManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagementDeleteController() {
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
		System.out.println("Inside product delete");
		System.out.println("Hiii"+" "+request.getParameter("pId"));
		int pId = Integer.parseInt(request.getParameter("pId"));
		Product product = new Product();
		product.setProductId(pId);
		
		product.setVerificationStatus("DELETED");
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.updateProductVerificationStatus(product);
		response.sendRedirect("ProductManagementController");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProductManagementController");
//		requestDispatcher.forward(request, response);
	}

}
