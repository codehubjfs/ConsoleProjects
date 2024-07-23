package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.hotelmanagement.bean.Booking;
import com.hotelmanagement.bean.Payment;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.PaymentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String paymentMethod = request.getParameter("paymentMethod");
	        HttpSession session = request.getSession();
	        Booking booking = (Booking) session.getAttribute("booking");

	        if (booking == null) {
	            response.sendRedirect("index.jsp");
	            return;
	        }

	        BookingDao bookingDAO = new BookingDao();
	        PaymentDao paymentDAO = new PaymentDao();
	        try {
	            // Get payment details from the request
	            double amount = Double.parseDouble(request.getParameter("amount"));
	            String cardNumber = request.getParameter("cardNumber");
	            String expiryDate = request.getParameter("expiryDate");
	            String cvv = request.getParameter("cvv");
	            String cardName = request.getParameter("cardName");
	            int bookingId = Integer.parseInt(request.getParameter("bookingId"));

	            // Fetch room rent and update the booking object
	            int roomRent = bookingDAO.getRoomRent(booking.getRoom());
	            System.out.println("RENT : "+roomRent);
	            booking.setRent(roomRent);
	            System.out.println("BOoking ID : "+bookingId);
	            // Create payment record
	            Payment payment = new Payment();
	            payment.setBookingId(bookingId);
	            payment.setPaymentAmt(amount);
	            payment.setPaymentDate(java.sql.Date.valueOf(LocalDate.now()));
	            payment.setPaymentMethod(paymentMethod);
	            payment.setPaymentStatus("Paid");

	            // Insert payment information
	            paymentDAO.insertPayment(payment);

	            // Update booking status to 'Booked'
	            bookingDAO.updateBookingStatus(bookingId, "Booked");
                
	            
	            // Update room status to 'Booked'
//	            bookingDAO.updateRoomStatus(booking.getRoom().getRoomId(), "Booked");
	            
	            // Remove booking from session
	            session.removeAttribute("booking");

	            // Redirect to index page with success message
	            request.setAttribute("message", "Booking and payment were successful!");
	            response.sendRedirect("views/user/room.jsp");
//	            request.getRequestDispatcher("views/user/room.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "An error occurred during the booking or payment process.");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
	    }
	}


