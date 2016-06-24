package com.comfine.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.Sever;
import com.comfine.service.SeverService;

@Controller
public class SeverController {
	@Resource
	HttpServletRequest request;
	@Resource
	SeverService sService;

//	@RequestMapping(value = "/sever", method = RequestMethod.GET)
//	public ModelAndView toSever() {
//		return new ModelAndView("/sever/sever");
//	}
	@RequestMapping(value = "/severhome", method = RequestMethod.GET)
	public String severhome() {
		return "sever/severhome";
	}

	@RequestMapping(value = "/addSever", method = RequestMethod.POST)
	public ModelAndView addSever(Sever sever) {
		
		return sService.addSever(sever);
	}
	
	@RequestMapping(value = "/sever", method = RequestMethod.GET)
	public ModelAndView display(){
		return sService.all_sever();
	}
	
	@RequestMapping (value = "/deleteSever" , method = RequestMethod.GET)
	public ModelAndView delete(){
		int id = Integer.parseInt(request.getParameter("serve_id"));
		System.out.println(id);
		return sService.delete(id);
	}
	
	@RequestMapping (value = "/updateSever" , method = RequestMethod.POST)
	public ModelAndView update(Sever sever){
		
		System.out.println(sever.getServertype());
		return sService.update(sever);
	}
}
