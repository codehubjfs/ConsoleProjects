package com.bus.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.mapper.PaymentMapper;
import com.bus.model.Booking;
import com.bus.model.Bus;
import com.bus.model.CustomersNew;
import com.bus.model.Payment;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private  PaymentMapper paymentMapper;
	
	@Autowired 
	BookingService bookingService;
    @Override
	public void payAmount(String upi, String paymentMethod, String paymentstatus, List<Booking> book) {
		
		int customerId = book.stream()
                .findFirst()
                .map(Booking::getCustomer)
                .map(x-> x.getCustomer_id()).orElseThrow(() -> new NoSuchElementException("No booking found in the list"));
		int busId =  book.stream()
                .findFirst()
                .map(Booking::getBus)
                .map(x-> x.getBusid()).orElseThrow(() -> new NoSuchElementException("No booking found in the list"));
		System.out.println("From service ------------------------------------------------------------");
		 book.stream().map(Booking::getRoute).forEach(b->System.out.println(b.getIndex()));
		int routeId =  book.stream()
                .findFirst()
                .map(Booking::getRoute)
                .map(r->r.getIndex()).orElseThrow(() -> new NoSuchElementException("No booking found in the list"));
        String boardingPoint=book.stream()
        		.findFirst()
        		.map(Booking::getBoardingPoint).orElse(null);
        
        String droppingPoint=book.stream()
        		.findFirst()
        		.map(Booking::getDroppingPoint).orElse(null);
        
        List<Integer> seatNumber = book.stream().map(Booking::getSelectedSeats).collect(Collectors.toList());

		double totalPrice=book.stream()
				.findFirst()
				.map(Booking::getTotalPrice).orElse(null);
		bookingService.bookSeats(customerId,busId,routeId,boardingPoint,droppingPoint,seatNumber,totalPrice,"Bookedandpaid");
		
		 for (Booking booking : book) {
	            Payment payment = new Payment();
	            payment.setAccountNumber(upi);
	            payment.setPaymentMethod(paymentMethod);
	            payment.setTotalAmount(totalPrice);
	            payment.setBook(booking);
	            payment.setPaymentStatus(paymentstatus);

	            paymentMapper.insertPayment(payment.getAccountNumber(), payment.getPaymentMethod(), payment.getTotalAmount(), payment.getBook(), payment.getPaymentStatus());
	        }
		
	}
}

