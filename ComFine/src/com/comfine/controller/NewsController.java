package com.comfine.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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

import com.comfine.javabean.News;
import com.comfine.jdbctemplate.NewsJdbcTemplate;
import com.comfine.service.NewsService;
import com.comfine.util.ListToJson;
@Controller
public class NewsController {
@Resource
HttpServletRequest request;
@Resource
HttpServletResponse response;
@Resource
NewsService nService;

/*新闻前台的controller*/
@RequestMapping(value="/news",method = RequestMethod.GET)
public ModelAndView newsmain(){
//	Cookie cookie = new Cookie("hello","hehe");
//	cookie.setPath("/");
//	response.addCookie(cookie);
	return nService.newsmain();
	
}
@RequestMapping(value="/newsshow",method = RequestMethod.GET)
public ModelAndView newsshow(){
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	return nService.newsshow(news_id);
}
@RequestMapping(value="/newspage",method = RequestMethod.GET)
public ModelAndView newsshowbypage(ModelMap model){
	int page = Integer.parseInt(request.getParameter("page"));
	return nService.newspage(page, model);
}


@RequestMapping(value="/getmore.action",method=RequestMethod.GET)
@ResponseBody public String getmore(HttpServletResponse response){
int i = Integer.parseInt(request.getParameter("start"));
int j =  Integer.parseInt(request.getParameter("end"));
response.setContentType("text/json;charset=UTF-8");
try {
	response.getWriter().print(nService.getMore(i, j));
} catch (IOException e) {
	e.printStackTrace();
}

return null;
}

/*新闻后台的controller*/

//添加新闻操作
	@RequestMapping(value="/addnews",method = RequestMethod.POST)
	public String oneUpload(News news,@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request){
	
		String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String filename = imageFile.getOriginalFilename();
		nService.addNews(news,uploadUrl,filename,imageFile);
		System.out.println(news.getContent());
		String url = "http://localhost:8080/ComFine/upload/"+filename;
			return "redirect:"+url;
    }  

//添加新闻的界面展示
@RequestMapping(value="/newsupdate.do",method =RequestMethod.GET )
public String newsUpdate(){
	System.out.println("ddd");
	return "news/newsupdate";
	
}	

//新闻后台管理控制（每个页面展示x条）
@RequestMapping(value="/newscontrol",method =RequestMethod.GET )
public ModelAndView newsControl(ModelMap model){	
	return nService.news_control(model);
}

//得到用户列表
@RequestMapping(value="/newsupcontrolajax",method =RequestMethod.GET )
@ResponseBody
public  String getUserList() {  
NewsJdbcTemplate nJdbc = NewsJdbcTemplate.getNewsJdbcInstance();
List<News> news =nJdbc.getNewsRange(1, 2);
ListToJson<News> newsJson = new ListToJson<News>(news);
String s= newsJson.getJson("news");
System.out.println(s);
return s;
}

//新闻修改界面展示
@RequestMapping(value="/editnews",method=RequestMethod.GET )
public ModelAndView editNews(){
	int id =Integer.parseInt(request.getParameter("news_id"));
	System.out.println(id);
	return nService.news_edit(id);
}

//新闻修改更新操作
@RequestMapping(value="/editnews.action",method=RequestMethod.POST )
public ModelAndView editNewsAction(News news,@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request){
	response.setContentType("application/json;charset=utf-8");
	String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";
	String filename = imageFile.getOriginalFilename();
	nService.editNewsAction(news, uploadUrl, filename, imageFile);
	return null;
}
@RequestMapping(value="/deletenews.action",method=RequestMethod.POST)
public String deleteNews(){
	int id = Integer.parseInt(request.getParameter("id"));
	System.out.println(id);
	nService.deleteNewsById(id);
	return null;
		
}

}
	

