package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.util.DbConnection;

public class CartDAO {
	
	public static void registerCart(Customer customer) {
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement("insert into cart values(cart_sequence.nextval,?)");
			statement.setInt(1, customer.getCustomerId());
			int r= statement.executeUpdate();
			System.out.println(r);
			//registerOrder(c_id);
	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public List<Product> getCustomerCart(Customer customer) {
		//String sql = "
		List<Product> myProducts = new ArrayList<>();
		//int i =1;
		String sql = "select p.warranty,p.p_brand,p.p_description,p.p_id,p.p_name,p.p_subtitle,p.p_price,cd.quantity \r\n"
				+ "from product p,cart_detail cd,cart ca,customer c\r\n"
				+ "where c.c_id=ca.c_id and c.c_id=? and cd.cart_id=ca.cart_id and cd.p_id=p.p_id";
		try {
		PreparedStatement st = DbConnection.openConnection().prepareStatement(sql);
		st.setInt(1, customer.getCustomerId());
		ResultSet rs = st.executeQuery();
		//Product(String productName, int productId, double productPrice, String brand, int quantity, String subtitle
		//,String description,String warranty)
		while(rs.next()) {
			Product product = new Product();
			product.setBrand(rs.getString("p_brand"));
			product.setDescription(rs.getString("p_description"));
			product.setProductId(rs.getInt("p_id"));
			product.setProductName(rs.getString("p_name"));
			product.setProductPrice(rs.getDouble("p_price"));
			product.setWarranty(rs.getString("warranty"));
			product.setSubtitle(rs.getString("p_subtitle"));
			product.setQuantity(rs.getInt("quantity"));
			myProducts.add(product);
//			myProducts.add( new Product(
//					rs.getString("p_name"),
//					rs.getInt("p_id"),
//					rs.getDouble("p_price"),
//					rs.getString("p_brand"),
//					rs.getInt("quantity"),
//					rs.getString("p_subtitle"),
//					rs.getString("p_description"),
//					rs.getString("warranty")
//					));
			//i++;
		}
		//Map<Integer, Product> myProducts2 = myProducts;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return myProducts;
	}
	
	public boolean addProductToCart(Product product,Customer customer) {
		String sql = "insert into cart_detail values(?,?,?)";
		try {
		PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
		statement.setInt(1, customer.getMyCart().getCart_id());
		statement.setInt(2, product.getProductId());
		statement.setInt(3,product.getQuantity());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Item has been inserted into cart sucessfully");
			return true;
			//CartAndOrderManager.updateCartTable(p);
		}else {
			System.out.println("Some error occured");
		}
		}catch(SQLException e) {
//			if(e.getMessage().contains("unique constraint")) {
//				if(updateQuantity(product,customer)) {
//					System.out.println("Item has been inserted into cart sucessfully");
//					return true;
//				}
//			}
			System.out.println(e.getMessage());
		}
		return false;
		
	}
	
	public boolean updateQuantity(Product p,Customer customer) {
		String sql = "update cart_detail set quantity = quantity+? where cart_id=? and p_id=?";
		System.out.println(p.getQuantity());
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, p.getQuantity());
			statement.setInt(2, customer.getMyCart().getCart_id());
			statement.setInt(3, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean clearMyCart(Customer customer) {
		String sql = "delete from cart_detail where cart_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, customer.getMyCart().getCart_id());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Cart has been updated sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean deleteCartQuantity(Product p,Customer customer,int quantity) {
//		System.out.println("p.id : "+p.getProductId());
//		System.out.println("Cart id : "+customer.getMyCart().getCart_id());
//		System.out.println("name : "+p.getProductName());
		String sql = "update cart_detail set quantity=quantity-? where cart_id=? and p_id=?";
		try {
			PreparedStatement  statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, customer.getMyCart().getCart_id());
			statement.setInt(3, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Product Quantity has been updated in the cart");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean deleteProduct(Product p,Customer customer) {
//		System.out.println("p.id : "+p.getProductId());
//		System.out.println("name : "+p.getProductName());
//		System.out.println("Crt id : "+customer.getMyCart().getCart_id());
//		System.out.println("Customer id : "+customer.getCustomerId());
		String sql = "delete from cart_detail where cart_id=? and p_id=?";
		try {
			PreparedStatement  statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, customer.getMyCart().getCart_id());
			statement.setInt(2, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Product has been removed from cart sucessfully");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
}
