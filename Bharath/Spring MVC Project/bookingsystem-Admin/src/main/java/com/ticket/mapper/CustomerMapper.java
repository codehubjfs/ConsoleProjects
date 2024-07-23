package com.ticket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ticket.model.Customer;

@Mapper
	public interface CustomerMapper {
	    
	    @Select("SELECT * FROM customer")
		List<Customer> viewCustomer();
	    @Update("UPDATE customer SET AVAILABLE = #{status} WHERE customer_id = #{id}")
	    void updateCustomerStatus(@Param("id") int id, @Param("status") String status);
	    
	}
