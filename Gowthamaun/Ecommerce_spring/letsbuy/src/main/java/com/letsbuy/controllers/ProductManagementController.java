package com.letsbuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Product;
import com.letsbuy.services.AdminService;
import com.letsbuy.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductManagementController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("ProductManagementController")
	public ModelAndView getAllProducts(ModelAndView modelAndView,HttpSession session,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			List<Product> productsList = adminService.getAllProducts();
			modelAndView.addObject("productList", productsList);
			modelAndView.setViewName("views/admin/productmanagement");
		}
		return modelAndView;
	}
	
	@GetMapping("ProductManagementEditController")
	public ModelAndView editProduct(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			
			int productId = Integer.parseInt(request.getParameter("pid"));
			String status = request.getParameter("product");
			Product product = adminService.getAllProducts().stream().filter(p->p.getProductId()==productId).findFirst().orElse(null);
			boolean flag = adminService.editProduct(product, status);
			if(flag) {
				System.out.println("Sucessfully updated");
				modelAndView.setViewName("redirect:/ProductManagementController");
			}
		}
		return modelAndView;
	}
	
}
