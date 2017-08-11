 $(function(){
	$("#add_user_button").click(subAction);
	
});

function subAction(){
	
	var user_name=$("#user_name").val();
	var user_account=$("#user_account").val();
	var user_password=$("#user_password").val();
	var user_tel=$("#user_tel").val();
	var user_email=$("#user_email").val();
	var user_remark=$("#user_remark").val();
	var userDisplay=$("input[name='isshow']:checked").val();
	var ok=true;

	if(user_name==""){
		ok=false;
	}
	if(user_account==""){
		ok=false;
	}
	if(user_password==""){
		ok=false;
	}
	if(user_tel==""){
		ok=false;
	}
	if(user_email==""){
		ok=false;
	}
	if(user_remark==""){
		ok=false;
	}
	if(userDisplay==""){
		ok=false;
	}
	
	//从cookie中获取id
//	var userId = getCookie('userId');
	if(ok){
		$.ajax({
			url:"user/add_user.do",
			type:"post",
			dataType:"json",
			data:{
				"name":user_name,
				"account":user_account,
				"password":user_password,
				"tel":user_tel,
				"email":user_email,
				"remark":user_remark,
				"enable":userDisplay
				},
				success:function(result){
				
				if(result.state==0){
					alert("添加用户成功！！");
				}
//				window.location.href = path +"/Administrator.do";		
			},
			error:function(){
				alert("添加用户失败！！");
			}
		});
	}
}



