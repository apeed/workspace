$(function(){
	//加载loadAdvTitle页面
	loadAdvTitle();
	//修改确定按钮的单击事件
	$("#amend_advTitle_button").click(modifyTitleAdv);


});


function modifyTitleAdv(){
	var aimMenuId = getCookie("aimMenuId")
	//判断cookie是否有效
	if(aimMenuId==null){
		window.location.href="amend_adv.do";	
		
	}
	var advamend_moduleName=$("#amend_title_moduleName").val();
	var advamend_remark=$("#amend_title_remark").val();
	var advDisplay=$("input[name='isshow']:checked").val();
	//..bug,是否显示，选否，获取的值是1
	var ok = true;
//	console.log(advamend_moduleName,advamend_remark,advDisplay);
	
	if(advamend_moduleName==""){
		//$("#advpop_title_span").html("标题为空");
		ok=false;
	}
	if(advamend_remark==""){
		
		ok=false;
	}
	if(advDisplay==""){
		
		ok=false;
	}
	
	//int id,String moduleName,String remark,Byte display
	if(ok){
		$.ajax({
			url:"adv/modifyTitle.do",
			type:"post",
			dataType:"json",
			data:{
			"id":aimMenuId,	
			"moduleName":advamend_moduleName,
			"remark":advamend_remark,
			"display":advDisplay
			},
			 success:function(result){
				if(result.state==0){//成功
					alert("修改成功！"); 	
					/*window.location.href = path +"/adv.do";	*/
				}
			},
			error:function(){
				alert("修改失败！"); 
			}
		});
	}

		
}


function loadAdvTitle(){
	// 获取参数userId
	var userId=getCookie("userId");
	/*//判断userId是否有效
	if(userId==null){
		window.location.href="login.do";
	}*/
	
	//获取cookie中的aiMenuId
	var aimMenuId = getCookie("aimMenuId");
	//判断cookie是否有效
	if(aimMenuId==null){
		window.location.href="amend_adv.do";
	}
		
	//发送ajax
	$.ajax({
		url : "adv/loadTitle.do",
		type : "post",
		data : {"id":aimMenuId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var AlternateImgModule = result.data;
/*				console.log(AlternateImgModule);
*/				//获取各项数值

				var AlternateImgModuleModuleName = AlternateImgModule.moduleName;
				var AlternateImgModuleRemark = AlternateImgModule.remark;
				var AlternateImgModuleDisplay = AlternateImgModule.display;
				
				//获取各个内容框，绑定他们哟
				var advamend_moduleName=$("#amend_title_moduleName").val(AlternateImgModuleModuleName);
				var advamend_remark=$("#amend_title_remark").val(AlternateImgModuleRemark);
				if(AlternateImgModuleDisplay==0){
					$("#label0").attr("class", "button active");
				}else if(AlternateImgModuleDisplay==1){
					$("#label1").attr("class", "button active");
				}
				
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
}
