package com.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TranscationResponse {
	private int ordernum;
	private double paymentamount;
	private String message;
	private String transcationid;

}
