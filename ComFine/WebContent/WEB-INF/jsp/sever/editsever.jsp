<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="resources/css/news-css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="resources/css/news-css/news_fabu.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="resources/css/news-css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="resources/js/jquery-3.0.0.min.js"></script>
<script src="resources/js/side.js" type="text/javascript"></script>
<style type="text/css">
</style>
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<header>
<!-- Header -->
<div id="Header">
<!-- Head -->
<div id="Head">
<h1 class="title">惠家E站服务发布</h1>
<script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script>
<script language="javascript">
function showmenu(id){id.style.visibility = "visible";}
function hidmenu(){UserList.style.visibility = "hidden";}
function dele(e){
	var p = e.parentNode;
	p.parentNode.removeChild(p);
}
	$(function(){
		$("#sub").bind("click",function(){
			var els =document.getElementsByName("sorts_child");
			var s = "";
			for (var i = 0, j = els.length; i < j; i++){
				s=s+els[i].value+"&";
			}
			$("#sorts").val(s);
			$("form").submit();
		});
		$("#add").click(function(){
			var clone = $(".sever").first().clone();
			var add = $(".addbutton").first();
			var mes = clone.find("input");
			mes.val("");
			$(".sorts_div").append(clone);
			$(".sorts_div").append(add);
		});
	});

document.onclick = hidmenu;

 function preview(file)  
 {  
 var prevDiv = document.getElementById('#introduce'); 
 testValue=document.getElementById("preview").innerHTML; 
 if (file.files && file.files[0])  
 {  
 var reader = new FileReader();  
 reader.onload = function(evt){  
 prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
}    
 reader.readAsDataURL(file.files[0]);  
}  
 else    
 {  
 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
 }  
 }  
 </script>  




<div class="user"><a href="javascript:showmenu(UserList)">admin</a>
<div id="UserList"><a href="">修改</a>
<a href="">注销</a>
<a href="">退出</a></div>
</div>
</div>
<!-- /Head -->
<nav>
<ul id="Navi">
<li><a href=""><img src="resources/images/common/navi01.png" width="30" height="36" alt="主页管理"><span>主页管理</span></a></li>
<li><a href=""><img src="resources/images/common/navi02.png" width="36" height="36" alt="系统管理"><span>系统管理</span></a></li>
<li ><a href="severcontrol"><img src="resources/images/common/navi03.png" width="26" height="36" alt="服务管理"><span>服务管理</span></a></li>
<li class="active"><a href=""><img src="resources/images/common/navi04.png" width="34" height="36" alt="查看新闻"><span>查看服务</span></a></li>
<li><a href="/sever/severadd"><img src="resources/images/common/navi05.png" width="24" height="36" alt="添加服务"><span>添加服务</span></a></li>
<li><a href=""><img src="resources/images/common/navi06.png" width="36" height="36" alt="项目管理"><span>项目管理</span></a></li>
</ul>
</nav>

</div>
<!-- /Header -->
</header>

<div class="fabu">
	<form action="editsever_action" method="POST" enctype="multipart/form-data" class="bootstrap-frm">
	
<div ><h1>服务发布
<span>惠家E站服务发布</span>
</h1>
</div>
<label>
<span>服务名</span>
<input id="severcontent_name" type="text" name="severcontent_name" placeholder="服务标题" value="${severcontent.getSevercontent_name()}"/>
</label>
<label>
<span>服务种类</span>
	<select id="serve_id" name = "serve_id">
		<option value = "1" >洗衣</option>
		<option value = "2" >家教</option>
		<option value = "3" >IT维护</option>
		<option value = "4" >生活助理</option>
		<option value = "5" >积分兑换</option>
		<option value = "6" >有机蔬菜配送</option>
		<option value = "7" >票务服务</option>
		<option value = "8" >社区图书室</option>
	</select>
</label>
<label>
	<span>子服务:</span>
	<div class="sorts_div">
		 <c:forEach items="${sorts}" var="mesg"> 
			 <div class="sever"><input id="sorts_child" type="text" name="sorts_child" placeholder="服务分类"  value="${mesg}"/>
			 <span class="del-text" onclick="dele(this)">del</span>
			 </div>
		</c:forEach> 
		<div class="addbutton"><a id = "add" >点击添加一项</a></div>
		<input type="hidden" name="sorts" id = "sorts"/>
	</div>
	
</label>
<label>
<br/>
<span>价钱</span>
<input id="price" type="text" name="price" placeholder="价钱"  value="${severcontent.getPrice()}"/>
</label>
<label>
<span>联系方式</span>
<input id="tel" type="text" name="tel" placeholder="联系方式"  value="${severcontent.getTel()}"/>
</label>
<label>
<span>地址</span>
<input id="addr" type="text" name="addr" placeholder="联系方式" value="${severcontent.getAddr()}"/>
</label>
<label>
<span>服务介绍:</span>
<textarea id="introduce" name="introduce" placeholder="服务内容" > ${severcontent.getIntroduce()} </textarea>
<div id="preview"><img src="http://localhost:8080/ComFine/upload/3.png"></div>  
<input type="file" name = "imageFile"  onchange="preview(this)" />  
</label>
<label>
<input type="hidden" name="id" value="${severcontent.getId()}">
</label>

<label>
<span>&nbsp;</span>
<input type="button" class="button" value="Send" id="sub"/>
</label>

</form>

</div>
</body>
</html>