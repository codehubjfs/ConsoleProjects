package com.springproject.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springproject.model.Booking;
import com.springproject.model.Contact;
import com.springproject.model.LoginRegister;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.User;

public interface UserService  {
	//LOGIN USER
	boolean validateUser(String email, String password);
	
	//REGISTER USER
	void registerUser(LoginRegister user);
	 boolean emailExists(String email);
	
	//Room Management :
	List<RoomType> getAllRoomTypes(String roomName);
	
	//Booking Form :
	List<String> getAvailableRooms(String roomName);


	//GET RENT :
int getRentByRoomName(String roomName);
	
	//Bookings :
	void insertBooking(Booking booking);
	int getLastInsertedBookingId(String customerName, String phoneNo);
	
	//PAYMENTS:
	void insertPayment(Payment payment);
    void updateBookingStatus(int bookingId, String status);
	
    int getTypeIdByRoomName(String roomName);
    void updateRoomStatus(int typeId, int roomId);
    
    //PROFILE MANAGEMENT :
    User getUserDetailsByEmail(String email);
    List<Booking> getBookingsByPhone(String phone);
    
    //PROFILE >> MODIFY DATES:
    
    void updateBooking(int bookingId, String customerName, String gender, int room, Date checkIn, Date checkOut, String phoneNo);
    
    void updateStatus(int bookingId);
    void cancelBooking(int bookingId); 
    
   //REFER 
    boolean insertContact(Contact contact);
    
}