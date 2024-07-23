package com.taskmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.taskmanagement.beans.OverlayedBeans;
import com.taskmanagement.util.DBConnection;

public class OverlayedDAO {
	
	private static final String OVERLAYED_TASK_QUERY = "SELECT e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = ? AND st.id = 5";
	
	public List<OverlayedBeans> getOverlayedTask(String email){
		
		List<OverlayedBeans> overlayedTasks = new ArrayList<>();
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement(OVERLAYED_TASK_QUERY);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				OverlayedBeans task = new OverlayedBeans();
				task.setTask_id(rs.getInt("task_id"));
                task.setTask_name(rs.getString("task_name"));
                task.setDesp(rs.getString("task_desp"));
                task.setStart_date(rs.getString("start_date"));
                task.setEnd_date(rs.getString("end_date"));
                task.setPriority(rs.getString("task_priortiy"));
                task.setStatus(rs.getString("status"));
                overlayedTasks.add(task);
			}
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		return overlayedTasks;
		
	}


}
