package com.letsbuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Vendor;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class VendorManagementController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("SellerManagementController")
	public ModelAndView getVendorData(ModelAndView modelAndView,HttpSession session,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			List<Vendor> vendorList = adminService.getAllVendors();
			modelAndView.addObject("seller", vendorList);
			modelAndView.setViewName("views/admin/vendormanagement");
		}
		return modelAndView;
	}
	
	@GetMapping("SellerManagementEditController")
	public ModelAndView editVendor(ModelAndView modelAndView,HttpSession session,HttpServletRequest request) {
		int vendorId = Integer.parseInt(request.getParameter("vid"));
		String select  = request.getParameter("vendor");
		Vendor vendor = adminService.getAllVendors().stream().filter(v->v.getVendorId()==vendorId).findFirst().orElse(null);
		boolean flag = adminService.editVendor(vendor, select);
		if(flag) {
			modelAndView.setViewName("redirect:/SellerManagementController");
		}
		return modelAndView;
	}
	
	
	
	
	
	
}
