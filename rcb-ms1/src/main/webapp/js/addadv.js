$(function(){
	$("#addAdv_button").click(subAction);
	//绑定上传改变事件
	$("#addAdv_myfile").change(load_addAdv_myfile);
});
function load_addAdv_myfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#url1").val(my);
}
function subAction(){
	var aimMenuId = getCookie('aimMenuId');

	var addAdv_title=$("#addAdv_title").val();
	var addAdv_link=$("#addAdv_link").val();
	var addAdv_keyword=$("#addAdv_keyword").val();
	var addAdv_imgUrl=$("#url1").val();
	var addAdv_remark=$("#addAdv_remark").val();
	var addAdv_profile=$("#addAdv_profile").val();
	var advDisplay=$("input[name='display']:checked").val();
	var addAdv_seq=$("#addAdv_seq").val();
	var ok=true;

	/*if(addAdv_title==""){
		ok=false;
	}
	if(addAdv_link==""){
		ok=false;
	}
	if(addAdv_keyword==""){
		ok=false;
	}
	if(addAdv_imgUrl==""){
		ok=false;
	}
	if(addAdv_remark==""){
		ok=false;
	}
	if(addAdv_profile==""){
		ok=false;
	}
	if(advDisplay==""){
		ok=false;
	}
	if(addAdv_seq==""){
		ok=false;
	}
	
	*/
	if(addAdv_title==""){
		$("#addAdv_title_span").html("标题为空");
		ok=false;
	}
	if(addAdv_imgUrl==""){
		$("#addAdv_imgUrl_span").html("图片为空");
		ok=false;
	}
	if(addAdv_seq==""){
		$("#addAdv_seq_span").html("排序为空");
		ok=false;
	}
	
	var data = new FormData($( "#addAdv_form" )[0]);
	//data.append("参数名",参数值);
	data.append("moduleId",aimMenuId);
	if(ok){
		
		$.ajax({
			url :"adv/addAlternateImgCol.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("添加轮播图成功");
					/*window.location.href = "adv.do";	*/
				}
			},
			error : function() {
				alert("添加轮播图失败!");
			}
		});
	}
	
	//从cookie中获取id
//	var userId = getCookie('userId');
	/*if(ok){  
		$.ajax({
			url:"adv/addAlternateImgCol.do",
			type:"post",
			dataType:"json",
			data:{
				"moduleId":aimMenuId,
				"title":addAdv_title,
				"imgUrl":addAdv_url,
				"keyword":addAdv_keyword,
				"link":addAdv_link,
				"remark":addAdv_remark,
				"profile":addAdv_profile,
				"display":advDisplay,
				"seq":addAdv_seq
				},
				success:function(result){
				
				if(result.state==0){
					alert("添加轮播图标题成功！！");
				}
//				window.location.href = path +"/adv.do";		
			},
			error:function(){
				alert("添加轮播图标题失败！！");
			}
		});
	}*/
}