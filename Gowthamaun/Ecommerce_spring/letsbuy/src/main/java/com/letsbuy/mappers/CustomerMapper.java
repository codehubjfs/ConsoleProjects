package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Customer;

@Mapper
public interface CustomerMapper {
	
	@Select("SELECT c.*, ct.cart_id " +
            "FROM customer c " +
            "LEFT JOIN cart ct ON c.c_id = ct.c_id")
	@Results({
		@Result(property="customerId",column="c_id"),
		@Result(property="firstName",column="first_name"),
		@Result(property="lastName",column="last_name"),
		@Result(property="gender",column="gender"),
		@Result(property="account.userName",column="username"),
		@Result(property="account.password",column="password"),
		@Result(property="account.accountType",column="account_type"),
		@Result(property="account.accountStatus",column="account_status"),
		@Result(property="address",column="address"),
		@Result(property="email",column="email_id"),
		@Result(property="mobileNumber",column="mobile_no"),
		@Result(property="myCart.cartId",column="cart_id")
	})
	List<Customer> getAllCustomers();
	
	@Insert("insert into customer(c_id,username,password,first_name,last_name,address,gender,mobile_no,email_id,account_type,account_status) values(customer_sequence.nextval,#{account.userName},#{account.password},#{firstName},#{lastName},#{address},#{gender},#{mobileNumber},#{email},#{account.accountType},#{account.accountStatus})")
	@Options(useGeneratedKeys = true, keyProperty = "customerId", keyColumn = "c_id")
	boolean registerCustomer(Customer customer);
	
	@Update("update customer set account_status=#{account.accountStatus} where c_id=#{customerId}")
	boolean changeCustomerStatus(Customer customer);
}
