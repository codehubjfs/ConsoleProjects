package com.springproject.Controller;

import java.net.http.HttpRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

import com.google.gson.Gson;
import com.springproject.model.Booking;
import com.springproject.model.Contact;
import com.springproject.model.LoginRegister;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.User;
import com.springproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller


public class FrontController {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginRegister user;
	@Autowired
	private Contact c;
//	@RequestMapping("/connect")
//	public String getConnect() {
//		return "user/login";
//	}
	
	
	//LOGIN PAGE
	@RequestMapping("/connect")
	 public ModelAndView getConnect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;
    }
	
//	@RequestMapping("/main")
//	public String getHome()
//	{
//		return "redirect:/index.jsp";
//	}
	
	//HOME PAGE :
	 @RequestMapping("/main")
	    public ModelAndView getHome() {
	        return new ModelAndView("redirect:/index.jsp");
	    }
	
	//ABOUT :
	
	@RequestMapping("/about")
	public ModelAndView goAbout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("user/about");
//		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//         response.setHeader("Expires", "0");
// 		 HttpSession session = request.getSession(false);
// 	        if (session == null || session.getAttribute("user") == null) {
// 	        	mv.setViewName("redirect:/index.jsp");
// 	            return mv;
// 	        }
		return mv;
	
	}
	
	//CONTACT :
	@RequestMapping("/contact")
	public ModelAndView goContact(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Contact c = (Contact) session.getAttribute("contact");
		if(c!=null)
		{
			mv.addObject("contact", c);
			request.setAttribute("contact", c);
			System.out.println("CONTACT INFO : "+c.getName());
			System.out.println("CONTACT MAIL : "+c.getEmail());
			System.out.println("CONTACT MSG  : "+c.getMessage());
		}
//		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setHeader("Expires", "0");
//		 HttpSession session = request.getSession(false);
//	        if (session == null || session.getAttribute("user") == null) {
//	            
//	        	mv.setViewName("redirect:/index.jsp");
//	            return mv;
//	        }		
	        mv.setViewName("user/contact");
		return mv;
	}
	@RequestMapping("/log")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpSession session,HttpServletRequest request )
	{
		 boolean hasError = false;
	        if (email == null || email.isEmpty()) {
	            request.setAttribute("emailError", "Please enter your email.");
	            hasError = true;
	        }
	        if (password == null || password.isEmpty()) {
	            request.setAttribute("passwordError", "Please enter your password.");
	            hasError = true;
	        }
		boolean isValid = userService.validateUser(email, password);
		if(isValid)
		{
		                User details = userService.getUserDetailsByEmail(email);
		                System.out.println("phone : "+details.getPhone());
			session.setAttribute("user", email);
			session.setAttribute("details", details);
			return "redirect:/index.jsp";
		}
		else {
			model.addAttribute("errorMessage","Invalid email or password");
			return "user/login";
		}
	}
	
	@RequestMapping("/reg")
	public String getReg() {
		return "user/register";
	}
	@PostMapping("/register")
	 public ModelAndView registerUser(
		        @RequestParam("firstName") String firstName,
		        @RequestParam("lastName") String lastName,
		        @RequestParam("age") int age,
		        @RequestParam("gender") String gender,
		        @RequestParam("phone") String phone,
		        @RequestParam("address") String address,
		        @RequestParam("state") String state,
		        @RequestParam("email") String email,
		        @RequestParam("password") String password,
		        HttpSession session
		    ) {
		ModelAndView mv = new ModelAndView();
		 if (userService.emailExists(email)) {
	            mv.addObject("msg", "Email already exists. Please use a different email.");
	            session.setAttribute("msg", "Email already exists. Please use a different email.");
	            mv.setViewName("redirect:/connect");
	            return mv;
	        }
		 
		
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setAge(age);
        user.setGender(gender);
        user.setPhone(phone);
        user.setAddress(address);
        user.setState(state);
        user.setEmail(email);
        user.setPassword(password);
		userService.registerUser(user);
		
		mv.setViewName("redirect:/connect");
		mv.addObject("msg", "Registration Successfull. Please login.....");
		return mv;
	}
	
	
	 @GetMapping("/vr")
	    public ModelAndView viewRoom(HttpServletRequest request, HttpServletResponse response) {
		 ModelAndView mv = new ModelAndView();
			
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		 HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("user") == null) {
	            
	        	mv.setViewName("redirect:/index.jsp");
	            return mv;
	        }		
	         mv.setViewName("user/room");

	        // Fetch room types for each room name
	        List<RoomType> single = userService.getAllRoomTypes("Single");
	        List<RoomType> doubleRooms = userService.getAllRoomTypes("Double");
	        List<RoomType> luxury = userService.getAllRoomTypes("Luxury");
	        List<RoomType> deluxe = userService.getAllRoomTypes("Deluxe Room");
	        System.out.println(single);
	        System.out.println(doubleRooms);
	        System.out.println(luxury);
	        System.out.println(deluxe);
	        // Add room types to ModelAndView
	        mv.addObject("singleRooms", single);
	        mv.addObject("doubleRooms", doubleRooms);
	        mv.addObject("familyRooms", luxury);
	        mv.addObject("deluxeRooms", deluxe);

	        return mv;
	    }
	 
	 
	 @GetMapping("/availableRooms")
	    @ResponseBody 
	    public String fetchAvailableRooms(@RequestParam("roomType") String roomType) {
	        List<String> availableRooms = userService.getAvailableRooms(roomType);
	        return new Gson().toJson(availableRooms);
	    }
	 
	 @RequestMapping("/goPay")
	
		 public ModelAndView goPay()
		 {
			 ModelAndView mv =new ModelAndView();
			 mv.setViewName("user/payment");
			 return mv;
		 }
	 
	 
	 @PostMapping("/book")
	 public ModelAndView bookUser(
			 @RequestParam("customerName") String customerName,
			 @RequestParam("gender") String gender, 
			 @RequestParam("roomNumber")  String room, 
			 @RequestParam("checkinDate")  Date checkInDate,
			 @RequestParam("checkoutDate")  Date checkOutDate, 
			 @RequestParam("phoneNo") String phoneNo, 
			 @RequestParam("roomName")String roomName, 
			 @RequestParam("daysStayed")int noDay ,
			 HttpServletRequest request,
			 HttpServletResponse response)
	 {
		 
		 Booking booking = new Booking();
		 booking.setCustomer_name(customerName);
		 booking.setGender(gender);
		 booking.setRoom(Integer.parseInt(room));
		 booking.setCheck_in(checkInDate);
		 booking.setCheck_out(checkOutDate);
		 booking.setPhoneNo(phoneNo);
		 booking.setBooking_status("Pending");
		booking.setRoomName(roomName);
		
		 System.out.println("ROOM NAME :"+booking.getRoomName());
		 System.out.println("ROOM NO : "+booking.getRoom());
		 booking.setRoomName(roomName);
		 //GET RENT :
		 int roomRent = userService.getRentByRoomName(roomName);
		 //Caclulate days and rent : 
		 int bookingRent = roomRent * noDay;
		 System.out.println("RENT :"+bookingRent);
		 booking.setRent(bookingRent);
		 System.out.println(booking.getCustomer_name()+booking.getGender()+booking.getRoom()+booking.getCheck_in()+booking.getCheck_out()+booking.getCheck_out());
		 //Insert bookinng:
		 userService.insertBooking(booking);
		 
		 //Fetch the last id : 
		 int  bookingId = userService.getLastInsertedBookingId(customerName, phoneNo);
		 booking.setId(bookingId);
		 
		// Store booking in session
		    HttpSession session = request.getSession();
		    session.setAttribute("booking", booking);
		    System.out.println("NEW TABLE :");
		    
		    System.out.println("Booking id "+booking.getId());
		    System.out.println("Booking rm : "+booking.getRoomName());
		    
		    List<Booking> viewBooks = new ArrayList<>();
		    viewBooks.add(booking);
		    viewBooks.stream().forEach(b->{
		    	System.out.println("Id"+b.getId());
		    	System.out.println("name : "+b.getCustomer_name());
		    	System.out.println("checkin :"+b.getCheck_in());
		    	System.out.println("checkout : "+b.getCheck_out());
		    	System.out.println("roomNo : "+b.getRoom());
		    	System.out.println("Room Name :"+b.getRoomName());
		    });
		    ModelAndView mv = new ModelAndView();
			
			 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        response.setHeader("Expires", "0");
			 HttpSession session1 = request.getSession(false);
		        if (session1 == null || session1.getAttribute("user") == null) {
		            
		        	mv.setViewName("redirect:/index.jsp");
		            return mv;
		        }
		 mv.setViewName("user/payment");
		 mv.addObject("booking", booking);
		 return mv;
		 
	 }
	 
	 @PostMapping("/processPayment")
	 public ModelAndView processPayment(HttpServletRequest request, HttpServletResponse response)
	 {
		 
		 HttpSession session = request.getSession();
		 Booking booking = (Booking) session.getAttribute("booking");
		 System.out.println("Booking name : "+booking.getCustomer_name());
		 System.out.println("Booking Id : "+booking.getId());
		 
		  if (booking == null) {
	            return new ModelAndView("redirect:/index.jsp");
	        }
		  double amount = Double.parseDouble(request.getParameter("amount"));
	        String paymentMethod = request.getParameter("paymentMethod");
	        String cardNumber = request.getParameter("cardNumber");
	        String expiryDate = request.getParameter("expiryDate");
	        String cvv = request.getParameter("cvv");
	        String cardName = request.getParameter("cardName");
	        int bookingId = booking.getId();
	        System.out.println("BookingId : "+ bookingId);
	        
	        Payment payment = new Payment();
	        payment.setBookingId(bookingId);
	        payment.setPaymentAmt(amount);
	        payment.setPaymentDate(Date.valueOf(LocalDate.now()));
	        payment.setPaymentMethod(paymentMethod);
	        payment.setPaymentStatus("Paid");
	        
	        String status = "Booked";
	        userService.insertPayment(payment);
	        
	        userService.updateBookingStatus(bookingId, status);
	        
	        
	        
	     // Update room status to 'Booked'
	        String roomName = booking.getRoomName();
	        System.out.println("The Book Romm NAme : "+roomName);
	        
	        int typeId = userService.getTypeIdByRoomName(roomName);
	        int roomId = booking.getRoom();
	        System.out.println("TypeId : "+typeId);
	        userService.updateRoomStatus(typeId, roomId);
	        session.removeAttribute("booking");
	        ModelAndView mv = new ModelAndView();
	        
	        mv.addObject("msg", "Payment Successful...");
	        session.setAttribute("msg", "Payment Successfull");
	       
	        mv.setViewName("redirect:/profile");	
	        return mv;
	        
	 }
	 
	 //MODIFY THE BOOKING
	 @RequestMapping("/modifier")
	 public ModelAndView modifier(
			 @RequestParam("bookingId") int bookingId,
			 @RequestParam("customerName") String customerName,
			 @RequestParam("gender") String gender, 
			 @RequestParam("roomNumber")  String room, 
			 @RequestParam("checkinDate")  Date checkInDate,
			 @RequestParam("checkoutDate")  Date checkOutDate, 
			 @RequestParam("phoneNo") String phoneNo, 
			 @RequestParam("roomName")String roomName, 
			 @RequestParam("daysStayed")int noDay ,
			 HttpServletRequest request)
	 {
		 Booking booking = new Booking();
		 booking.setCustomer_name(customerName);
		 booking.setGender(gender);
		 booking.setRoom(Integer.parseInt(room));
		 booking.setCheck_in(checkInDate);
		 booking.setCheck_out(checkOutDate);
		 booking.setPhoneNo(phoneNo);
		 booking.setBooking_status("Pending");
		booking.setRoomName(roomName);
		
		 System.out.println("ROOM NAME :"+booking.getRoomName());
		 System.out.println("ROOM NO : "+booking.getRoom());
		 booking.setRoomName(roomName);
		 //GET RENT :
		 int roomRent = userService.getRentByRoomName(roomName);
		 //Caclulate days and rent : 
		 int bookingRent = roomRent * noDay;
		 System.out.println("RENT :"+bookingRent);
		 booking.setRent(bookingRent);
		 System.out.println(booking.getCustomer_name()+booking.getGender()+booking.getRoom()+booking.getCheck_in()+booking.getCheck_out()+booking.getCheck_out());
		 // Call the service to update the booking status, check-in, and check-out dates
		    userService.updateBooking(bookingId, customerName, gender, Integer.parseInt(room), checkInDate, checkOutDate, phoneNo);

		    ModelAndView mv = new ModelAndView();
		    mv.addObject("msg", "Booking modification successful.");
		    mv.setViewName("redirect:/profile");
		    return mv;

	     
	 }
	 @RequestMapping("/profile")
		public ModelAndView viewProfile(HttpServletRequest request, HttpServletResponse response)
		{
		 
		 
		 HttpSession session1 = request.getSession();
		 Booking booking = (Booking) session1.getAttribute("booking");
//		 System.out.println("Bookingn Name"+booking.getRoom());
		 ModelAndView mv = new ModelAndView("user/profile");
		 HttpSession session = request.getSession(false);
		 if (session != null) {
	            String email = (String) session.getAttribute("user");
	            if (email != null) {
	                User user = userService.getUserDetailsByEmail(email);
	                System.out.println("phone : "+user.getPhone());
	                if (user != null) {
	                    List<Booking> bookings = userService.getBookingsByPhone(user.getPhone());
	                    bookings.stream().forEach(book->{
	                    	System.out.println("Booking ID: " + book.getId());
	                        System.out.println("Customer Name: " + book.getCustomer_name());
	                        System.out.println("Gender: " + book.getGender());
	                        System.out.println("Room: " + book.getRoom());
	                        System.out.println("Check-in Date: " + book.getCheck_in());
	                        System.out.println("Check-out Date: " + book.getCheck_out());
	                        System.out.println("Booking Status: " + book.getBooking_status());
	                        System.out.println("Phone No: " + book.getPhoneNo());
	                        System.out.println("Rent: " + book.getRent());
	                        System.out.println("Room Name : "+book.getRoomName());
	                    });
	                    ModelAndView modelAndView = new ModelAndView();
	        			
	       			 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	       	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	       	        response.setHeader("Expires", "0");
	       			 HttpSession session11 = request.getSession(false);
	       		        if (session11 == null || session11.getAttribute("user") == null) {
	       		            
	       		        	modelAndView.setViewName("redirect:/index.jsp");
	       		            return mv;
	       		        }
	       		     // Pass the message from the session to the view
	                    String message = (String) session.getAttribute("message");
	                    System.out.println("The passed message is "+ message);
	                    if (message != null) {
	                        mv.addObject("message", message);
	                    }
	                    
	                    
	                    modelAndView.addObject("user", user);
	                    modelAndView.addObject("bookings", bookings);
	                    modelAndView.setViewName("user/profile");
	                    return modelAndView;
	                }
	            }
	        }
	        return new ModelAndView("redirect:/connect");
		
		}
	 
//	 @PostMapping("/updateBooking")
//	    public ModelAndView updateBooking(@RequestParam("id") int id,
//	                                      @RequestParam("checkIn") Date checkIn,
//	                                      @RequestParam("checkOut") Date checkOut) {
//	        userService.updateBookingDates(id, checkIn, checkOut);
//	        return new ModelAndView("redirect:/profile");
//	    }
	 
	 
	 @PostMapping("/cancelBooking")
	    public ModelAndView cancelBooking(@RequestParam("bookingId") int bookingId, HttpSession session, HttpServletRequest request,ModelAndView mv) {
		 System.out.println("Booking id :"+bookingId);
	        userService.cancelBooking(bookingId);
	        userService.updateStatus(bookingId);
//	        request.getSession().setAttribute("message", "Booking cancelled successfully");
	        session.setAttribute("message", "Booking cancelled successfully");
	        mv.setViewName("redirect:/profile");
//	        return new ModelAndView("redirect:/profile");
	        return mv;
	    }
	
	 
	  @GetMapping("/logoutUser")
	    public ModelAndView doLogout(HttpServletRequest request, HttpServletResponse response) {
		  ModelAndView mv = new ModelAndView();
	        HttpSession session = request.getSession(false);
	        
	        if (session != null) {
	        	session.removeAttribute("user");
	            session.invalidate(); // Invalidate session
	        }

	        // Set cache control headers to prevent caching
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        response.setHeader("Expires", "0");

	        mv.setViewName("redirect:/main");
	        return mv;
	    }
	  
	  @PostMapping("/refer")
	  public ModelAndView refer(ModelAndView mv,
			  @RequestParam("name") String name,
			  @RequestParam("email") String email,
			  @RequestParam("msg") String message,
			  HttpSession session
			  )
	  {
		  c.setName(name);
		  c.setEmail(email);
		  c.setMessage(message);
		  userService.insertContact(c);
		  session.setAttribute("contact", c);
		  mv.setViewName("redirect:/contact");
		  return mv;
	  }
	 
	 
}
