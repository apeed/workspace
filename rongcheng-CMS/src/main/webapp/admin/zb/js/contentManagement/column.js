
//0.全局变量 最大页数
var max_page=1;

//0.全局变量 当前页数
var now_page=1;

$(function(){
	
	//1.加载校验
	loadCheckpoint("../");
	
	//2.加载页面
	loadColumn(now_page, getCookie("authorization"), getCookie("ownerId"), getCookie("operatorId"), null);
	
	//3.监听点击'添加栏目'、'添加子栏目'、'修改'
	$("body").on("click", 
			".column_addParent,.column_addChildren,.column_publicParent,.column_publicChildren,.column_delete", 
			columnAddPublic);
	
	//4.点击'批量删除'
	$("#column_batch_del").click(batchDel);
	
	//5.点击'搜索'
	$("#column_search").click(search);
	
	//6.悬浮栏目上，改变背景颜色
	$("#column_table").on("mouseover mouseout", ".suspension li", mouseBackground);
	
	//7.点击单条栏目，选中序号框
	$("#column_table").on("click", "li", clickBlockChannel);
	
	//8.点击序号框，选中
	$("#column_table").on("click", "input[name='checkbox_blockChannel']", clickCheckbox);
});

/**
 * 8.点击序号框，选中
 * @returns
 * @author 赵滨
 */
function clickCheckbox() {
	//是否选中
	var isChecked = $(this).prop("checked");
	//如果选中
	if (isChecked == true) {
		//改变未选中
		$(this).prop("checked", false);
	//否则
	} else {
		//改变选中
		$(this).prop("checked", true);
	}
}

/**
 * 7.点击单条栏目，选中序号框
 * @returns
 * @author 赵滨
 */
function clickBlockChannel() {
	//是否选中
	var isChecked = $(this).parent().find("input[name='checkbox_blockChannel']:first").prop("checked");
	//如果选中
	if (isChecked == true) {
		//改变未选中
		$(this).parent().find("input[name='checkbox_blockChannel']:first").prop("checked", false);
	//否则
	} else {
		//改变选中
		$(this).parent().find("input[name='checkbox_blockChannel']:first").prop("checked", true);
	}
	
}

/**
 * 6.悬浮栏目上，改变背景颜色
 * @returns
 * @author 赵滨
 */
function mouseBackground() {

	//鼠标悬浮
	if(event.type == "mouseover"){
		
		//遍历
		for (var i = 0; i < $(this).parent().children().length - 1; i++) {
			//改变每一个li的颜色
			$(this).parent().children().eq(i).css("background-color", "#FCFCFC");
		}
		
	//鼠标离开
	} else if (event.type == "mouseout") {
		
		//遍历
		for (var i = 0; i < $(this).parent().children().length - 1; i++) {
			//改变每一个li的颜色
			$(this).parent().children().eq(i).css("background-color", "#FFF");
			
		}
		//重新添加一级栏目预设背景色
		var ulAll = $("#column_table ul");
		//遍历所有栏目
		for (var i = 0; i < ulAll.length; i++) {
			//如果父类ID是零，说明是一级栏目
			if (ulAll.eq(i).data("blockChannelParentId") == 0) {
				//遍历栏目内的li
				for (var j = 0; j < ulAll.eq(i).children("li").length; j++) {
					ulAll.eq(i).children("li").eq(j).css("background-color", "#FDFDFD");
				}
			}
		}
	}
}

/**
 * 5.点击'搜索'
 * @returns
 * @author 赵滨
 */
function search() {
	//获取关键字
	var keywords = $("input[name='keywords']").val();
	
	//如果没有内容
	if (keywords.trim() == "") {
		keywords = null;
	}
	
	//加载页面
	loadColumn(now_page, getCookie("authorization"), getCookie("ownerId"), getCookie("operatorId"), keywords);
}

/**
 * 4.点击'批量删除'
 * @returns
 * @author 赵滨
 */
function batchDel() {
	
	//获取栏目集合
	var blockChannelList = $("#column_table input[name='checkbox_blockChannel']:checked");
	
	//定义栏目id数组
	var blockChannelId = [];
	//遍历
	for (var i = 0; i < blockChannelList.length; i++) {
		//加入数组中
		blockChannelId.push(blockChannelList.eq(i).parent().parent().data("blockChannelId"));
	}
	
	//如果没有栏目订单
	if (blockChannelId.length == 0) { 
		alert("请选择订单");
		return;
	}
	
	if (confirm("您确定要批量删除吗?")) { 
		//获取参数
		var authorization = getCookie("authorization");
		var ownerId = getCookie("ownerId");
		var operatorId = getCookie("operatorId");
		
		//发送请求，批量删除栏目
		$.ajax({
			url : path+"/column/removeBlockChannel.do",
			type : "post",
			traditional : true,
			data : {
				"blockChannelId" : blockChannelId,
				"authorization" : authorization,
				"ownerId" : ownerId,
				"operatorId" : operatorId
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var row = result.data;
					//如果删除的行数，不是0行
					if (row !=0 ) {
						alert("删除成功!");
						//加载页面
						loadColumn(now_page, getCookie("authorization"), getCookie("ownerId"), 
								getCookie("operatorId"));
					} else {
						alert("删除中失败!");
					}
				} else if (result.state == 1) {
					alert(result.message);
				}
			},
			error : function() {
				alert("删除失败!");
			}
		});
	}
}

/**
 * 3.监听点击'添加栏目'、'添加子栏目'、'修改'
 * @returns
 * @author 赵滨
 */
function columnAddPublic() {
	console.log($(this).parent().parent());
	
	//是否选中
	var isChecked = $(this).parent().parent().parent().find("input[name='checkbox_blockChannel']:first").prop("checked");
	
	//如果选中
	if (isChecked == true) {
		//改变未选中
		$(this).parent().parent().parent().find("input[name='checkbox_blockChannel']:first").prop("checked", false);
	//否则
	} else {
		//改变选中
		$(this).parent().parent().parent().find("input[name='checkbox_blockChannel']:first").prop("checked", true);
	}
	
	//定义栏目ID
	var blockChannelId = null;
	
	//定义父类ID
	var blockChannelParentId = null;
	
	//定义按钮类型
	var buttonType = null;
	
	//定义页面类型
	var columnType = getCookie("columnType");
	
	//如果是添加栏目
	if ($(this).prop("class").includes('column_addParent')) {
		//赋值
		blockChannelId = 0;
		blockChannelParentId = 0;
		
		//如果是栏目页面
		if (columnType == "column") {
			buttonType = "column_addParent";
			
		//如果是类目页面
		} else if (columnType == "type") {
			buttonType = "type_addParent";
			
		}
		
	//如果是添加子栏目
	} else if ($(this).prop("class").includes('column_addChildren')) {
		//赋值
		blockChannelId = 0;
		blockChannelParentId = $(this).parent().parent().parent().data("blockChannelId");
		
		//如果是栏目页面
		if (columnType == "column") {
			buttonType = "column_addChildren";
			
		//如果是类目页面
		} else if (columnType == "type") {
			buttonType = "type_addChildren";
			
		}
		
	//如果是修改栏目
	} else if ($(this).prop("class").includes('column_publicParent')) {
		//赋值
		blockChannelId = $(this).parent().parent().parent().data("blockChannelId");
		blockChannelParentId = 0;

		//如果是栏目页面
		if (columnType == "column") {
			buttonType = "column_publicParent";
			
		//如果是类目页面
		} else if (columnType == "type") {
			buttonType = "type_publicParent";
			
		}
		
	//如果是修改子栏目
	} else if ($(this).prop("class").includes('column_publicChildren')) {
		//赋值
		blockChannelId = $(this).parent().parent().parent().data("blockChannelId");
		blockChannelParentId = $(this).parent().parent().parent().data("blockChannelParentId");

		//如果是栏目页面
		if (columnType == "column") {
			buttonType = "column_publicChildren";
			
		//如果是类目页面
		} else if (columnType == "type") {
			buttonType = "type_publicChildren";
			
		}
		
	//如果是删除栏目
	} else if ($(this).prop("class").includes('column_delete')) {
		
		if (confirm("您确定要删除吗?")) { 
			//获取参数
			var authorization = getCookie("authorization");
			var ownerId = getCookie("ownerId");
			var operatorId = getCookie("operatorId");
			//赋值
			blockChannelId = $(this).parent().parent().parent().data("blockChannelId");
			
			//发送请求，删除栏目
			$.ajax({
				url : path+"/column/removeBlockChannel.do",
				type : "post",
				data : {
					"blockChannelId" : blockChannelId,
					"authorization" : authorization,
					"ownerId" : ownerId,
					"operatorId" : operatorId
				},
				dataType : "json",
				success : function(result) {
					if (result.state == 0) {
						var row = result.data;
						//如果删除的行数，不是0行
						if (row !=0 ) {
							alert("删除成功!");
							//加载页面
							loadColumn(now_page, getCookie("authorization"), getCookie("ownerId"), 
									getCookie("operatorId"));
						} else {
							alert("删除中失败!");
						}
					} else if (result.state == 1) {
						alert(result.message);
					}
				},
				error : function() {
					alert("删除失败!");
				}
			});
		}

		return;
	}
	
	//加入cookie
	addCookie("blockChannelId", blockChannelId);
	addCookie("blockChannelParentId", blockChannelParentId);
	addCookie("buttonType", buttonType);
	
	//跳转页面
	window.location.href = "/admin/columnAddPublic.do";
}

/**
 * 2.加载页面
 * @returns
 * @author 赵滨
 */
function loadColumn(nowPage, authorization, ownerId, operatorId, keywords) {
	
	//获取页面类型
	var columnType = getCookie("columnType");
	
	//定义参数
	var recordType = null;

	//如果是栏目页面
	if (columnType == "column") {
		//绑定
		recordType = [1, 2, 3];
		
		//修改列表
		$(".icon-reorder").html(" 栏目列表");
		
		//修改添加
		$(".icon-plus-square-o").html(" 添加栏目");
		
		//修改提示
		$("#column_prompt").html("注：添加栏目后，需将相关内容推荐至此栏目中，然后在web页添加相应栏目框架，" +
				"并将栏目框架和此栏目内容连接后方可在web页显示。");
		
		//修改搜索关键字
		$("#column_search_keywords").prop("placeholder", "请输入搜索关键字");
		
	} else if (columnType == "type") {
		//绑定
		recordType = [4];
		
		//修改列表
		$(".icon-reorder").html(" 类目列表");
		
		//修改添加
		$(".icon-plus-square-o").html(" 添加类目");
		
		//修改提示
		$("#column_prompt").html("注：添加类目后，需将相关内容推荐至此类目中，然后在web页添加相应类目框架，" +
				"并将类目框架和此类目内容连接后方可在web页显示。");
		
		//修改搜索关键字
		$("#column_search_keywords").prop("placeholder", "可输入栏目标题/子标题/简介/标签/备注信息");
		
	}
	
	
	//发送请求，获取页面内容
	$.ajax({
		url : path+"/column/loadColumn.do",
		type : "post",
		traditional : true,
		data : {
			"recordType" : recordType,
			"authorization" : authorization,
			"ownerId" : ownerId,
			"operatorId" : operatorId,
			"keywords" : keywords
		},
		dataType : "json",
		success : function(result) {
			//接受栏目集合
			var map = result.data
			
			//获取显示行数
			var rows = map.rows;
			
			//获取栏目集合
			var blockChannelList = map.blockChannelList;
			
			//如果是没有关键字
			if (keywords == null) {
				//创建栏目
				createBlockChannelAll(blockChannelList, nowPage, rows);
			} else {
				//创建栏目
				createBlockChannelKeywords(blockChannelList, nowPage, rows);
			}
			
			
			//监听页码点击事件，在这里监听，省去了调去数据库的请求
			$("#column_table").on("click", ".pagelist a", function(){
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
					now_page = parseInt(aHtml);
				}
				//如果是没有关键字
				if (keywords == null) {
					//创建栏目
					createBlockChannelAll(blockChannelList, now_page, rows);
				} else {
					//创建栏目
					createBlockChannelKeywords(blockChannelList, now_page, rows);
				}
			});
		},
		error : function() {
			alert("栏目列表加载失败");
		}
	});
}

/**
 * 2.1.创建栏目
 * @param blockChannelList 栏目集合
 * @returns
 * @author 赵滨
 */
function createBlockChannelAll(listBlockChannel, nowPage, rows) {
	
	//获取页面类型
	var columnType = getCookie("columnType");
	
	//复制集合，用于删除内容
	var blockChannelList = listBlockChannel.concat();
	
	//清空页面
	$("#column_table").children().remove();
	
	//定义拼接字符串
	var put = "";
	
	//第一部分 提示信息
	put += '<ul class="table-ul" style="padding-left:0px;">';
	put += '<li class="">序号</li>';
	
	//如果是栏目页面
	if (columnType == "column") {
		put += '<li class="">栏目名称</li>';
		put += '<li class="">栏目类型</li>';
		
	//如果是类目页面
	} else if (columnType == "type") {
		put += '<li class="">类目名称</li>';
		put += '<li class="">类目类型</li>';
		
	}
	
	put += '<li class="">备注</li>';
	put += '<li class="">操作</li>';
	put += '</ul>';
	//加入页面
	$("#column_table").append(put);
	
	put = "";
	
	//定义开始位置
	var start = (nowPage - 1) * rows;
	//定义结束位置
	var end = (nowPage * rows) - 1;
	//定义当前位置
	var now = 0;
	
	//拦截大于一万的循环，防止页面崩溃
	var interceptA = 0;
	
	//第二部分 创建栏目
	for (var i = 0; i < blockChannelList.length; i++) {
		
		interceptA++;
		//如果超过一万，跳出
		if (interceptA > 9999) {
			break;
		}
		
		//创建最上级栏目
		if (blockChannelList[i].parentId == 0) {
			put = "";
			
			//分页显示 如果在显示范围内
			if (now >= start && now <= end) {
				put += '<ul class="table-ul suspension" style="padding-left:0px; cursor: pointer;">';
			} else {
				put += '<ul class="table-ul suspension" style="display:none;">';
			}
			
			put += '<li style="background-color: #FDFDFD;">';
			put += '<input type="checkbox" name="checkbox_blockChannel" style="cursor: pointer;"/>';
			put += '<span class="column_span1">';
			put += blockChannelList[i].userSequence;	//序号
			put += '</span></li>';
			put += '<li style="background-color: #FDFDFD;">';
			put += '<span  class="column_span2"></span>';
			
			//如果没有内容
			if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
				put += '&nbsp;';							//栏目名称
			} else {
				put += blockChannelList[i].blockTitle;		//栏目名称
			}
			
			put += '</li>';
			put += '<li style="background-color: #FDFDFD;">';

			//栏目类型
			var recordType = blockChannelList[i].recordType;
			//根据情况显示内容
			if (recordType == 1) {
				put += '导航区';
			} else if (recordType == 2) {
				put += '轮播区';
			} else if (recordType == 3) {
				put += '视频区';
			} else if (recordType == 4) {
				put += '商品页面';
			}
					
			put += '</li>';
			put += '<li style="background-color: #FDFDFD;">';
			
			//如果没有内容
			if (blockChannelList[i].note == null || blockChannelList[i].note == "") {
				put += '&nbsp;';							//备注
			} else {
				put += blockChannelList[i].note;			//备注
			}
			
			put += '</li>';
			put += '<li style="background-color: #FDFDFD;">';
			put += '<div class="button-group">';
			put += '<a type="button" class="button border-main column_publicParent" href="javascript:void(0)"><span class="icon-edit">修改</span></a>';
			put += '<a class="button border-red column_delete" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a>';
			put += '<a class="button border-yellow column_addChildren" href="javascript:void(0)"><span class="icon-plus-square-o">添加子栏目</span></a>';
			put += '</div>';
			put += '</li>';
			put += '<div class="table-ul-son">';
			put += '</div>';
			put += '</ul>';
			
			//转换对象
			var $put = $(put);
			
			//绑定参数
			$put.data("blockChannelId", blockChannelList[i].id);
			$put.data("blockChannelParentId", blockChannelList[i].parentId);
			
			//加入页面
			$("#column_table").append($put);
			
			//删除
			blockChannelList.splice(i, 1);
			
			i--;
			now++;
		}
	}

	//获取最大页数
	max_page = Math.ceil(now / rows);
	
	put = "";
	
	//缩进系数
	var ratio = 1;
	
	//拦截大于一万的循环，防止页面崩溃
	var interceptB = 0;
	
	//省略递归
	while (blockChannelList.length != 0) {
	
		interceptB++;
		//如果超过一万，跳出
		if (interceptB > 9999) {
			break;
		}
		
		//拦截大于一万的循环，防止页面崩溃
		var interceptC = 0;
		
		//获取页面已经显示的栏目
		var webPageBlockChannelList = $("#column_table").find("ul");
		
		//遍历 需要加载的子栏目
		for (var i = 0; i < blockChannelList.length; i++) {
			
			interceptC++;
			//如果超过一万，跳出
			if (interceptC > 9999) {
				break;
			}
			
			//拦截大于一万的循环，防止页面崩溃
			var interceptD = 0;
			
			//获取每条的父类ID
			var blockChannelParentId = blockChannelList[i].parentId;
			
			//遍历 已经显示的栏目
			for (var j = 0; j < webPageBlockChannelList.length; j++) {

				interceptD++;
				//如果超过一万，跳出
				if (interceptD > 9999) {
					break;
				}
				
				//获取每条ID
				var webPageBlockChannelId = webPageBlockChannelList.eq(j).data("blockChannelId");
				
				//判断是否匹配 子类的父类ID 等于 父类的ID
				if (blockChannelParentId == webPageBlockChannelId) {
					put = "";
					
					put += '<ul>';
					put += '<li><input type="checkbox" name="checkbox_blockChannel"/><span class="column_span1">';
					put += blockChannelList[i].userSequence;	//序号
					put += '</span></li>';
					put += '<li  style="padding-left: ';
					put += 25 * ratio;
					put += 'px;">';
					put += '<span class="column_span2">├─</span>';
					
					//如果没有内容
					if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
						put += '&nbsp;';							//栏目名称
					} else {
						put += blockChannelList[i].blockTitle;		//栏目名称
					}
					
					put += '</li>';
					put += '<li>';

					//栏目类型
					var recordType = blockChannelList[i].recordType;
					//根据情况显示内容
					if (recordType == 1) {
						put += '导航区';
					} else if (recordType == 2) {
						put += '轮播区';
					} else if (recordType == 3) {
						put += '视频区';
					} else if (recordType == 4) {
						put += '商品页面';
					}
							
					put += '</li>';
					put += '<li>';

					//如果没有内容
					if (blockChannelList[i].note == null || blockChannelList[i].note == "") {
						put += '&nbsp;';							//备注
					} else {
						put += blockChannelList[i].note;			//备注
					}
					put += '</li>';
					put += '<li>';
					put += '<div class="button-group">';
					put += '<a type="button" class="button border-main column_publicChildren" href="javascript:void(0)"><span class="icon-edit">修改</span></a>';
					put += '<a class="button border-red column_delete" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a>';
					put += '<a class="button border-yellow column_addChildren" href="javascript:void(0)"><span class="icon-plus-square-o">添加子栏目</span> </a>';
					put += '</div>';
					put += '</li>';
					put += '<div class="table-ul-son">';
					put += '</div>';
					put += '</ul>';
					
					//转换对象
					var $put = $(put);
					
					//绑定参数
					$put.data("blockChannelId", blockChannelList[i].id);
					$put.data("blockChannelParentId", blockChannelList[i].parentId);
					
					//加入页面
					webPageBlockChannelList.eq(j).find(".table-ul-son:first").append($put);
					
					//删除
					blockChannelList.splice(i, 1);
					
					//删除后，取消i自增
					i--;
					
					break;
				}
			}
		}
		
		//系数自增
		ratio++;
	}
	
	//获取页面栏目
	var webPageBlockChannel = $("#column_table").find("ul:not(:first)");
	
	//是否重复数组
	var isepeat = [];
	
	//拦截大于一万的循环，防止页面崩溃
	var interceptE = 0;
	
	//遍历页面栏目	把结尾├─改成└─
	for (var i = 0; i < webPageBlockChannel.length; i++) {
		
		interceptE++;
		//如果超过一万，跳出
		if (interceptE > 9999) {
			break;
		}
		
		//获取每条父类id
		var blockChannelParentId = webPageBlockChannel.eq(i).data("blockChannelParentId");
		
		//如果这条栏目的父类ID是第一次使用
		if ($.inArray(blockChannelParentId, isepeat) == -1) {
			//加入数组
			isepeat.push(blockChannelParentId);

			//定义同类，存储序号最大值
			var identical = null;
			
			//定义需要修改的ID
			var blockChannelId = null;
			
			//拦截大于一万的循环，防止页面崩溃
			var interceptF = 0;
			
			//查找当前父类ID的最大一条栏目
			for (var j = 0; j < webPageBlockChannel.length; j++) {
				
				interceptF++;
				//如果超过一万，跳出
				if (interceptF > 9999) {
					break;
				}
				
				//如果父类ID相同
				if (webPageBlockChannel.eq(j).data("blockChannelParentId") == blockChannelParentId) {
					
					//获取序号
					var webPageBlockChannelUserSequence = webPageBlockChannel.eq(j).find(".column_span1:first").html();
					
					//如果同类为空
					if (identical == null) {
						//同类赋值
						identical = webPageBlockChannelUserSequence;
						//ID赋值
						blockChannelId = webPageBlockChannel.eq(j).data("blockChannelId");
					}
					//如果当前序号大于同类序号
					if (webPageBlockChannelUserSequence > identical) {
						//同类赋值
						identical = webPageBlockChannelUserSequence;
						//ID赋值
						blockChannelId = webPageBlockChannel.eq(j).data("blockChannelId");
					}
					//如果当前序号等于同类序号
					if (webPageBlockChannelUserSequence == identical) {
						
						//如果当前ID大于修改ID
						if (webPageBlockChannel.eq(j).data("blockChannelId") > blockChannelId) {
							//ID赋值
							blockChannelId = webPageBlockChannel.eq(j).data("blockChannelId");
						}
					}
					//类型转换,方式String类型的不准确
					identical = parseInt(identical);
					blockChannelId = parseInt(blockChannelId);
				}
			}
			
			//拦截大于一万的循环，防止页面崩溃
			var interceptG = 0;
			interceptG++;
			
			//改变最大一条栏目的样式
			for (var k = 0; k < webPageBlockChannel.length; k++) {
				
				//如果超过一万，跳出
				if (interceptG > 9999) {
					break;
				}
				
				//如果找到需要更改的ID
				if (blockChannelId == webPageBlockChannel.eq(k).data("blockChannelId")) {
					
					//如果这个内容是├─
					if (webPageBlockChannel.eq(k).find(".column_span2:first").html() == "├─") {
						//更改
						webPageBlockChannel.eq(k).find(".column_span2:first").html("└─");
					}
				}
			}
		}
	}
	
	put = "";
	
	//第三部分 创建页码

	//开始部分
    put += '<div class="pagelist"><a href="javascript:void(0)">首页</a><a href="javascript:void(0)">上一页</a> ';
    //中间部分
    if (max_page > 5) {
        //如果是页码前两个
        if (now_page <= 3) {
            //循环前三页码
            for (var i = 1; i < 4; i++) {
                
                //如果选中当前页码，则变成蓝色背景
                if(i==now_page){
                    put += '<span class="current" style="cursor:default">';
                    put += i;
                    put += '</span>';
                    
                //否则页码为白色背景
                }else{
                    put += '<a href="javascript:void(0)">';
                    put += i;
                    put += '</a>';
                }
            }
            //写出最后两个
            put += '<a href="javascript:void(0)">';
            put += 4;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += 5;
            put += '</a>……';
            
        //如果是页码最中间
        } else if (now_page >= 4 && now_page <= max_page - 3) {
            //页码前两个
            put += '……<a href="javascript:void(0)">';
            put += now_page - 2;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += now_page - 1;
            put += '</a>';
            
            //页码中间选中的
            put += '<span class="current" style="cursor:default">';
            put += now_page;
            put += '</span>';
            
            //页码后两个
            put += '<a href="javascript:void(0)">';
            put += now_page + 1;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += now_page + 2;
            put += '</a>……';
        //如果是页码后两个
        } else if (now_page > max_page - 3) {
            //页码前两个
            put += '……<a href="javascript:void(0)">';
            put += max_page - 4;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += max_page - 3;
            put += '</a>';
            
            //循环后三页
            for (var i = max_page - 2; i <= max_page; i++) {
                //如果选中当前页码，则变成蓝色背景
                if(i==now_page){
                    put += '<span class="current" style="cursor:default">';
                    put += i;
                    put += '</span>';
                    
                //否则页码为白色背景
                }else{
                    put += '<a href="javascript:void(0)">';
                    put += i;
                    put += '</a>';
                }
            }
        }
    
    //否则页数小于5页
    } else {
        var i = 1;
        //循环页码
        while (i <= max_page) {
            //如果选中当前页码，则变成蓝色背景
            if(i==now_page){
                put += '<span class="current" href="javascript:void(0)" style="cursor:default">';
                put += i;
                put += '</span>';
                
            //否则页码为白色背景
            }else{
                put += '<a href="javascript:void(0)">';
                put += i;
                put += '</a>';
            }
            i++;
        }
    }

    //结束部分
    put += '<a href="javascript:void(0)">下一页</a><a href="javascript:void(0)">尾页</a></div>';

    //加入页面
	$("#column_table").append(put);
}

/**
 * 2.2.创建栏目
 * @returns
 * @author 赵滨
 */
function createBlockChannelKeywords(blockChannelList, nowPage, rows) {

	//清空页面
	$("#column_table").children().remove();
	
	//定义拼接字符串
	var put = "";
	
	//第一部分 提示信息
	put += '<ul class="table-ul" style="padding-left:0px;">';
	put += '<li class="">序号</li>';
	put += '<li class="">栏目名称</li>';
	put += '<li class="">栏目类型</li>';
	put += '<li class="">备注</li>';
	put += '<li class="">操作</li>';
	put += '</ul>';
	//加入页面
	$("#column_table").append(put);
	
	put = "";
	
	//定义开始位置
	var start = (nowPage - 1) * rows;
	//定义结束位置
	var end = (nowPage * rows) - 1;
	//定义当前位置
	var now = 0;
	
	//如果超过一万，跳出
	var interceptA = 0;
	
	//第二部分 创建栏目
	for (var i = 0; i < blockChannelList.length; i++) {
		
		interceptA++;
		//如果超过一万，跳出
		if (interceptA > 9999) {
			break;
		}
		
		put = "";
		
		//分页显示 如果在显示范围内
		if (now >= start && now <= end) {
			put += '<ul class="table-ul" style="padding-left:0px; cursor: pointer;">';
		} else {
			put += '<ul class="table-ul" style="display:none;">';
		}
		
		put += '<li><input type="checkbox" name="checkbox_blockChannel"/>';
		put += '<span class="column_span1">';
		put += blockChannelList[i].userSequence;	//序号
		put += '</span></li>';
		put += '<li>';
		put += '<span class="column_span2"></span>';
		
		//如果没有内容
		if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
			put += '&nbsp;';							//栏目名称
		} else {
			put += blockChannelList[i].blockTitle;		//栏目名称
		}		
		
		put += '</li>';
		put += '<li>';
		
		//栏目类型
		var recordType = blockChannelList[i].recordType;
		//根据情况显示内容
		if (recordType == 1) {
			put += '导航区';
		} else if (recordType == 2) {
			put += '轮播区';
		} else if (recordType == 3) {
			put += '视频区';
		} else if (recordType == 4) {
			put += '商品页面';
		}
				
		put += '</li>';
		put += '<li>';
		
		//如果没有内容
		if (blockChannelList[i].note == null || blockChannelList[i].note == "") {
			put += '&nbsp;';							//备注
		} else {
			put += blockChannelList[i].note;			//备注
		}
				
		put += '</li>';
		put += '<li>';
		put += '<div class="button-group">';
		put += '<a type="button" class="button border-main column_publicParent" href="javascript:void(0)"><span class="icon-edit">修改</span></a>';
		put += '<a class="button border-red column_delete" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a>';
		put += '<a class="button border-yellow column_addChildren" href="javascript:void(0)"><span class="icon-plus-square-o">添加子栏目</span></a>';
		put += '</div>';
		put += '</li>';
		put += '<div class="table-ul-son">';
		put += '</div>';
		put += '</ul>';
		
		//转换对象
		var $put = $(put);
		
		//绑定参数
		$put.data("blockChannelId", blockChannelList[i].id);
		$put.data("blockChannelParentId", blockChannelList[i].parentId);
		
		//加入页面
		$("#column_table").append($put);
		
		now++;
	
	}

	//获取最大页数
	max_page = Math.ceil(now / rows);
	
	//获取页面栏目
	var webPageBlockChannel = $("#column_table").find("ul:not(:first)");
	
	
	
	put = "";
	
	//第三部分 创建页码

	//开始部分
    put += '<div class="pagelist"><a href="javascript:void(0)">首页</a><a href="javascript:void(0)">上一页</a> ';
    //中间部分
    if (max_page > 5) {
        //如果是页码前两个
        if (now_page <= 3) {
            //循环前三页码
            for (var i = 1; i < 4; i++) {
                
                //如果选中当前页码，则变成蓝色背景
                if(i==now_page){
                    put += '<span class="current" style="cursor:default">';
                    put += i;
                    put += '</span>';
                    
                //否则页码为白色背景
                }else{
                    put += '<a href="javascript:void(0)">';
                    put += i;
                    put += '</a>';
                }
            }
            //写出最后两个
            put += '<a href="javascript:void(0)">';
            put += 4;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += 5;
            put += '</a>……';
            
        //如果是页码最中间
        } else if (now_page >= 4 && now_page <= max_page - 3) {
            //页码前两个
            put += '……<a href="javascript:void(0)">';
            put += now_page - 2;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += now_page - 1;
            put += '</a>';
            
            //页码中间选中的
            put += '<span class="current" style="cursor:default">';
            put += now_page;
            put += '</span>';
            
            //页码后两个
            put += '<a href="javascript:void(0)">';
            put += now_page + 1;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += now_page + 2;
            put += '</a>……';
        //如果是页码后两个
        } else if (now_page > max_page - 3) {
            //页码前两个
            put += '……<a href="javascript:void(0)">';
            put += max_page - 4;
            put += '</a>';
            put += '<a href="javascript:void(0)">';
            put += max_page - 3;
            put += '</a>';
            
            //循环后三页
            for (var i = max_page - 2; i <= max_page; i++) {
                //如果选中当前页码，则变成蓝色背景
                if(i==now_page){
                    put += '<span class="current" style="cursor:default">';
                    put += i;
                    put += '</span>';
                    
                //否则页码为白色背景
                }else{
                    put += '<a href="javascript:void(0)">';
                    put += i;
                    put += '</a>';
                }
            }
        }
    
    //否则页数小于5页
    } else {
        var i = 1;
        //循环页码
        while (i <= max_page) {
            //如果选中当前页码，则变成蓝色背景
            if(i==now_page){
                put += '<span class="current" href="javascript:void(0)" style="cursor:default">';
                put += i;
                put += '</span>';
                
            //否则页码为白色背景
            }else{
                put += '<a href="javascript:void(0)">';
                put += i;
                put += '</a>';
            }
            i++;
        }
    }

    //结束部分
    put += '<a>下一页</a><a">尾页</a></div>';

    //加入页面
	$("#column_table").append(put);

}
