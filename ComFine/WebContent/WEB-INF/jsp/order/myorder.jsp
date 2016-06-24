<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/news-css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="resources/css/news-css/print.css" rel="stylesheet" type="text/css"  media="print" />
<title>MyOrder</title>
</head>
<script src="resources/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
$(function(){

$(".form_boxA tr:odd").addClass("odd");//odd为偶数行
$(".form_boxA tr").hover(function(){
	$(this).toggleClass("tdhover");

})
  $("#table01 tr:even").addClass("even");//even为偶数行
});
</script>
<body>
<div id="MainForm">
<div class="form_boxA">
<h2></h2>
<table cellpadding="0" cellspacing="0" id="news_table">
<tr>
<th>订单ID</th>
<th>服务ID</th>
<th></th>
<th>4人</th>
<th>5</th>
<th>6</th>
<th>7</th>

</tr>
<c:forEach items="${content}" var="content" varStatus="status">
<tr>
<td>${content.serve_id}</td> <td>${content.serve_id}</td><td>${content.severcontent_name}</td><td>${content.price}</td><td>${content.up_date}</td><td>content.tel</td>
<td><input type="checkbox"></td><td></td>
</tr>
</c:forEach>

</table>
<p class="msg">共找到xx条年度预算记录，当前显示从第xx条至第xx条</p>
</div>
</div>
</body>
</html>