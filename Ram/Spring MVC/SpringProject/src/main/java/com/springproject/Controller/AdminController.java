package com.springproject.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.model.Admin;
import com.springproject.model.Booking;
import com.springproject.model.HouseKeeper;
import com.springproject.model.Payment;
import com.springproject.model.Room;
import com.springproject.model.RoomType;
import com.springproject.model.Staff;
import com.springproject.model.User;
import com.springproject.model.ViewBook;
import com.springproject.model.ViewPay;
import com.springproject.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//GO TO ADMIN PAGE :
	@GetMapping("/adminPage")
	public ModelAndView adminPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/index");
		return mv;

	}
	
	//ADMIN LOGIN :
	
	@PostMapping("/adminLogin")
    public ModelAndView adminLogin(@RequestParam("email") String email, 
                                   @RequestParam("password") String password,
                                   HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        if (email.isEmpty() || password.isEmpty()) {
            mv.addObject("errorMessage", "Username and Password cannot be empty");
            mv.setViewName("admin/index");
            return mv;
        }
        
        

        Admin admin = adminService.getAdminByEmailAndPassword(email, password);
        if (admin != null && admin.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", email);
            mv.setViewName("redirect:/dashboard");
        } else {
            mv.addObject("errorMessage", "Invalid username or password");
            mv.setViewName("admin/index");
        }

        return mv;
    }
	//DashBoard
//    @RequestMapping("/Dashboard")
//    public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response)
//    {
//    	ModelAndView mv = new ModelAndView();
//    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setHeader("Expires", "0");
//		 HttpSession session = request.getSession(false);
//	        if (session == null || session.getAttribute("username") == null) {
//	            // If session or username attribute is null, redirect to login
//	            mv.setViewName("admin/index");
//	            return mv;
//	        }
//
// 	        mv.setViewName("admin/dashboard");
//    	return mv;
//    }
    
    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpServletRequest request, HttpServletResponse response) {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
      response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
      response.setHeader("Expires", "0");
      ModelAndView modelAndView = new ModelAndView();

      HttpSession session = request.getSession(false);
      if (session == null || session.getAttribute("username") == null) {
          // If session or username attribute is null, redirect to login
    	  modelAndView.setViewName("admin/index");
          return modelAndView;
      }
      modelAndView.setViewName("admin/dashboard");
        modelAndView.addObject("totalBookings", adminService.getTotalBookings());
        modelAndView.addObject("roomsAvailable", adminService.getRoomsAvailable());
        modelAndView.addObject("totalCustomers", adminService.getTotalCustomers());
        modelAndView.addObject("newBookingsThisMonth", adminService.getNewBookingsThisMonth());
        modelAndView.addObject("totalStaff", adminService.getTotalStaff());
        modelAndView.addObject("revenueThisMonth", adminService.getRevenueThisMonth());
        modelAndView.addObject("getContact", adminService.getContact());
        return modelAndView;
    }
	@PostMapping("/InsertStaff")
	public ModelAndView insertStaff(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone_no");
        String password = request.getParameter("password");

        System.out.println("Name "+name);
        System.out.println("email"+email);
        System.out.println("phone "+phone);
        System.out.println("pass"+password);
        
        Map<String, String> errors = new HashMap<>();

        // Validate inputs
        if (name == null || name.isEmpty()) {
            errors.put("nameError", "Name is required.");
        }
        if (email == null || email.isEmpty()) {
            errors.put("emailError", "Email is required.");
        }
        if (phone == null || phone.isEmpty()) {
            errors.put("phoneError", "Phone is required.");
        }
        if (password == null || password.isEmpty()) {
            errors.put("passwordError", "Password is required.");
        }

        // Check for existing email and phone
        boolean emailExists = adminService.emailExists(email);
        boolean phoneExists = adminService.phoneExists(phone);

        if (emailExists) {
            errors.put("emailError", "Email already exists.");
        }
        if (phoneExists) {
            errors.put("phoneError", "Phone number already exists.");
        }

        // If there are errors, return them to the JSP
        if (!errors.isEmpty()) {
            ModelAndView mv = new ModelAndView(); // Replace with your JSP name
            session.setAttribute("errors", errors);
            session.setAttribute("param.name", name);
            session.setAttribute("param.email", email);
            session.setAttribute("param.phone_no", phone);
            mv.setViewName("redirect:/dashboard");
            return mv;
        }
//        if (!errors.isEmpty()) {
//            ModelAndView mv = new ModelAndView();
//            
//            mv.addAllObjects(errors);
//            mv.setViewName("redirect:/ListStaffServlet");
//            return mv;
//        }


        Staff newStaff = new Staff();
        newStaff.setName(name);
        newStaff.setEmail(email);
        newStaff.setPhone_no(phone);
        newStaff.setPassword(password);

        adminService.insertStaff(newStaff);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ListStaffServlet");
        return mv;
    }
	
	@RequestMapping("/ListStaffServlet")
    public ModelAndView listStaff(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		 HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("username") == null) {
	            // If session or username attribute is null, redirect to login
	            modelAndView.setViewName("admin/index");
	            return modelAndView;
	        }
		 modelAndView.setViewName("admin/staff");
		   
	        	 List<Staff> staffList = adminService.getAllStaff();
	             System.out.println("INSIDE 1");
	             
	             modelAndView.addObject("staffList", staffList);
	             staffList.stream().forEach(s->{
	             	System.out.println(s.getEmail());
	             	System.out.println(s.getName());
	             	System.out.println(s.getPassword());
	             	System.out.println(s.getPhone_no());
	             	System.out.println(s.getStaff_id());
	             });
	        
        return modelAndView;
    }
	
	 @PostMapping("/editStaff")
	    public ModelAndView editStaff(@ModelAttribute("staff") Staff staff) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/ListStaffServlet");
	        boolean isUpdated = adminService.updateStaff(staff);
	        if (isUpdated) {
	            modelAndView.addObject("message", "Staff details updated successfully");
	        } else {
	            modelAndView.addObject("message", "Failed to update staff details");
	        }
	        return modelAndView;
	    }

	    @PostMapping("/deleteStaff")
	    public ModelAndView deleteStaff(@RequestParam("email") String email) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/ListStaffServlet");
	        boolean isDeleted = adminService.deleteStaffByEmail(email);
	        if (isDeleted) {
	            modelAndView.addObject("message", "Staff deleted successfully");
	        } else {
	            modelAndView.addObject("message", "Failed to delete staff");
	        }
	        return modelAndView;
	    }
	
	    
	    @RequestMapping("/ListKeeperServlet")
	    public ModelAndView listKeeper(HttpServletRequest request, HttpServletResponse response)
	    {
	    	ModelAndView mv = new ModelAndView("admin/keeper");

	    	
	    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            // If session or username attribute is null, redirect to login
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
		        
	    	List<HouseKeeper> keeperList = adminService.getAllHousekeepers();
	    	mv.addObject("keeperList", keeperList);
	    	keeperList.stream().forEach(x->{
	    		System.out.println(x.getEmail());
	    		System.out.println(x.getKeeper_id());
	    		System.out.println(x.getName());
	    		System.out.println(x.getPassword());
	    		System.out.println(x.getPhone_no());
	    		System.out.println(x.getStatus());
	    	});
	    	return mv;
	    	
	    }
	    
	    @PostMapping("/InsertKeeperServlet")
	    public ModelAndView insertKeeper(@RequestParam("name") String name, 
	                                     @RequestParam("email") String email,
	                                     @RequestParam("phone_no") String phone_no,
	                                     @RequestParam("password") String password,
	                                     @RequestParam("status") String status) {
	        ModelAndView mav = new ModelAndView("redirect:/ListKeeperServlet");

	        if (name.isEmpty() || email.isEmpty() || phone_no.isEmpty() || password.isEmpty()) {
	            mav.setViewName("adminKeeper");
	            if (name.isEmpty()) mav.addObject("nameError", "Name is required");
	            if (email.isEmpty()) mav.addObject("emailError", "Email is required");
	            if (phone_no.isEmpty()) mav.addObject("phoneError", "Phone number is required");
	            if (password.isEmpty()) mav.addObject("passwordError", "Password is required");
	            return mav;
	        }

	        HouseKeeper keeper = new HouseKeeper();
	        keeper.setEmail(email);
	     
	        keeper.setName(name);
	        keeper.setPassword(password);
	        keeper.setPhone_no(phone_no);
	        keeper.setStatus(status);
	        adminService.addHousekeeper(keeper);
	        return mav;
	    }
	    
	    @PostMapping("/EditKeeper")
	    public ModelAndView editKeeper(@ModelAttribute("keeper") HouseKeeper keeper)
	    {
	    	 ModelAndView mav = new ModelAndView("redirect:/ListKeeperServlet");

	         if (keeper.getName().isEmpty() || keeper.getEmail().isEmpty() || keeper.getPhone_no().isEmpty() || keeper.getStatus().isEmpty()) {
	             mav.setViewName("editHousekeeper");
	             mav.addObject("keeper", keeper);
	             mav.addObject("error", "All fields are required");
	             return mav;
	         }

	         boolean isUpdated = adminService.updateHousekeeper(keeper);
	         if (isUpdated) {
	             mav.addObject("message", "Housekeeper updated successfully");
	         } else {
	             mav.addObject("error", "Failed to update housekeeper");
	         }
	         return mav;
	    }
	    
	    @PostMapping("/DeleteKeeperServlet")
	    public ModelAndView deleteKeeper(@RequestParam("email") String email) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/ListKeeperServlet");
	        
	        boolean isDeleted = adminService.deleteHousekeeper(email);
	        if (isDeleted) {
	            modelAndView.addObject("message", "Staff deleted successfully");
	        } else {
	            modelAndView.addObject("error", "Failed to delete staff");
	        }
	        return modelAndView;
	    }

	    @GetMapping("/Customers")
	    public ModelAndView listCustomers(HttpServletRequest request, HttpServletResponse response) {
	        ModelAndView mv = new ModelAndView("admin/customer");
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            // If session or username attribute is null, redirect to login
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
		        
	        List<User> customers = adminService.getAllCustomers();
	        mv.addObject("customers", customers);
	        return mv;
	    }
	    
	    @GetMapping("/viewBookings")
	    public ModelAndView viewBookings(HttpServletRequest request, HttpServletResponse response) {
	        ModelAndView modelAndView = new ModelAndView("admin/allBookings");
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            // If session or username attribute is null, redirect to login
	 	        	modelAndView.setViewName("admin/index");
	 	            return modelAndView;
	 	        }
		        
	        List<Booking> bookings = adminService.getAllBookings();
	        modelAndView.addObject("bookings", bookings);
	        return modelAndView;
	    }
	    
	 // View all payments
	    @GetMapping("/viewPayments")
	    public ModelAndView viewPayments(HttpServletRequest request, HttpServletResponse response) {
	        ModelAndView modelAndView = new ModelAndView("admin/payment");
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            // If session or username attribute is null, redirect to login
	 	        	modelAndView.setViewName("admin/index");
	 	            return modelAndView;
	 	        }
	        // Fetch all payments
	        List<ViewPay> payments = adminService.getAllPayments();
	        modelAndView.addObject("payments", payments);

	        return modelAndView;
	    }
	    
	    @GetMapping("/RoomType")
	    public ModelAndView viewRoomType(HttpServletRequest request, HttpServletResponse response)
	    {
	    	ModelAndView mv = new ModelAndView("admin/roomType");
	    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            // If session or username attribute is null, redirect to login
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
	    	List<RoomType> roomTypes = adminService.getAllRoomTypes();
	    	mv.addObject("roomTypes", roomTypes);
	    	return mv;
	    }
	    @PostMapping("/addRoomType")
	    public ModelAndView addRoomType(RoomType roomType) {
	        adminService.addRoomType(roomType);
	        return new ModelAndView("redirect:/RoomType").addObject("successMessage", "Room type added successfully");
	    }
	    
	    @PostMapping("/editRoomType")
	    public ModelAndView editRoomType(RoomType roomType) {
	        adminService.updateRoomType(roomType);
	        return new ModelAndView("redirect:/RoomType").addObject("successMessage", "Room type updated successfully");
	    }
	    
	    @PostMapping("/deleteRoomType")
	    public ModelAndView deleteRoomType(@RequestParam("type_id") int type_id) {
	        adminService.deleteRoomType(type_id);
	        return new ModelAndView("redirect:/RoomType").addObject("successMessage", "Room type deleted successfully");
	    }
	    
	    @GetMapping("/ShowRoom")
	    public ModelAndView getRoom(HttpServletRequest request, HttpServletResponse response)
	    {
	    	ModelAndView mv = new ModelAndView("admin/rooms");
	    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
	    	List<Room> room = adminService.getRoom();
	    	mv.addObject("room", room);
	    	
	    	return mv;
	    			
	    }
	    
	    @PostMapping("/add")
	    public ModelAndView addRoom(Room room) {
	        adminService.insertRoom(room);
	        return new ModelAndView("redirect:/ShowRoom").addObject("successMessage", "Room added successfully"); 
	    }
	   
	    
	    @PostMapping("/editRoom")
	    public ModelAndView editRoom(Room room) {
	        adminService.updateRoom(room);
	        return new ModelAndView("redirect:/ShowRoom");
	    }
	    
	    @PostMapping("/deleteRoom")
	    public ModelAndView deleteRoom(@RequestParam("type_Id") int type_Id) {
	        adminService.deleteRoom(type_Id);
	        return new ModelAndView("redirect:/ShowRoom"); 
	    }
	    
	    @GetMapping("/logout")
	    public ModelAndView doLogOut(HttpServletRequest request, HttpServletResponse response) {
	        ModelAndView mv = new ModelAndView();

	    
	        HttpSession session = request.getSession(false);
	        
	        if (session != null) {
	        	session.removeAttribute("username");
	            session.invalidate(); // Invalidate session
	        }

	        // Set cache control headers to prevent caching
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        response.setHeader("Expires", "0");

	        mv.setViewName("admin/index"); 
	        return mv;
	    }
	    
	    //VIEW PAY 
	    @GetMapping("/payments")
	    public ModelAndView getAllPayments(HttpServletRequest request, HttpServletResponse response) {
	    	ModelAndView mv = new ModelAndView("admin/payment");
	    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
	        List<ViewPay> payments = adminService.getAllPayment();
	     
	        mv.addObject("payments", payments);
	        return mv;
	    }

	    @GetMapping("/paymentDetails")
	    public ModelAndView getPaymentDetails(@RequestParam("paymentId") int paymentId) {
	        Payment payment = adminService.getPaymentById(paymentId);
	        ModelAndView mv = new ModelAndView("paymentDetails");
	        mv.addObject("payment", payment);
	        return mv;
	    }
	    

	    @GetMapping("/admin")
	    public ModelAndView viewAllAdmins(HttpServletRequest request, HttpServletResponse response) {
	    	ModelAndView mv = new ModelAndView();
	    	 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	         response.setHeader("Expires", "0");
	 		 HttpSession session = request.getSession(false);
	 	        if (session == null || session.getAttribute("username") == null) {
	 	            
	 	        	mv.setViewName("admin/index");
	 	            return mv;
	 	        }
	        ModelAndView mav = new ModelAndView("admin/profile");
	        mav.addObject("admins", adminService.getAllAdmins());
	        return mav;
	    }
}
