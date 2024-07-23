package com.letsbuy.beans;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	private int cartId;
	private Map<Integer,Product> myCart;
	private double totalAmount;
	private double discount;
	private double deliveryCharges;
	private double paidAmount;
	private int productsCount;
	
	
	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public Cart(){
		
	}

	public int getCart_id() {
		return cartId;
	}
	
	

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setCart_id(int cart_id) {
		this.cartId = cart_id;
	}

	public Map<Integer,Product> getMyCart() {
		return myCart;
	}

	public void setMyCart(Map<Integer,Product> myCart) {
		this.myCart = myCart;
	}
}
