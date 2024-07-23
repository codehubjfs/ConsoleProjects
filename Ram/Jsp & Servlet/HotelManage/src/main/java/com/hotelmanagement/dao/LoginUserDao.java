package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotelmanagement.bean.LoginUser;
import com.hotelmanagement.bean.User;
import com.hotelmanagement.utilities.DbUtil;

public class LoginUserDao {

	public boolean validate(LoginUser log)
	{
		boolean status = false; 
		try
		{
		Connection conn = DbUtil.openConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * from users where email = ? and password = ?");
		ps.setString(1, log.getMail());
		ps.setString(2, log.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
		
	}
	
	public User getDetails(String email)
	{
		User user = null;
		String sql = "select * from users where email = ?";
		try {
			Connection conn = DbUtil.openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			 ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("ID"));
	                user.setFirstName(rs.getString("FIRST_NAME"));
	                user.setLastName(rs.getString("LAST_NAME"));
	                user.setAge(rs.getInt("AGE"));
	                user.setGender(rs.getString("GENDER"));
	                user.setPhone(rs.getString("PHONE"));
	                user.setAddress(rs.getString("ADDRESS"));
	                user.setState(rs.getString("STATE"));
	                user.setEmail(rs.getString("EMAIL"));
	            }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return user;
	}
}
