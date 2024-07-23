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

/**
 * Servlet implementation class MobileViewPageController
 */
public class MobileViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileViewPageController() {
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
		String isExist = "false";
		System.out.println("Inside the mobile view controller");
		int productId = Integer.parseInt(request.getParameter("productId"));
		Map<Integer,Product> productMap = (Map<Integer, Product>) request.getSession().getAttribute("mobiles");		
		System.out.println(productMap.size());
//		productMap.forEach((k,v)->System.out.println(k+" "+v));
		Product choosenProduct = productMap.get(productId);
		Customer customer = (Customer) request.getSession().getAttribute("user");
		if(customer!=null) {
			if(customer.getMyCart().getMyCart().containsKey(choosenProduct.getProductId())) {
				isExist = "true";
				System.out.println("Product already exist in the cart");
			}
		}
		System.out.println(choosenProduct.getSubtitle());
		request.getSession().setAttribute("choosen", choosenProduct);
		request.setAttribute("isExist", isExist);
		request.getRequestDispatcher("views/customer/mobilepage.jsp").forward(request, response);
	}

}
