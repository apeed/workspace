$(function(){

	// 获取参数userId
	var userName=getCookie("userName");
	//判断userId是否有效
	if(userName==null){
		window.location.href="../admin.do";
	}
	
	//加载一级菜单下拉框
	loadOneMenu();
	
	//绑定单击事件
	$("#addSonColumn_button").click(addSonColumn);
	
	//绑定上传改变事件
	$("#addSonColumn_myfile").change(loadMyfile);
});

function loadMyfile(){
	//C:\fakepath\20110207024419-1451327809.jpg
	var str=$(this).val(); 
	//["C:", "fakepath", "20110207024419-1451327809.jpg"]
	var arr=str.split('\\');//注split可以用字符或字符串分割 
	//0110207024419-1451327809.jpg
	var my=arr[arr.length-1];//这就是要取得的图片名称 
	/*console.log(my);*/
	$("#addSonColumn_link").val(my);
}

function addSonColumn(){
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
	if($("#addSonColumn_oneMenu").find("option:selected").html() == "请选择分类"){
		alert("请在上级分类中选择分类");
		ok = false;
	}
	//获取oneMenuId
	var oneMenuId = $("#addSonColumn_oneMenu").find("option:selected").data("oneMenuId");
	/*alert(oneMenuId);*/
	var data = new FormData($( "#addSonColumn_form" )[0]);
	//data.append("参数名",参数值);
	data.append("oneMenuId",oneMenuId);
	if(ok){
		$.ajax({
			url : path + "/addSonColumn/addSonColumn.do",
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

function loadOneMenu(){
	
	//获取cookie中的oneMenuId
	var oneMenuCookieId = getCookie("oneMenuId")
	//判断cookie是否有效
	if(oneMenuCookieId==null){
		window.location.href="column.do";
	}
	//查询oneMenu
	$.ajax({
		url:path+"/column/loadMenu.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取map
				var map = result.data;
				//获取两个集合
				var oneMenuList = map.oneMenu;
				var twoMenuList = map.twoMenu;
				/*console.log(oneMenuList);
				console.log(twoMenuList);*/
				//创建下拉框
				createOption(oneMenuList,oneMenuCookieId);
			}
		},
		error : function() {
			alert("栏目加载失败!!!");
		}
	});
};

function createOption(oneMenuList,oneMenuCookieId){
	//循环处理
	for(var i=0;i<oneMenuList.length;i++){
		//获取id
		var oneMenuId = oneMenuList[i].id;
		//获取title
		var oneMenuTitle = oneMenuList[i].title;
		
		//创建页面显示字符串
		var soption="";
		soption+="<option value=''>";
		soption+=oneMenuTitle;
		soption+="</option>";
		//将字符串转换成jQuery对象
		var $option=$(soption);
		//将oneMenuId绑定到$option对象中
		$option.data("oneMenuId",oneMenuId);
		//将$option对象添加到select中
		$("#addSonColumn_oneMenu").append($option);
		//如果两个oneMenuId相同，则选中这条
		if(oneMenuCookieId==oneMenuId){
			var OneMenu = $option.prop('selected',true);
		}
	}
}