package com.taskmanagement.dao;

import com.taskmanagement.beans.AddAdmin;
import com.taskmanagement.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private static final String INSERT_ADMIN_SQL = "INSERT INTO admins (admin_id, name, email, password) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ADMIN_BY_ID = "SELECT admin_id, name, email, password FROM admins WHERE admin_id = ?;";
    private static final String SELECT_ALL_ADMINS = "SELECT * FROM admins;";
    private static final String DELETE_ADMIN_SQL = "DELETE FROM admins WHERE admin_id = ?;";
    private static final String UPDATE_ADMIN_SQL = "UPDATE admins SET name = ?, email = ?, password = ? WHERE admin_id = ?;";

    // Create or insert admin
    public void insertAdmin(AddAdmin admin) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
            preparedStatement.setInt(1, admin.getAdmin_id());
            preparedStatement.setString(2, admin.getName());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Select admin by id
    public AddAdmin selectAdmin(int admin_id) {
        AddAdmin admin = null;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID)) {
            preparedStatement.setInt(1, admin_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                admin = new AddAdmin();
                admin.setAdmin_id(admin_id);
                admin.setName(name);
                admin.setEmail(email);
                admin.setPassword(password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admin;
    }

    // Select all admins
    public List<AddAdmin> selectAllAdmins() {
        List<AddAdmin> admins = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int admin_id = rs.getInt("admin_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                AddAdmin admin = new AddAdmin();
                admin.setAdmin_id(admin_id);
                admin.setName(name);
                admin.setEmail(email);
                admin.setPassword(password);
                admins.add(admin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admins;
    }

    // Delete admin
    public boolean deleteAdmin(int admin_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL)) {
            statement.setInt(1, admin_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Update admin
    public boolean updateAdmin(AddAdmin admin) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL)) {
            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setInt(4, admin.getAdmin_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
