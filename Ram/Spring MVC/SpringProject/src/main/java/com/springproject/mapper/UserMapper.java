package com.springproject.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.model.Booking;
import com.springproject.model.Contact;
import com.springproject.model.LoginRegister;
import com.springproject.model.LoginUser;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.User;

@Mapper
public interface UserMapper {
	//LOGIN USER
	@Select("select * from users where email = #{email} and password = #{password}")
	LoginUser  validateUser(@Param("email") String email, @Param("password") String password);
		
	//REGISTER USER
	  @Insert("INSERT INTO users (id, first_name, last_name, age, gender, phone, address, state, email, password) VALUES (users_seq.nextval, #{first_name}, #{last_name}, #{age}, #{gender}, #{phone}, #{address}, #{state}, #{email}, #{password})")
	    void registerUser(LoginRegister user);
	  @Select("SELECT COUNT(*) FROM users WHERE email = #{email}")
	    int emailExists(String email);
	  //ROOM MANAGEMENT 
	  @Select("SELECT * FROM rt where room_name=#{roomName}")
	    List<RoomType> getAllRoomTypes(@Param("roomName") String roomName);
	  
	    @Select("SELECT ar.*, rt.room_name " +
	            "FROM allroom ar " +
	            "JOIN rt ON ar.type_id = rt.type_id " +
	            "WHERE ar.type_id = #{typeId}")
	    List<Room> getRoomsByTypeId(int typeId);
	    
	    
	    //BOOKING FORM
//	    @Select("SELECT ar.room_id " +
//	            "FROM allroom ar " +
//	            "JOIN rt ON ar.type_id = rt.type_id " +
//	            "WHERE ar.type_id = #{typeId} " +
//	            "AND ar.room_status = 'Available'")
//	    List<String> getAvailableRooms(@Param("typeId") int typeId);
	    @Select("SELECT room_id FROM allroom WHERE type_id = (SELECT type_id FROM rt WHERE room_name = #{roomName}) AND room_status = 'Available'")
	    List<String> getAvailableRooms(@Param("roomName") String roomName);
	   
	    //GET RENT :
	    @Select("select rent from rt where room_name = #{roomName}")
	    int getRentByRoomName(String roomName);
	    
	    //BOOKING INSERTIONS :
	  
	    @Insert("INSERT INTO bookings (id, customer_name, gender, room, check_in, check_out, booking_status, phone_no) " +
	            "VALUES (book_id.nextval, #{customer_name}, #{gender}, #{room}, #{check_in}, #{check_out}, #{booking_status}, #{phoneNo})")
	    void insertBooking(Booking booking);

	    @Select("SELECT id FROM (SELECT id FROM bookings WHERE customer_name = #{customerName} AND phone_no = #{phoneNo} ORDER BY id DESC) WHERE ROWNUM = 1")
	    int getLastInsertedBookingId(@Param("customerName") String customerName, @Param("phoneNo") String phoneNo);
	    
	    //PAYMENT :
	    @Insert("INSERT INTO payments (payment_id, booking_id, payment_amt, payment_date, payment_method, payment_status) " +
	            "VALUES (payment_id_seq.nextval, #{bookingId}, #{paymentAmt}, #{paymentDate}, #{paymentMethod}, #{paymentStatus})")
	    void insertPayment(Payment payment);
	    
	    //UPDATE PAYMENT :
	    @Update("update bookings set check_in = #{check_in} , check_out=#{check_out}, room=#{room} where id=#{id}")
	    void updateModifier(@Param("check_in") Date check_in, @Param("check_out") Date check_out, @Param("room") int room, @Param("id") int id);
	    
	    //UPDATE Bookings TO BOOKED :
	    @Update("UPDATE bookings SET booking_status = #{status} WHERE id = #{bookingId}")
	    void updateBookingStatus(@Param("bookingId") int bookingId, @Param("status") String status);
	    
	    //UPDATEE ROOM STATUS TO BOOKED :
	    @Select("SELECT type_id FROM rt WHERE room_name = #{roomName}")
	    int getTypeIdByRoomName(@Param("roomName") String roomName);
	    
	    @Update("UPDATE allroom SET room_status = 'Booked' WHERE type_id = #{typeId} AND room_id = #{roomId}")
	    void updateRoomStatus(@Param("typeId") int typeId, @Param("roomId") int roomId);
	    
	    //PROFILE MANAGEMENT :
	    
	    @Select("SELECT * FROM users WHERE email = #{email}")
	    User getUserDetailsByEmail(@Param("email") String email);

	    @Select("SELECT * FROM bookings WHERE phone_no = #{phone} AND booking_status IN ('Booked', 'Cancelled') order by id desc")
	    List<Booking> getBookingsByPhone(@Param("phone") String phone);
	    
	    //PROFILE >> MODIFY DATES :
	    @Update("UPDATE bookings SET customer_name = #{customerName}, gender = #{gender}, room = #{room}, " +
	            "check_in = #{checkIn}, check_out = #{checkOut}, phone_no = #{phoneNo}, booking_status = 'Booked' " +
	            "WHERE id = #{bookingId}")
	    void updateBooking(int bookingId, String customerName, String gender, int room, Date checkIn, Date checkOut, String phoneNo);

	    
	    
	    //PROFILE >> CANCEL BOOKING
	    @Update("UPDATE bookings SET booking_status = 'Cancelled' WHERE id = #{bookingId} AND booking_status IN ('Booked', 'Reserved')")
	    void updateStatus(int bookingId);
	    
	    @Update("update allroom set room_status ='Available' where room_id=(select room from bookings where id=#{id})")
	    void cancelBooking(int bookingId);
	    
	    //CONTACT :
	    @Insert("insert into refer (name, email, message) values (#{name}, #{email}, #{message})")
	    boolean insertContact(Contact contact);
}
