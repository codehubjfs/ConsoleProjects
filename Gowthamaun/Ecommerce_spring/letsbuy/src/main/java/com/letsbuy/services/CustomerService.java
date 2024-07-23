package com.letsbuy.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.letsbuy.beans.Card;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Login;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Orders;
import com.letsbuy.beans.Product;


public interface CustomerService {
	Customer validateCredentail(Login login);
	List<String> getAllMobileNumbers();
	List<String> getAllEmail();
	List<String> getAlluserName();
	boolean registerCustomer(Customer customer);
	boolean regsiterCart(Customer customer);
	Customer getCartDetails(Customer customer);
	Customer updateCartDetails(Customer customer);
	boolean incrementCartQuantity(Customer customer,Product product);
	boolean decrementCartQuantity(Customer customer,Product product);
	boolean deleteCartProduct(Customer customer,Product product);
	Orders getCustomerOrder(Customer customer);
	boolean cancelOrder(Customer customer,Order order);
	boolean addProductCart(Customer customer,Product product);
	Product getChoosenProduct(Map<Integer,Product> productMap,int productId);
	boolean makeOrder(List<Card> ordersList,Customer customer);
	boolean cartProductOrder(List<Product> products,Card card,Order order,Customer customer);
	boolean orderRefund(Order order);
}
