package com.bus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bus.model.Booking;
import com.bus.model.Bus;
import com.bus.model.CustomersNew;
import com.bus.model.Routes;
import com.bus.service.BookingService;
import com.bus.service.BusService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping("/bookSeat")
	public ModelAndView bookSeat(@RequestParam("customerid") int customerId, @RequestParam("busid") int busid,
			@RequestParam("routeid") int routeId, @RequestParam("boardingPoint") String boardingPoint,
			@RequestParam("droppingPoint") String droppingPoint,
			@RequestParam("selectedSeats") List<Integer> selectedSeats, @RequestParam("totalPrice") double totalPrice,
			@RequestParam("bookingStatus") String bookingStatus, ModelAndView model, HttpServletRequest request) {
		
		System.out.println("Received parameters:");
		System.out.println("customerId:" + customerId);
		System.out.println("Bus ID: " + busid);
		System.out.println("Route ID: " + routeId);
		System.out.println("Boarding Point: " + boardingPoint);
		System.out.println("Dropping Point: " + droppingPoint);
		System.out.println("Total Price: " + totalPrice);
		System.out.println("Booking Status: " + bookingStatus);

		Booking book = new Booking();

		
		Routes routes = new Routes();
		routes.setIndex(routeId);
		
		Bus buses = bookingService.getAllBus().stream().filter(x -> x.getBusid() == busid).findFirst().orElse(null);
		CustomersNew customer= (CustomersNew) request.getSession().getAttribute("customersNew");
		List<Booking> bookingList = new ArrayList<>();
		System.out.println("Selected Seats:"+selectedSeats);
		for (int seat : selectedSeats) {
			book.setCustomer(customer);
			book.setBus(buses);
			book.setRoute(routes);
			book.setBoardingPoint(boardingPoint);
			book.setDroppingPoint(droppingPoint);
			book.setTotalPrice(totalPrice);
			book.setSelectedSeats(seat);
			book.setBus(buses);
			bookingList.add(book);
		}
	
		bookingList=bookingService.bookSeats(customerId, busid, routeId, boardingPoint, droppingPoint, selectedSeats, totalPrice, bookingStatus);
		model.addObject("selectedSeats",selectedSeats.toString());
		request.getSession().setAttribute("Listofbookings", bookingList);
		System.out.println("----");
		System.out.println("why \n"+bookingList);
		System.out.println("-----");
		model.setViewName("redirect:/payment");
		return model;
		}
 
	  @RequestMapping("/CancelSeat")
	    public ModelAndView cancelBooking(@RequestParam("bookingId") int bookingId, ModelAndView model, HttpServletRequest request) {
	        bookingService.cancelBooking(bookingId);
	        
	       
	        HttpSession session = request.getSession();
	        @SuppressWarnings("unchecked")
	        List<Booking> bookingList = (List<Booking>) session.getAttribute("Listofbookings");

	       
	        if (bookingList != null) {
	            bookingList.removeIf(booking -> booking.getBookingid() == bookingId);
	        }

	       
	        session.setAttribute("Listofbookings", bookingList);

	       
	        model.setViewName("redirect:/viewBookings");
	        return model;
	    }
	   @RequestMapping("/ViewBooking")
	    public ModelAndView viewBooking(@RequestParam("bookingId") int bookingId, ModelAndView model) {
	        
	       
	        Booking booking = bookingService.getBookingById(bookingId);
	        
	       
	        if (booking != null) {
	        	System.out.println("success");
	            model.addObject("booking", booking);
	            model.setViewName("Customer/bookingDetails"); 
	        } else {
	            model.addObject("error", "Booking not found for ID: " + bookingId);
	            model.setViewName("errorPage");
	        }

	        return model;
	    }

	}

	