package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.SupervisorMapper;
import com.springmvc.model.Supervisor;

@Service
public class SupervisorServiceImpl implements SupervisorService {
	
	@Autowired 
	SupervisorMapper supervisorMapper;
	
	public List<Supervisor> getSupervisor(){
		return supervisorMapper.getSupervisor();
		
		
	}

	@Override
	public String getSupervisorName(int supervisorid) {
		return supervisorMapper.getSupervisorName(supervisorid);
	}
}
