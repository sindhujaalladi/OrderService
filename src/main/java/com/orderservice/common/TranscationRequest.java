package com.orderservice.common;

import java.io.Serializable;

import com.orderservice.pojo.OrdersRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TranscationRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrdersRequest ordreq;
	private PaymentRequest payreq;

}
