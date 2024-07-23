package com.letsbuy.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.letsbuy.beans.Order;

@Mapper
public interface OrderProductMapper {
	
	@Delete("delete order_product where order_id=#{orderId}")
	boolean deleteOrderProduct(Order order);
	
	@Insert("insert into order_product(order_id,p_id,quantity) VALUES(#{orderId},#{product.productId},#{product.quantity})")
	boolean updateOrderProduct(Order order);
}
