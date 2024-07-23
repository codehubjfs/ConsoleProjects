package com.carrentalsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.carrentalsystem.util.DBConnection;
import com.carrentalsystem.beans.PackageDetails;

public class RentalPackageDao {
    // Method to get all package detailss
    public List<PackageDetails> getAll() throws SQLException {
        String sqlQuery = "SELECT * FROM package_details";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery();
        List<PackageDetails> list = new ArrayList<>();
        while (resultSet.next()) {
            PackageDetails packageDetails = new PackageDetails();
            packageDetails.setPackageDetailsId(resultSet.getInt("package_details_id"));
            packageDetails.setDuration(resultSet.getInt("duration"));
            packageDetails.setCarType(resultSet.getString("car_type"));
            packageDetails.setAmount(resultSet.getDouble("amount"));
            packageDetails.setPackageId(resultSet.getInt("package_id"));
            list.add(packageDetails);
        }
        return list;
    }

    // Method to add a new package details
    public boolean add(PackageDetails packageDetails) throws SQLException {
        String insertQuery = "INSERT INTO package_details (package_details_id, duration, car_type, amount, package_id) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, packageDetails.getPackageDetailsId());
        statement.setInt(2, packageDetails.getDuration());
        statement.setString(3, packageDetails.getCarType());
        statement.setDouble(4, packageDetails.getAmount());
        statement.setInt(5, packageDetails.getPackageId());
        return statement.executeUpdate() > 0;
    }

    // Method to update package details
    public boolean update(PackageDetails packageDetails) throws SQLException {
        String updateQuery = "UPDATE package_details SET duration = ?, car_type = ?, amount = ?, package_id = ? WHERE package_details_id = ?";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setInt(1, packageDetails.getDuration());
        statement.setString(2, packageDetails.getCarType());
        statement.setDouble(3, packageDetails.getAmount());
        statement.setInt(4, packageDetails.getPackageId());
        statement.setInt(5, packageDetails.getPackageDetailsId());
        return statement.executeUpdate() > 0;
    }

    // Method to delete package details
    public boolean delete(PackageDetails packageDetails) throws SQLException {
        String deleteQuery = "DELETE FROM package_details WHERE package_details_id = ?";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, packageDetails.getPackageDetailsId());
        return statement.executeUpdate() > 0;
    }
}

