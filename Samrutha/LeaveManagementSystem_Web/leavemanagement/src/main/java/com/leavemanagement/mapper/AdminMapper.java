package com.leavemanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.leavemanagement.model.Employee;

@Mapper
public interface AdminMapper {
	
	@Insert("")
	void insertUser(Employee emp);
}
