package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.dao.BookDAO;
import com.hallbookingmanagement.dao.BookingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentGatewayServlet
 */
public class PaymentGatewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaymentGatewayServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int bookId = Integer.parseInt(request.getParameter("bookingID"));
		 try {
			Booking booking = new BookingDAO().getAll().stream().filter(x->x.getBookingId()==bookId).findFirst().orElse(null);
			request.setAttribute("booking", booking);
			long numberOfDays = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
			long totalDays = numberOfDays * (long) booking.getHall().getPrice();
			request.setAttribute("totalPayment", totalDays);
			request.setAttribute("numberOfDays",numberOfDays);
			request.getRequestDispatcher("view/PaymentPage.jsp").forward(request, response);
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
