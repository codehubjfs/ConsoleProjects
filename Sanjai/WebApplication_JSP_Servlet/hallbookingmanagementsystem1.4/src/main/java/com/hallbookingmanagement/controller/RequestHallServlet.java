package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.beans.Event;
import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.beans.Seats;
import com.hallbookingmanagement.dao.BookDAO;
import com.hallbookingmanagement.dao.EventDAO;

import jakarta.mail.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHallServlet
 */
public class RequestHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RequestHallServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event = request.getParameter("event");
		String seat = request.getParameter("seat");
		LocalDate bookedDate = LocalDate.parse(request.getParameter("bookedDate")) ;
		System.out.println("booked-Date"+ bookedDate);
		int numberDay = Integer.parseInt(request.getParameter("numberDay"));
		Hall hall = (Hall)request.getSession().getAttribute("hallDetail");
		int hallid = hall.getHallId();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		int userId = customer.getUserId();
		int bookedEvent = hall.getEvents().stream().filter(x->x.getEventName().equals(event)).findFirst().orElse(null).getEventId();
		int bookedSeat = hall.getSeat().stream().filter(x->x.getArrangementType().equals(seat)).findFirst().orElse(null).getSeatId();
		Seats seatObj = new Seats();
		Event eventObj = new Event();
		seatObj.setSeatId(bookedSeat);
		eventObj.setEventId(bookedEvent);
		HashSet<Seats> seatSet = new HashSet<>();
		seatSet.add(seatObj);
		HashSet<Event> eventSet = new HashSet<>();
		eventSet.add(eventObj);
		Hall hallObj = new Hall();
		hallObj.setHallId(hallid);
		hallObj.setEvents(eventSet);
		hallObj.setSeat(seatSet);
		Booking booking = new Booking();
		booking.setCustomer(customer);
		booking.setHall(hallObj);
		booking.setStartDate(bookedDate);
		booking.setEndDate(bookedDate.plusDays(numberDay));
		booking.setRequestedTime(LocalDateTime.now());
		try {
			boolean isAdded = new BookDAO().add(booking);
			if(isAdded) {
				System.out.print("Added Successfully");
				request.getRequestDispatcher("MyRequestsServlet").forward(request, response);;
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
	}

}
