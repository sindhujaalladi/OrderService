package com.orderservice.service;

import com.orderservice.common.TranscationRequest;
import com.orderservice.common.TranscationResponse;
import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;

public interface OrderService {
	
	TranscationResponse createorder(TranscationRequest orderrequest);
	
	OrdersRequest getorderdetails(int ordernum); 

}
