package com.leavemanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.leavemanagement.model.Employee;

@Mapper
public interface ManagerMapper {
	
	@Select("SELECT * FROM employee e JOIN department d ON e.DEPTID = d.DEPTID WHERE managerId=  #{id}")
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
	List<Employee> getTeams(int id);
}
