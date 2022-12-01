package com.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;
import com.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orderservice")
public class OrderServiceController {
	
	
	@Autowired
	private OrderService orderservice;
	
	
	@PostMapping("/placeorder")
	public ResponseEntity<OrdersResponse> createorder(@RequestBody OrdersRequest ordersrequest) {
		OrdersResponse ordresponse = this.orderservice.createorder(ordersrequest);
		return new ResponseEntity<>(ordresponse,HttpStatus.CREATED);

		
	}

}
