package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.letsbuy.beans.Category;
import com.letsbuy.beans.Product;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.util.DbConnection;

public class CategoryDAO {

	public void addCategory(Category categrory) {
		String sql = "insert into category values(category_sequence.nextval,?,?)";
		try {
		PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
		statement.setString(1, categrory.getCategoryName());
		statement.setString(2, categrory.getVerificationStatus());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("The New category has been introduced successfully");
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public List<Category> getAllCategory(){
		String sql = "select * from category";
		List<Category> categories = new ArrayList<>(); 
		try {
			Statement statement = DbConnection.openConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				category.setVerificationStatus(resultSet.getString("cat_v_status"));
				categories.add(category);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categories;
	}
	
	
//	public void deleteCategory(Category category) {
//		String sql = "update into category set verification_status='DELETED' where category_id=?";
//		try {
//		PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
//		statement.setInt(1, category.getCategoryId());
//		int rowsAffected = statement.executeUpdate();
//		if(rowsAffected>0) {
//			System.out.println("The category has been deleted successfully");
//		}
//		}catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	
	public void updateCategoryVerificationStatus(Category category) {
		String sql = "update category set cat_v_status=? where category_id=?";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setString(1, category.getVerificationStatus());
			statement.setInt(2, category.getCategoryId());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Category Verification Status has been updated sucessfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
