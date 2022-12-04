package com.orderservice.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;


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
