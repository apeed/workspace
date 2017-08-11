$(function() {
	// 输入框内容改变触发事件
	$(".jxb_inputChange").change(addSubmit);
	// 密码改变触发事件
	$("#password").change(checkPassword);
	// 新密码改变触发事件
	$("#newPassword2").change(checkNewPassword);
	// 问题改变触发事件
	$(".jxb_userQuestion").change(changeQuestion);
	// 问题答案改变触发事件
	$(".jxb_userAnswer").change(changeAnswer);
	// 绑定提交单击事件
	$("#subButton").click(update);
});

function addSubmit() {
	$(this).attr("form","subForm");
	$(this).next().find(".icon-check").addClass("tipShow");
	/*if($(this).val()==""){
		$(this).removeAttr("form");
		$(this).next().find(".icon-check").removeClass("tipShow");
	}*/
}

function checkPassword(){
	if($("#password").val().trim()!=""){
		$("#password").attr("form","subForm");
	}else{
		$("#password").removeAttr("form");
	}
}
function checkNewPassword(){
	var newPassword1=$("#newPassword1").val().trim();
	var newPassword2=$("#newPassword2").val().trim();
	$(".newPassword").removeAttr("form");
	$(".newPassword").next().find(".icon-check").removeClass("tipShow");
	if(newPassword1!=newPassword2){
		queueShowMessage("两次输入的密码不一致");
	}
	//执行修改密码
	if(newPassword1!=""&&newPassword1==newPassword2){
		$(".newPassword").attr("form","subForm");
		$(".newPassword").next().find(".icon-check").addClass("tipShow");
	}
}

function changeQuestion(){
	var userQuestionInput = $(this);
	var userAnswerInput = userQuestionInput.parent().parent().next().find("input");
	/*if(userAnswerInput.val().trim()!=""&&userQuestionInput.val().trim()!=""&&$("#password").val().trim()!=""){*/
		userQuestionInput.attr("form","subForm");
		userAnswerInput.attr("form","subForm");
		userQuestionInput.parent().find(".icon-check").addClass("tipShow");
		/*}
	if(userAnswerInput.val()==""||userQuestionInput.val()==""){
		userQuestionInput.removeAttr("form");
		userAnswerInput.removeAttr("form");
		userQuestionInput.parent().find(".icon-check").removeClass("tipShow");
	}*/
}
function changeAnswer(){
	var userAnswerInput = $(this);
	var userQuestionInput = userAnswerInput.parent().parent().prev().find("input");
	/*if(userAnswerInput.val().trim()!=""&&userQuestionInput.val().trim()!=""&&$("#password").val().trim()!=""){*/
		userQuestionInput.attr("form","subForm");
		userAnswerInput.attr("form","subForm");
		userQuestionInput.parent().find(".icon-check").addClass("tipShow");
		/*}
	if(userAnswerInput.val()==""||userQuestionInput.val()==""){
		userQuestionInput.removeAttr("form");
		userAnswerInput.removeAttr("form");
		userQuestionInput.parent().find(".icon-check").removeClass("tipShow");
	}*/
}
function update() {
	if(!$("#password").attr("form")){
		queueShowMessage("请输入密码");
		return;
	}
	if($("[form='subForm']").length<2){
		queueShowMessage("没有可修改的内容");
		return;
	}
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/config/updatenowuser.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result > 0) {
				queueShowMessage("修改成功");
				$("[form='subForm']").removeAttr("form");
				$("#password").attr("form","subForm");
				$(".tipShow").show();
				$(".tipShow").removeClass("tipShow");
				setTimeout('$(".icon-check").hide();',2000);
			} else {
				queueShowMessage("修改失败");
			}
		},
		error : function() {
			queueShowMessage("修改失败");
		}
	});
}
