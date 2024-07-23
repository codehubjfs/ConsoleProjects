package com.carrentalsystem.dao;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.beans.Booking;
import com.carrentalsystem.util.DBConnection;

public class BookingDAO {

  

    private static final String SELECT_BOOKING_BY_ID = "SELECT * FROM booking WHERE booking_id = ?";
    private static final String SELECT_ALL_BOOKINGS = "SELECT * FROM booking";
    private static final String UPDATE_BOOKING = "UPDATE booking SET start_date = ?, end_date = ?, booking_status = ?, car_id = ?, user_id = ?, rental_rate = ? WHERE booking_id = ?";

    

    public Booking selectBooking(int id) throws SQLException {
        Booking booking = null;
        Connection connection = DBConnection.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.print("servd1");
            while (rs.next()) {
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String bookingStatus = rs.getString("booking_status");
                int carId = rs.getInt("car_id");
                int userId = rs.getInt("user_id");
                BigDecimal rentalRate = rs.getBigDecimal("rental_rate");
                booking = new Booking();
                booking.setBookingId(id);
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);
                booking.setBookingStatus(bookingStatus);
                booking.setCarId(carId);
                booking.setUserId(userId);
                booking.setRentalRate(rentalRate);
                System.out.print("servd2");
            }
        
        return booking;
    }

    public List<Booking> selectAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.print("servd3");
            while (rs.next()) {
            	System.out.print("servdd4");
                int id = rs.getInt("booking_id");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String bookingStatus = rs.getString("booking_status");
                int carId = rs.getInt("car_id");
                int userId = rs.getInt("user_id");
                BigDecimal rentalRate = rs.getBigDecimal("rental_rate");
                Booking booking = new Booking();
                booking.setBookingId(id);
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);
                booking.setBookingStatus(bookingStatus);
                booking.setCarId(carId);
                booking.setUserId(userId);
                booking.setRentalRate(rentalRate);
                bookings.add(booking);
                System.out.print("servd4");
            }
        
        return bookings;
    }

    public boolean updateBooking(Booking booking) throws SQLException {
        boolean rowUpdated;
             Connection connection =  DBConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING);
            statement.setDate(1, new java.sql.Date(booking.getStartDate().getTime()));
            statement.setDate(2, new java.sql.Date(booking.getEndDate().getTime()));
            statement.setString(3, booking.getBookingStatus());
            statement.setInt(4, booking.getCarId());
            statement.setInt(5, booking.getUserId());
            statement.setBigDecimal(6, booking.getRentalRate());
            statement.setInt(7, booking.getBookingId());

            rowUpdated = statement.executeUpdate() > 0;
        
        return rowUpdated;
    }
}

