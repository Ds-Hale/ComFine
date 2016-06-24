<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>	
<script src="resources/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src ="resources/js/jquery.easing.1.3.js"></script>
<script src="resources/js/news_js/news_show.js"></script>
</head>

<style>
*{padding: 0px;}
body{
	background: #eee;
}
.header{position: relative;  margin-left:auto;margin-right:auto;width: 100%;height: 70px;background: black;}
.container{width: 70%;margin-left:auto;margin-right:auto;height: auto;background: white;position: relative;margin-top: 30px;}
.footer{width: 100%;margin-left:auto;margin-right:auto;height: 50px;background: gray;position: relative;margin-top: 30px;}
.img_show img{width: 100%;height: 300px;}
.container h1,p{margin: 30px 40px;}
.container h1{font-size: 50px;}
#click{text-align: center;}
.user_head{float: left;width: 40px;height:40px;border-radius: 50%;overflow: hidden;position: relative;margin-top: 20px;}
.up_name{float:left;text-align: center;margin-bottom: 20px;}
.user_head img{width: 60px;height: 60px;position: absolute;left:-10px;top:-15px;}

.up{
	float: left;
	width:100%;
	height: 70px;
	position:relative;
	font-family: "幼圆";
	    font-size: 20px;
}
.article{
	    line-height: 2em;
	    font-family: "幼圆";
	    font-size: 16px;
}
</style>

<body>
	<div class="header"></div>
	<div class="container">
		<div class="img_show">
			<img src="${news.getPath() }">
		</div>
		<h1 class="title">${news.getTitle()}<img src="resources/images/news_img/share.png"></h1>
		<div class="up">`
			<p class="up_name"><strong>UP：</strong>${news.getUp()}</p>
			<div class="user_head"><img src="resources/images/news_img/user_head.jpg"></div>
		</div>
		<p>${news.getDate()}</p>
		<br/>
			<p class="article">&nbsp;&nbsp;${news.getContent()}</p>
	</div>

	<div class="footer"></div>

</body>
</html>