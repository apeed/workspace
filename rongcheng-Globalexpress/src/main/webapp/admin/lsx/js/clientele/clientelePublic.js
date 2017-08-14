 
$(function(){
	loadModify();
	$(".clientelePublic_btn").click(modifyBtn);
	
});

function modifyBtn(){
	var userInfoId = getCookie("id");
	var clientele_password=$("#clientele_password").val();
	var clientele_repassword=$("#clientele_repassword").val();
	var clientele_accountEmail=$("#clientele_accountEmail").val();
	var clientele_userNickname=$("#clientele_userNickname").val();
	var clientele_userName=$("#clientele_userName").val();
	var clientele_userTelephone=$("#clientele_userTelephone").val();
	var clientele_userMobile=$("#clientele_userMobile").val();
	var clientele_userAddress=$("#clientele_userAddress").val();
	var clientele_accountStatus=$("input[name='qt']:checked").val();
//	console.log(clientele_accountStatus);
	var clientele_userQuestion1=$("#clientele_userQuestion1").val();
	var clientele_userAnswer1=$("#clientele_userAnswer1").val();
	var clientele_userQuestion2=$("#clientele_userQuestion2").val();
	var clientele_userAnswer2=$("#clientele_userAnswer2").val();
	var clientele_userQuestion3=$("#clientele_userQuestion3").val();
	var clientele_userAnswer3=$("#clientele_userAnswer3").val();
	var clientele_note=$("#clientele_note").val();
	var ok=true;
	if(clientele_accountEmail!=""&&clientele_accountEmail!=null){
		if(!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(clientele_accountEmail)){
			ok=false;
			$("#clientele_accountEmail_ts").html("请输入正确账户邮箱格式！");
		}else{
			$("#clientele_accountEmail_ts").html("");
		}
	}
	
	if(clientele_password!=clientele_repassword){
		$("#clientele_repassword_ts").html("两次密码不一致");
		ok=false;
	}
//	var re = /^0\d{10,11}$/;
	var re = /^(0|1)\d{10,11}$/;
	if(clientele_userTelephone!=""&&clientele_userTelephone!=null){
		if(!re.test(clientele_userTelephone)){
			ok=false;
			$("#clientele_userTelephone_ts").html("请输入0开头的 11或12位数字!");
		}else{
			$("#clientele_userTelephone_ts").html("");
		}
	}
	
	var re = /^(0|1)\d{10,11}$/;
	if(clientele_userMobile!=""&&clientele_userMobile!=null){
		if(!re.test(clientele_userMobile)){
			ok=false;
			$("#clientele_userMobile_ts").html("请输入正确的格式!");
		}else{
			$("#clientele_userMobile_ts").html("");
		}	
	}
	
		if(ok){
			$.ajax({
				url:"/admin/modify_userInfo.do",
				type:"post",
				dataType:"json",
				data:{
					"id":userInfoId,
					"userPassword":clientele_password,
					"accountEmail":clientele_accountEmail,
					"userNickname":clientele_userNickname,
					"userName":clientele_userName,
					"userTelephone":clientele_userTelephone,
					"userMobile":clientele_userMobile,
					"userAddress":clientele_userAddress,
					"accountStatus":clientele_accountStatus,
					"userQuestion1":clientele_userQuestion1,
					"userAnswer1":clientele_userAnswer1,
					"userQuestion2":clientele_userQuestion2,
					"userAnswer2":clientele_userAnswer2,
					"userQuestion3":clientele_userQuestion3,
					"userAnswer3":clientele_userAnswer3,
					"note":clientele_note
					},
				 success:function(result){
					if(result.state==0){
						alert("修改成功！"); 	
						window.location.href ="clientele.do";	
					}
				},
				error:function(){
					alert("修改失败！"); 
				}
			});	
		}
}
function loadModify(){
		var userInfoId = getCookie("id");
		$.ajax({
			url : "/admin/load_modify_userInfo.do",
			type : "post",
			data : {"id":userInfoId},
			dataType : "json",
			success:function(result){
				if (result.state == 0) {
					var UserInfo = result.data;
					var accountNum = UserInfo.accountNum;
					var accountEmail = UserInfo.accountEmail;
					var userNickname = UserInfo.userNickname;
					var userName = UserInfo.userName;
					var userTelephone = UserInfo.userTelephone;
					var userMobile = UserInfo.userMobile;
					var userAddress = UserInfo.userAddress;
					var accountStatus = UserInfo.accountStatus;
					var userQuestion1 = UserInfo.userQuestion1;
					var userAnswer1 = UserInfo.userAnswer1;
					var userQuestion2 = UserInfo.userQuestion2;
					var userAnswer2 = UserInfo.userAnswer2;
					var userQuestion3 = UserInfo.userQuestion3;
					var userAnswer3 = UserInfo.userAnswer3;
					var note = UserInfo.note;
					
					$("#clientele_accountNum_ts").html(accountNum);
					var clientele_accountEmail=$("#clientele_accountEmail").val(accountEmail);
					var clientele_userNickname=$("#clientele_userNickname").val(userNickname);
					var clientele_userName=$("#clientele_userName").val(userName);
					var clientele_userTelephone=$("#clientele_userTelephone").val(userTelephone);
					var clientele_userMobile=$("#clientele_userMobile").val(userMobile);
					var clientele_userAddress=$("#clientele_userAddress").val(userAddress);
					$(".radio").find('input[value="'+accountStatus+'"]').prop("checked", true);
					var clientele_userQuestion1=$("#clientele_userQuestion1").val(userQuestion1);
					var clientele_userAnswer1=$("#clientele_userAnswer1").val(userAnswer1);
					var clientele_userQuestion2=$("#clientele_userQuestion2").val(userQuestion2);
					var clientele_userAnswer2=$("#clientele_userAnswer2").val(userAnswer2);
					var clientele_userQuestion3=$("#clientele_userQuestion3").val(userQuestion3);
					var clientele_userAnswer3=$("#clientele_userAnswer3").val(userAnswer3);
					var clientele_note=$("#clientele_note").val(note);
				}
			},
			error:function(){
				alert("加载失败！"); 
			}
		});
}