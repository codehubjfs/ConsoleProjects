package com.housekeeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.jamocha.hotelmanagementsystem.App;
import com.person.DbmsConnection;
import com.room.Room;
import com.room.RoomCondition;
import com.room.RoomStatus;



public class ManageHousekeep {
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public static void manageHouseKeep() {
        while (true) {
            try {
            	 String menu = 
                         "+---------------------------------------+\n" +
                         "|      Housekeeping Management Menu     |\n" +
                         "+---------------------------------------+\n" +
                         "| 1. View Room Status                   |\n" +
                         "| 2. Assign Cleaning Task               |\n" +
                         "| 3. Track Cleaning Completion          |\n" +
                         "| 4. Back to Menu                       |\n" +
                         "| 5. Exit				|\n"+	
                         "+---------------------------------------+";
                     System.out.println(menu);
                System.out.print("Enter your choice: ");
                int choice = 0;
                try {
                    choice = Integer.parseInt(sc.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        viewRoomStatus();
                        break;
                    case 2:
                        assignCleaningTaskFlow();
                        break;
                    case 3:
                        trackCleaningCompletionFlow();
                        break;
                    case 4:
                    	App.menu();
                    	break;
                    case 5:
                        System.out.println("Exiting Housekeeping Management System.");
                        return;
                    default:
                    	System.out.println("Invalid Input! Please Enter a number between 1 and 4");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
   
    public static void viewRoomStatus() throws SQLException {
        String query = "SELECT room_no, room_status, room_condition, housekeeping_request FROM room WHERE housekeeping_request IS NOT NULL";

        try (Connection conn = DbmsConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

        	 boolean hasData = false;

            while (rs.next()) {
            	hasData = true;
                int roomNo = rs.getInt("room_no");
                String roomStatus = rs.getString("room_status");
                String roomCondition = rs.getString("room_condition");
                String housekeepingRequest = rs.getString("housekeeping_request");

                int maxLength = Math.max(Math.max(roomStatus.length(), roomCondition.length()), housekeepingRequest.length());
                maxLength = Math.max(maxLength, String.valueOf(roomNo).length());

                String border = "+" + "-".repeat(maxLength + 27) + "+";

                System.out.println(border);
                System.out.printf("| %-18s : %-38d |\n", "Room No", roomNo);
                System.out.printf("| %-18s : %-38s |\n", "Status", roomStatus);
                System.out.printf("| %-18s : %-38s |\n", "Condition", roomCondition);
                System.out.printf("| %-18s : %-36s |\n", "Housekeeping Request", housekeepingRequest);
                System.out.println(border);
                System.out.println();
            }
            if (!hasData) {
                System.out.println("All rooms are cleaned and neat.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error viewing room status");
        }
    }

    //HANDLE THE INPUTS :
    public static void assignCleaningTaskFlow() {
    	
    	 // Retrieve the available keeper IDs from the database
        List<Integer> availableKeeperIds = null;
		try {
			availableKeeperIds = getAvailableKeeperIds();
		} catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("Unexpected error: " + e.getMessage());
	    }

        // Display the available keeper IDs to the user
        System.out.println("Available Keeper IDs: " + availableKeeperIds);

        try {
            int keeperId = 0;
            boolean validInput = false;
            while (!validInput) {
            	try {
                    System.out.print("Enter Keeper ID: ");
                    keeperId = Integer.parseInt(sc.readLine());
                    // Check if the entered keeper ID is valid
                    if (availableKeeperIds.contains(keeperId)) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input! Please enter a valid Keeper ID from the list.");
                    }
                } 
            	catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number for Keeper ID.");
                }
            }            
//            List<Room> rooms = getAllRooms();
//            displayRooms(rooms);

            int roomNo = 0;
            validInput = false; // Reset validInput for the next input
            while (!validInput) {
                try {
                    System.out.print("Enter Room No: ");
                    roomNo = Integer.parseInt(sc.readLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number for Room No.");
                }
            }

            Date nextClean = null;
            validInput = false; // Reset validInput for the next input
            while (!validInput) {
                try {
                    System.out.print("Enter Next Clean Date (yyyy-mm-dd): ");
                    String inputDate = sc.readLine();
                    nextClean = Date.valueOf(inputDate);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid date format! Please enter the date in yyyy-mm-dd format.");
                }
            }

            assignCleaningTask(keeperId, roomNo, nextClean);
        } catch (IOException e) {
            System.out.println("Error occurred while reading input: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    //Get the housekeeper Id in the list :
    public static List<Integer> getAvailableKeeperIds() throws SQLException {
        List<Integer> keeperIds = new ArrayList<>();
        
        // Get the database connection using the DbmsConnection class
        Connection connection = DbmsConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            // Define your SQL query to retrieve available keeper IDs
            String sqlQuery = "SELECT KEEPER_ID FROM housekeeper";
            
            // Create a prepared statement
            preparedStatement = connection.prepareStatement(sqlQuery);
            
            // Execute the query
            resultSet = preparedStatement.executeQuery();
            
            // Iterate through the result set and add each keeper ID to the list
            while (resultSet.next()) {
                int keeperId = resultSet.getInt("KEEPER_ID");
                keeperIds.add(keeperId);
            }
        }
        catch (SQLException e) {
            System.out.println("Error occurred while fetching available keeper IDs: " + e.getMessage());
        }
        
        
        return keeperIds;
    }
    
    //Get rooms :
    private static List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                connection = DbmsConnection.getConnection();

                // Define your SQL query to retrieve room details
                String sqlQuery = "SELECT type_id, room_no, room_condition, room_status FROM room";

                // Create a prepared statement
                preparedStatement = connection.prepareStatement(sqlQuery);

                // Execute the query
                resultSet = preparedStatement.executeQuery();

                // Iterate through the result set and add each room's details to the list
                while (resultSet.next()) {
                    int typeId = resultSet.getInt("type_id");
                    int roomNo = resultSet.getInt("room_no");
//                    int roomPrice = resultSet.getInt("room_price");
                    String roomConditionStr = resultSet.getString("room_condition");
                    String roomStatusStr = resultSet.getString("room_status");

                    RoomCondition roomCondition;
                    try {
                        roomCondition = RoomCondition.valueOf(roomConditionStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        // Handle unknown room condition
                        System.out.println("Unknown room condition: " + roomConditionStr);
                        roomCondition = RoomCondition.CLEAN; // Set a default value or handle appropriately
                    }

                    RoomStatus roomStatus = RoomStatus.valueOf(roomStatusStr.toUpperCase());

                    rooms.add(new Room(typeId, roomNo, roomCondition, roomStatus));

                    // Debugging statement
                    System.out.println("Fetched Room - No: " + roomNo + ", Status: " + roomStatus);
                }

            } catch (SQLException e) {
                throw new SQLException("Error occurred while fetching room details: " + e.getMessage());
            } 
		return rooms;
    }
    //Display the rooms :
    private static void displayRooms(List<Room> rooms) {
    	System.out.println("+---------+------------+");
        System.out.println("| Room No | Room Status|");
        System.out.println("+---------+------------+");

        // Iterate through the list and print each room's details
        for (Room room : rooms) {
            System.out.printf("| %7d | %-10s |%n", room.getRoomNo(), room.getRoom_status());
        }

        // Print footer for the room details table
        System.out.println("+---------+------------+");
    }

    public static void trackCleaningCompletionFlow() {
        try {
            System.out.println("Enter Room No:");
            int roomNumber = Integer.parseInt(sc.readLine());
            System.out.println("Enter Keeper ID:");
            int keeperID = Integer.parseInt(sc.readLine());
            trackCleaningCompletion(roomNumber, keeperID);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers for Room No and Keeper ID.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }


    public static void assignCleaningTask(int keeperId, int roomNo, Date nextClean) throws SQLException {
    	// Update room status and housekeeping request
        String updateRoomQuery = "UPDATE room SET room_condition = ?, housekeeping_request = ? WHERE room_no = ?";
        // Update housekeeper's next clean date
        String updateHousekeeperQuery = "UPDATE housekeeper SET next_clean = ? WHERE keeper_id = ?";
        
        try (Connection conn = DbmsConnection.getConnection()) {

            try (PreparedStatement psRoom = conn.prepareStatement(updateRoomQuery);
                 PreparedStatement psHousekeeper = conn.prepareStatement(updateHousekeeperQuery)) {

                // Update room
                psRoom.setString(1, "Scheduled");
                psRoom.setString(2, "Cleaning assigned to keeper ID: " + keeperId);
                psRoom.setInt(3, roomNo);
                int roomRowsAffected = psRoom.executeUpdate();

                // Update housekeeper
                psHousekeeper.setDate(1, new java.sql.Date(nextClean.getTime()));
                psHousekeeper.setInt(2, keeperId);
                int housekeeperRowsAffected = psHousekeeper.executeUpdate();

                if (roomRowsAffected > 0 && housekeeperRowsAffected > 0) {
                    
                    System.out.println("Cleaning task assigned successfully for room no: " + roomNo);
                } else {
                    
                    System.out.println("Failed to assign cleaning task for room no: " + roomNo);
                }
            } catch (SQLException e) {
               
                e.printStackTrace();
                throw new SQLException("Error assigning cleaning task");
            }
        }
    }

    public static void trackCleaningCompletion(int roomNo, int keeperId) throws SQLException {
        String updateRoomQuery = "UPDATE room SET room_condition = ?, housekeeping_request = NULL WHERE room_no = ?";
        String updateHousekeeperQuery = "UPDATE housekeeper SET last_clean = ? WHERE keeper_id = ?";

        try (Connection conn = DbmsConnection.getConnection()) {
//            conn.setAutoCommit(false);

            try (PreparedStatement psRoom = conn.prepareStatement(updateRoomQuery);
                 PreparedStatement psHousekeeper = conn.prepareStatement(updateHousekeeperQuery)) {

                // Update room
                psRoom.setString(1, "Clean");
                psRoom.setInt(2, roomNo);
                int roomRowsAffected = psRoom.executeUpdate();

                // Update housekeeper
                psHousekeeper.setDate(1, new java.sql.Date(System.currentTimeMillis()));
                psHousekeeper.setInt(2, keeperId);
                int housekeeperRowsAffected = psHousekeeper.executeUpdate();

                if (roomRowsAffected > 0 && housekeeperRowsAffected > 0) {
//                    conn.commit();
                    System.out.println("Cleaning completed for room no: " + roomNo);
                } else {
//                    conn.rollback();
                    System.out.println("Failed to update cleaning status for room no: " + roomNo);
                }
            } catch (SQLException e) {
//                conn.rollback();
                e.printStackTrace();
                throw new SQLException("Error tracking cleaning completion");
            }
        }
    }

    
}
