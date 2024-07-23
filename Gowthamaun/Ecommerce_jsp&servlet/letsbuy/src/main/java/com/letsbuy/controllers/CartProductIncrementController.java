package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.CartDAO;
import com.letsbuy.dao.ProductDAO;

/**
 * Servlet implementation class CartProductIncrementController
 */
public class CartProductIncrementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CartDAO cartDAO = new CartDAO(); 
    private ProductDAO productDAO = new ProductDAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartProductIncrementController() {
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
		// TODO Auto-generated method stub
		System.out.println("Inside the Cart Increment Controller");
		String operation = request.getParameter("operation");
		System.out.println("Choosen opeartion : "+operation);
		int productId = Integer.parseInt(request.getParameter("pId"));
		System.out.println(productId);
		Customer customer = (Customer) request.getSession().getAttribute("user");
		if(customer!=null) {
			System.out.println("Customer id : "+customer.getCustomerId());
			
//			List<Product> cartProducts = customer.getMyCart().getMyCart();
			String updationStatus = "failed";
			Map<Integer,Product> cartMap = customer.getMyCart().getMyCart();
			if(cartMap.get(productId).getQuantity()==1 && operation.equals("decrement")) {
				updationStatus = "Minimum Quanity should be 1";
			}else if(cartMap.get(productId).getQuantity()==10 && operation.equals("increment")) {
				updationStatus = "The Quantity Limit is 10";
			}
			else {
//			cartProducts.stream().forEach(p->System.out.println(p.getProductName()));
			Product choosen = new Product();
			System.out.println("Choosen before : "+cartMap.get(productId).getQuantity());
			choosen.setProductId(productId);			
			switch(operation) {
			case "increment":{
				choosen.setQuantity(1);
				boolean status = cartDAO.updateQuantity(choosen, customer);
				if(status) {				
					System.out.println("The increment has been done sucessfully");
					choosen = cartMap.get(choosen.getProductId());
					choosen.setQuantity(choosen.getQuantity()+1);
					System.out.println("Choosen after : "+cartMap.get(productId).getQuantity());
					updationStatus = "success";
				}
				break;
			}
			case "decrement":{
				boolean status = cartDAO.deleteCartQuantity(choosen, customer, 1);
				if(status) {				
					System.out.println("The decrement has been done sucessfully");
					choosen = cartMap.get(choosen.getProductId());
					choosen.setQuantity(choosen.getQuantity()-1);
					System.out.println("Choosen after : "+cartMap.get(productId).getQuantity());
					updationStatus = "success";
				}
				break;
			}
			case "delete":{
				boolean status = cartDAO.deleteProduct(choosen, customer);
				if(status) {
					System.out.println("The product has been removed from cart successfully");
					cartMap.remove(choosen.getProductId());
					updationStatus = "The Product has removed from the cart";
				}
				break;
			}
			}
			}
			request.getSession().setAttribute("cart-update-status", updationStatus);
			response.sendRedirect("CustomerCartController");
		}
	}
	
//	private boolean incrementProductOuantity(Customer customer,Product product) {
//		
//	}

}
