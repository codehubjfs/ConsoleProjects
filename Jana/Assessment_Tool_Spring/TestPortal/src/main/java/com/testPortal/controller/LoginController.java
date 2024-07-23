package com.testPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.testPortal.model.User;
import com.testPortal.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

//	@Autowired
//	ModelAndView modelAndView;

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("user-type") String userType, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		User user = userService.findByEmail(email, userType);

		if (user != null && user.getPassword().equals(password)) {
			userType = userType.toLowerCase().trim();
			session.setAttribute("email", email);
			switch (userType) {
			case "admin":
				modelAndView.setViewName("redirect:/admin/home");
				break;
			case "student":
				modelAndView.setViewName("redirect:/student/home?email");
				break;
			case "instructor":
				modelAndView.setViewName("redirect:/instructor/home");
				break;
			default:
				modelAndView.addObject("error", "Invalid user type");
				modelAndView.setViewName("Login/login");
				break;
			}
		} else {
			modelAndView.addObject("error", "Invalid username or password");
			modelAndView.setViewName("Login/login");
		}

		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "Login/login";
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/loginPage");
	}
}
