//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=10;
$(function(){
	loadLogistics(1);
	$(".wlxq_wk").mouseover(fun1);
	$("#logistics_table").on("click",".modify_logistics",modifyLogistics);
});

function changesearch() {
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "/admin/findListByCargoTracking.do",
		type : "post",
		data : {
			"keyword" : keywords
		},
		dataType : "json",
		success : function(result) {
			var list=result.data;
			reload(list);
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
}
function modifyLogistics(){
	var $tr = $(this).parent().parent();
	var id = $tr.data("cid");
	addCookie("cid", id, 1);
//	alert(getCookie("cid"));
}

function fun1() {
	$(".wlxq_nk").css("display","block");
}
function loadLogistics(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/loadList_logistics.do",
		type : "post",
		data : {
			"page" : page
		},
		dataType : "json",
		success : function(result) {
			max_page = result.message;
			var list=result.data;
			reload(list);
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
	}
function reload(list) {
	var logisticsTable = $("#logistics_table");
	logisticsTable.empty();
	var sa="";
	sa+='<tr>';
	sa+='<th style="padding-left:20px;">序号</th>';
	sa+='<th>电商平台</th>';
	sa+='<th>店铺名称</th>';
	sa+='<th>订单号</th>';
	sa+='<th>物流单号</th>';
	sa+='<th>转运公司</th>';
	sa+='<th>转运单号</th>';
	sa+='<th>是否完成</th>';
	sa+='<th width="140">物流状态</th>';
	sa+='<th width="100">操作</th>';
	sa+='<tr>';
	$("#logistics_table").append(sa);
	for(var i=0;i<list.length;i++){
		var CargoTracking = list[i];
		var id = CargoTracking.id;
		var orderId=CargoTracking.orderId;
		var carrierId=CargoTracking.carrierId;
		var trackingNum=CargoTracking.trackingNum;
		var transferCarrierId=CargoTracking.transferCarrierId;
		var transferTrackingNum=CargoTracking.transferTrackingNum;
		var complete=CargoTracking.complete;
		var userTrackingInfo=CargoTracking.userTrackingInfo;
		var platformId=CargoTracking.platformId;
		var shopId=CargoTracking.shopId;
		var str="";
		str+='<tr>';
		str+='<td style="padding-left:20px;">'+id+'</td>';
        str+='<td>'+platformId+'</td>';
		str+='<td>'+shopId+'</td>';
		str+='<td>'+orderId+'</td>';
		str+='<td>'+trackingNum+'</td>';
		var index = $.inArray(transferCarrierId,oftenUseExpress);
		if(transferCarrierId == "EMS"){
			str+='<td>'+transferCarrierId+'</td>';
		}else if(index == -1){
			index = $.inArray(transferCarrierId,allExpress);
			if(index == -1){
				str+='<td>'+transferCarrierId+'</td>';
			}else {
				str+='<td>'+allExpress[index-1]+'</td>';
			}
		}else{
			str+='<td>'+oftenUseExpress[index-1]+'</td>';
		}
		str+='<td>'+transferTrackingNum+'</td>';
		str+='<td>'+complete+'</td>';
		str+='<td>';
		str+='<div class="wlxq_wk">';
		str+='<a class="button border-main" href="javascript:0"><span class="icon-edit"></span> 物流详情</a>';
		if(userTrackingInfo!=null&&userTrackingInfo!=""){
			str+='<div class="wlxq_nk">';
			str+=userTrackingInfo;
			str+='</div>';
		}
		str+='</div>';
		str+='</td>';
		str+='<td>';
		str+='<a class="button border-main modify_logistics" href="logisticsPublic.do"><span class="icon-edit"></span> 修改</a>';
		str+='</td>';
		str+='</tr>';
		//转jquery对象
		var $tr=$(str);
		$tr.data("cid",id);
		$("#logistics_table").append($tr);
	}
	/////页码////////////
	var trs="";
	trs += '<tr id = "page_tr">';
	trs += '<td colspan="10"><div class="pagelist"><a class="current" onclick="loadLogistics(1)" href="javascript:;">首页</a><a class="bookpage" onclick="loadLogistics('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadLogistics('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadLogistics('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadLogistics(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadLogistics(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadLogistics('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadLogistics('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadLogistics('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadLogistics('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadLogistics('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadLogistics('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadLogistics('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadLogistics('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadLogistics('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadLogistics('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadLogistics('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadLogistics('+max_page+')">尾页</a></div></td>';
	trs += '</tr>';
	$("#logistics_table").append(trs);
	//////////////////////////
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}

		