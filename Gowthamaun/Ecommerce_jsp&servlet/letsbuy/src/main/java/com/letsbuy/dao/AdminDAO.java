package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Admin;
import com.letsbuy.util.DbConnection;

public class AdminDAO {
	
	public List<Admin> getAllAdmin(){
		String sql = "select * from admin";
		List<Admin> admins = new ArrayList<>();
		try {
			Statement statement = DbConnection.openConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Admin admin = new Admin();
				admin.setAdminId(resultSet.getInt("admin_id"));
				admin.setUserName(resultSet.getString("username"));
				admin.setPassword(resultSet.getString("password"));
				admins.add(admin);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return admins;
	}
	
	public boolean addAdmin(Admin admin) {
		String sql = "insert into admin values(admin_sequence.nextval,?,?)";
		try {
			PreparedStatement statement =DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, admin.getPassowrd());
			statement.setString(2, admin.getUserName());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				System.out.println("Error occured while trying to insert");
				return false;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean changeAdminPassword(Admin admin) {
		String sql = "update admin set password=? where admin_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, admin.getPassowrd());
			statement.setInt(2, admin.getAdminId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				System.out.println("Error occured while trying to insert");
				return false;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
