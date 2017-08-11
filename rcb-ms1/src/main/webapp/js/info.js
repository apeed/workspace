$(function() {
	//上传按钮点击事件
	$("#logo").change(imageName);
	// 绑定单击事件
	$("#setinfo_button").click(set);
});
function imageName(){

	var file=$("#logo").val();
    //filename得到文件名
	var filename=file.replace(/.*(\/|\\)/, "");  
	//fileExt得到后缀名
	//var fileExt=file.slice(file.lastIndexOf('.')+1);
	//var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';  
	$("#logoImgName").val(filename);
	//console.log("filename："+filename,"fileExt："+fileExt);
};
function set() {
	var data = new FormData($("#form-x")[0]);
	$.ajax({
		url : "set.do",
		type : "post",
		dataType : "json",
		data : data/*$("#form-x").serialize()*/,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result > 0) {
				alert("修改成功");
			} else {
				alert("没有修改");
			}
		},
		error : function() {
			alert("修改失败");
		}
	});
}
