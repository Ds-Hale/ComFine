package com.comfine.dao;

import java.util.List;

import com.comfine.javabean.Order;

public interface OrderDao {
	public List<Order> getAllOrder();
	public Order getMyOrderById(int id);
	public void updateMyOrderById(int content_id,String sorts,float price);
	public void insertMyOrder(int id);
}
