package com.bus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bus.model.CustomersNew;

@Mapper
public interface MapperCustomer {
	    @Select("SELECT * FROM customer WHERE email = #{email} AND password = #{password}")
	    CustomersNew findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
//	    @Insert("INSERT INTO customer (admin_id, firstname, lastname, email, username, password, phonenumber) " +
//	            "VALUES (Admin_id_sequ.NEXTVAL, #{firstName}, #{lastName}, #{email}, #{username}, #{password}, #{phoneNumber})")
//	    void insertAdmin(CustomersNew customer);

	}

