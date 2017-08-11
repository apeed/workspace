$(function(){
	//加载loadAmendAdv页面
	loadAmendAdv();
	//修改确定按钮的单击事件
	$("#amend_adv_button").click(modifyAmendAdv);
	//绑定上传改变事件
	$("#amend_myfile").change(load_amend_myfile);

});
function load_amend_myfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#url1").val(my);
}

function modifyAmendAdv(){
	var aiMenuId = getCookie("aiMenuId")
	//判断cookie是否有效
	if(aiMenuId==null){
		window.location.href="amend_adv.do";	
	}
	
	var advamend_title=$("#amend_adv_title").val();
	var advamend_link=$("#amend_adv_link").val();
	var advamend_keyword=$("#amend_adv_keyword").val();
	var advamend_imgUrl=$("#url1").val();
	var advamend_remark=$("#amend_adv_remark").val();
	var advamend_profile=$("#amend_adv_profile").val();
	var advDisplay=$("input[name='display']:checked").val();
	var advamend_seq=$("#amend_adv_seq").val();
	
	var ok = true;
	
	/*
	if(advamend_title==""){
		$("#advamend_title_span").html("标题为空");
		ok=false;
	}
	if(advamend_imgUrl==""){
		$("#advamend_imgUrl_span").html("图片为空");
		ok=false;
	}
	if(advamend_seq==""){
		$("#advamend_seq_span").html("排序为空");
		ok=false;
	}
	if(advamend_keyword==""){
		
		ok=false;
	}
	if(advamend_link==""){
		
		ok=false;
	}
	if(advamend_remark==""){
		
		ok=false;
	}
	if(advamend_profile==""){
			
			ok=false;
		}
	if(advDisplay==""){
		
		ok=false;
	}
	*/
//	console.log(advpop_title,advpop_url,advpop_link,advpop_content,advpop_seq);

	var data = new FormData($( "#amend_adv_form" )[0]);
	//data.append("参数名",参数值);
	data.append("id",aiMenuId);
	if(ok){
		$.ajax({
			url :"adv/modifyAmend.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("修改成功");
					window.location.href = "adv.do";	
				}
			},
			error : function() {
				alert("修改失败!");
			}
		});
	}
	
		
}


function loadAmendAdv(){
	// 获取参数userId
	/*var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href=path+"/admin.do";
	}*/
	
	//获取cookie中的aiMenuId
	var aiMenuId = getCookie("aiMenuId");
	//判断cookie是否有效
	if(aiMenuId==null){
//		window.location.href="amend_adv.do";
	}
		
	//发送ajax
	$.ajax({
		url : "adv/loadAmend.do",
		type : "post",
		data : {"id":aiMenuId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				//int id,String title,String imgUrl,String keyword,
//				String link,String remark,String profile,Byte display,Byte seq					
				var AlternateImg = result.data;
/*				console.log(HomeImg);
*/				//获取各项数值

				var AlternateImgTitle = AlternateImg.title;
				var AlternateImglink = AlternateImg.link;
				var AlternateImgKeyword = AlternateImg.keyword;
				var AlternateImgImgUrl = AlternateImg.imgUrl;
				var AlternateImgRemark = AlternateImg.remark;
				var AlternateImgProfile = AlternateImg.profile;
				var AlternateImgDisplay = AlternateImg.display;
				var AlternateImgSeq = AlternateImg.seq;
				
				//获取各个内容框，绑定他们哟
				var advamend_title=$("#amend_adv_title").val(AlternateImgTitle);
				var advamend_link=$("#amend_adv_link").val(AlternateImglink);
				var advamend_keyword=$("#amend_adv_keyword").val(AlternateImgKeyword);
				var advamend_imgUrl=$("#url1").val(AlternateImgImgUrl);
				var advamend_remark=$("#amend_adv_remark").val(AlternateImgRemark);
				var advamend_profile=$("#amend_adv_profile").val(AlternateImgProfile);
				
				if(AlternateImgDisplay == 1){
					$("#amendAdv_yes").click();
				}else if(AlternateImgDisplay  == 0){
					$("#amendAdv_no").click();
				}
				
				var advamend_seq=$("#amend_adv_seq").val(AlternateImgSeq);
				
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
}
