package com.letsbuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class SubCategoryManagementController {
	@Autowired
	AdminService adminService;
	@Autowired
	SubCategory subCategory;
	
	@GetMapping("SubCategoryManagementController")
	public ModelAndView getAllSubCategory(ModelAndView modelAndView,HttpSession session,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			List<SubCategory> subCategoryList = adminService.getAllSubCategory();
			List<Category> categoryList = adminService.getAllCategory();
			modelAndView.addObject("categoryList", categoryList);
 			modelAndView.addObject("subCategoryList", subCategoryList);
			modelAndView.setViewName("views/admin/subcategorymanagement");
		}
		return modelAndView;	
	}
	
	@GetMapping("SubCategoryManagementEditController")
	public ModelAndView editSubCategory(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
			
		}else {
			String id = request.getParameter("subcategory-id");
			System.out.println(id);
			if(id!=null) {
			int subcategoryId = Integer.parseInt(id);
			System.out.println(subcategoryId);
			String verificationStatus = request.getParameter("v-status");
			SubCategory subCategory = adminService.getAllSubCategory().stream().filter(s->s.getSubCategoryId()==subcategoryId).findFirst().orElse(null);
			subCategory.setVerificationStatus(verificationStatus);
			boolean flag = adminService.editSubCategory(subCategory);
			if(flag) {
				modelAndView.setViewName("redirect:/SubCategoryManagementController");
			}else {
				System.out.println("Problem while updating");
			}
			}
		}
		return modelAndView;
	}
	
	@PostMapping("SubCategoryManagementAddController")
	public ModelAndView addSubCategory(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
			
		}else {
			String subCategoryName = request.getParameter("sub-category-input");
			int categoryId = Integer.parseInt(request.getParameter("category-name"));
			System.out.println(subCategoryName+" : "+categoryId);
			subCategory.setSubCategoryName(subCategoryName);
			subCategory.setVerificationStatus("VERIFIED");
			Category category = adminService.getAllCategory().stream().filter(c->c.getCategoryId()==categoryId).findFirst().orElse(null);
			subCategory.setCategory(category);
			adminService.addSubCategory(subCategory);
			modelAndView.setViewName("redirect:/SubCategoryManagementController");
		}
		return modelAndView;
	}
}
