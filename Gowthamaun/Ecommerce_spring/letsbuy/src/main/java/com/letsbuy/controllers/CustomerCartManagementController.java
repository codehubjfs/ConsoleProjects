package com.letsbuy.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.mappers.CartDetailMapper;
import com.letsbuy.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerCartManagementController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("CartProductIncrementController")
	public ModelAndView increaseProductQuantity(HttpServletResponse response,HttpServletRequest request,@RequestParam("pId") int productId,ModelAndView modelAndView) {
		Customer customer = (Customer) request.getSession().getAttribute("user");
		String updationStatus="";
		if(customer==null) {
			modelAndView.setViewName("views/customer/home");
		}else {
			modelAndView.setViewName("redirect:/CustomerCartController");
			Map<Integer,Product> cartProducts = customer.getMyCart().getMyCart();
			 if(cartProducts.get(productId).getQuantity()==10) {
				updationStatus = "The Quantity Limit is 10";
			}
			else {
				Product choosen = cartProducts.get(productId);
				System.out.println("Choosen before : "+cartProducts.get(productId).getQuantity());
				choosen.setProductId(productId);	
				boolean updateStatus = customerService.incrementCartQuantity(customer, choosen);
				choosen.setQuantity(choosen.getQuantity()+1);
				if(updateStatus) {
					System.out.println("Quantity updated Sucessfully");
					updationStatus = "success";
				}
				System.out.println("Choosen after : "+cartProducts.get(productId).getQuantity());
			}
			 modelAndView.addObject("cart-update-status",updationStatus);
			 
		}
		return modelAndView;
	}
	
	@PostMapping("CartProductDecrementController")
	public ModelAndView decreaseProductQuantity(HttpServletResponse response,HttpServletRequest request,@RequestParam("pId") int productId,ModelAndView modelAndView) {
		Customer customer = (Customer) request.getSession().getAttribute("user");
		String updationStatus="";
		if(customer==null) {
			modelAndView.setViewName("views/customer/home");
		}else {
			modelAndView.setViewName("redirect:/CustomerCartController");
			Map<Integer,Product> cartProducts = customer.getMyCart().getMyCart();
			 if(cartProducts.get(productId).getQuantity()==1) {
				updationStatus = "The Minimum quantity is 1";
			}
			else {
				Product choosen = cartProducts.get(productId);
				System.out.println("Choosen before : "+cartProducts.get(productId).getQuantity());
				choosen.setProductId(productId);	
				boolean updateStatus = customerService.decrementCartQuantity(customer, choosen);
				choosen.setQuantity(choosen.getQuantity()-1);
				if(updateStatus) {
					System.out.println("Quantity updated Sucessfully");
					updationStatus = "success";
				}
				System.out.println("Choosen after : "+cartProducts.get(productId).getQuantity());
			}
			 modelAndView.addObject("cart-update-status",updationStatus);
			 
		}
		return modelAndView;
	}
	
	@PostMapping("CustomerCartDeleteController")
	public ModelAndView deleteProductFromCart(@RequestParam("pId") int productId,ModelAndView modelAndView,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("user");
		if(customer==null) {
			modelAndView.setViewName("views/customer/home");
		}else {
			Map<Integer,Product> cartProducts = customer.getMyCart().getMyCart();
			String updationStatus = "";
			Product choosen = cartProducts.get(productId);
			boolean updateStatus = customerService.deleteCartProduct(customer, choosen);
			if(updateStatus) {
				System.out.println("Product has been deletdd Successfully");
				updationStatus = "The Product has removed from the cart";
				cartProducts.remove(productId);
			}
			modelAndView.addObject("cart-update-status", updationStatus);
			modelAndView.setViewName("redirect:/CustomerCartController");
		}
		return modelAndView;
	}
	
	@PostMapping("ProductAddCartController")
	public ModelAndView addProductToCart(@RequestParam("productId") int productId,ModelAndView modelAndView,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("user");
		Map<Integer,Product> products = (Map<Integer, Product>) session.getAttribute("mobiles");
		if(customer==null) {
			modelAndView.setViewName("views/customer/login");
		}else {
			Map<Integer,Product> productMap = customer.getMyCart().getMyCart();
			boolean isExist = productMap.containsKey(productId);
			Product product = products.get(productId);
			System.out.println(product);
			if(!isExist) {
				boolean status = customerService.addProductCart(customer, product);
				if(status) {
					System.out.println("The product has been added to cart successfully"+product);
					productMap.put(product.getProductId(), product);
				}
			}
			modelAndView.setViewName("redirect:/CustomerCartController");
		}
		return modelAndView;
	}
}
