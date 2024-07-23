package com.taskmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.taskmanagement.beans.CompletedBeans;
import com.taskmanagement.util.DBConnection;

public class CompletedDAO {

    private static final String COMPLETED_TASK_QUERY = "SELECT e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = ? AND st.id = 4";

    public List<CompletedBeans> getCompletedTasks(String email) {
        List<CompletedBeans> completedTasks = new ArrayList<>();

        try {Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(COMPLETED_TASK_QUERY);

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CompletedBeans task = new CompletedBeans();
                task.setTask_id(resultSet.getInt("task_id"));
                task.setTask_name(resultSet.getString("task_name"));
                task.setDesp(resultSet.getString("task_desp"));
                task.setStart_date(resultSet.getString("start_date"));
                task.setEnd_date(resultSet.getString("end_date"));
                task.setPriority(resultSet.getString("task_priortiy"));
                task.setStatus(resultSet.getString("status"));
                completedTasks.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return completedTasks;
    }
}
