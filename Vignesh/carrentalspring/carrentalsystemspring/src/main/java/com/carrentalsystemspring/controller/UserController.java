package com.carrentalsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.User;
import com.carrentalsystemspring.service.UserService;



public class UserController {
   
	

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "user/login";  // Forward to /views/user/login.jsp
    }

//    @PostMapping("/loginuser")
//    public String login(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            HttpSession session,
//            Model model) {
//        
//        User user = userService.getUserByUsernameAndPassword(username, password);
//        
//        if (user != null) {
//            session.setAttribute("user", user);
//            return "redirect:/index"; 
//        } else {
//            model.addAttribute("errorMessage", "Invalid username or password.");
//            return "user/loginpage";  
//        }
//    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";  
    }
    

    @PostMapping("/register")
    public String register(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("gender") String gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
          System.out.println(lastName+" hii");
        if (userService.getUserByUsername(username) != null) {
            model.addAttribute("errorMessage", "Username already exists.");
            return "register";
        }
        
        User user = new User();
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone_number(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);
       // user.setAccount_status("active");        
        userService.registerUser(user);
        return "redirect:/login";        
    }
  
    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> suvCars = userService.getCarsByType("SUV");
        List<Car> luxuryCars = userService.getCarsByType("luxury");
        List<Car> sedanCars = userService.getCarsByType("sedan"); 
        System.out.println(suvCars+" hi");
        model.addAttribute("suvCars", suvCars);
        model.addAttribute("luxuryCars", luxuryCars);
        model.addAttribute("sedanCars", sedanCars);
        return "user/carpage";
    }
}
