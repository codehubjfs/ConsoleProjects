package com.ungalkadai.components;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ecommerce.users.Customer;
import com.ecommerce.users.DbConnection;


public class Order implements Comparable<Order>{
	private int orderId;
	private Customer customer;
	private LocalDate orderDate;
	private String address;
	private Product product;
	private long amount;
	private String orderStatus;
	
	public Order() {
		
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Order(int orderId, Customer customer, LocalDate orderDate, String address,long amount) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.address = address;
		this.amount = amount;
	}
	
	public Order(int orderId, LocalDate orderDate, String address, Product product) {
		this.orderId = orderId;
		this.product = product;
		this.orderDate = orderDate;
		this.address = address;
	}
	
	public Order(int orderId, LocalDate orderDate, String address, Product product,String orderStatus) {
		this.orderId = orderId;
		this.product = product;
		this.orderDate = orderDate;
		this.address = address;
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	@Override
	public String toString() {
		return "Product Name : "+product.getProductName()+"\n"
				+"Brand : "+product.getBrand()+"\n"
				+"Price : "+product.getProductPrice()+"\n"
				+"Quantity : "+product.getQuantity()+"\n"
				+"Order Date : "+orderDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))+"\n"
				//+"Total Amount : "+amount+"\n"
				+"Shipped Address : "+address+"\n"
				+"Order Status : "+orderStatus;
	}

	@Override
	public int compareTo(Order order) {
		return order.getOrderDate().compareTo(this.getOrderDate());
	}
	
	public void printOrderDetails(int serialNumber) {
        String orderDateFormatted = orderDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        
        System.out.printf("|%-12d | %-24s | %-10s | %-10s | %-20s | %-10d | %-15s | %-15d | %-68s| %-16s|%n",
        		serialNumber,
                product.getProductName(), product.getBrand(),
                amount / product.getQuantity(), product.getWarranty(),
                product.getQuantity(), orderDateFormatted, amount, address,orderStatus);
        System.out.println("+-------------+--------------------------+------------+------------+----------------------+------------+-----------------+-----------------+---------------------------------------------------------------------+-----------------+");
    }
	
	public void printSellersOrderDetails(int serialNumber,Product product) {
        String orderDateFormatted = orderDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        
        System.out.printf("| %-12d | %-25s | %-25s | %-7.1f | %-8d | %-11s | %-70s | %-12s |%n", serialNumber, product.getProductName(), product.getBrand(), product.getProductPrice(), product.getQuantity(), orderDateFormatted, address, orderStatus);
        System.out.printf("+--------------+---------------------------+---------------------------+---------+----------+-------------+------------------------------------------------------------------------+--------------+%n");
    }
	
	public boolean  changeShippingAddress() {
		String sql = "update orders set address=? where order_id=?";
		try {
			PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, this.address);
			statement.setInt(2, this.orderId);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
}
