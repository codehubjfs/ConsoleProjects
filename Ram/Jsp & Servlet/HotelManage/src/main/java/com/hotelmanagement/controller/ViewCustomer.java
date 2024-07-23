package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hotelmanagement.bean.Customer;
import com.hotelmanagement.dao.ViewCustomers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ViewCustomer
 */
public class ViewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ViewCustomers customerDAO;

	    public void init() {
	        customerDAO = new ViewCustomers();
	    }

    public ViewCustomer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
            listCustomers(request, response);
        
	}

	 private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        response.setHeader("Expires", "0");
	        
	        if(request.getSession().getAttribute("username")==null)
	        {
	        	response.sendRedirect("LogoutAdminServlet");
	        }
	        if(request.getSession().getAttribute("username")!=null)
	        {
	        	List<Customer> customers = null;
				try {
					customers = customerDAO.getAllCustomers();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("customers", customers);
				request.getRequestDispatcher("views/admin/adminCustomer.jsp").forward(request, response);
	        }
		 
	    }
	  private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String customerIdString = request.getParameter("customerId");

	        try {
	            int customerId = Integer.parseInt(customerIdString);
	            Customer customer = customerDAO.getCustomerById(customerId);
	            request.setAttribute("customer", customer);
	            request.getRequestDispatcher("views/admin/adminCustomer.jsp").forward(request, response);
	        } catch (NumberFormatException e) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Customer ID must be a valid integer.");
	        } catch (Exception e) {
	            throw new ServletException(e);
	        }
	  }
		  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
