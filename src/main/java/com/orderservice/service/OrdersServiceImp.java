package com.orderservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.common.PaymentRequest;
import com.orderservice.common.PaymentResponse;
import com.orderservice.common.TranscationRequest;
import com.orderservice.common.TranscationResponse;
import com.orderservice.entity.Orders;
import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;
import com.orderservice.repository.OrderRepository;

import jakarta.transaction.Transactional;


@Service
public class OrdersServiceImp implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository; 
	
	@Autowired
	private RestTemplate resttemplate;

	@Transactional
	@Override
	public TranscationResponse createorder(TranscationRequest transcationRequest) {
		String response;
		OrdersResponse ordres = new OrdersResponse();
		Orders ord = Orders.builder()
				.ordernum(transcationRequest.getOrdreq().getOrdernum())
				.orderdescription(transcationRequest.getOrdreq().getOrderdescription())
				.quantity(transcationRequest.getOrdreq().getQuantity())
				.price(transcationRequest.getOrdreq().getPrice()).build();
		orderRepository.save(ord);
		PaymentRequest payobj = transcationRequest.getPayreq();
		payobj.setOrdernum(transcationRequest.getOrdreq().getOrdernum());
		payobj.setOrderdescription(transcationRequest.getOrdreq().getOrderdescription());
		ResponseEntity<PaymentRequest> payres = resttemplate.postForEntity("http://localhost:8082/api/payment/createPayment", payobj, PaymentRequest.class);
		response = payres.getBody().getStatus().equalsIgnoreCase("SUCCESS")?"Order placed successfully":"payment failed order added to cart";
		ordres.setMessage("order has been placed successfully");
		return new TranscationResponse(transcationRequest.getOrdreq().getOrdernum(),payres.getBody().getPaymentamount(),response,UUID.randomUUID().toString());
	}

	@Override
	public OrdersRequest getorderdetails(int ordernum) {
		Orders order = orderRepository.findByOrdernum(ordernum);
		OrdersRequest ordreq = OrdersRequest.builder()
				.ordernum(order.getOrdernum())
				.orderdescription(order.getOrderdescription())
				.quantity(order.getQuantity())
				.price(order.getPrice()).build();
		return ordreq;
	}

	

}
