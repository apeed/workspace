$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//加载一级菜单下拉框
	loadOneMenu();
	
	//publicSonColumn页面
	loadpublicSonColumn();
	
	//修改单击事件
	$("#publicSonColumn_button").click(publicSonColumn);
	
	//绑定上传改变事件
	$("#publicSonColumn_myfile").change(loadMyfile);
});

function loadMyfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#publicSonColumn_link").val(my);
}

function publicSonColumn(){
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
	if($("#publicSonColumn_oneMenu").find("option:selected").html() == "请选择分类"){
		alert("请在上级分类中选择分类");
		ok = false;
	}
	//获取oneMenuId
	var oneMenuId = $("#publicSonColumn_oneMenu").find("option:selected").data("oneMenuId");
	/*alert(oneMenuId);*/
	var data = new FormData($( "#publicSonColumn_form" )[0]);
	//data.append("参数名",参数值);
	data.append("oneMenuId",oneMenuId);
	if(ok){
		$.ajax({
			url : path + "/publicSonColumn/publicSonColumn.do",
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

function loadpublicSonColumn(){
	
	//获取cookie中的twoMenuId
	var twoMenuCookieId = getCookie("twoMenuId")
	//判断cookie是否有效
	if(twoMenuCookieId==null){
		window.location.href="column.do";
	}
	/*console.log(twoMenuCookieId);*/
	//获取单条oneMenu信息
	$.ajax({
		url:path+"/publicSonColumn/loadPublicSonColumn.do",
		type:"post",
		data:{"id":twoMenuCookieId},
		dataType:"json",
		success : function(result) {
			if (result.state == 0) {

				//获取twoMenu
				var twoMenu = result.data;
				//获取各项数值
				var twoMenuId = twoMenu.id;
				var oneMenuId = twoMenu.oneMenuId;
				var twoMenuTitle = twoMenu.title;
				var twoMenuIconUrl = twoMenu.iconUrl;
				var twoMenuLink = twoMenu.link;
				var twoMenuProfile = twoMenu.profile;
				var twoMenuKeyword = twoMenu.keyword;
				var twoMenuDisplay = twoMenu.display;
				var twoMenuSeq = twoMenu.seq;
				var twoMenuRemark = twoMenu.remark;
				
				//twoMenuLink得到文件名
				twoMenuLink=twoMenuLink.replace(/.*(\/|\\)/, "");  
				if(twoMenuLink=="error"){
					twoMenuLink="";
				}else if(twoMenuLink=="null"){
					twoMenuLink="";
				}
				
				/*console.log(twoMenuId,oneMenuId,twoMenuTitle,twoMenuIconUrl,
						twoMenuLink,twoMenuProfile,twoMenuKeyword,
						twoMenuDisplay,twoMenuSeq,twoMenuRemark);*/
				
				//获取各个内容框，绑定他们哟
				$("input[name='id']").val(twoMenuId);
				$("input[name='title']").val(twoMenuTitle);
				$("input[name='iconUrl']").val(twoMenuIconUrl);
				$("input[name='link']").val(twoMenuLink);
				$("textarea[name='profile']").val(twoMenuProfile);
				$("input[name='keyword']").val(twoMenuKeyword);
				$("input[name='remark']").val(twoMenuRemark);
				$("input[name='seq']").val(twoMenuSeq);
				if(twoMenuDisplay==0){
					$("#publicSonColumn_no").click();
				}else if(twoMenuDisplay==1){
					$("#publicSonColumn_yes").click();
				}
			}
		},
		error : function() {
			alert("栏目内容加载失败!!!");
		}
	});
};

function loadOneMenu(){
	
	//获取cookie中的oneMenuId
	var twoMenuCookieId = getCookie("twoMenuId")
	//判断cookie是否有效
	if(twoMenuCookieId==null){
		window.location.href="column.do";
	}
	/*console.log(twoMenuCookieId);*/
	//查询oneMenu
	$.ajax({
		url:path+"/column/loadMenu.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取map
				var map = result.data;
				//获取两个集合
				var oneMenuList = map.oneMenu;
				var twoMenuList = map.twoMenu;
				//遍历twoMenuList，取得twoMenu的父类oneMenuId
				for (var i = 0; i < twoMenuList.length; i++) {
					var twoMenuId = twoMenuList[i].id;
					if(twoMenuId==twoMenuCookieId){
						var oneMenuCookieId = twoMenuList[i].oneMenuId;
					}
				}
				//创建下拉框
				createOption(oneMenuList,oneMenuCookieId);
			}
		},
		error : function() {
			alert("栏目加载失败!!!");
		}
	});
};

function createOption(oneMenuList,oneMenuCookieId){
	//循环处理
	for(var i=0;i<oneMenuList.length;i++){
		//获取id
		var oneMenuId = oneMenuList[i].id;
		//获取title
		var oneMenuTitle = oneMenuList[i].title;
		
		//创建页面显示字符串
		var soption="";
		soption+="<option value=''>";
		soption+=oneMenuTitle;
		soption+="</option>";
		//将字符串转换成jQuery对象
		var $option=$(soption);
		//将oneMenuId绑定到$option对象中
		$option.data("oneMenuId",oneMenuId);
		//将$option对象添加到select中
		$("#publicSonColumn_oneMenu").append($option);
		//如果两个oneMenuId相同，则选中这条
		if(oneMenuCookieId==oneMenuId){
			var OneMenu = $option.prop('selected',true);
		}
	}
}