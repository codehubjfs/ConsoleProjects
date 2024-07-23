package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.letsbuy.beans.Card;
import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.CartDAO;
import com.letsbuy.dao.OrderDAO;
import com.letsbuy.dao.OrderProductDAO;
import com.letsbuy.dao.PaymentDAO;
import com.letsbuy.dao.ProductDAO;

/**
 * Servlet implementation class ProductOrderPaymentController
 */
public class ProductOrderPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OrderDAO orderDAO = new OrderDAO(); 
    private static PaymentDAO paymentDAO = new PaymentDAO();
    private static ProductDAO productDAO = new ProductDAO();
    private static OrderProductDAO orderProductDAO = new OrderProductDAO();
    private static CartDAO cartDAO = new CartDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOrderPaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("user");
		if(customer!=null) {
			String cardNumber = request.getParameter("card-number");
			String cardHolderName = request.getParameter("card-holder-name");
			String monthInput = request.getParameter("card-expiry-date-month");
			monthInput = monthInput.length()==1?"0"+monthInput:monthInput;
			String yearInput = request.getParameter("card-expiry-date-year");
			 String cardExpiryDate = monthInput+"/"+yearInput;
			 int quantity = Integer.parseInt(request.getParameter("order-product-quantity"));
		        
//		        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/yy");
		        
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
			Product choosen = (Product) request.getSession().getAttribute("choosen");
			long amount = Long.parseLong(request.getParameter("order-card-amount"));
			if(choosen==null) {
				System.out.println("Inside cart to orders");
			List<Product> products = customer.getMyCart().getMyCart().values().stream().collect(Collectors.toList());
				for(Product product:products) {
					int orderId = orderDAO.getSequenceNumber();
					Order order = new Order();
					order.setOrderId(orderId);
					order.setAddress(address);
					order.setAmount((long) (product.getProductPrice()*product.getQuantity()));
					order.setCustomer(customer);
					order.setOrderDate(LocalDate.now());
					order.setOrderStatus("PLACED");
					order.setProduct(product);
					Card card = new Card();
					card.setCustomer(customer);
					card.setCardNumber(cardNumber);
					card.setCardHolderName(cardHolderName);
					card.setCvv(cvv);
					card.setCardHolderName(cardExpiryDate);
		    		card.setOrder(order);
		    		card.setAmount(order.getAmount());
		    		card.setPaymentStatus("COMPLETED");
		    		card.setPaymentType("CREDIT CARD");
		    		boolean orderStatus = orderDAO.makeOrder(order);
		    		if(orderStatus) {
		    			System.out.println("Your Order will placed sucessfully.Once you completed the payment process.");
		    		}
		    		boolean paymentStatus = paymentDAO.makePayment(card);
		    		if(paymentStatus) {
		    			System.out.println("Your payment is sucessfully");
		    		}
		    		productDAO.updateProductTable(product);
		    		orderProductDAO.makeOrder(order, product);
		    		System.out.println("Process Completed Sucessfully");
				}
				boolean cartStatus = cartDAO.clearMyCart(customer);
				Cart cart = customer.getMyCart();
				Map<Integer,Product> c = new HashMap<>();
				cart.setMyCart(c);
				customer.setMyCart(cart);
				request.setAttribute("user", customer);
				System.out.println(cartStatus);
			}
			else {
			choosen.setQuantity(quantity);
			
			int orderId = orderDAO.getSequenceNumber();
			Order order = new Order();
			order.setOrderId(orderId);
			order.setAddress(address);
			order.setAmount(amount);
			order.setCustomer(customer);
			order.setOrderDate(LocalDate.now());
			order.setOrderStatus("PLACED");
			order.setProduct(choosen);
			Card card = new Card();
			card.setCustomer(customer);
			card.setCardNumber(cardNumber);
			card.setCardHolderName(cardHolderName);
			card.setCvv(cvv);
			card.setCardHolderName(cardExpiryDate);
    		card.setOrder(order);
    		card.setAmount(amount);
    		card.setPaymentStatus("COMPLETED");
    		card.setPaymentType("CREDIT CARD");
    		boolean orderStatus = orderDAO.makeOrder(order);
    		if(orderStatus) {
    			System.out.println("Your Order will placed sucessfully.Once you completed the payment process.");
    		}
    		boolean paymentStatus = paymentDAO.makePayment(card);
    		if(paymentStatus) {
    			System.out.println("Your payment is sucessfully");
    		}
    		productDAO.updateProductTable(choosen);
    		orderProductDAO.makeOrder(order, choosen);
    		System.out.println("Process Completed Sucessfully");
    		request.getSession().setAttribute("choosen", null);
			}
    		response.sendRedirect("CustomerOrdersController");
		}else {
			
		}
	}

}
