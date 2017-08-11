$(function(){
	//自动加载
	loadAdministrator();
	//增加adv
	/*$("#adv_button").click(addAdv);
	*/
	//监听删除事件
	$("#user_table").on("click",".delete_button",deleteAdministrator);
	//监听修改事件
	$("#user_table").on("click",".modify_button",modifyAdministrator);
	
});

function modifyAdministrator(){
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var userId = $tr.data("userId");
	//绑定cookie
	addCookie("userId",userId,3);
//	alert(getCookie("userId"));
//	alert(12);
}
function deleteAdministrator(){
	
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var userId = $tr.data("userId");
		console.log(userId);
		//发送ajax
		$.ajax({
			url:"user/delAdministrator.do",
			type:"post",
			data:{"id":userId},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					$tr.remove();
					alert("删除栏目成功");
				}
			},
			error:function(){
				alert("删除栏目失败");
			}
		});
		
	}
	
}
function loadAdministrator(){
	
	// 获取参数userId
	//var userId=getCookie("userId");
	//判断userId是否有效
	//if(userId==null){
	//	window.location.href="../rcb-ms/login.do";
	//}
	
	$.ajax({
		url:"user/loadAdministrator.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取user集合
				var user=result.data;
				/*console.log(user);*/
				//循环处理
				for(var i=0;i<user.length;i++){
					//获取
					var userId = user[i].id;
					//获取
					var userName = user[i].name;
					//获取
					var userAccount = user[i].account;
					//获取
					var enable = user[i].enable;
					//获取
					var userTel = user[i].tel;
					//获取
					var userEmail = user[i].email;
					//获取
					var userRemark = user[i].remark;
//String name, String account, String password, 
					//String tel, String email, String remark					
					createAdministrator(userId,userName,userAccount,enable,userTel,userEmail,userRemark);
				}
			}
		},
		error : function() {
			alert("主页内容加载失败!!!");
		}
	});
}

function createAdministrator(userId,userName,userAccount,enable,userTel,userEmail,userRemark){
	var str="";
	str+='<tr>';
	str+='<td>';
	str+=userId;
	str+='</td>';
	str+='<td>';
	str+=userAccount;
	str+='</td>';
	str+='<td>';
	str+=userName;
	str+='</td>';
	str+='<td>';
	str+=userTel;
	str+='</td>';
	str+='<td>';
	str+=userEmail;
	str+='</td>';
	str+='<td>';
	
	if(enable=='1'){
		str+='可用';
	}else{
		str+='冻结';
	}
	str+='</td>';
	str+='<td>';
	str+=userRemark;
	str+='</td>';
	str+='<td><div class="button-group"><a class="button border-main modify_button" href="amend_user.do"><span class="icon-edit"></span> 修改</a><a class="button border-red delete_button" href="javascript:void(0)" onclick="return del(1,1,1)><span class="icon-trash-o"></span> 删除</a></div></td>';
	str+='</tr>';
	//将字符串转换成jQuery对象
	var $tr=$(str);
	//将homeImgId绑定到tr对象中
	$tr.data("userId",userId);
	//将tr对象添加到table中
	$("#user_table").append($tr);
}