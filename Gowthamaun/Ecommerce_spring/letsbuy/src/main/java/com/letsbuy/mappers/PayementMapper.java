package com.letsbuy.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Card;
import com.letsbuy.beans.Order;

@Mapper
public interface PayementMapper {
	
	@Delete("delete payment where order_id=#{orderId}")
	boolean updatePayment(Order order);
	
	@Update("update payment set payment_status='REFUND' where order_id=#{orderId}")
	boolean updatePaymentStatus(Order order);
	
	@Insert("insert into payment(payment_id,order_id,payment_date,payment_type,payment_status,amount,card_number) VALUES(payment_sequence.nextval,#{order.orderId},SYSDATE,#{paymentType},#{paymentStatus},#{amount},#{cardNumber})")
	boolean makePayment(Card card);
}
