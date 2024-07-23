package com.issueraisesystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.util.DBUtil;

public class AdminDAO {
	
	public List<AdminDetails> getAdminDetails() throws SQLException{
		
		
		String sql="select * from admin";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		List<AdminDetails>adminDetails=new ArrayList<>();
		while(rs.next()) {
			AdminDetails admin=new AdminDetails();
			admin.setAdminid(rs.getInt("adminid"));
			admin.setMailid(rs.getString("mailid"));
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
			adminDetails.add(admin);
			
		}
		
		
		
		
		return adminDetails;
	
		
	}

}
