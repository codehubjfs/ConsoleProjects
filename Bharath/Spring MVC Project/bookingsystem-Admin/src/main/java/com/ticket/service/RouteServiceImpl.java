package com.ticket.service;

import com.ticket.mapper.RoutesMapper;
import com.ticket.model.RoutesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RoutesMapper routeMapper;

    @Autowired
    public RouteServiceImpl(RoutesMapper routeMapper) {
        this.routeMapper = routeMapper;
    }

    @Override
    public List<RoutesBean> getAllRoutes() {
        return routeMapper.getAllRoutes();
    }

    @Override
    public void addRoute(RoutesBean route) {
        routeMapper.insertRoute(route);
    }

	@Override
	public RoutesBean getRouteById(int routeId) {
		return routeMapper.getRouteById(routeId);
	}

	@Override
	public void updateRoute(RoutesBean route) {
		 routeMapper.updateRoute(route);
		
	}

	@Override
	public void deleteRoute(int routeId) {
		routeMapper.delteRoute(routeId);
		
	}
}
