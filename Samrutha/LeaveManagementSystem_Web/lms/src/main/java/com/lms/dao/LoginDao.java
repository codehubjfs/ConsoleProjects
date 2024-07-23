package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lms.bean.Login;
import com.lms.bean.Role;
import com.lms.util.DbConnection;

public class LoginDao {
	public static Login getUserDetails(String username, String password) {
        Login user=null;
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	user = new Login();
                Role role = user.mapToEnum(resultSet.getString("role")); // Assuming "userType" is a string in the database representing role
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
