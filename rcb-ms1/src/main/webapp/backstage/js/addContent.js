$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//加载Menu
	loadMenu();
	
	//绑定上传改变事件
	$("#addContent_myfile").change(loadMyfile);
	
	//绑定提交单击事件
	$("#addContent_button").click(addContent);
	
	
	//测试下拉菜单改变
	/*$("#addContent_menu").change(function(){
		var oneMenuId = $("#addContent_menu").find("option:selected").data("oneMenuId");
		var twoMenuId = $("#addContent_menu").find("option:selected").data("twoMenuId");
		console.log("one:"+oneMenuId);
		console.log("two:"+twoMenuId);
	});*/
});
//content1富文本编译器
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="con1"]',{
		cssPath : '/backstage/editor/plugins/code/prettify.css',
		uploadJson : '/backstage/editor/jsp/upload_json.jsp',
		fileManagerJson : '/backstage/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['example'].submit();
			});
			K.ctrl(self.edit.doc, 13, function(){
				self.sync();
				document.forms['example'].submit();
			});
		}
	});
	prettyPrint();
});
//content1富文本编译器
var editor2;
KindEditor.ready(function(K) {
	editor2 = K.create('textarea[name="con2"]',{
		cssPath : '/backstage/editor/plugins/code/prettify.css',
		uploadJson : '/backstage/editor/jsp/upload_json.jsp',
		fileManagerJson : '/backstage/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['example'].submit();
			});
			K.ctrl(self.edit.doc, 13, function(){
				self.sync();
				document.forms['example'].submit();
			});
		}
	});
	prettyPrint();
});
//content1富文本编译器
var editor3;
KindEditor.ready(function(K) {
	editor3 = K.create('textarea[name="con3"]',{
		cssPath : '/backstage/editor/plugins/code/prettify.css',
		uploadJson : '/backstage/editor/jsp/upload_json.jsp',
		fileManagerJson : '/backstage/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['example'].submit();
			});
			K.ctrl(self.edit.doc, 13, function(){
				self.sync();
				document.forms['example'].submit();
			});
		}
	});
	prettyPrint();
});

function addContent(){
	
	//获取oneMenuId
	var oneMenuId = $("#addContent_menu").find("option:selected").data("oneMenuId");
	//获取twoMenuId
	var twoMenuId = $("#addContent_menu").find("option:selected").data("twoMenuId");
	if(typeof(oneMenuId) == "undefined"){
		oneMenuId = "";
	}
	if(typeof(twoMenuId) == "undefined"){
		twoMenuId = "";
	}
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
	if(isNaN($("input[name='click']").val().trim())){
		alert("请在点击次数中填入数字");
		ok = false;
	}
	if($("input[name='click']").val().trim() >= 2147483648){
		alert("点击次数中填入数字过大");
		ok = false;
	}
	if($("input[name='seq']").val().trim() == ""){
		$("input[name='seq']").val(100);
	}
	if($("input[name='click']").val().trim() == ""){
		$("input[name='click']").val(0);
	}
	if($("#addContent_menu").find("option:selected").html() == "请选择分类"){
		alert("请在分类标题中选择分类");
		ok = false;
	}
	//判断存在是否可以选择一级菜单
	var thisSub = $("#addContent_menu").find("option:selected").html().substr(0,1);
	if(thisSub != "├" && thisSub != "└"){
		var nextSub = "";
		if(typeof($("#addContent_menu").find("option:selected").next().html()) != "undefined"){
			nextSub = $("#addContent_menu").find("option:selected").next().html().substr(0,1);
		}
		if(nextSub == "├" || nextSub == "└"){
			ok = false;
			alert("该分类标题存在子栏目，请选择其中子栏目");
		}
	}
	/*console.log(oneMenuId);
	console.log(twoMenuId);*/
	var data = new FormData($( "#addContent_form" )[0]);
	//data.append("参数名",参数值);
	data.append("oneMenuId",oneMenuId);
	data.append("twoMenuId",twoMenuId);
	data.append("content1",editor1.html());
	data.append("content2",editor2.html());
	data.append("content3",editor3.html());
	if(ok){
		$.ajax({
			url : path + "/addContent/addContent.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("内容添加成功");
					window.location.href = "list.do";
				}
			},
			error : function() {
				alert("内容添加失败!!!");
			}
		});
	}
	
}

function loadMyfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#addContent_link").val(my);
}

function loadMenu(){
	
	//发送请求调取OneMenu和TwoMenu
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
				/*console.log("两个对象：",oneMenuList,twoMenuList);
				console.log(oneMenuList.length);*/
				
				//创建下拉菜单Menu
				//console.log(oneMenuList,twoMenuList);
				createOneMenu(oneMenuList);
				createTwoMenu(twoMenuList);
			}
		},
		error : function() {
			alert("栏目加载失败!!!");
		}
	});
}

function createOneMenu(oneMenuList){

	//遍历oneMenu
	for(var i=0;i<oneMenuList.length;i++){
		var oneMenuId = oneMenuList[i].id;
		var oneMenuTitle = oneMenuList[i].title;
		/*var oneMenuIconUrl = oneMenuList[i].icon_url;
		var oneMenuLink = oneMenuList[i].link;
		var oneMenuProfile = oneMenuList[i].profile;
		var oneMenuKeyWord = oneMenuList[i].keyword;
		var oneMenuIsDisplay = oneMenuList[i].is_display;
		var oneMenuSeq = oneMenuList[i].seq;
		var oneMenuRemark = oneMenuList[i].remark;*/
		/*console.log(oneMenuId,oneMenuTitle,oneMenuIconUrl,oneMenuLink,
				oneMenuProfile,oneMenuKeyWord,oneMenuIsDisplay,
				oneMenuSeq,oneMenuRemark);*/
		
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
		$("#addContent_menu").append($option);
		/*console.log($option.data("oneMenuId"));
		console.log($option);*/
	}
}

function createTwoMenu(twoMenuList){
	
	//创建数组,用于判断结尾符
	var isFirst = [];
	
	//遍历twoMenu
	for(var i=twoMenuList.length-1;i>=0;i--){
		var twoMenuId = twoMenuList[i].id;
		var oneMenuId = twoMenuList[i].oneMenuId;
		var twoMenuTitle = twoMenuList[i].title;
		/*var twoMenuIconUrl = twoMenuList[i].iconUrl;
		var twoMenuLink = twoMenuList[i].link;
		var twoMenuProfile = twoMenuList[i].profile;
		var twoMenuKeyWord = twoMenuList[i].keyword;
		var twoMenuIsDisplay = twoMenuList[i].display;
		var twoMenuSeq = twoMenuList[i].seq;
		var twoMenuRemark = twoMenuList[i].remark;*/
		/*console.log(twoMenuId,oneMenuId,twoMenuTitle,twoMenuIconUrl,twoMenuLink,
				twoMenuProfile,twoMenuKeyWord,twoMenuIsDisplay,
				twoMenuSeq,twoMenuRemark);*/
		
		//创建页面显示字符串
		var soption="";
		soption+="<option value=''>";
		/*console.log(oneMenuId);
		console.log(twoMenuId);*/
		
		//添加前缀符号
		if($.inArray(oneMenuId, isFirst)!=-1){
			/*console.log("不使用");*/
			soption+='├─';
		}else{
			/*console.log("使用，标记为使用过");*/
			soption+='└─';
			isFirst.push(oneMenuId);
		}
		
		soption+=twoMenuTitle;
		soption+="</option>";
		//将字符串转换成jQuery对象
		var $option=$(soption);
		//将twoMenuId绑定到$option对象中
		$option.data("twoMenuId",twoMenuId);
		/*console.log($option.data("oneMenuId"));
		console.log($option);*/
		//获取所有option集合
		var $optionList = $("#addContent_menu").find("option");
		/*console.log($optionList);*/
		var len = $optionList.length;
		//遍历ul集合,算法搞事请
		for (var j = 0; j < len; j++) {
			
			if(oneMenuId==$optionList.eq(j).data("oneMenuId")){
				//将$option对象添加到optionList身后
				$optionList.eq(j).after($option);
				/*console.log($option.data("twoMenuId"));
				console.log(oneMenuId,$optionList.eq(j).data("oneMenuId"));*/
			}
		}
	}
}