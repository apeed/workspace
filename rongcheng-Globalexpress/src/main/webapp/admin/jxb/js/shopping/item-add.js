var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="itemDetail"]',{
		cssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
});

function add() {
	var data = new FormData($("#subForm")[0]);
	data.append("itemDetail",editor1.html());
	$.ajax({
		url : "/admin/item/additem/add.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result == 1) {
				queueShowMessage("新增成功");
				setTimeout(function(){
					window.location.href = "/admin/item/list.do";
				},500);
			} else {
				queueShowMessage("新增失败");
			}
		},
		error : function() {
			queueShowMessage("新增失败");
		}
	});
}
function fileChange(){
	var file=$("#itemImage1").val();
	var filename=file.replace(/.*(\/|\\)/, "");  
	$("#fileName").val(filename);
}
