<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/admin/jxb/js/jiml-utils.js"></script>

<script type="text/javascript">
$(function(){
	//自动加载
	loadAdministrator(1);
	//全选
	var flag=true;
   $("#checkall").click(function(){ 
     if(flag){
         flag=false;
         $('tr').find('input').prop('checked',true);
     }else{
       flag=true;
         $('tr').find('input').prop('checked',false);
     }
   })
});
var nowPage = 1;
var maxPage = 1;
function loadAdministrator(page){
	if(page<1 || page>maxPage){return;}
	$.ajax({
		url:"/admin/config/loadusersinfo.do",
		type:"post",
		data:{"page":page},
		dataType:"json",
		success : function(result) {
			maxPage = result.maxPage;
			if(page>maxPage){page = maxPage;}
			if (maxPage != 0){
				reloadUsersTable(result.users);
				pagination(maxPage,page,"pageTd","loadAdministrator");
				nowPage = page;
			}
		},
		error : function() {
			showMessage("主页内容加载失败，请刷新重试。");
		}
	});
}
function reloadUsersTable(users){
	$(".jxb_removeTr").remove();
	for(var i = 0;i<users.length;i++){
		var str='<tr class="jxb_removeTr">';
		str+='<td><input type="checkbox" name="userId" value="'+users[i].id+'" />'+users[i].id+'</td>';
		str+='<td>'+users[i].accountNum+'</td>';
		str+='<td>'+users[i].userName+'</td>';
		str+='<td>'+users[i].userTelephone+'</td>';
		str+='<td>'+users[i].accountEmail+'</td>';
		str+='<td>';
		if(users[i].accountStatus=='1'){
			str+='可用';
		}else{
			str+='冻结';
		}
		str+='</td>';
		str+='<td>'+users[i].note+'</td>';
		str+='<td><div class="button-group"> <a class="button border-main" href="/admin/config/userconfig.do?userId='+users[i].id+'"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="deleteUser('+users[i].id+')"><span class="icon-trash-o"></span> 删除</a> </div></td>';
		str+='</tr>';
		$("#usersTable").append(str);
	}
	$("#usersTable").append('<tr class="jxb_removeTr"><td colspan="8" id="pageTd"></td></tr>');
}
function deleteUser(id) {
	if(confirm("您确定要删除吗?")){
		var data;
		if(id == -1){
			data = new FormData($("#subForm")[0]);
			data.append("page",nowPage);
		}else{
			data = new FormData();
			data.append("userId",id);
			data.append("page",nowPage);
		}
		$.ajax({
			url:"/admin/config/deleteuser.do",
			type:"post",
			data:data,
			processData: false,
			contentType: false, 
			dataType:"json",
			success : function(result) {
				showMessage("已删除"+result+"个账号");
				loadAdministrator(nowPage);
			},
			error : function() {
				showMessage("删除失败");
			}
		});
	}
}
</script>

</head>
<body>
<div id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="/admin/config/toadduser.do"> 添加用户</a> </li> 
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="button" class="button border-red" onclick="deleteUser(-1)"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <form id="subForm">
    <table class="table table-hover text-center" id = "usersTable">
      <tr>
        <th width="80">ID</th>
        <th>账号</th>
        <th>姓名</th>
        <th>电话</th> 
        <th>邮箱</th>
        <th>状态</th>
        <th>备注</th>
        <th width="310">操作</th>
      </tr>
    </table>
    </form>
  </div>
</div>
</body>
</html>