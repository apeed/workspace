$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//加载Menu	//加载AmendContent	//loadAmendContent();
	loadMenu();
	
	//加载AmendContent
	//loadAmendContent();
	
	//绑定上传改变事件
	$("#amendContent_myfile").change(loadMyfile);
	

	//绑定提交单击事件
	$("#amendContent_button").click(amendContent);
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


function amendContent(){
	//获取oneMenuId
	var oneMenuId = $("#amendContent_menu").find("option:selected").data("oneMenuId");
	//获取twoMenuId
	var twoMenuId = $("#amendContent_menu").find("option:selected").data("twoMenuId");
	if(typeof(oneMenuId) == "undefined"){
		oneMenuId = "";
	}
	if(typeof(twoMenuId) == "undefined"){
		twoMenuId = "";
	}
	/*console.log(oneMenuId);
	console.log(twoMenuId);*/
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
	if($("input[name='seq']").val().trim() == ""){
		$("input[name='seq']").val(100);
	}
	if($("input[name='click']").val().trim() == ""){
		$("input[name='click']").val(0);
	}
	if($("input[name='click']").val().trim() >= 2147483648){
		alert("点击次数中填入数字过大");
		ok = false;
	}
	if($("#amendContent_menu").find("option:selected").html() == "请选择分类"){
		alert("请在分类标题中选择分类");
		ok = false;
	}
	//判断存在是否可以选择一级菜单
	var thisSub = $("#amendContent_menu").find("option:selected").html().substr(0,1);
	if(thisSub != "├" && thisSub != "└"){
		var nextSub = "";
		if(typeof($("#amendContent_menu").find("option:selected").next().html()) != "undefined"){
			nextSub = $("#amendContent_menu").find("option:selected").next().html().substr(0,1);
		}
		if(nextSub == "├" || nextSub == "└"){
			ok = false;
			alert("该分类标题存在子栏目，请选择其中子栏目");
		}
	}
	var data = new FormData($( "#amendContent_form" )[0]);
	//data.append("参数名",参数值);
	data.append("oneMenuId",oneMenuId);
	data.append("twoMenuId",twoMenuId);
	data.append("content1",editor1.html());
	data.append("content2",editor2.html());
	data.append("content3",editor3.html());
	
	
	if(ok){
		$.ajax({
			url : path + "/amendContent/amendContent.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("内容修改成功");
					window.location.href = "list.do";
				}
			},
			error : function() {
				alert("内容修改失败!");
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
	$("#amendContent_link").val(my);
}

function loadAmendContent(){
	//获取cookie中的twoMenuId
	var singlePageCookieId = getCookie("singlePageId")
	//判断cookie是否有效
	if(singlePageCookieId==null){
		window.location.href="list.do";
	}
	/*console.log(singlePageCookieId);*/
	//获取单条oneMenu信息
	$.ajax({
		url:path+"/amendContent/loadAmendContent.do",
		type:"post",
		data:{"id":singlePageCookieId},
		dataType:"json",
		success : function(result) {
			if (result.state == 0) {

				//获取twoMenu
				var singlePage = result.data;
				//获取各项数值
				var singlePageId = singlePage.id;
				var singlePageOneMenuId = singlePage.oneMenuId;
				var singlePageTwoMenuId = singlePage.twoMenuId;
				var singlePageTitle = singlePage.title;
				var singlePageShortTitle = singlePage.shortTitle;
				var singlePageAuthor = singlePage.author;
				var singlePageImgUrl = singlePage.imgUrl;
				var singlePageKeyword = singlePage.keyword;
				var singlePageProfile = singlePage.profile;
				var singlePageContent1 = singlePage.content1;
				var singlePageContent2 = singlePage.content2;
				var singlePageContent3 = singlePage.content3;
				var singlePageCreateTime = singlePage.createTime;
				var singlePageModifyTime = singlePage.modifyTime;
				var singlePageDisplay = singlePage.display;
				var singlePageSeq = singlePage.seq;
				var singlePageClick = singlePage.click;
				var singlePageRemark = singlePage.remark;
				
				//singlePageImgUrl得到文件名
				singlePageImgUrl=singlePageImgUrl.replace(/.*(\/|\\)/, "");  
				if(singlePageImgUrl=="error"){
					singlePageImgUrl="";
				}else if(singlePageImgUrl=="null"){
					singlePageImgUrl="";
				}
				
				
				/*console.log(singlePageId,singlePageOneMenuId,singlePageTwoMenuId,singlePageTitle,
						singlePageShortTitle,singlePageAuthor,singlePageImgUrl,singlePageKeyword,
						singlePageProfile,singlePageContent1,singlePageContent2,singlePageContent3,
						singlePageCreateTime,singlePageModifyTime,singlePageDisplay,singlePageSeq,
						singlePageClick,singlePageRemark);*/
				
				//获取各个内容框，绑定他们哟
				$("input[name='id']").val(singlePageId);
				
				//遍历optionList 选中相应的option
				var $optionList = $("#amendContent_menu option");
				var len = $optionList.length;
				/*console.log($optionList);
				console.log(len);*/
				for (var i = 0; i < len; i++) {
					var oneMenuDataId = $optionList.eq(i).data("oneMenuId");
					var twoMenuDataId = $optionList.eq(i).data("twoMenuId");
					/*console.log($optionList.eq(i));
					console.log($optionList.eq(i).data());*/
					if(typeof(oneMenuDataId) != "undefined"){
						if(oneMenuDataId == singlePageOneMenuId){
							$optionList.eq(i).prop('selected',true);
						}
					}else if(typeof(twoMenuDataId) != "undefined"){
						if(twoMenuDataId == singlePageTwoMenuId){
							$optionList.eq(i).prop('selected',true);
						}
					}
				}
				
				$("input[name='oneMenuId']").val(singlePageOneMenuId);
				$("input[name='twoMenuId']").val(singlePageTwoMenuId);
				
				$("input[name='title']").val(singlePageTitle);
				$("input[name='shortTitle']").val(singlePageShortTitle);
				$("input[name='author']").val(singlePageAuthor);
				$("input[name='link']").val(singlePageImgUrl);
				$("input[name='keyword']").val(singlePageKeyword);
				$("textarea[name='profile']").val(singlePageProfile);
				
				editor1.html(singlePageContent1);
				editor2.html(singlePageContent2);
				editor3.html(singlePageContent3);
				
				$("input[name='createTime']").val(singlePageCreateTime);
				$("input[name='modifyTime']").val(singlePageModifyTime);
				$("input[name='seq']").val(singlePageSeq);
				$("input[name='click']").val(singlePageClick);
				$("input[name='remark']").val(singlePageRemark);
				if(singlePageDisplay==0){
					$("#addSonColumn_no").click();
				}else if(singlePageDisplay==1){
					$("#addSonColumn_yes").click();
				}
			}
		},
		error : function() {
			alert("内容加载失败!!!");
		}
	});

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
				//加载AmendContent
				loadAmendContent();
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
		$("#amendContent_menu").append($option);
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
		var $optionList = $("#amendContent_menu").find("option");
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