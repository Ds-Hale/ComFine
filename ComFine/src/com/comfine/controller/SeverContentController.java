package com.comfine.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.Severcontent;
import com.comfine.javabean.test;
import com.comfine.service.SeverContentService;

@Controller
public class SeverContentController {
	@Resource
	HttpServletRequest request;
	@Resource
	SeverContentService scService;
	@Resource
	HttpServletResponse response;

	/*
	 * 查找当前服务的二级列表
	 */
	@RequestMapping(value = "/listsever", method = RequestMethod.GET)
	public ModelAndView listContent() {
		int serve_id = Integer.parseInt(request.getParameter("serve_id"));
		System.out.println("商品列表显示");
//		return "/sever/severcontent";
		return scService.listSever(serve_id);
	}
	/*
	 * 查找三级内容
	 */
	@RequestMapping	(value = "/listcontent" , method = RequestMethod.GET)
	public ModelAndView list(ModelMap model){
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("商品内容显示");
		return scService.listContent(id,model);
	}
	/*
	 * 后台管理,查询所有的订单
	 */
	@RequestMapping (value = "/severcontrol" , method = RequestMethod.GET)
	public ModelAndView severControl(){
		return scService.sever_control();
	}
	/*
	 * 修改一个服务内容
	 */
	@RequestMapping (value = "/editsever" , method = RequestMethod.GET)
	public ModelAndView editsever(ModelMap model){
		int id = Integer.parseInt( request.getParameter("id"));
		System.out.println(id);
		return scService.severcontent_edit(id, model);
	}
	
	/*
	 * 修改一个服务内容
	 */
	@RequestMapping(value = "/editsever_action", method = RequestMethod.POST)
	public ModelAndView editSeverAction(Severcontent sc,@RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) {
		response.setContentType("application/json;charset=utf-8");
		String severloadUrl = request.getSession().getServletContext().getRealPath("/") + "severload/";
		String filename = imageFile.getOriginalFilename();
		System.out.println(sc.getId());
		System.out.println(sc.getSorts());
		System.out.println(request.getParameter("price"));
		scService.update(sc, severloadUrl, filename, imageFile);
		
		return severControl();
	}
	/*
	 * 添加服务展示
	 */
	@RequestMapping(value = "/addsever_action", method = RequestMethod.GET)
	public String addseverPage(){
		return "sever/severadd";
	}
	/*
	 * 增加一个服务内容
	 */
	@RequestMapping(value = "/addsever", method = RequestMethod.POST)
	public ModelAndView addsever(Severcontent sc,@RequestParam("imageFile") MultipartFile imageFile,
			HttpServletRequest request) {
		response.setContentType("application/json;charset=utf-8");
		String severloadUrl = request.getSession().getServletContext().getRealPath("/") + "severload/";
		String filename = imageFile.getOriginalFilename();
		scService.addSeverContent(sc, severloadUrl, filename, imageFile);

		return severControl();
	}
	
	@RequestMapping(value = "/listgetmore", method = RequestMethod.POST)
	public String getmorelist(HttpServletResponse rs){
		int start = Integer.parseInt(request.getParameter("start"));
		System.out.println("con"+start);
		int serve_id = Integer.parseInt(request.getParameter("serve_id"));
		try {
			rs.setContentType("application/json;charset=UTF-8");
			PrintWriter out = rs.getWriter();	
			out.print(scService.getmore(start, start,serve_id));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
