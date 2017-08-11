$(document).ready(function(){
	$("input,select").change(function(){
	  $(this).attr("form","subForm");
	});
});
function modify() {
	if($("[form]").length<2){
		queueShowMessage("没有修改。");
		return;
	}
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/item/modifyitem/modify.do",
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
				$("#itemImage1Temp").val(result.itemImage1Temp);
				setTimeout(function(){
					window.location.href = "/admin/item/list.do";
				},500);
			} else {
				queueShowMessage("未进行修改");
			}
		},
		error : function() {
			queueShowMessage("修改失败");
		}
	});
}
function fileChange(obj){
	var filename=$(obj).val().replace(/.*(\/|\\)/, "");  
	$("#"+$(obj).attr("id")+"FileName").val(filename);
}
