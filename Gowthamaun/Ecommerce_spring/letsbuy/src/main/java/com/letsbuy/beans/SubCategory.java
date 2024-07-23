package com.letsbuy.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class SubCategory implements Serializable {
	private int subCategoryId;
	private String subCategoryName;
	private Category category;
	private String verificationStatus;
	
	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public SubCategory() {
		
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

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", category="
				+ category + ", verificationStatus=" + verificationStatus + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
