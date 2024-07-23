package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Orders;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.CartDAO;
import com.letsbuy.dao.OrderDAO;

/**
 * Servlet implementation class CustomerCartController
 */
public class CustomerCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO cartDAO = new CartDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCartController() {
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
//		doGet(request, response);
		System.out.println("Inside the Customer cart Controller");
		Customer c = (Customer) request.getSession().getAttribute("user");
		
		if(c==null) {
			response.setContentType("text/html");
			response.sendRedirect("index.jsp");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/login.jsp");
			
		}else {
			List<Product> cartProduct = new ArrayList<>();
			Cart cart = c.getMyCart();
			cartProduct = cart.getMyCart().values().stream().collect(Collectors.toList());
			double totalAmount = cartProduct.stream()
					.mapToDouble(p->(p.getProductPrice()+(p.getProductPrice()*p.getDiscount()/100))*p.getQuantity())
					.sum();
			int productsCount = cartProduct.size();
			double amountPaid = cartProduct.stream()
					.mapToDouble(p->p.getProductPrice()*p.getQuantity())
					.sum();
			double discountAmount = totalAmount-amountPaid;
			double deliveryCharges = cartProduct.stream().mapToDouble(p->p.getQuantity()*40).sum();
			cart.setDeliveryCharges(deliveryCharges);
			cart.setDiscount(discountAmount);
			cart.setPaidAmount(amountPaid);
			cart.setTotalAmount(totalAmount);
			cart.setProductsCount(productsCount);
			c.setMyCart(cart);
			request.getSession().setAttribute("customerCart", c.getMyCart());
			request.getRequestDispatcher("views/customer/cart.jsp").forward(request, response);
//			System.out.println("Cart id : "+c.getMyCart().getCart_id());
//			System.out.println("Customer id : "+c.getCustomerId());
//			List<Product> cartProduct = cartDAO.getCustomerCart(c);
//			Cart cart = c.getMyCart();
//			cart.setMyCart(cartProduct);
//			c.setMyCart(cart);
//			cartProduct = c.getMyCart().getMyCart();
//			System.out.println("Cart id : "+c.getMyCart().getCart_id());
			cartProduct.stream().forEach(p->System.out.println(p.getProductId()));
		}
	}

}
