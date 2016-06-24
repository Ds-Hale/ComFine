package com.comfine.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.comfine.javabean.Severcontent;
import com.comfine.jdbctemplate.SeverContentJdbcTemplate;
import com.comfine.util.ListToJson;

@Service
public class SeverContentService {
	public SeverContentJdbcTemplate scJdbc = SeverContentJdbcTemplate.getSevercontentJdbc();
	
	/*
	 * 图片上传函数
	 */
	public void UpFile(String uploadUrl, String filename, MultipartFile imageFile) {

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
	
	public boolean addSeverContent(Severcontent sc,String uploadUrl, String filename, MultipartFile imageFile){
		// 文件上传
		UpFile(uploadUrl, filename, imageFile);

		// 服务数据入库
		sc.setPic_path("severload/"+filename);
		sc.setUp_date(getDatetime().toString());
		scJdbc.insert(sc);
		System.out.println(sc.getSevercontent_name());
		return true;
	}
	public ModelAndView severcontent_edit(int id,ModelMap model){
		Severcontent sc = scJdbc.getContentById(id);
		List<String> sortsArray = splitString(sc.getSorts(),"&");
		model.addAttribute("severcontent",sc);
		model.addAttribute("sorts",sortsArray);
		return new ModelAndView("sever/editsever","model",model);
	}
	/*
	 * 列出二级服务内容
	 */
	public ModelAndView listSever(int serve_id){
		List<Severcontent> sContent = scJdbc.getServe_idContent(serve_id);
		ListToJson<Severcontent> list = new ListToJson<Severcontent>(sContent);
//		System.out.println(list.getJson("message"));
//		System.out.println(serve_id);
		return new ModelAndView("/sever/severcontent","message",sContent);
	}
	/*
	 * 列出三级内容
	 */
	public ModelAndView listContent(int id,ModelMap model){
		Severcontent sc = scJdbc.getContentById(id);
		List<String> list = splitString(sc.getSorts(),"&");
		List<String> introduce = splitString(sc.getIntroduce(),"&");

		model.addAttribute("message",sc);
		model.addAttribute("mes", list);
		model.addAttribute("introduce",introduce);
		return new ModelAndView("/sever/listcontent","model",model);
	}
	/*
	 * 管理服务页面,可以查看所有的服务
	 */
	public ModelAndView sever_control(){
		List<Severcontent> severcontent = scJdbc.getAllSeverContent();
		return new ModelAndView("/sever/severhoutai","message",severcontent);
	}
	/*
	 * 更新服务内容
	 */
	public boolean update(Severcontent sc, String severloadUrl, String filename, MultipartFile imageFile){
		if (!imageFile.isEmpty()) {
			UpFile(severloadUrl, filename, imageFile);
		}
		sc.setUp_date(getDatetime().toString());
		scJdbc.update(sc);
		return true;
	}
	/*
	 * 获取sorts分割并存入链表
	 */
	public List<String> splitString(String str, String cha){
		List<String> list = new ArrayList<String>();
		String []strArray = str.split(cha);
		for(int i=0;i<strArray.length;i++)
			list.add(strArray[i]);
		return list;
	}
	/*
	 * 获取系统时间 精确到毫秒
	 */
	public Timestamp getDatetime(){
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		return timeStamp;
	}
	/*
	 * 列出剩余的
	 */
	public String getmore(int start,int end,int id){
		List<Severcontent>sc = scJdbc.getmore(start, end, id);
		ListToJson<Severcontent> list = new ListToJson<Severcontent>(sc);
		
		return list.getJson("contents");
	}
}
