package com.comfine.service;

import org.springframework.stereotype.Service;

import com.comfine.jdbctemplate.OrderJdbcTemplate;

@Service
public class OrderService {
	OrderJdbcTemplate oJdbc = OrderJdbcTemplate.getOrderJdbcTemplate();
	
	public String placeorder(int content_id ,String sorts,float price){
		oJdbc.updateMyOrderById(content_id, sorts,price);
		return "/sever";
	}
}
