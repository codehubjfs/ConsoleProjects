package com.bookrooms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.access.AccessMain;
import com.exception.BookingCancellationException;
import com.exception.DateValidator;
import com.exception.InvalidEmailException;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.exception.RoomNotFoundException;
import com.exception.ValidateClass;
import com.jamocha.hotelmanagementsystem.*;
import com.payment.PaymentModule;
import com.payment.ViewBookings;
import com.person.Customer;
import com.person.DbmsConnection;
import com.room.Room;
import com.room.RoomType;

import oracle.ons.Connection;

public class BookRoom {
//	public static  Customer cus ;
	static App app = new App();
	
	static ViewBookings view = new ViewBookings();
	//static Customer cus = new Customer();
	// static Room room = new Room();
	static Booking book =new Booking();
//	static PaymentModule pm = new PaymentModule();
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	    
	public static  void bookRoom() {
	    // Prompt the user for guest details, dates, and room preferences
	    // Check room availability and allocate a room to the guest if available
	    // Update the database or data structure to reflect the new reservation
	    System.out.println("Booking a reservation...");
	}
	
	// GET ROOM TYPES FROM ROOMTYPE CLASS :
	public static List<RoomType> getRoomType() throws SQLException {
		List<RoomType> rt = new ArrayList<>();
		try {
			String sql ="select * from roomtype";
			PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String tname = rs.getString("type_name");
				int rcapacity = rs.getInt("room_capacity");
				String amenities = rs.getString("AMENITIES");
				int price = rs.getInt("pricepernight");
				
				RoomType roomtype = new RoomType(tname, rcapacity, amenities, price);
				rt.add(roomtype);
			}
		}
		catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("Failed to retrieve room types: " + e.getMessage());
	    }
	    return rt;
		
	}
	
	
	public static void showRoomTypes(List<RoomType> roomTypes, Customer cus) throws NumberFormatException, IOException, SQLException, EmailException, PasswordException, DateValidator {
		 int boxWidth = 108;

		   
		    System.out.println("+" + "-".repeat(boxWidth) + "+");

		    for (RoomType type : roomTypes) {
		       
		        System.out.printf("| %-14s: %-90s |\n", "Room Type", type.getType_name());
		        System.out.printf("| %-14s: %-90d |\n", "Capacity", type.getRoom_capacity());
		        System.out.printf("| %-14s: %-90s |\n", "Amenities", type.getAmenity());
		        System.out.printf("| %-14s: %-90d |\n", "Price/Night", type.getPricePerNight());
		        // Print the middle separator of the box
		        System.out.println("|" + "-".repeat(boxWidth) + "|");
		    }

		    
		    System.out.println("+" + "-".repeat(boxWidth) + "+");
	    App.customerMenu(cus);
	}
	public static boolean showTypeRooms(Customer cus) throws NumberFormatException, IOException, EmailException, PasswordException, SQLException, DateValidator {
		 try {
		        List<RoomType> roomTypes = getRoomType();
		        showRoomTypes(roomTypes, cus);
		    } catch (SQLException e) {
		    	System.out.println("Error !!!!!");
		    	throw new SQLException("Failed to show room types: " + e.getMessage());
		    }
		    return false;
		
    }
//	public static void bookAvailableRoom(String status) throws NumberFormatException, IOException {
//		try {
//	        // Query to select the first available room
//	        String query = "SELECT ROOM_NO FROM rooms WHERE ROOM_STATUS = 'Available' ";
//	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
//	        ResultSet rs = ps.executeQuery();
//	        if (rs.next()) {
//	            int roomNo = rs.getInt("ROOM_NO");
//	            // Book the room
//	            bookReservation();
//	        } else {
//	            System.out.println("No available rooms found.");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    
//	}

	
//		public static void bookReservation( ) throws NumberFormatException, IOException {
//		    try {
//			    	System.out.println("Enter The Room Model (Standard | Luxury | FamilyRoom");
//			    	String model = sc.readLine();
//			    	System.out.println("Enter The Room No for Reservation:");
//			    	int roomNo = Integer.parseInt(sc.readLine());
//	
//			    	// Check if the room number exists in the db and its status is available
//			    	if (checkRoomAvailability(roomNo)) {
//			    	    // Room is available, proceed with reservation
//			    	    String query = "UPDATE room SET room_status = 'Booked' WHERE room_no = ?";
//			    	    PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
//			    	    preparedStatement.setInt(1, roomNo);
//			    	    int rowsAffected = preparedStatement.executeUpdate();
//			    	    if (rowsAffected > 0) {
//			    	        System.out.println("Reservation booked successfully");
//			    	    } else {
//			    	        System.out.println("Failed to book reservation");
//			    	    }
//			    	} else {
//			    	    // Room is not available
//			    	    System.out.println("Room is not available for reservation. Please choose another room.");
//			    	    App.customerMenu();
//			    	}
//			    }
//		    
//		    	catch(Exception e )
//		    	{
//		    		System.out.print(e);
//		    	}
//	}
	public static void bookRoomByModel(Customer cus) throws NumberFormatException, EmailException, PasswordException, IOException, SQLException, DateValidator {
	    try {
	    	 Room room = new Room();
	    	 RoomType roomtype = new RoomType();
	        // Display available room models (type_name)
	        System.out.println("Available Room Models:");
//	        showRoomModels();
	        System.out.println("1. Standard\n2. Luxury\n3. Family Room");
	        // Allow the user to select a room model
//	        System.out.println("Enter The Room Model (1 or 2 or 3):");
	        String modelOption = sc.readLine();
	        String model;
	        switch (modelOption) {
	            case "1":
	                model = "Standard";
	                break;
	            case "2":
	                model = "Luxury";
	                break;
	            case "3":
	                model = "Family Room";
	                break;
	            default:
	                System.out.println("Invalid option. Please enter a valid option.");
//	                App.customerMenu(cus);
	                bookRoomByModel(cus);
	                return;
	        }

	        // Fetch available room numbers for the selected model
	        String query = "SELECT * FROM room JOIN roomtype ON room.type_id = roomtype.type_id WHERE roomtype.type_name = ? AND room.room_status = 'AVAILABLE'";
	        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
	        preparedStatement.setString(1, model);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        // Display available room numbers
	        boolean roomFound = false;
//	        int getRoom =0;
	        System.out.println("Available Room Numbers for " + model + ":");
	        while (resultSet.next()) {
	            int roomNo = resultSet.getInt("room_no");
	        	room.setRoomNo(resultSet.getInt("room_no"));
	        	room.setType_id(resultSet.getInt("type_id"));
	        	roomtype.setPricePerNight(resultSet.getInt("pricepernight"));
//	           
	            System.out.println(roomNo);
	            roomFound = true;
	        }

	        if (!roomFound) {
	            // No available rooms for the selected model
	            System.out.println("No AVAILABLE rooms for " + model);
	            App.customerMenu(cus);
	            return;
	        }

	        // Allow the user to select a room number for booking
	        int roomNo;
	        while(true) {
	            try {
	                System.out.println("Enter The Room No for Reservation:");
	                roomNo = Integer.parseInt(sc.readLine());
	                room.setRoomNo(roomNo);
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Not Accept Alphanetical or any symbol. Please enter room-no (eg : 1)");
	            }
	        }
	        //To check roo
//	        System.out.println("ID "+cus.getCustomer_id());
//	        System.out.println("ROOMNO"+room.getRoomNo());
	        // Check if the room number exists in the db and its status is available
	        if (checkRoomAvailability(roomNo, room.getType_id())) {
	            // Room is available, proceed with reservation
	        	
	        	//UPDATE CHECKIN AND CHECKOUT
	        	 // UPDATE CHECKIN AND CHECKOUT :
	        	 String checkin = "";
	             String checkout = "";
	             // Prompt for check-in date
	             LocalDate checkinDate = null;
	             LocalDate checkoutDate = null;

	             while (true) {
	                 System.out.println("Enter Check-In Date (yyyy-MM-dd): ");
	                  checkin = sc.readLine();

	                 try {
	                     checkinDate = LocalDate.parse(checkin);

	                     if (checkinDate.isBefore(LocalDate.now())) {
	                         System.out.println("Cannot book rooms for the past. Please choose a future date to book!");
	                         continue;
	                     }

	                     break;
	                 } catch (DateTimeParseException e) {
	                     System.out.println("Please enter the date in the format: yyyy-MM-dd");
	                 }
	             }
	             while (true) {
	                 System.out.println("Enter Check-Out Date (yyyy-MM-dd): ");
	                  checkout = sc.readLine();

	                 try {
	                     checkoutDate = LocalDate.parse(checkout);

	                     if (checkoutDate.isBefore(checkinDate)) {
	                         System.out.println("Check-Out date must be after the Check-In date. Please enter a valid Check-Out date.");
	                         continue;
	                     }

	                     break;
	                 } catch (DateTimeParseException e) {
	                     System.out.println("Please enter the date in the format: yyyy-MM-dd");
	                 }
	             }

	             while (true) {
	                 System.out.println("Do you want to continue? (Y/N)");
	                 String choice = sc.readLine().trim().toUpperCase();

	                 if (choice.equalsIgnoreCase("N")) {
	                     // Back to customer menu
	                     System.out.println("Take Your Own time and Book Room!!!");
	                     App.customerMenu(cus);
	                     break; // Exit the loop and return to the customer menu
	                 } else if (choice.equalsIgnoreCase("Y")) {
	                     try {
	                         String insertQuery = "INSERT INTO booking (booking_id, customer_id, room_no, checkin, checkout, booking_status) VALUES (book.nextval, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?)";
	                         PreparedStatement insertStatement = DbmsConnection.getConnection().prepareStatement(insertQuery);

	                         insertStatement.setInt(1, cus.getCustomer_id());
	                         insertStatement.setInt(2, room.getRoomNo());
	                         insertStatement.setString(3, checkin);
	                         insertStatement.setString(4, checkout);
	                         insertStatement.setString(5, "Reserved");
	                         insertStatement.executeUpdate();
	                         System.out.println("BOOKING RESERVED");

	                         // Payment process
	                         PaymentModule pm = new PaymentModule();
	                         boolean paymentSuccess = pm.capturePayment(cus, room, roomtype);
	                         if (paymentSuccess) {
	                             break; // Exit the loop if payment is successful
	                         }
	                     } catch (Exception e) {
	                         System.out.println("Booking not inserted: " + e.getMessage());
	                     }
	                 } else {
	                     System.out.println("Invalid Option. Please Enter 'Y' or 'N'");
	                 }
	             }

	             System.out.println("Check-In Date: " + checkin);
	             System.out.println("Check-Out Date: " + checkout);
	         } else {
	             // Room is not available
	             System.out.println("Room is not available for reservation. Please choose another room.");
	             bookRoomByModel(cus);
	         }
	     } catch (SQLException e) {
	         System.out.println("SQL Error: " + e.getMessage());
	     	App.customerMenu(cus);
	     } catch (IOException | NumberFormatException e) {
	    	 System.out.println("Failed to book room by model: " + e.getMessage());
		    	App.customerMenu(cus);
//	         System.out.println("Invalid Error: " + e.getMessage());
	     }
	}
	
	// VALIDATE DATE FOR CHECKIN ND CHECKOUT :
	private static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Disable lenient parsing
        try {
            java.util.Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in the format yyyy-MM-dd.");
            return false;
        }
    }
	
		// MODIFY BOOKINGS : 
	public static void modifyReservation(Customer cus) throws SQLException, IOException, NumberFormatException, EmailException, PasswordException, DateValidator {
	    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	    try {
	        String query = "SELECT b.room_no, b.booking_id, r.room_status FROM booking b JOIN room r ON b.room_no = r.room_no WHERE b.customer_id = ? AND b.booking_status = 'Booked' AND r.room_status = 'Booked'";
	        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
	        preparedStatement.setInt(1, cus.getCustomer_id());
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Check if the result set is empty
	        boolean hasBookings = false;
	        System.out.println("+------------+-------------+-------------+");
	        System.out.println("| Room Number| Booking ID  | Room Status |");
	        System.out.println("+------------+-------------+-------------+");

	        while (resultSet.next()) {
	            hasBookings = true;
	            int bookedRoomNo = resultSet.getInt("room_no");
	            int bookingId = resultSet.getInt("booking_id");
	            String roomStatus = resultSet.getString("room_status");

	            // Format the data to fit into the table
	            String roomNoFormatted = String.format("| %-11d", bookedRoomNo);
	            String bookingIdFormatted = String.format("| %-12d", bookingId);
	            String roomStatusFormatted = String.format("| %-12s", roomStatus);

	            System.out.println(roomNoFormatted + bookingIdFormatted + roomStatusFormatted + "|");
	        }

	        System.out.println("+------------+-------------+-------------+");


	        if (!hasBookings) {
	            System.out.println("No bookings found for the customer.");
	            App.customerMenu(cus);
	            return;
	        }

	        int roomNo = 0;
	        try {
	            System.out.println("Enter Your Booking Room No:");
	            roomNo = Integer.parseInt(sc.readLine());

	            // Proceed with further logic using roomNo
	            System.out.println("You have entered room number: " + roomNo);

	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid room number.");
	            return;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading input: " + e.getMessage());
	            return;
	        }

	        // Verify if the customer ID and room number are associated with a booking
	        if (verifyCustomerId(cus.getCustomer_id(), roomNo)) {
	            System.out.println("Are you sure you want to modify your reservation for Room " + roomNo + "? (yes/no)");
	            String confirmation = sc.readLine();

	            if ("yes".equalsIgnoreCase(confirmation)) {
	                // Proceed with modification
	                String checkin = "";
	                String checkout = "";
	                LocalDate checkinDate = null;
	                LocalDate checkoutDate = null;

	                while (true) {
	                    System.out.println("Enter Check-In Date (yyyy-MM-dd): ");
	                    checkin = sc.readLine();

	                    try {
	                        checkinDate = LocalDate.parse(checkin);

	                        if (checkinDate.isBefore(LocalDate.now())) {
	                            System.out.println("Cannot book rooms for the past. Please choose a future date to book!");
	                            continue;
	                        }

	                        break;
	                    } catch (DateTimeParseException e) {
	                        System.out.println("Please enter the date in the format: yyyy-MM-dd");
	                    }
	                }

	                while (true) {
	                    System.out.println("Enter Check-Out Date (yyyy-MM-dd): ");
	                    checkout = sc.readLine();

	                    try {
	                        checkoutDate = LocalDate.parse(checkout);

	                        if (checkoutDate.isBefore(checkinDate)) {
	                            System.out.println("Check-Out date must be after the Check-In date. Please enter a valid Check-Out date.");
	                            continue;
	                        }

	                        break;
	                    } catch (DateTimeParseException e) {
	                        System.out.println("Please enter the date in the format: yyyy-MM-dd");
	                    }
	                }

	                String updateQuery = "UPDATE booking SET checkin = TO_DATE(?, 'YYYY-MM-DD'), checkout = TO_DATE(?, 'YYYY-MM-DD'), booking_status = 'Booked' WHERE room_no = ?";

	                PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(updateQuery);
	                ps.setString(1, checkin);
	                ps.setString(2, checkout);
	                ps.setInt(3, roomNo);
	                int rowsAffected = ps.executeUpdate();
	                if (rowsAffected > 0) {
	                    // Update room status to 'Available'
	                    String updateRoomQuery = "UPDATE room SET room_status = 'Booked' WHERE room_no = ?";
	                    PreparedStatement updateRoomStatement = DbmsConnection.getConnection().prepareStatement(updateRoomQuery);
	                    updateRoomStatement.setInt(1, roomNo);
	                    updateRoomStatement.executeUpdate();

	                    System.out.println("Modification Updated!");
	                    App.customerMenu(cus);
	                }
	            } else if ("no".equalsIgnoreCase(confirmation)) {
	                System.out.println("Modification canceled. Your reservation remains unchanged.");
	                App.customerMenu(cus);
	            } else {
	                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
	                App.customerMenu(cus);
	            }
	        } else {
	            System.out.println("Invalid room number. No reservation found.");
	            App.customerMenu(cus);
	        }
	    } catch (SQLException e) {
	        System.out.println("Failed to modify reservation: " + e.getMessage());
	        App.customerMenu(cus);
	    }
	}



	public static boolean verifyCustomerId(int customerId, int roomNo) throws SQLException {
	    String query = "SELECT b.customer_id, r.room_no FROM booking b JOIN room r ON b.room_no = r.room_no WHERE b.customer_id = ? AND b.room_no = ?";
	    try {
	        PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query);
	        ps.setInt(1, customerId);
	        ps.setInt(2, roomNo);
	        ResultSet rs = ps.executeQuery();
	        boolean bookingFound = false;
	        if (rs.next()) {
	            // Booking found for the given customer ID and room number
	            bookingFound = true;
	        }
	        if (!bookingFound) {
	            System.out.println("Booking not found for the given customer ID and room number.");
	        }
	        return bookingFound;
	    } catch (SQLException e) {
	        System.err.println("Error verifying customer ID and room number: " + e.getMessage());
	        return false;
	    }
	}


	private static void showRoomModels() throws SQLException {
	    String query = "SELECT DISTINCT type_name FROM roomtype";
	    PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    int n = 1;
	    while (resultSet.next()) {
	        String roomModel = resultSet.getString("type_name");
	        switch (roomModel) {
	            case "Standard":
	                System.out.println("1. Standard");
	                break;
	            case "Luxury":
	                System.out.println("2. Luxury");
	                break;
	            case "FamilyRoom":
	                System.out.println("3. Family Room");
	                break;
	            default:
	                System.out.println(n + ". " + roomModel);
	                break;
	        }
	        n++;
	    }
	}


			public static void showAvailableRooms(Customer cus) throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
	        try {
	        	String query = "SELECT * FROM room r JOIN roomtype rt ON r.type_id = rt.type_id WHERE r.room_status = 'AVAILABLE' ";

//	        	String query = "SELECT rt.type_name, r.room_no FROM room r JOIN roomtype rt ON r.type_id = rt.type_id WHERE r.room_status = 'Available'";
	            PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            boolean foundAvailableRooms = false;

	            while (resultSet.next()) {
	                int roomNo = resultSet.getInt("room_no");
	                String roomStatus = resultSet.getString("room_status");
	                String roomCondition = resultSet.getString("room_condition");
	                String type = resultSet.getString("type_name");
	                System.out.println("+----------------------------------------------------+");
	                System.out.println("|                   Available Rooms                  |");
	                System.out.println("+---------+------------------+--------------+---------+");
	                System.out.println("| Room No | Type Of Room     | Room Status  | Condition");
	                System.out.println("+---------+------------------+--------------+---------+");
	                System.out.println("| " + String.format("%-7s", roomNo) + " | " + String.format("%-16s", type) + " | " + String.format("%-12s", roomStatus) + " | " + String.format("%-8s", roomCondition) + "|");
	                System.out.println("+---------+------------------+--------------+---------+");


	                foundAvailableRooms = true;

	            }
	            

	            if (!foundAvailableRooms) {
	                System.out.println("No available rooms found.");
	                App.customerMenu(cus);
	            }
	            else {
	            	App.customerMenu(cus);
	            	
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new SQLException("Failed to show available rooms: " + e.getMessage());
	        }
	    }
		
//		public static void showReservedRooms() throws NumberFormatException, IOException, InvalidUsernameExceptions, PasswordException {
//	        try {
//	            String query = "SELECT * FROM room where room_status = 'Occupied' ";
//	            PreparedStatement ps= DbmsConnection.getConnection().prepareStatement(query);
//	            ResultSet rs = ps.executeQuery();
//	            while (rs.next()) {
//	                System.out.println(rs.getInt("room_no") + " - " + rs.getString("room_status"));
//	            }
//	            App.customerMenu();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }

		
		// Check the Room no exists or not :
		public static boolean checkRoomAvailability(int roomNo, int type_id) {
		    try {
		    	RoomType rt = new RoomType();
		        String query = "SELECT * FROM room WHERE room_no = ? and type_id = ? and room_status ='AVAILABLE'";
		        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
		        
		        preparedStatement.setInt(1, roomNo);
		        preparedStatement.setInt(2, type_id);
		        if(type_id==1)
		        {
		        	rt.setPricePerNight(500);
		        	
		        }
		        else if(type_id==2)
		        {
		        	rt.setPricePerNight(3000);
		        }
		        else if(type_id==3)
		        {
		        	rt.setPricePerNight(2000);
		        }
		        
		        ResultSet resultSet = preparedStatement.executeQuery();
		        
		        if (resultSet.next()) {
		        	
//		        	rt.setPricePerNight(type_id);
		            String roomStatus = resultSet.getString("room_status");
		            // Check if room status is "Available"
//		            System.out.println(roomStatus);
		            return roomStatus.equalsIgnoreCase("Available");
		        }
		            
		            return false;
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		// TO show booked rooms of booked customer-id :
		public static void showBookedRooms(Customer cus) throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
		    try {
		        String query = "SELECT b.room_no, b.booking_id, r.room_status FROM booking b JOIN room r ON b.room_no = r.room_no WHERE b.customer_id = ? AND b.booking_status = 'Booked' AND r.room_status = 'Booked'";
		        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
		        preparedStatement.setInt(1, cus.getCustomer_id());
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Check if the result set is empty
		        boolean hasBookings = false;
		        int roomNumberWidth = 11;
		        int bookingIdWidth = 13;
		        int roomStatusWidth = 13;

		        // Create horizontal line and header
		        String horizontalLine = "+" + "-".repeat(roomNumberWidth + 2) + "+"
		                + "-".repeat(bookingIdWidth + 2) + "+"
		                + "-".repeat(roomStatusWidth + 2) + "+";
		        String header = "| " + padRight("Room Number", roomNumberWidth) + " | "
		                + padRight("Booking ID", bookingIdWidth) + " | "
		                + padRight("Room Status", roomStatusWidth) + " |";

		        // Print header
		        System.out.println(horizontalLine);
		        System.out.println(header);
		        System.out.println(horizontalLine);

		        while (resultSet.next()) {
		            hasBookings = true;
		            int bookedRoomNo = resultSet.getInt("room_no");
		            int bookingId = resultSet.getInt("booking_id");
		            String roomStatus = resultSet.getString("room_status");

		            String roomNumberStr = String.valueOf(bookedRoomNo);
		            String bookingIdStr = String.valueOf(bookingId);

		            String row = "| " + padRight(roomNumberStr, roomNumberWidth) + " | "
		                    + padRight(bookingIdStr, bookingIdWidth) + " | "
		                    + padRight(roomStatus, roomStatusWidth) + " |";

		            System.out.println(row);
		        }
		        System.out.println(horizontalLine);

		        if (!hasBookings) {
		            System.out.println("No bookings found for the customer.");
		        }

		        App.customerMenu(cus);

		    } catch (SQLException e) {
		        System.out.println("Failed to retrieve booked rooms: " + e.getMessage());
		        App.customerMenu(cus);
		    }
		}


		 public static String padRight(String text, int length) {
		        return text + " ".repeat(length - text.length());
		    }
		// Method to perform canceling reservation
		public static void cancelReservation(Customer cus) throws NumberFormatException, IOException, EmailException, PasswordException, SQLException, DateValidator {
			 RoomType roomtype = new RoomType();
			try {
		    	String q = "SELECT b.room_no, b.booking_id, r.room_status, rt.type_name, rt.room_capacity, rt.amenities, rt.pricepernight FROM booking b JOIN room r ON b.room_no = r.room_no JOIN roomtype rt ON r.type_id = rt.type_id WHERE b.customer_id = ? AND r.room_status = 'Booked'";
		    	
		        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(q);
		        preparedStatement.setInt(1, cus.getCustomer_id());
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Check if the result set is empty
		        boolean hasBookings = false;
		        System.out.println("+------------+-------------+-------------+");
		        System.out.println("| Room Number| Booking ID  | Room Status |");
		        System.out.println("+------------+-------------+-------------+");

		        while (resultSet.next()) {
		            hasBookings = true;
		            int bookedRoomNo = resultSet.getInt("room_no");
		            int bookingId = resultSet.getInt("booking_id");
		            String roomStatus = resultSet.getString("room_status");
		            roomtype.setPricePerNight(resultSet.getInt("pricepernight"));	

		            // Format the data to fit into the table
		            String roomNoFormatted = String.format("| %-11d", bookedRoomNo);
		            String bookingIdFormatted = String.format("| %-12d", bookingId);
		            String roomStatusFormatted = String.format("| %-12s", roomStatus);

		            System.out.println(roomNoFormatted + bookingIdFormatted + roomStatusFormatted + "|");
		        }

		        System.out.println("+------------+-------------+-------------+");


		        if (!hasBookings) {
		            System.out.println("No bookings found for the customer.");
		            App.customerMenu(cus);
		            return;
		        }

		        int roomNo = 0;
		        try {
		            System.out.println("Enter The Room That You Have Booked:");
		             roomNo = Integer.parseInt(sc.readLine());

		            // Proceed with further logic using roomNo
		            System.out.println("You have entered room number: " + roomNo);

		        } catch (NumberFormatException e) {
		            System.out.println("Invalid input. Please enter a valid room number.");
		        } catch (IOException e) {
		            System.out.println("An error occurred while reading input: " + e.getMessage());
		        }

		     // Check if the room status is 'Booked' before canceling the reservation
	            String query1 = "SELECT customer_id, room_no FROM booking WHERE room_no = ? AND customer_id = ?";
	            PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(query1);
	            ps.setInt(1, roomNo);
	            ps.setInt(2, cus.getCustomer_id());
	            resultSet = ps.executeQuery();

	            if (resultSet.next()) {
	                int customerId = resultSet.getInt("customer_id");
	                int roomNo1 = resultSet.getInt("room_no");

	                if (roomNo == roomNo1 && customerId == cus.getCustomer_id()) {
	                    System.out.println("Are you sure you want to cancel the reservation for Room " + roomNo1 + "? (yes/no)");
	                    String confirmation = sc.readLine();

	                    if ("yes".equalsIgnoreCase(confirmation)) {
	                        // Update booking status to 'Canceled'
	                        String updateQuery = "UPDATE booking SET booking_status = 'Canceled' WHERE room_no = ?";
	                        PreparedStatement updateStatement = DbmsConnection.getConnection().prepareStatement(updateQuery);
	                        updateStatement.setInt(1, roomNo1);
	                        updateStatement.executeUpdate();

	                        // Update room status to 'AVAILABLE'
	                        String updateRoomQuery = "UPDATE room SET room_status = 'AVAILABLE' WHERE room_no = ?";
	                        PreparedStatement updateRoomStatement = DbmsConnection.getConnection().prepareStatement(updateRoomQuery);
	                        updateRoomStatement.setInt(1, roomNo1);
	                        updateRoomStatement.executeUpdate();

	                        // Delete payment associated with the canceled reservation
	                        String deletePaymentQuery = "DELETE FROM payment WHERE booking_id IN (SELECT booking_id FROM booking WHERE customer_id = ?)";
	                        PreparedStatement deletePaymentStatement = DbmsConnection.getConnection().prepareStatement(deletePaymentQuery);
	                        deletePaymentStatement.setInt(1, customerId);
	                        int rows = deletePaymentStatement.executeUpdate();

	                        int pricePerNight = roomtype.getPricePerNight();
	                        if (rows > 0) {
	                            System.out.println("Payment will be refunded Rs." + pricePerNight + " within 7 working days...");
	                        }
	                        System.out.println("Reservation for Room " + roomNo1 + " canceled successfully for Customer ID " + customerId);

	                    } else {
	                        System.out.println("Cancellation aborted. Your reservation remains active.");
	                    }

	                } else {
	                    System.out.println("Invalid room number provided for the booked customer ID");
	                }
	            } else {
	                System.out.println("No reservation found for the provided room number");
	            }
	            App.customerMenu(cus);
	        } catch (SQLException e) {
	            System.out.println("Failed to cancel reservation: " + e.getMessage());
	            App.customerMenu(cus);
	        }
		}



			 
//
//			        if (resultSet.next()) {
//			            String roomStatus = resultSet.getString("room_status");
//			            if ("Booked".equalsIgnoreCase(roomStatus)) {
//			                // Room is booked, proceed with canceling the reservation
//			                updateRoomStatus(roomNo, "Available");
//			                System.out.println("Reservation for Room " + roomNo + " canceled successfully");
////			                deleteBook(cus.getCustomer_id(),room.getRoomNo());
//			                
//			            } 
//			            else if("Occupied".equalsIgnoreCase(roomStatus)) {
//			                // Room is not booked, display a message
//			            	System.out.println("Room "+roomNo+ " is Alread Occupied ");
//			            	App.customerMenu();
//			               
//			            }
//			            else {
//			            	 System.out.println("Room " + roomNo + " is not currently booked. No reservation to cancel.");
//			            	 App.customerMenu();
//			            	 throw new RoomNotFoundException("Room Not Available");
//			            }
//			        } else {
//			            // Room does not exist
//			            System.out.println("Room " + roomNo + " does not exist.");
//			            App.customerMenu();
//			        }
//			    } catch (SQLException | IOException e) {
////		            e.printStackTrace();
//		            System.out.println("Failed to cancel reservation: " + e.getMessage());
//		        } catch (RoomNotFoundException e) {
//		            System.out.println("Room not found: " + e.getMessage());
//		        }
		

		public static void updateRoomStatus(Customer cus,Room room, String status) throws NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
		    try {
		        String query = "UPDATE room SET ROOM_STATUS = ? WHERE ROOM_NO = ?";
		        PreparedStatement preparedStatement = DbmsConnection.getConnection().prepareStatement(query);
		        preparedStatement.setString(1, status);
		        preparedStatement.setInt(2, room.getRoomNo());
		        int rowsAffected = preparedStatement.executeUpdate();
		        if (rowsAffected > 0) {
		        	System.out.println("Reservation for Room " + room.getRoomNo() + " canceled successfully");
		        	 deleteBook(cus,room.getRoomNo());
		        } else {
		            System.out.println("Failed to update room status");
		        }
		        App.customerMenu(cus);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public static void deleteBook(Customer cus, int roomno) throws SQLException, NumberFormatException, IOException, EmailException, PasswordException
		{
			String sql = "DELETE from booking where customer_id = ? and room_no = ?";
			PreparedStatement ps = DbmsConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, cus.getCustomer_id());
			ps.setInt(2, roomno);
			int rows= ps.executeUpdate();
//			if(rows>0) {
//				App.customerMenu();
//			}
		}
}
		
