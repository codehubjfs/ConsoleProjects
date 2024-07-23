package com.letsbuy.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letsbuy.beans.Admin;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
public class AdminDataController {
	@Autowired
	AdminService adminService;
	@GetMapping("/AdminUserNameController")
	public List<String> getAdminUserNames(HttpServletRequest request,HttpServletResponse response){
		List<String> userNames = adminService.getAllAdmin().stream().map(Admin::getUserName).collect(Collectors.toList());
		return userNames;
	}
}
