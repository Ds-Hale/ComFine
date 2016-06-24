package com.comfine.jdbctemplate;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.comfine.dao.NewsDao;
import com.comfine.javabean.News;
import com.comfine.mapper.NewsMapper;
public class NewsJdbcTemplate implements NewsDao{
private static DataSource dataSource;
private static JdbcTemplate jdbcTemplataObject;
public static NewsJdbcTemplate newsJdbc = null;
private NewsJdbcTemplate(){}

//静态初始化   代码只需要粘贴复制   其余的配置文件搞定
static {
	newsJdbc = new NewsJdbcTemplate();
	@SuppressWarnings("resource")
	ApplicationContext context = new
			ClassPathXmlApplicationContext("Beans.xml");
		newsJdbc = (NewsJdbcTemplate) context.getBean("newsJdbcTemplate");
		jdbcTemplataObject = new JdbcTemplate(dataSource);	
}
public static NewsJdbcTemplate getNewsJdbcInstance(){
	return newsJdbc;	
}

@Override
public List<News> getAllNews() {
	String SQL = "SELECT * FROM tbl_news";
	List<News> news = jdbcTemplataObject.query(SQL, new NewsMapper());
	return news;
}
@Override
public void create(News news) {
	
	Date date=new Date(System.currentTimeMillis());

	String SQL = "INSERT INTO tbl_news (title,content,up,date,url,path) VALUES(?,?,?,?,?,?)";
	jdbcTemplataObject.update(SQL,news.getTitle(),
									news.getTitle(),
									news.getUp(),
									date,
									news.getUrl(),
									news.getPath()
									);
	System.out.println("success");
	
}
public DataSource getDataSource() {
	return dataSource;
}
public void  setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
@Override
public News getNewsById(int news_id) {
	String SQL = "SELECT * FROM tbl_news WHERE news_id=?";
	News news = jdbcTemplataObject.queryForObject(SQL, new Object[]{news_id},new NewsMapper());
	return news;
}
@Override
public void updateNews(News news) {
	Date date = new Date(System.currentTimeMillis());
	news.setPath("1111");
	news.setUrl("111111");
	String SQL = "UPDATE tbl_news SET title=?,content=?,up=?,date=?,url=?,path=? WHERE news_id=?";
	String sql1="UPDATE tbl_news SET title = 'ccccccc' WHERE news_id = 10006";
	jdbcTemplataObject.update(SQL, news.getTitle(),
									news.getContent(),
									news.getUp(),
									date,
									news.getUrl(),
									news.getPath(),
									news.getNews_id());
	
	
	System.out.println(news.getTitle()+"  "+news.getNews_id());
	
}

@Override
public void deleteNewsById(int id) {
	String SQL = "DELETE FROM tbl_news WHERE news_id = ?";
	jdbcTemplataObject.update(SQL,id);
	
}

@Override
public List<News> getNewsRange(int i, int j) {
	String SQL = "SELECT * FROM tbl_news LIMIT ?,?";
	List<News> news = jdbcTemplataObject.query(SQL, new Object[]{i,j}, new NewsMapper());
	News.setCount(news.size());
	return news;
}

@Override
public int getCount() {
	return 0;
	
}

}
