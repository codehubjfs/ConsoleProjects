package com.hotelmanagement.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Staff;
import com.hotelmanagement.utilities.DbUtil;

public class FrontStaffDao {
   

    private static final String INSERT_STAFF_SQL = "INSERT INTO staff (id, name, email, phone_no, password) VALUES (staff_id.nextval, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STAFF = "SELECT * FROM staff";
    private static final String DELETE_STAFF_SQL = "DELETE FROM staff WHERE id = ?";
    private static final String UPDATE_STAFF_SQL = "UPDATE staff SET name = ?, email = ?, phone = ? WHERE id = ?";
    private static final String SELECT_STAFF_BY_ID = "SELECT * FROM staff WHERE id = ?";
    private static final String EMAIL_EXISTS_SQL = "SELECT COUNT(*) FROM staff WHERE email = ?";
    private static final String PHONE_EXISTS_SQL = "SELECT COUNT(*) FROM staff WHERE phone_no = ?";

    
    public void insertStaff(Staff newStaff) throws SQLException {
        try {
            // Using nextval from sequence for id
        	Connection connection = DbUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO staff (staff_id, name, email, phone_no, password) VALUES (staff_id.nextval, ?, ?, ?, ?)"); 
            preparedStatement.setString(1, newStaff.getName());
            preparedStatement.setString(2, newStaff.getEmail());
            preparedStatement.setString(3, newStaff.getPhone());
            preparedStatement.setString(4, newStaff.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean emailExists(String email) throws SQLException {
        try  {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EMAIL_EXISTS_SQL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public boolean phoneExists(String phone) throws SQLException {
        try {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PHONE_EXISTS_SQL);
            preparedStatement.setString(1, phone);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }
    public List<Staff> selectAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM staff");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Staff newStaff = new Staff();
                newStaff.setId(rs.getInt("staff_id"));
                newStaff.setName(rs.getString("name"));
                newStaff.setEmail(rs.getString("email"));
                newStaff.setPhone(rs.getString("phone_no"));
                newStaff.setPassword(rs.getString("password"));
                staffList.add(newStaff);
            }
        } 
        catch (SQLException e) {
            printSQLException(e);
        }
        return staffList;
    }

    public boolean deleteStaff(String email) throws SQLException {
        boolean rowDeleted = false;
        try  {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM staff WHERE email = ?");
            statement.setString(1, email);
            rowDeleted = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateStaff(Staff staff) throws SQLException {
        boolean rowUpdated = false;
        try  {
        	Connection connection = DbUtil.openConnection();
            String query = "UPDATE staff SET name = ?, phone_no = ? WHERE email = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getPhone());
            statement.setString(3, staff.getEmail());
            rowUpdated = statement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            printSQLException(e);
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
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public Staff selectStaff(int id) {
        Staff staff = null;
        try (Connection connection = DbUtil.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                staff = new Staff();
                staff.setId(id);
                staff.setName(name);
                staff.setEmail(email);
                staff.setPhone(phone);
                staff.setPassword(password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }
}
