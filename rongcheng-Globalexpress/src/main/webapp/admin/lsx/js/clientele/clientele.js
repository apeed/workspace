//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
$(function(){
	loadClientele(1);
	//监听修改事件
	$("#clientele_table").on("click",".modify_btn",modifyClientelePublic);
});

function changesearch(){
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "/admin/findListByUserInfo.do",
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
function modifyClientelePublic(){
	var $tr = $(this).parent().parent().parent();
	var id = $tr.data("id");
	addCookie("id", id, 1);
//	alert(getCookie("id"));
}
function loadClientele(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/loadList_clientele.do",
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
	var clienteleTable = $("#clientele_table");
	clienteleTable.empty();
	var sa="";
	sa+='<tr>';
	sa+='<th style="padding-left:20px;">序号</th>';
	sa+='<th>客户账号</th>';
	sa+='<th>姓名</th>';
	sa+='<th>电话</th>';
	sa+='<th>地址</th>';
	sa+='<th>账户状态</th>';
	sa+='<th>备注</th>';
	sa+='<th width="180">操作</th>';
	sa+='</tr>';
	$("#clientele_table").append(sa);
	for(var i=0;i<list.length;i++){
		var UserInfo = list[i];
		var id = UserInfo.id;
		var accountNum = UserInfo.accountNum;
		var userName = UserInfo.userName;
		var userTelephone = UserInfo.userTelephone;
		var userAddress = UserInfo.userAddress;
		var accountStatus = UserInfo.accountStatus;
		var note = UserInfo.note;
		var str="";
		str+='<tr>';
		str+='<td style="padding-left:20px;">'+id+'</td>';
		str+='<td>'+accountNum+'</td>';
		str+='<td>'+userName+'</td>';
		str+='<td>'+userTelephone+'</td>';
		str+='<td>'+userAddress+'</td>';
		str+='<td>'+accountStatus+'</td>';
		str+='<td>'+note+'</td>';
		str+='<td>';
		str+='<div class="button-group">';
		str+='<a class="button border-main modify_btn" href="clientelePublic.do"><span class="icon-edit"></span> 修改</a>';
		str+='</div>';
		str+='</td>';
		str+='</tr>';
		//转jquery对象
		var $tr=$(str);
		//把id加到 这条数据上
		$tr.data("id",id);
		$("#clientele_table").append($tr);
	}
	/////页码////////////
	var trs="";
	trs += '<tr id = "page_tr">';
	trs += '<td colspan="10"><div class="pagelist"><a class="current" onclick="loadClientele(1)" href="javascript:;">首页</a><a class="bookpage" onclick="loadClientele('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadClientele('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadClientele('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadClientele(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadClientele(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadClientele('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadClientele('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadClientele('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadClientele('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadClientele('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadClientele('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadClientele('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadClientele('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadClientele('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadClientele('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadClientele('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadClientele('+max_page+')">尾页</a></div></td>';
	trs += '</tr>';
	$("#clientele_table").append(trs);
	//////////////////////////
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}
	
	
		
		