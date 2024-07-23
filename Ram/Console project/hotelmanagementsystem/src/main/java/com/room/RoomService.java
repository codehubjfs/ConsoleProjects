package com.room;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.DateValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;

public class RoomService {
	static BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
	public static void handleRoomServiceRequest(Customer cus) throws IOException, SQLException, EmailException, PasswordException, DateValidator {
	    System.out.println("Welcome to Room Service Requests!");

	    // Check if the room is occupied by the customer
	    int customerId = cus.getCustomer_id();
	    int roomId = getOccupiedRoomId(customerId);
	    if (roomId == -1) {
	        System.out.println("You don't have an occupied room. Please book a room first.");
	        App.customerMenu(cus);
	        return;
	    }
	    // Display room service options
	    System.out.println("Please select the type of service you need:");
	    System.out.println("1. Require Housekeeping");
	    System.out.println("2. Require Maintenance");
	    System.out.println("3. Back to Customer Menu");

	    try {
	        int choice = Integer.parseInt(sc.readLine());
	        switch (choice) {
	            case 1:
	                requestHousekeeping(roomId, cus);
	                break;
	            case 2:
	                requestMaintenance(roomId, cus);
	                break;
	            case 3:
	                App.customerMenu(cus);
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                handleRoomServiceRequest(cus);
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a number.");
	        handleRoomServiceRequest(cus);
	    }
	}

	public static void requestMaintenance(int roomId, Customer cus) throws IOException, SQLException, EmailException, PasswordException, DateValidator {
		try {
	        // Update room status to indicate maintenance is needed
	        String updateQuery = "UPDATE room SET room_condition = 'Needs Maintenance' WHERE room_no = ?";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	        ps.setInt(1, roomId);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	        	System.out.println("-".repeat(500));
	            System.out.println("Maintenance request has been successfully placed for your room.");
	            System.out.println("-".repeat(500));
	            handleRoomServiceRequest(cus);
	        } else {
	            System.out.println("Failed to place maintenance request. Please try again later.");
	            handleRoomServiceRequest(cus);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error occurred while requesting maintenance: " + e.getMessage());
	        handleRoomServiceRequest(cus);
	    }
		
	}

	private static void requestHousekeeping(int roomId, Customer cus) throws IOException, EmailException, PasswordException, DateValidator, SQLException {
		try {
	        // Update room status to indicate housekeeping is needed
	        String updateQuery = "UPDATE room SET room_condition = 'Needs Housekeeping' WHERE room_no = ?";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	        ps.setInt(1, roomId);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	        	System.out.println("-".repeat(500));
	            System.out.println("Housekeeping request has been successfully placed for your room.");
	            System.out.println("-".repeat(500));
	            System.out.println("Please specify the type of housekeeping request:");
	            System.out.println("1. Clean room and bathroom");
	            System.out.println("2. Dirty bedsheet or towel");
	            System.out.println("3. Provide water supply");

	            int choice = Integer.parseInt(sc.readLine());

	            switch (choice) {
	                case 1:
	                    updateHousekeepingRequest(roomId, "Clean room and bathroom", cus);
	                    break;
	                case 2:
	                    updateHousekeepingRequest(roomId, "Change bedsheet or towel", cus);
	                    break;
	                case 3:
	                    updateHousekeepingRequest(roomId, "Provide water supply", cus);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    requestHousekeeping(roomId, cus); // Re-prompt the user for a valid choice
	                    return;
	            }

	            handleRoomServiceRequest(cus);
	        } else {
	            System.out.println("Failed to place housekeeping request. Please try again later.");
	            handleRoomServiceRequest(cus);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error occurred while requesting housekeeping: " + e.getMessage());
	        handleRoomServiceRequest(cus);
	    }
		
	}

	private static void updateHousekeepingRequest(int roomId, String requestType, Customer cus) throws SQLException {
		String updateRequestQuery = "UPDATE room SET housekeeping_request = ? WHERE room_no = ?";
	    PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateRequestQuery);
	    ps.setString(1, requestType);
	    ps.setInt(2, roomId);
	    int rowsAffected = ps.executeUpdate();
	    if (rowsAffected > 0) {
	        System.out.println(requestType + " request has been successfully placed.");
	        try {
	            handleRoomServiceRequest(cus);
	        } catch (IOException e) {
	            System.out.println("Input/output error occurred. Please try again later.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("A database error occurred. Please try again later.");
	            e.printStackTrace();
	        } catch (EmailException | PasswordException | DateValidator e) {
	            System.out.println("Try Again Later...");
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Failed to place " + requestType + " request. Please try again later.");
	        try {
				handleRoomServiceRequest(cus);
			} catch (IOException e) {
	            System.out.println("Input/output error occurred. Please try again later.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("A database error occurred. Please try again later.");
	            e.printStackTrace();
	        } catch (EmailException | PasswordException | DateValidator e) {
	            System.out.println("Try Again Later...");
	            e.printStackTrace();
	        }
	    }
		
	}
	
	public static int getOccupiedRoomId(int customerId) throws SQLException {
	    String query = "SELECT room_no FROM booking WHERE customer_id = ? AND checkin <= SYSDATE AND checkout >= SYSDATE AND booking_status = 'Occupied'";
	    PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
	    ps.setInt(1, customerId);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        return rs.getInt("room_no");
	    }
	    return -1;
	}
}
