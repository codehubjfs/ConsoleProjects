package com.hotelmanagement.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Booking;
import com.hotelmanagement.utilities.DbUtil;

public class BookingDao {

	 public void insertBooking(Booking booking) throws SQLException {
		 System.out.println("BOOK 1");
		 String sql = "INSERT INTO bookings (id, customer_name, gender, room, check_in, check_out, booking_status, phone_no) VALUES (book_id.nextval, ?, ?, ?, ?, ?, ?, ?)";
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = DbUtil.openConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, booking.getCustomerName());
	            stmt.setString(2, booking.getGender());
	            stmt.setString(3, booking.getRoom());
	            stmt.setDate(4, new java.sql.Date(booking.getCheckIn().getTime()));
	            stmt.setDate(5, new java.sql.Date(booking.getCheckOut().getTime()));
	            stmt.setString(6, booking.getBookingStatus());
	            stmt.setString(7, booking.getPhoneNo());
	            
	            stmt.executeUpdate();
	            
	         // Fetch the last inserted booking ID
	            String query = "SELECT id FROM (SELECT id FROM bookings WHERE customer_name = ? AND phone_no = ? ORDER BY id DESC) WHERE ROWNUM = 1";
	            PreparedStatement stmt2 = conn.prepareStatement(query);
	            stmt2.setString(1, booking.getCustomerName());
	            stmt2.setString(2, booking.getPhoneNo());
	            rs = stmt2.executeQuery();

	            if (rs.next()) {
	                booking.setId(rs.getInt("id"));
	            }

	        } catch (SQLException e) {
	            System.out.println("Error inserting booking: " + e.getMessage());
	            throw e; // Rethrow the exception to handle it in the calling method
	        }
	        }
	 
	 public void updateBookingStatus(int bookingId, String status) throws SQLException {
	        String sql = "UPDATE bookings SET booking_status = ? WHERE id = ?";
	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn = DbUtil.openConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, status);
	            stmt.setInt(2, bookingId);

	            stmt.executeUpdate();
	        } 
	        catch (SQLException e) {
	            System.out.println("Error updating booking status: " + e.getMessage());
	            throw e; // Rethrow the exception to handle it in the calling method
	        }
	    }
	 
	 public void updateRoomStatus(int roomId, String newStatus) throws SQLException {
	        String sql = "UPDATE allroom SET ROOM_STATUS = ? WHERE ROOM_ID = ?";
	        try  {
	        	Connection conn = DbUtil.openConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, newStatus);
	            stmt.setInt(2, roomId);
	            stmt.executeUpdate();
	        }
	        catch (SQLException e) {
	            System.out.println("Error inserting booking: " + e.getMessage());
	            throw e; // Rethrow the exception to handle it in the calling method
	        }
	    }
	 
	 
	    // Method to get room rent
	    public int getRoomRent(String roomName) {
	        String query = "SELECT RENT FROM rt WHERE ROOM_NAME = ?";
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = DbUtil.openConnection();
	            stmt = conn.prepareStatement(query);
	            stmt.setString(1, roomName);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                return rs.getInt("RENT");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return 0; // Default rent if not found
	    }
	    
	    
	    public List<Booking> getBookingsByPhone(String phone) {
	        List<Booking> bookings = new ArrayList<>();
	        String sql = "SELECT * FROM bookings WHERE phone_no = ?";
	        try  {
	        	Connection connection = DbUtil.openConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, phone);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Booking booking = new Booking();
	                booking.setId(resultSet.getInt("id"));
	                booking.setCustomerName(resultSet.getString("customer_name"));
	                booking.setGender(resultSet.getString("gender"));
	                booking.setRoom(resultSet.getString("room"));
	                booking.setCheckIn(resultSet.getDate("check_in"));
	                booking.setCheckOut(resultSet.getDate("check_out"));
	                booking.setBookingStatus(resultSet.getString("booking_status"));
	                booking.setPhoneNo(resultSet.getString("phone_no"));
	                bookings.add(booking);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bookings;
	    }
}
