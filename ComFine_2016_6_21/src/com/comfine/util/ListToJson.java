package com.comfine.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONObject;

public class  ListToJson<T> {
private List<T> list;
private List<T> arraylist = new ArrayList<T>();

public ListToJson(List<T> list){
	this.list = list;	
	this.ListToArryList();
}

public void ListToArryList(){   //经过测试发现需要将List转化为ArrayList 我也不知道具体原因
	Iterator<T> itera = list.iterator();
	while (itera.hasNext()){
		arraylist.add(itera.next());	
	}
}
/*
 * @name json的key
 * @return json转化为字符串
 * */
public String getJson(String name){
	JSONObject json = new JSONObject();
	json.put(name,arraylist);
	return json.toString();
}
}
