package com.leavemanagement.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		session = request.getSession(false); // Do not create session if it doesn't exist	
        session.invalidate();  // Invalidate the session
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/home");
		return mv;
	}
}
