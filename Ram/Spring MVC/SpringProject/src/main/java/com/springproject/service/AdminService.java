package com.springproject.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

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

public interface AdminService {
	
		//DASHBOARD:
	 int getTotalBookings();
	    int getRoomsAvailable();
	    int getTotalCustomers();
	    int getNewBookingsThisMonth();
	    int getTotalStaff();
	    double getRevenueThisMonth();
	    int getContact();
	    //LOGIN
		    Admin getAdminByEmailAndPassword(String email, String password);
	
		    //INSERT STAFF :
		    boolean emailExists(String email);
		    boolean phoneExists(String phone);
		    void insertStaff(Staff staff);
		    //LLIST STAFF :
		    List<Staff> getAllStaff();
		    //EDIT/DELETE staff :
		    boolean updateStaff(Staff staff);
		    boolean deleteStaffByEmail(String email);
		    
		    //HOUSEKEEPER MANAGEMENT :
		    List<HouseKeeper> getAllHousekeepers();

		    void addHousekeeper(HouseKeeper housekeeper);

		    boolean updateHousekeeper(HouseKeeper housekeeper);

		    boolean deleteHousekeeper(String email);
		    //VIEW CUS :
		    List<User> getAllCustomers();
		    
		    //VIEW BOOKINGS :
		    List<Booking> getAllBookings();
		    
		    //VIEW PAYMENTS :
		    List<ViewPay> getAllPayments();
		    
		    //VIEW ROOMTYPES:
		    
		    List<RoomType> getAllRoomTypes();
		    
		    //INSERT ROOMTYPE :
		    void addRoomType(RoomType roomType);
		    //UPDATE ROOMTYPE :
		    void updateRoomType(RoomType roomType);
		    //DELETE ROOMTYPE :
		    void deleteRoomType(int type_id);
		    
		    //INSERT ROOM :
		    void insertRoom(Room room);
		    
		    //VIEW
		    List<Room> getRoom();
		    
		    //UPDATE:
		    void updateRoom(Room room);
		    
		    //DELETE :
		    void deleteRoom(int type_Id);
		    
		    
		    //VIEW PAYMENT :
		    Payment getPaymentById(int paymentId);

		    List<ViewPay> getAllPayment();
		    
		    List<Admin> getAllAdmins();


}
