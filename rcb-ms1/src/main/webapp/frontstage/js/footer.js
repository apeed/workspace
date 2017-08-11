function leaveWord(){
	// 获取请求参数
	var name = $("#footer_name").val().trim();
	var email = $("#footer_email").val().trim();
	var tel = $("#footer_tel").val().trim();
	var content = $("#footer_content").val().trim();

	//表单所有字段不为空
	if (name == ""||email == ""||tel == ""||content == "") {
		ok = false;
		$("#footer_tj").val("请填写完整再提交");
		$("#footer_tj").css("color","red");
		return;
	}
	// 发送ajax请求
		$.ajax({
			url :"savaleavemessage.php",
			type : "post",
			data : $("#leave_word").serialize(), 
			async: false,
			dataType : "json",
			success : function(result) {
				if (result > 0) {
					alert("留言成功，我们将尽快处理。");
					//清空表单
					$("#footer_name").val("");
					$("#footer_email").val("");
					$("#footer_tel").val("");
					$("#footer_content").val("");
					
					$("#footer_tj").val("提交");
					$("#footer_tj").css("color","#666");
				}else{
					alert("留言失败，请稍候再试。");
				}
			},
			error : function() {
				alert("留言失败，请稍候再试。");
			}
		});
}