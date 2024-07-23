package com.room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.access.AccessStaff;
import com.bookrooms.BookRoom;
import com.exception.DateValidator;
import com.exception.DefaultException;
import com.exception.EmailValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.Customer;
import com.person.DbmsConnection;

import oracle.ons.Connection;

public class ManageRooms {
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//	static App app = new App();
	public static boolean createRoom() throws NumberFormatException, IOException, SQLException, PasswordException, EmailException, DefaultException, DateValidator
	{
		AccessStaff staff = new AccessStaff();
		int roomNo;
		while(true)
		{
			try {
		System.out.println("Enter Room Number: ");
		  roomNo = Integer.parseInt(sc.readLine());
		  break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please enter a valid Number....");
			}
		}
		 String checkQuery = "SELECT COUNT(*) FROM room WHERE room_no = ?";
		 PreparedStatement checkStatement = DbmsConnection.getConnection().prepareStatement(checkQuery);
		 checkStatement.setInt(1, roomNo);
		 ResultSet resultSet = checkStatement.executeQuery();
		 resultSet.next();
		 int count = resultSet.getInt(1);
		 System.out.println("COUNT "+count);
		 if (count > 0) {
		     System.out.println("Room number already exists. Cannot create a room with the same number.");
		     staff.createRoom();
		 } else {
		 System.out.println("Enter Type_id : (1 or 2 or 3 ) ");
	     int typeId = Integer.parseInt(sc.readLine());
	     try {
	     if (typeId < 1 || typeId > 3) {
	         throw new DefaultException("Invalid Type_id"); // Throw DefaultException 
	     }
	     }
	     catch(DefaultException e)
	     {
	    	 System.out.println("Error Occured ");
	    	 staff.createRoom();
	     }
	    
	     Room room = new Room();
	     room.setRoom_condition(RoomCondition.CLEAN);
	     room.setRoom_status(RoomStatus.AVAILABLE);
	     room.setRoomNo(roomNo);
	     room.setType_id(typeId);
	     //room.setRoomPrice(roomPrice);
	     
//	     System.out.println("Enter Room Status: ");
//	     String status = sc.readLine();
//	     System.out.println("Enter Room Condition: (Clean or Dirty) ");
//	     String condition = sc.readLine();
	        // Insert room details into the database
	        String insertQuery = "INSERT INTO room (room_no, type_id, room_status, room_condition) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(insertQuery);
	        ps.setInt(1, room.getRoomNo());
	        ps.setInt(2, room.getType_id());
	        ps.setString(3, RoomStatus.AVAILABLE.toString());
	        ps.setString(4, RoomCondition.CLEAN.toString());
	        
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Room created successfully!");
	            staff.createRoom();
	            return true;
	        } else {
	            System.out.println("Failed to create room.");
	            staff.createRoom();
	            return false;
	        }
		 }
		return true;
	}
	
	//MODIFY ROOMS 
	public static boolean modifyRoom() throws NumberFormatException, PasswordException, EmailException, SQLException, DefaultException, DateValidator {
	    try {
	        while (true) {
	            System.out.println("1. Modify Room Status");
	            System.out.println("2. Modify Room Condition");
	            System.out.println("3. Back to Main Menu");
	            System.out.print("Choose an action: ");
	            int action;
	            try {
	                action = Integer.parseInt(sc.readLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid choice. Please enter a number.");
	                continue;
	            }

	            if (action == 1) {
	                try {
	                    modifyRoomStatus();
	                } catch (IOException e) {
	                    System.out.println("Error: " + e.getMessage());
	                }
	            } else if (action == 2) {
	                try {
	                    modifyRoomCondition();
	                } catch (IOException e) {
	                    System.out.println("Error: " + e.getMessage());
	                }
	            } else if (action == 3) {
	            	App.adminMenu();
	                return false;
	            } else {
	                System.out.println("Invalid action choice!");
	            }
	        }
	        
	    } catch (IOException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return false;
	}

	public static void modifyRoomCondition() throws IOException {
	    try {
	        System.out.print("Enter Room Number: ");
	        int roomNo = Integer.parseInt(sc.readLine());

	        System.out.print("Enter New Room Condition: ");
	        String roomCondition = sc.readLine();

	        String updateQuery = "UPDATE room SET room_condition = ? WHERE room_no = ?";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	        ps.setString(1, roomCondition);
	        ps.setInt(2, roomNo);
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Room condition updated successfully!");
	        } else {
	            System.out.println("Failed to update room condition.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating room condition: " + e.getMessage());
	    }
	}


	private static void modifyRoomStatus() throws NumberFormatException, IOException {
	    try {
	        System.out.print("Enter Room Number: ");
	        int roomNo = Integer.parseInt(sc.readLine());

	        System.out.print("Enter New Room Status: ");
	        String roomStatus = sc.readLine();

	        String updateQuery = "UPDATE room SET room_status = ? WHERE room_no = ?";
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	        ps.setString(1, roomStatus);
	        ps.setInt(2, roomNo);
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Room status updated successfully!");
	        } else {
	            System.out.println("Failed to update room status.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating room status: " + e.getMessage());
	    }
	}

	// CANCEL RESERVATION BASED ON CUSTOMER EMAIL VERIFICATION :
	
	public static void cancelBookingByCustomerEmail() throws IOException, NumberFormatException, PasswordException, EmailException, DefaultException, DateValidator {
	    try {
	        //  to enter customer's email
	    	boolean validEmailEntered = false;
	    	String customerEmail = null;
	    	while (!validEmailEntered) {
	    	    try {
	    	        System.out.print("Enter customer email whose booking needs to be canceled: ");
	    	        customerEmail = sc.readLine();
	    	        // Validate email format
	    	        if (EmailValidator.isValidEmail(customerEmail)) {
	    	            validEmailEntered = true;
	    	        } else {
	    	            System.out.println("Invalid email format. Please enter a valid email address.");
	    	        }
	    	    } catch (IOException e) {
	    	        System.out.println("Error reading input: " + e.getMessage());
	    	    }
	    	}
	        // Fetch booking details associated with provided email
	        String selectQuery = "SELECT * FROM booking WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID FROM customer WHERE EMAIL = ?)";
	        try (PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(selectQuery)) {
	            ps.setString(1, customerEmail);
	            try (ResultSet rs = ps.executeQuery()) {
	                // Check if any booking exists for the provided email
	                if (!rs.next()) {
	                    System.out.println("No booking found for the provided email.");
	                    return;
	                }

	                // Extract room number from booking details
	                int roomNo = rs.getInt("ROOM_NO");

	                // Update room status to make it available
	                String updateRoomStatusQuery = "UPDATE room SET room_status = 'AVAILABLE' WHERE room_no = ?";
	                try (PreparedStatement psUpdateRoomStatus = DbmsConnection.getConnection().prepareStatement(updateRoomStatusQuery)) {
	                    psUpdateRoomStatus.setInt(1, roomNo);
	                    int roomRowsAffected = psUpdateRoomStatus.executeUpdate();
	                    //DELETE THE BOOKING :
	                    try  {
	                    String deleteBookingQuery = "DELETE FROM booking WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID FROM customer WHERE EMAIL = ?)";
	                    	PreparedStatement psDeleteBooking = DbmsConnection.getConnection().prepareStatement(deleteBookingQuery);
	                        psDeleteBooking.setString(1, customerEmail);
	                        int bookingRowsAffected = psDeleteBooking.executeUpdate();

	                        if (roomRowsAffected > 0 && bookingRowsAffected > 0) {
	                            System.out.println("Booking canceled successfully!");
	                            AccessStaff.createRoom();
	                        } else {
	                            System.out.println("Failed to cancel booking.");
	                            AccessStaff.createRoom();
	                        }
	                    }
	                    catch(SQLException e) {
	                        System.out.println("Error canceling booking: " + e.getMessage());
	                        AccessStaff.createRoom();
	                    }
	                    // Update booking status to reflect cancellation
//	                    String cancelBookingQuery = "UPDATE booking SET booking_status = 'Cancelled' WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID FROM customer WHERE EMAIL = ?)";
//	                    try (PreparedStatement psCancelBooking = DbmsConnection.getConnection().prepareStatement(cancelBookingQuery)) {
//	                        psCancelBooking.setString(1, customerEmail);
//	                        int bookingRowsAffected = psCancelBooking.executeUpdate();
//
//	                        if (roomRowsAffected > 0 && bookingRowsAffected > 0) {
//	                            System.out.println("Booking canceled successfully!");
//	                        } else {
//	                            System.out.println("Failed to cancel booking.");
//	                        }
//	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error canceling booking.  The booking could not be deleted !!! " + e.getMessage());
	    }
	}
	
	//CREATE ROOM-TYPE :
	public static void insertRoomType() throws SQLException, IOException, NumberFormatException, PasswordException, EmailException, DefaultException, DateValidator {
		Customer cus = new Customer();
		System.out.println("Enter Type_id : ");
		int type_id = Integer.parseInt(sc.readLine());
		System.out.println("Enter Type_Name : ");
		String typeName = sc.readLine();
		System.out.println("Enter Room Capacity : ");
		int roomCapacity = Integer.parseInt(sc.readLine());
		System.out.println("Enter Amenities facility :");
		String amenities = sc.readLine();
		System.out.println("Enter Price for Room : ");
		int pricePerNight = Integer.parseInt(sc.readLine());
		RoomType rt =new RoomType(type_id, typeName, roomCapacity, amenities, pricePerNight);
		
	    String insertQuery = "INSERT INTO roomtype (TYPE_ID, TYPE_NAME, ROOM_CAPACITY, AMENITIES, PRICEPERNIGHT) VALUES (?, ?, ?, ?, ?)";
	    
	    PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(insertQuery);
	    preparedStatement.setInt(1, rt.getType_id());
	    preparedStatement.setString(2, rt.getType_name());
	    preparedStatement.setInt(3, rt.getRoom_capacity());
	    preparedStatement.setString(4, rt.getAmenity());
	    preparedStatement.setInt(5, rt.getPricePerNight());
	    
	    int rowsAffected = preparedStatement.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Room type inserted successfully.");
	        AccessStaff.createRoom();
	    } else {
	        System.out.println("Failed to insert room type.");
	        AccessStaff.createRoom();
	    }
	    BookRoom.bookRoomByModel(cus);
	    }
	
	//GENERATE INVOICE FOR THE CUST_ID:
	public static void generateInvoiceAndTrackPayment() throws NumberFormatException, IOException, PasswordException, EmailException, DefaultException, DateValidator, SQLException {
        try {
        	System.out.println("Enter the Customer-MailId : ");
        	String email = sc.readLine();
        	int customerId = getCustomerIdByEmail(email);
            if (customerId == -1) {
                System.out.println("No customer found with email: " + email);
                
                App.adminMenu();
            }
            // Retrieve booking details ::::
//        	System.out.println("CUSID :"+customer_id);
            String bookingQuery = "SELECT * FROM booking WHERE customer_id = ? AND booking_status='Occupied'";
            PreparedStatement bookingPs = DbmsConnection.getConnection().prepareStatement(bookingQuery);
            bookingPs.setInt(1, customerId);
            ResultSet bookingRs = bookingPs.executeQuery();

            // Check if booking exists for the customer
            if (!bookingRs.next()) {
                System.out.println("No booking found for customer ID: " + customerId);
                App.adminMenu();
            }

            // Extract booking details
            int bookingId = bookingRs.getInt("booking_id");
            int roomId = bookingRs.getInt("room_no");
            LocalDate checkInDate = bookingRs.getDate("checkin").toLocalDate();
            LocalDate checkOutDate = bookingRs.getDate("checkout").toLocalDate();
            String bookingStatus = bookingRs.getString("booking_status");

            // Retrieve room details
            String roomQuery = "SELECT * FROM room WHERE room_no = ?";
            PreparedStatement roomPs = DbmsConnection.getConnection().prepareStatement(roomQuery);
            roomPs.setInt(1, roomId);
            ResultSet roomRs = roomPs.executeQuery();

            // Check if room exists
            if (!roomRs.next()) {
                System.out.println("Room not found for booking ID: " + bookingId);
                App.adminMenu();
            }
            // Extract room details
            int roomNo = roomRs.getInt("room_no");
            int roomTypeId = roomRs.getInt("type_id");

            // Retrieve room type details
            String roomTypeQuery = "SELECT * FROM roomtype WHERE type_id = ?";
            PreparedStatement roomTypePs = DbmsConnection.getConnection().prepareStatement(roomTypeQuery);
            roomTypePs.setInt(1, roomTypeId);
            ResultSet roomTypeRs = roomTypePs.executeQuery();

            // Check if room type exists
            if (!roomTypeRs.next()) {
                System.out.println("Room type not found for room ID: " + roomId);
                App.adminMenu();
            }

            // Extract room type details
            String roomTypeName = roomTypeRs.getString("type_name");
            int pricePerNight = roomTypeRs.getInt("pricepernight");

            // Calculate total number of nights
            long totalNights = checkOutDate.toEpochDay() - checkInDate.toEpochDay();

            // Calculate total amount
            double totalAmount = pricePerNight * totalNights;

            // Generate invoice
            System.out.println("Invoice for Booking ID: " + bookingId);
            System.out.println("Customer ID: " + customerId);
            System.out.println("Room No: " + roomNo);
            System.out.println("Room Type: " + roomTypeName);
            System.out.println("Check-in Date: " + checkInDate);
            System.out.println("Check-out Date: " + checkOutDate);
            System.out.println("Total Nights: " + totalNights);
            System.out.println("Price per Night: Rs." + pricePerNight);
            System.out.println("Total Amount: Rs." + totalAmount);

            // Retrieve payment status
            String paymentQuery = "SELECT * FROM payment WHERE booking_id = ?";
            PreparedStatement paymentPs = DbmsConnection.getConnection().prepareStatement(paymentQuery);
            paymentPs.setInt(1, bookingId);
            ResultSet paymentRs = paymentPs.executeQuery();

            // Check if payment exists
            if (paymentRs.next()) {
                String paymentStatus = paymentRs.getString("payment_status");
                System.out.println("Payment Status: " + paymentStatus);
                App.adminMenu();
            } else {
                System.out.println("Payment Status: Not Paid");
                App.adminMenu();
            }

        } catch (SQLException e) {
            System.out.println("A database error occurred. Please try again later.");
//            e.printStackTrace();
            App.adminMenu();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid number.");
            App.adminMenu();
        } catch (IOException e) {
            System.out.println("An I/O error occurred. Please try again.");
            App.adminMenu();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); 
            App.adminMenu();
        }
	}

	private static int getCustomerIdByEmail(String email) throws SQLException {
		String customerIdQuery = "SELECT customer_id FROM customer WHERE email = ?";
	    PreparedStatement c = DbmsConnection.getConnection().prepareStatement(customerIdQuery);
	    c.setString(1, email);
	    ResultSet cs = c.executeQuery();
	    if (cs.next()) {
	        return cs.getInt("customer_id");
	    } else {
	        return -1; 
	    }
	}
	
	//MODIFY ROOMTYPE
	public static void modifyRoomType() throws SQLException, IOException, NumberFormatException, PasswordException, EmailException, DefaultException, DateValidator {
		int type_id = 0;
	    boolean validInput = false;

	    // Loop until a valid and existing type_id is provided
	    while (!validInput) {
	        try {
	            System.out.println("Enter Type_id of the room type you want to update: ");
	            type_id = Integer.parseInt(sc.readLine());

	            // Check if the type_id exists
	            String checkQuery = "SELECT COUNT(*) FROM roomtype WHERE TYPE_ID = ?";
	            PreparedStatement checkStatement = DbmsConnection.getConnection().prepareStatement(checkQuery);
	            checkStatement.setInt(1, type_id);
	            ResultSet rs = checkStatement.executeQuery();
	            rs.next();
	            
	            if (rs.getInt(1) > 0) {
	                validInput = true;
	            } else {
	                System.out.println("Type_id does not exist. Please enter a valid type_id.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Type_id.");
	        }
	    }
	    System.out.println("Select the field you want to update: ");
	    System.out.println("1. Type_Name");
	    System.out.println("2. Room Capacity");
	    System.out.println("3. Amenities");
	    System.out.println("4. Price per Night");
	    int choice = Integer.parseInt(sc.readLine());

	    String updateQuery = "";
	    PreparedStatement preparedStatement = null;
	    
	    switch (choice) {
	        case 1:
	            System.out.println("Enter new Type_Name: ");
	            String typeName = sc.readLine();
	            updateQuery = "UPDATE roomtype SET TYPE_NAME = ? WHERE TYPE_ID = ?";
	            preparedStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
	            preparedStatement.setString(1, typeName);
	            preparedStatement.setInt(2, type_id);
	            break;
	        case 2:
	            System.out.println("Enter new Room Capacity: ");
	            int roomCapacity = Integer.parseInt(sc.readLine());
	            updateQuery = "UPDATE roomtype SET ROOM_CAPACITY = ? WHERE TYPE_ID = ?";
	            preparedStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
	            preparedStatement.setInt(1, roomCapacity);
	            preparedStatement.setInt(2, type_id);
	            break;
	        case 3:
	            System.out.println("Enter new Amenities: ");
	            String amenities = sc.readLine();
	            updateQuery = "UPDATE roomtype SET AMENITIES = ? WHERE TYPE_ID = ?";
	            preparedStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
	            preparedStatement.setString(1, amenities);
	            preparedStatement.setInt(2, type_id);
	            break;
	        case 4:
	            System.out.println("Enter new Price per Night: ");
	            int pricePerNight = Integer.parseInt(sc.readLine());
	            updateQuery = "UPDATE roomtype SET PRICEPERNIGHT = ? WHERE TYPE_ID = ?";
	            preparedStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
	            preparedStatement.setInt(1, pricePerNight);
	            preparedStatement.setInt(2, type_id);
	            break;
	        default:
	            System.out.println("Invalid choice.");
	            return;
	    }

	    int rowsAffected = preparedStatement.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Room type updated successfully.");
	    } else {
	        System.out.println("Failed to update room type.");
	    }
	    AccessStaff.createRoom();
//	    BookRoom.bookRoomByModel(new Customer());
	}
	
	//DELETE ROOM TYPE:
	public static void deleteRoomType() throws SQLException, IOException, NumberFormatException, PasswordException, EmailException, DefaultException, DateValidator {
		int type_id = 0;
	    boolean validInput = false;

	    // Loop until a valid integer input 
	    while (!validInput) {
	        try {
	            System.out.println("Enter Type_id of the room type you want to update: ");
	            type_id = Integer.parseInt(sc.readLine());

	            // Check if the type_id exists
	            String checkQuery = "SELECT COUNT(*) FROM roomtype WHERE TYPE_ID = ?";
	            PreparedStatement checkStatement = DbmsConnection.getConnection().prepareStatement(checkQuery);
	            checkStatement.setInt(1, type_id);
	            ResultSet rs = checkStatement.executeQuery();
	            rs.next();
	            
	            if (rs.getInt(1) > 0) {
	                validInput = true;
	            } else {
	                System.out.println("Type_id does not exist. Please enter a valid type_id.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid integer for Type_id.");
	        }
	    }
	    
	    String deleteQuery = "DELETE FROM roomtype WHERE TYPE_ID = ?";
	    
	    PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(deleteQuery);
	    preparedStatement.setInt(1, type_id);
	    
	    int rowsAffected = preparedStatement.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Room type deleted successfully.");
	    } else {
	        System.out.println("Failed to delete room type.");
	    }
	    AccessStaff.createRoom();
	    
	}


}
