package com.letsbuy.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.letsbuy.beans.Customer;

@Mapper
public interface CartMapper {
	
	@Insert("insert into cart(cart_id,c_id) values(cart_sequence.nextval,#{customerId})")
	@Options(useGeneratedKeys = true, keyProperty = "myCart.cartId", keyColumn = "cart_id")
	boolean createCart(Customer customer);
}
