package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.dao.BookingDAO;

import jakarta.mail.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyRequestsServlet
 */
public class MyRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyRequestsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int userId = customer.getUserId();
		try {
			List<Booking> bookingList = new BookingDAO().getAll().stream().filter(x->x.getCustomer().getUserId()==userId).collect(Collectors.toList());
			request.setAttribute("bookList", bookingList);
			System.out.println(bookingList);
			request.getRequestDispatcher("view/MyRequest.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
