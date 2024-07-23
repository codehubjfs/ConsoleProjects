package com.carrentalsystem.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.util.DBConnection;
import com.carrentalsystem.beans.Payment;

public class PaymentDao {

    // Method to get all payments
    public List<Payment> getAll() throws SQLException {
        String sqlQuery = "SELECT * FROM payments";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery();

        List<Payment> list = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment();
            payment.setPaymentId(resultSet.getInt("payment_id"));
            payment.setTotalAmount(resultSet.getDouble("total_amount"));
            payment.setPaymentDate(resultSet.getDate("payment_date"));
            payment.setPaymentMethod(resultSet.getString("payment_method"));
            payment.setPaymentStatus(resultSet.getString("payment_status"));
            payment.setBookingId(resultSet.getInt("booking_id"));
            list.add(payment);
        }
        return list;
    }

    // Method to add a new payment
    public boolean add(Payment payment) throws SQLException {
        String insertQuery = "INSERT INTO payments (payment_id, total_amount, payment_date, payment_method, payment_status, booking_id) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, payment.getPaymentId());
        statement.setDouble(2, payment.getTotalAmount());
        statement.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
        statement.setString(4, payment.getPaymentMethod());
        statement.setString(5, payment.getPaymentStatus());
        statement.setInt(6, payment.getBookingId());
        return statement.executeUpdate() > 0;
    }

    // Method to update a payment's status
    public boolean updatePaymentStatus(Payment payment, String paymentStatus) throws SQLException {
        String updateQuery = "UPDATE payments SET payment_status = ? WHERE payment_id = ?";
        Connection connection = DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, paymentStatus);
        statement.setInt(2, payment.getPaymentId());
        return statement.executeUpdate() > 0;
    }

    // Method to delete a payment
    public boolean delete(Payment payment) throws SQLException {
        String deleteQuery = "DELETE FROM payments WHERE payment_id = ?";
        Connection connection =DBConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, payment.getPaymentId());
        return statement.executeUpdate() > 0;
    }
}

