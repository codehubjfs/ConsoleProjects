package com.taskmanagement.authentication;

import java.sql.*;

import com.smartcliff.TaskManagementSystem.DbmsConnection;

public class UserAuthentication {

    // Method to authenticate an employee using email and password
    public boolean loginemp(String mail, String password) {
        boolean isValidUser = false;
        try {
            Connection connection = DbmsConnection.getInstance().getConnection();
            // Prepare SQL statement to select employee's name based on email and password
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT name FROM employee WHERE email=? AND password=?");
            stmt.setString(1, mail);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isValidUser = true;
                // Print welcome message with user's name
                System.out.println("Welcome, " + rs.getString("name") + "!");
            } else {
                // Print invalid credentials message
                System.out.println("Invalid Credentials. Please try again.");
            }
            // Close result set, statement, and connection
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            // Print error message
            System.out.println("An error occurred: " + e.getMessage());
        }
        return isValidUser;
    }

    // Method to get manager ID based on email
    public static int manager(String mail) {
        int id = 0;
        try {
            // Prepare SQL statement to select manager's employee ID based on email
            PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
                    .prepareStatement("SELECT emp_id FROM employee WHERE email=?");
            stmt.setString(1, mail);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("emp_id");
            }
            // Close result set and statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Print error message
            System.out.println("An error occurred: " + e.getMessage());
        }
        return id;
    }

    // Method to get employee ID based on email
    public static int employee(String mail) {
        int emp_id = 0;
        try {
            // Prepare SQL statement to select employee's ID based on email
            PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
                    .prepareStatement("SELECT emp_id FROM employee WHERE email=?");
            stmt.setString(1, mail);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                emp_id = rs.getInt("emp_id");
            }
            // Close result set and statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Print error message
            System.out.println("An error occurred: " + e.getMessage());
        }
        return emp_id;
    }

    // Method to authenticate a manager using email and password
    public boolean loginman(String mail, String password) {
        boolean isValidUser = false;
        try {
            // Prepare SQL statement to select all details of a manager based on email and password
            PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
                    .prepareStatement("SELECT * FROM employee WHERE email=? AND password=?");
            stmt.setString(1, mail);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isValidUser = true;
                // Print welcome message with user's name
                System.out.println("Welcome, " + rs.getString("name") + "!");
            } else {
                // Print invalid credentials message
                System.out.println("Invalid Credentials. Please try again.");
            }
            // Close result set and statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Print error message
            System.out.println("An error occurred: " + e.getMessage());
        }
        return isValidUser;
    }

    // Method to authenticate an admin using email and password
    public boolean loginadmin(String mail, String password) {
        boolean isValidUser = false;
        try {
            // Prepare SQL statement to select admin's name based on email and password
            PreparedStatement stmt = DbmsConnection.getInstance().getConnection()
                    .prepareStatement("SELECT name FROM admin WHERE email=? AND admin_password=?");
            stmt.setString(1, mail);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isValidUser = true;
                // Print welcome message with user's name
                System.out.println("Welcome, " + rs.getString("name") + "!");
            } else {
                // Print invalid credentials message
                System.out.println("Invalid Credentials. Please try again.");
            }
            // Close result set and statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Print error message
            System.out.println("An error occurred: " + e.getMessage());
        }
        return isValidUser;
    }
}
