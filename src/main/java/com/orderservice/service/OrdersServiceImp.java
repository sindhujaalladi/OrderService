package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.entity.Orders;
import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;
import com.orderservice.repository.OrderRepository;

import jakarta.transaction.Transactional;


@Service
public class OrdersServiceImp implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository; 

	@Transactional
	@Override
	public OrdersResponse createorder(OrdersRequest orderrequest) {
		OrdersResponse ordres = new OrdersResponse();
		Orders orders =  Orders.builder()
				.ordernum(orderrequest.getOrdernum())
				.orderdescription(orderrequest.getOrderdescription())
				.quantity(orderrequest.getQuantity())
				.price(orderrequest.getPrice()).build();
		orderRepository.save(orders);
		ordres.setMessage("order has been placed successfully");
		return ordres;
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
