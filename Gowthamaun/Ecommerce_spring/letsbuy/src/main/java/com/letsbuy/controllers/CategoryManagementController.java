package com.letsbuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CategoryManagementController {
	@Autowired
	AdminService adminService;
	@Autowired
	Category category;
	@GetMapping("CategoryManagementController")
	public ModelAndView getCategoryData(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			List<Category> categoryList = adminService.getAllCategory();
			modelAndView.addObject("categoryList",categoryList);
			modelAndView.setViewName("views/admin/categorymanagement");
		}
		return modelAndView;
	}
	
	@PostMapping("CategoryManagementEditController")
	public ModelAndView editcategory(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			int categoryId = Integer.parseInt(request.getParameter("category-id"));
			String status = request.getParameter("v-status");
			Category category = adminService.getAllCategory().stream().filter(c->c.getCategoryId()==categoryId).findFirst().orElse(null);
			category.setVerificationStatus(status);
			System.out.println("Objedct : "+category+"Category : "+category.getVerificationStatus());
			boolean flag = adminService.editCategory(category);
			if(flag) {
				modelAndView.setViewName("redirect:/CategoryManagementController");
		}
		}
		return modelAndView;
	}
	@PostMapping("CategoryManagementAddController")
	public ModelAndView addCategory(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			String categoryName = request.getParameter("catName");
			category.setCategoryName(categoryName);
			category.setVerificationStatus("VERIFIED");
			boolean status = adminService.addCategory(category);
			if(status) {
				System.out.println("New category has been introduced sucessfully");
				modelAndView.setViewName("redirect:/CategoryManagementController");
		}
		}
		return modelAndView;
	}
		
}
