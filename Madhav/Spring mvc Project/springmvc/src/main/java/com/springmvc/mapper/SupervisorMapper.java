package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springmvc.model.Supervisor;

@Mapper
public interface SupervisorMapper {
	
	@Select("select * from supervisor  order by supervisorid")
	List<Supervisor>getSupervisor();
	
	@Select("select name from supervisor where supervisorid=#{supervisorid}")
	String getSupervisorName(@Param("supervisorid")int supervisorid);
	

}
