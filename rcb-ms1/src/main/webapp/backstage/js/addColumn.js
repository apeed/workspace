$(function(){
	
	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//绑定单击事件
	$("#addColumn_button").click(addColumn);
	
	//绑定上传改变事件
	$("#addColumn_myfile").change(loadMyfile);
});

function loadMyfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#addColumn_link").val(my);
}

function addColumn(){
	var ok = true;
	//给予默认值
	if($("input[name='title']").val().trim() == ""){
		alert("请在标题中填入内容");
		ok = false;
	}
	if(isNaN($("input[name='seq']").val().trim())){
		alert("请在排序中填入数字");
		ok = false;
	}
	if($("input[name='seq']").val().trim() >= 128){
		alert("排序中数字最大为127");
		ok = false;
	}
	if($("input[name='seq']").val().trim() == ""){
		$("input[name='seq']").val(100);
	}
	
	var data = new FormData($( "#addColumn_form" )[0]);
	//data.append("参数名",参数值);
	if(ok){
		$.ajax({
			url : path + "/addColumn/addColumn.do",
			type : "post",
			data : data,
			async: false,
	        cache: false,  
	        contentType: false,  
	        processData: false,
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("栏目添加成功");
					window.location.href = "column.do";
				}
			},
			error : function() {
				alert("栏目添加失败!!!");
			}
		});
	}
	

}