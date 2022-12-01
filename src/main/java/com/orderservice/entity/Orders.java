package com.orderservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Orders {
	
	@Id
	private int ordernum;
	
	@Column(name = "OrderDescription")
	private String orderdescription;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Price")
	private double price;

}
