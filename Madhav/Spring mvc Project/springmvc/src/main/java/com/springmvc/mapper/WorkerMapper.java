package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springmvc.model.Worker;

@Mapper
public interface WorkerMapper {
	
	@Select("select * from workers order by workersid")
	List<Worker>getWorker();

}
