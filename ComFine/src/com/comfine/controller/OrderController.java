package com.comfine.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comfine.service.OrderService;

@Controller
public class OrderController {
	@Resource
	HttpServletRequest request;
	@Resource
	OrderService oService;
	
	@RequestMapping(value="/placeorder", method = RequestMethod.POST)
	public String placeorder (int content_id,String sorts,float price){
		return oService.placeorder(content_id,sorts, price);
	}

	@RequestMapping(value="myorder",method=RequestMethod.GET)
public ModelAndView myorder(ModelMap model){
	int id = Integer.parseInt(request.getParameter("order_id"));
	System.out.println(id);
	return oService.myorder(id,model);

}
}
