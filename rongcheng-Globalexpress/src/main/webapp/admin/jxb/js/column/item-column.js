//0.全局变量 最大页数
var max_page=1;

//0.全局变量 当前页数
var now_page=1;

//批量归类/单独归类
var glType = 0;

$(function(){
	
	//1.点击选择分类，加载栏目
	$(".change_column").click(selectBlockChannel);
	
	//2.监听点击选择分类下的内容，获取ID
	$(".change_column_box").on("click", "li", selectBlockChannelUl);
	
	//3.点击批量归类，加载栏目
	
	//4.点击小红×，关闭
	$(".change_column_box").on("click", ".change_column_del", changeColumnDel);
});

/**
 * 4.点击小红×，关闭
 * @returns
 * @author 赵滨
 */
function changeColumnDel() {
	//隐藏
	$(".change_column_box").css("display","");

}

/**
 * 3.点击批量归类，加载栏目
 * @returns
 * @author 赵滨
 */
function recommendBtn(GLType,id,piLiangGuiLeiType) {
	if(GLType == 0){
		$("#saveOrDeleteGuiLei").html("单条归类到：");
	}else if (GLType == 1 && piLiangGuiLeiType == 1) {
		$("#saveOrDeleteGuiLei").html("批量归类到：");
	} else if (GLType == 1 && piLiangGuiLeiType == 2) {
		$("#saveOrDeleteGuiLei").html("清除归类项：");
	}
	piLiangGuiLeiTypeTemp = piLiangGuiLeiType;
	GLTypeTemp = GLType;
	idTemp = id;
	
	$(".recommend_box").css("display","block");
	$(".recommend_content").css("width", "650px");
	
	//获取页面类型
	//var columnType = getCookie("columnType");
	
	//定义参数
	var recordType = [4];
	var keywords = null;
	
	//发送请求，获取页面内容
	$.ajax({
		url : "/admin/column/loadColumn-jxb.do",
		type : "post",
		traditional : true,
		data : {
			"recordType" : recordType,
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
			createBlockChannelBatch(blockChannelList, now_page, rows);
			
			//监听页码点击事件，在这里监听，省去了调去数据库的请求
			$(".recommend").on("click", ".pagelist a", function(){
				var aHtml = $(this).html();
				//判断当前页的值
				if(aHtml=="首页"){
					now_page = 1;
				}else if(aHtml=="上一页"){
					if(now_page>1){
						now_page--;
					}
				}else if(aHtml=="下一页") {
					if(now_page<max_page) {
						now_page++;
					}
				}else if(aHtml=="尾页"){
					now_page = parseInt(max_page);
				}else{
					now_page = parseInt(aHtml);
				}
				//创建栏目
				changeBlockChannelBatch(now_page, rows);
			});
		},
		error : function() {
			alert("栏目列表加载失败");
		}
	});


}

/**
 * 3.1.创建栏目
 * @param blockChannelList 栏目集合
 * @returns
 * @author 赵滨
 */
function createBlockChannelBatch(listBlockChannel, nowPage, rows) {
	
	//复制集合，用于删除内容
	var blockChannelList = listBlockChannel.concat();
	
	//清空页面
	$(".recommend").children().remove();
	
	//定义拼接字符串
	var put = "";
	
	//第一部分 提示信息
	put += '<ul class="table-ul" style="padding-left:0px;">';
	
	put += '<li class="" style="width: 20%"><input type="checkbox" onclick="checkAllColumn(this)">全选</li>';
	put += '<li class="" style="width: 60%">栏目名称</li>';
	put += '<li class="" style="width: 20%">栏目类型</li>';
		
	put += '</ul>';
	//加入页面
	$(".recommend").append(put);
	
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
		
		//创建最上级栏目
		if (blockChannelList[i].parentId == 0) {
			put = "";
			
			//分页显示 如果在显示范围内
			if (now >= start && now <= end) {
				put += '<ul class="table-ul suspension suspensionParent" style="padding-left:0px; cursor: pointer;">';
			} else {
				put += '<ul class="table-ul suspension suspensionParent" style="display:none;">';
			}
			//当前内容是否属于此归类标志
			var flag = false;
			for (var int = 0; int < blockIdList.length; int++) {
				if(blockIdList[int] == blockChannelList[i].id){
					put += '<li style="width: 20%"><input type="checkbox" name="blockChannelId" value="'+
					blockChannelList[i].id+'" checked="checked">';
					flag = true;
				}
			}
			if(!flag){
				put += '<li style="width: 20%"><input type="checkbox" name="blockChannelId" value="'+
				blockChannelList[i].id+'"';
			}
			put += '<span class="column_span1">';
			put += blockChannelList[i].userSequence;	//序号
			put += '</span></li>';
			put += '<li style="width: 60%">';
			put += '<span  class="column_span2"></span>';
			
			//如果没有内容
			if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
				put += '&nbsp;';							//栏目名称
			} else {
				put += blockChannelList[i].blockTitle;		//栏目名称
			}
			
			put += '</li>';
			put += '<li style="width: 20%">';
			
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
			$(".recommend").append($put);
			
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
	//如果超过一万，跳出
	var interceptB = 0;
	
	//省略递归
	while (blockChannelList.length != 0) {
		
		interceptB++;
		//如果超过一万，跳出
		if (interceptB > 9999) {
			break;
		}
		
		//获取页面已经显示的栏目
		var webPageBlockChannelList = $(".recommend").find("ul");
		//如果超过一万，跳出
		var interceptC = 0;
		
		//遍历 需要加载的子栏目
		for (var i = 0; i < blockChannelList.length; i++) {
			
			interceptC++;
			//如果超过一万，跳出
			if (interceptC > 9999) {
				break;
			}
			
			//获取每条的父类ID
			var blockChannelParentId = blockChannelList[i].parentId;
			
			//如果超过一万，跳出
			var interceptD = 0;
			
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
					put += '<li style="width: 20%"><input type="checkbox" name="blockChannelId" value="'+
							blockChannelList[i].id+'"><span class="column_span1">';
					put += blockChannelList[i].userSequence;	//序号
					put += '</span></li>';
					put += '<li  style="width: 60%;padding-left: ';
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
					put += '<li style="width: 20%">';
					
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
	var webPageBlockChannel = $(".recommend").find("ul");
	
	//是否重复数组
	var isepeat = [];
	
	//如果超过一万，跳出
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
			
			//如果超过一万，跳出
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
			
			//如果超过一万，跳出
			var interceptG = 0;
			
			//改变最大一条栏目的样式
			for (var k = 0; k < webPageBlockChannel.length; k++) {

				interceptG++;
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
    put += '<ul style="height: 40px;"><div class="pagelist" style="line-height:1.5;"> ';
    put += '<a href="javascript:void(0)">首页</a><a href="javascript:void(0)">上一页</a> ';
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
    put += '<a href="javascript:void(0)">下一页</a><a href="javascript:void(0)">尾页</a></div></ul>';

    //加入页面
	$(".recommend").append(put);
}


/**
 * 3.2.创建栏目
 * @param blockChannelList 栏目集合
 * @returns
 * @author 赵滨
 */
function changeBlockChannelBatch(nowPage, rows) {
	now_page = nowPage;
	$(".pagelist").empty();
	var put = '';
	put += '<a href="javascript:void(0)">首页</a><a href="javascript:void(0)">上一页</a> ';
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
    put += '<a href="javascript:void(0)">下一页</a><a href="javascript:void(0)">尾页</a>';
    $(".pagelist").append(put);
	
	
	//获取ul
	var suspension = $(".recommend").find(".suspensionParent");
	

	//所有的栏目操作
	for (var i = 0; i < suspension.length; i++) {
		
		if ((nowPage - 1) * rows <= i && i <= (nowPage - 1) * rows + rows - 1) {
			suspension.eq(i).css("display", "block");
			
		} else {
			suspension.eq(i).css("display", "none");
		}
		
	}
	
	
}



/**
 * 2.监听点击选择分类下的内容，获取ID
 * @returns
 * @author 赵滨
 */
function selectBlockChannelUl() {
	blockChannelId = $(this).parent().data("blockChannelId");
	var blockChannelTitle = $(this).parent().data("blockChannelTitle");
	blockChannelTitle = $.isEmptyObject(blockChannelTitle)?"":blockChannelTitle;
	$("#jxb_xzfl").html(blockChannelTitle);
	changeColumnDel();
	loadData(1);
}

/**
 * 1.点击选择分类，加载栏目
 * @returns
 * @author 赵滨
 */
function selectBlockChannel() {

	$(".change_column_box").css("width", "550px");
	
	//获取页面类型
	//var columnType = getCookie("columnType");
	
	//定义参数
	var recordType = [4];
	var keywords = null;
	
	//发送请求，获取页面内容
	$.ajax({
		url : "/admin/column/loadColumn-jxb.do",
		type : "post",
		traditional : true,
		data : {
			"recordType" : recordType,
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
			createBlockChannelAll(blockChannelList, now_page, rows);
			
			//监听页码点击事件，在这里监听，省去了调去数据库的请求
			$(".change_column_box").on("click", ".pagelist a", function(){
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
				//创建栏目
				createBlockChannelAll(blockChannelList, now_page, rows);
			});
		},
		error : function() {
			alert("栏目列表加载失败");
		}
	});

}

/**
 * 1.1.创建栏目
 * @param blockChannelList 栏目集合
 * @returns
 * @author 赵滨
 */
function createBlockChannelAll(listBlockChannel, nowPage, rows) {
	
	//复制集合，用于删除内容
	var blockChannelList = listBlockChannel.concat();
	
	//清空页面
	$(".change_column_box").children().remove();
	
	//定义拼接字符串
	var put = "";
	
	//第一部分 提示信息
	put += '<ul class="table-ul" style="padding-left:0px;">';
	
	put += '<li style="width: 20%" class="">选择</li>';
	put += '<li style="width: 60%" class="">栏目名称</li>';
	put += '<li style="width: 20%" class="">栏目类型</li>';
		
	put += '</ul>';
	//加入页面
	$(".change_column_box").append(put);
	//jiml//////////////////////////////////////
	put = '';
	put += '<ul class="table-ul suspension" style="padding-left:0px; cursor: pointer;"><li style="width: 20%; background-color: rgb(255, 255, 255);"><span class="column_span1">&nbsp;</span></li><li style="width: 60%; background-color: rgb(255, 255, 255);"><span class="column_span2"></span>全部分类</li><li style="width: 20%; background-color: rgb(255, 255, 255);">商品页面</li><div class="table-ul-son"></div></ul>';
	//转换对象
	var $put = $(put);
	//绑定参数
	$put.data("blockChannelId", -1);
	$put.data("blockChannelTitle", "全部分类");
	$(".change_column_box").append($put);
	////////////////////////////////////////
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
		
		//创建最上级栏目
		if (blockChannelList[i].parentId == 0) {
			put = "";
			
			//分页显示 如果在显示范围内
			if (now >= start && now <= end) {
				put += '<ul class="table-ul suspension" style="padding-left:0px; cursor: pointer;">';
			} else {
				put += '<ul class="table-ul suspension" style="display:none;">';
			}
			
			put += '<li style="width: 20%">';
			put += '<span class="column_span1">';
			put += blockChannelList[i].userSequence;	//序号
			put += '</span></li>';
			put += '<li style="width: 60%">';
			put += '<span  class="column_span2"></span>';
			
			//如果没有内容
			if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
				put += '&nbsp;';							//栏目名称
			} else {
				put += blockChannelList[i].blockTitle;		//栏目名称
			}
			
			put += '</li>';
			put += '<li style="width: 20%">';
			
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
			$put.data("blockChannelTitle", blockChannelList[i].blockTitle);
			$put.data("blockChannelParentId", blockChannelList[i].parentId);
			
			//加入页面
			$(".change_column_box").append($put);
			
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
	
	//如果超过一万，跳出
	var interceptB = 0;
	
	//省略递归
	while (blockChannelList.length != 0) {
		
		interceptB++;
		//如果超过一万，跳出
		if (interceptB > 9999) {
			break;
		}
		
		//获取页面已经显示的栏目
		var webPageBlockChannelList = $(".change_column_box").find("ul");
		
		//如果超过一万，跳出
		var interceptC = 0;
		
		//遍历 需要加载的子栏目
		for (var i = 0; i < blockChannelList.length; i++) {
			
			interceptC++;
			//如果超过一万，跳出
			if (interceptC > 9999) {
				break;
			}
			
			//获取每条的父类ID
			var blockChannelParentId = blockChannelList[i].parentId;
			
			//如果超过一万，跳出
			var interceptD = 0;
			
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
					put += '<li style="width: 20%"><span class="column_span1">';
					put += blockChannelList[i].userSequence;	//序号
					put += '</span></li>';
					put += '<li  style="padding-left: ';
					put += 25 * ratio;
					put += 'px;width: 60%">';
					put += '<span class="column_span2">├─</span>';
					
					//如果没有内容
					if (blockChannelList[i].blockTitle == "" || blockChannelList[i].blockTitle == null) {
						put += '&nbsp;';							//栏目名称
					} else {
						put += blockChannelList[i].blockTitle;		//栏目名称
					}
					
					put += '</li>';
					put += '<li style="width: 20%">';
					
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
	
	//如果超过一万，跳出
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
			
			//如果超过一万，跳出
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
			
			//如果超过一万，跳出
			var interceptG = 0;
			
			//改变最大一条栏目的样式
			for (var k = 0; k < webPageBlockChannel.length; k++) {
				
				interceptG++;
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
    put += '<ul style="height: 40px;"><div class="pagelist" style="line-height:1.5;"> ';
    put += '<a href="javascript:void(0)">首页</a><a href="javascript:void(0)">上一页</a> ';
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
    put += '<a href="javascript:void(0)">下一页</a><a href="javascript:void(0)">尾页</a></div></ul>';
	put += '<div class="re_cha change_column_del">×</div>';


    //加入页面
	$(".change_column_box").append(put);
	//5.悬浮栏目，改变背景颜色
	$(".change_column_box").on("mouseover mouseout", ".suspension li", mouseBackground);
}

/**
 * 5.悬浮栏目，改变背景颜色
 * @returns
 * @author 赵滨
 */
function mouseBackground() {

	//鼠标悬浮
	if(event.type == "mouseover"){
		
		//遍历
		for (var i = 0; i < $(this).parent().children().length - 1; i++) {
			//改变每一个li的颜色
			$(this).parent().children().eq(i).css("background-color", "#eee");
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
function checkAllColumn(obj){ 
	if($(obj).is(":checked")){
		$("input[name='blockChannelId']").prop('checked',true);
	}else{
		$("input[name='blockChannelId']").prop('checked',false);
	}
}