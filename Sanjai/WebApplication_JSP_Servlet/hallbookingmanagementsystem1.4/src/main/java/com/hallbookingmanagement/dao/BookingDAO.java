package com.hallbookingmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.hallbookingmanagement.bdutil.DBConnection;
import com.hallbookingmanagement.beans.*;

public class BookingDAO implements DAO<Booking>{

	@Override
	public List<Booking> getAll() throws SQLException {
        List<Booking> bookingList = new ArrayList<>();
		String query = "select * from BOOKING";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int bookId = resultSet.getInt("BOOK_ID");
            int customerId = resultSet.getInt("USER_ID");
            int hallId = resultSet.getInt("HALL_ID");
            int eventId = resultSet.getInt("EVENT_ID");
            int arrangementId = resultSet.getInt("ARRANGEMENT_ID");
            LocalDateTime requestedTime = resultSet.getTimestamp("REQUESTED_TIME").toLocalDateTime();
            LocalDate startDate = resultSet.getDate("START_DATE").toLocalDate();
            LocalDate endDate = resultSet.getDate("END_DATE").toLocalDate();
            String bookStatus = resultSet.getString("BOOK_STATUS");

            List<Customer> customerList = new CustomerDAO().getAll();
            Customer customer = null;
            for(Customer tempCustomer:customerList){
                if(tempCustomer.getUserId()==customerId){
                    customer = tempCustomer;
                    break;
                }
            }
            Hall hall = null;
            List<Hall> hallList = new HallDAO().getAll();
            for(Hall tempHall:hallList){
                if(tempHall.getHallId()==hallId){
                    hall = tempHall;
                    break;
                }
            }
            Seats seat = null;
            for(Seats tempSeat: hall.getSeat()){
                if(tempSeat.getSeatId()==arrangementId){
                    seat = tempSeat;
                    break;
                }
            }
            Event event = null;
            for(Event tempEvent : hall.getEvents()){
                if(tempEvent.getEventId()==eventId){
                    event = tempEvent;
                    break;
                }
            }
            HashSet<Event> eventSet = new HashSet<>();
            eventSet.add(event);
            hall.setEvents(eventSet);
            HashSet<Seats> hashSet = new HashSet<>();
            hashSet.add(seat);
            hall.setSeat(hashSet);
            Booking booking = new Booking();
            booking.setBookingId(bookId);
            booking.setCustomer(customer);
            booking.setHall(hall);
            booking.setRequestedTime(requestedTime);
            booking.setStartDate(startDate);
            booking.setEndDate(endDate);
            booking.setBookStatus(bookStatus);
            bookingList.add(booking);
        }
		return  bookingList;
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
	    
	    public void blockOtherBooking(Booking selectedBook) {
	        
	        try {
	            Connection connection = DBConnection.getInstance().getConnection();
	            connection.setAutoCommit(false); // Start transaction
	            
	            List<Booking> bookList = getAll();
	            ArrayList<Integer> bookIdList = new ArrayList<>();

	            // Identify bookings that overlap with the selected booking
	            for (Booking book : bookList) {
	                if (book.getBookingId() != selectedBook.getBookingId() &&
	                    book.getStartDate().isBefore(selectedBook.getEndDate()) &&
	                    book.getEndDate().isAfter(selectedBook.getStartDate()) &&
	                    (book.getBookStatus().equals("PENDING") || book.getBookStatus().equals("APPROVED"))) {
	                    bookIdList.add(book.getBookingId());
	                }
	            }

	            // Update the status of overlapping bookings to 'CANCELED'
	            String blockUpdateQuery = "UPDATE booking SET book_status = 'CANCELED' WHERE book_id = ?";
	            PreparedStatement blockStatement = connection.prepareStatement(blockUpdateQuery);
	            System.out.println("Canceled");
	            for (int bookId : bookIdList) {
	                blockStatement.setInt(1, bookId);
	                System.out.println(bookId);
	                blockStatement.executeUpdate();
	            } 
	            System.out.println("Booked things");
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
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
	    
	    public boolean update(Booking booking) throws SQLException {
	    	String updateQuery = "Update BOOKING set BOOK_STATUS='CONFIRMED' where BOOK_ID=?";
	    	PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(updateQuery);
	    	statement.setInt(1,booking.getBookingId());
	    	if(statement.executeUpdate()>0) {
	    		return true;
	    	}
	    	return false;
	    	
	    }
}