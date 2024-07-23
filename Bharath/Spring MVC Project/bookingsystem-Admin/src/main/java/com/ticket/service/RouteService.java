package com.ticket.service;

import com.ticket.model.RoutesBean;

import java.util.List;

public interface RouteService {
    List<RoutesBean> getAllRoutes();
    void addRoute(RoutesBean route);
    RoutesBean getRouteById(int routeId);
    void updateRoute(RoutesBean route);
	void deleteRoute(int routeId);
}

