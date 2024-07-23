package com.ticket.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.model.RoutesBean;
import com.ticket.service.RouteService;
@Controller
public class EditRoutesController{
  private final RouteService routeService;

  @Autowired
  public EditRoutesController(RouteService routeService) {
      this.routeService = routeService;
  }

  @RequestMapping("/updateRoute")
  public String updateRoute(
          @RequestParam("editRouteID") int routeId,
          @RequestParam("editStartLocation") String startLocation,
          @RequestParam("editEndLocation") String endLocation,
          @RequestParam("editDestination") int distance,
          @RequestParam("editDuration") int duration,
          Model model) {
  	System.out.println(routeId+" "+startLocation+" "+endLocation+" "+distance+" "+duration);
      RoutesBean route = routeService.getRouteById(routeId);
      System.out.println(route);
      if (route != null) {
          route.setStartLocation(startLocation);
          route.setEndLocation(endLocation);
          route.setDistance(distance);
          route.setEstimatedDuration(duration);
          routeService.updateRoute(route);
          model.addAttribute("message", "Route updated successfully!");
          return "redirect:/viewroutes"; 
      } else {
          model.addAttribute("error", "Route not found!");
          return "errorPage";
      }
  }
}
