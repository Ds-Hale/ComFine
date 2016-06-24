package com.comfine.jdbctemplate;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.comfine.dao.OrderDao;
import com.comfine.javabean.Order;
import com.comfine.mapper.NewsMapper;
import com.comfine.mapper.OrderMapper;


public class OrderJdbcTemplate implements OrderDao {
	private static DataSource dataSource;
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		OrderJdbcTemplate.dataSource = dataSource;
	}

	private static JdbcTemplate jdbcTemplataObject;
	private static OrderJdbcTemplate orderJdbcTemplate = null;
	
	private OrderJdbcTemplate() {}
	
	static {
		orderJdbcTemplate = new OrderJdbcTemplate();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		orderJdbcTemplate = (OrderJdbcTemplate)context.getBean("orderJdbcTemplate");
		jdbcTemplataObject = new JdbcTemplate(dataSource);
	}
 public static OrderJdbcTemplate getOrderInstance(){
	 return orderJdbcTemplate;
 }
	@Override
	public Order getMyOrderById(int id) {
		String SQL = "SELECT * FROM tbl_order WHERE order_id = ?";
		Order order =jdbcTemplataObject.queryForObject(SQL, new Object[]{id},new OrderMapper());
		return order;
	}

	@Override
	public void updateMyOrderById(int id) {
		
	}

	@Override
	public void insertMyOrder(int id) {

	}

}
