package com.letsbuy.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MobileProductController {
	@Autowired
	Product product;
	@Autowired
	ProductService productService;
	
	@PostMapping("MobileViewPageController")
	public ModelAndView navigateMobilePage(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Customer customer = (Customer) request.getSession().getAttribute("user");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("Product Id : "+productId);
		
		Map<Integer,Product> productMap = (Map<Integer, Product>) request.getSession().getAttribute("mobiles");
		if(productMap==null) {
			productMap = productService.getAllProduct()
					.entrySet().stream()
					.filter((e)->e.getValue().getSubCategory().getSubCategoryName().equalsIgnoreCase("Mobile phones"))
					.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		}
		System.out.println(productMap);
		product.setProductId(productId);
		product = productService.getChoosenProduct(productMap, product);
		boolean isExist = false;
		if(customer!=null) {
			isExist = productService.isProductExistInCart(customer, product);
		}
		modelAndView.addObject("isExist", isExist?"true":"false");
		modelAndView.addObject("choosen", product);
		modelAndView.setViewName("views/customer/mobilepage");
		
		return modelAndView;
	}
}
