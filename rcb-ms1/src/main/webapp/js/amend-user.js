$(function(){
//自动加载
load_modify_Administrator();
$("#amend_user_button").click(modify_Administrator);

});
function modify_Administrator(){
	var user_name=$("#user_name").val();
	var user_account=$("#user_account").val();
	var user_password=$("#user_password").val();
	var user_tel=$("#user_tel").val();
	var user_email=$("#user_email").val();
	var user_remark=$("#user_remark").val();
	var user_enable=$("input[name='isshow']:checked").val();
	var ok = true;
	var userId = getCookie("userId");
	if(user_name==""){
		//$("#advpop_title_span").html("标题为空");
		ok=false;
	}
	if(user_account==""){
		
		ok=false;
	}
	if(user_password==""){
		
		ok=false;
	}
	/*if(user_tel==""){
		
		ok=false;
	}
	if(user_email==""){
		
		ok=false;
	}
	if(user_remark==""){
			
			ok=false;
		}*/
	if(user_enable==""){
		
		ok=false;
	}

	if(ok){
		$.ajax({
			url:"user/modifyAdministrator.do",
			type:"post",
			dataType:"json",
			data:{
				"id":userId,
				"name":user_name,
				"account":user_account,
				"password":user_password,
				"tel":user_tel,
				"email":user_email,
				"remark":user_remark,
				"enable":user_enable
				},
			 success:function(result){
				if(result.state==0){//成功
					alert("修改成功！"); 	
					window.location.href = "Administrator.do";	
				}
			},
			error:function(){
				alert("修改失败！"); 
			}
		});
	}
}

function load_modify_Administrator(){
	
	var userId = getCookie("userId");
	
	$.ajax({
		url:"user/load_modify_Administrator.do",
		type:"post",
		data:{"id":userId},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取user集合
				var user=result.data;
				/*console.log(user);*/
					//获取姓名
					var userName = user.name;
					//获取账号
					var userAccount = user.account;
					//获取密码
					var userPassword = user.password;
					//获取电话
					var userTel = user.tel;
					//获取邮箱
					var userEmail = user.email;
					//获取备注
					var userRemark = user.remark;
					//获取是否可用
					var userEnable = user.enable;
					
					var user_name=$("#user_name").val(userName);
					var user_account=$("#user_account").val(userAccount);
					var user_password=$("#user_password").val(userPassword);
					var user_tel=$("#user_tel").val(userTel);
					var user_email=$("#user_email").val(userEmail);
					var user_remark=$("#user_remark").val(userRemark);
					if(userEnable==0){
						$("#label2").attr("class", "button active");
					}else if(userEnable==1){
						$("#label1").attr("class", "button active");
					}
					//var user_enable=$("input[name='isshow']:checked").val(userEnable);					
				
			}
		},
		error : function() {
			alert("主页内容加载失败!!!");
		}
	});
}