package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.beans.Payment;
import com.hallbookingmanagement.dao.BookDAO;
import com.hallbookingmanagement.dao.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaymentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Booking userBooking;
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			System.out.println("Customer "+ customer);
			if(customer==null) {
				System.out.println("I'm in null");
			}
			int userId = customer.getUserId();
			List<Booking> bookingList;
			try {
				bookingList = new BookDAO().getAll().stream().filter(b->b.getCustomer().getUserId()==userId).collect(Collectors.toList());
				System.out.println(bookingList);
				System.out.println();
				List<Payment> paymentList = new PaymentDAO().getAll();
				List<Payment> userPaymentList = paymentList.stream()
					    .filter(payment -> bookingList.stream()
					        .anyMatch(booking -> payment.getBook().getBookingId() == booking.getBookingId()))
					    .collect(Collectors.toList());
				request.setAttribute("PaymentList", userPaymentList);
				System.out.print("Payment List"+userPaymentList);
				request.getRequestDispatcher("view/MyBooking.jsp").forward(request, response);
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
