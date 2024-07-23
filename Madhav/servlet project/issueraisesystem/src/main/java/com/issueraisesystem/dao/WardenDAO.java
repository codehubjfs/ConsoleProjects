package com.issueraisesystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.Login;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.util.DBUtil;

public class WardenDAO {
	
	public  List<WardenDetails> getAllWarden() throws SQLException{
		String sql="select * from warden";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		List<WardenDetails>list=new ArrayList<>();
		
		
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) {
			WardenDetails warden=new WardenDetails();
			warden.setWardenid(rs.getInt("wardenid"));
			
			warden.setMailid(rs.getString("mailid"));
			
			warden.setPassword(rs.getString("password"));
		
			warden.setName(rs.getString("name"));
			warden.setRole(rs.getString("role"));
			
			
			list.add(warden);
		}
		return list;

	}
	
	public boolean addWarden(WardenDetails warden) throws SQLException {
		String addQuery="insert into warden values(wardensequence.nextval,?,?,?,?)";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(addQuery);
	
		stmt.setString(1,warden.getMailid());
		stmt.setString(2,warden.getPassword());
		stmt.setString(3,warden.getName());
		stmt.setString(4,"warden");
		
		return stmt.executeUpdate()>0?true:false;
	
	}
	
	public int getWardenCount() throws SQLException {
        String sql = "SELECT * FROM warden";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	count++;
        }
        
        return count; 
    }
	public boolean deleteWarden(String id) throws SQLException {
		String deleteQuery="delete from warden where wardenid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(deleteQuery);
		stmt.setString(1, id);
		return stmt.executeUpdate()>0?true:false;
	}
	
	public List<WardenDetails>profileOverview(String mailid) throws SQLException{
		List<WardenDetails>profile=new ArrayList<>();
		String sql="select * from warden where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1,mailid);
		ResultSet rs=stmt.executeQuery();
		WardenDetails warden=new WardenDetails();
		if(rs.next()) {
			warden.setName(rs.getString("name"));
			warden.setMailid(rs.getString("mailid"));
			
			profile.add(warden);
		}
		return profile;
		
		
		
	}
}
