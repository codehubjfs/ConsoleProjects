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
import java.util.Map;
import java.util.stream.Collectors;

import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Login;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.CartDAO;
import com.letsbuy.dao.CustomerDAO;
import com.letsbuy.dao.RegisterDAO;

/**
 * Servlet implementation class CustomerLoginController
 */

public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CustomerDAO l = new CustomerDAO();
    private CartDAO cartDAO = new CartDAO();
	private static List<Customer> customers ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginController() {
        super();
//        System.out.println("I m in ");        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long mobileNumber = Long.parseLong(request.getParameter("mobile_no").trim());
		String password = request.getParameter("password");
		customers = l.getAllCustomers();
		if(request.getAttribute("customers")!=null) {
			customers = (List<Customer>) request.getAttribute("customers");
			System.out.println("Data retrieved");
		}
		
		Login login = new Login();
		login.setMobileNumber(mobileNumber);
		login.setPassword(password);
		System.out.println(mobileNumber);
		System.out.println(password);
		customers.stream().forEach(x->System.out.println(x.getMobileNumber()+" "+x.getAccount().getPassword()));
		
		boolean isValid = false;
		Customer customer = null;
		
		isValid = customers.stream().anyMatch(c->c.getAccount().getPassword().equals(login.getPassword()) && c.getMobileNumber()==login.getMobileNumber());
		
		System.out.println(isValid);
	
		
		if(isValid) {
			List<Customer> filtered = customers.stream().filter(c->c.getAccount().getPassword().equals(login.getPassword()) && c.getMobileNumber()==login.getMobileNumber()).collect(Collectors.toList());
			customer = filtered.get(0);
			if(customer.getAccount().getAccountStatus().equals("DELETED")) {			
				System.out.println("Deleted Account : "+customer.getFirstName());
				request.setAttribute("statusmessage", "Account Deleted");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/login.jsp");
				requestDispatcher.forward(request, response);
								
			}else if(customer.getAccount().getAccountStatus().equals("BLOCKED")) {
				System.out.println("Deleted Account : "+customer.getFirstName());
				request.setAttribute("statusmessage", "Account Blocked");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/login.jsp");
				requestDispatcher.forward(request, response);
			}else {
				System.out.println("Cart id : "+customer.getMyCart().getCart_id());
				System.out.println("Customer id : "+customer.getCustomerId());
				List<Product> cartProduct = cartDAO.getCustomerCart(customer);
				Cart cart = customer.getMyCart();
				Map<Integer,Product> customerCart =  cartProduct.stream().collect(Collectors.toMap(p->p.getProductId(), p->p));
				cart.setMyCart(customerCart);
				customer.setMyCart(cart);
				cartProduct = customer.getMyCart().getMyCart().values().stream().collect(Collectors.toList());
				System.out.println("Cart id : "+customer.getMyCart().getCart_id());
				cartProduct.stream().forEach(p->System.out.println(p.getProductId()));
				request.getSession().setAttribute("user", customer);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("statusmessage", "Invalid Username or Password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
