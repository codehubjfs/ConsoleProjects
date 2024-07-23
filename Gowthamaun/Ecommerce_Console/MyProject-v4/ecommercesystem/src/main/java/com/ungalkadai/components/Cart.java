package com.ungalkadai.components;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int cart_id;
	private List<Product> myCart;
	
	public Cart(){
		myCart = new ArrayList<>();
	}
	

	public Cart(int cart_id, List<Product> myCart) {
		this.cart_id = cart_id;
		this.myCart = myCart;
	}
	
	public Cart(List<Product> myCart) {
		//this.cart_id = cart_id;
		this.myCart = myCart;
	}

	public Cart(int cart_id) {
		this.cart_id = cart_id;
	}



	public void setMyCart(List<Product> cart) {
		this.myCart = cart;
	}
	
	public List<Product> getMyCart() {
		return myCart;
	}
	
	public int getCart_id() {
		return cart_id;
	}



	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}



	//	public boolean checkOutAll() {
//		
//	}
//	
//	public boolean checkOutSingleProduct(Product product) {
//		
//	}
//	
	
	public void addProduct(Product product) {
		myCart.add(product);
	}
	
	public void printCartDetails(int serialNumber,Product product) {
		System.out.printf("| %-18d | %-34s | %-36s | %-10s | %-8.2f | %-100s | %-15s | %-10d |%n",
                serialNumber, product.getProductName(), product.getSubtitle(), product.getBrand(),
                product.getProductPrice(), product.getDescription(), product.getWarranty(),
                product.getQuantity());
		 System.out.println("+--------------------+------------------------------------+--------------------------------------+------------+----------+------------------------------------------------------------------------------------------------------+-----------------+------------+");
		//System.out.println("+-----+--------------+--------------------------------------+------------+----------+-------------------------------------------------------------------------------------+------------+----------+");
//        String orderDateFormatted = orderDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
//
//        System.out.println("+----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+------------+-----------------+");
//        System.out.printf("| %-2s | %-12s | %-35s | %-10s | %-8s | %-57s | %-10s | %-10s | %-15s |%n", "S.no", "Product Name", "Subtitle", "Brand", "Price", "Description", "Warranty", "Quantity", "Order Date");
//        System.out.println("+----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+------------+-----------------+");
//        System.out.printf("| %-2d | %-12s | %-35s | %-10s | %-8d | %-57s | %-10s | %-8d | %-15s |%n", 
//                          serialNumber, product.getProductName(), product.getSubtitle(), product.getBrand(), 
//                          amount / product.getQuantity(), product.getDescription(), product.getWarranty(), 
//                          product.getQuantity(), orderDateFormatted);
//        System.out.println("+----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+------------+-----------------+");
//        System.out.printf("| %-10s : %-8d |%n", "Quantity", product.getQuantity());
//        System.out.println("+----+--------------+-------------------------------------+------------+----------+-----------------------------------------------------------+------------+------------+-----------------+");
    }
//	
//	public boolean removeProduct(Product product) {
//		
//	}
}
