package com.comfine.dao;

import java.util.List;

import com.comfine.javabean.Severcontent;

public interface SeverContentDao {
	public List<Severcontent> getAllSeverContent();
	public List<Severcontent> getServe_idContent(int serve_id);
	public Severcontent getContentById(int id);
	public void delete(int id);
	public void insert(Severcontent severcontent);
	public void update(Severcontent severcontent);
	public  List<Severcontent> getContent(List<String> list);
}
