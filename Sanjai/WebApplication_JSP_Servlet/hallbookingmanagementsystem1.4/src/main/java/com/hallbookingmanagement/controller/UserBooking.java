package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.dao.BookingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserBooking
 */
public class UserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserBooking() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Customer customer = (Customer) request.getSession().getAttribute("customer");
			int userId = customer.getUserId();
			List<Booking> bookList = new BookingDAO().getAll().stream().filter(x->x.getCustomer().getUserId()==userId).toList();
			request.setAttribute("bookingList", bookList);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
