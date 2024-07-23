package com.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.util.DBConnection; 
import com.carrentalsystem.beans.User;

public class UserDao {
    // Method to get all users
    public List<User> getAll() throws SQLException {
        String sqlQuery = "SELECT * FROM users";
        Connection connection =DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setPassword(resultSet.getString("password"));
            user.setAccountStatus(resultSet.getString("account_status"));
            user.setLicenseId(resultSet.getString("license_id"));
            user.setUsername(resultSet.getString("username"));
            list.add(user);
        }
        return list;
    }
    
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        
            PreparedStatement preparedStatement = DBConnection.openConnection().prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("hi3");
            while (rs.next()) {
            	System.out.println("hi4");
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setPassword(rs.getString("password"));
                user.setAccountStatus(rs.getString("account_status"));
                user.setLicenseId(rs.getString("license_id"));
                user.setUsername(rs.getString("username"));
                System.out.print(user.getFirstName());
                userList.add(user);
                
            }
            System.out.print(userList);
        
        return userList;
    }
    
    public boolean updateStatus(User user, String status) throws SQLException {
        String updateQuery = "UPDATE users SET account_status = ? WHERE user_id = ?";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, status);
        statement.setInt(2, user.getUserId());
        return statement.executeUpdate() > 0;
    }
    
    public boolean add(User user) throws SQLException {
        String insertQuery = "INSERT INTO users (user_id, first_name, last_name, email, gender, phone_number, password, account_status, license_id, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, user.getUserId());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getGender());
        statement.setString(6, user.getPhoneNumber());
        statement.setString(7, user.getPassword());
        statement.setString(8, user.getAccountStatus());
        statement.setString(9, user.getLicenseId());
        statement.setString(10, user.getUsername());
        return statement.executeUpdate() > 0;
    }

    // Method to delete (block) a user
    public boolean delete(User user) throws SQLException {
        String deleteQuery = "UPDATE users SET account_status = 'BLOCKED' WHERE user_id = ?";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, user.getUserId());
        return statement.executeUpdate() > 0;
    }
}
