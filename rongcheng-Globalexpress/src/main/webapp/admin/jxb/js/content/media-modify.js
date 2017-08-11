//正在提交标志
var flag = false;
function modify() {
	if(flag){
		return;
	}
	flag = true;
	showLoadingImg("/media/images/public/loading.gif");
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/content/modifymedia/modify.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result.modify == 1) {
				queueShowMessage("修改成功");
				$("#mediaUrlTemp").val(result.mediaUrlTemp);
				$("#iconUrlTemp").val(result.iconUrlTemp);
				setTimeout(function(){
					window.location.href = "/admin/content/media.do";
				},500);
			} else {
				queueShowMessage("未进行修改");
			}
			hideLoadingImg("/media/images/public/loading.gif");
			flag = false;
		},
		error : function() {
			queueShowMessage("修改失败");
			hideLoadingImg("/media/images/public/loading.gif");
			flag = false;
		}
	});
}
function fileChange(obj){
	var filename=$(obj).val().replace(/.*(\/|\\)/, "");  
	$("#"+$(obj).attr("id")+"FileName").val(filename);
}