package com.letsbuy.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Category implements Serializable{
	
	private int categoryId;
	private String categoryName;
	private String verificationStatus;
	
	public Category() {
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", verificationStatus="
				+ verificationStatus + "]";
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
