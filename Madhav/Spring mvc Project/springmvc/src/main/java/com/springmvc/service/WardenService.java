package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Issue;
import com.springmvc.model.Warden;

public interface WardenService {
	
	List<Warden>getWarden();
	
	Warden getWardenUser(String mailid,String password);
	
	List<Issue>getRecentTicket(String status);
	
	boolean assignSupervisor(String supervisornName,int issueId,String status);
	
	boolean editRoom(String mailid,int roomNo,String blockno);

}
