package com.orderservice.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int paymentid;
	private String payeename;
	private double paymentamount;
	private String paymentLocation;
	private String isCheck;
	private String isCash;
	
	//for assocoation of mapping fields
	private int ordernum;
	private String orderdescription;	
	private String Status;

}
