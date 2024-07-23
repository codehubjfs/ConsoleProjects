package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Supervisor;

public interface SupervisorService {
	
	List<Supervisor>getSupervisor();
	
	String getSupervisorName(int supervisorid);

	

}
