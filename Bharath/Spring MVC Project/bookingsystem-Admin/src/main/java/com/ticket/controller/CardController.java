package com.ticket.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticket.model.Admin;
import com.ticket.model.BookingBean;
import com.ticket.model.Bus;
import com.ticket.model.Customer;
import com.ticket.model.RoutesBean;
import com.ticket.service.CardService;


/**
 * Servlet implementation class CardController
 */
@Controller
public class CardController {


	    @Autowired
	    private CardService cardService;

	    @GetMapping("/card")
	    public String showAdminDashboard(Model model) {
	    	List<Bus> bus=cardService.getAllBus();
	    	int totalBus = bus.size();
	        System.out.println("Number of Bus: " + totalBus);
	        model.addAttribute("Buses", totalBus);
	        
	        List<RoutesBean> routes = cardService.getAllRoutes();
	        if (routes != null) {
	            int routeSize = routes.size();
	            System.out.println("Number of routes: " + routeSize);
	            model.addAttribute("Routes", routeSize);
	        }

	        List<Customer> customers = cardService.viewCustomer();
	        int customerSize = customers.size();
	        System.out.println("Number of Customers: " + customerSize);
	        model.addAttribute("Customers", customerSize);
	        
	        List<BookingBean> book=cardService.getAllBooking();
	        int totalBooking=book.size();
	        System.out.println("Number of Bookings: "+totalBooking);
	        model.addAttribute("Bookings", totalBooking);

	        return "Admin/AdminIndex";
	    }
}