package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Admin;

@Mapper
public interface AdminMapper {
	
	@Select("select * from admin")
	@Results({
		@Result(property="adminId",column="admin_id"),
		@Result(property="userName", column="username"),
		@Result(property="password",column="password")
	})
	List<Admin> getAllAdmin();
	@Update("update admin set password=#{password} where admin_id=#{adminId}")
	boolean updatePassword(Admin admin);
	@Insert("insert into admin(admin_id,username,password) VALUES (admin_sequence.nextval,#{userName},'admin@123')")
	boolean addAdmin(Admin admin);
}
