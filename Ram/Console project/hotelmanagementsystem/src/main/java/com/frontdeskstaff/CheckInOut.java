package com.frontdeskstaff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.bookrooms.Booking;
import com.exception.DateValidator;
import com.exception.EmailException;
import com.exception.PasswordException;
import com.jamocha.hotelmanagementsystem.App;
import com.person.DbmsConnection;

public class CheckInOut {
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public static void checkinOut() throws NumberFormatException, IOException, SQLException, EmailException, PasswordException, DateValidator {
    	
    	 boolean exit = false;
    	    while (!exit) {
    	        displayReceptionistMenu();
    	        System.out.print("Enter your choice: ");
    	        int choice = Integer.parseInt(sc.readLine());
    	        
    	        switch (choice) {
    	            case 1:
    	                // Call method to view all bookings
    	            	displayBookedRooms();
    	                break;
    	            case 2:
    	                // Call method to update check-in status
    	            	updateRoomStatusOnCheckIn();
    	                break;
    	            case 3:
    	                // Call method to update check-out status
    	                updateRoomStatusOnCheckOut();
    	                break;
    	            case 4:
    	                // Call method to process payment
    	                processPayment();
    	                break;
    	            case 5:
    	                // Exit to main menu
    	                exit = true;
    	                App.menu();
    	                break;
    	            default:
    	                System.out.println("Invalid choice. Please select a valid option.");
    	        }
    	    }
    	}
        


    private static void displayBookedRooms() throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
        String query = "SELECT b.booking_id, b.room_no, c.f_name, c.email, b.checkin, b.checkout " +
                       "FROM booking b " +
                       "JOIN customer c ON b.customer_id = c.customer_id " +
                       "WHERE b.booking_status IN ('Booked', 'Reserved')";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            // Display booked rooms and customer details
        	 System.out.println("+------------+------------+----------------+-----------------------+--------------+--------------------------------+");
        	    System.out.println("| Booking ID | Room Number| Customer Name  | Customer Email        | Check-in Date      | Check-out Date           |   ");
        	    System.out.println("+------------+------------+----------------+-----------------------+--------------+--------------------------------+");

        	    while (rs.next()) {
        	        int bookingId = rs.getInt("booking_id");
        	        int roomNo = rs.getInt("room_no");
        	        String fName = rs.getString("f_name");
        	        String email = rs.getString("email");
        	        String checkIn = rs.getString("checkin");
        	        String checkOut = rs.getString("checkout");

        	        System.out.printf("| %-10d | %-10d | %-14s | %-21s | %-15s | %-9s |\n",
        	                          bookingId, roomNo, fName, email, checkIn, checkOut);
        	        System.out.println("+------------+------------+----------------+-----------------------+--------------+--------------------------------+");
        	    }
            
            
            // Update room status based on check-in and check-out dates
//            updateRoomStatusOnCheckIn();
//            updateRoomStatusOnCheckOut();
            try {
				checkinOut();
			} catch (NumberFormatException | IOException | EmailException | PasswordException | DateValidator e) {
                System.out.println("Please Enter the Option which was given in the console !!!" );
                checkinOut();
//				e.printStackTrace();
			}
        } catch (SQLException e) {
        	System.out.println("Error occurred while fetching booking details: ");
        	checkinOut();
//            throw new SQLException("Error occurred while fetching booking details: ");
        }
    }

    // Method to update room status on check-in dates
    private static void updateRoomStatusOnCheckIn() throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
    	 // Ask the user if they want to proceed with updating the status
        System.out.println("Do you want to update the status for all bookings with check-in date today? (yes/no)");
        String userInput = sc.readLine().trim().toLowerCase();
        
        
        
        if (userInput.equalsIgnoreCase("yes")) {
            
        
        // Format the current date to match the database date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        String formattedCurrentDate = currentDate.format(formatter);

        String fetchBookingsQuery = "SELECT b.booking_id, c.f_name, b.room_no, b.checkin " +
                                    "FROM booking b " +
                                    "JOIN customer c ON b.customer_id = c.customer_id " +
                                    "WHERE b.checkin = ?";

        String updateRoomQuery = "UPDATE room SET room_status = 'Occupied' " +
                                 "WHERE room_no IN (SELECT room_no FROM booking WHERE checkin = ?)";

        String updateBookingQuery = "UPDATE booking SET booking_status = 'Occupied' " +
                                    "WHERE checkin = ?";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement psFetch = conn.prepareStatement(fetchBookingsQuery);
             PreparedStatement psRoom = conn.prepareStatement(updateRoomQuery);
             PreparedStatement psBooking = conn.prepareStatement(updateBookingQuery)) {

           

            // Set the formatted current date parameter for fetching bookings
            psFetch.setString(1, formattedCurrentDate);

            // Fetch and display the booking details
            try (ResultSet rs = psFetch.executeQuery()) {
                boolean hasBookings = false;

                System.out.println("+------------+----------------+------------+--------------+");
                System.out.println("| Booking ID | Customer Name  | Room Number| Check-in Date|");
                System.out.println("+------------+----------------+------------+--------------+");

                while (rs.next()) {
                    hasBookings = true;
                    int bookingId = rs.getInt("booking_id");
                    String fName = rs.getString("f_name");
                    int roomNo = rs.getInt("room_no");
                    String checkIn = rs.getString("checkin");

                    System.out.printf("| %-10d | %-14s | %-10d | %-12s |\n",
                                      bookingId, fName, roomNo, checkIn);
                    System.out.println("+------------+----------------+------------+--------------+");
                }

                if (!hasBookings) {
                    System.out.println("No bookings found with check-in date today.");
                    checkinOut();
                    return;
                }
            }

         

            // Set the formatted current date parameter for both update queries
            psRoom.setString(1, formattedCurrentDate);
            psBooking.setString(1, formattedCurrentDate);

            // Execute the room status update query
            int roomRowsAffected = psRoom.executeUpdate();

            // Execute the booking status update query
            int bookingRowsAffected = psBooking.executeUpdate();

            // Check if any rooms or bookings were affected
            if (roomRowsAffected > 0) {
                System.out.println("Room status updated to 'Occupied' for rooms with check-in date today.");
                System.out.println();
            } else {
                System.out.println("No rooms found with check-in date today.");
            }

            if (bookingRowsAffected > 0) {
                System.out.println("Booking status updated to 'Occupied' for bookings with check-in date today.");
                System.out.println();
            } else {
                System.out.println("No bookings found with check-in date today.");
            }

            checkinOut();
        } 
        
        
       
        catch (SQLException e) {
            System.out.println("Error occurred while updating statuses on check-in!!!! ");
            checkinOut();
        } catch (NumberFormatException | IOException | EmailException | PasswordException | DateValidator e) {
            System.out.println("Please Enter the Option which was given in the console !!!");
            checkinOut();
        }
        }
        else if(userInput.equalsIgnoreCase("no"))
        {
        	System.out.println("Status update canceled. Returning to receptionist menu.");
            checkinOut();
        }
        else {
        	 // Handle invalid input
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            updateRoomStatusOnCheckIn(); 
        }
    }




    // Method to update room status on check-out dates
    private static void updateRoomStatusOnCheckOut() throws SQLException, NumberFormatException, IOException, EmailException, PasswordException, DateValidator {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
        String formattedCurrentDate = currentDate.format(formatter);

        // Ask the user if they want to display the booking details
        System.out.println("Do you want to display the booking details? (yes/no)");
        String response = sc.readLine().trim().toLowerCase();

        if (response.equals("yes")) {
            // Query to retrieve booking details with checkout date today
            String query = "SELECT b.booking_id, b.room_no, c.f_name, b.checkout " +
                           "FROM booking b " +
                           "JOIN customer c ON b.customer_id = c.customer_id " +
                           "WHERE b.checkout = ?";

            try (Connection conn = DbmsConnection.getConnection();
                 PreparedStatement psQuery = conn.prepareStatement(query)) {

                // Set the parameter for the query
                psQuery.setString(1, formattedCurrentDate);
                try (ResultSet rs = psQuery.executeQuery()) {
                    System.out.println("+------------+------------+------------------+-----------------------+");
                    System.out.println("| Booking ID | Room Number| Customer Name    | Checkout              |		  "	);
                    System.out.println("+------------+------------+------------------+-----------------------+");

                    boolean hasBookings = false;
                    while (rs.next()) {
                        hasBookings = true;
                        int bookingId = rs.getInt("booking_id");
                        int roomNo = rs.getInt("room_no");
                        String customerName = rs.getString("f_name");
                        String checkoutDate = rs.getString("checkout");

                        System.out.printf("| %-10d | %-10d | %-16s | %-12s |\n", bookingId, roomNo, customerName, checkoutDate);
                    }
                    System.out.println("+------------+------------+------------------+-----------------------+");

                    if (!hasBookings) {
                        System.out.println("No bookings found with check-out date today.");
                        checkinOut();
                        return;
                    }
                }
            }

            // Queries to update room status, booking status, and housekeeping requests
            String updateRoom = "UPDATE room SET room_status = 'AVAILABLE' " +
                                "WHERE room_no IN (SELECT room_no FROM booking WHERE checkout = ?)";
            String updateBook = "UPDATE booking SET booking_status = 'Vacated' " +
                                "WHERE checkout = ?";
            String updateHousekeep = "UPDATE room SET housekeeping_request = NULL " +
                                     "WHERE room_no IN (SELECT room_no FROM booking WHERE checkout = ?)";

            try (Connection conn = DbmsConnection.getConnection();
                 PreparedStatement psRoom = conn.prepareStatement(updateRoom);
                 PreparedStatement psBooking = conn.prepareStatement(updateBook);
                 PreparedStatement psHousekeeping = conn.prepareStatement(updateHousekeep)) {

                // Set the parameter and execute the update queries
                psRoom.setString(1, formattedCurrentDate);
                int roomRowsAffected = psRoom.executeUpdate();

                psBooking.setString(1, formattedCurrentDate);
                int bookingRowsAffected = psBooking.executeUpdate();

                psHousekeeping.setString(1, formattedCurrentDate);
                int housekeepingRowsAffected = psHousekeeping.executeUpdate();

                if (roomRowsAffected > 0) {
                    System.out.println("Room status updated to 'Available' for rooms with check-out date today.");
                    System.out.println();
                } else {
                    System.out.println("No rooms found with check-out date today.");
                }

                if (bookingRowsAffected > 0) {
                    System.out.println("Booking status updated to 'Vacated' for bookings with check-out date today.");
                    System.out.println();
                } else {
                    System.out.println("No bookings found with check-out date today.");
                }

                if (housekeepingRowsAffected > 0) {
                    System.out.println("Housekeeping requests deleted for customers with check-out date today.");
                    System.out.println();
                } else {
                    System.out.println("No housekeeping requests found for customers with check-out date today.");
                }

                checkinOut();
            } catch (SQLException e) {
                System.out.println("Error occurred while updating statuses on check-out!!!");
                checkinOut();
            }
        } else if (response.equals("no")) {
            // If the user does not want to display booking details, return to receptionist menu
            System.out.println("Returning to receptionist menu...");
            checkinOut();
        } else {
            // Handle invalid input
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            updateRoomStatusOnCheckOut(); // Retry the process
        }
    }


    
    // PAYMENT PROCESS :
    
    private static void processPayment() throws SQLException, EmailException, PasswordException, DateValidator {
        int bookingId = 0;
        boolean validInput = false;

        // Loop to ensure valid input for booking ID
        while (!validInput) {
            try {
                System.out.println("Enter Booking ID for payment processing:");
                bookingId = Integer.parseInt(sc.readLine());
                validInput = true;
            } catch (NumberFormatException | IOException e1) {
                System.out.println("Invalid input. Please enter a valid integer for Booking ID.");
            }
        }

        String query = "SELECT b.booking_id, b.room_no, b.checkin, b.checkout, rt.pricepernight, b.booking_status " +
                       "FROM booking b " +
                       "JOIN room r ON b.room_no = r.room_no " +
                       "JOIN roomtype rt ON r.type_id = rt.type_id " +
                       "WHERE b.booking_id = ? AND (b.booking_status = 'Booked' OR b.booking_status = 'Occupied')";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, bookingId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int roomNo = rs.getInt("room_no");
                    LocalDate checkIn = rs.getDate("checkin").toLocalDate();
                    LocalDate checkOut = rs.getDate("checkout").toLocalDate();
                    double roomRate = rs.getDouble("pricepernight");

                    long daysStayed = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
                    double totalAmount = daysStayed * roomRate;

                    // Display booking details in a table format
                    System.out.println("+------------+------------+--------------+--------------+--------------+--------------+");
                    System.out.println("| Booking ID | Room Number| Check-in Date| Check-out Date| Room Rate    | Total Amount |");
                    System.out.println("+------------+------------+--------------+--------------+--------------+--------------+");

                    String bookingIdFormatted = String.format("| %-10d ", bookingId);
                    String roomNoFormatted = String.format("| %-10d ", roomNo);
                    String checkInFormatted = String.format("| %-12s ", checkIn);
                    String checkOutFormatted = String.format("| %-12s ", checkOut);
                    String roomRateFormatted = String.format("| Rs. %-8.2f ", roomRate);
                    String totalAmountFormatted = String.format("| Rs. %-8.2f |", totalAmount);

                    System.out.println(bookingIdFormatted + roomNoFormatted + checkInFormatted + checkOutFormatted + roomRateFormatted + totalAmountFormatted);
                    System.out.println("+------------+------------+--------------+--------------+--------------+--------------+");

                    System.out.println("Enter payment amount:");

                    double paymentAmount = 0;
                    try {
                        paymentAmount = Double.parseDouble(sc.readLine());
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Please Enter the amount only....");
                    }

                    if (paymentAmount == totalAmount) {
                        System.out.println("Payment successful. Issuing receipt...");
                        issueReceipt(bookingId, roomNo, totalAmount);
                    } else {
                        System.out.println("Payment amount does not match the total amount. Please try again.");
                        processPayment();
                    }
                } else {
                    System.out.println("No booking found for the provided Booking ID.");
                    try {
                        checkinOut();
                    } catch (NumberFormatException | EmailException | PasswordException | DateValidator e) {
                        System.out.println("Please Enter the Option which was given in the console !!!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Please Enter the number.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while processing payment!");
            try {
                checkinOut();
            } catch (NumberFormatException | IOException | SQLException | EmailException | PasswordException
                    | DateValidator e1) {
                System.out.println("Invalid Input!!!");
            }
        }
    }

    
    //ISSUES RECEIPT 
    private static void issueReceipt(int bookingId, int roomNo, double totalAmount) throws SQLException, IOException, EmailException, PasswordException, DateValidator {
        // Define the receipt query
        String receiptQuery = "INSERT INTO receipt (receipt_id, booking_id, room_no, amount, receipt_date) VALUES (receipt_id.nextval , ?, ?, ?, ?)";

        // Get the current date for the receipt
        LocalDate receiptDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
        String formattedReceiptDate = receiptDate.format(formatter);

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(receiptQuery)) {

            // Set the values for the receipt
            ps.setInt(1, bookingId);
            ps.setInt(2, roomNo);
            ps.setDouble(3, totalAmount);
            ps.setString(4, formattedReceiptDate);

            // Execute the receipt insertion
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
//                String formattedReceiptDate = LocalDate.now().toString(); // Assuming you format the receipt date like this
                System.out.println("Receipt issued successfully!");
                System.out.println("Receipt Details:");
                System.out.println("+------------+------------+----------+---------------+");
                System.out.println("| Booking ID | Room Number| Amount   | Receipt Date  |");
                System.out.println("+------------+------------+----------+---------------+");

                String bookingIdFormatted = String.format("| %-10d ", bookingId);
                String roomNoFormatted = String.format("| %-10d ", roomNo);
                String totalAmountFormatted = String.format("| Rs. %-7.2f ", totalAmount);
                String receiptDateFormatted = String.format("| %-10s |", formattedReceiptDate);

                System.out.println(bookingIdFormatted + roomNoFormatted + totalAmountFormatted + receiptDateFormatted);
                System.out.println("+------------+------------+----------+---------------+");
            } 

            else {
                System.out.println("Failed to issue receipt. Please try again.");
                try {
					processPayment();
				} catch (NumberFormatException e) {
		            System.out.println("Please Enter the Option which was given in the console !!!" );
//					e.printStackTrace();
				}
            }
            try {
				checkinOut();
			} catch (NumberFormatException | IOException | EmailException | PasswordException | DateValidator e) {
	            System.out.println("Please Enter the Option which was given in the console !!!" );
//				e.printStackTrace();
			}
        } catch (SQLException e) {
            System.out.println("Error occurred while issuing receipt!");
            try {
				checkinOut();
			} catch (NumberFormatException | IOException | SQLException | EmailException | PasswordException
					| DateValidator e1) {
	            System.out.println("Error Occured in the app" );
//				e1.printStackTrace();
			}
        }
    }


    public static Booking getBookingDetailsFromMailId(String customerMailId) throws SQLException {
        String query = "SELECT * FROM booking WHERE customer_id IN (SELECT customer_id FROM customer WHERE email = ?)";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, customerMailId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int customerId = rs.getInt("customer_id");
                    String checkInDate = rs.getString("checkin");
                    String checkOutDate = rs.getString("checkout");
                    int roomNumber = rs.getInt("room_no");
                    return new Booking(customerId, checkInDate, checkOutDate, roomNumber);
                } else {
                    System.out.println("No booking found for the customer with mail ID: " + customerMailId);
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error occurred while fetching booking details: " + e.getMessage(), e);
        }
    }

    public boolean isValidDateFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Booking getBookingDetailsById(int bookingId) throws SQLException {
        String query = "SELECT * FROM booking WHERE booking_id = ?";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, bookingId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int customerId = rs.getInt("customer_id");
                    String checkInDate = rs.getString("checkin");
                    String checkOutDate = rs.getString("checkout");
                    int roomNumber = rs.getInt("room_no");
                    return new Booking(customerId, checkInDate, checkOutDate, roomNumber);
                } else {
                    System.out.println("No booking found for the booking ID: " + bookingId);
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error occurred while fetching booking details: " + e.getMessage(), e);
        }
    }
    
    //DISPLAY MENU 
    public static void displayReceptionistMenu() {
        System.out.println("+------------------------+");
        System.out.println("| Receptionist Menu      |");
        System.out.println("+------------------------+");
        System.out.println("| 1. View All bookings   |");
        System.out.println("| 2. Update Check-In     |");
        System.out.println("|    Status              |");
        System.out.println("| 3. Update Check-Out    |");
        System.out.println("|    Status              |");
        System.out.println("| 4. Process Payment     |");
        System.out.println("| 5. Exit to Main Menu   |");
        System.out.println("+------------------------+");
    }
}
