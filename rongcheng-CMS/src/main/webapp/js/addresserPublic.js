 
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
			$.ajax({
				url:"modifyUserInfo1.do",
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
			});	
}
function loadModify(){
		var userInfoId = getCookie("aid");
		$.ajax({
			url : "load_modify_userInfo.do",
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