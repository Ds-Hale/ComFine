package com.comfine.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.comfine.javabean.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int row) throws SQLException {
		Order order=new Order();
		order.setUser_id(rs.getInt("user_id"));
		order.setContent_id(rs.getString("content_id"));
		order.setOrder_id(rs.getInt("order_id"));
		order.setIntroduce(rs.getString("introduce"));
		order.setOrdername(rs.getString("ordername"));
		order.setPrice(rs.getFloat("price"));
		order.setProgress(rs.getString("progress"));
		order.setServe_id(rs.getInt("serve_id"));;
		order.setUp_date(rs.getDate("up_date"));
		return order;
	}

}
