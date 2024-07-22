package com.leavemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.mapper.LeavesMapper;
import com.leavemanagement.model.LeaveBalance;
import com.leavemanagement.model.LeaveType;
import com.leavemanagement.model.Leaves;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	LeavesMapper leavesMapper;
	@Override
	public List<Leaves> getLeavesById(int id) {
		List<Leaves> leaveList = leavesMapper.getLeavesById(id);
		System.out.println("Service: " + leaveList);
		for(Leaves l: leaveList) {
			System.out.println("LEave type = " + l.getLeaveType());
		}
		return leaveList;
	}
	
	@Override
	public void insertLeave(Leaves leave) {
		leavesMapper.insertLeave(leave);
	}

	@Override
	public void updateLeave(Leaves leave) {
		leavesMapper.updateLeave(leave);
	}

	@Override
	public LeaveBalance displayLeaveCount(int id) {
		LeaveBalance leaveBalance = leavesMapper.displayLeaveCount(id);
		return leaveBalance;
	}

	@Override
	public void cancelLeave(int id) {
		leavesMapper.calcelLeave(id);
	}

	@Override
	public List<Leaves> getLeavesByManagerId(int id) {
		List<Leaves> leaves = leavesMapper.getLeavesByManagerId(id);
		return leaves;
	}

	@Override
	public void approveLeave(int id, int empId) {
		leavesMapper.approveLeave(id, empId);
	}

	@Override
	public void rejectLeave(int id, String reason) {
		leavesMapper.rejectLeave(id, reason);
	}

	@Override
	public void updateLeaveCount(int id, int days, LeaveType leaveType) {
		
		String leaveTypeColumn = "";
        switch (leaveType) {
            case CASUALLEAVE:
                leaveTypeColumn = "CASUALLEAVE";
                break;
            case VACATIONLEAVE:
                leaveTypeColumn = "VACATIONLEAVE";
                break;
            case SICKLEAVE:
                leaveTypeColumn = "SICKLEAVE";
                break;
        }
                
		leavesMapper.updateLeaveCount(id, days, leaveTypeColumn);
	}

	@Override
	public void reassignApproveLeave(int id, String empName) {
		leavesMapper.reassignApproveLeave(id, empName);
	}

}
