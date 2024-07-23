package com.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.carrentalsystem.beans.User;
import com.carrentalsystem.util.DBConnection;

public class RegDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
        "  (FIRST_NAME, LAST_NAME, EMAIL, GENDER, PHONE_NUMBER, PASSWORD, ACCOUNT_STATUS, USERNAME,USER_ID) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    protected Connection getConnection() {
        Connection connection = null;
        connection = DBConnection.openConnection();
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        
        
        Connection connection = getConnection(); 
        	System.out.print("2nd hi");	
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL) ;
             System.out.print("3nd hi");	
             System.out.print(user.getEmail());
            preparedStatement.setString(1, user.getFirstName().trim());
            preparedStatement.setString(2, user.getLastName().trim());
            preparedStatement.setString(3, user.getEmail().trim());
            preparedStatement.setString(4, user.getGender().trim());
            preparedStatement.setString(5, user.getPhoneNumber().trim());
            preparedStatement.setString(6, user.getPassword().trim());
            preparedStatement.setString(7, "Active");
            
            preparedStatement.setString(8, user.getUsername().trim());
            preparedStatement.setInt(9, 9);
            System.out.print(user);
           
            preparedStatement.executeUpdate();
        
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
