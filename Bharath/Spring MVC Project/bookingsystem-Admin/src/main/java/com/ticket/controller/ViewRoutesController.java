package com.ticket.controller;

import com.ticket.model.RoutesBean;
import com.ticket.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/viewroutes")
public class ViewRoutesController {

    private final RouteService routeService;

    @Autowired
    public ViewRoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView viewRoutes() {
        List<RoutesBean> routes = routeService.getAllRoutes();
        for (RoutesBean route : routes) {
            System.out.println(route.getIndex() + " " + route.getStartLocation() + " " + route.getDistance() + " " + route.getEstimatedDuration());
        }

        ModelAndView modelAndView = new ModelAndView("Admin/Routes");
        modelAndView.addObject("routes", routes);
        return modelAndView;
    }
}
