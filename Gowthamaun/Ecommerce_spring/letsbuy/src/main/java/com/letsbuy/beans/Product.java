package com.letsbuy.beans;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class Product implements Serializable {
	private String productName;
	private int productId;
	private double productPrice;
	private String brand;
	private int quantity;
	private String subtitle;
	private String description;
	private String warranty;
	private Vendor vendor;
	private SubCategory subCategory;
	private String verificationStatus;
	private String productStatus;
	private String[] specifications;
	private int discount = 21;
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String[] getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String[] specifications) {
		this.specifications = specifications;
	}

	public Product() {
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public SubCategory getSubCategrory() {
		return subCategory;
	}

	public void setSubCategrory(SubCategory subCategrory) {
		this.subCategory = subCategrory;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", productPrice=" + productPrice
				+ ", brand=" + brand + ", quantity=" + quantity + ", subtitle=" + subtitle + ", description="
				+ description + ", warranty=" + warranty + ", vendor=" + vendor + ", subCategory=" + subCategory
				+ ", verificationStatus=" + verificationStatus + ", productStatus=" + productStatus
				+ ", specifications=" + Arrays.toString(specifications) + ", discount=" + discount + "]";
	}
	
	
}
