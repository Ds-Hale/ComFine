
$(document).ready(function(){

	var currentIndex=5;
	$(".delete_news").click(function(){
		
		removeTd();
		});
	$(".get_more").click(function(){
		currentIndex+=5;
	
		getMore(currentIndex);
	});
	
	
});

function removeTd(){
	var r = confirm("确定删除这些记录吗");
	if(r==true){
	$("#news_table tr").each(function(i){	
		var check = $(this).find("input[type='checkbox']");

		if(check.is(':checked')){
			var id = $("#news_table tr:eq("+i+") td:nth-child(2)").html();
			
//			$("#news_table tr:eq("+i+")")
//			coum+=1;
			$.post("deletenews.action",{"id":id});
		}
		
		
		
	});}
	window.location.reload();
}


function getMore(index){	
getNews(index+1, index+3);
function getNews(i,j){
	$.ajax({
		url:'getmore.action',		
		type:"GET",
		dataType:'json',
		data:{'start':i,'end':j},
		success:function(data){
			printToHtml(data);		
			
		},
		error:function(){
			alert("请求数据错误，请稍后重试");
		}		
	})
}
}
function printToHtml(data){
	

$.each(data.news,function(i,item){
	
	//找到news_content元素里面需要赋值的元素
	var clone = $(".news_content").eq(1).clone();
	
	var img = clone.find("img");
	var title = clone.find("h1");
	var up = clone.find("p[class='up']");
	var introduce = clone.find("p[class='introduce']");
	var date = clone.find("p[class='date']")
	
	//对元素的值进行赋值
	img.attr('src',item.path);
	title.html(item.title);
	up.html(item.up);
	date.html(item.date);
	introduce.html(item.introduce);
	$(".news_show").append(clone);
	clone.css({"left":"1000px"});
	clone.animate({left:0},{duration:(i+1)*1000,easing:"easeInOutBack"});
});
}