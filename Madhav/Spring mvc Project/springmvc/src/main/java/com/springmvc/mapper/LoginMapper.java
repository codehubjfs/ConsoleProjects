package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springmvc.model.Admin;
import com.springmvc.model.Login;

@Mapper
public interface LoginMapper {
	
	
	@Select("SELECT * FROM students WHERE mailid = #{email} AND password = #{password} AND role = #{role}")
    Login getUser(@Param("email") String email, @Param("password") String password, @Param("role") String role);
	
	
	
}
