package com.comfine.dao;
import java.util.List;

import com.comfine.javabean.News;
public interface NewsDao {
	public List<News> getAllNews();
	public List<News> getNewsRange(int i,int j);
	public void create(News news);
	public News getNewsById(int news_id);
	public void updateNews(News news);
	public void deleteNewsById(int id);
	public int getCount();
}
