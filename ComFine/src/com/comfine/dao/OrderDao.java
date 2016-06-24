package com.comfine.dao;

import java.util.List;

import com.comfine.javabean.Order;

public interface OrderDao {
public Order getMyOrderById(int id);
public void updateMyOrderById(int id);
public void insertMyOrder(int id);
}
