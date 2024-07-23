package com.letsbuy.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.mappers.ProductMapper;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Map<Integer, Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products = productMapper.getAllProduct().stream()
				.filter(p->p.getSubCategory().getVerificationStatus().equals("VERIFIED"))
				.collect(Collectors.toList());
		
		products = products.stream()
		.peek(p->{
			p.setSpecifications(p.getDescription().substring(p.getDescription().indexOf(",")+1).split(","));
		}).collect(Collectors.toList());
		
		Map<Integer,Product> productMap = products.stream()
				.collect(Collectors.toMap(p->p.getProductId(), p->p));
		return productMap;
	}
	
	@Override
	public Product getChoosenProduct(Map<Integer,Product> productMap,Product product) {
		return productMap.get(product.getProductId());
	}
	
	@Override
	public boolean isProductExistInCart(Customer customer,Product product) {
		return customer.getMyCart().getMyCart().containsKey(product.getProductId());
	}
	
	

}
