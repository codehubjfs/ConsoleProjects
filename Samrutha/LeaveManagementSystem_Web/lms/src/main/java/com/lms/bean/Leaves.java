package com.lms.bean;

import java.time.LocalDate;

public class Leaves {
	private int leaveId;
	private Employee emp;
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String assignWork;
	private ApplicationStatus status;
	private String rejectionReason;
	
	//Default constructor
	public Leaves() {
		super();
	}
	
	//Getters and Setters
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveID) {
		this.leaveId = leaveID;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAssignWork() {
		return assignWork;
	}
	public void setAssignWork(String assignWork) {
		this.assignWork = assignWork;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public static LeaveType mapToEnum(String value) {
        if ("CASUALLEAVE".equalsIgnoreCase(value)) {
            return LeaveType.CASUALLEAVE;
        } 
        else if ("SICKLEAVE".equalsIgnoreCase(value)) {
        	return LeaveType.SICKLEAVE;
        }
        else {
        	return LeaveType.VACATIONLEAVE;
        }
    }
	
	
	//Conversion of string value to enum
		public static ApplicationStatus mapToStatus(String value) {
			if("APPROVED".equalsIgnoreCase(value)) {
	        	return ApplicationStatus.APPROVED;
	        }
	        else if("CANCELLED".equalsIgnoreCase(value)) {
	        	return ApplicationStatus.CANCELLED;
	        }
	        else if("REJECTED".equalsIgnoreCase(value)) {
	        	return ApplicationStatus.REJECTED;
	        }
	        else {
	        	return ApplicationStatus.PENDING;
	        }
		}

		@Override
		public String toString() {
			return "Leaves [ emp=" + emp + ", leaveType=" + leaveType + ", startDate="
					+ startDate + ", endDate=" + endDate + ", reason=" + reason + ", assignWork=" + assignWork
					+ ", status=" + status + "]";
		}
}
