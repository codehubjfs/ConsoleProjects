package com.carrentalsystemspring.service;

import java.util.List;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.User;

public interface AdminService {
	    long getTotalUsers();
	    long getTotalCars();
	    long getTotalRented();
	    
	    boolean isCarAvailable(String vehicleNo, String date, String time);
	    
	    void addCar(Car car);

	    // Update an existing car
	    void updateCar(Car car);

	    // Delete a car by ID
	    void deleteCar(int car_id);
	    
	    List<Car> getAllCars();
	    
	   
	    
	    List<User> getAllCustomers();
	    
	    
	    List<Booking> getAllBookings();
	    void updateBookingStatus(int bookingId, String bookingStatus);
	    void deleteBooking(int bookingId);
	    
	    
	    User getUserById(int userId);
	    void updateUserStatus(int user_id, String accountStatus);
	    void deleteUser(int userId);
	}


