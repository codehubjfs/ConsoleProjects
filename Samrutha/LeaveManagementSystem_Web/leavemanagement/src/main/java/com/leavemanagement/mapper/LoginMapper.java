package com.leavemanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import com.leavemanagement.model.Login;

@Mapper
public interface LoginMapper {
	
	@Select("select username, password, role from employee where username = #{username} ")
	Login getLogin(String username);
}
