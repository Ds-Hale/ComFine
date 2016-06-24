<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="resources/css/sever-css/liststyle.css" rel="stylesheet" type="text/css" media="screen,print">
</head>
<body>
	<script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="resources/js/sever_js/sever.js"></script>
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
	<div class="path">
		<p>我的E家>惠家洗衣</p>
	</div>
	<!--订单区域-->
	<div class="bkground">
		<div class="display_content">
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

		<div class="list_head">
			<ul class="sorts">
				<li><a href="#">综合排序</a></li>
				<li><a href="#">人气排序</a></li>
				<li><a href="#">销量排序</a></li>
				<li><a href="#">信用排序</a></li>
				<li><a href="#">价格排序</a></li>
			</ul>
			<div class="price">
				<input class="price_input" type="text" name="min_price"> - <input
					class="price_input" type="text" name="max_price">
			</div>
			<div class="space"></div>
			<div class="pager"></div>
		</div>

		<div class="pdct_list">
			<c:forEach items="${message}" var="mesg" begin="0" end="2"> 
			<script type="text/javascript">
				var se_id = ${mesg.serve_id};
			</script>
				<div class="list1">

					<div class="col1">
						<div class="pict">
							<img src="${mesg.pic_path}">
						</div>
					</div>

					<div class="col2">
						<div class="pdct_name">
							<p class="sc_name">${mesg.severcontent_name}</p>
						</div>
						<div class="addr">
							<p class="sc_addr">${mesg.addr}</p>
						</div>
					</div>
					<div class="col3">
						<div class="introduce">
							<p class="sc_intro">${mesg.introduce}</p>
						</div>
					</div>
					<div class="col4">
						<div class="p_price">
							<span><span>￥</span><strong class="sc_price">${mesg.price}</strong></span>
						</div>
					</div>
					<div class="col5">
						<div class="count">
							<span><p>已有12450人付款</p></span>
						</div>
					</div>
					<div class="col6">
						<div class="btn_In">
							<a href="listcontent?id=${mesg.id}">进去看看</a>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
		<div class="getmore"><p>加载更多</p></div>
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