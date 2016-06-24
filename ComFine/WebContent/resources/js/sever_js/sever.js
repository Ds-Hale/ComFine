$(function(){
	var index=3;
	$(".getmore").click(function(){
		var s = se_id;
		$.ajax({
			url:"listgetmore",
			type:"post",
			dataType:"json",
			data:{
				"start":index,
				"end":index+3,
				"serve_id":s,
			},
			success:function(data){
				$.each(data.contents,function(i,item){
					var clone = $(".list1").first().clone();
					var title = clone.find("p[class='sc_name']");
					var addr = clone.find("p[class='sc_addr']");
					var introduce = clone.find("p[class='sc_intro']");
					var price = clone.find("strong");
					var id = clone.find("a");
					var str = 'listcontent?id='+item.id;
					title.html(item.severcontent_name);
					addr.html(item.addr);
					introduce.html(item.introduce);
					price.html(item.price);
					id.attr("href",str);
					$(".pdct_list").append(clone);
				});	
				index+=3;
			},
			error:function(){
				alert("error!");
			}
		});
	});
});