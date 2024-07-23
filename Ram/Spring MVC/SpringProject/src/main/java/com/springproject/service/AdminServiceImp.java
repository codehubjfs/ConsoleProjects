package com.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.mapper.AdminMapper;
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

@Service
public class AdminServiceImp implements AdminService {

	 @Autowired
	    private AdminMapper adminMapper;
	 @Override
	    public Admin getAdminByEmailAndPassword(String email, String password) {
	        return adminMapper.getAdminByEmailAndPassword(email, password);
	    }
	 @Override
	    public boolean emailExists(String email) {
	        return adminMapper.emailExists(email);
	    }

	    @Override
	    public boolean phoneExists(String phone) {
	        return adminMapper.phoneExists(phone);
	    }

	@Override
	public void insertStaff(Staff staff) {
		 adminMapper.insertStaff(staff);
	}
	@Override
    public List<Staff> getAllStaff() {
        return adminMapper.getAllStaff();
    }
	@Override
	public boolean updateStaff(Staff staff) {
		  return adminMapper.updateStaff(staff) > 0;
	}
	@Override
	public boolean deleteStaffByEmail(String email) {
		 return adminMapper.deleteStaffByEmail(email) > 0;
	}
	@Override
	public List<HouseKeeper> getAllHousekeepers() {
		return adminMapper.getAllHousekeepers();
	}
	
	
	
	@Override
	public void addHousekeeper(HouseKeeper housekeeper) {
		adminMapper.addHousekeeper(housekeeper);
		
	}
	@Override
	public boolean deleteHousekeeper(String email) {
		return adminMapper.deleteHousekeeper(email);
	}
	 @Override
	    public boolean updateHousekeeper(HouseKeeper housekeeper) {
	        return adminMapper.updateHousekeeper(housekeeper);
	    }
	@Override
	public List<User> getAllCustomers() {
		return adminMapper.getAllCustomers();
	}
	@Override
	public List<Booking> getAllBookings() {
		return adminMapper.getAllBookings();
	}
	@Override
	public List<ViewPay> getAllPayments() {
		 return adminMapper.getAllPayments();
	}
	@Override
	public List<RoomType> getAllRoomTypes() {
		return adminMapper.getAllRoomTypes();
	}
	@Override
	public void addRoomType(RoomType roomType) {
		adminMapper.insertRoomType(roomType);
		
	}
	 @Override
	    public void updateRoomType(RoomType roomType) {
	        adminMapper.updateRoomType(roomType);
	    }
	 
	 @Override
	    public void deleteRoomType(int type_id) {
	        adminMapper.deleteRoomType(type_id);
	    }
	@Override
	public void insertRoom(Room room) {
		adminMapper.insertRoom(room);
		
	}
	@Override
	public List<Room> getRoom() {
		return adminMapper.getRoom();
	}
	@Override
	public void updateRoom(Room room) {
		adminMapper.updateRoom(room);
		
	}
	@Override
	public void deleteRoom(int type_Id) {
		adminMapper.deleteRoom(type_Id);	
	}
	@Override
    public int getTotalBookings() {
        return adminMapper.getTotalBookings();
    }

    @Override
    public int getRoomsAvailable() {
        return adminMapper.getRoomsAvailable();
    }

    @Override
    public int getTotalCustomers() {
        return adminMapper.getTotalCustomers();
    }

    @Override
    public int getNewBookingsThisMonth() {
        return adminMapper.getNewBookingsThisMonth();
    }

    @Override
    public int getTotalStaff() {
        return adminMapper.getTotalStaffCount();
    }

    @Override
    public double getRevenueThisMonth() {
        return adminMapper.getRevenueThisMonth();
    }
    @Override
    public Payment getPaymentById(int paymentId) {
        return adminMapper.getPaymentById(paymentId);
    }

    @Override
    public List<ViewPay> getAllPayment() {
        return adminMapper.getAllPayment();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }
	@Override
	public int getContact() {
		 return adminMapper.getContact();
	}
}
