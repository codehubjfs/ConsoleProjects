package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.bean.Booking;
import com.hotelmanagement.bean.Room;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.RoomDAO;
import com.hotelmanagement.dao.RoomTypeDao;
import com.hotelmanagement.utilities.DbUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookingServlet() {
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
		String customerName = request.getParameter("customerName");
        String gender = request.getParameter("gender");
        String room = request.getParameter("roomNumber");
        String checkInDate = request.getParameter("checkinDate");
        String checkOutDate = request.getParameter("checkoutDate");
        String phoneNo = request.getParameter("phoneNo");
        String roomName = request.getParameter("roomName");
        int noDay = Integer.parseInt(request.getParameter("daysStayed"));
           
        Booking booking = new Booking();
        booking.setCustomerName(customerName);
        booking.setGender(gender);
        booking.setRoom(room);
        booking.setCheckIn(java.sql.Date.valueOf(checkInDate));
        booking.setCheckOut(java.sql.Date.valueOf(checkOutDate));
        booking.setPhoneNo(phoneNo);
        booking.setBookingStatus("Pending");
       
      
        String query = "SELECT RENT FROM rt WHERE ROOM_NAME = ?";
        try 
       {
        	 Connection conn = DbUtil.openConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, roomName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	int roomRent = rs.getInt("RENT");
                booking.setRent(roomRent*noDay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        BookingDao bookingDAO = new BookingDao();

        try {
            // Insert booking information
            bookingDAO.insertBooking(booking);
            
            // Store booking in session
            HttpSession session = request.getSession();
            session.setAttribute("booking", booking);
            System.out.println("BOOKING ID : "+booking.getId());
            // Redirect to payment page
            response.sendRedirect("views/user/payment.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred during the booking process.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
//        // Store booking information in session to be used after payment
//        request.getSession().setAttribute("booking", booking);
//
//        // Redirect to payment page
//        response.sendRedirect("views/user/payment.jsp");

	}
	
}
