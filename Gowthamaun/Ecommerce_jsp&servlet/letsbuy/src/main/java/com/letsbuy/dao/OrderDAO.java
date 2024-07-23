package com.letsbuy.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Orders;
import com.letsbuy.beans.Product;
import com.letsbuy.util.DbConnection;

public class OrderDAO {
	
	public boolean makeOrder(Order order) {
		String sql = "insert into orders values(?,?,?,?,?)";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getCustomer().getCustomerId());
			statement.setDate(3,Date.valueOf(order.getOrderDate()));
			statement.setString(4, order.getAddress());
			statement.setString(5, order.getOrderStatus());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0)
			{
				
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	
	public boolean  changeShippingAddress(Order order) {
		String sql = "update orders set address=? where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, order.getAddress());
			statement.setInt(2, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public  int getSequenceNumber() {
		String sql= "select order_sequence.nextval from dual";
		try {
		Statement statement = DbConnection.openConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			int id = rs.getInt("nextval");
			return id;
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public  Orders getCustomerOrders(Customer customer) {
		List<Order> myOrders = new ArrayList<>();
		
		String sql = "select p.p_name,p.p_id,pa.amount,p.p_brand,p.warranty,p.p_subtitle,p.p_price,p.p_description,o.order_status,o.order_id,o.order_date,o.address,op.quantity from product p,customer c,orders o,order_product op,payment pa where o.c_id=c.c_id and c.c_id=? and op.order_id=o.order_id and op.p_id=p.p_id and pa.order_id=o.order_id";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, customer.getCustomerId());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				Product p = new Product();
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderStatus(resultSet.getString("order_status"));
				order.setAddress(resultSet.getString("address"));
				order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
				order.setAmount(resultSet.getLong("amount"));
				p.setProductId(resultSet.getInt("p_id"));
				p.setProductName(resultSet.getString("p_name"));
				p.setBrand(resultSet.getString("p_brand"));
				p.setWarranty(resultSet.getString("warranty"));
				p.setDescription(resultSet.getString("p_description"));
				p.setSubtitle(resultSet.getString("p_subtitle"));
				p.setProductPrice(resultSet.getDouble("p_price"));;
				p.setQuantity(resultSet.getInt("quantity"));
				order.setProduct(p);
				myOrders.add(order);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		Orders orders = new Orders();
		orders.setOrders(myOrders);
		orders.setC_id(customer.getCustomerId());
		return orders;
	}
	
	
	public long getOrdersCount() {
		String sql = "select count(*) as order_count from orders";
		long count = 0;
		try {
			Statement statement = DbConnection.openConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				count =  resultSet.getInt("order_count");
				return count;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	
	
	public static void insertOrder(Order order,Product p) {
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
	
	
	
	public static boolean updateOrderProduct(Order order) {
		String sql = "delete order_product where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
//				updatePayment(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("Inside update order product : "+e.getMessage());
		}
		return false;
	}
	
	
	public static boolean updateOrders(Order order) {
		//System.out.println(order.getOrderId());
		String sql = "update orders set order_status='CANCELED',order_date=SYSDATE where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
//				updateProduct(order);
				return true;
			}
		}catch(SQLException e) {
			System.out.println("In update orders : "+e.getMessage());
		}
		return false;
	}
	
	public void confirmOrder(Order order) {
		String sql = "update orders set order_status='CONFIRMED',order_date=SYSDATE where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The order has been Confirmed sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void makeShipment(Order order) {
		String sql = "update orders set order_status='SHIPPED',order_date=SYSDATE where order_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1,order.getOrderId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The order has been shipped sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
