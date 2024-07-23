package com.issueraisesystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.util.DBUtil;

public class IssueDAO {
	
	public int getIssueCount() throws SQLException {
        String sql = "SELECT * FROM issue";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	
        	count++;
        }
        
        return count; 
    }
	
	
	//Issue Opened 
	public int getIssueOpened(String mailid) throws SQLException {
        String sql = "SELECT * FROM issue where status=? and raisedby=?";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        stmt.setString(1,"Opened");
        stmt.setString(2, mailid);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	
        	count++;
        }
       
        return count; 
    }
	
	//InProgress Issue
	public int getIssueProgress(String mailid) throws SQLException {
        String sql = "SELECT * FROM issue where status=? and raisedby=?";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        stmt.setString(1,"In_progress");
        stmt.setString(2, mailid);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	
        	count++;
        }
       
        return count; 
    }
	
	
	//Completed Issue
	public int getIssueCompleted(String mailid) throws SQLException {
        String sql = "SELECT * FROM issue where status=? and raisedby=?";
        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
        stmt.setString(1,"Completed");
        stmt.setString(2, mailid);
        ResultSet rs = stmt.executeQuery();
        int count=0;
       
        while(rs.next()) {
        	
        	count++;
        }
       
        return count; 
    }
	
	
	//Getting the Details of the issue
	
	
	 public List<Issue> getTicketsByUsername(String mailid) throws SQLException {
		
	        String sql = "SELECT * FROM issue WHERE raisedby = ? and status!=? order by issueid desc";
	       
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        
	        stmt.setString(1, mailid);
	        stmt.setString(2,"Completed");
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        List<Issue> tickets = new ArrayList<>();
	        
	        while (rs.next()) {
	          Issue issue = new Issue();
	        
	            issue.setIssueid(rs.getInt("issueid"));
	            issue.setIssuetitle(rs.getString("issueTitle"));
	            issue.setTicketraisedate(rs.getDate("ticketraisedate"));
	            issue.setRaisedby(rs.getString("raisedby"));
	            issue.setAllocateto(rs.getString("allocatedto"));
	            issue.setPriority(rs.getString("priority"));
	            issue.setIssuedate(rs.getDate("issueDate"));
	            issue.setStatus(rs.getString("status"));
	            tickets.add(issue);
	        }
	        
	      
	        return tickets;
	    }
	 
	   public static void addIssue(Issue issue) throws SQLException {
		   
		
		   String sql = "INSERT INTO issue (issuetitle, description, ticketraisedate, raisedby, allocatedto, priority, issuedate, status, issueid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ticketseq.nextval)";
		   PreparedStatement stmt=DBUtil.openConnection().prepareStatement(sql);
		   stmt.setString(1,issue.getIssuetitle());
		   stmt.setString(2,issue.getDescription());
		   stmt.setDate(3,issue.getTicketraisedate());
		   stmt.setString(4,issue.getRaisedby());
		   stmt.setString(5,issue.getAllocateto());
		   stmt.setString(6,issue.getPriority());
		   stmt.setDate(7, issue.getIssuedate());
		   stmt.setString(8,issue.getStatus());
		   stmt.executeUpdate();
		   
	   }
	   
	   public List<Issue> getHistoryOfTicket(String mailid) throws SQLException {
			
	        String sql = "SELECT * FROM issue WHERE raisedby = ?  order by issueid desc";
	       
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        
	        stmt.setString(1, mailid);
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        List<Issue> tickets = new ArrayList<>();
	        
	        while (rs.next()) {
	          Issue issue = new Issue();
	        
	            issue.setIssueid(rs.getInt("issueid"));
	            issue.setIssuetitle(rs.getString("issueTitle"));
	            issue.setTicketraisedate(rs.getDate("ticketraisedate"));
	            issue.setRaisedby(rs.getString("raisedby"));
	            issue.setAllocateto(rs.getString("allocatedto"));
	            issue.setPriority(rs.getString("priority"));
	            issue.setIssuedate(rs.getDate("issueDate"));
	            issue.setStatus(rs.getString("status"));
	            tickets.add(issue);
	        }
	        
	       
	        return tickets;
	    }
	   
	   
	   public List<Issue> getRecentTicketsByUsername(String mailid) throws SQLException{
		   
		   String sql="SELECT * FROM (SELECT * FROM issue WHERE raisedby = ? ORDER BY issueid DESC) WHERE ROWNUM = 1";
		   
		  
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        
	        List<Issue>tickets=new ArrayList<>();
	        stmt.setString(1, mailid);
	        
	        ResultSet rs=stmt.executeQuery();
	        
	        int count=1;
	        while(rs.next()) {
	        	Issue issue=new Issue();
	        	 	issue.setIssueid(rs.getInt("issueid"));
		            issue.setIssuetitle(rs.getString("issueTitle"));
		            issue.setTicketraisedate(rs.getDate("ticketraisedate"));
		            issue.setRaisedby(rs.getString("raisedby"));
		            issue.setAllocateto(rs.getString("allocatedto"));
		            issue.setPriority(rs.getString("priority"));
		            issue.setIssuedate(rs.getDate("issueDate"));
		            issue.setStatus(rs.getString("status"));
		            
		            tickets.add(issue);
	        	
	        	
	        }
	        return tickets;
	   
	   }
	   
	   
  public List<Issue> getRecentTickets() throws SQLException{
		   
		   String sql="SELECT * FROM (SELECT * FROM issue WHERE status=? ORDER BY issueid DESC) WHERE ROWNUM <=5";
		   
		  
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        
	        List<Issue>tickets=new ArrayList<>();
	        stmt.setString(1, "Raised");
	        
	        ResultSet rs=stmt.executeQuery();
	        
	        
	        while(rs.next()) {
	        	Issue issue=new Issue();
	        	 	issue.setIssueid(rs.getInt("issueid"));
		            issue.setIssuetitle(rs.getString("issueTitle"));
		            issue.setTicketraisedate(rs.getDate("ticketraisedate"));
		            issue.setRaisedby(rs.getString("raisedby"));
		            issue.setAllocateto(rs.getString("allocatedto"));
		            issue.setPriority(rs.getString("priority"));
		            issue.setIssuedate(rs.getDate("issueDate"));
		            issue.setStatus(rs.getString("status"));
		            
		            tickets.add(issue);
	        	
	        	
	        }
	        System.out.println("nbvcdrtyuio;");
	        tickets.forEach(x->System.out.println(x.getIssueid()));
	        return tickets;
	   
	   }
	   
	   
	   public List<Issue> totalIssue() throws SQLException{
		   	String sql="select * from issue";
		   
		   	
	        PreparedStatement stmt = DBUtil.openConnection().prepareStatement(sql);
	        
	        List<Issue>totalTickets=new ArrayList<>();
	       
	       
	        ResultSet rs=stmt.executeQuery();
	       
	        
	        while(rs.next()) {
	        	Issue issue=new Issue();
	        	 	issue.setIssueid(rs.getInt("issueid"));
		            issue.setIssuetitle(rs.getString("issueTitle"));
		            issue.setTicketraisedate(rs.getDate("ticketraisedate"));
		            issue.setRaisedby(rs.getString("raisedby"));
		            issue.setAllocateto(rs.getString("allocatedto"));
		            issue.setPriority(rs.getString("priority"));
		            issue.setIssuedate(rs.getDate("issueDate"));
		            issue.setStatus(rs.getString("status"));
		            
		            totalTickets.add(issue);
	        	
	        	
	        }
	        return totalTickets;
		   
		   
	   }
	   
	   
	
	

}
