package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springmvc.model.Student;

@Mapper
public interface StudentMapper {
	
	@Select("SELECT * FROM students order by stud_id")
	List<Student> getStudent();
	
	@Select("select * from students where mailid=#{mailid}")
	List<Student> getProfile(@Param("mailid") String mailid);
	
	@Update("update students set name=#{name},phonenumber=#{phonenumber} where mailid=#{mailid}")
	boolean editProfile(Student student);

}
