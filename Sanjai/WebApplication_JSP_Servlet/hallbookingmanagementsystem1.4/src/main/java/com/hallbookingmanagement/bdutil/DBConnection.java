package com.hallbookingmanagement.bdutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Validate class provides various static methods to validate user inputs.
 * @author Sanjai
 * @since 08-May-2024
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // The single instance of the connection
    private static DBConnection instance;
    private Connection connection;

    // Database credentials
    final private static String USER_NAME = "HALLBOOKING";
    final private static String PASSWORD = "root";
    final private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    // Private constructor to prevent instantiation
    private DBConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to create connection: " + e.getMessage());
            throw e; // Rethrow the SQLException to signal failure
        }
    }

    // Public method to provide access to the instance
    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    // Method to get the connection
    public Connection getConnection() {
        return connection;
    }
}
