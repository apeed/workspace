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