<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详情</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/sever-css/sevcontent.css" />
</head>
<body>
	<script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript">
		$(function() {
			var s;
			var clone = $(".middle .img li").first().clone();
			$(".middle .img").append(clone);
			var size = $(".middle .img li").size();
			var size_img = $(".middle .img img ").width()
			for (var i = 0; i < size - 1; i++) {
				var a = i + 1;
				$(".middle .num")
						.append(
								"<li><img src='resources/images/sever/" + a + ".jpg'></li>");
			}
			$(".middle .num li").first().addClass("on");
			$(".middle .num li").click(function() {
				$(this).addClass("on").siblings().removeClass("on");
				var index = $(this).index();
				$(".middle .img").stop().animate({
					left : -index * size_img
				}, {
					duration : 1000,
					easing : "easeInOutBack"
				});
			});

			$(".xiadan_btn").click(function() {
				$(".confirm_order").slideDown("slow");
				$("#sort_choose").val(s);
				alert(s);
				$("<p/>").appendTo("#sort_choose").html(s);
				var a = ${message.getServe_id()};
				var b = ${message.getId()};
				var c = ${message.getPrice()};
				$("#sorts").val(s);
				$("#content_id").val(b);
				$("#price").val(c);
			});

			$(".sorts").click(
					function() {
						s = $(this).text().trim();
						$(this).addClass("sorts_active").siblings()
								.removeClass("sorts_active");
					});
		});
	</script>

	<!--头部导航栏-->
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
	<!--路径栏-->
	<div class="path">
		<p>我的E家>惠家洗衣>商品详情</p>
	</div>
	<!--背部-->
	<div class="bkground">
		<!--商品图片-->
		<div class="display_content">
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
					<li><a href="#"><img src="resources/images/sever/5.jpg"></a></li>
				</ul>
				<span class="top"></span>
				<ul class="num"></ul>
			</div>
		</div>
		<!--下单-->
		<div class="xiadan">
			<div class="xiadan_row1">
				<p>${message.getSevercontent_name()}</p>
			</div>
			<div class="xiadan_row2">
				<div class="name">
					<p>请选择服务</p>
				</div>
				<c:forEach items="${mes}" var="mesg">
					<div class="sorts">
						<p>${mesg}</p>
					</div>
				</c:forEach>
			</div>
			<!--  <input type="text" id="sort_choose" name="sort_active">-->
			<div class="xiadan_row3">
				<div class="xiadan_btn">
					<strong>点击下单</strong>
				</div>
			</div>
		</div>
		<form method="post" action="placeorder" enctype="multipart/form-data">
			<input type="hidden" name="sorts" id="sorts" />
			<input type="hidden" name="content_id" id="content_id" />
			<input type="hidden"name="price" id="price" />
			<div class="confirm_order">
				<div class="triangle-up"></div>
				<div class="xiadan_frame">
					<div class="xiadan_frame_row1">
						<p>请确认您的订单</p>
					</div>
					<div class="xiadan_frame_row2">
						<p>商店名: ${message.getSevercontent_name()}</p>
					</div>
					<div class="xiadan_frame_row3">
						<p id="sort_choose">您选择的业务:</p>
						<br />
						<p>您的地址:</p>
					</div>
					<div class="xiadan_frame_row4">

						<div class="xiadan_btn">
							<input type="submit" value="确认下单"><a href="#"><p>确认下单</p></a>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div
			style="float: left; border: 1px solid #888; padding: 10px 20px; background: #f1f1f1">
			<!--商品文字介绍-->
			<div class="content">
				<ul>
					<c:forEach items="${introduce}" var="intr">
						<li>${intr}</li>
					</c:forEach>
				</ul>
			</div>
			<!--商品图片介绍-->
			<div class="pic_content">
				<div class="pic_content_img">
					<img src="resources/images/sever/6.jpg" alt="" />
				</div>
			</div>
			<div
				style="height: 1px; margin-top: -1px; clear: both; overflow: hidden;"></div>
		</div>
	</div>
	<!--底部-->
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