package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewAdminEditProfile {
	
	@GetMapping("/AdminEditProfile")
	public String viewAdminEditProfile() {
		return "Admin/EditProfile";
	}

}
