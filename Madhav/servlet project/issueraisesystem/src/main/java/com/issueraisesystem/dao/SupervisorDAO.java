package com.issueraisesystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.Login;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.beans.WorkersDetails;
import com.issueraisesystem.util.DBUtil;

public class SupervisorDAO {
	public  List<SupervisorDetails> getAllSupervisor() throws SQLException{
		String sql="select * from supervisor";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		List<SupervisorDetails>list=new ArrayList<>();
		
		
		
		ResultSet rs=stmt.executeQuery();
		
		
		while(rs.next()) {
			SupervisorDetails supervisor=new SupervisorDetails();
			supervisor.setSupervisorid(rs.getInt("supervisorid"));
			supervisor.setName(rs.getString("name"));
			supervisor.setRole(rs.getString("password"));
			supervisor.setMailid(rs.getString("mailid"));
			supervisor.setRole(rs.getString("role"));
			supervisor.setDepartment(rs.getString("department"));
			list.add(supervisor);
		}
		return list;

	}
	
	public boolean addSupervisor(SupervisorDetails supervisorDetails) throws SQLException {
		String addQuery="insert into supervisor values(supsequence.nextval,?,?,?,?,?)";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(addQuery);
	
		
		stmt.setString(1,supervisorDetails.getMailid());
		stmt.setString(2,supervisorDetails.getPassword());
		stmt.setString(3, supervisorDetails.getName());
		stmt.setString(4, "Supervisor");
		stmt.setString(5,supervisorDetails.getDepartment());
		
		
		return stmt.executeUpdate()>0?true:false;
	
	}
	
	
	//Supervisor count
	 public int getSupervisorCount() throws SQLException {
	        String sql = "SELECT * FROM supervisor";
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        int count=0;
	       
	        while(rs.next()) {
	        	count++;
	        }
	        
	        return count; 
	    }
	 
	 
	public boolean deleteSupervisor(String mailid) throws SQLException {
		String deleteQuery="delete from supervisor where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(deleteQuery);
		stmt.setString(1, mailid);
		return stmt.executeUpdate()>0?true:false;
	}
	
	
	public boolean updateWorkers(SupervisorDetails supervisor) throws SQLException {
		String sql="update supervisor set name=?,department=? where mailid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1, supervisor.getName());
		stmt.setString(2, supervisor.getDepartment());
		stmt.setString(3, supervisor.getMailid());
		System.out.println("db supervisor");
		return stmt.executeUpdate()>0?true:false;
	}
	
	public String chooseSupervisor(int supervisorId) throws SQLException {
		String sql="select name from supervisor where supervisorid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setInt(1,supervisorId );
		ResultSet rs=stmt.executeQuery();
		String name=null;
		if(rs.next()) {
			name=rs.getString("name");
		}
		return name;
	}
	
	public  boolean assignSupervisor(String supervisorName ,int issueid) throws SQLException{
		String sql="update issue set allocatedto=?,status=? where issueid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1,supervisorName);
		stmt.setString(2, "Assigned");
		stmt.setInt(3,issueid);
		return stmt.executeUpdate()>0?true:false;
	}
	
	 
	
	

}
