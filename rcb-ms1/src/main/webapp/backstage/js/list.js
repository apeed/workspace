//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;

$(function(){
	
	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//加载Menu
	loadMenu();
	
	//加载总页数
	countSinglePage(0,0,"");
	
	//loadList页面	
	//包含监听页码点击事件	$(".pagelist").on("click","a",function(){
	loadListByPage(parseInt(now_page),0,0,"");
	
	//监听修改事件
	$("body").on("click",".modify_button",modifyList);
	
	//监听删除事件
	$("body").on("click",".delete_button",deleteList);
	
	//分类改变事件
	$("#list_menu").change(changeMenu);
	
	//搜索单机事件
	$("#list_search").click(searchList);
});

//搜索加载
function searchList(){
	//分类选项清除
	 $("#list_menu").find("option:first").prop('selected',true);
	// $("#mySelect option:first").prop("selected", 'selected');
	//获取参数
	var keywords = $("input[name='keywords']").val().trim();
	if(keywords == ""){
		$("input[name='keywords']").val("");
	}
	//加载页面，根据页数和搜索内容,重新初始化
	now_page = 1;
	//最大值赋值
	countSinglePage(0,0,keywords);
	loadListByPage(parseInt(now_page),0,0,keywords);
}

function changeMenu(){
	//搜索框清除
	$("input[name='keywords']").val("");
	//获取参数
	var oneMenuId = $("#list_menu").find("option:selected").data("oneMenuId");
	var twoMenuId = $("#list_menu").find("option:selected").data("twoMenuId");
	/*console.log("one:"+oneMenuId);
	console.log("two:"+twoMenuId);*/
	//加载页面，根据页数和菜单ID,重新初始化
	now_page = 1;
	//最大值赋值
	countSinglePage(oneMenuId,twoMenuId,"");
	loadListByPage(parseInt(now_page),oneMenuId,twoMenuId,"");
}

//删除事件
function deleteList(){
	if(confirm("您确定要删除吗?")){
		//获取顶级ul
		var $ul = $(this).parent().parent().parent();
		//获取id
		var singlePageId = $ul.data("singlePageId");
		//发送ajax
		$.ajax({
			url : path+"/list/deleteSinglePage.do",
			type : "post",
			data : {
				"singlePageId":singlePageId
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0){
					alert("删除成功!");
					var oneMenuId = $("#list_menu").find("option:selected").data("oneMenuId");
					var twoMenuId = $("#list_menu").find("option:selected").data("twoMenuId");
					var keywords = $("input[name='keywords']").val();
					countSinglePage(oneMenuId,twoMenuId,keywords);
					loadListByPage(parseInt(now_page),oneMenuId,twoMenuId,keywords);
				}
			},
			error : function() {
				alert("删除失败!");
			}
		});
	}
}

//修改事件
function modifyList(){ 
	
	//获取顶级ul
	var $ul = $(this).parent().parent().parent();
	//获取id
	var singlePageId = $ul.data("singlePageId");
	//保存cookie
	addCookie("singlePageId",singlePageId,2);
	/*alert(getCookie("singlePageId"));*/
}

function countSinglePage(oneMenuId,twoMenuId,fuzzy){
	if(typeof(oneMenuId) == "undefined"){
		oneMenuId = 0;
	}
	if(typeof(twoMenuId) == "undefined"){
		twoMenuId = 0;
	}
	/*console.log(oneMenuId,twoMenuId);*/
	$.ajax({
		url : path+"/list/countSinglePage.do",
		type : "post",
		data : {
			"oneMenuId" : oneMenuId,
			"twoMenuId" : twoMenuId,
			"fuzzy" : fuzzy
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0){
				max_page = result.data;
			}
		},
		error : function() {
			alert("页数加载失败!");
		}
	});
}

function loadListByPage(page,oneMenuId,twoMenuId,fuzzy){
	
	if(typeof(oneMenuId) == "undefined"){
		oneMenuId = 0;
	}
	if(typeof(twoMenuId) == "undefined"){
		twoMenuId = 0;
	}
	$.ajax({
		url : path+"/list/loadListByPage.do",
		type : "post",
		data : {
			"page" : page,
			"oneMenuId" : oneMenuId,
			"twoMenuId" : twoMenuId,
			"fuzzy" : fuzzy
		},
		dataType : "json",
		
		success : function(result) {
			if (result.state == 0){
				//获取singlePage集合
				var map = result.data;
				//如果没有内容，就加载前一页
				if(map.singlePageList.length == 0){
					//如果不是首页
					if(now_page>1){
						now_page--;
						max_page--;
						var oneMenuId = $("#list_menu").find("option:selected").data("oneMenuId");
						var twoMenuId = $("#list_menu").find("option:selected").data("twoMenuId");
						var keywords = $("input[name='keywords']").val();
						loadListByPage(parseInt(now_page),oneMenuId,twoMenuId,keywords);
					}else{
						createSinglePage(map);
					}
				}else{
					//创建singlePage的tr，追加到页面中
					createSinglePage(map);
				}
			}
		},
		error : function() {
			alert("内容加载失败!");
		}
	});
}

function createSinglePage(map){
	var singlePageList = map.singlePageList;
	var oneMenuList = map.oneMenuList;
	var twoMenuList = map.twoMenuList;
	/*console.log(oneMenuList);
	console.log(twoMenuList);*/
	//清空页面内容
	$("#list_table tr").remove();
	//创建singlePagep拼接块
	var th="";
	//第一部分 顶部
	th+='<tr>';
	th+='<th width="1"></th>';
	th+='<th  width="50" style="text-align:center;">序号</th>';
	th+='<th  width="70">点击量</th>';
	th+='<th>名称</th>';
	th+='<th>备注</th>';
	th+='<th>分类名称</th>';
	th+='<th>更新时间</th>';
	th+='<th width="210">操作</th>';
	th+='</tr>';
	//将th对象添加到list_table身后
	$("#list_table").append(th);
	for (var i = 0; i <= singlePageList.length; i++) {
		if(i < singlePageList.length){
			//清空
			var tr = "";
			//获取各个参数
			var singlePageId = singlePageList[i].id;
			var singlePageOneMenuId = singlePageList[i].oneMenuId;
			var singlePageTwoMenuId = singlePageList[i].twoMenuId;
			var singlePageTitle = singlePageList[i].title;
			var singlePageShortTitle = singlePageList[i].shortTitle;
			var singlePageAuthor = singlePageList[i].author;
			var singlePageImgUrl = singlePageList[i].imgUrl;
			var singlePageKeyword = singlePageList[i].keyword;
			var singlePageProfile = singlePageList[i].profile;
			var singlePageContent1 = singlePageList[i].content1;
			var singlePageContent2 = singlePageList[i].content2;
			var singlePageContent3 = singlePageList[i].content3;
			var singlePageCreateTime = singlePageList[i].createTime;
			var singlePageModifyTime = singlePageList[i].modifyTime;
			var singlePageDisplay = singlePageList[i].display;
			var singlePageSeq = singlePageList[i].seq;
			var singlePageClick = singlePageList[i].click;
			var singlePageRemark = singlePageList[i].remark;
			//转换时间类型 导入format工具js
			singlePageCreateTime = format(singlePageCreateTime);
			singlePageModifyTime = format(singlePageModifyTime);
			
			//获取分类名称
			var oneMenuTitle = null;
			var twoMenuTitle = null;
			var menuTitle = null;
			//console.log(oneMenuList);
			if(oneMenuList[i]==null){
				oneMenuTitle = "";	
			}else{
				if(singlePageOneMenuId == oneMenuList[i].id){
					oneMenuTitle = oneMenuList[i].title;
				}
			}
			if(twoMenuList[i] == null){
				twoMenuTitle = "";
			}else if(singlePageTwoMenuId == twoMenuList[i].id){
				/*twoMenuTitle = twoMenuList[i].title;*/
				twoMenuTitle = "<br/>"+"<span style='padding-left:80px;'>└─"+twoMenuList[i].title+"</span>"
			}
			
			if(oneMenuTitle != null && twoMenuTitle != null){
				menuTitle = oneMenuTitle+twoMenuTitle;
			}
			/*console.log(singlePageId,
					singlePageOneMenuId,
					singlePageTwoMenuId,
					singlePageTitle,
					singlePageShortTitle,singlePageAuthor,singlePageImgUrl,singlePageKeyword,
					singlePageProfile,singlePageContent1,singlePageContent2,singlePageContent3,
					singlePageCreateTime,singlePageModifyTime,singlePageDisplay,
					 singlePageSeq,singlePageClick,singlePageRemark,menuTitle);*/
			tr+='<tr>';
			tr+='<td>';
			/*tr+=singlePageId;*/
		    tr+='</td>';
		    tr+='<td style="text-align:center; ">';
		    tr+=singlePageSeq;
			tr+='</td>';
		    tr+='<td>';
		    tr+= singlePageClick;
		    tr+='</td>';
		    tr+='<td> <span style="width:200px;display:inline-block;text-overflow:ellipsis;overflow:hidden;">';
		    tr+=singlePageTitle;
		    tr+='</span></td>';
		    tr+='<td>';
		    tr+=singlePageRemark;
		    tr+='</td>';
		    tr+='<td>';
		    tr+=menuTitle;
		    tr+='</td>';
		    tr+='<td>';
		    tr+=singlePageModifyTime;
		    tr+='</td>';
		    tr+='<td><div class="button-group"> <a class="button border-main modify_button" href="amendContent.do"><span class="icon-edit"></span> 修改</a> <a class="button border-red delete_button" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a> </div></td>';
		    tr+='</tr>';
		    
		    //转换对象，用于存储
		    var $tr=$(tr);
			//将singlePageId绑定到tr对象中
			$tr.data("singlePageId",singlePageId);
			/*console.log($tr.data("singlePageId"));
			console.log($tr);*/
			//将tr对象添加到list_table身后
			$("#list_table").append($tr);
		}else if(i = singlePageList.length){

			var td = ""
			td+='<tr>';
			td+='<td colspan="8"><div class="pagelist"> <a>首页</a> <a>上一页</a>';
		    
			//三种情况
			//在第一页
			if(parseInt(now_page) <= 1){
				/*console.log("parseInt(now_page) <= 1");*/
				td+='<span class="current">1</span>';
				if(parseInt(max_page) >= 2){
					td+='<a>2</a>';
				}
				if(parseInt(max_page) >= 3){
					td+='<a>3</a>';
				}
			}
			//在中间页
			else if(parseInt(now_page) > 1 && parseInt(now_page) < parseInt(max_page)){
				/*console.log("parseInt(now_page) > 1 && parseInt(now_page) < parseInt(max_page)");*/
				if(parseInt(now_page) > 1){
					td+='<a>';
					td+=(parseInt(now_page)-1);
					td+='</a>';
				}
				td+='<span class="current">';
				td+=parseInt(now_page);
				td+='</span>';
				if(parseInt(now_page) < parseInt(max_page)){
					td+='<a>';
					td+=(parseInt(parseInt(now_page))+1);
					td+='</a>';
				}
			}
			//在尾页
			else if(parseInt(now_page) >= parseInt(max_page)){
				/*console.log("parseInt(now_page) >= parseInt(max_page)");*/
				if(parseInt(max_page) >= 3){
					td+='<a>';
					td+=(parseInt(now_page)-2);
					td+='</a>';
				}
				if(parseInt(max_page) >= 2){
					td+='<a>';
					td+=(parseInt(now_page)-1);
					td+='</a>';
				}
				td+='<span class="current">';
				td+=parseInt(now_page);
				td+='</span>';
			}
			
		    td+='<a>下一页</a><a>尾页</a> </div></td>';
		    td+='</tr>';
	    //将td对象添加到list_table身后
		$("#list_table").append(td);
		}
	}
	
	//监听页码点击事件
	$(".pagelist").on("click","a",function(){
		var aHtml = $(this).html();
		//判断当前页的值
		if(aHtml=="首页"){
			now_page = 1;
		}else if(aHtml=="上一页"){
			if(now_page>1){
				now_page--;
			}
		}else if(aHtml=="下一页"){
			if(now_page<max_page){
				now_page++;
			}
		}else if(aHtml=="尾页"){
			now_page = parseInt(max_page);
		}else{
			now_page = aHtml;
		}
		/*alert(parseInt(now_page));*/
		var oneMenuId = $("#list_menu").find("option:selected").data("oneMenuId");
		var twoMenuId = $("#list_menu").find("option:selected").data("twoMenuId");
		var keywords = $("input[name='keywords']").val();
		loadListByPage(parseInt(now_page),oneMenuId,twoMenuId,keywords);
	});
}

//加载Menu
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
		$("#list_menu").append($option);
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
		var $optionList = $("#list_menu").find("option");
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