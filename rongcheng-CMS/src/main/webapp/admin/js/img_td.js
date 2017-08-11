var td_img=$(".img_td>img");
var img_content_img=$(".img_content>img");
var img_content=$(".img_content");
var img_alert=$(".img_alert");
var img_del=$(".img_del");
td_img.click(function(){
	img_alert.css("display","block");
	var imgsrc=$(this).attr("src");
	img_content_img.attr('src',imgsrc);
	img_content.width(img_content_img.width());
})
img_del.click(function(){
	img_alert.css("display","none");
})