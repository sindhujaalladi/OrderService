package com.orderservice.repository;

import org.springframework.stereotype.Repository;

import com.orderservice.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
	
	Orders findByOrdernum(int ordernum);

}
