package com.hallbookingmanagement.dao;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.beans.Event;
import com.hallbookingmanagement.beans.Hall;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDAO implements  DAO<Booking>{
    @Override
    public List<Booking> getAll() throws SQLException {
        List<Booking> list = new ArrayList<>();
        String query = "select * from BOOKING";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Customer> customerList = new CustomerDAO().getAll();
        List<Hall> hallList = new HallDAO().getAll();
        while (resultSet.next()){
            Booking booking = new Booking();
            booking.setBookingId(resultSet.getInt("BOOK_ID"));
            int userId = resultSet.getInt("USER_ID");
            Customer customer = customerList.stream().filter(customer1 -> customer1.getUserId()==userId).findFirst().orElse(null);
            booking.setCustomer(customer);
            int hallId = resultSet.getInt("HALL_ID");
            Hall hall = hallList.stream().filter(hallObj->hallObj.getHallId()==hallId).findFirst().orElse(null);
            booking.setHall(hall);
            booking.setRequestedTime(resultSet.getTimestamp("REQUESTED_TIME").toLocalDateTime());
            booking.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
            booking.setEndDate(resultSet.getDate("end_date").toLocalDate());
            booking.setBookStatus(resultSet.getString("BOOK_STATUS"));
            list.add(booking);
        }
        return  list;

    }

    @Override
    public boolean add(Booking book) throws SQLException {
        String addQuery = "INSERT INTO booking (book_id, user_id, hall_id, event_id, arrangement_id, requested_time, start_date, end_date, book_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int bookID = PrimaryKeyProvider.primaryKey("Booking");
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(addQuery);
        statement.setInt(1,bookID);
        statement.setInt(2,book.getCustomer().getUserId());
        int eventId = book.getHall().getEvents().stream().findFirst().map(x->x.getEventId()).orElse(0);
        int arrangmentId = book.getHall().getSeat().stream().findFirst().map(x->x.getSeatId()).orElse(0);
        statement.setInt(3, book.getHall().getHallId());
        statement.setInt(4,eventId);
        statement.setInt(5, arrangmentId);
        statement.setTimestamp(6, Timestamp.valueOf(book.getRequestedTime()));
        statement.setDate(7, Date.valueOf(book.getStartDate()));
        statement.setDate(8,Date.valueOf(book.getEndDate()));
        statement.setString(9,"PENDING");
        return  statement.executeUpdate()>0?true:false;
    }

    @Override
    public boolean delete(Booking book) throws SQLException {
        String deleteQuery = "delete booking where book_id = ? ";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
        statement.setInt(1,book.getBookingId());
        return statement.executeUpdate()>0?true:false;
    }
    
    public boolean updateStatus(Booking book) throws SQLException {
        String deleteQuery = "Update booking set BOOK_STATUS= ? where book_id = ? ";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(deleteQuery);
        statement.setString(1,book.getBookStatus());
        statement.setInt(2,book.getBookingId());
        return statement.executeUpdate()>0?true:false;
    }
    
 
}
