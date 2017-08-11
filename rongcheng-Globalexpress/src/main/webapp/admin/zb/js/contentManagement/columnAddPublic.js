
//0.全局变量，是否已经打开上级栏目
var isOpenParent = false;

$(function(){
	
	//1.加载校验
	loadCheckpoint("../");
	
	//2.加载页面
	loadWebPage();
	
	//3.点击'上传'，显示信息到输出框
	$("#columnAddPublic_myfile").change(upload);
	
	//4.点击'提交'，完成添加栏目
	$("#columnAddPublic_commit").click(columnAddPublicCommit);
	
	//5.点击'上级栏目'框，加载栏目列表
	$(".change_column").click(loadBlockChannel);
	
	//6.监听点击'上级栏目'框后，点击'提交'或'取消'按钮
	$(".change_column_inner").on("click", "button", blockChannelCommitCancel)
	
	//7.悬浮栏目上，改变背景颜色
	$(".change_column_box").on("mouseover mouseout", ".suspension li", mouseBackground);
	
	//8.点击单条栏目，选中序号框
	$(".change_column_box").on("click", ".suspension li", clickBlockChannel);
	
});

/**
 * 8.点击单条栏目，选中序号框
 * @returns
 * @author 赵滨
 */
function clickBlockChannel() {
	//改变未选中
	$(this).parent().find("input[name='radio_blockChannel']:first").prop("checked", true);
	
}

/**
 * 7.悬浮栏目上，改变背景颜色
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
		
	}
}

/**
 * 6.监听点击'上级栏目'框后，点击'提交'或'取消'按钮
 * @returns
 * @author 赵滨
 */
function blockChannelCommitCancel() {
	
	//关闭开关
	isOpenParent = false;
	
	//获取上级栏目ID
	var blockChannelParentId = $("input[name='radio_blockChannel']:checked").parent().parent().data("blockChannelId");
	
	//如果是提交按钮
	if ($(this).prop("id") == "parent_commit") {
		
		//在栏目中显示内容
		$(".change_column").html($("input[name='radio_blockChannel']:checked").parent().parent().find(".column_span3").html());
		
		//添加上级栏目ID
		$(".change_column").data("blockChannelParentId", blockChannelParentId);
	}
	
	//隐藏弹出框
	$(".change_column_box").css("display","none");
}

/**
 * 5.点击'上级栏目'框，加载栏目列表
 * @returns
 * @author 赵滨
 */
function loadBlockChannel() {
	//如果已经打开
	if (isOpenParent == true) {
		return;
	}
	
	//获取页面类型
	var columnType = getCookie("columnType");
	
	//显示弹出框
	$(".change_column_box").css("display","block");
	
	//状态为打开
	isOpenParent = true;
	
	var authorization = getCookie("authorization");
	var ownerId = getCookie("ownerId");
	var operatorId = getCookie("operatorId");
	var keywords = null;
	
	//如果是栏目页面
	if (columnType == "column") {
		//绑定
		recordType = [1, 2, 3, 5];
	} else if (columnType == "type") {
		//绑定
		recordType = [4];
	}
	
	//发送请求，获取页面内容
	$.ajax({
		url : path+"/column/loadColumn.do",
		type : "post",
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
			
			//创建栏目
			createBlockChannelAll(blockChannelList);
			
		},
		error : function() {
			alert("栏目列表加载失败");
		}
	});
}

/**
 * 5.1.创建栏目
 * @param blockChannelList 栏目集合
 * @returns
 * @author 赵滨
 */
function createBlockChannelAll(listBlockChannel) {
	
	//复制集合，用于删除内容
	var blockChannelList = listBlockChannel.concat(); ;
	
	//清空页面
	$(".change_column_box").children().remove();
	
	//定义拼接字符串
	var put = "";
	
	//第一部分 提示信息
	put += '<li class="change_column_fu">';
	put += '<ol>';
	put += '<li>选择</li>';
	put += '<li>栏目名称</li>';
	put += '<li>栏目类型</li>';
	put += '</ol>';
	put += '</li>';
	
	//加入页面
	$(".change_column_box").append(put);
	
	put = "";
	
	//根据当前ID，去找顶级父类ID
	var blockChannelParentId = getCookie("blockChannelParentId");
	
	//定义ID
	var blockChannelId = getCookie("blockChannelId");
	
	//模拟递归  如果父类ID不为零，说明还没有到最顶层
	for (var j = 0; j < 50; j++) {
		//遍历
		for (var i = 0; i < blockChannelList.length; i++) {
			//如果  找到了它的父类
			if (blockChannelList[i].id == blockChannelParentId) {
				//赋值
				blockChannelParentId = blockChannelList[i].parentId;
				blockChannelId = blockChannelList[i].id;
			}
		}
	}
	
	//第二部分 创建栏目
	for (var i = 0; i < blockChannelList.length; i++) {
		//创建最上级栏目
		if (blockChannelList[i].parentId == 0) {
			
			put = "";
			
			//如果 匹配到需要显示的id
			if (blockChannelList[i].id == blockChannelId) {
				put += '<ul class="table-ul suspension" style="padding-left:0px; cursor: pointer;">';
			} else {
				put += '<ul class="table-ul suspension" style="display:none;">';
			}
			
			put += '<li style="width:10%;"><input type="radio" name="radio_blockChannel" style="cursor: pointer;"/>';
			put += '<span class="column_span1">';
			put += blockChannelList[i].userSequence;	//序号
			put += '</span></li>';
			put += '<li style="width: 70%;">';
			put += '<span class="column_span2"></span>';
			put += '<span class="column_span3">';

			//如果没有内容
			if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
				put += '&nbsp;';							//栏目名称
			} else {
				put += blockChannelList[i].blockTitle;		//栏目名称
			}
			
			put += '</span></li>';
			put += '<li style="width: 20%;text-align:center">';

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
			} else if (recordType == 5) {
				put += '首页导航';
			}
					
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
			$(".change_column_box").append($put);
			
			//删除
			blockChannelList.splice(i, 1);
			
			i--;
		}
	}

	put = "";
	
	//缩进系数
	var ratio = 1;
	
	//省略递归
	while (blockChannelList.length != 0) {
		
		//获取页面已经显示的栏目
		var webPageBlockChannelList = $(".change_column_box").find("ul");
		
		//遍历 需要加载的子栏目
		for (var i = 0; i < blockChannelList.length; i++) {
			//获取每条的父类ID
			var blockChannelParentId = blockChannelList[i].parentId;
			
			//遍历 已经显示的栏目
			for (var j = 0; j < webPageBlockChannelList.length; j++) {
				//获取每条ID
				var webPageBlockChannelId = webPageBlockChannelList.eq(j).data("blockChannelId");
				
				//判断是否匹配 子类的父类ID 等于 父类的ID
				if (blockChannelParentId == webPageBlockChannelId) {
					
					put = "";
					
					//获取本条栏目的ID
					var BlockChannelId = getCookie("blockChannelId");
					
					//如果是本条栏目的子栏目，不显示
					if (blockChannelList[i].parentId == BlockChannelId) {
						put += '<ul style="display: none;">';
					} else {
						put += '<ul>';
					}
					
					put += '<li style="width:10%;"><input type="radio" name="radio_blockChannel"/>';
					put += '<span class="column_span1">';
					put += blockChannelList[i].userSequence;	//序号
					put += '</span></li>';
					put += '<li  style="width: 70%; padding-left: ';
					put += 25 * ratio;
					put += 'px;">';
					put += '<span class="column_span2">├─</span>';
					put += '<span class="column_span3">';

					//如果没有内容
					if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
						put += '&nbsp;';							//栏目名称
					} else {
						put += blockChannelList[i].blockTitle;		//栏目名称
					}
					
					put += '</span></li>';
					put += '<li style="width: 20%;text-align:center">';

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
					} else if (recordType == 5) {
						put += '首页导航';
					}
							
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
	var webPageBlockChannel = $(".change_column_box").find("ul");
	
	//是否重复数组
	var isepeat = [];
	
	//遍历页面栏目	把结尾├─改成└─
	for (var i = 0; i < webPageBlockChannel.length; i++) {
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
			
			//查找当前父类ID的最大一条栏目
			for (var j = 0; j < webPageBlockChannel.length; j++) {
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
			
			//改变最大一条栏目的样式
			for (var k = 0; k < webPageBlockChannel.length; k++) {
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
	
	//第三部分 创建按钮

	put += '<li style="margin-bottom:10px;" class="change_column_fu">';
	put += '<button class="button border-black" id="parent_commit" type="button" style="margin-left:10px;">提交</button>';
	put += '<button class="button border-black" id="parent_cancel" type="button" style="margin-left:10px;">取消</button>';
	put += '</li>';


    //加入页面
	$(".change_column_box").append(put);
}


/**
 * 4.点击'提交'，完成添加栏目
 * @returns
 * @author 赵滨
 */
function columnAddPublicCommit() {
	
	//筛选条件
	var ok = true;
	
	//获取按钮类型
	var buttonType = getCookie("buttonType");
	
	//创建返回表单参数
	var data = new FormData($("#columnAddPublic_form")[0]);
	
	//追加主账号ID
	data.append("ownerId",getCookie("ownerId"));
	
	//追加操作人ID
	data.append("operatorId",getCookie("operatorId"));
	
	//追加是否授权
	data.append("authorization",getCookie("authorization"));
	
	//追加栏目ID
	data.append("blockChannelId",getCookie("blockChannelId"));
	
	//获取排序
	var userSequence = $("input[name='userSequence']").val();
	
	//如果排序为空
	if (userSequence == null || userSequence=="") {
		$("input[name='userSequence']").next().html("排序内格式输入错误，不能为空。");
		ok = false;
		
	//如果排序不是数字
	}else if (isNaN(userSequence)) {
		$("input[name='userSequence']").next().html("排序内格式输入错误，必须为正整数。");
		ok = false;
		
	//如果排序不是正整数
	} else if (!/^\d+$/.test(userSequence)) {
		$("input[name='userSequence']").next().html("排序内格式输入错误，必须为正整数。");
		ok = false;
		
	} else if (userSequence > 999999999) {
		$("input[name='userSequence']").next().html("排序内格式输入错误，输入数字过大。");
		ok = false;
		
	} else {
		$("input[name='userSequence']").next().html("");
	}
	
	//标题长度不能超过10个字符
	if ($("input[name='blockTitle']").val().length > 10) {
		$("input[name='blockTitle']").next().html("标题长度不能超过10个字符");
		ok = false;
	} else {
		$("input[name='blockTitle']").next().html("");
	}
	
	//子标题长度不能超过10个字符
	if ($("input[name='blockSubtitle']").val().length > 10) {
		$("input[name='blockSubtitle']").next().html("子标题长度不能超过10个字符");
		ok = false;
	} else {
		$("input[name='blockSubtitle']").next().html("");
	}
	
	//英文标题长度不能超过10个字符
	if ($("input[name='enTitle']").val().length > 20) {
		$("input[name='enTitle']").next().html("英文标题长度不能超过20个字符");
		ok = false;
	} else {
		$("input[name='enTitle']").next().html("");
	}
	
	//跳转链接长度不能超过128个字符
	if ($("input[name='iconDirectLink']").val().length > 128) {
		$("input[name='iconDirectLink']").next().html("跳转链接长度不能超过128个字符");
		ok = false;
	} else {
		$("input[name='iconDirectLink']").next().html("");
	}
	
	//标题简介长度不能超过255个字符
	if ($("textarea[name='blockProfile']").val().length > 255) {
		$("textarea[name='blockProfile']").next().html("标题简介长度不能超过255个字符");
		ok = false;
	} else {
		$("textarea[name='blockProfile']").next().html("");
	}
	
	//标签长度不能超过10个字符
	if ($("input[name='blockLabel']").val().length > 10) {
		$("input[name='blockLabel']").next().html("标签长度不能超过10个字符");
		ok = false;
	} else {
		$("input[name='blockLabel']").next().html("");
	}
	
	//内部分类关键字长度不能超过20个字符
	if ($("input[name='blockKeyword']").val().length > 20) {
		$("input[name='blockKeyword']").next().html("内部分类关键字长度不能超过20个字符");
		ok = false;
	} else {
		$("input[name='blockKeyword']").next().html("");
	}
	
	//备注长度不能超过10个字符
	if ($("input[name='note']").val().length > 10) {
		$("input[name='note']").next().html("备注长度不能超过10个字符");
		ok = false;
	} else {
		$("input[name='note']").next().html("");
	}
	
	//如果是修改子栏目
	if (buttonType == "column_publicChildren" || buttonType == "type_publicChildren") {
		//获取父类ID
		var blockChannelParentId = $(".change_column").data("blockChannelParentId");
		
		//如果没有选择上级栏目
		if (blockChannelParentId == undefined) {
			$(".change_column").parent().next().html("请选择上级栏目");
			ok = false;
		}
		
		//如果选择的上级栏目就是自己
		if (blockChannelParentId == getCookie("blockChannelId")) {
			$(".change_column").parent().next().html("当前栏目不能当作上级栏目");
			ok = false;
		}
		
		//追加父类ID
		data.append("blockChannelParentId", blockChannelParentId);
		
	} else {
		//追加父类ID
		data.append("blockChannelParentId",getCookie("blockChannelParentId"));
	}
	
	//追加按钮类型
	data.append("buttonType",getCookie("buttonType"));
	
	//data.append("参数名",参数值);
	
	//如果筛选通过
	if (ok) {
		//发送请求，添加或修改栏目
		$.ajax({
			url : path + "/columnAddPublic/columnAddPublicCommit.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					if (result.data == 0) {
						alert("栏目提交失败");
					} else if (result.data == 1) {
						alert("栏目成功");
							window.location.href = "column.do";
					}
				} else if (result.state == 1) {
					alert(result.message);
				}
				
			},
			error : function() {
				alert("栏目提交失败");
			}
		});
	}
	
}

/**
 * 3.点击'上传'，显示信息到输出框
 * @returns
 * @author 赵滨
 */
function upload(){
	
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	//显示到页面上
	$("#columnAddPublic_fileName").val(my);
	
}

/**
 * 2.加载页面
 * @returns
 * @author 赵滨
 */
function loadWebPage() {
	//获取主账号ID
	var ownerId = getCookie("ownerId");
	
	//获取操作人ID
	var operatorId = getCookie("operatorId");
	
	//获取是否授权
	var authorization = getCookie("authorization");
	
	//获取栏目ID
	var blockChannelId = getCookie("blockChannelId");
	
	//获取父类ID
	var blockChannelParentId = getCookie("blockChannelParentId");
	
	//获取按钮类型
	var buttonType = getCookie("buttonType");
	
	//如果是添加栏目
	if (buttonType == "column_addParent") {
		//提示
		$("#columnAddPublic_webPageType").html("添加栏目");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").prop("selected", true);
		$("select[name='recordType']").find("option[value='4']").css("display", "none");
		
	//如果是添加子栏目
	} else if (buttonType == "column_addChildren") {
		//提示
		$("#columnAddPublic_webPageType").html("添加子栏目");

		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").prop("selected", true);
		$("select[name='recordType']").find("option[value='4']").css("display", "none");
		
	//如果是修改栏目
	} else if (buttonType == "column_publicParent") {
		//提示
		$("#columnAddPublic_webPageType").html("修改栏目");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").prop("selected", true);
		$("select[name='recordType']").find("option[value='4']").css("display", "none");
		
	//如果是修改子栏目
	} else if (buttonType == "column_publicChildren") {
		//提示
		$("#columnAddPublic_webPageType").html("修改子栏目");
		
		//显示上级栏目
		$("#columnAddPublic_parentBlockChannel").css("display", "block");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").prop("selected", true);
		$("select[name='recordType']").find("option[value='4']").css("display", "none");
		
	//如果是添加类目
	} else if (buttonType == "type_addParent") {
		//提示
		$("#columnAddPublic_webPageType").html("添加类目");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").css("display", "none");
		$("select[name='recordType']").find("option[value='2']").css("display", "none");
		$("select[name='recordType']").find("option[value='3']").css("display", "none");
		$("select[name='recordType']").find("option[value='4']").prop("selected", true);
		$("select[name='recordType']").find("option[value='5']").css("display", "none");
		
	//如果是添加子类目
	} else if (buttonType == "type_addChildren") {
		//提示
		$("#columnAddPublic_webPageType").html("添加子类目");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").css("display", "none");
		$("select[name='recordType']").find("option[value='2']").css("display", "none");
		$("select[name='recordType']").find("option[value='3']").css("display", "none");
		$("select[name='recordType']").find("option[value='4']").prop("selected", true);
		$("select[name='recordType']").find("option[value='5']").css("display", "none");
		
	//如果是修改类目
	} else if (buttonType == "type_publicParent") {
		//提示
		$("#columnAddPublic_webPageType").html("修改类目");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").css("display", "none");
		$("select[name='recordType']").find("option[value='2']").css("display", "none");
		$("select[name='recordType']").find("option[value='3']").css("display", "none");
		$("select[name='recordType']").find("option[value='4']").prop("selected", true);
		$("select[name='recordType']").find("option[value='5']").css("display", "none");
		
	//如果是修改子类目
	} else if (buttonType == "type_publicChildren") {
		//提示
		$("#columnAddPublic_webPageType").html("修改子类目");
		
		//显示上级栏目
		$("#columnAddPublic_parentBlockChannel").css("display", "block");
		
		//隐藏其他类型
		$("select[name='recordType']").find("option[value='1']").css("display", "none");
		$("select[name='recordType']").find("option[value='2']").css("display", "none");
		$("select[name='recordType']").find("option[value='3']").css("display", "none");
		$("select[name='recordType']").find("option[value='4']").prop("selected", true);
		$("select[name='recordType']").find("option[value='5']").css("display", "none");
	}
	
	//定义页面类型
	var recordType = null;
	
	//如果是栏目页面
	if (getCookie("columnType") == "column") {
		recordType = [1, 2, 3];
		
	//如果是类目页面
	} else if (getCookie("columnType") == "type") {
		recordType = [4];
		
	}
	
	//发送请求，加载修改页面,加载排序,加载上级栏目
//	return;
	$.ajax({
		url : path+"/columnAddPublic/loadColumnAddPublic.do",
		type : "post",
		traditional : true,
		data : {
			"recordType" : recordType,
			"blockChannelId" : blockChannelId,
			"blockChannelParentId" : blockChannelParentId,
			"buttonType" : buttonType,
			"authorization" : authorization,
			"ownerId" : ownerId,
			"operatorId" : operatorId
		},
		dataType : "json",
		success : function(result) {
			//接收参数
			var map = result.data;
			
			//获取排序
			var userSequence = map.userSequence;
			
			//获取栏目
			var blockChannel = map.blockChannel;
			
			//加载序号
			$("input[name='userSequence']").val(userSequence+1);
			
			//如果存在栏目对象，说明需要加载栏目
			if (blockChannel != undefined) {
				//加载栏目类型
				$("select[name='recordType']").val(blockChannel.recordType);
				
				//加载栏目标题
				$("input[name='blockTitle']").val(blockChannel.blockTitle);
				
				//加载栏目子标题
				$("input[name='blockSubtitle']").val(blockChannel.blockSubtitle);
				
				//加载栏目英文标题
				$("input[name='enTitle']").val(blockChannel.enTitle);
				
				//得到栏目缩略图
				var iconUrl = blockChannel.iconUrl.replace(/.*(\/|\\)/, ""); 
				//判断
				if (iconUrl=="error") {
					iconUrl="";
					
				} else if(iconUrl=="null") {
					iconUrl="";
					
				}
				
				//加载栏目缩略图
				$("#columnAddPublic_fileName").val(iconUrl);
				
				//加载跳转链接
				$("input[name='iconDirectLink']").val(blockChannel.iconDirectLink);
				
				//加载标题简介
				$("textarea[name='blockProfile']").html(blockChannel.blockProfile);
				
				//加载栏目标签
				$("input[name='blockLabel']").val(blockChannel.blockLabel);
				
				//加载内部分类关键字
				$("input[name='blockKeyword']").val(blockChannel.blockKeyword);
				
				//加载备注
				$("input[name='note']").val(blockChannel.note);
				
				//加载显示
				$(".radio").find("input[value='"+blockChannel.show+"']").click();
				
				//加载序号
				$("input[name='userSequence']").val(blockChannel.userSequence);
			}
		},
		error : function() {
			alert("加载栏目失败");
		}
	});
	
}
