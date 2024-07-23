package com.testPortal.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.testPortal.model.User;

public interface UserMapper {

	@Select("SELECT email, password, 'Admin' AS userType FROM admin WHERE email = #{email}")
	User findAdminByEmail(@Param("email") String email);

	@Select("SELECT email, password, 'Student' AS userType FROM student WHERE email = #{email}")
	User findStudentByEmail(@Param("email") String email);

	@Select("SELECT email, password, 'Instructor' AS userType FROM educator WHERE email = #{email}")
	User findInstructorByEmail(@Param("email") String email);

}
