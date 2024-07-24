package com.hallbookingmanagement.service;

import java.util.HashMap;
import java.util.List;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.beans.Payment;
import com.hallbookingmanagement.beans.WebContactDetails;

import jakarta.servlet.http.HttpServletRequest;

public interface AdminServices {
	HashMap<String,String> viewDashboardDetail();
	List<Booking> listBooking(); 
	List<Customer> listCustomer();
	List<Payment> viewPaymentList();
	boolean validateAdmin(String name, String password, HttpServletRequest request);
	Customer changeCustomerStatus(int userId, String status);
	List<Hall> showAllHalls();
	boolean deleteHall(int bookId);
	boolean addHallAndProperties(String name, String isAc, double price, int capacity, 
			String location, String locationLink, String[] amenities, String[] events,
			int theater, int cluster, int banquet, int uShaped, int hallowSquare,
			int cabaretStyle);
	Booking checkConflict(int bookId);
	Booking changeBookingStatus(String status, int bookId);
	void changeBooking(int currentBooking, int changeBookId, HttpServletRequest request);
	WebContactDetails getWebDetails();
	
	Hall updateHall(int hallId, String hallName, int capacity, double price, String location, String locationLink);
}
