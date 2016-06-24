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
<script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script>

<script type="text/javascript" src ="resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="resources/js/news_js/news.js"></script>
<script type="text/javascript">
$(function(){
	var i=0;

	var clone=$(".middle .img li").first().clone();
	$(".middle .img").append(clone);	
	var size = $(".middle .img li").size();
	for (var j = 0; j < size-1; j++) {
		$(".middle .num").append("<li></li>");
	}
	$(".middle .num li").first().addClass("on");
	$(".middle .num li").click(function(){
		$(this).addClass("on").siblings().removeClass("on");
		index = $(this).index();
		i=index;
		$(".middle .img").stop().animate({left:-index*860},{duration:1000,easing:"easeInOutBack"});
	});
		$(".top").hover(function(){
		$(this).find("span").stop().animate({left:0},{duration:1000,easing:"easeInOutBack"});
		clearInterval(t);
	
},function(){$(this).find("span").stop().animate({left:1000},{duration:1000,easing:"easeInOutBack"});
t=setInterval(function(){
		i++;
		move()
	},3000);
});



	/*向左的按钮*/
	$(".btn_l").click(function(){
		i++;
		move();
	});
	
	
	
	/*向右的按钮*/
	$(".btn_r").click(function(){
		i--;
		move();	
	});
 var t=setInterval(function(){
		i++;
		move()
	},3000);
	function move(){
		
		if(i==size){
			$(".middle .img").css({left:0})			
			i=1;
		}
		
		
		if(i==-1){
			$(".middle .img").css({left:-(size-1)*860})
			i=size-2;
		}
		
		$(".middle .img").stop().animate({left:-i*860},{duration:1000,easing:"easeInOutBack"})	
		
		if(i==size){
			$(".middle .num li").eq(0).addClass("on").siblings().removeClass("on")	
		}else{		
			$(".middle .num li").eq(i).addClass("on").siblings().removeClass("on")	
		}	
	}
	
	
});
//滑动
	

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
		
		<li ><div class="point"><a href="#">要闻&nbsp&nbsp</a></div></li>
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
	<div class="btn btn_l"><p>&lt;</p></div>
	<div class="middle">
		<ul class="img">
		<c:forEach  items="${message}" var="mesgmain" begin="0" end="3" >
		<li><a href="#"><div class="top"><span>${mesgmain.title}</br></<br></br></<br><p>${mesgmain.introduce}</p></span><img src="${mesgmain.path}"></div></a></li>
		</c:forEach>
    	<!-- <li><a href="#"><div class="top"><span></span><img src="resources/images/news_img/1.jpg"></div></a></li>
        <li><a href="#"><div class="top"><span></span><img src="resources/images/news_img/2.jpg"></div></a></li>
        <li><a href="#"><div class="top"><span></span><img src="resources/images/news_img/3.jpg"></div></a></li>
        <li><a href="#"><div class="top"><span></span><img src="resources/images/news_img/4.jpg"></div></a></li>
    -->
   
    </ul>
	<!-- <span class="top"></span> -->
    <ul class="num"></ul>
	</div>
     <div class="btn btn_r"><p>&gt;</p></div>

</div>
<c:forEach  items="${message}" var="mesg" begin="1" end="5" >
<div class="news_content">
	<div class="left"><a class="news_img" href="newsshow?news_id=${mesg.news_id}"><img src="${mesg.path}" ></a></div>
	<div class="right">
		<a href="newsshow?news_id=${mesg.news_id}"><h1>${mesg.title}</h1></a>	
		<p class="introduce">${mesg.introduce}</p><br/><br/><br/>
		<p class="up">${mesg.up}</p>
		<p class="date">${mesg.date}</p>
	</div>
</div>
</c:forEach>
</div>
</div>
<!--底部区域-->
<div class="get_more"><p>点击加载更多...</p></div>
<div class="footer">sdafasd</div>
</body>
</html>