package com.comfine.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.News;
import com.comfine.jdbctemplate.NewsJdbcTemplate;
import com.comfine.util.ListToJson;


@Service
public class NewsService {
public NewsJdbcTemplate nJdbc = NewsJdbcTemplate.getNewsJdbcInstance();
public void UpFile(String uploadUrl,String filename,MultipartFile imageFile){
	
	File dir = new File(uploadUrl);
	if (!dir.exists()) {
		dir.mkdirs();
	}
	
	System.out.println("文件上传到: " + uploadUrl + filename);
	
	File targetFile = new File(uploadUrl + filename);
	if (!targetFile.exists()) {
		try {
			targetFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	try {
		imageFile.transferTo(targetFile);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}  
}
public boolean addNews(News news,String uploadUrl,String filename,MultipartFile imageFile){
	
	  //文件上传
	  UpFile(uploadUrl,filename,imageFile);
	
	
	 //新闻数据入库
	
		news.setPath("upload/"+filename);
		news.setUrl("upload/"+filename);	
		nJdbc.create(news);
		System.out.println(news.getContent());
	    return true;
}

public ModelAndView news_control() {
	List<News> news  = nJdbc.getAllNews();
	return new ModelAndView("/news/newshoutai","message",news);
}
public ModelAndView news_edit(int news_id) {
	News news = nJdbc.getNewsById(news_id);
	System.out.println(news.getTitle());
	return new ModelAndView ("news/editnews","news",news);
}
public String editNewsAction(News news,String uploadUrl,String filename,MultipartFile imageFile){
	if(!imageFile.isEmpty()){
	UpFile(uploadUrl, filename, imageFile);}
	nJdbc.updateNews(news);
	
return "newsuocontrol";
}
public void deleteNewsById(int id) {
	nJdbc.deleteNewsById(id);
	
}
public ModelAndView newsmain() {
	List<News> news  = nJdbc.getAllNews();
	return new ModelAndView("/news/news_main","message",news);
}
public String getMore(int i,int j) {
	List <News> newslist = nJdbc.getNewsRange(i, j);
	ListToJson<News> news = new ListToJson<News>(newslist);
	return news.getJson("news");
}
public ModelAndView newsshow(int news_id) {
	News news = nJdbc.getNewsById(news_id);
	return  new ModelAndView("news/news_show","news",news);
}

}