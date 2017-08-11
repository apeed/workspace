<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script> 
    
    <script src="/admin/jxb/js/jiml-utils.js"></script>
    <script type="text/javascript">
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
    </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加用户信息</strong></div>
  <div class="body-content">
    <div class="form-x">
    <form id="subForm">
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="userName"/>
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="accountNum" onchange="chick(this)"/>
          <div class="tips" id="accountNum"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="password" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>确认密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="rePassword"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="userTelephone" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="accountEmail" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="note"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>账户状态：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input value="true" type="radio" name="accountStatus">启用             
            <input value="false"  type="radio" name="accountStatus" checked="checked">停用
          </div>    
        </div>
      </div>
    </form>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" onclick="addUser()"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>