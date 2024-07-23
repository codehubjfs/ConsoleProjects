package com.ticket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ticket.model.Admin;
@Mapper
public interface AdminMapper {
	    @Select("SELECT * FROM admin WHERE email = #{email} AND password = #{password}")
	    Admin findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	}

