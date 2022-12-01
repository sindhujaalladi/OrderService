package com.orderservice.service;

import com.orderservice.pojo.OrdersRequest;
import com.orderservice.pojo.OrdersResponse;

public interface OrderService {
	
	OrdersResponse createorder(OrdersRequest orderrequest);
	
	OrdersRequest getorderdetails(int ordernum); 

}
