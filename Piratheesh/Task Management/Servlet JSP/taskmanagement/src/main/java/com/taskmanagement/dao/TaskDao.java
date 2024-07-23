package com.taskmanagement.dao;
import com.taskmanagement.beans.TaskBeans;
import com.taskmanagement.beans.UpdateTask;
import com.taskmanagement.util.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    private static final String INSERT_TASK_SQL = "INSERT INTO task (task_id, task_name, task_desp, start_date, end_date, task_priortiy) VALUES (TASKSEQ.nextVal, ?, ?, ?, ?, ?)";
    private static final String UPDATE_TASK_BY_ID = "update  task set task_name = ?, task_desp = ?, start_date = ?, end_date = ?, task_priortiy = ? where task_id = ?"  ;
    private static final String SELECT_ALL_TASKS = "SELECT * FROM task";
    private static final String DELETE_TASK_SQL = "DELETE FROM task WHERE task_id = ?";
    private static final String UPDATE_TASK_SQL = "UPDATE transcation SET status_id = ? where task_id =? and emp_id=?";
    private static final String COUNT_NUMBER_OF_ATASK = "select e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,ts.status_id "
			+ "from employee e join transcation ts on e.emp_id = ts.emp_id join task t on t.task_id = ts.task_id join task_status st on st.id=ts.status_id where e.email = ? and st.id=1 ";
    private static final String COUNT_NUMBER_OF_PTASK = "select e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,ts.status_id "
			+ "from employee e join transcation ts on e.emp_id = ts.emp_id join task t on t.task_id = ts.task_id join task_status st on st.id=ts.status_id where e.email = ? and st.id=3 ";
    private static final String COUNT_NUMBER_OF_CTASK = "select e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,ts.status_id "
			+ "from employee e join transcation ts on e.emp_id = ts.emp_id join task t on t.task_id = ts.task_id join task_status st on st.id=ts.status_id where e.email = ? and st.id=4 ";
    private static final String COUNT_NUMBER_OF_OTASK = "select e.name, t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,ts.status_id "
			+ "from employee e join transcation ts on e.emp_id = ts.emp_id join task t on t.task_id = ts.task_id join task_status st on st.id=ts.status_id where e.email = ? and st.id=5 ";

  
    // Create or insert task
    public void insertTask(TaskBeans task) throws SQLException {
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_SQL);
            preparedStatement.setString(1, task.getTask_name());
            preparedStatement.setString(2, task.getDesp());
            preparedStatement.setDate(3, Date.valueOf(task.getStart_date()));
            preparedStatement.setDate(4, Date.valueOf(task.getEnd_date()));
            preparedStatement.setString(5, task.getPriority());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Update task by id
    public void updateTask(TaskBeans task) throws SQLException{
    	
    
    	try {
    		Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_TASK_BY_ID);
            statement.setString(1, task.getTask_name());
            statement.setString(2, task.getDesp());
            statement.setDate(3, Date.valueOf(task.getStart_date()));
            statement.setDate(4, Date.valueOf(task.getEnd_date()));
            statement.setString(5, task.getPriority());
            statement.setInt(6, task.getTask_id());

             int rowUpdated = statement.executeUpdate();
    	}catch (SQLException e) {
            printSQLException(e);
        }
    	
    }
    
   

    // Select all tasks
    public List<TaskBeans> selectAllTasks() {
        List<TaskBeans> tasks = new ArrayList<>();
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int task_id = rs.getInt("task_id");
                String task_name=rs.getString("task_name");
                String desp = rs.getString("task_desp");
                LocalDate start_date =   rs.getDate("start_date").toLocalDate();
                LocalDate end_date = rs.getDate("end_date").toLocalDate();
                String priority = rs.getString("task_priortiy");
                TaskBeans task = new TaskBeans();
                task.setTask_id(task_id);
                task.setTask_name(task_name);
                task.setDesp(desp);
                task.setStart_date(start_date);
                task.setEnd_date(end_date);
                task.setPriority(priority);
                tasks.add(task);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tasks;
    }

    // Delete task
    public boolean deleteTask(int task_id) throws SQLException {
        boolean rowDeleted=false;
        try {
        	Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TASK_SQL);
            statement.setInt(1, task_id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    // Update task
    public void updateTasks(UpdateTask updatetask) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL);

            preparedStatement.setInt(1, updatetask.getTask_status());
            preparedStatement.setInt(2, updatetask.getTask_id());
            preparedStatement.setInt(3, updatetask.getEmp_id());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error updating profile", e);
        }
        
    }
    
//    public boolean updateTask(TaskBeans task) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = DBConnection.getInstance().getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_TASK_SQL)) {
//            statement.setString(1, task.getDesp());
//            statement.setString(2, task.getStart_date());
//            statement.setString(3, task.getEnd_date());
//            statement.setString(4, task.getPriority());
//            statement.setInt(5, task.getAssignedto());
//            statement.setInt(6, task.getTask_id());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
    
    public int countAssingedTaskEmployee(String email) {
    	System.out.println("Assign DOA");
        int taskCount = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
        	connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(COUNT_NUMBER_OF_ATASK); 
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taskCount++;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taskCount;
    }
    
    public int countPendingTaskEmployee(String email) {
    	System.out.println("Pending DOA");
        int taskCount = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
        	connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(COUNT_NUMBER_OF_PTASK);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taskCount++;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taskCount;
    }
    
    public int countCompletedTaskEmployee(String email) {
    	System.out.println("Complete DOA");
        int taskCount = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
        	connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(COUNT_NUMBER_OF_CTASK) ;
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taskCount++;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taskCount;
    }
    
    public int countOverlayedTaskEmployee(String email) {
    	System.out.println("Overlay DOA");
        int taskCount = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
        	connection = DBConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(COUNT_NUMBER_OF_OTASK);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taskCount++;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taskCount;
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
