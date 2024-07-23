package com.bus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bus.model.CustomersNew;


@Mapper
	public interface CustomerMapper {
	    
	    @Select("SELECT * FROM customer")
	    @Results({
	    	 @Result(property="customer_id", column="customer_id"),
		        @Result(property="firstName", column="firstname"),
		        @Result(property="lastName", column="lastname"),
		        @Result(property="gender", column="gender"),
		        @Result(property="email", column="email"),
		        @Result(property="username", column="username"),
		        @Result(property="password", column="password"),
		        @Result(property="phonenumber", column="phonenumber"),
	    })
		List<CustomersNew> viewCustomer();
	    @Update("UPDATE customer SET AVAILABLE = #{status} WHERE customer_id = #{id}")
	    void updateCustomerStatus(@Param("id") int id, @Param("status") String status);
	    
	}
