package com.carrentalsystem.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.carrentalsystem.exception.NumberException;
import com.carrentalsystem.exception.Validate;
import com.gotrip.CarRentalSystem.DbConnection;

public class UserManagement {
	static BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
	//Altering the customer details
    public void manageuser() throws SQLException, NumberException, IOException {
    	Scanner sc= new Scanner(System.in);
    	Connection con = DbConnection.getConnection();
    	Statement st= con.createStatement();
    	ResultSet rs = st.executeQuery("SELECT USER_ID, USERNAME FROM users");
    	System.out.println("+---------+----------------+");
    	System.out.println("| USER_ID |    USERNAME    |");
    	System.out.println("+---------+----------------+");
    	while (rs.next()) {
    	    int userId = rs.getInt("USER_ID");
    	    String username = rs.getString("USERNAME");
    	    System.out.printf("| %-7d | %-14s |%n", userId, username);
    	}
    	System.out.println("+---------+----------------+");
    	System.out.println("Enter Id To Modify:");
    	//Scanner sc= new Scanner(System.in);
    	
    	int userId=Validate.ValidateNumber(scanner.readLine());
    	
    	if (checkUserExists(userId)) {
            System.out.println("Enter Account Status: (Active/InActive/Blocked)");
            String newValue = sc.nextLine();

            if (updateAccountStatus(userId, newValue)) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("Failed to update account status.");
            }
        } else {
            System.out.println("User ID not found. Please check the user ID.");
        }
    	
    	
    }
    public static boolean checkUserExists(int userId) {
        String query = "SELECT 1 FROM users WHERE user_id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // If there's at least one result, the user exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public static boolean updateAccountStatus(int userId, String newValue) {
        String updateQuery = "UPDATE users SET account_status = ? WHERE user_id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, userId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
   
}
