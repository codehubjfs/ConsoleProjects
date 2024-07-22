package com.leavemanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.leavemanagement.model.Employee;

@Mapper
public interface EmployeeMapper {
	
	@Select("SELECT * FROM employee e JOIN department d ON e.DEPTID = d.DEPTID WHERE username= #{username}")
	@Results({
	    @Result(property = "empID", column = "empID"),
	    @Result(property = "firstName", column = "firstName"),
	    @Result(property = "lastName", column = "lastName"),
	    @Result(property = "email", column = "email"),
	    @Result(property = "managerId", column = "managerId"),
	    @Result(property = "joinDate", column = "joinDate"),
	    @Result(property = "salary", column = "salary"),
	    @Result(property = "gender", column = "gender"),
	    @Result(property = "role", column = "role"),
	    @Result(property = "status", column = "status"),
	    @Result(property = "username", column = "username"),
	    @Result(property = "password", column = "password"),
	    @Result(property = "department.deptId", column = "deptId"),
	    @Result(property = "department.deptName", column = "deptName"),
	    @Result(property = "department.location", column = "location")
	})
	Employee getEmployeeDetail(String username);
	
	@Update("Update employee set password = #{password} where empId = #{id}")
	void updatePassword(@Param("password") String password, @Param("id") int id);
	
}
