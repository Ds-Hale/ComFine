package com.comfine.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.Sever;
import com.comfine.jdbctemplate.SeverJdbcTemplate;

@Service
public class SeverService {

	public SeverJdbcTemplate sJdbc = SeverJdbcTemplate.getSeverJdbcInstance();
	
	public ModelAndView addSever(Sever sever){
		System.out.println(sever.getServername());
		sJdbc.create(sever);
		return new ModelAndView("/sever/sever");
	}
	
	public ModelAndView all_sever(){
		List<Sever>sever=sJdbc.getAllSever();
		return new ModelAndView("/sever/sever","message",sever);
	}
	public ModelAndView delete(int id){
		sJdbc.delete(id);
		return new ModelAndView("/sever/sever");
	}
	public ModelAndView update(Sever sever){
		sJdbc.update(sever);
		return new ModelAndView("/sever/sever");
	}
}
