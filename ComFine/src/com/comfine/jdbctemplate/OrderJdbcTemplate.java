package com.comfine.jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.comfine.dao.OrderDao;
import com.comfine.javabean.Order;

public class OrderJdbcTemplate implements OrderDao {
	
	private static DataSource dataSource;
	private static JdbcTemplate jdbcTemplataObject;
	private static OrderJdbcTemplate orderJdbcTemplate = null;
	
	private OrderJdbcTemplate() {
	}
	
	static {
		orderJdbcTemplate = new OrderJdbcTemplate();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		orderJdbcTemplate = (OrderJdbcTemplate)context.getBean("orderJdbcTemplate");
		jdbcTemplataObject = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getMyOrderById(int id) {
		String SQL = "SELECT * FROM tbl_order WHERE order_id = ?";
		Order order =jdbcTemplataObject.queryForObject(SQL, new Object[]{id},new OrderMapper());
		return order;
	}


	@Override
	public void updateMyOrderById(int content_id,String sorts,float price) {
		String str = "&"+content_id+"#"+ sorts;
		String sql = "UPDATE tbl_order SET content_id = CONCAT ( content_id , ? ) , price = price + ? ";
		jdbcTemplataObject.update (sql , str,price);
	}

	@Override
	public void insertMyOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		OrderJdbcTemplate.dataSource = dataSource;
	}

	public static JdbcTemplate getJdbcTemplataObject() {
		return jdbcTemplataObject;
	}

	public static void setJdbcTemplataObject(JdbcTemplate jdbcTemplataObject) {
		OrderJdbcTemplate.jdbcTemplataObject = jdbcTemplataObject;
	}

	public static OrderJdbcTemplate getOrderJdbcTemplate() {
		return orderJdbcTemplate;
	}

	public static void setOrderJdbcTemplate(OrderJdbcTemplate orderJdbcTemplate) {
		OrderJdbcTemplate.orderJdbcTemplate = orderJdbcTemplate;
	}

}
