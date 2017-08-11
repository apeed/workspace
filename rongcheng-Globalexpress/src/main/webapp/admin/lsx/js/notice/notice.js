//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
var userName;
$(function(){
	loadNotice(1);
	//批量删除
	$(".notice_delList").click(DelSelect);	
	//监听修改事件
	$("#statementNotice_table").on("click",".modify_notice",modifyNoticePublic);
	//启用
	$("#statementNotice_table").on("click","#useIt",useIts);
});
function useIts() {
	var isStartUsing=$(".isStartUsing");
	for (var i = isStartUsing.length - 1; i >= 0; i--) {
		isStartUsing[i].index=i;
		isStartUsing[i].flag=false;
	}
	if (isStartUsing[this.index].flag) {
		isStartUsing[this.index].style.background="#fff";
		isStartUsing[this.index].style.color="#00AAEE";
		isStartUsing[this.index].flag=false;
	}else{
		for (var j = isStartUsing.length - 1; j >= 0; j--) {
			isStartUsing[j].style.background="#fff";
			isStartUsing[j].style.color="#00AAEE";
			isStartUsing[j].flag=false;
		};
		isStartUsing[this.index].style.background="#00AAEE";
		isStartUsing[this.index].style.color="#fff";
		isStartUsing[this.index].flag=true;
	}
	
	var $tr = $(this).parent().parent().parent();
	var id = $tr.data("id");
	var id1=$(this).attr("id1");
//	console.log($(this).parent().parent().parent());
	if(id1!=id){			//启用
		$.ajax({
			url : "/admin/updateStatementNotice.do",
			type : "post",
			data : {
				"id" : id,
				"apply":true
			},
			dataType : "json",
			success : function(result) {
				if(result.state==0){
					isStartUsing.attr("id1",id);
				}
			},
			error : function() {
				alert("启用失败!!!");
			}
		});
		$.ajax({
			url : "/admin/updateStatementNotice1.do",
			type : "post",
			data : {
				"id" : id
			},
			dataType : "json",
			success : function(result) {
			},
			error : function() {
				alert("停用失败!!!");
			}
		});
	}					//停用
	if(id==id1){
		console.log(2);
		$.ajax({
			url : "/admin/updateStatementNotice.do",
			type : "post",
			data : {
				"id" : id,
				"apply":false
			},
			dataType : "json",
			success : function(result) {
//				alert("停用成功！");
				isStartUsing.prop("style","");
				window.location.href="notice.do";
			},
			error : function() {
				alert("停用失败!!!");
			}
		});
	}
		
}

function DelSelect(){
	var id1 = new Array();
	var Checkbox=false;
	 $("input[name='id1']").each(function(){
		 id1.push($(this).val());
//		 console.log(id1);
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 
		$.ajax({
			url:"/admin/delStatementNoticeList.do",
			type:"post",
			dataType:"json",
			data:$('#fm1').serialize(),
			 success:function(result){
				if(result.state==0){
					alert("批量删除成功！"); 	
					window.location.href="notice.do";
				}
			},
			error:function(){
				alert("批量删除失败！"); 
			}
		});
	}else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
function changesearch() {
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "/admin/findListByStatementNotice.do",
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

function delNotice(id){
	$.ajax({
		url:"/admin/delStatementNotice.do",
		type:"post",
		dataType:"json",
		data:{"id":id},
		 success:function(result){
			if(result.state==0){
				alert("删除成功！");
				window.location.href="notice.do";
			}
		},
		error:function(){
			alert("删除失败！"); 
		}
	});
}

function modifyNoticePublic(){
	var $tr = $(this).parent().parent().parent();
	var id = $tr.data("id");
	addCookie("id", id, 1);
//	alert(getCookie("id"));
}
function loadNotice(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/loadList_notice.do",
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
	var statementNoticeTable = $("#statementNotice_table");
	statementNoticeTable.empty();
	var sa="";
	sa+='<tr>';
	sa+='<th width="50">ID</th>';
	sa+='<th>名称</th>';
	sa+='<th>作者</th>';
	sa+='<th width="400">公司公告</th>';
	sa+='<th>备注</th>';
	sa+='<th width="120">修改时间</th>';
	sa+='<th width="300">操作</th>';
	sa+='<tr>';
	$("#statementNotice_table").append(sa);
	for(var i=0;i<list.length;i++){
		var StatementNotice = list[i];
		var id = StatementNotice.id;
		var statementTitle = StatementNotice.statementTitle;
		var operatorId = StatementNotice.operatorId;
		var statement = StatementNotice.statement;
		var note = StatementNotice.note;
		var gmtModified = StatementNotice.gmtModified;
		 apply = StatementNotice.apply;
		 $.ajax({
				url : "/admin/findByOperatorId.do",
				type : "post",
				async:false,
				data : {
					"id" : operatorId
				},
				dataType : "json",
				success : function(result) {
					if(result.state==0){
						var UserInfo = result.data;
						 userName = UserInfo.userName;
					}
				},
				error : function() {
					alert("加载失败!!!");
				}
			});
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
		var time = new Date(gmtModified).Format("yyyy-MM-dd");
		var str="";
		str+='<tr>';
		str+='<td style="width:5%;"><input type="checkbox" name="id1" value="'+id+'" />'+id+'</td>';
		str+='<td>'+statementTitle+'</td>';
		str+='<td>'+userName+'</td>';
		str+='<td><div class="w400_gsgg">'+statement+'</div></td>';
		str+='<td>'+note+'</td>';
		str+='<td>'+time+'</td>';
		str+='<td><div class="button-group">';
		if(apply==1){
			str+='<a href="javascript:;" id1="'+id+'" class="button border-main isStartUsing" id="useIt" style="background-color:rgb(0, 170, 238);color:#FFF">启用</a>';
		}else{
			str+='<a href="javascript:;" class="button border-main isStartUsing" id="useIt">启用</a>';	
		}
		str+='<a type="button" class="button border-main modify_notice" href="noticePublic.do"><span class="icon-edit"></span>修改</a>';
		str+='<a class="button border-red" onclick=delNotice('+id+')><span class="icon-trash-o"></span>删除 </a>';
		str+='</div></td>';
		str+='</tr>';
		//转jquery对象
		var $tr=$(str);
		//把id加到 这条数据上
		$tr.data("id",id);
		$("#statementNotice_table").append($tr);
		
	}
	
	/////页码////////////
	var trs="";
	trs += '<tr id = "page_tr">';
	trs += '<td colspan="10"><div class="pagelist"><a class="current" onclick="loadNotice(1)" href="javascript:;">首页</a><a class="bookpage" onclick="loadNotice('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadNotice('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadNotice('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadNotice(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadNotice(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadNotice('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadNotice('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadNotice('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadNotice('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadNotice('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadNotice('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadNotice('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadNotice('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadNotice('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadNotice('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadNotice('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadNotice('+max_page+')">尾页</a></div></td>';
	trs += '</tr>';
	$("#statementNotice_table").append(trs);
	//////////////////////////
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}
	
	
		
		