$(function(){
	//id自增，剞劂
	$("#addAdv_title_button").click(subAction);
	$("#addAdv_title_moduleName").blur(function(){
		//清空提示信息
		$("#addAdv_title_moduleName_span").html("");
		//获取请求参数
		var moduleName=$("#addAdv_title_moduleName").val().trim();
		if(moduleName==""){
			$("#addAdv_title_moduleName_span").html("标题为空");
		}
	});
	$("#addAdv_title_remark").blur(function(){
		//清空提示信息
		$("#addAdv_title_remark_span").html("");
		//获取请求参数
		var remark=$("#addAdv_title_remark").val().trim();
		if(remark==""){
			$("#addAdv_title_remark_span").html("标题为空");
		}
	});
	$("#addAdv_title_display").blur(function(){
		//清空提示信息
		$("#addAdv_title_display_span").html("");
		//获取请求参数
		var display=$("#addAdv_title_display").val().trim();
		if(display==""){
			$("#addAdv_title_display_span").html("标题为空");
		}
	});
	
});

function subAction(){
	var addModuleName=$("#addAdv_title_moduleName").val();
	var addRemark=$("#addAdv_title_remark").val();
	var addDisplay=$("input[name='isshow']:checked").val();
	var ok=true;

	if(addModuleName==""){
		ok=false;
	}
	if(addRemark==""){
		ok=false;
	}
	if(addDisplay==""){
		ok=false;
	}
	//从cookie中获取id
//	var userId = getCookie('userId');
	if(ok){
		$.ajax({
			url:"addAdvTitle/addTitleCol.do",
			type:"post",
			dataType:"json",
			data:{"moduleName":addModuleName,
				"remark":addRemark,
				"display":addDisplay},
				success:function(result){
				if(result.state==0){
					alert("添加轮播图标题成功！！");
				}
				window.location.href = "adv.do";		
			},
			error:function(){
				alert("添加轮播图标题失败！！");
			}
		});
	}
}