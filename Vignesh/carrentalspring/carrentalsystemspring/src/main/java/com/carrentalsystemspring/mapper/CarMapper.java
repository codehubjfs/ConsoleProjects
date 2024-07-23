package com.carrentalsystemspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.Payment;
import com.carrentalsystemspring.model.RentalPackage;
import com.carrentalsystemspring.model.User;

@Mapper
public interface CarMapper {
	     //get all car
	    @Select("SELECT * FROM CAR")
	    List<Car> getCars();
	     
	    //get the userdetails
	    @Select("SELECT * FROM users WHERE username = #{username}")
	    User getUserByUsername(String username);
	    
	    //for check the username and password
	    @Select("SELECT * FROM USERS WHERE USERNAME = #{username} AND PASSWORD = #{password}")
	    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	    
	    
	    //register the new user
	    @Insert("INSERT INTO users (first_name, last_name, email, gender, phone_number, username, password) " +
	            "VALUES (#{first_name}, #{last_name}, #{email}, #{gender}, #{phone_number}, #{username}, #{password})")
	    void insertUser(User user);
	    
	    
	    //get the cars by cartype
	    @Select("SELECT * FROM cars WHERE car_type = #{car_type}")
	    List<Car> getCarsByType(String carType);
	    
	    //get the rental packages by duration
	    @Select("SELECT * FROM rental_package WHERE duration = #{duration}")
	    List<RentalPackage> getPackagesByDuration(String duration);
	    
	    //for get all booking details
	    @Select("SELECT booking_id, start_date , end_date , " +
	            "booking_status , car_name , user_name , rental_rate  " +
	            "FROM booking ORDER BY start_date DESC")
	    List<Booking> getAllBookings();
	    
	    //get the booking details of particular user
	    @Select("SELECT booking_id , start_date, end_date , " +
	            "booking_status , car_name , user_name , rental_rate  " +
	            "FROM bookings WHERE user_name = #{user_name} ORDER BY start_date DESC")
	    List<Booking> getBookingsByUsername(String username);
	    
	    
	    
	    
	    
	    @Select("SELECT COUNT(*) FROM cars")
	    int getTotalCars();

	    @Select("SELECT COUNT(*) FROM bookings")
	    int getTotalBookings();

	   
	    
	    @Select("SELECT COUNT(*) FROM users")
	    int getTotalCustomers();
	    
	    
	    
	    @Select("SELECT * FROM cars WHERE car_id = #{car_id}")
	    Car getCarById(@Param("car_id") Long carId);
	    
	    
	    @Insert("INSERT INTO bookings (user_name, car_name, start_date, end_date, rental_rate,booking_status) VALUES (#{user_name}, #{car_name}, #{start_date}, #{end_date}, #{rental_rate} ,'completed')")
	    void insertBooking(Booking booking);
	    
	    
	    
	    @Insert("INSERT INTO payments ( username, carname, cardholder_name, card_number, card_type, exp_date, cvv, created_at) " +
	            "VALUES ( #{username}, #{carname}, #{cardholder_name}, #{cardNumber}, #{cardType}, #{expDate}, #{cvv}, #{createdAt})")
	    void insert(Payment payment);
	    
	    
	    
}
  