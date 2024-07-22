package com.leavemanagement.lms.leave;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.leavemanagement.lms.department.Department;
import com.leavemanagement.lms.driver.AppDriver;
import com.leavemanagement.lms.employee.AccountStatus;
import com.leavemanagement.lms.employee.Employee;
import com.leavemanagement.lms.style.Border;

public class LeaveApplication {
	
	private int leaveId;
	private Employee employee;
	private LeaveType leavetype;
	private LocalDate startDate;
	private LocalDate endDate;
	private String leaveReason;
	private LocalDate submitDate;
	private Status status;
	private String rejectionReason;
	private int workAssigned;
	
	public LeaveApplication() {
		
	}
	
	public LeaveApplication(int leaveId,Employee emp, LeaveType leavetype, LocalDate startDate, LocalDate endDate,
			String leaveReason, LocalDate submitDate, Status status, String rejectionReason, int workAssigned) {
		super();
		this.leaveId = leaveId;
		this.employee = emp;
		this.leavetype = leavetype;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveReason = leaveReason;
		this.submitDate = submitDate;
		this.status = status;
		this.rejectionReason = rejectionReason;
		this.workAssigned = workAssigned;
	}
	
	public LeaveApplication(Employee emp, LeaveType leavetype, LocalDate startDate, LocalDate endDate,
			String leaveReason, LocalDate submitDate, Status status, String rejectionReason, int workAssigned) {
		super();
		this.employee = emp;
		this.leavetype = leavetype;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveReason = leaveReason;
		this.submitDate = submitDate;
		this.status = status;
		this.rejectionReason = rejectionReason;
		this.workAssigned = workAssigned;
	}
	
	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveType getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
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

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public int getWorkAssigned() {
		return workAssigned;
	}

	public void setWorkAssigned(int workAssigned) {
		this.workAssigned = workAssigned;
	}
	
	//Conversion of string value to enum
		public LeaveType mapToEnum(String value) {

	        if ("CASUAL_LEAVE".equalsIgnoreCase(value)) {
	            return LeaveType.CASUAL_LEAVE;
	        } 
	        else if ("MARRIAGE_LEAVE".equalsIgnoreCase(value)) {
	            return LeaveType.MARRIAGE_LEAVE ;
	        } 
	        else  if ("MATERNITY_LEAVE".equalsIgnoreCase(value)) {
	        	return  LeaveType.MATERNITY_LEAVE;
	        }
	        else if ("SICK_LEAVE".equalsIgnoreCase(value)) {
	        	return LeaveType.SICK_LEAVE;
	        }
	        else {
	        	return LeaveType.VACATION_LEAVE;
	        }
	    }
		
		//Conversion of string value to enum
		public Status mapToStatus(String value) {
			if("APPROVED".equalsIgnoreCase(value)) {
	        	return Status.APPROVED;
	        }
	        else if("CANCELLED".equalsIgnoreCase(value)) {
	        	return Status.CANCELLED;
	        }
	        else if("REJECTED".equalsIgnoreCase(value)) {
	        	return Status.REJECTED;
	        }
	        else {
	        	return Status.WAITING_IN_QUEUE;
	        }
		}
		
		//insert leave into Database
		public void insertLeave(LeaveApplication leave) {
			Border border = new Border();
			
			System.out.println("HEllo insert leave method");
			System.out.println(leave);
			try {
			    String sql = "insert into leaveapplication values(leaveSeq.nextval, ? , ?, ?, ?, ?, ?, ?, ?, ?)";
			    PreparedStatement pst = AppDriver.getConnection().prepareStatement(sql);
			    pst.setInt(1, leave.getEmployee().getEmpId());
			    pst.setString(2, leave.getLeavetype().toString());
			    pst.setDate(3, Date.valueOf(leave.getStartDate())); // Convert LocalDate to SQL Date
			    pst.setDate(4, Date.valueOf(leave.getEndDate()));   // Convert LocalDate to SQL Date
			    pst.setString(5, leave.getLeaveReason());
			    pst.setDate(6, Date.valueOf(leave.getSubmitDate())); // Convert LocalDate to SQL Date
			    pst.setString(7, leave.getStatus().toString()); 
			    pst.setString(8, leave.getRejectionReason());
			    pst.setInt(9, leave.getWorkAssigned());
			    int res = pst.executeUpdate();
			    if(res == 0) {
			    	System.out.println("---------------------------------------------");
			        System.out.println("Something went wrong...!");
			        System.out.println("---------------------------------------------");
			    } else {
			    	border.applyNoteBorder("Leave request submitted successfully...!");
			    }
			} 
			catch(Exception e) {
				System.out.println("---------------------------------------------");
				System.out.println(e.getMessage());
				System.out.println("---------------------------------------------");
			}
		}
		
		//Display all leaves
		public ArrayList<LeaveApplication>showAllLeaves(){
			ArrayList<LeaveApplication> leave = new ArrayList<>();
			Set<Integer> processedIds = new HashSet<>();
			Employee emp = null;
			Department dept = null;
			LeaveApplication leaves = new LeaveApplication();
			try {
				String sql = "select * from leaveApplication l JOIN employee e ON e.empId = l.empId, employee e JOIN department d ON  e.DEPTID = d.DEPTID";
				PreparedStatement prs = AppDriver.getConnection().prepareStatement(sql);
				ResultSet rs = prs.executeQuery();
				while(rs.next()) {
					int leaveApplicationId = rs.getInt("leaveId");
					if (!processedIds.contains(leaveApplicationId)) {
						LeaveType type = leaves.mapToEnum(rs.getString("LeaveType"));
						Date sdate = rs.getDate("startDate");
						Date edate = rs.getDate("endDate");
						Date submitDate = rs.getDate("SUBMITDATE");
						Status status = leaves.mapToStatus(rs.getString("status"));
						
						dept = new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("Location"));
						emp = new Employee(rs.getString("fname"), rs.getString("lname"),rs.getInt("empId") ,rs.getString("email"), rs.getString("userName"), rs.getString("password"), dept, rs.getDate("joindate").toLocalDate(), rs.getFloat("salary"), rs.getString("role"), rs.getInt("managerId"), AccountStatus.mapToStatus(rs.getString("empAccStatus"))); 
						
						leaves = new LeaveApplication(emp, type, sdate.toLocalDate() , edate.toLocalDate(), rs.getString("leaveReason"), submitDate.toLocalDate(),status, rs.getString("rejectionReason") ,rs.getInt("workAssigned"));
						leave.add(leaves);
						processedIds.add(leaveApplicationId);
					}
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return leave;
		}

		@Override
		public String toString() {
			return "LeaveApplication [employee=" + employee + ", leavetype=" + leavetype + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", leaveReason=" + leaveReason + ", submitDate=" + submitDate
					+ ", status=" + status + ", rejectionReason=" + rejectionReason + ", workAssigned=" + workAssigned
					+ "]";
		}
		
		
}
