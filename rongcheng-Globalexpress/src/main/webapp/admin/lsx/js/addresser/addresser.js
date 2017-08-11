//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
$(function(){
	loadClientele(1);
	//监听修改事件
	$("#addresser_table").on("click",".modify_btn",modifyAddresserPublic);
	$(".addresser_delList").click(DelSelect);
});

function changesearch(){
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "/admin/findListsByUserInfo.do",
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
			url:"/admin/delUserInfoList.do",
			type:"post",
			dataType:"json",
			data:$('#fm1').serialize(),
			 success:function(result){
				if(result.state==0){
					alert("批量删除成功！"); 	
					window.location.href="addresser.do";
				}
			},
			error:function(){
				alert("批量删除失败！"); 
			}
		});
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}	

function modifyAddresserPublic(){
	var $tr = $(this).parent().parent().parent();
	var id = $tr.data("aid");
	addCookie("aid", id, 1);
//	alert(getCookie("aid"));
}
function del(id) {
	if(confirm("您确定要删除吗?")){
		$.ajax({
			url:"/admin/delUserInfo.do",
			type:"post",
			dataType:"json",
			data:{"id":id},
			 success:function(result){
				if(result.state==0){
					window.location.href="addresser.do";
				}
			},
			error:function(){
				alert("删除失败！"); 
			}
		});   
    }
}
function loadClientele(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/loadList_addresser.do",
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
	var clienteleTable = $("#addresser_table");
	clienteleTable.empty();
	var sa="";
	sa+='<tr>';
	sa+='<th>序号</th>';
	sa+='<th>发件人姓名</th>';
	sa+='<th>发件人电话</th>';
	sa+='<th>发件人地址</th>';
	sa+='<th>备注</th>';
	sa+='<th width="180">操作</th>';
	sa+='</tr>';
	sa+='<tr>';
	$("#addresser_table").append(sa);
	for(var i=0;i<list.length;i++){
		var UserInfo = list[i];
		var id = UserInfo.id;
		var userName = UserInfo.userName;
		var userTelephone = UserInfo.userTelephone;
		var userAddress = UserInfo.userAddress;
		var note = UserInfo.note;
		var str="";
		str+='<tr>';
		str+='<td><input type="checkbox" name="id1" value="'+id+'" />'+id+'</td>';
		str+='<td>'+userName+'</td>';
		str+='<td>'+userTelephone+'</td>';
		str+='<td>'+userAddress+'</td>';
		str+='<td>'+note+'</td>';
		str+='<td>';
		str+='<div class="button-group">';
		str+='<a class="button border-main modify_btn" href="addresserPublic.do"><span class="icon-edit"></span> 修改</a>';
		str+='<a class="button border-red" href="javascript:void(0)" onclick="del('+id+')"><span class="icon-trash-o"></span> 删除</a>';
		str+='</div>';
		str+='</td>';
		str+='</tr>';    
		//转jquery对象
		var $tr=$(str);
		//把id加到 这条数据上
		$tr.data("aid",id);
		$("#addresser_table").append($tr);
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
	$("#addresser_table").append(trs);
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}
	
	
		
		