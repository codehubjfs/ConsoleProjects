package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.letsbuy.beans.Card;
import com.letsbuy.beans.Order;
import com.letsbuy.util.DbConnection;

public class PaymentDAO {
	
	
	public boolean makePayment(Card card) {
		String sql = "insert into payment values(payment_sequence.nextval,?,SYSDATE,?,?,?)";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, card.getOrder().getOrderId());
			statement.setString(2, card.getPaymentType());
			statement.setString(3, card.getPaymentStatus().toString());
			statement.setDouble(4, card.getAmount());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Payment has been done sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	public static boolean updatePayment(Order order) {
		String sql = "delete payment where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
//				updateOrders(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("Inside payment order product : "+e.getMessage());
		}
		return false;
	}
	
	
	
	
	
}
