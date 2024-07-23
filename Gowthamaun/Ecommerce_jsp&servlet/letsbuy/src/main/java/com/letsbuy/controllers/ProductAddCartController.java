package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.CartDAO;

/**
 * Servlet implementation class ProductAddCartController
 */
public class ProductAddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO cartDAO = new CartDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddCartController() {
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
//		// TODO Auto-generated method stub
//		Map<Integer,Product> productMap = (Map<Integer, Product>) request.getSession().getAttribute("mobiles");		
//		System.out.println(productMap.size());
//		int productId = Integer.parseInt(request.getParameter("productId"));
//		Product choosen = productMap.get(productId);
//		System.out.println("From map : "+choosen.getSubtitle());

		System.out.println("From product Add Cart Controller");
		String updationStatus = "";
		Product choosenOne = (Product) request.getSession().getAttribute("choosen");
		System.out.println("From session : "+choosenOne.getSubtitle()+" "+choosenOne.getQuantity());
		Customer customer = (Customer) request.getSession().getAttribute("user");
		if(customer!=null) {
			System.out.println("Customer id : "+customer.getCustomerId());
			System.out.println("Cart id : "+customer.getMyCart().getCart_id());
			choosenOne.setQuantity(1);
			boolean isAlreadyExist = customer.getMyCart().getMyCart().containsKey(choosenOne.getProductId());
			if(isAlreadyExist) {
				System.out.println("The Choosen product is already present in the cart");
				}else {
				boolean status = cartDAO.addProductToCart(choosenOne, customer);
				if(status) {
					System.out.println("The new Product has introduced in the cart");
					Map<Integer,Product> cartProduct = customer.getMyCart().getMyCart();
					cartProduct.put(choosenOne.getProductId(), choosenOne);
					request.getSession().setAttribute("cart-update-status", "The product has been added to cart sucessfully");
					
				}
			}
			request.getSession().setAttribute("choosen", null);
			response.sendRedirect("CustomerCartController");
//			request.getSession().setAttribute("cart-update-status", updationStatus);
		}else {
			System.out.println("Customer is null");
		}
		
	}

}
