package com.springproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.model.Admin;
import com.springproject.model.Booking;
import com.springproject.model.HouseKeeper;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.Staff;
import com.springproject.model.User;
import com.springproject.model.ViewBook;
import com.springproject.model.ViewPay;

import jakarta.servlet.http.HttpServletRequest;

@Mapper
public interface AdminMapper {
	
	//DASHBOARD:
	 @Select("SELECT COUNT(*) FROM bookings")
	    int getTotalBookings();

	    @Select("SELECT COUNT(*) FROM allroom WHERE ROOM_STATUS = 'Available'")
	    int getRoomsAvailable();

	    @Select("SELECT COUNT(*) FROM users")
	    int getTotalCustomers();

	    @Select("SELECT COUNT(*) FROM bookings WHERE EXTRACT(MONTH FROM CHECK_IN) = EXTRACT(MONTH FROM SYSDATE)")
	    int getNewBookingsThisMonth();

	    @Select("SELECT SUM(cnt) AS total_staff_count FROM (SELECT COUNT(*) AS cnt FROM staff UNION ALL SELECT COUNT(*) AS cnt FROM keeper)")
	    int getTotalStaffCount();

	    @Select("SELECT SUM(rent) FROM bookings b JOIN rt r ON b.room = r.type_id WHERE EXTRACT(MONTH FROM b.check_in) = EXTRACT(MONTH FROM SYSDATE)")
	    double getRevenueThisMonth();
	    
	    @Select("select  count(*) from refer ")
	    int getContact();
	
	
	//LOGIN :
	
	 @Select("SELECT * FROM admin WHERE email = #{email} and password = #{password}")
	 Admin getAdminByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	 
	 //INSERT STAFF :
	 @Select("SELECT COUNT(*) FROM staff WHERE email = #{email}")
	    boolean emailExists(String email);

	    @Select("SELECT COUNT(*) FROM staff WHERE phone_no = #{phone}")
	    boolean phoneExists(String phone);
	    @Insert("INSERT INTO staff (staff_id, name, email, password, phone_no) VALUES (staff_id.nextval, #{name}, #{email}, #{password}, #{phone_no})")
	    void insertStaff(Staff staff);
	    //List STAFF
	    @Select("SELECT * FROM staff")
	    List<Staff> getAllStaff();
	    
	    //EDIT AND DELETE STAFF :
	    @Update("UPDATE staff SET name = #{name}, phone_no = #{phone_no}, password = #{password} WHERE email = #{email}")
	    int updateStaff(Staff staff);

	    @Delete("DELETE FROM staff WHERE email = #{email}")
	    int deleteStaffByEmail(String email);
	    
	    // HOUSEKEEPER MANAGEMENT :
	    @Select("SELECT * FROM keeper")
	    List<HouseKeeper> getAllHousekeepers();

	    @Insert("INSERT INTO keeper (keeper_id,name, email, phone_no, password, status) VALUES (keep_id.nextval, #{name}, #{email}, #{phone_no}, #{password}, #{status})")
	    void addHousekeeper(HouseKeeper housekeeper);

	    @Update("UPDATE keeper SET name=#{name}, phone_no=#{phone_no}, status=#{status} WHERE email=#{email}")
	    boolean updateHousekeeper(HouseKeeper housekeeper);

	   
	    @Delete("DELETE FROM keeper WHERE email=#{email}")
	    boolean deleteHousekeeper(String email);
	    
	    //VIEW CUSTOMER :
	    @Select("SELECT * from USERS")
	    List<User> getAllCustomers();
	    
	    //VIEW BOOKINGS :
	   
	    @Select("select * from bookings")
	    List<Booking> getAllBookings();
	    
	    //VIEW PAYMENTS :
	    @Select("SELECT * FROM payments")
	    List<ViewPay> getAllPayments();

	    //ROOMTYPE :
	    @Select("SELECT * FROM RT")
	    List<RoomType> getAllRoomTypes();
	    
	    @Insert("INSERT INTO rt (type_id, room_name, bed_capacity, amenity, no_of_room, rent) " +
	            "VALUES (#{type_id}, #{room_name}, #{bed_capacity}, #{amenity}, #{no_of_room}, #{rent})")
	    void insertRoomType(RoomType roomType);
	    
	    @Update("UPDATE rt SET room_name = #{room_name}, bed_capacity = #{bed_capacity}, amenity = #{amenity}, no_of_room = #{no_of_room}, rent = #{rent} WHERE type_id = #{type_id}")
	    void updateRoomType(RoomType roomType);
	    
	    @Delete("DELETE FROM rt WHERE type_id = #{type_id}")
	    void deleteRoomType(int type_id);
	    
	    //ROOM 
	    @Insert("INSERT INTO allroom (room_id, type_id, room_status, room_condition) VALUES (#{room_Id}, #{type_Id}, #{room_status}, #{room_condition})")
	    void insertRoom(Room room);
	    
	    @Select("select * from allroom")
	    List<Room> getRoom();
	    
	    @Update("update allroom set type_id= #{type_Id}, room_status = #{room_status}, room_condition=#{room_condition} where room_id = #{room_Id}")
	    void updateRoom(Room room);
	    
	    @Delete("DELETE FROM allroom WHERE type_id = #{type_Id}")
	    void deleteRoom(int type_Id);
	    
	    //VIEW PAYMENT :
	    @Select("SELECT * FROM payments WHERE payment_id = #{paymentId}")
	    Payment getPaymentById(int paymentId);

	    @Select("SELECT * FROM payments order by payment_date desc")
	    List<ViewPay> getAllPayment();
	    
	    @Select("SELECT * FROM admin")
	    List<Admin> getAllAdmins();
}
