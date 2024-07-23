package com.carrentalsystemspring.service;

import java.util.List;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.Payment;
import com.carrentalsystemspring.model.RentalPackage;
import com.carrentalsystemspring.model.User;

public interface UserService {
	User getUserByUsernameAndPassword(String username, String password); //login
	void registerUser(User user); //register
	User getUserByUsername(String username); //get user details by useranme
	List<Car> getCarsByType(String carType); //get the cars by cartype 
	List<RentalPackage> getPackagesByDuration(String duration);  //get the rentalpackage by duration
	 List<Booking> getAllBookings(); // to get all booking
	 List<Booking> getBookingsByUsername(String username); //get booking of particular user
	 
	 

	    int getTotalCars();

	    int getTotalBookings();

	 
	    
	    int getTotalCustomers();
	    Car getCarById(Long carId);
	    
	    void createBooking(Booking booking);
	    
	    void insertPayment(Payment payment);

	   
}
