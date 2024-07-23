package com.carrentalsystemspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.User;

public interface AdminMapper {
	@Select("SELECT COUNT(*) FROM users")
    long countUsers();
	
	
	@Select("SELECT COUNT(*) FROM cars")
    long countCars();
	
	
	@Select("SELECT COUNT(*) FROM bookings")
    long countBookings();
	
	 @Select("SELECT AVAILABLE FROM cars WHERE VEHICLE_NO = #{vehicleNo}")
	    String getCarAvailability(@Param("vehicleNo") String vehicleNo);

	    default boolean isCarAvailable(String vehicleNo) {
	        return "yes".equals(getCarAvailability(vehicleNo));
	    }
	    
	    
	    @Select("SELECT * FROM CAR WHERE CAR_ID = #{id}")
	    Car getCarById(@Param("id") Long id);

	    // Add a new car
	    @Insert("INSERT INTO CARS (CAR_NAME, VEHICLE_NO, AVAILABLE, RENTAL_RATE, SEAT_COUNT, FUEL_TYPE, CAR_TYPE, BAGS, CAR_IMAGE_URL) " +
	            "VALUES (#{car_name}, #{vehicle_no}, #{available}, #{rental_rate}, #{seat_count}, #{fuel_type}, #{car_type}, #{bags}, #{car_image_url})")	    
	    void addCar(Car car);

	    // Update an existing car
	    @Update("UPDATE CARS SET CAR_NAME = #{car_name}, VEHICLE_NO = #{vehicle_no}, AVAILABLE = #{available}, RENTAL_RATE = #{rental_rate}, SEAT_COUNT = #{seat_count}, " +
	            "FUEL_TYPE = #{fuel_type}, CAR_TYPE = #{car_type}, BAGS = #{bags}, CAR_IMAGE_URL = #{car_image_url} WHERE CAR_ID = #{car_id}")
	    void updateCar(Car car);

	    // Delete a car by ID
	    @Delete("DELETE FROM CARS WHERE car_id = #{car_id}")
	    void deleteCar(@Param("car_id") int car_id);

	    // Find cars by car type
	    @Select("SELECT * FROM CAR WHERE CAR_TYPE LIKE CONCAT('%', #{type}, '%')")
	    List<Car> findCarsByType(@Param("type") String type);
	    
	    
	    
	    @Select("SELECT * FROM cars")
	    List<Car> getAllCars();
	    
	    @Select("SELECT * FROM bookings")
	    List<Booking> getAllBookings();
	    
	    
	    @Select("SELECT * FROM users")
	    List<User> getAllCustomers();
	    
	    
	    @Select("SELECT * FROM bookings")
	    List<Booking> selectAllBookings();

	    @Update("UPDATE Bookings SET booking_status = #{booking_status} WHERE booking_id = #{booking_id}")
	    void updateBookingStatus(@Param("booking_id") int bookingId, @Param("booking_status") String bookingStatus);

	    @Delete("DELETE FROM bookings WHERE booking_id = #{booking_id}")
	    void deleteBooking(int bookingId);
	    
	    
	    @Select("SELECT * FROM users WHERE user_id = #{user_id}")
	    User getUserById(@Param("userId") int userId);

	    @Update("UPDATE users SET account_status = #{accountStatus} WHERE user_id = #{user_id}")
	    void updateUserStatus(@Param("user_id") int user_id, @Param("accountStatus") String accountStatus);


	    @Delete("DELETE FROM users WHERE user_id = #{userId}")
	    void deleteUser(@Param("userId") int userId);
	    
	    
}
