package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.mapper.BusMapper;
import com.bus.model.Bus;

@Service
	public class BusServiceImpl implements BusService {

	    @Autowired
	    private BusMapper busMapper;

	    @Override
	    public List<Bus> getBusList() {
	        return busMapper.busList();
	    }
	    @Override
	    public List<Bus> searchBuses(String startlocation, String endlocation, LocalDate travelDate) {
	        return busMapper.searchBuses(startlocation, endlocation, travelDate);
	    }	
	}
