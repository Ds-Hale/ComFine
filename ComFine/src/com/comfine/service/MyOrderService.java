package com.comfine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.Order;
import com.comfine.javabean.Severcontent;
import com.comfine.jdbctemplate.OrderJdbcTemplate;
import com.comfine.jdbctemplate.SeverContentJdbcTemplate;




@Service
public class MyOrderService {
	OrderJdbcTemplate oJdbc = OrderJdbcTemplate.getOrderInstance();
	public ModelAndView myorder(int id,ModelMap model) {
		Order order = oJdbc.getMyOrderById(id);
		
		String Content = order.getContent_id();
		String[] contentid= Content.split("&");
		List<String> contentList = new ArrayList<String>();
		List<String> contentIntroduce = new ArrayList<String>();
		for (int i = 0; i < contentid.length; i++) {
			String[] eachContent = contentid[i].split("#");
			contentList.add(eachContent[0]);
			contentIntroduce.add(eachContent[1]);
		}
		System.out.println(contentList);
		System.out.println(contentIntroduce);
		SeverContentJdbcTemplate scJdbc = SeverContentJdbcTemplate.getSevercontentJdbc();		
		List<Severcontent> contents = scJdbc.getContent(contentList);
		System.out.println(contents);
		model.put("content", contents);//特定服务列表
		model.put("type", contentIntroduce);//特定服务类型
		return new ModelAndView ("order/myorder","model",model);
	}

}
