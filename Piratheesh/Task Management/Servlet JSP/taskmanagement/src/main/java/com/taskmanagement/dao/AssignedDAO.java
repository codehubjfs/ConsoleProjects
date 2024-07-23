package com.taskmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.taskmanagement.beans.AssignedBeans;
import com.taskmanagement.util.DBConnection;

public class AssignedDAO {
	
	private static final String ASSIGNED_TASK_QUERY = "SELECT e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = ? AND st.id = 1";
	
	public List<AssignedBeans> getAssignedTask(String email){
		
		List<AssignedBeans> assignedTasks = new ArrayList<>();
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement(ASSIGNED_TASK_QUERY);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				AssignedBeans task = new AssignedBeans();
				task.setTask_id(rs.getInt("task_id"));
                task.setTask_name(rs.getString("task_name"));
                task.setDesp(rs.getString("task_desp"));
                task.setStart_date(rs.getString("start_date"));
                task.setEnd_date(rs.getString("end_date"));
                task.setPriority(rs.getString("task_priortiy"));
                task.setStatus(rs.getString("status"));
                assignedTasks.add(task);
			}
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		return assignedTasks;
		
	}

}
