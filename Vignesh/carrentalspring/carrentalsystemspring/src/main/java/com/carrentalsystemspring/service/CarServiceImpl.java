package com.carrentalsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystemspring.mapper.CarMapper;
import com.carrentalsystemspring.model.Car;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarMapper carMapper;
	
	@Override
	public List<Car> getCars() {	
		List<Car> car = carMapper.getCars(); 
		return car;
	}
	
}
