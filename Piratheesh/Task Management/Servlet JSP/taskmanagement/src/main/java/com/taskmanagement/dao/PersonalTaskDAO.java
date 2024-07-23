package com.taskmanagement.dao;

import com.taskmanagement.beans.EditPersonalTaskBeans;
import com.taskmanagement.beans.PersonalTaskAddBeans;
import com.taskmanagement.beans.PersonalTaskBeans;
import com.taskmanagement.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalTaskDAO {
	
    private static final String INSERT_PERSONAL_TASK_SQL = "INSERT INTO personal_task (task_id, task_name, task_desp, start_date, end_date, task_priority, email, status) VALUES (personalseq.nextval, ?, ?, ?, ?, ?, ?,'Assigned')";
//    private static final String SELECT_PERSONAL_TASK_BY_MAILID = "SELECT  task_name, desp, start_date, end_date, priority FROM personal_tasks WHERE email = ?;";
    private static final String SELECT_ALL_PERSONAL_TASKS_BY_MAILID = "SELECT * FROM personal_task WHERE email = ?";
    private static final String DELETE_PERSONAL_TASK_SQL = "DELETE FROM personal_tasks WHERE task_id = ? and email=?";
    private static final String UPDATE_PERSONAL_TASK_SQL = "UPDATE personal_task SET task_name = ?, task_desp = ?, start_date = ?, end_date = ?, task_priority = ? WHERE task_id = ?";

    // Create or insert personal task
    public void insertPersonalTask(PersonalTaskAddBeans personalTask) throws SQLException {
    	
    	
    	
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONAL_TASK_SQL);
            preparedStatement.setString(1, personalTask.getTask_name());
            preparedStatement.setString(2, personalTask.getDesp());
            preparedStatement.setDate(3, Date.valueOf(personalTask.getStart_date()));
            preparedStatement.setDate(4, Date.valueOf(personalTask.getEnd_date()));
            preparedStatement.setString(5, personalTask.getPriority());
            preparedStatement.setString(6, personalTask.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Select personal task by id
//    public PersonalTaskBeans selectPersonalTask(String mail) {
//        PersonalTaskBeans personalTask = null;
//        try (Connection connection = DBConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PERSONAL_TASK_BY_MAILID)) {
//            preparedStatement.setString(1, mail);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String task_name = rs.getString("task_name");
//                String desp = rs.getString("desp");
//                String start_date = rs.getString("start_date");
//                String end_date = rs.getString("end_date");
//                String priority = rs.getString("priority");
//                personalTask = new PersonalTaskBeans();
//                personalTask.setTask_name(task_name);
//                personalTask.setDesp(desp);
//                personalTask.setStart_date(start_date);
//                personalTask.setEnd_date(end_date);
//                personalTask.setPriority(priority);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return personalTask;
//    }

    // Select all personal tasks
    public List<PersonalTaskBeans> selectAllPersonalTasks(String mail) {
        List<PersonalTaskBeans> personalTasks = new ArrayList<>();
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PERSONAL_TASKS_BY_MAILID);
             preparedStatement.setString(1, mail);
            ResultSet rs = preparedStatement.executeQuery();
            

            while (rs.next()) {
                int task_id = rs.getInt("task_id");
                String task_name = rs.getString("task_name");
                String desp = rs.getString("task_desp");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                String priority = rs.getString("task_priority");
                String Email = rs.getString("email");
                String status = rs.getString("status");
                PersonalTaskBeans personalTask = new PersonalTaskBeans();
                personalTask.setTask_id(task_id);
                personalTask.setTask_name(task_name);
                personalTask.setDesp(desp);
                personalTask.setStart_date(start_date);
                personalTask.setEnd_date(end_date);
                personalTask.setPriority(priority);
                personalTask.setEmail(Email);
                personalTask.setStatus(status);
                personalTasks.add(personalTask);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return personalTasks;
    }

    // Delete personal task
    public boolean deletePersonalTask(int task_id,String mail) throws SQLException {
        boolean rowDeleted=false;
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PERSONAL_TASK_SQL);
            statement.setInt(1, task_id);
            statement.setString(2, mail);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    // Update personal task
    public void updatePersonalTask(EditPersonalTaskBeans personalTask) throws SQLException {
        int rowUpdated;
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PERSONAL_TASK_SQL);
            statement.setString(1, personalTask.getTask_name());
            statement.setString(2, personalTask.getDesp());
            statement.setDate(3, Date.valueOf(personalTask.getStart_date()));
            statement.setDate(4, Date.valueOf(personalTask.getEnd_date()));
            statement.setString(5, personalTask.getPriority());
            statement.setInt(6, personalTask.getTask_id());

            rowUpdated = statement.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        } 
       
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
