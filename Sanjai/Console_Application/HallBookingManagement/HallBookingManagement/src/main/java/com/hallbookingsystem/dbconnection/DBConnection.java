package com.hallbookingsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Validate class provides various static methods to validate user inputs.
 * @author Sanjai
 * @since 08-May-2024
 */
public class DBConnection {

    // The single instance of the connection
    private static DBConnection instance;
    public static Connection connection;

    // Database credentials
    final private static String USER_NAME = "HALLBOOKING";
    final private static String PASSWORD = "root";
    final private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    // Private constructor to prevent instantiation
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return  null;
    }
}

