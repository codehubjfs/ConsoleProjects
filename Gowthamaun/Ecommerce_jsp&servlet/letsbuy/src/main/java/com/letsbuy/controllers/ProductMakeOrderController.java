package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;

/**
 * Servlet implementation class ProductMakeOrderController
 */
public class ProductMakeOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMakeOrderController() {
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
		Customer customer = (Customer) request.getSession().getAttribute("user");
		if(customer==null) {
			response.sendRedirect("views/customer/login.jsp");
		}else {
		Product choosen = (Product) request.getSession().getAttribute("choosen");
		List<Product> products = new ArrayList<>();
		if(choosen==null) {
			products = customer.getMyCart().getMyCart().values().stream().collect(Collectors.toList());
		}else {
		choosen.setQuantity(1);
		System.out.println("Inside the Make Order Controller");
		
		products.add(choosen);
		System.out.println(choosen.getSubtitle());
		}
		request.setAttribute("orderProducts", products);
		request.getRequestDispatcher("views/customer/orderpage.jsp").forward(request, response);
		}
	}

}
