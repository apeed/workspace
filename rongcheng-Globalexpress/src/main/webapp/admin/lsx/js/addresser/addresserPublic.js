 
$(function(){
	loadModify();
	$(".addresserPublic_btn").click(modifyBtn);
	
});

function modifyBtn(){
	var userInfoId = getCookie("aid");
	var addresser_userName=$("#addresser_userName").val();
	var addresser_userTelephone=$("#addresser_userTelephone").val();
	var addresser_userAddress=$("#addresser_userAddress").val();
	var addresser_note=$("#addresser_note").val();
	var ok=true;		
	 var re = /^(0\d{11}|1\d{10})$/;
	if(addresser_userTelephone==""){
		ok=false;
		$("#addresser_userTelephone_ts").html("发件人电话为空");
	}else if(!re.test(addresser_userTelephone)){
		ok=false;
		$("#addresser_userTelephone_ts").html("请输入正确的格式!");
	}else{
		$("#addresser_userTelephone_ts").html("");
	}
	if(ok){
		$.ajax({
				url:"/admin/modifyUserInfo1.do",
				type:"post",
				dataType:"json",
				data:{
					"id":userInfoId,
					"userName":addresser_userName,
					"userTelephone":addresser_userTelephone,
					"userAddress":addresser_userAddress,
					"note":addresser_note
					},
				 success:function(result){
					if(result.state==0){
						alert("修改成功！"); 	
						window.location.href ="addresser.do";	
					}
				},
				error:function(){
					alert("修改失败！"); 
				}
			});	}
}
function loadModify(){
		var userInfoId = getCookie("aid");
		$.ajax({
			url : "/admin/load_modify_userInfo.do",
			type : "post",
			data : {"id":userInfoId},
			dataType : "json",
			success:function(result){
				if (result.state == 0) {
					var UserInfo = result.data;
					var userName = UserInfo.userName;
					var userTelephone = UserInfo.userTelephone;
					var userAddress = UserInfo.userAddress;
					var note = UserInfo.note;
					var addresser_userName=$("#addresser_userName").val(userName);
					var addresser_userTelephone=$("#addresser_userTelephone").val(userTelephone);
					var addresser_userAddress=$("#addresser_userAddress").val(userAddress);
					var addresser_note=$("#addresser_note").val(note);
				}
			},
			error:function(){
				alert("加载失败！"); 
			}
		});
}