var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content1"]',{
		cssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		height : '400px',
	});
});


//正在提交标志
var flag = false;
function modify() {
	if(flag){
		return;
	}
	flag = true;
	showLoadingImg("/media/images/public/loading.gif");
	var data = new FormData($("#subForm")[0]);
	data.append("content1",editor1.html());
	$.ajax({
		url : "/admin/content/modifycontent/modify.do",
		type : "post",
		dataType : "json",
		data : data,
		//async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result.modify == 1) {
				queueShowMessage("修改成功");
				$("#iconUrlTemp").val(result.iconUrlTemp);
				setTimeout(function(){
					window.location.href = "/admin/content/content.do";
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
function fileChange(){
	var file=$("#iconUrl").val();
	var filename=file.replace(/.*(\/|\\)/, "");  
	$("#fileName").val(filename);
}