package com.leavemanagement.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.leavemanagement.model.LeaveBalance;
import com.leavemanagement.model.LeaveType;
import com.leavemanagement.model.Leaves;

public interface LeaveService {
	
	List<Leaves> getLeavesById(int id);
	void insertLeave(Leaves leave);
	void updateLeave(Leaves leave);
	LeaveBalance displayLeaveCount(int id);
	void cancelLeave(int id);
	void approveLeave(int id, int empId);
	void rejectLeave(int id, String reason);
	List<Leaves> getLeavesByManagerId(int id);
	void updateLeaveCount(int id, int days, LeaveType leaveType);
	void reassignApproveLeave(int id, String empName);
}
