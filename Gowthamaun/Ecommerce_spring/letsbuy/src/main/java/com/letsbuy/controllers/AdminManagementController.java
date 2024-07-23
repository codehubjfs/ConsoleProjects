package com.letsbuy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminManagementController {
	@Autowired
	AdminService adminService;
	
	
	@GetMapping("AdminManagementController")
	public ModelAndView navigateAdmin(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			modelAndView.setViewName("views/admin/adminmanagement");
		}
		return modelAndView;
	}

	@PostMapping("AdminProfileEditController")
	public ModelAndView editPassword(ModelAndView modelAndView,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			String password = request.getParameter("edit-profile-password");
			System.out.println(password);
//			String id = request.getParameter("add-modal-adminId");
//			int adminId = Integer.parseInt(id);
			admin.setPassword(password);
			boolean flag = adminService.editAdminPassword(admin);
			if(flag) {
				session.setAttribute("admin", admin);
				modelAndView.addObject("updateMessage", "The password has been updated succesfully");
			}
			modelAndView.setViewName("views/admin/adminmanagement");
		}
		return modelAndView;
	}
	@PostMapping("AddAdminController")
	public ModelAndView addAnotherAdmin(ModelAndView modelAndView,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin adminSession = (Admin) session.getAttribute("admin");
		if(adminSession==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			int adminId = adminSession.getAdminId();
			String userName = request.getParameter("add-admin-username");
			//String password = "admin@123";
			boolean flag = adminService.addAdmin(userName);
			if(flag) {
				modelAndView.addObject("updateMessage", "Admin has been added successfully");
				System.out.println("Admin has been added sucessfully");
			}
			adminSession = adminService.getAllAdmin().stream().filter(a->a.getAdminId()==adminId).findFirst().orElse(null);
			session.setAttribute("admin", adminSession);
			modelAndView.setViewName("views/admin/adminmanagement");
		}
		return modelAndView;
	}
}
