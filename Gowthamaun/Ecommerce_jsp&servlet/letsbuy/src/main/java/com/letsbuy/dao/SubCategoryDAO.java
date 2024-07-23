package com.letsbuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.letsbuy.beans.Category;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.util.DbConnection;

public class SubCategoryDAO {
	public void addSubCategory(SubCategory subCategory) {
		String sql = "INSERT into subcategory values(subcategory_sequence.nextval,?,?,?)";
		try {
			PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
			statement.setInt(1,subCategory.getCategory().getCategoryId());
			statement.setString(2, subCategory.getSubCategoryName());
			statement.setString(3, subCategory.getVerificationStatus());
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The New Subcategory has been introduced Sucessfully");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  Map<Integer,SubCategory> getAllSubCategoryMap(){
		Map<Integer,SubCategory> categoryList = new HashMap<>();
		int i = 1;
		String sql  = "select s.subcategory_id,s.subcategory_name,s.sub_v_status,c.category_name,c.category_id from subcategory s,category c where s.category_id=c.category_id";
		try {
			Statement statement = DbConnection.openConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				SubCategory subCategory = new SubCategory();
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				subCategory.setSubCategoryId(resultSet.getInt("subcategory_id"));
				subCategory.setSubCategoryName(resultSet.getString("subcategory_name"));
				subCategory.setVerificationStatus(resultSet.getString("sub_v_status"));
				subCategory.setCategory(category);
				categoryList.put(i,subCategory);
				i++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	
	public  void updateSubCategoryVerificationStatus(SubCategory subCategory) {
			String sql = "update subcategory set sub_v_status=? where subcategory_id=?";
			try {
				PreparedStatement statement = DbConnection.openConnection().prepareStatement(sql);
				statement.setString(1, subCategory.getVerificationStatus());
				statement.setInt(2,subCategory.getSubCategoryId());
//				statement.setString(2, subCategory.getSubCategoryName());
				int rowsAffected = statement.executeUpdate();
				if(rowsAffected>0) {
					System.out.println("The  Subcategory has been Edited Sucessfully");
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
}
