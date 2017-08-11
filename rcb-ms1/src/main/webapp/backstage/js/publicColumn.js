$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//publicColumn页面
	loadPublicColumn();
	
	//修改单击事件
	$("#publicColumn_button").click(publicColum);
	
	//绑定上传改变事件
	$("#publicColumn_myfile").change(loadMyfile);
});

function loadMyfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#publicColumn_link").val(my);
}

function publicColum(){

	var ok = true;
	//给予默认值
	if($("input[name='title']").val().trim() == ""){
		alert("请在标题中填入内容");
		ok = false;
	}
	if(isNaN($("input[name='seq']").val().trim())){
		alert("请在排序中填入数字");
		ok = false;
	}
	if($("input[name='seq']").val().trim() >= 128){
		alert("排序中数字最大为127");
		ok = false;
	}
	if($("input[name='seq']").val().trim() == ""){
		$("input[name='seq']").val(100);
	}
	var data = new FormData($( "#publicColum_form" )[0]);
	//data.append("参数名",参数值);
	if(ok){
		$.ajax({
			url : path + "/publicColum/publicColum.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("栏目修改成功");
					window.location.href = "column.do";
				}
			},
			error : function() {
				alert("栏目修改失败!");
			}
		});
	}
	
}

function loadPublicColumn(){
	
	//获取cookie中的oneMenuId
	var oneMenuCookieId = getCookie("oneMenuId")
	//判断cookie是否有效
	if(oneMenuCookieId==null){
		window.location.href="column.do";
	}
	//获取单条oneMenu信息
	$.ajax({
		url:path+"/publicColumn/loadPublicColumn.do",
		type:"post",
		data:{"id":oneMenuCookieId},
		dataType:"json",
		success : function(result) {
			if (result.state == 0) {
				//获取oneMenu
				var oneMenu = result.data;
				//获取各项数值
				var oneMenuId = oneMenu.id;
				var oneMenuTitle = oneMenu.title;
				var oneMenuIconUrl = oneMenu.iconUrl;
				var oneMenuLink = oneMenu.link;
				var oneMenuProfile = oneMenu.profile;
				var oneMenuKeyword = oneMenu.keyword;
				var oneMenuDisplay = oneMenu.display;
				var oneMenuSeq = oneMenu.seq;
				var oneMenuRemark = oneMenu.remark;
				
				//oneMenuLink得到文件名
				oneMenuLink=oneMenuLink.replace(/.*(\/|\\)/, "");  
				if(oneMenuLink=="error"){
					oneMenuLink="";
				}else if(oneMenuLink=="null"){
					oneMenuLink="";
				}
				
				/*console.log(oneMenuId,oneMenuTitle,oneMenuIconUrl,
						oneMenuLink,oneMenuProfile,oneMenuKeyword,
						oneMenuDisplay,oneMenuSeq,oneMenuRemark);*/
				
				//获取各个内容框，绑定他们哟
				$("input[name='id']").val(oneMenuId);
				$("input[name='title']").val(oneMenuTitle);
				$("input[name='iconUrl']").val(oneMenuIconUrl);
				$("input[name='link']").val(oneMenuLink);
				$("textarea[name='profile']").val(oneMenuProfile);
				$("input[name='keyword']").val(oneMenuKeyword);
				$("input[name='remark']").val(oneMenuRemark);
				$("input[name='seq']").val(oneMenuSeq);
				if(oneMenuDisplay==0){
					$("#publicColumn_no").click();
				}else if(oneMenuDisplay==1){
					$("#publicColumn_yes").click();
				}
			}
		},
		error : function() {
			alert("栏目内容加载失败!!!");
		}
	});
};
