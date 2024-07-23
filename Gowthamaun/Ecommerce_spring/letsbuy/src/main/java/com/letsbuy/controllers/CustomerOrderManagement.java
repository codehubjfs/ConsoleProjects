package com.letsbuy.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Card;
import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Orders;
import com.letsbuy.beans.Product;
import com.letsbuy.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerOrderManagement {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Card card;
	
	@Autowired
	Order order;
	
	@GetMapping("/CustomerOrdersController")
	public ModelAndView navigateOrderPage(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Customer customer = (Customer) session.getAttribute("user");
		if(customer==null) {
			System.out.println("Customer is null");
			modelAndView.setViewName("views/customer/login");
		}else {
		Orders orders = customerService.getCustomerOrder(customer);
		modelAndView.addObject("orders",orders);
		modelAndView.setViewName("views/customer/orders");
		}
		return modelAndView;
	}
	
//	public ModelAndView cancelOrder(HttpSession session,ModelAndView modelAndView,@RequestParam("orderId") int orderId) {
//		
//		return modelAndView;
//	}
	
	@PostMapping("ProductMakeOrderController")
	public ModelAndView makeOrder(HttpSession session,ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		String id = request.getParameter("productId");
		int productId ;
		//System.out.println(productId);
		Customer customer = (Customer) session.getAttribute("user");
		if(customer==null) {
			modelAndView.setViewName("views/customer/login");
		}else {
			if(id==null) {
				List<Product> orders = customer.getMyCart().getMyCart().values().stream().collect(Collectors.toList());
				modelAndView.addObject("orderProducts", orders);
			}else {
				productId = Integer.parseInt(id);
			Map<Integer,Product> productMap = (Map<Integer, Product>) session.getAttribute("mobiles");
			Map<Integer,Product> tempMap = new HashMap<>(productMap);
			Product choosen = customerService.getChoosenProduct(tempMap, productId);
			choosen.setQuantity(1);
			System.out.println(productMap);
			List<Product> customerOrders = new ArrayList<>();
			customerOrders.add(choosen);
			session.setAttribute("orderProducts", customerOrders);
			}
			//modelAndView.addObject("orderProducts", customerOrders);
			modelAndView.setViewName("views/customer/orderpage");
		}
			return modelAndView;
		}
	
	
	
	@PostMapping("ProductOrderPaymentController")
	public ModelAndView makeOrderPayment(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("user");
		String cardNumber = request.getParameter("card-number");
		String cardHolderName = request.getParameter("card-holder-name");
		String monthInput = request.getParameter("card-expiry-date-month");
		String yearInput = request.getParameter("card-expiry-date-year");
		 String cardExpiryDate = monthInput+"/"+yearInput;
		 int quantity = Integer.parseInt(request.getParameter("order-product-quantity"));
		 long amount = Long.parseLong(request.getParameter("order-card-amount"));  
//	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/yy");
	        
	        try {
	     
	            LocalDate parsedDate = LocalDate.parse("01/" + cardExpiryDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            

	            int month = parsedDate.getMonthValue();
	            int year = parsedDate.getYear();
	            

	            String formattedDate = String.format("%02d/%02d", month, year % 100); // keeping it as MM/YY
	            
	            System.out.println("Formatted Date: " + formattedDate);

	            
	        } catch (DateTimeParseException e) {
	            System.out.println(e.getMessage());
	            System.out.println("Invalid date format");
	        }
		int cvv = Integer.parseInt(request.getParameter("card-cvv"));
		String address = request.getParameter("order-address");
		List<Product> customerOrders = (List<Product>) session.getAttribute("orderProducts");
		order.setAddress(address);
		order.setAmount(amount);
		order.setCustomer(customer);
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("PLACED");
		//order.setProduct(choosen);
		card.setCustomer(customer);
		card.setCardNumber(cardNumber);
		card.setCardHolderName(cardHolderName);
		card.setCvv(cvv);
		card.setCardHolderName(cardExpiryDate);
		card.setOrder(order);
		card.setAmount(amount);
		card.setPaymentStatus("COMPLETED");
		card.setPaymentType("CREDIT CARD");
		if(customerOrders==null) {
			customerOrders = customer.getMyCart().getMyCart().values().stream().collect(Collectors.toList());
//			List<Card> cards = new ArrayList<>();
			boolean status = customerService.cartProductOrder(customerOrders, card, order,customer);
			if(status) {
				Cart cart = customer.getMyCart();
				Map<Integer,Product> productMapp = new HashMap<>();
				cart.setMyCart(productMapp);
				customer.setMyCart(cart);
				session.setAttribute("user", customer);
				modelAndView.setViewName("redirect:/CustomerOrdersController");
			}
			}
		else {
		Product choosen = customerOrders.get(0);
		choosen.setQuantity(quantity);
		//order.setOrderId(orderId);
//		order.setAddress(address);
//		order.setAmount(amount);
//		order.setCustomer(customer);
//		order.setOrderDate(LocalDate.now());
//		order.setOrderStatus("PLACED");
		order.setProduct(choosen);
//		card.setCustomer(customer);
//		card.setCardNumber(cardNumber);
//		card.setCardHolderName(cardHolderName);
//		card.setCvv(cvv);
//		card.setCardHolderName(cardExpiryDate);
//		card.setOrder(order);
//		card.setAmount(amount);
//		card.setPaymentStatus("COMPLETED");
//		card.setPaymentType("CREDIT CARD");
		List<Card> orders = new ArrayList<>();
		orders.add(card);
		boolean status = customerService.makeOrder(orders, customer);
		if(status) {
			session.setAttribute("orderProducts", null);
			modelAndView.setViewName("redirect:/CustomerOrdersController");
		}
		System.out.println(customerOrders);
		}
		return modelAndView;
	}
	
	@PostMapping("OrderRefundController")
	public ModelAndView cancelCustomerOrder(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String reason = request.getParameter("returnReason");
		Customer customer = (Customer) session.getAttribute("user");
		Order order = customerService.getCustomerOrder(customer).getCustomerOrders().stream().filter(o->o.getOrderId()==orderId).findAny().orElse(null);
		order.setReturnReason(reason);
		boolean status = customerService.orderRefund(order);
		if(status) {
			System.out.println("Order has been cancelled successfully");
			modelAndView.setViewName("redirect:/CustomerOrdersController");
		}
		return modelAndView;
	}
}
