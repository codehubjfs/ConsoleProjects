package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Category;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Product;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.beans.Vendor;
import com.letsbuy.util.DbConnection;

public class ProductDAO {
	
	public void updateProductTable(Product p) {
		String sql = "update product set p_quantity=p_quantity-? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, p.getQuantity());
			statement.setInt(2, p.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Product table updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  boolean updateProduct(Order order) {
		String sql = "update product set p_quantity=p_quantity+? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, order.getProduct().getQuantity());
			statement.setInt(2, order.getProduct().getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println("In update product : "+e.getMessage());
		}
		return false;
	}
	
	public void updateProductDescription(Product product,String description) {
		String sql = "update product set p_description=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, description);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Description has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void updateProductSubtitle(Product product,String subTitle) {
		String sql = "update product set p_subtitle=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, subTitle);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Subtitle has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductName(Product product,String productName) {
		String sql = "update product set p_name=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, productName);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Name has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductBrand(Product product,String brand) {
		String sql = "update product set p_brand=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, brand);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Brand has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductPrice(Product product,double price) {
		String sql = "update product set p_price=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Price has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductQuantity(Product product,int quantity) {
		String sql = "update product set p_quantity=p_quantity+? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Quantity has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean addProduct(Product product) {
		String sql = "insert into product values(product_sequence.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
		PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setString(2, product.getBrand());
		statement.setInt(3, product.getQuantity());
		statement.setString(4, product.getSubtitle());
		statement.setString(5, product.getDescription());
		statement.setString(6, product.getWarranty());
		statement.setInt(7, product.getSubCategrory().getSubCategoryId());
		statement.setInt(8, product.getSubCategrory().getCategory().getCategoryId());
		statement.setString(9, product.getProductStatus().toString());
		statement.setInt(10, product.getVendor().getVendorId());
		statement.setDouble(11, product.getProductPrice());
		statement.setString(12, product.getVerificationStatus().toString());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Product has been added sucessfully");
			return true;
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public List<Product> getAllProducts(){
		String sql = "SELECT p.p_id,p.p_name,p.p_brand,p.p_subtitle,p.p_description,p.p_price,p.warranty,p_quantity,p.verified_status,p.product_status,s.subcategory_id,s.category_id,"
				+ "s.subcategory_name,c.category_name,v.username,v.v_id "
				+ "FROM product p,subcategory s,category c,vendor v WHERE p.category_id=c.category_id AND p.subcategory_id=s.subcategory_id AND p.v_id=v.v_id";
		List<Product> products = new ArrayList<>();
		try {
		Statement statement = DbConnection.openConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getInt("p_id"));
			product.setProductName(resultSet.getString("p_name"));
			product.setBrand(resultSet.getString("p_brand"));
			product.setQuantity(resultSet.getInt("p_quantity"));
			product.setSubtitle(resultSet.getString("p_subtitle"));
			product.setDescription(resultSet.getString("p_description"));
			product.setWarranty(resultSet.getString("warranty"));
			product.setProductPrice(resultSet.getDouble("p_price"));
			product.setVerificationStatus(resultSet.getString("verified_status"));
//			System.out.println(product.getVerificationStatus());
			product.setProductStatus(resultSet.getString("product_status"));
			Vendor vendor = new Vendor();
			vendor.setVendorId(resultSet.getInt("v_id"));
			Account account = new Account();
			account.setUserName(resultSet.getString("username"));
			vendor.setAccount(account);
			product.setVendor(vendor);
			Category category = new Category();
			category.setCategoryId(resultSet.getInt("category_id"));
			category.setCategoryName(resultSet.getString("category_name"));
			SubCategory subCategory = new SubCategory(); 
			subCategory.setCategory(category);
			subCategory.setSubCategoryId(resultSet.getInt("subcategory_id"));
			subCategory.setSubCategoryName(resultSet.getString("subcategory_name"));
			product.setSubCategrory(subCategory);
			products.add(product);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return products;
	}
	
	public void updateProductVerificationStatus(Product product) {
		String sql = "update product set verified_status=? where p_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, product.getVerificationStatus());
			statement.setInt(2, product.getProductId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Verification Status has been updated sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
