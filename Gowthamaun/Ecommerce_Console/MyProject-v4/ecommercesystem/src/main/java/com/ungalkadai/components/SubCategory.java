package com.ungalkadai.components;

public class SubCategory {
	private int subCategoryId;
	private String subCategoryName;
	private Category category;
	
	public SubCategory() {
		
	}
	
	public SubCategory(int subCategoryId,String subCategoryName,Category category) {
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
	}
	
	public SubCategory(String subCategoryName,Category category) {
		//this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
	}
	
	public SubCategory(int subCategoryId,String subCategoryName) {
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		//this.category = category;
	}
	

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return subCategoryName+" "+category.getCategoryName();
	}
}
