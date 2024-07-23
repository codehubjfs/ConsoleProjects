package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.letsbuy.beans.Customer;
import com.letsbuy.dao.CustomerDAO;

/**
 * Servlet implementation class CustomerUsernameDataController
 */
public class CustomerUsernameDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO l = new CustomerDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUsernameDataController() {
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
		List<Customer> customers = l.getAllCustomers();   
		// TODO Auto-generated method stub
		List<String> usernames = (List<String>) customers.stream()
				.map(c->c.getAccount().getUserName())
				.collect(Collectors.toList());
		 String json = new Gson().toJson(usernames);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	}

}
