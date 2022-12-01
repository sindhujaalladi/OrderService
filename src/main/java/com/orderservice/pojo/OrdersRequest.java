package com.orderservice.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ordernum;
	private String orderdescription;
	private int quantity;
	private double price;

}
