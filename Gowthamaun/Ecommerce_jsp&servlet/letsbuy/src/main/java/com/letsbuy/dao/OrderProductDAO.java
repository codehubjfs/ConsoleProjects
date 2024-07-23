package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.letsbuy.beans.Order;
import com.letsbuy.beans.Product;
import com.letsbuy.util.DbConnection;

public class OrderProductDAO {

	public  void makeOrder(Order order,Product p) {
		String sql = "insert into order_product values(?,?,?)";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			statement.setInt(2, p.getProductId());
			statement.setInt(3, p.getQuantity());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
//				Card card = new Card();
//				card.setOrder(order);
//				card.setAmount(p.getProductPrice()*p.getQuantity());
//				makePayments(card);
				System.out.println("Order has been placed sucessfully");
			}else {
				System.out.println("Error occured!!");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
