$(function(){
	loadPass();
	
	$("#pass_submit").click(subAction);
});
//载pass
function loadPass(){
	var userAccount=getCookie("userAccount");
	$("#pass_account_span").html(userAccount);
	
	
	/*//获取cookie中的HomeImgId
	var homeImgId = getCookie("homeImgId");
	//判断cookie是否有效
	if(homeImgId==null){
		window.location.href=path+"/adv.do";
	}*/
		
	//发送ajax
	$.ajax({
		url : "pass/loadPass.do",
		type : "post",
		data : {"account":userAccount},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var User = result.data;
/*				console.log(HomeImg);
*/				//获取各项数值
				var account = User.account;
				var UserName = User.name;
				var UserTel = User.tel;
				var UserEmail = User.email;
				
				//获取各个内容框，绑定他们哟
				var pass_name=$("#name").val(UserName);
				var pass_tel=$("#tel").val(UserTel);
				var pass_email=$("#email").val(UserEmail);
				$("#pass_account_span").append(account);
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
}

function subAction(){
	/*var name=$("#name").val();//姓名
	var tel=$("#tel").val();//电话
	var email=$("#email").val();//邮箱*/
	//原始密码
	var password=$("#mpass").val();
	//新密码
	var newPassword=$("#newPassword").val();
	//确认新密码
	var renewpass=$("#renewpass").val();
	var ok=true;

	/*if(name==""){
		ok=false;
	}
	if(tel==""){
		ok=false;
	}
	if(email==""){
		ok=false;
	}*/
	if(password==""){
		ok=false;
	}
	if(newPassword==""){
		ok=false;
	}
	if(renewpass==""){
		ok=false;
	}
	//从cookie中获取id  
//int userId,String name, String tel, String email, String password, String newPassword	
	var userId = getCookie('userId');
	if(ok){
		$.ajax({
			url:"pass/modify.do",
			type:"post",
			dataType:"json",
			data:{"userId":userId,
				"name":name,
				"tel":tel,
				"email":email,
				"password":password,
				"newPassword":newPassword,
				},
				success:function(result){
				if(result.state==0){
					alert("修改密码成功！");
				}
			},
			error:function(){
				alert("修改密码失败");
			}
		});
	}
}