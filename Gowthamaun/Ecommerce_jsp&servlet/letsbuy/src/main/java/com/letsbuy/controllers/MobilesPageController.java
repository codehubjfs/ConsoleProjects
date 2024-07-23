package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;
import com.letsbuy.dao.ProductDAO;

/**
 * Servlet implementation class MobilesPageController
 */
public class MobilesPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ProductDAO productDAO = new ProductDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobilesPageController() {
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
		if(customer==null) {
			System.out.println("empty");
		}else {
			System.out.println(customer.getFirstName());
		}
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getAllProducts();
		products = products.stream()
			    .map(p -> {
			        String description = p.getDescription();
			        if (description != null && description.contains(",")) {
			            String[] specifications = description.substring(description.indexOf(",") + 1).split(",");
			            p.setSpecifications(specifications);
			        }
			        return p;
			    })
			    .collect(Collectors.toList());

		List<Product> mobiles = products
				.stream()
				.filter(p->p.getSubCategrory().getSubCategoryName().equalsIgnoreCase("mobile phones"))
				.collect(Collectors.toList());
		Map<Integer,Product> mobileMap = mobiles
				.stream()
				.collect(Collectors.toMap(p->p.getProductId(), p->p)); 
		mobileMap.forEach((k,v)->System.out.println(k+" "+Arrays.toString(v.getSpecifications())));
		request.getSession().setAttribute("mobiles", mobileMap);
		request.getRequestDispatcher("views/customer/mobiles.jsp").forward(request, response);
	}

}
