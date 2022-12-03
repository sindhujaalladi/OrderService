package com.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.common.TranscationRequest;
import com.orderservice.common.TranscationResponse;
import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;
import com.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orderservice")
public class OrderServiceController {
	
	
	@Autowired
	private OrderService orderservice;
	
	
	@PostMapping("/placeorder")
	public ResponseEntity<TranscationResponse> createorder(@RequestBody TranscationRequest transcationRequest) {
		TranscationResponse ordresponse = this.orderservice.createorder(transcationRequest);
		return new ResponseEntity<>(ordresponse,HttpStatus.CREATED);
	}
	
	@GetMapping("/{ordernum}")
	public ResponseEntity<OrdersRequest> getorderdetails(@PathVariable int ordernum){
		OrdersRequest req = this.orderservice.getorderdetails(ordernum);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}

}
