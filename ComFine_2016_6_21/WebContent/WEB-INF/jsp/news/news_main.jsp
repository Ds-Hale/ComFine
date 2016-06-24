<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="resources/css/news-css/news_main.css"/>
</head>
<body>
<script type="text/javascript" src="resources/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src ="resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src ="resources/js/news_js/news.js"></script>
<script type="text/javascript">
$(function(){
	var clone=$(".middle .img li").first().clone();
	$(".middle .img").append(clone);	
	var size = $(".middle .img li").size();
	for (var i = 0; i < size; i++) {
		$(".middle .num").append("<li></li>");
	}
	$(".middle .num li").first().addClass("on");
	$(".middle .num li").click(function(){
		$(this).addClass("on").siblings().removeClass("on");
		var index = $(this).index();
		$(".middle .img").stop().animate({left:-index*860},{duration:1000,easing:"easeInOutBack"});
	});

	
});


</script>
<!-- 头部区域-->
<div class="header">
	<div class="header_top"></div>
	<div class="header_line"></div>
	<div class="header_bottom">
		<ul>
			<li><div class="title_box b1"></div></li>
			<li><div class="title_box b2"></div></li>
			<li><div class="title_box b3"></div></li>
			<li><div class="title_box b4"></div></li>
			<li><div class="title_box b5"></div></li>
		</ul>

	</div>
	<!-- <div class="btn btn_l"></div>
	<div class="pro"></div>
	<div class="btn btn_r"></div> -->

</div>
<div class="news">
<!--左侧新闻选择区域-->
<div class="news_title">
<p style="font-size:120px; color:white;">新闻</p>
	<ul>
		
		<li ><div class="point"><a href="#">要闻 &nbsp &nbsp</a></div></li>
		<li class="point"><div class="point"><a href="#">热点&nbsp&nbsp</a></div></li>
		<li class="point"><div class="point"><a href="#">社区新闻</a></div></li>
		<li class="point"><div class="point"><a href="#">其他新闻</a></div></li>
	</ul>
</div>

<!--新闻展示区域-->
<div class="news_show">
	<!--新闻速报-->
<!-- <p class="news_quick">新闻速报|江南最大皮革厂倒闭了</p> -->

	
	<!--新闻内容-->
<div class="news_content lunbo">
	<div class="btn btn_l">&lt;</div>
	<div class="middle">
		<ul class="img">
    	<li><a href="#"><div style="background:black"><img src="resources/images/news_img/2.jpg"></a></div></li>
        <li><a href="#"><img src="resources/images/news_img/2.jpg"></a></li>
        <li><a href="#"><img src="resources/images/news_img/3.jpg"></a></li>
        <li><a href="#"><img src="resources/images/news_img/4.jpg"></a></li>
    </ul>
	<span class="top"></span>
    <ul class="num"></ul>
	</div>
     <div class="btn btn_r">&lt;</div>

</div>

<c:forEach items="${message}" var="mesg" begin="1" end="5">
<div class="news_content">
	<div class="left"><a class="news_img" href="#"><img src="resources/images/news_img/jnpgc.jpg" ></a></div>
	<div class="right">
		<a> <h1> ${mesg.title} </h1></a>
		<br/><br/><br/>
		<p class="up">${mesg.up}</p>
		<p class="date">${mesg.date}</p>
	</div>
	</div>
</c:forEach>





</div>
</div>
<!--底部区域-->
<div class="get_more">加载跟多</div>

<div class="footer">sdafasd</div>
</body>
</html>