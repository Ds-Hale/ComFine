package com.comfine.jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.comfine.dao.SeverDao;
import com.comfine.javabean.Sever;
import com.comfine.mapper.SeverMapper;

public class SeverJdbcTemplate implements SeverDao {
	private  static DataSource dataSource;
	private static JdbcTemplate jdbcTemplataObject;
	public static SeverJdbcTemplate severJdbc = null;

	private SeverJdbcTemplate() {
	}

	static {
		severJdbc = new SeverJdbcTemplate();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		severJdbc = (SeverJdbcTemplate) context.getBean("severJdbcTemplate");
		jdbcTemplataObject = new JdbcTemplate(dataSource);
	}
	public static SeverJdbcTemplate getSeverJdbcInstance() {
		return severJdbc;

	}
	public  DataSource getDataSource() {
		return dataSource;
	}
	public  void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	
	@Override
	public List<Sever> getAllSever() {
		String sql = "SELECT * FROM tbl_sever";
		List<Sever> sever = jdbcTemplataObject.query(sql, new SeverMapper());
		return sever;
	}

	@Override
	public Sever getSeverById(int sever_id) {
		String sql="SELECT * FROM tbl_sever WHERE serve_id = ? ";
		Sever sever = jdbcTemplataObject.queryForObject(sql, new Object[] {sever_id},new SeverMapper());
		return sever;
	}
	@Override
	public void create(Sever sever) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tbl_sever(serve_id,servername,servertype,introduce) VALUES (?,?,?,?)";
		jdbcTemplataObject.update(sql,sever.getServe_id(),sever.getServername(),sever.getServertype(),sever.getIntroduce());
		System.out.println("success");
	}
	@Override
	public void delete(int serve_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_sever WHERE serve_id = ? ";
		jdbcTemplataObject.update(sql,serve_id);
	}
	@Override
	public void update(Sever sever) {
		String sql = "UPDATE tbl_sever SET servername = ? , servertype = ? , introduce = ? WHERE serve_id = ?";
		jdbcTemplataObject.update(sql,sever.getServername(),sever.getServertype(),sever.getIntroduce(),sever.getServe_id());
		System.out.println("update");
	}
	

}
