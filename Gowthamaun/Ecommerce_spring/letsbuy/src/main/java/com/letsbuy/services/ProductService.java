package com.letsbuy.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;

public interface ProductService {
	
	Map<Integer,Product> getAllProduct();

	Product getChoosenProduct(Map<Integer, Product> productMap, Product product);

	boolean isProductExistInCart(Customer customer, Product product);
	
}
