$(function() {
	// 输入框内容改变触发事件
	$("input").change(addSubmit);
	// 绑定提交单击事件
	$("#subButton").click(update);
});

function addSubmit() {
	$(this).attr("form","subForm");
	$(this).next().find(".icon-check").addClass("tipShow");
	if($(this).val()==""){
		$(this).removeAttr("form");
		$(this).next().find(".icon-check").removeClass("tipShow");
	}
}
function update() {
	if($("[form='subForm']").length<1){
		queueShowMessage("没有可修改的内容");
		return;
	}
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/config/updateuser.do",
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
				$(".tipShow").show();
				$(".tipShow").removeClass("tipShow");
				setTimeout('$(".icon-check").hide();',2000);
			} else {
				queueShowMessage("密码错误");
			}
		},
		error : function() {
			queueShowMessage("修改失败");
		}
	});
}
