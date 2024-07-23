package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Keeper;
import com.hotelmanagement.utilities.DbUtil;

public class KeeperDao {
   

    public KeeperDao() {
        // Initialize connection in constructor (implementation not shown)
        // You can use connection pooling or other methods to get a connection
        // Example: this.connection = ConnectionUtil.getConnection();
    }

    // Insert a new housekeeper into the database
    Connection connection = DbUtil.openConnection();
    public void insertHousekeeper(Keeper housekeeper) throws SQLException {
        try{
            String sql = "INSERT INTO keeper (keeper_id, name, email, phone_no, password, status) VALUES (keep_id.nextval, ?, ?, ?, ?, ?)";
        	PreparedStatement statement = connection.prepareStatement(sql);
        	  
        	 statement.setString(1, housekeeper.getKeeperName());
             statement.setString(2, housekeeper.getEmail());
             statement.setString(3, housekeeper.getPhoneNo());
             statement.setString(4, housekeeper.getPassword());
             statement.setString(5, housekeeper.getStatus());
            
            statement.executeUpdate();
        }
        catch (SQLException e) {
            printSQLException(e);
        }
    }
    public void updateHousekeeperByEmail(Keeper housekeeper) throws SQLException {
        String sql = "UPDATE keeper SET name = ?, phone_no = ?, status = ? WHERE email = ?";
        try  {
        	Connection connection = DbUtil.openConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, housekeeper.getKeeperName());
            statement.setString(2, housekeeper.getPhoneNo());
            statement.setString(3, housekeeper.getStatus());
            statement.setString(4, housekeeper.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
            throw e;
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
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    // Retrieve all housekeepers from the database
    public List<Keeper> getAllHousekeepers() throws SQLException {
    	 List<Keeper> housekeepers = new ArrayList<>();
         String sql = "SELECT * FROM keeper";
        try  {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Keeper housekeeper = new Keeper();
                housekeeper.setId(resultSet.getInt("keeper_id"));
                housekeeper.setKeeperName(resultSet.getString("name"));
                housekeeper.setEmail(resultSet.getString("email"));
                housekeeper.setPhoneNo(resultSet.getString("phone_no"));
                housekeeper.setStatus(resultSet.getString("status"));

                housekeepers.add(housekeeper);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return housekeepers;
    }

   

    // Delete a housekeeper from the database
    public void deleteHousekeeper(String email) throws SQLException {
        String sql = "DELETE FROM keeper WHERE email = ?";
        try  {
        	Connection con = DbUtil.openConnection();
        	PreparedStatement statement = con.prepareStatement(sql);
        	 statement.setString(1, email);
             statement.executeUpdate();
        }
        catch (SQLException e) {
            printSQLException(e);
        }
    }
}
