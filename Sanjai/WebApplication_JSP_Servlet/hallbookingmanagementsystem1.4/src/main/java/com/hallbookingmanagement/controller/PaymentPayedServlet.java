package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Payment;
import com.hallbookingmanagement.dao.BookingDAO;
import com.hallbookingmanagement.dao.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentPayedServlet
 */
public class PaymentPayedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaymentPayedServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paymentNum = Integer.parseInt(request.getParameter("paytype"));
		String paymentStatus = paymentNum==1?"ADVANCED":"PAID";
		int bookID = Integer.parseInt(request.getParameter("paybookId"));
		double paidAmount = Double.parseDouble(request.getParameter("totpay"));
		Booking book = new Booking();
		book.setBookingId(bookID);
		book.setBookStatus("CONFIRMED");
		Payment payment = new Payment();
		Booking payBooking;
		try {
			BookingDAO bookingDao =  new BookingDAO();
			payBooking =bookingDao.getAll().stream().filter(x->x.getBookingId()==bookID).findFirst().orElse(null);
			
			payment.setBook(payBooking);
			payment.setPaymentTime(LocalDateTime.now());
			payment.setPaidStatus(paymentStatus);
			payment.setPrice(paidAmount);
			
			bookingDao.update(payBooking);
			bookingDao.blockOtherBooking(payBooking);

			boolean isPaymentAdded = new PaymentDAO().add(payment);
			if(isPaymentAdded) {
				System.out.println("Payment Added Successfully");
				request.getRequestDispatcher("PaymentServlet").forward(request, response);
			}
			else {
				System.out.println("Payment Not added");
			}
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
