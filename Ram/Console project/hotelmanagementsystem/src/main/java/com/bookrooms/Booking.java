package com.bookrooms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.person.Customer;
import com.room.Room;

import oracle.ons.Connection;

import com.person.*;
public class Booking {
	 
	    private int booking_id;
	    private int customer_id;
	    private int room_no;
	    private String checkIn;
	    private String checkOut;
	    private String bookingStatus;
		public Booking(int booking_id, int customer_id, int room_no, String checkIn, String checkOut,
				String bookingStatus) {
			super();
			this.booking_id = booking_id;
			this.customer_id = customer_id;
			this.room_no = room_no;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			this.bookingStatus = bookingStatus;
		}
		public Booking(int customer_id, String checkIn, String checkOut, int room_no) {
	        this.customer_id = customer_id;
	        this.checkIn = checkIn;
	        this.checkOut = checkOut;
	        this.room_no = room_no;
	    }

		public Booking()
		{
			
		}
		public int getBooking_id() {
			return booking_id;
		}
		public void setBooking_id(int booking_id) {
			this.booking_id = booking_id;
		}
		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
		public int getRoom_no() {
			return room_no;
		}
		public void setRoom_no(int room_no) {
			this.room_no = room_no;
		}
		public String getCheckIn() {
			return checkIn;
		}
		public void setCheckIn(String checkIn) {
			this.checkIn = checkIn;
		}
		public String getCheckOut() {
			return checkOut;
		}
		public void setCheckOut(String checkOut) {
			this.checkOut = checkOut;
		}
		public String getBookingStatus() {
			return bookingStatus;
		}
		public void setBookingStatus(String bookingStatus) {
			this.bookingStatus = bookingStatus;
		}
		public Customer getCustomer() {
			// TODO Auto-generated method stub
			return null;
		}
	   
	    
		
	    
	    
}
