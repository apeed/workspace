$(function(){
	//自动加载
	loadAdv();
	//绑定单击事件
//	$("#column_button").click(addColumn);
	
	//监听删除事件 ..给栏目增加删除，连同删除
	$("#aimMenu_table").on("click",".del_aimenu",deleteAdv);
	//监听增加事件
	$("#aimMenu_table").on("click",".add_aimmenu",addAdv);
	//监听修改事件
	$("#aimMenu_table").on("click",".modify_aimmenu",modifyAdvTitle);
	//监听修改事件
	$("#aimMenu_table").on("click",".modify_aimenu",modifyAdv);
});
function addAdv(){
	
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var aimMenuId = $tr.data("aimMenuId");
	//绑定cookie
	addCookie("aimMenuId",aimMenuId,2);
//	alert(getCookie("aimMenuId"));
}
function modifyAdvTitle(){
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var aimMenuId = $tr.data("aimMenuId");
	//绑定cookie
	addCookie("aimMenuId",aimMenuId,2);
/*	alert(getCookie("aimMenuId"));
	alert(12);*/
}
function modifyAdv(){
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var aiMenuId = $tr.data("aiMenuId");
	//绑定cookie
	addCookie("aiMenuId",aiMenuId,2);
//	alert(11);
}
function deleteAdv(){
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var aiMenuId = $tr.data("aiMenuId");
//		console.log(aiMenuId);
		//发送ajax
		$.ajax({
			url:"adv/delAiMenu.do",
			type:"post",
			data:{"id":aiMenuId},
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

function deleteAIM(id){
	if(confirm("您确定要删除此轮播模块吗?其下所有轮播图也将被删除。")){
	//发送请求调取OneMenu和TwoMenu
	$.ajax({
		url:"alternateimgmodule/delete.do",
		type:"post",
		data:{"moduleId":id},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取map
				var map = result.data;
				//获取两个集合
				var aiMenuList = map.aimenu;
				var aimMenuList = map.aimmenu;
				
				console.log("两个对象：",aiMenuList,aimMenuList);
				console.log(aimMenuList.length);
				$("ul:gt(0)").remove();
				//创建createAimMenu
				createAimMenu(aimMenuList);
				
				
				//创建createAiMenu
				createAiMenu(aiMenuList);
			}
		},
		error : function() {
			alert("栏目加载失败!!!");
		}
	});
	}
}



function loadAdv(){
	
	//发送请求调取OneMenu和TwoMenu
	$.ajax({
		url:"column/loadAIMenu.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取map
				var map = result.data;
				//获取两个集合
				var aiMenuList = map.aimenu;
				var aimMenuList = map.aimmenu;
				
//				console.log("两个对象：",aiMenuList,aimMenuList);
//				console.log(aimMenuList.length);
				//创建createAimMenu
				createAimMenu(aimMenuList);
				//创建createAiMenu
				createAiMenu(aiMenuList);
			}
		},
		error : function() {
			alert("栏目加载失败!!!");
		}
	});
}

function createAimMenu(aimMenuList){

	//遍历oneMenu
	for(var i=0;i<aimMenuList.length;i++){
		var aimMenuId = aimMenuList[i].id;
		var aimMenuName = aimMenuList[i].moduleName;
		var aimMenuRemark = aimMenuList[i].remark;
//		console.log(aimMenuId,aimMenuName,aimMenuDisplay,aimMenuRemark);
		var sul="";
		sul+='<ul class="table-ul">';
		sul+='<li>'; 
		sul+="id:"+aimMenuId;//排序
		sul+='</li>';
		sul+='<li>';
		sul+=aimMenuName;
		sul+='</li> '; 
		sul+='<li>';
		sul+=aimMenuRemark;
		sul+='</li>'; 
		sul+='<li>';
		sul+='<div class="button-group">';
		sul+='<a type="button" class="button border-main modify_aimmenu" href="amend-advTitle.do"><span class="icon-edit"></span>修改</a>';
		sul+='<a class="button border-red" href="javascript:void(0)" onclick="deleteAIM('+aimMenuId+')"><span class="icon-trash-o"></span> 删除</a>';
		sul+='<a class="button border-yellow add_aimmenu" href="addadv.do"><span class="icon-plus-square-o"></span> 添加轮播图</a>';
		sul+='</div>';
		sul+='</li>';
		sul+='</ul>';
		//将字符串转换成jQuery对象
		var $ul=$(sul);
		//将oneMenuId绑定到ul对象中
		$ul.data("aimMenuId",aimMenuId);
		//将tr对象添加到table中
		$("#aimMenu_table").append($ul);
		/*console.log("ul.data:"+$ul.data("oneMenuId"));
		console.log($ul);*/
	}
}

function createAiMenu(aiMenuList){
	
	//创建数组,用于判断结尾符
	var isFirst = [];
	
	//遍历twoMenu
	for(var i=aiMenuList.length-1;i>=0;i--){
		
		var aiMenuId = aiMenuList[i].id;
		var aimMenuId = aiMenuList[i].moduleId;
		var aiMenuTitle = aiMenuList[i].title;
		var aiMenuImgUrl = aiMenuList[i].imgUrl;
		var aiMenuProfile = aiMenuList[i].profile;
		var aiMenuLink = aiMenuList[i].link;
		var aiMenuKeyword = aiMenuList[i].keyword;
		var aiMenuDisplay = aiMenuList[i].display;
		var aiMenuSeq = aiMenuList[i].seq;
		var aiMenuRemark = aiMenuList[i].remark;
	
		/*console.log(twoMenuId,oneMenuId,twoMenuTitle,twoMenuIconUrl,twoMenuLink,
				twoMenuProfile,twoMenuKeyWord,twoMenuIsDisplay,
				twoMenuSeq,twoMenuRemark);*/
		//创建twoMenu
		var sul="";
		sul+='<ul class="table-ul table-ul-son" >';
//		sul+='<li>';
//		sul+=aiMenuId;
//		sul+='</li>';
		sul+='<li>';
		sul+=aiMenuSeq;
		sul+='</li>';
		sul+='<li>'; 
		
		if($.inArray(aimMenuId, isFirst)!=-1){
			console.log("不使用");
			sul+='├─';
		}else{
			console.log("使用，标记为使用过");
			sul+='└─';
			isFirst.push(aimMenuId);
		}
		
		
		/*if(i==twoMenuList.length-1){
			sul+='└─';
		}else{
			sul+='├─';
		}*/
		
		sul+=aiMenuTitle;
		sul+='</li>';  
		sul+='<li>';
		sul+=aiMenuRemark;
		sul+='</li>';
		sul+='<li>';
		sul+='';
		sul+='</li>';
		sul+='<li>';
		sul+='<div class="button-group">';
		sul+='<a type="button" class="button border-main modify_aimenu" href="amend_adv.do"><span class="icon-edit"></span>修改</a>';
		sul+='<a class="button border-red del_aimenu" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>';
		sul+='</div>';
		sul+='</li>';
		sul+='</ul>';
		//将字符串转换成jQuery对象
		var $ul=$(sul);
		//将oneMenuId绑定到ul对象中
		$ul.data("aiMenuId",aiMenuId);
		//获取所有ul集合
		var $aimMenuUl = $("#aimMenu_table").find("ul");
		/*console.log($oneMenuUl);*/
		var len = $aimMenuUl.length;
		//遍历ul集合,算法搞事请
		for (var j = 0; j < len; j++) {
			if(aimMenuId==$aimMenuUl.eq(j).data("aimMenuId")){
				//将tr对象添加到oneMenu身后
				$aimMenuUl.eq(j).after($ul);
				/*console.log($ul.data("aiMenuId"));*/
			}
		}
	}
	

}







