package com.carrentalsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carrentalsystemspring.model.Booking;
import com.carrentalsystemspring.model.Car;
import com.carrentalsystemspring.model.User;
import com.carrentalsystemspring.service.AdminService;
import com.carrentalsystemspring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	private final AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping("/admin-dashboard")
	public ModelAndView adminDashboard() {
		ModelAndView mav = new ModelAndView("admin/index");
		mav.addObject("totalUsers", adminService.getTotalUsers());
		mav.addObject("totalCars", adminService.getTotalCars());
		mav.addObject("totalRented", adminService.getTotalRented());
		return mav;
	}

	@PostMapping("/checkCarAvailability")
	public String checkCarAvailability(@RequestParam("vehicleNo") String vehicleNo, @RequestParam("date") String date,
			@RequestParam("time") String time, Model model) {
		boolean isAvailable = adminService.isCarAvailable(vehicleNo, date, time);
		model.addAttribute("isAvailable", isAvailable);
		return "admin/index";
	}

	@GetMapping("/dashboard")
	public String adminDashboard(Model model) {
		List<Car> cars = adminService.getAllCars();
		model.addAttribute("cars", cars);
		return "admin/index";
	}

	@GetMapping("/handleCar")
	public String handleCar(
			// @RequestParam("action") String action,
			@RequestParam(value = "id", required = false) int id, @RequestParam("carName") String carName,
			@RequestParam("vehicleNo") String vehicleNo, @RequestParam("available") String available,
			@RequestParam("rentalRate") int rentalRate, @RequestParam("seatCount") int seatCount,
			@RequestParam("fuelType") String fuelType, @RequestParam("carType") String carType,
			@RequestParam("bags") int bags, @RequestParam("carImageUrl") String carImageUrl) {

		Car car = new Car(id, carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags,
				carImageUrl);
		String action = "add";
		if ("add".equals(action)) {
			adminService.addCar(car);
		} else if ("edit".equals(action)) {
			adminService.updateCar(car);
		}

		return "redirect:/admin/index";
	}

	@GetMapping("/deleteCar")
	public String deleteCar(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("carId") String carId, RedirectAttributes redirectAttributes) {
		if (carId == null || carId.isEmpty()) {
			System.out.println("erroringa" + carId);
			redirectAttributes.addFlashAttribute("errorMessage", "Car ID is missing or invalid.");
			return "redirect:/admincars"; // Redirect back to the car listing page with an error message
		}

		try {
			System.out.println(carId + " hi");
			int id = Integer.parseInt(carId);
			System.out.println("erroringa");
			adminService.deleteCar(id);
			return "redirect:/admincars";
		} catch (NumberFormatException e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid car ID format.");
			return "redirect:/admincars"; // Redirect back to the car listing page with an error message
		}
	}

	@GetMapping("/admincars")
	public String carManagement(Model model) {
		List<Car> cars = adminService.getAllCars();
		model.addAttribute("cars", cars);
		System.out.println(cars);
		return "admin/carmanagement";
	}

	@GetMapping("/bookingmanagement")
	public String listBookings(Model model) {
		List<Booking> bookings = adminService.getAllBookings();
		model.addAttribute("bookings", bookings);
		return "admin/bookingmanagement";
	}

	@GetMapping("/customermanagement")
	public String customermanage(Model model) {
		List<User> bookings = adminService.getAllCustomers();
		model.addAttribute("user", bookings);
		return "admin/usermanagement";
	}

	@GetMapping("/adminlogin")
	public String loginpage(Model model) {

		return "admin/login";
	}

	@GetMapping("/customerpage")
	public String customerpage(Model model) {

		return "admin/usermanagement";
	}

	@Autowired
	private UserService userService;

	@PostMapping("/loginusers")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {

		User user = userService.getUserByUsernameAndPassword(username, password);
		ModelAndView mv = new ModelAndView();

		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("username", username);
			mv.setViewName("redirect:/admin-dashboard");
		} else {
			mv.addObject("errorMessage", "Invalid username or password.");
			mv.setViewName("admin/login");
		}

		return mv;
	}

	@RequestMapping("/userpage")
	public ModelAndView listCustomers(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<User> customers = adminService.getAllCustomers();
		model.addAttribute("customers", customers);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/usermanagement");
		return mv;
	}

	@PostMapping("/update")
	public ModelAndView updateCar(@RequestParam("carId") int carId, @RequestParam("car_name") String carName,
			@RequestParam("vehicle_no") String vehicleNo, @RequestParam("available") String available,
			@RequestParam("rental_rate") int rentalRate, @RequestParam("seat_count") int seatCount,
			@RequestParam("fuel_type") String fuelType, @RequestParam("car_type") String carType,
			@RequestParam("bags") int bags,
			@RequestParam(value = "car_image_url", required = false) String carImageUrl) {

		System.out.println(carId);

		Car car = new Car();
		car.setCar_id(carId);
		car.setCar_name(carName);
		car.setVehicle_no(vehicleNo);
		car.setAvailable(available);
		car.setRental_rate(rentalRate);
		car.setSeat_count(seatCount);
		car.setFuel_type(fuelType);
		car.setCar_type(carType);
		car.setBags(bags);
		car.setCar_image_url("url");
		System.out.println(car);
		adminService.updateCar(car);
		return new ModelAndView("redirect:/admincars");
	}

	@PostMapping("/AdminInsertCar")
	public ModelAndView insertCar(@RequestParam("carName") String carName, @RequestParam("vehicleNo") String vehicleNo,
			@RequestParam("available") String available, @RequestParam("rentalRate") int rentalRate,
			@RequestParam("seatCount") int seatCount, @RequestParam("fuelType") String fuelType,
			@RequestParam("carType") String carType, @RequestParam("bags") int bags,
			@RequestParam("carImageUrl") String carImageUrl, RedirectAttributes redirectAttributes) {

		// Create a new car object and set its properties
		Car car = new Car();
		car.setCar_name(carName);
		car.setVehicle_no(vehicleNo);
		car.setAvailable(available);
		car.setRental_rate(rentalRate);
		car.setSeat_count(seatCount);
		car.setFuel_type(fuelType);
		car.setCar_type(carType);
		car.setBags(bags);
		car.setCar_image_url(carImageUrl);

		adminService.addCar(car);
		redirectAttributes.addFlashAttribute("message", "Car added successfully!");
		return new ModelAndView("redirect:/admincars");
	}

	@PostMapping("/updateBookingStatus")
	public ModelAndView updateBookingStatus(@RequestParam("bookingId") int bookingId,
			@RequestParam("bookingStatus") String bookingStatus) {
		System.out.println(bookingId + " " + bookingStatus);
		adminService.updateBookingStatus(bookingId, bookingStatus);

		ModelAndView modelAndView = new ModelAndView("redirect:/bookingmanagement");
		modelAndView.addObject("message", "Booking status updated successfully.");
		return modelAndView;
	}

	@GetMapping("/deleteBooking")
	public ModelAndView deleteBooking(@RequestParam("bookingId") int bookingId) {
		adminService.deleteBooking(bookingId);

		ModelAndView modelAndView = new ModelAndView("redirect:/bookingmanagement");
		modelAndView.addObject("message", "Booking deleted successfully.");
		return modelAndView;
	}

	@GetMapping("/{userId}")
	public String showUserDetails(@PathVariable("userId") int userId, Model model) {
		User user = adminService.getUserById(userId);
		model.addAttribute("user", user);
		return "user-details";
	}

	@RequestMapping("/updateuser")
	public ModelAndView updateUserStatus(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("user_id") int user_id, @RequestParam("accountStatus") String accountStatus) {
		System.out.println(user_id + " k" + accountStatus);
		adminService.updateUserStatus(user_id, accountStatus);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("redirect:/customermanagement");
		return mv;
	}

	@PostMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") int userId) {
		adminService.deleteUser(userId);
		return "redirect:/customermanagement9";
	}

}
