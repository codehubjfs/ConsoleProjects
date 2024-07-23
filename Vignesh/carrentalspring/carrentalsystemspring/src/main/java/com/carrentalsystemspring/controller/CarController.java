package com.carrentalsystemspring.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.Payment;
import com.carrentalsystemspring.model.RentalPackage;
import com.carrentalsystemspring.model.User;
import com.carrentalsystemspring.service.CarService;
import com.carrentalsystemspring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;
    
    @RequestMapping("/car")
    public ModelAndView getCar(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        
    	
    	 ModelAndView mv = new ModelAndView();
    	
    	
    	
    	List<Car> carList = carService.getCars();
       
        mv.addObject("car", carList);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            mv.addObject("username", user.getUsername());  
        }
        int totalCars = userService.getTotalCars();
        int totalCustomers = userService.getTotalCustomers();
        int totalBookings = userService.getTotalBookings();
       

        mv.addObject("totalCars", totalCars);
        mv.addObject("totalCustomers", totalCustomers);
        mv.addObject("totalBookings", totalBookings);
        
        mv.setViewName("user/index");
        return mv;
    }

    
    //for redirecting to login page
    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("user/loginpage"); 
    }

    
    //for checking the user values and login
    @PostMapping("/loginuser")
    public ModelAndView login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {
        
        User user = userService.getUserByUsernameAndPassword(username, password);
        ModelAndView mv = new ModelAndView();

        if (user != null) {
           // session.setAttribute("user", user);
            session.setAttribute("username", username);  
            mv.setViewName("redirect:/car"); 
        } else {
            mv.addObject("errorMessage", "Invalid username or password.");
            mv.setViewName("user/loginpage");
        }

        return mv;
    }

    
    
    // to register the new user
    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("gender") String gender,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {

        ModelAndView mv = new ModelAndView();

        if (userService.getUserByUsername(username) != null) {
            mv.addObject("errorMessage", "Username already exists.");
            mv.setViewName("user/loginpage");
            return mv;
        }
        
        User user = new User();        
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone_number(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);

        userService.registerUser(user);
        
        session.setAttribute("user", user);
        session.setAttribute("username", username);
        
        mv.setViewName("redirect:/car"); 
        return mv;
    }

    
    //to logout the application
//    @PostMapping("/logout")
//    public ModelAndView logout(HttpSession session) {
//        session.invalidate();
//        return new ModelAndView("redirect:/login"); 
//    }
//    
    //get the cars by car type
    @GetMapping("/cars")
    public ModelAndView getCars() {
        List<Car> suvCars = userService.getCarsByType("SUV");
        List<Car> luxuryCars = userService.getCarsByType("luxury");
        List<Car> sedanCars = userService.getCarsByType("sedan");     
        System.out.println("SUV Cars: " + suvCars);
        System.out.println("Luxury Cars: " + luxuryCars);
        System.out.println("Sedan Cars: " + sedanCars);
        ModelAndView modelAndView = new ModelAndView("user/carpage");
        modelAndView.addObject("suvCars", suvCars);
        modelAndView.addObject("luxuryCars", luxuryCars);
        modelAndView.addObject("sedanCars", sedanCars);       
        return modelAndView;
        
    }
    
    
    //get the rental package car by duration
    @GetMapping("/rental-packages")
    public ModelAndView getRentalPackages() {
        List<RentalPackage> dayPackages = userService.getPackagesByDuration("day");
        List<RentalPackage> weekPackages = userService.getPackagesByDuration("week");
        List<RentalPackage> monthPackages = userService.getPackagesByDuration("month");

        ModelAndView modelAndView = new ModelAndView("user/rentalpack");
        modelAndView.addObject("dayPackages", dayPackages);
        modelAndView.addObject("weekPackages", weekPackages);
        modelAndView.addObject("monthPackages", monthPackages);

        return modelAndView;
    }
    
    //to view the history of current user
//    @GetMapping("/booking-history")
//    public ModelAndView getBookingHistory(HttpServletRequest request) {
//    	HttpSession session=request.getSession(false);
//        User user = (User) session.getAttribute("user");
//        System.out.println(user);
//        List<Booking> bookingHistory = userService.getBookingsByUsername(user.getUsername());
//        System.out.println(bookingHistory);
//        ModelAndView modelAndView = new ModelAndView("user/profilemanage");
//        modelAndView.addObject("bookingHistory", bookingHistory);
//        return modelAndView;
//    }
    
    @GetMapping("/booking-history")
    public ModelAndView getBookingHistory(HttpServletRequest request) {
    	HttpSession session=request.getSession(false);
       String user =(String) session.getAttribute("username");
        System.out.println(user);
        List<Booking> bookingHistory = userService.getBookingsByUsername(user);
        System.out.println(bookingHistory);
        ModelAndView modelAndView = new ModelAndView("user/profilemanage");
        modelAndView.addObject("bookingHistory", bookingHistory);
        return modelAndView;
    }
    
    
    @PostMapping("/rent")
    public ModelAndView rentCar(
            @RequestParam("carId") Long carId,
            @RequestParam("carName") String carName,
            @RequestParam("username") String username,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException {
    	
    	String validuser=(String)request.getSession().getAttribute("username");
   	 ModelAndView mv = new ModelAndView();
   	if(validuser==null) {
   		mv.setViewName("redirect:/car");
   	}

         userService.getUserByUsername(username);
        Car car = userService.getCarById(carId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date startUtilDate = dateFormat.parse(startDate);
        java.util.Date endUtilDate = dateFormat.parse(endDate);

        java.sql.Date startSqlDate = new java.sql.Date(startUtilDate.getTime());
        java.sql.Date endSqlDate = new java.sql.Date(endUtilDate.getTime());

        // Calculate the rental duration in days
        long durationMillis = endSqlDate.getTime() - startSqlDate.getTime();
        int days = (int) (durationMillis / (1000 * 60 * 60 * 24)) + 1; 

        // Calculate the total amount
        double totalAmount = days * car.getRental_rate();
        System.out.println(username+" "+carName+" "+carId+" "+startDate+" "+" "+endDate);

       mv.setViewName("user/payment");
        mv.addObject("username", username);
        mv.addObject("carName", carName);
        mv.addObject("totalAmount", totalAmount);
        mv.addObject("startDate", startDate);
        mv.addObject("endDate", endDate);

        return mv;
    }


    // Process payment and create a booking
    @PostMapping("/process-payment")
    public ModelAndView processPayment(
            @RequestParam("username") String username,
            @RequestParam("carName") String carName,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("totalAmount") double totalAmount,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("exp_date") String cardExpiry,
            @RequestParam("cvv") String cardCVV,
            @RequestParam("card_type") String paymentType,
            @RequestParam("name") String name
    		
    		)
   
    
    {
    	// Create a booking record
        Booking booking = new Booking();
        booking.setUser_name(username);
        booking.setCar_name(carName);
        booking.setStart_date(Date.valueOf(startDate));
        booking.setEnd_date(Date.valueOf(endDate));
        booking.setRental_rate(totalAmount);
        
        
        // Process the payment here (this is a placeholder for actual payment logic)
    	Payment payment = new Payment();
    	payment.setUsername(username);
    	payment.setCarname(carName);
    	payment.setCardNumber(cardNumber);
    	payment.setCardType(paymentType);
    	payment.setCardholder_name(name);
    	payment.setExpDate(Date.valueOf(cardExpiry));
    	payment.setCvv(cardCVV);
    	payment.setCreatedAt(Date.valueOf(LocalDate.now()));
    	
    	
    	//INSERT PAY : 
    	userService.insertPayment(payment);
  	
        userService.createBooking(booking);

        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("carName", carName);
        mv.addObject("startDate", startDate);
        mv.addObject("endDate", endDate);
        mv.addObject("totalAmount", totalAmount);
        mv.setViewName("redirect:/cars");
        return mv;
    }
    
    @GetMapping("/services")
    public ModelAndView services() {
        ModelAndView mav = new ModelAndView("user/services");
        return mav;
    }

    @GetMapping("/aboutus")
    public ModelAndView aboutUs() {
        ModelAndView mav = new ModelAndView("user/aboutus");
        return mav;
    }

    @GetMapping("/contactus")
    public ModelAndView contactUs() {
        ModelAndView mav = new ModelAndView("user/contactus");
        return mav;
    }
    
    
   //  @RequestMapping("/logout")
//public String logout(HttpServletRequest request,HttpServletResponse response) {
//	
//		HttpSession session=request.getSession();
//		session.removeAttribute("user");
//		session.invalidate();
//	  ModelAndView mv=new ModelAndView();
//	  System.out.println("IAM LOGOUT");
//		mv.setViewName("redirect:/login");
//		
//	return mv;
//	//HttpSession session = request.getSession(false); // Get existing session without creating a new one
//
//	if (session != null) {
//   session.removeAttribute("username"); // Remove specific attribute 'admin' from session
// session.invalidate(); // Invalidate (remove) the entire session
//}
//
//		//System.out.println(" new logout");
//		
//	//	return "redirect:/login";
//				
				
	@RequestMapping("/logout")
	public String AdminLogOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false); // Get existing session without creating a new one
    
		if (session != null) {
		    session.removeAttribute("user"); // Remove specific attribute 'admin' from session
		    session.invalidate(); // Invalidate (remove) the entire session
		}

		
		return "redirect:/login";	
	}	
				
				
		
		
	}
    
    
    
    

