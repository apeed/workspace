$(function() {
	//输入框内容改变事件
	$("input").change(addInput);
	$("textarea").change(addInput);
	//上传按钮点击事件
	$("#logo").change(imageName);
	// 绑定单击事件
	$("#setinfo_button").click(updateConfig);
});
var haveChange = false;
function addInput() {
	$(this).attr("form","subForm");
	haveChange = true;
	$(this).next().find(".icon-check").addClass("tipShow");
}


function imageName(){

	var file=$("#logo").val();
    //filename得到文件名
	var filename=file.replace(/.*(\/|\\)/, "");  
	//fileExt得到后缀名
	//var fileExt=file.slice(file.lastIndexOf('.')+1);
	//var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';  
	$("#logoImgName").val(filename);
	$("#logoImgName").next().find(".icon-check").addClass("tipShow");
	//console.log("filename："+filename,"fileExt："+fileExt);
};
function updateConfig() {
	if(!haveChange){
		queueShowMessage("没有可修改的内容");
		return;
	}
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/config/updateconfig.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result > 0) {
				showMessage("修改了"+result+"条");
				haveChange = false;
				$(".tipShow").show();
				$(".tipShow").removeClass("tipShow");
				setTimeout('$(".icon-check").hide();',2000);
				
			} else {
				showMessage("没有修改");
			}
		},
		error : function() {
			showMessage("修改失败");
		}
	});
}
