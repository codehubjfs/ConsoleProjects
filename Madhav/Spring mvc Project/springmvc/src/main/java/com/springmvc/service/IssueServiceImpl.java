package com.springmvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.IssueMapper;
import com.springmvc.model.Issue;

@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	private IssueMapper issueMapper;
		
	@Override
	public List<Issue> getIssue() {
		return issueMapper.getIssue();
	}
	
	public List<Issue>getRecentTicketsByUsername(String mailid){
		return issueMapper.getRecentTicketsByUsername(mailid);
	}
	
	public List<Issue>getTicketsByUsername(String mailid){
		return issueMapper.getTicketsByUsername(mailid).stream().filter(x->!x.getStatus().equals("Completed")).collect(Collectors.toList());
	}
	
	public List<Issue>historyOfTicket(String mailid){
		return issueMapper.getTicketsByUsername(mailid);
		
	}
	
	public boolean insertNewTicket(Issue issue) {
		boolean inserted=issueMapper.insertNewTicket(issue);
		return inserted;
		
	}
	
	

}
