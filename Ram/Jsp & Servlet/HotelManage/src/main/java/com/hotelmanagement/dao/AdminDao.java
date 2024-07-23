package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Admin;
import com.hotelmanagement.bean.Customer;
import com.hotelmanagement.utilities.DbUtil;

public class AdminDao {
	
	public List<Admin> getAllAdmin() throws Exception {
        List<Admin> ad = new ArrayList<>();
        String query = "SELECT name, email, phone_no, address FROM ADMIN";
        try {
        	PreparedStatement statement = DbUtil.openConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setName(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPhoneNo(resultSet.getString("phone_no"));
                admin.setAddress(resultSet.getString("address"));
                ad.add(admin);
            }
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        return ad;
    }
	
	public Admin getAdminById(String adminEmail) {
        Admin admin = null ;
        String sql = "SELECT * FROM admin WHERE email = ?";

        try {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, adminEmail);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setPhoneNo(rs.getString("phone_no"));
                admin.setAddress(rs.getString("address"));
                admin.setName(rs.getString("name"));
                // Set any other fields as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
	public boolean updateAdmin(Admin admin) {
        boolean updated = false;
        String sql = "UPDATE admin SET username = ?, password = ?, email = ?, phone_no = ?, address = ?, name = ? WHERE admin_id = ?";

        try  {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPhoneNo());
            preparedStatement.setString(5, admin.getAddress());
            preparedStatement.setString(6, admin.getName());
            preparedStatement.setInt(7, admin.getAdminId());

            int rowsUpdated = preparedStatement.executeUpdate();
            updated = rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
	
	
	public Admin getAdminByUsername(String username, String password) {
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        try  {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setPhoneNo(rs.getString("phone_no"));
                admin.setAddress(rs.getString("address"));
                admin.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public boolean updateAdmins(Admin admin) {
        boolean updated = false;
        String sql = "UPDATE admin SET username = ?, password = ?, email = ?, phone_no = ?, address = ?, name = ? WHERE admin_id = ?";

        try  {
        	Connection con = DbUtil.openConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPhoneNo());
            preparedStatement.setString(5, admin.getAddress());
            preparedStatement.setString(6, admin.getName());
            preparedStatement.setInt(7, admin.getAdminId());

            int rowsUpdated = preparedStatement.executeUpdate();
            updated = rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

}
