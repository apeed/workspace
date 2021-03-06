//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
$(document).ready(function(){
	setTimeout(loadReview(1), 500)
	$(".modify_reviewList").click(modifyReviewList);
	$("#review_table").on("click",".addReview_btn",addReviewBtn);
	$(".noReply").click(noReply);
	
});
function noReply() {
	var id1 = new Array();
	 $("input[name='id1']:checked").each(function(){
		 id1.push($(this).val());
	 });
//	 console.log(id1);  没有给它设具体的值
		$.ajax({
			url:"/admin/updateUserRemarks.do",
			type:"post",
			dataType:"json",
			data:$('#fm1').serialize(),
			 success:function(result){
				if(result.state==0){
					alert("保存成功！"); 	
					window.location.href ="review.do";					
				}
			},
			error:function(){
				alert("保存失败！"); 
			}
		});
}
function addReviewBtn(){
	var $tr = $(this).parent().parent().parent();
	var id = $tr.data("rid");
	var itemSku=$tr.data("itemSku");
	var accountNum = $tr.data("accountNum");
	var operatorId=$tr.data("operatorId");
	addCookie("accountNum", accountNum);
	addCookie("rid", id, 1);
	addCookie("itemSku", itemSku, 1);
	addCookie("operatorId", operatorId);
//	console.log(getCookie("itemSku"));
}
function modifyReviewList() {
	var id1 = new Array();
	 $("input[name='id1']:checked").each(function(){
		 id1.push($(this).val());
	 });
//	 console.log(id1);  没有给它设具体的值
		$.ajax({
			url:"/admin/modifyUserRemarks.do",
			type:"post",
			dataType:"json",
			data:$('#fm1').serialize(),
			 success:function(result){
				if(result.state==0){
					alert("保存成功！"); 	
					window.location.href ="review.do";					
				}
			},
			error:function(){
				alert("保存失败！"); 
			}
		});
	
}
function changesearch() {
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "/admin/findListByUserRemark.do",
		type : "post",
		data : {
			"keyword" : keywords
		},
		dataType : "json",
		success : function(result) {
			var list=result.data;
			reload(list);
			console.log(list);
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
}

function loadReview(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/loadList_book1.do",
		type : "post",
		data : {
			"page" : page
		},
		dataType : "json",
		success : function(result) {
			max_page = result.message;
//			console.log(result);
			var list=result.data;
			reload(list);
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
	}
function reload(list) {
	var bookTable = $("#review_table");
	bookTable.empty();
	var sa="";
	sa+='<tr>';
	sa+='<th style="padding-left:20px;">序号</th>';
	sa+='<th>商品编号</th>';
	sa+='<th>评论人</th>';
	sa+='<th width="200">评论内容</th>';
	sa+='<th>评论类型</th>';
	sa+='<th>评论时间</th>';
	sa+='<th>是否显示</th>';
	sa+='<th>备注</th>';
	sa+='<th width="100">操作</th>';
	sa+='<tr>';
	$("#review_table").append(sa);
	for(var i=0;i<list.length;i++){
		var UserRemark = list[i];
		var id = UserRemark.id;
		var userSequence = UserRemark.userSequence;
		var contentType = list[i].contentType;
		var itemSku =UserRemark.itemSku;
		var contentId = UserRemark.contentId;
		var accountNum = UserRemark.accountNum;
		var userWord = UserRemark.userWord;
		var userWordTime = UserRemark.userWordTime;
		var remarkType = UserRemark.remarkType;
		var show = UserRemark.show;
		var operatorId = UserRemark.operatorId;
		Date.prototype.Format = function (fmt) { //author: meizz 
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		}
		var time = new Date(userWordTime).Format("yyyy/MM/dd hh:mm:ss");
		var note = UserRemark.note;
		var str="";
		str+='<tr>';
		str+='<td style="padding-left:20px;"><input type="checkbox" name="id1" value="'+id+'" />'+userSequence+'</td>';
		str+='<td>'+itemSku+'</td>';
		str+='<td>'+accountNum+'</td>';
		str+='<td><div style="width:200px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;">'+userWord+'</div></td>';
		if(remarkType>6){
			str+='<td>好评</td>';	
		}else if(remarkType>3){
			str+='<td>中评</td>';
		}else if(remarkType>0){
			str+='<td>差评</td>';
		}
		str+='<td>'+time+'</td>';
			if(show==1){
				str+='<td>是</td>';
			}
			if(show==0){
				str+='<td>否</td>';	
			}
		str+='<td>'+note+'</td>';
		str+='<td>';
		str+='<div class="button-group">';
		str+='<a class="button border-main addReview_btn" href="reviewReturn.do"><span class="icon-edit"></span> 回复</a>';
		str+='</div>';
		str+='</td>';
		str+='</tr>';
		//转jquery对象
		var $tr=$(str);
		$tr.data("rid",id);
		$tr.data("accountNum",accountNum);
		$tr.data("itemSku",itemSku);
		$tr.data("operatorId",operatorId);
		$("#review_table").append($tr);
	}
	/////页码////////////
	var trs="";
	trs += '<tr id = "page_tr">';
	trs += '<td colspan="10"><div class="pagelist"><a onclick="loadReview(1)" href="javascript:;">首页</a><a class="bookpage" onclick="loadReview('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadReview('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadReview('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadReview(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadReview(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadReview('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadReview('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadReview('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadReview('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadReview('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadReview('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadReview('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadReview('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadReview('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadReview('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadReview('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadReview('+max_page+')">尾页</a></div></td>';
	trs += '</tr>';
	$("#review_table").append(trs);
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}

		