package com.taskmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.taskmanagement.beans.User;
import com.taskmanagement.util.DBConnection;

public class UserLoginDAO {
	
	
	

    public boolean validateUserLogin(User user) {
    	
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet rs= null;
    	
        String sql = "";
        if ("Manager".equals(user.getRole())) {
            sql = "SELECT * FROM employee WHERE role = 'manager' AND email = ? AND password = ?";
        } else if ("Employee".equals(user.getRole())) {
            sql = "SELECT * FROM employee WHERE role = 'employee' AND email = ? AND password = ?";
        } else if ("Admin".equals(user.getRole())) {
            sql = "SELECT * FROM admin WHERE email = ? AND admin_password = ?";
        }
        System.out.println("UserDao");

        try {
        	 connection = DBConnection.getInstance().getConnection();
             preparedStatement = connection.prepareStatement(sql); 
             
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            rs = preparedStatement.executeQuery(); 
                return rs.next();  // If a record is found, the user is valid
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
