package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Admin;
import com.letsbuy.dao.CustomerDAO;
import com.letsbuy.dao.OrderDAO;
import com.letsbuy.dao.SellerDAO;

/**
 * Servlet implementation class AdminDashBoardController
 */
public class AdminDashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashBoardController() {
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
		long customerCount = getCustomerCount();
		long sellerCount = getSellerCount();
		long ordersCount = getOrdersCount();
		System.out.println(customerCount);
		System.out.println(sellerCount);
		System.out.println(ordersCount);
		if(admin==null) {
			response.sendRedirect("views/admin/index.jsp");
		}else {
			request.setAttribute("customercount", customerCount);
			request.setAttribute("sellercount", sellerCount);
			request.setAttribute("ordercount", ordersCount);
			request.getRequestDispatcher("views/admin/dashboard.jsp").forward(request, response);
		}
	}
	
	static long getCustomerCount() {
		CustomerDAO customerDAO = new CustomerDAO();
		long count = customerDAO.getAllCustomers().stream().filter(c-> !c.getAccount().getAccountStatus().equals("DELETED")).count();
		return count;
	}
	
	static long getSellerCount() {
		SellerDAO sellerDAO = new SellerDAO();
		long count = sellerDAO.getAllSellers().stream().filter(c-> !c.getAccount().getAccountStatus().equals("DELETED")).count();
		return count;
	}
	
	static long getOrdersCount() {
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getOrdersCount();
	}

}
