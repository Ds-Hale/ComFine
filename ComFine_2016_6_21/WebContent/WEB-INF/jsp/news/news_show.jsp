<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	
</head>
<style>
*{padding: 0px;}
body{
	background: #eee;
}
.header{position: relative;margin-left:auto;margin-right:auto;width: 70%;height: 70px;background: black;}
.container{width: 70%;margin-left:auto;margin-right:auto;height: auto;background: white;position: relative;margin-top: 30px;}
.footer{width: 70%;margin-left:auto;margin-right:auto;height: 50px;background: gray;position: relative;margin-top: 30px;}
.img_show img{width: 100%;height: 300px;}
.container h1,p{margin: 30px 40px;}
#click{text-align: center;}
.user_head{float: left;width: 50px;height:50px;border-radius: 50%;overflow: hidden;position: relative;}
.up_name{float:left}
.user_head img{width: 90px;height: 90px;position: absolute;left:-20px;top:-15px;}

.up{
	float: left;
	width:100%;
	height: auto;
	position:relative;
}
</style>
<body>
	<div class="header"></div>
	<div class="container">
		<div class="img_show">
			<img src="resources/images/news_img/1.jpg">
		</div>
		<h1>${news.title}</h1>
		<div class="up">
			<p class="up_name"><strong>UP：</strong>${news.up}</p>
			<div class="user_head"><img src="resources/images/news_img/user_head.jpg"></div>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
			<p>&nbsp;&nbsp;${news.content}</p>
		
	</div>
	<div class="footer"></div>

</body>
</html>