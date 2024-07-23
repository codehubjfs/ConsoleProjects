package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hotelmanagement.bean.Payment;
import com.hotelmanagement.utilities.DbUtil;

public class PaymentDao {
	
	 public void insertPayment(Payment payment) throws SQLException {
	        String sql = "INSERT INTO payments (payment_id, booking_id, payment_amt, payment_date, payment_method, payment_status) VALUES (payment_id_seq.nextval, ?, ?, ?, ?, ?)";

	        try  {
	        	Connection conn = DbUtil.openConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, payment.getBookingId());
	            stmt.setDouble(2, payment.getPaymentAmt());
	            stmt.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
	            stmt.setString(4, payment.getPaymentMethod());
	            stmt.setString(5, payment.getPaymentStatus());

	            stmt.executeUpdate();
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }

}
