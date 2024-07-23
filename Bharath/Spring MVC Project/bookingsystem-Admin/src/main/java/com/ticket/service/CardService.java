package com.ticket.service;

import java.util.List;

import com.ticket.model.BookingBean;
import com.ticket.model.Bus;
import com.ticket.model.Customer;
import com.ticket.model.RoutesBean;

public interface CardService {
	 List<Customer> viewCustomer();
	List<RoutesBean> getAllRoutes();
	List<Bus> getAllBus();
	List<BookingBean> getAllBooking();
	
}
