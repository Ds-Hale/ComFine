package com.comfine.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.service.MyOrderService;

@Controller
public class OrderController {
@Resource
MyOrderService oService;
@Resource
HttpServletRequest request;

@RequestMapping(value="myorder",method=RequestMethod.GET)
public ModelAndView myorder(ModelMap model){
	int id = Integer.parseInt(request.getParameter("order_id"));
	System.out.println(id);
	return oService.myorder(id,model);

}
}
