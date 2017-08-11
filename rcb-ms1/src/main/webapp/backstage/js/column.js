$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//自动加载oneMenu
	loadMenu();
	
	//监听添加子栏目单击事件
	$("#column_table").on("click",".addSonColumn_button",addSonColumn);
	
	//监听修改栏目单击事件
	$("#column_table").on("click",".publicColumn_button",publicColumn);
	
	//监听修改子栏目单击事件
	$("#column_table").on("click",".publicSonColumn_button",publicSonColumn);
	
	//监听删除栏目单击事件
	$("#column_table").on("click",".deleteColumn_button",deleteColumn);
	
	//监听删除子栏目单击事件
	$("#column_table").on("click",".deleteSonColumn_button",deleteSonColumn);
});

function deleteSonColumn(){
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var twoMenuId = $tr.data("twoMenuId");
		/*console.log(oneMenuId);*/
		//发送ajax
		$.ajax({
			url:path+"/column/deleteTwoMenu.do",
			type:"post",
			data:{"id":twoMenuId},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					$tr.remove();
					alert("删除栏目成功");
				}
			},
			error:function(){
				alert("删除栏目失败");
			}
		});
	}
}

function deleteColumn(){
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var oneMenuId = $tr.data("oneMenuId");
		/*console.log(oneMenuId);*/
		//发送ajax
		$.ajax({
			url:path+"/column/deleteOneMenu.do",
			type:"post",
			data:{"id":oneMenuId},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					$tr.remove();
					alert("删除栏目成功");
				}else if(result.state==4){//存在子集，无法删除
					alert(result.message);
				}
			},
			error:function(){
				alert("删除栏目失败");
			}
		});
	}
}

function publicSonColumn(){
	//获取顶级ul
	var $ul = $(this).parent().parent().parent();
	//获取id
	var twoMenuId = $ul.data("twoMenuId");
	/*alert(twoMenuId);*/
	//保存cookie
	addCookie("twoMenuId",twoMenuId,2);
	/*alert(getCookie("twoMenuId"));*/
}

function publicColumn(){
	//获取顶级ul
	var $ul = $(this).parent().parent().parent();
	//获取id
	var oneMenuId = $ul.data("oneMenuId");
	/*alert(oneMenuId);*/
	//保存cookie
	addCookie("oneMenuId",oneMenuId,2);
	/*alert(getCookie("oneMenuId"));*/
}

function addSonColumn(){
	//获取顶级ul
	var $ul = $(this).parent().parent().parent();
	//获取id
	var oneMenuId = $ul.data("oneMenuId");
	/*alert(oneMenuId);*/
	//保存cookie
	addCookie("oneMenuId",oneMenuId,2);
	/*alert(getCookie("oneMenuId"));*/
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
				
				//创建oneMenu
				createOneMenu(oneMenuList);
				
				//创建twoMenu
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
		var oneMenuIconUrl = oneMenuList[i].icon_url;
		var oneMenuLink = oneMenuList[i].link;
		var oneMenuProfile = oneMenuList[i].profile;
		var oneMenuKeyWord = oneMenuList[i].keyword;
		var oneMenuIsDisplay = oneMenuList[i].is_display;
		var oneMenuSeq = oneMenuList[i].seq;
		var oneMenuRemark = oneMenuList[i].remark;
		/*console.log(oneMenuId,oneMenuTitle,oneMenuIconUrl,oneMenuLink,
				oneMenuProfile,oneMenuKeyWord,oneMenuIsDisplay,
				oneMenuSeq,oneMenuRemark);*/
		
		var sul="";
		sul+='<ul class="table-ul" style="background:#FCFCFC">';
		sul+='<li>';
		sul+=oneMenuSeq;
		sul+='</li>';
		sul+='<li>';
		sul+=oneMenuTitle;
		sul+='</li> '; 
		sul+='<li>'; 
		
		sul+='</li>';
		sul+='<li>';
		sul+=oneMenuRemark;
		sul+='</li>'; 
		sul+='<li>';
		sul+='<div class="button-group">';
		sul+='<a type="button" class="button border-main publicColumn_button" href="publicColumn.do"><span class="icon-edit"></span>修改</a>';
		sul+='<a class="button border-red deleteColumn_button" href="javascript:void(0)" ><span class="icon-trash-o"></span> 删除</a>';
		sul+='<a class="button border-yellow addSonColumn_button" href="addSonColumn.do"><span class="icon-plus-square-o"></span> 添加子栏目</a>';
		sul+='</div>';
		sul+='</li>';
		sul+='</ul>';
		//将字符串转换成jQuery对象
		var $ul=$(sul);
		//将oneMenuId绑定到ul对象中
		$ul.data("oneMenuId",oneMenuId);
		//将tr对象添加到table中
		$("#column_table").append($ul);
		/*console.log("ul.data:"+$ul.data("oneMenuId"));*/
		/*console.log($ul);*/
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
		var twoMenuIconUrl = twoMenuList[i].iconUrl;
		var twoMenuLink = twoMenuList[i].link;
		var twoMenuProfile = twoMenuList[i].profile;
		var twoMenuKeyWord = twoMenuList[i].keyword;
		var twoMenuIsDisplay = twoMenuList[i].display;
		var twoMenuSeq = twoMenuList[i].seq;
		var twoMenuRemark = twoMenuList[i].remark;
		/*console.log(twoMenuId,oneMenuId,twoMenuTitle,twoMenuIconUrl,twoMenuLink,
				twoMenuProfile,twoMenuKeyWord,twoMenuIsDisplay,
				twoMenuSeq,twoMenuRemark);*/
		//创建twoMenu
		var sul="";
		sul+='<ul class="table-ul table-ul-son" >';
		sul+='<li>';
		sul+=twoMenuSeq;
		sul+='</li>';
		sul+='<li>'; 
		/*console.log(oneMenuId);
		console.log(twoMenuId);*/
		if($.inArray(oneMenuId, isFirst)!=-1){
			/*console.log("不使用");*/
			sul+='├─';
		}else{
			/*console.log("使用，标记为使用过");*/
			sul+='└─';
			isFirst.push(oneMenuId);
		}
		
		sul+=twoMenuTitle;
		sul+='</li>';  
		sul+='<li>';
		
		sul+='</li>';
		sul+='<li>';
		sul+=twoMenuRemark;
		sul+='</li>';
		sul+='<li>';
		sul+='<div class="button-group">';
		sul+='<a type="button" class="button border-main publicSonColumn_button" href="publicSonColumn.do"><span class="icon-edit"></span>修改</a>';
		sul+='<a class="button border-red deleteSonColumn_button" href="javascript:void(0)" ><span class="icon-trash-o"></span> 删除</a>';
		sul+='</div>';
		sul+='</li>';
		sul+='</ul>';
		//将字符串转换成jQuery对象
		var $ul=$(sul);
		//将oneMenuId绑定到ul对象中
		$ul.data("twoMenuId",twoMenuId);
		//获取所有ul集合
		var $oneMenuUl = $("#column_table").find("ul");
		/*console.log($oneMenuUl);*/
		var len = $oneMenuUl.length;
		//遍历ul集合,算法搞事请
		for (var j = 0; j < len; j++) {
			if(oneMenuId==$oneMenuUl.eq(j).data("oneMenuId")){
				//将tr对象添加到oneMenu身后
				$oneMenuUl.eq(j).after($ul);
				/*console.log($ul.data("twoMenuId"));*/
			}
		}
	}
}







