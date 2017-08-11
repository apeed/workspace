var path="/admin";
//存放的临时cookie，用于替代登录保存的内容
/*addCookie("ownerId",2);
addCookie("operatorId",2);
addCookie("authorization",true);*/
//启动第二套，用于测试打印
addCookie("ownerId",1);
addCookie("operatorId",1);
addCookie("authorization",true);

//addCookie("columnType", "column");
//addCookie("columnType", "type");

/**
 * 1.加载校验
 * @param jumpPath 跳转的相对路径
 * @returns
 */
function loadCheckpoint(jumpPath){
	//获取主账号ID
	var ownerId = getCookie("ownerId");
	//判断是否为null
	if (ownerId == "" || ownerId == undefined || ownerId == null || typeof(ownerId) == "undefined" || ownerId == 0){ 
		alert("帐号不存在，请重新登录");
		window.location.href=jumpPath;
	}
	//获取操作人ID
	var operatorId = getCookie("operatorId");
	//判断是否为null
	if (operatorId == "" || operatorId == undefined || operatorId == null || typeof(operatorId) == "undefined" || 
			operatorId == 0){ 
		alert("操作人不存在，请重新登录");
		window.location.href=jumpPath;
	}
};
