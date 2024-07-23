package com.issuesystem.issue;

import java.time.LocalDate;

public class IssueDetails{
	private int issueId;
	private String issueTitle;
    private String description;
    private LocalDate ticketRaisedDate;
    private int categoryId;
    private String raisedBy;
    private String allocatedTo;
    private String priority;
    private LocalDate issueDate;
    private String status;
	public IssueDetails(int issueId, String issueTitle, String description, LocalDate ticketRaisedDate, int categoryId,
			String raisedBy, String allocatedTo, String priority, LocalDate issueDate, String status) {
		super();
		this.issueId = issueId;
		this.issueTitle = issueTitle;
		this.description = description;
		this.ticketRaisedDate = ticketRaisedDate;
		this.categoryId = categoryId;
		this.raisedBy = raisedBy;
		this.allocatedTo = allocatedTo;
		this.priority = priority;
		this.issueDate = issueDate;
		this.status = status;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueTitle() {
		return issueTitle;
	}
	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTicketRaisedDate() {
		return ticketRaisedDate;
	}
	public void setTicketRaisedDate(LocalDate ticketRaisedDate) {
		this.ticketRaisedDate = ticketRaisedDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public String getAllocatedTo() {
		return allocatedTo;
	}
	public void setAllocatedTo(String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
   

   

    
}
