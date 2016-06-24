$(document).ready(function(){
	$(".img_show").css({"left":"3000px","position":"absolute"});
	$(".img_show").animate({left:0},{duration:1000,easing:"easeInBounce"});
	$(".img_show").css({"position":"relative"});
	$(".title").css({"left":"-1000px","position":"absolute"});
	$(".title").animate({left:0},{duration:1000,easing:"easeInBounce"});
	$(".title").css({"position":"relative"});
	});
