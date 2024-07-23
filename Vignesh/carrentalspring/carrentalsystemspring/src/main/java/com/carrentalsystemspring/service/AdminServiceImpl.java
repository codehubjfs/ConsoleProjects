package com.carrentalsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystemspring.mapper.AdminMapper;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.User;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminMapper adminMapper;

	@Autowired
	public AdminServiceImpl(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public long getTotalUsers() {
		return adminMapper.countUsers();
	}

	@Override
	public long getTotalCars() {
		return adminMapper.countCars();
	}

	@Override
	public long getTotalRented() {
		return adminMapper.countBookings();
	}

	@Override
	public boolean isCarAvailable(String vehicleNo, String date, String time) {
		// Check availability logic here
		// For simplicity, assume the car is available if the AVAILABLE column is "yes"
		return adminMapper.isCarAvailable(vehicleNo);
	}

	@Override
	public void addCar(Car car) {
		adminMapper.addCar(car);
	}

	@Override
	public void updateCar(Car car) {
		adminMapper.updateCar(car);
	}

	@Override
	public void deleteCar(int car_id) {
		adminMapper.deleteCar(car_id);
	}

	@Override
	public List<Car> getAllCars() {
		return adminMapper.getAllCars();
	}

	@Override
	public List<User> getAllCustomers() {
		return adminMapper.getAllCustomers();
	}

	@Override
	public List<Booking> getAllBookings() {
		return adminMapper.selectAllBookings();
	}

	@Override
	public void updateBookingStatus(int bookingId, String bookingStatus) {
		adminMapper.updateBookingStatus(bookingId, bookingStatus);
	}

	@Override
	public void deleteBooking(int bookingId) {
		adminMapper.deleteBooking(bookingId);
	}

	@Override
	public User getUserById(int userId) {
		return adminMapper.getUserById(userId);
	}

	@Override
	public void updateUserStatus(int user_id, String accountStatus) {
		adminMapper.updateUserStatus(user_id, accountStatus);
	}

	@Override
	public void deleteUser(int userId) {
		adminMapper.deleteUser(userId);
	}

}
