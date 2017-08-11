var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content1"]',{
		cssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
});
function checkEmpty(){
	var flag = false;
	$(".jiml_notEmpty").each(function(){
		if($(this).val().trim().length == 0){
			flag = true;
			return false; //跳出循环
		}
	});
	return flag;
}
//正在提交标志
var flag = false;
function add() {
	/* if(checkEmpty() || editor1.text().length == 0){
		return;
	} */
	if(flag){
		return;
	}
	flag = true;
	showLoadingImg("/media/images/public/loading.gif");
	var data = new FormData($("#subForm")[0]);
	data.append("content1",editor1.html());
	$.ajax({
		url : "/admin/content/addcontent/add.do",
		type : "post",
		dataType : "json",
		data : data,
		//async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result == 1) {
				queueShowMessage("新增成功");
				setTimeout(function(){
					window.location.href = "/admin/content/content.do";
				},500);
			} else {
				queueShowMessage("新增失败");
			}
			hideLoadingImg("/media/images/public/loading.gif");
			flag = false;
		},
		error : function() {
			queueShowMessage("新增失败");
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