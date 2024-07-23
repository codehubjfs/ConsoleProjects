package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Product;

@Mapper
public interface CartDetailMapper {
	@Select("select p.warranty,p.p_brand,p.p_description,p.p_id,p.p_name,p.p_subtitle,p.p_price,cd.quantity,v.username,v.v_id from product p,cart_detail cd,cart ca,customer c,vendor v where c.c_id=ca.c_id and c.c_id=#{customerId} and cd.cart_id=ca.cart_id and cd.p_id=p.p_id and p.v_id=v.v_id")
	@Results({
		@Result(property="productId",column="p_id"),
		@Result(property="warranty",column="warranty"),
		@Result(property="brand",column="p_brand"),
		@Result(property="description",column="p_description"),
		@Result(property="productName",column="p_name"),
		@Result(property="subtitle",column="p_subtitle"),
		@Result(property="productPrice",column="p_price"),
		@Result(property="quantity",column="quantity"),
		@Result(property="vendor.account.userName",column="username"),
		@Result(property="vendor.vendorId",column="v_id")
	})
	List<Product> getCustomerCart(Customer customer);
	
	@Update("update cart_detail set quantity=quantity+1 where cart_id=#{customer.myCart.cartId} AND p_id=#{product.productId}")
	boolean incrementProductQuantity(@Param("customer") Customer customer,@Param("product") Product product);
	
	@Update("update cart_detail set quantity=quantity-1 where cart_id=#{customer.myCart.cartId} AND p_id=#{product.productId}")
	boolean decrementProductQuantity(@Param("customer") Customer customer,@Param("product") Product product);
	
	@Delete("delete from cart_detail where cart_id=#{customer.myCart.cartId} and p_id=#{product.productId}")
	boolean deleteCartProduct(@Param("customer") Customer customer,@Param("product") Product product);
	
	@Insert("insert into cart_detail(cart_id,p_id,quantity) VALUES(#{customer.myCart.cartId},#{product.productId},#{product.quantity})")
	boolean addProductToCart(@Param("customer") Customer customer,@Param("product") Product product);
	
	@Delete("delete from cart_detail where cart_id=#{myCart.cartId}")
	boolean clearCustomerCart(Customer customer);
}
