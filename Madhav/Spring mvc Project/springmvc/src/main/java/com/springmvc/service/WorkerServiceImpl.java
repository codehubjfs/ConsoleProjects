package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.WorkerMapper;
import com.springmvc.model.Worker;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerMapper workerMapper;
	
	@Override
	public List<Worker> getWorker() {
		
		return workerMapper.getWorker();
	}

	
}
