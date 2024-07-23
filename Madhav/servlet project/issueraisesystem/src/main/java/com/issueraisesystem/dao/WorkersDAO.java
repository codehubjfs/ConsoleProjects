package com.issueraisesystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.beans.WorkersDetails;
import com.issueraisesystem.util.DBUtil;

public class WorkersDAO {
	
	public List<WorkersDetails> getWorkersDetails() throws SQLException{
		String sql="select * from workers";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		List<WorkersDetails>workersDetails=new ArrayList<>();
		while(rs.next()) {
			WorkersDetails worker=new WorkersDetails();
			worker.setWorkersid(rs.getInt("workersid"));
			worker.setName(rs.getString("name"));
			worker.setPhonenumber(rs.getString("phonenumber"));
			worker.setDepartment(rs.getString("department"));
			workersDetails.add(worker);
			
		}
		
		
		
		
		return workersDetails;
		
	}
	
	public void addWorkers(WorkersDetails Workers) throws SQLException {
		String sql="insert into workers values(workerssequence.nextval,?,?,?)";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1, Workers.getName());
		stmt.setString(2, Workers.getPhonenumber());
		stmt.setString(3, Workers.getDepartment());
		
		stmt.executeUpdate();
	}
	
	public boolean deleteWorker(String id) throws SQLException {
		String deleteQuery="delete from workers where WORKERSID=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(deleteQuery);
		stmt.setString(1, id);
		return stmt.executeUpdate()>0?true:false;
	}
	
	public boolean updateWorkers(WorkersDetails worker) throws SQLException {
		String sql="update workers set name=?,department=? where workersid=?";
		PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		stmt.setString(1, worker.getName());
		stmt.setString(2, worker.getDepartment());
		stmt.setInt(3, worker.getWorkersid());
		
		return stmt.executeUpdate()>0?true:false;
	}

}
