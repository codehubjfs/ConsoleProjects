package com.taskManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.taskManage.model.UserModel;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM employee WHERE email = #{email} AND password = #{password} AND role = #{usertype}")
	UserModel getEmployee(@Param("email") String email, @Param("password") String password, @Param("usertype") String usertype);
	
	

}
