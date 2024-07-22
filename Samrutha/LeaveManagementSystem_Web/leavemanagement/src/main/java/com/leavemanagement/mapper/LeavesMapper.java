package com.leavemanagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.jdbc.core.SqlProvider;

import com.leavemanagement.model.LeaveBalance;
import com.leavemanagement.model.LeaveType;
import com.leavemanagement.model.Leaves;

@Mapper
public interface LeavesMapper {
	
	@Select("SELECT l.leaveId,l.leaveType, l.startDate, l.endDate, l.reason, l.assignWork, l.status AS leaveStatus, 'l.rejectionReason', "
			+ "e.empId, e.firstName, e.lastName, e.email, e.managerId, e.joinDate, e.salary, e.gender, e.role, e.status AS empStatus, e.username, e.password, "
			+ "d.deptId, d.deptName, d.location "
			+ "FROM leaves l "
			+ "JOIN employee e ON e.empId = l.empId "
			+ "JOIN department d ON d.deptId = e.deptId "
			+ "WHERE l.empId = #{id}")
		@Results({
			@Result(property = "leaveId", column = "leaveId"),
			@Result(property = "leaveType", column = "leaveType"),
			@Result(property = "startDate", column = "startDate"),
			@Result(property = "endDate", column = "endDate"),
			@Result(property = "reason", column = "reason"),
			@Result(property = "assignWork", column = "assignWork"),
			@Result(property = "status", column = "leaveStatus"),
			@Result(property = "rejectionreason", column = "rejectionReason"),
			@Result(property = "emp.empID", column = "empId"),
			@Result(property = "emp.firstName", column = "firstName"),
			@Result(property = "emp.lastName", column = "lastName"),
			@Result(property = "emp.email", column = "email"),
			@Result(property = "emp.managerId", column = "managerId"),
			@Result(property = "emp.joinDate", column = "joinDate"),
			@Result(property = "emp.salary", column = "salary"),
			@Result(property = "emp.gender", column = "gender"),
			@Result(property = "emp.role", column = "role"),
			@Result(property = "emp.status", column = "empStatus"),
			@Result(property = "emp.username", column = "username"),
			@Result(property = "emp.password", column = "password"),
			@Result(property = "emp.department.deptId", column = "deptId"),
			@Result(property = "emp.department.deptName", column = "deptName"),
			@Result(property = "emp.department.location", column = "location")
		})
		List<Leaves> getLeavesById(int id);
	
	
	
	@Insert("INSERT INTO leaves VALUES (leaveSeq.nextval, #{emp.empID}, #{leaveType}, #{startDate}, #{endDate}, #{reason}, #{assignWork}, #{status}, #{rejectionreason})")
    void insertLeave(Leaves leave);
	
	
	@Update("UPDATE leaves SET leaveType = #{leaveType}, startDate = #{startDate}, endDate = #{endDate}, reason = #{reason}, assignWork = #{assignWork} " +
            "WHERE leaveId = #{leaveId}")
    void updateLeave(Leaves leave);
	
	
	@Select("select * from leaveBalance where empId = #{id}")
	LeaveBalance displayLeaveCount(int id);
	
	@Select("select * from leaves where status = 'PENDING'")
	List<Leaves> getAllPendingLeaves();
	
	@Update("UPDATE leaves SET STATUS = 'CANCELLED' WHERE leaveId = #{id}")
    void calcelLeave(int id);
	
	@Update("UPDATE leaves SET STATUS = 'REJECTED', REJECTIONREASON = #{reason} WHERE leaveId = #{id}")
    void rejectLeave(@Param("id") int id, @Param("reason") String reason);
	
	@Update("UPDATE leaves SET STATUS = 'APPROVED' WHERE leaveId = #{id}")
    void approveLeave(@Param("id") int id, @Param("reason") int empId);
	
	@Update("UPDATE leaves SET STATUS = 'APPROVED', ASSIGNWORK = #{empName} WHERE leaveId = #{id}")
    void reassignApproveLeave(@Param("id") int id, @Param("empName") String empName);
	
	
	@UpdateProvider(type = SqlProvider.class, method = "updateLeaveCount")
	void updateLeaveCount(@Param("id") int id, @Param("days") int days, @Param("leaveTypeColumn") String leaveTypeColumn);
	
	class SqlProvider {
        public String updateLeaveCount(Map<String, Object> params) {
            return "UPDATE leavebalance SET " + params.get("leaveTypeColumn") + " = " + params.get("leaveTypeColumn") + " - #{days}, BALANCELEAVE = BALANCELEAVE - #{days} WHERE empId = #{id}";
        }
    }
	
	@Select("SELECT l.leaveId,l.leaveType, l.startDate, l.endDate, l.reason, l.assignWork, l.status AS leaveStatus, l.rejectionReason, e.empId, e.firstName, e.lastName, e.email, e.managerId, e.joinDate, e.salary, e.gender, e.role, e.status AS empStatus, e.username, e.password, d.deptId, d.deptName, d.location FROM leaves l JOIN employee e ON e.empId = l.empId JOIN department d ON d.deptId = e.deptId WHERE e.managerId = #{id}")
		@Results({
			@Result(property = "leaveId", column = "leaveId"),
			@Result(property = "leaveType", column = "leaveType"),
			@Result(property = "startDate", column = "startDate"),
			@Result(property = "endDate", column = "endDate"),
			@Result(property = "reason", column = "reason"),
			@Result(property = "assignWork", column = "assignWork"),
			@Result(property = "status", column = "leaveStatus"),
			@Result(property = "rejectionreason", column = "rejectionReason"),
			@Result(property = "emp.empID", column = "empId"),
			@Result(property = "emp.firstName", column = "firstName"),
			@Result(property = "emp.lastName", column = "lastName"),
			@Result(property = "emp.email", column = "email"),
			@Result(property = "emp.managerId", column = "managerId"),
			@Result(property = "emp.joinDate", column = "joinDate"),
			@Result(property = "emp.salary", column = "salary"),
			@Result(property = "emp.gender", column = "gender"),
			@Result(property = "emp.role", column = "role"),
			@Result(property = "emp.status", column = "empStatus"),
			@Result(property = "emp.username", column = "username"),
			@Result(property = "emp.password", column = "password"),
			@Result(property = "emp.department.deptId", column = "deptId"),
			@Result(property = "emp.department.deptName", column = "deptName"),
			@Result(property = "emp.department.location", column = "location")
		})
		List<Leaves> getLeavesByManagerId(int id);
	
	
}
