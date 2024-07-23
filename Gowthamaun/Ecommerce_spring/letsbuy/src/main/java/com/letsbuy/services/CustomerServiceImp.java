package com.letsbuy.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Card;
import com.letsbuy.beans.Cart;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Login;
import com.letsbuy.beans.Order;
import com.letsbuy.beans.Orders;
import com.letsbuy.beans.Product;
import com.letsbuy.mappers.AdminMapper;
import com.letsbuy.mappers.CartDetailMapper;
import com.letsbuy.mappers.CartMapper;
import com.letsbuy.mappers.CustomerMapper;
import com.letsbuy.mappers.OrderMapper;
import com.letsbuy.mappers.OrderProductMapper;
import com.letsbuy.mappers.PayementMapper;
import com.letsbuy.mappers.ProductMapper;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	CartDetailMapper cartDetailMapper;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	Orders order;
	
	@Autowired
	OrderProductMapper orderProductMapper;
	
	@Autowired
	PayementMapper paymentMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Customer validateCredentail(Login login) {
		System.out.println("Inside admin validate Login Service");
		List<Customer> customerList = customerMapper.getAllCustomers();
		customerList.stream().forEach(System.out::println);
		Customer customer = customerList.stream()
				.filter(a->a.getAccount().getPassword().equals(login.getPassword()) && a.getMobileNumber()==login.getMobileNumber())
				.findFirst().orElse(null);
		return customer;
	}

	@Override
	public List<String> getAllMobileNumbers() {
		List<String> mobileNumbers = customerMapper.getAllCustomers().stream()
				.map(c->String.valueOf(c.getMobileNumber()))
				.collect(Collectors.toList());
		return mobileNumbers;
	}

	@Override
	public List<String> getAllEmail() {
		List<String> emailAddresses = customerMapper.getAllCustomers().stream()
				.map(c->(c.getEmail()))
				.collect(Collectors.toList());
		return emailAddresses;
	}

	@Override
	public List<String> getAlluserName() {
		List<String> userNames = customerMapper.getAllCustomers().stream()
				.map(c->c.getAccount().getUserName())
				.collect(Collectors.toList());
		return userNames;
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		boolean status = customerMapper.registerCustomer(customer);
		return status;
	}

	@Override
	public boolean regsiterCart(Customer customer) {
		boolean status = cartMapper.createCart(customer);
		return status;
	}

	@Override
	public Customer getCartDetails(Customer customer) {
		List<Product> cartList = cartDetailMapper.getCustomerCart(customer);
		Map<Integer,Product> cartMap = cartList.stream().collect(Collectors.toMap(p->p.getProductId(), p->p));
		Cart cart = customer.getMyCart();
		cart.setMyCart(cartMap);
		return customer;
	}

	@Override
	public Customer updateCartDetails(Customer customer) {
		Cart cart = customer.getMyCart();
		List<Product> cartProduct = cart.getMyCart().values().stream().collect(Collectors.toList());
		double totalAmount = cartProduct.stream()
				.mapToDouble(p->(p.getProductPrice()+(p.getProductPrice()*p.getDiscount()/100))*p.getQuantity())
				.sum();
		int productsCount = cartProduct.size();
		double amountPaid = cartProduct.stream()
				.mapToDouble(p->p.getProductPrice()*p.getQuantity())
				.sum();
		double discountAmount = totalAmount-amountPaid;
		double deliveryCharges = cartProduct.stream().mapToDouble(p->p.getQuantity()*40).sum();
		cart.setDeliveryCharges(deliveryCharges);
		cart.setDiscount(discountAmount);
		cart.setPaidAmount(amountPaid+59);
		cart.setTotalAmount(totalAmount);
		cart.setProductsCount(productsCount);
		return customer;
	}

	@Override
	public boolean incrementCartQuantity(Customer customer, Product product) {
		boolean status = cartDetailMapper.incrementProductQuantity(customer, product);
		return status;
	}

	@Override
	public boolean decrementCartQuantity(Customer customer, Product product) {
		boolean status = cartDetailMapper.decrementProductQuantity(customer, product);
		return status;
	}

	@Override
	public boolean deleteCartProduct(Customer customer, Product product) {
		boolean status = cartDetailMapper.deleteCartProduct(customer, product);
		return status;
	}

	@Override
	public Orders getCustomerOrder(Customer customer) {
		List<Order> orders = orderMapper.getCustomerOrdes(customer);
		orders.sort((a, b) -> b.getOrderDate().compareTo(a.getOrderDate()));
		//order = customer.getMyOrders();
		order.setCustomerOrders(orders);
		return order;
	}

	@Override
	public boolean cancelOrder(Customer customer, Order order) {
		boolean updatePaymentStatus = false;
		boolean updateOrdersStatus = false;
		boolean updateProductStatus = false;
		boolean orderProductStatus = orderProductMapper.deleteOrderProduct(order);
		if(orderProductStatus) {
			updatePaymentStatus = paymentMapper.updatePayment(order);
			if(updatePaymentStatus) {
				updateOrdersStatus = orderMapper.updateOrders(order);
				if(updateOrdersStatus) {
					updateProductStatus = productMapper.updateProductTable(order);
					if(updateProductStatus) {
						System.out.println("Order has been cancelled successfully");
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean addProductCart(Customer customer, Product product) {
		// TODO Auto-generated method stub
		product.setQuantity(1);
		boolean status = cartDetailMapper.addProductToCart(customer, product);
		return status;
	}

	@Override
	public Product getChoosenProduct(Map<Integer,Product> productMap, int productId) {
		// TODO Auto-generated method stub
		Product product = productMap.get(productId);
		return product;
	}

	@Override
	public boolean makeOrder(List<Card> ordersList, Customer customer) {
		boolean paymentStatus = false;
		boolean status = false;
		for(Card card:ordersList) {
			System.out.println("Inside for each");
			System.out.println(card.getOrder());
			boolean orderStatus = orderMapper.makeOrders(card.getOrder());
			if(orderStatus) {
				System.out.println("orderMapper worked");
				paymentStatus = paymentMapper.makePayment(card);
				if(paymentStatus) {
					System.out.println("paymentMapper worked");
					productMapper.updateProductOrderQuantity(card.getOrder().getProduct());
					orderProductMapper.updateOrderProduct(card.getOrder());
					System.out.println("Order placed successfully");
					status = true;
				}
			}
		}
		return status;
	}

	@Override
	public boolean cartProductOrder(List<Product> products, Card card, Order order,Customer customer) {
		boolean paymentStatus = false;
		boolean status = false;
		for(Product p:products) {
			order.setProduct(p);
			order.setAmount((long) (p.getQuantity()*p.getProductPrice()));
			card.setAmount((long) (p.getQuantity()*p.getProductPrice()));
			card.setOrder(order);
			boolean orderStatus = orderMapper.makeOrders(card.getOrder());
			if(orderStatus) {
				System.out.println("orderMapper worked");
				paymentStatus = paymentMapper.makePayment(card);
				if(paymentStatus) {
					System.out.println("paymentMapper worked");
					productMapper.updateProductOrderQuantity(card.getOrder().getProduct());
					orderProductMapper.updateOrderProduct(card.getOrder());
					boolean cartDeleteStatus = cartDetailMapper.clearCustomerCart(customer);
					System.out.println("Order placed successfully");
					if(cartDeleteStatus) {
						System.out.println("The cart has been updated sucessfully");
						status = true;
					}
				}else {
					status = false;
				}
				
			}else {
				status = false;
			}
		}
		return status;
	}

	@Override
	public boolean orderRefund(Order order) {
//		paymentCancel = paymentMapper.updatePaymentStatus(order);
//		boolean paymentCancel = false,ordersStatus = false;
//		if(paymentCancel) {
//			paymentCancel = paymentMapper.updatePaymentStatus(order);
//			if(paymentCancel) {
//				ordersStatus = orderMapper.updateOrders(order);
//				if(ordersStatus) {
//					
//				}
//			}
//		}
		boolean status = false,paymentCancel = false,orderStatus=false,productUpdate = false;
		paymentCancel = paymentMapper.updatePaymentStatus(order);
		if(paymentCancel) {
			orderStatus = orderMapper.updateOrdersStatus(order);
			if(orderStatus) {
				productUpdate = productMapper.updateProductTable(order);
				if(productUpdate) {
					System.out.println("Order has been cancelled sucessfully");
					return true;
				}
			}
			status = false;
		}
		return status;
	}
	
}
