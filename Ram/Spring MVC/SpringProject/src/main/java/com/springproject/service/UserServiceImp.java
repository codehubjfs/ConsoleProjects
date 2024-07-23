package com.springproject.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.mapper.UserMapper;
import com.springproject.model.Booking;
import com.springproject.model.Contact;
import com.springproject.model.LoginRegister;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.User;
@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean validateUser(String email, String password) {
		return userMapper.validateUser(email, password) != null;
	}

	@Override
	public void registerUser(LoginRegister user) {
		userMapper.registerUser(user);
		
		
	}
	 @Override
	    public boolean emailExists(String email) {
	        return userMapper.emailExists(email) > 0;
	    }

	@Override
	public List<RoomType> getAllRoomTypes(String roomName) {
		 return userMapper.getAllRoomTypes(roomName);
	}

	@Override
	public List<String> getAvailableRooms(String roomName) {
		return userMapper.getAvailableRooms(roomName);
	}

	@Override
	public int getRentByRoomName(String roomName) {
		return userMapper.getRentByRoomName(roomName);
	}

	@Override
	public void insertBooking(Booking booking) {
		 userMapper.insertBooking(booking);
		
	}

	@Override
	public int getLastInsertedBookingId(String customerName, String phoneNo) {
		return userMapper.getLastInsertedBookingId(customerName, phoneNo);
	}

	@Override
	public void insertPayment(Payment payment) {
		userMapper.insertPayment(payment);
		
	}

	@Override
	public void updateBookingStatus(int bookingId, String status) {
		 userMapper.updateBookingStatus(bookingId, status);
		
	}

	@Override
	public int getTypeIdByRoomName(String roomName) {
		return userMapper.getTypeIdByRoomName(roomName);
	}

	@Override
	 public void updateRoomStatus(int typeId, int roomId) {
        userMapper.updateRoomStatus(typeId, roomId);
    }

	@Override
	public User getUserDetailsByEmail(String email) {
		return userMapper.getUserDetailsByEmail(email);
		
	}

	@Override
	public List<Booking> getBookingsByPhone(String phone) {
		return userMapper.getBookingsByPhone(phone);
	}


	@Override
	public void cancelBooking(int bookingId) {
		userMapper.cancelBooking(bookingId);
		
	}

	@Override
	public void updateStatus(int bookingId) {
		userMapper.updateStatus(bookingId);
		
		
	}

	@Override
	public void updateBooking(int bookingId, String customerName, String gender, int room, Date checkIn, Date checkOut,
			String phoneNo) {
		userMapper.updateBooking(bookingId, customerName, gender, room, checkIn, checkOut, phoneNo);
		
	}

	@Override
	public boolean insertContact(Contact contact) {
		return userMapper.insertContact(contact);
	}

	
	 
	
	
}
