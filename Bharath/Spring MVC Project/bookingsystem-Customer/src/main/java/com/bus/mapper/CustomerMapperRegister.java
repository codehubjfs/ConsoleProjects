package com.bus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bus.model.CustomersNew;


@Mapper
	public interface CustomerMapperRegister {

	    @Insert("INSERT INTO customer (customer_id, firstname, lastname, username, email, gender, password, phonenumber) VALUES (customer_seq.NEXTVAL, #{firstname}, #{lastname}, #{username}, #{email}, #{gender}, #{password}, #{phone})")
	    void insertCustomer(@Param("firstname") String firstname,
	                        @Param("lastname") String lastname,
	                        @Param("username") String username,
	                        @Param("email") String email,
	                        @Param("gender") String gender,
	                        @Param("password") String password,
	                        @Param("phone") String phone);
	    
	   
//	    @Insert("INSERT INTO customer (customer_id, firstname, lastname, username, email, gender, password, phonenumber) VALUES (customer_seq.NEXTVAL, #{firstname}, #{lastname}, #{username}, #{email}, #{gender}, #{password}, #{phone})")
//	    @Options(useGeneratedKeys = true, keyProperty = "id")
//	    void insert(CustomersNew customer);
//
//	    @Select("SELECT * FROM customers WHERE email = #{email}")
//	    CustomersNew findByEmail(String email);
	}
