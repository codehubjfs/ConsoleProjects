package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Issue;

public interface IssueService {
	
	
	List<Issue>getIssue();
	List<Issue>getRecentTicketsByUsername(String mailid);
	List<Issue>getTicketsByUsername(String mailid);
	boolean insertNewTicket(Issue issue);
	List<Issue>historyOfTicket(String mailid);
}
