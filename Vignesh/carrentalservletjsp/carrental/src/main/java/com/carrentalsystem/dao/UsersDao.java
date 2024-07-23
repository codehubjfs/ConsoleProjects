package com.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.carrentalsystem.beans.User;
import com.carrentalsystem.util.DBConnection;

public class UsersDao {
   

    private static final String UPDATE_USER_SQL = "UPDATE users SET account_status = ? WHERE user_id = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE user_id = ?";

    

    public void updateUser(User user) {
        try {Connection connection =DBConnection.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, user.getAccountStatus());
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
    	try {Connection connection =DBConnection.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

