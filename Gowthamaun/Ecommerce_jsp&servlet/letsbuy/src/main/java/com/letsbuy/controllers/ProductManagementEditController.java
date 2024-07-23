package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Product;
import com.letsbuy.dao.ProductDAO;

/**
 * Servlet implementation class ProductManagementEditController
 */
public class ProductManagementEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagementEditController() {
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
		System.out.println("Inside product edit");
		Product product = new Product();
		int productId = Integer.parseInt(request.getParameter("pId"));
		String verifiedStatus = request.getParameter("status");
		product.setProductId(productId);
		product.setVerificationStatus(verifiedStatus);
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.updateProductVerificationStatus(product);
		response.sendRedirect("ProductManagementController");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProductManagementController");
//		requestDispatcher.forward(request, response);
		}

}
