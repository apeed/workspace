function addUser() {
    	var accountNum = $("[name='accountNum']").val().trim();
    	$("[name='accountNum']").val(accountNum);
    	var password = $("[name='password']").val().trim();
    	$("[name='password']").val(password);
    	var rePassword = $("#rePassword").val().trim();
    	if(accountNum=="" || password==""){
    		queueShowMessage("请填写完整账号密码");
    		return;
    	}
    	if(password != rePassword){
    		queueShowMessage("请确认两次密码一致性，且不允许有空格");
    		return;
    	}
    	var data = new FormData($("#subForm")[0]);
    	$.ajax({
    		url : "/admin/config/adduser.do",
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
    			} else {
    				queueShowMessage("新增失败");
    			}
    		},
    		error : function() {
    			queueShowMessage("新增失败");
    		}
    	});
    }
	function chick(obj) {
		$.ajax({
    		url : "/admin/config/chickuser.do",
    		type : "post",
    		dataType : "json",
    		data : {"accountNum":$(obj).val().trim()},
    		success : function(result) {
    			if (result == 0) {
    				$("#accountNum").html("");
    			} else {
    				$("#accountNum").html("已被使用");
    			}
    		},
    		error : function() {
    			queueShowMessage("查询失败");
    		}
    	});
	}