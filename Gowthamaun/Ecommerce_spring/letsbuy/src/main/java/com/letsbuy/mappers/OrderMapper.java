package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Order;

@Mapper
public interface OrderMapper {
	
	@Select("SELECT p.*, pa.amount,o.order_status, o.order_id, o.order_date, o.address, op.quantity FROM customer c JOIN orders o ON c.c_id = o.c_id JOIN order_product op ON o.order_id = op.order_id JOIN product p ON op.p_id = p.p_id JOIN payment pa ON o.order_id = pa.order_id WHERE c.c_id = #{customerId}")
	@Results({
		@Result(property="product.productName",column="p_name"),
		@Result(property="product.productId",column="p_id"),
		@Result(property="product.brand",column="p_brand"),
		@Result(property="product.productPrice",column="p_price"),
		@Result(property="product.quantity",column="quantity"),
		@Result(property="product.subtitle",column="p_subtitle"),
		@Result(property="product.description",column="p_description"),
		@Result(property="product.warranty",column="warranty"),
		@Result(property="product.varificationStatus",column="verification_status"),
		@Result(property="product.productStatus",column="product_status"),
		@Result(property="amount",column="amount"),
		@Result(property="orderId",column="order_id"),
		@Result(property="orderDate",column="order_date"),
		@Result(property="address",column="address"),
		@Result(property="orderStatus",column="order_status")
		
	})
	List<Order> getCustomerOrdes(Customer customer);
	
	@Delete("delete orders where order_id=#{orderId}")
	boolean updateOrders(Order order);
	@Update("update orders set order_status='CANCELLED',reason=#{returnReason},order_date=SYSDATE where order_id=#{orderId}")
	boolean updateOrdersStatus(Order order);
	
	@Insert("insert into orders(order_id,c_id,order_date,address,order_status) values(order_sequence.nextval,#{customer.customerId},#{orderDate},#{address},#{orderStatus})")
	@Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "order_id")
	boolean makeOrders(Order order);
	
	@Select("select COUNT(*) from Orders")
	long getOrdersCount();
}
