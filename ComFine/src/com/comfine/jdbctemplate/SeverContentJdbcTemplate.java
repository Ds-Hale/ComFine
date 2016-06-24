package com.comfine.jdbctemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.comfine.dao.SeverContentDao;
import com.comfine.javabean.Severcontent;
import com.comfine.mapper.SeverContentMapper;

public class SeverContentJdbcTemplate implements SeverContentDao {

	private static DataSource dataSource;
	private static JdbcTemplate jdbcTemplataObject;
	private static SeverContentJdbcTemplate severcontentJdbc = null;

	private SeverContentJdbcTemplate() {
	}

	static {
		severcontentJdbc = new SeverContentJdbcTemplate();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		severcontentJdbc = (SeverContentJdbcTemplate) context.getBean("severcontentJdbcTemplate");
		jdbcTemplataObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Severcontent> getAllSeverContent() {
		String sql = "SELECT * FROM tbl_severcontent";
		List<Severcontent> Severcontent = jdbcTemplataObject.query(sql, new SeverContentMapper());
		return Severcontent;
	}
	@Override
	public List<Severcontent> getServe_idContent(int serve_id) {
		String sql = "SELECT * FROM tbl_severcontent WHERE serve_id = ?";
		List<Severcontent> severcontent = jdbcTemplataObject.query(sql, new Object[]{serve_id}, new SeverContentMapper());
		return severcontent;
	}
	@Override
	public Severcontent getContentById(int id) {
		String sql = "SELECT * FROM tbl_severcontent WHERE id = ? ";
		Severcontent severcontent = jdbcTemplataObject.queryForObject(sql, new Object[] { id },
				new SeverContentMapper());
		return severcontent;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM tbl_severcontent WHERE id = ? ";
		jdbcTemplataObject.update(sql, id);

	}

	@Override
	public void insert(Severcontent severcontent) {
		String sql = "INSERT INTO tbl_severcontent (serve_id,severcontent_name,introduce,price,up_date,sorts,pic_path,tel,addr)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplataObject.update(sql, severcontent.getServe_id(), severcontent.getSevercontent_name(),
				severcontent.getIntroduce(), severcontent.getPrice(), severcontent.getUp_date(),
				severcontent.getSorts(), severcontent.getPic_path(), severcontent.getTel(), severcontent.getAddr());
	}

	@Override
	public void update(Severcontent severcontent) {
		String sql = "UPDATE tbl_severcontent SET serve_id = ? , severcontent_name = ? ,introduce = ? ,price = ? ,up_date = ? ,sorts = ? ,pic_path = ? ,tel = ? ,addr = ? WHERE id = ?";
		jdbcTemplataObject.update(sql, severcontent.getServe_id(), severcontent.getSevercontent_name(),
				severcontent.getIntroduce(), severcontent.getPrice(), severcontent.getUp_date(),
				severcontent.getSorts(), severcontent.getPic_path(), severcontent.getTel(), severcontent.getAddr(),severcontent.getId());
	}


	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		SeverContentJdbcTemplate.dataSource = dataSource;
	}

	public static JdbcTemplate getJdbcTemplataObject() {
		return jdbcTemplataObject;
	}

	public static void setJdbcTemplataObject(JdbcTemplate jdbcTemplataObject) {
		SeverContentJdbcTemplate.jdbcTemplataObject = jdbcTemplataObject;
	}

	public static SeverContentJdbcTemplate getSevercontentJdbc() {
		return severcontentJdbc;
	}

	public static void setSevercontentJdbc(SeverContentJdbcTemplate severcontentJdbc) {
		SeverContentJdbcTemplate.severcontentJdbc = severcontentJdbc;
	}
	


}
