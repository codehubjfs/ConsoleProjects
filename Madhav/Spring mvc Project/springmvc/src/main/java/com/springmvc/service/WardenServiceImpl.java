package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.WardenMapper;
import com.springmvc.model.Issue;
import com.springmvc.model.Warden;

@Service
public class WardenServiceImpl implements WardenService {
	
	
	@Autowired
	WardenMapper wardenMapper;
	
	public List<Warden> getWarden(){
		
		return wardenMapper.getWarden();
		
	}

	@Override
	public Warden getWardenUser(String mailid,String password) {
		return wardenMapper.getWardenUser(mailid,password);
	}

	@Override
	public List<Issue> getRecentTicket(String status) {
		return wardenMapper.getRecentTicket(status);
	}

	@Override
	public boolean assignSupervisor(String supervisornName, int issueId,String status) {
		return wardenMapper.assignSupervisor(supervisornName,issueId,status);
	}

	@Override
	public boolean editRoom(String mailid, int roomNo, String blockno) {
		return wardenMapper.editRoom(mailid,roomNo,blockno);
	}

}
