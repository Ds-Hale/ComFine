<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>惠家服务</title>
<link rel="stylesheet" type="text/css" href="resources/css/sever-css/style.css" />
</head>

<body>

	<script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript">
		$(function() {
			var clone = $(".middle .img li").first().clone();
			$(".middle .img").append(clone);
			var size = $(".middle .img li").size();
			for (var i = 0; i < size; i++) {
				$(".middle .num").append("<li></li>");
			}
			$(".middle .num li").first().addClass("on");
			$(".middle .num li").click(function() {
				$(this).addClass("on").siblings().removeClass("on");
				var index = $(this).index();
				$(".middle .img").stop().animate({
					left : -index * 860
				}, {
					duration : 1000,
					easing : "easeInOutBack"
				});
			});

		});
	</script>
	<!-- 头部区域-->
	<div class="header">
		<div class="header_top"></div>
		<div class="header_line"></div>
		<div class="header_bottom">
			<ul class="title">
				<li>
					<div class="title_box b1"></div>
				</li>
				<li>
					<div class="title_box b2"></div>
				</li>
				<li>
					<div class="title_box b3"></div>
				</li>
				<li>
					<div class="title_box b4"></div>
				</li>
				<li>
					<div class="title_box b5"></div>
				</li>
			</ul>
		</div>
	</div>

	<div class="bkground">
		<!--图片-->
		<div class="news_content">
			<div class="btn btn_l"></div>
			<div class="middle">
				<ul class="img">
					<li><a href="#">
							<div style="background: black">
								<img src="resources/images/sever/1.jpg">
							</div>
					</a></li>
					<li><a href="#"><img src="resources/images/sever/2.jpg"></a></li>
					<li><a href="#"><img src="resources/images/sever/3.jpg"></a></li>
					<li><a href="#"><img src="resources/images/sever/4.jpg"></a></li>
				</ul>
				<span class="top"></span>
				<ul class="num"></ul>
			</div>
			<div class="btn btn_r"></div>
		</div>

		<!--服务-->
		<div class="serverlist">
			<div class="ser1">
				<a href="listsever?serve_id=1"><img src="resources/images/sever/2.jpg"></a> <span
					class="top"><a href=""><p></p></a> </span>
			</div>
			<div class="ser2">
				<a href="listsever?serve_id=2"><img src="resources/images/sever/2.jpg"></a>
			</div>
			<div class="ser3">
				<a href="listsever?serve_id=3"><img src="resources/images/sever/2.jpg"></a>
			</div>
			<div class="ser4">
				<a href="listsever?serve_id=4"><img src="resources/images/sever/2.jpg" style="margin-top: 10%"></a>
			</div>

			<div class="ser1" style="float: right">
				<a href="listsever?serve_id=5"><img src="resources/images/sever/2.jpg"></a>
			</div>
			<div class="ser4" style="float: right">
				<a href="listsever?serve_id=6"><img src="resources/images/sever/2.jpg" style="margin-top: 10%"></a>
			</div>
			<div class="ser2" style="float: right">
				<a href="listsever?serve_id=7"><img src="resources/images/sever/2.jpg"></a>
			</div>
			<div class="ser3" style="float: right">
				<a href="listsever?serve_id=8"><img src="resources/images/sever/2.jpg"></a>
			</div>
		</div>

	</div>
	<div class="footer">
		<div class="footer_col1">
			<img src="" />
		</div>
		<div class="footer_col2">
			<p>asdjflkjsadlkjflkflsajdlgjaslkjagdsg</p>
		</div>
		<div class="footer_col3"></div>
		<div class="footer_col4">
			<a href="http://www.baidu.com">联系我们</a>
		</div>
		<div class="footer_col4">
			<a href="http://www.baidu.com">联系他们</a>
		</div>
	</div>
</body>
</html>