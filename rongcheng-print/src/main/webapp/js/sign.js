$(function(){
	$(".sign_reg_btn").click(regAction);
});

function regAction(){
	var sign_accountNum=$("#sign_accountNum").val();
	var sign_password=$("#sign_password").val();
	var sign_email=$("#sign_email").val();
	var sign_telephone=$("#sign_telephone").val();
	var ok=true;

	if(sign_accountNum==""){
		ok=false;
	}
	if(sign_password==""){
		ok=false;
	}
	if(sign_email==""){
		ok=false;
	}
	if(sign_telephone==""){
		ok=false;
	}
	//String accountNum, String password, String email, String telephone 
	if(ok){
		$.ajax({
			url:"regist_account.do",
			type:"post",
			dataType:"json",
			data:{"accountNum":sign_accountNum,
				"password":sign_password,
				"email":sign_email,
				"telephone":sign_telephone},
				success:function(result){
				if(result.state==0){
					alert("恭喜您注册成功！！");
					window.location.href = "admin.do";		
				}
				
			},
			error:function(){
				alert("注册失败！！");
			}
		});
	}
}