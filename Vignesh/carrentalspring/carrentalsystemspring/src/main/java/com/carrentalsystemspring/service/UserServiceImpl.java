package com.carrentalsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystemspring.mapper.CarMapper;
import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.Payment;
import com.carrentalsystemspring.model.RentalPackage;
import com.carrentalsystemspring.model.User;

@Service
public class UserServiceImpl implements UserService{
	 private final CarMapper userMapper;
        
	    @Autowired
	    public UserServiceImpl(CarMapper userMapper) {
	        this.userMapper = userMapper;
	    }

	    @Override
	    public User getUserByUsername(String username) {
	        return userMapper.getUserByUsername(username);
	    }

	    @Override
	    public User getUserByUsernameAndPassword(String username, String password) {
	        return userMapper.findByUsernameAndPassword(username, password);
	    }
	    
	    @Override
	    public void registerUser(User user) {
	    	
	    		System.out.println("sql");
	        userMapper.insertUser(user);
	    	
	    		System.out.println("errorinsert");
	    		System.out.print(user.toString());
	    		//System.out.println(e.getMessage());
	    	
	    }
	    
	    @Override
	    public List<Car> getCarsByType(String carType) {
	    	System.out.println("service impl");
	        return userMapper.getCarsByType(carType);
	    }
	    
	    
	    @Override
	    public List<RentalPackage> getPackagesByDuration(String duration) {
	        return userMapper.getPackagesByDuration(duration);
	    }
	    
	    
	    @Override
	    public List<Booking> getAllBookings() {
	        return userMapper.getAllBookings();
	    }
	    
	    @Override
	    public List<Booking> getBookingsByUsername(String username) {
	        return userMapper.getBookingsByUsername(username);
	    }
	    
	    

	    @Override
	    public int getTotalCars() {
	        return userMapper.getTotalCars();
	    }

	    @Override
	    public int getTotalBookings() {
	        return userMapper.getTotalBookings();
	    }

		

		@Override
		public int getTotalCustomers() {
			// TODO Auto-generated method stub
			return userMapper.getTotalCustomers();
		}

		@Override
		public Car getCarById(Long carId) {
			return userMapper.getCarById(carId);
		}
		
		 @Override
		    public void createBooking(Booking booking) {
		        userMapper.insertBooking(booking);
		    }
      
		 
		   @Override
		    public void insertPayment(Payment payment) {
		        userMapper.insert(payment);
		    }
	   
}
