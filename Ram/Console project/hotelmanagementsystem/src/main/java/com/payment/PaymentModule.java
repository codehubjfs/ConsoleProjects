package com.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.bookrooms.BookRoom;
import com.bookrooms.Booking;
import com.exception.DateValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;
import com.room.Room;
import com.room.RoomType;

public class PaymentModule {

	static ViewBookings vb = new ViewBookings();
	//static Customer cus = new Customer();
	//static Room room = new Room();
//	static Payment payment = new Payment();
//	static RoomType rt = new RoomType();
	static BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));

	
	//NEW PAYMENT METHOD :
	
	public boolean capturePayment(Customer cus, Room room, RoomType roomtype) throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
	    try {
	        // Initialize variables for storing payment details
	        String paymentType;
	        String paymentStatus;

	        // Ask the user if they are sure they want to book the room
	        System.out.println("Are you sure you want to book the room? (yes/no): ");
	        String confirmation = sc.readLine().toLowerCase();

	        if (confirmation.equalsIgnoreCase("no")) {
	            // Cancel the booking
	            System.out.println("Booking canceled.");
	            String cancelBookingQuery = "UPDATE booking SET booking_status = 'Canceled' WHERE customer_id = ?";
	            PreparedStatement cancelBookingStatement = DbmsConnection.getConnection().prepareStatement(cancelBookingQuery);
	            cancelBookingStatement.setInt(1, cus.getCustomer_id());
	            cancelBookingStatement.executeUpdate();

	            // Update room status to 'Available'
	            String updateRoomQuery = "UPDATE room SET room_status = 'AVAILABLE' WHERE room_no = ?";
	            PreparedStatement updateRoomStatement = DbmsConnection.getConnection().prepareStatement(updateRoomQuery);
	            updateRoomStatement.setInt(1, room.getRoomNo());
	            updateRoomStatement.executeUpdate();

	            App.customerMenu(cus);
	            return false;
	        }
	        else if (confirmation.equals("yes")) {
	        // Proceed with payment process
	        // Ask the user to enter the payment method (Card / Cash / UPI)
	        System.out.println("Enter Payment Method (Card / UPI): ");
	        String paymentMethod = sc.readLine().toLowerCase(); // Convert input to lowercase for case-insensitivity

	        // Validate 
	        if (!paymentMethod.equalsIgnoreCase("card") &&  !paymentMethod.equalsIgnoreCase("upi")) {
	            System.out.println("Invalid payment method.");
	            return false;
	        }
	        
//	        // Calculate payment amount based on room type
//	        int pricePerNight = roomtype.getPricePerNight(); 
//	        System.out.println("Enter Payment Amount: " + pricePerNight);
//	        int paymentAmount = Integer.parseInt(sc.readLine());
//	      
//	        // Check if the entered payment amount matches the calculated amount
//	        if (paymentAmount != pricePerNight) {
//	            // Payment amount mismatch
//	            System.out.println("Payment amount mismatch. Please enter the correct amount.");
//	            capturePayment(cus, room, roomtype);
//	             
//	            return false;
//	        }
	        // NO OF DAYS STAYED :
	        String bookingQuery = "SELECT checkin, checkout FROM booking WHERE customer_id = ? AND booking_status = 'Reserved'";
            PreparedStatement bookingStatement = DbmsConnection.getConnection().prepareStatement(bookingQuery);
            bookingStatement.setInt(1, cus.getCustomer_id());
            ResultSet bookingResultSet = bookingStatement.executeQuery();
            if (!bookingResultSet.next()) {
                System.out.println("No booking found for the customer.");
                return false;
            }
            LocalDate checkInDate = bookingResultSet.getDate("checkin").toLocalDate();
            LocalDate checkOutDate = bookingResultSet.getDate("checkout").toLocalDate();

            // Calculate the number of days stayed
            long daysStayed = checkOutDate.toEpochDay() - checkInDate.toEpochDay();
            System.out.println("Total No Of Days : "+daysStayed);
            // Calculate total payment amount
            int pricePerNight = roomtype.getPricePerNight();
            int totalAmount = (int) (pricePerNight * daysStayed);

            // Inform the user about the payment amount
            System.out.println("Total amount for your stay is: Rs." + totalAmount);

            // Ask the user to enter the payment amount
            System.out.println("Enter Payment Amount: ");
            int paymentAmount = Integer.parseInt(sc.readLine());

            // Check if the entered payment amount matches the calculated amount
            if (paymentAmount != totalAmount) {
                System.out.println("Payment amount mismatch. Please enter the correct amount.");
                capturePayment(cus, room, roomtype); // Retry the payment process
                return false;
            }
	       
	     // Insert payment status in the database
	        String selectQuery = "SELECT booking_id FROM booking WHERE customer_id = ?";
	        PreparedStatement selectPs = DbmsConnection.getConnection().prepareStatement(selectQuery);
	        selectPs.setInt(1, cus.getCustomer_id());
	        ResultSet rs = selectPs.executeQuery();
//	        System.out.println(cus.getCustomer_id());
	        int bookingId = 0;
	        if (rs.next()) {
	            bookingId = rs.getInt("booking_id");
	        }
	        else {
	            System.out.println("No booking found for the customer.");
	            
	            return false;
	        }
//	        System.out.println("BookingID : "+bookingId);
	       
	        String insertQuery = "INSERT INTO payment (payment_id, booking_id, payment_amt, payment_date, payment_method, payment_status) VALUES (p_id.nextval, ?, ?, SYSDATE, ?,?)";
	        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(insertQuery);
	        preparedStatement.setInt(1, bookingId);
	       
	        preparedStatement.setInt(2, paymentAmount);
	     
	        preparedStatement.setString(3, paymentMethod.toUpperCase()); 
	        preparedStatement.setString(4, "Paid");
	        int rowsAffected = preparedStatement.executeUpdate();
	        
//	        System.out.println(room.getRoomNo());
	        if (rowsAffected > 0) {
	            // Payment successfully captured
	            // Update room status to 'Booked'
	            String updateRoomQuery = "UPDATE room SET room_status = 'Booked' WHERE room_no = ?";
	            PreparedStatement urs = DbmsConnection.getConnection().prepareStatement(updateRoomQuery);
	            urs.setInt(1, room.getRoomNo());
	            int updateRoomRowsAffected = urs.executeUpdate();

	            if (updateRoomRowsAffected > 0) {
	                // Room status updated successfully, now update booking status to 'Booked'
	                String updateBookingQuery = "UPDATE booking SET booking_status = 'Booked' WHERE booking_id = ?";
	                PreparedStatement ubs = DbmsConnection.getConnection().prepareStatement(updateBookingQuery);
	                ubs.setInt(1, bookingId);
	                int updateBookingRowsAffected = ubs.executeUpdate();

	                if (updateBookingRowsAffected > 0) {
	                    System.out.println("Payment of " + paymentAmount + " successfully completed. Booking confirmed.");
	                    vb.viewsCustomer(cus,room);
	                    return true;
	                } else {
	                    System.out.println("Failed to update booking status.");
	                    // Rollback room status update
	                    String rollbackRoomQuery = "UPDATE room SET room_status = 'AVAILABLE' WHERE room_no = ?";
	                    PreparedStatement rbs = DbmsConnection.getConnection().prepareStatement(rollbackRoomQuery);
	                    rbs.setInt(1, room.getRoomNo());
	                    rbs.executeUpdate();
	                    App.customerMenu(cus);
	                    return false;
	                }
	            } else {
	                System.out.println("Failed to update room status.");
	                App.customerMenu(cus);
	                return false;
	            }
	        } else {
	            System.out.println("Failed to capture payment.");
	            return false;
	        }

//	        if (rowsAffected > 0) {
//	            // Update booking status
//	            String updateQuery = "UPDATE room SET room_status = 'Booked' WHERE room_no = ?";
//	            PreparedStatement updateStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
//	            updateStatement.setInt(1, room.getRoomNo());
//	            int updateRowsAffected = updateStatement.executeUpdate();
//
//	            if (updateRowsAffected > 0) {
//	                System.out.println("Payment of " + paymentAmount + " successfully completed. Booking confirmed.");
//	                vb.viewsCustomer(cus);
//	                return true;
//	            } else {
//	                System.out.println("Failed to update booking status.");
//	                App.customerMenu(cus);
//	                return false;
//	            }
//	        } else {
//	            System.out.println("Failed to capture payment.");
//	            return false;
//	        }
	        }
	        else {
	        	System.out.println("Invalid option. Please enter 'yes' or 'no'.");
                return capturePayment(cus, room, roomtype);
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	        return false;
	    } catch (NumberFormatException | IOException e) {
	        System.out.println("Invalid Error : " + e.getMessage());
	        return false;
	    }
	}


	
}
