package com.payment;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.access.AccessMain;
import com.bookrooms.BookRoom;
import com.exception.DateValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;
import com.room.Room;

import oracle.ons.Connection;

public class ViewBookings {
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	static Room room = new Room();
//	static Customer cus = new Customer();
	public static void viewsCustomer(Customer cus,Room room) throws IOException, NumberFormatException, SQLException, EmailException, PasswordException, DateValidator {
        // Display customer menu options
		System.out.println("*".repeat(500));
        System.out.println("Customer Menu");
        System.out.println("1. VIEW BOOK ");
        System.out.println("2. Go Back to Customer Menu ");
        System.out.println("*".repeat(500));
        // Read user input
        int choice=0;
        try {
         choice = Integer.parseInt(sc.readLine());
        if(choice!=1 && choice !=2)
        {
        	throw new NumberFormatException("Error Occur!");
        }
        }
        catch(NumberFormatException | IOException e)
        {
        	System.out.println("Please enter 1 or 2 : ");
        	viewsCustomer(cus, room);
        }
        
        // Process user choice
        switch (choice) {
            case 1:
                viewBookedRoomDetails(cus,room);
                break;
            case 2:
            	System.out.println("-".repeat(500));
                System.out.println("Exiting customer menu");
                System.out.println("-".repeat(500));
                App.customerMenu(cus);
                return;
            
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
//                displayCustomerMenu(customer);
                break;
        }
    }

	public static void viewBookedRoomDetails(Customer cus, Room room) throws IOException, NumberFormatException, EmailException, PasswordException, DateValidator {
		try {

//			String sql ="select b.room_no, b.checkin, b.checkout from booking b join payment p on b.booking_id = p.booking_id where p.payment_date = (select max(payment_date) from payment)";
//		        String selectQuery = "SELECT room_no, checkin, checkout FROM booking WHERE customer_id = ?";
			
				String sql = "SELECT b.room_no, b.checkin, b.checkout " +
		             "FROM booking b " +
		             "JOIN payment p ON b.booking_id = p.booking_id " +
		             "WHERE p.payment_date = (SELECT MAX(payment_date) FROM payment) " +
		             "AND b.customer_id = ?";

		        PreparedStatement selectStatement = DbmsConnection.getConnection().prepareStatement(sql);
		        selectStatement.setInt(1, cus.getCustomer_id());
		        
		        // Execute query
		        ResultSet resultSet = selectStatement.executeQuery();
		        
		        // Display booked room details
		        System.out.println("Your booked room details:");
		        boolean hasResults = false;
	            while (resultSet.next()) {
	                hasResults = true;
	                int roomNumber = resultSet.getInt("room_no");
	                Date checkInDate = resultSet.getDate("checkin");
	                Date checkOutDate = resultSet.getDate("checkout");
	                System.out.println("-".repeat(50));
	                System.out.println("Room Number: " + roomNumber);
	                System.out.println("Check-in Date: " + checkInDate);
	                System.out.println("Check-out Date: " + checkOutDate);
	                System.out.println("-".repeat(50));
	            }
	            
	            if (!hasResults) {
	                System.out.println("No bookings found for your account.");
	            }

	            System.out.println("Press any key to return to the customer menu...");
	            sc.readLine();
	            viewsCustomer(cus, room);
		       
		    } catch (SQLException e) {
		    	 System.out.println("Error retrieving booking details: " + e.getMessage());
//		        e.printStackTrace();
		    }
		
	}

}
