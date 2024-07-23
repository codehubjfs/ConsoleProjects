package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Orders;
import com.letsbuy.dao.OrderDAO;

/**
 * Servlet implementation class CustomerOrdersController
 */
public class CustomerOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrdersController() {
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
		Customer c = (Customer) request.getSession().getAttribute("user");
		if(c==null) {
			response.setContentType("text/html");
			response.sendRedirect("index.jsp");	
		}else {
			OrderDAO order = new OrderDAO();
			Orders orders = order.getCustomerOrders(c);
			
			orders.getOrders().stream().forEach(System.out::println);
			request.setAttribute("orders", orders);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/orders.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
