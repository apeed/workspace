<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/css/pintuer.css">
<link rel="stylesheet" href="/css/admin.css">
<script src="/js/jquery.js"></script>
<script src="/js/pintuer.js"></script>

 	<script src="/js/cookie_util.js"></script>
    <script src="/js/pass.js"></script>  
    <script src="/js/basevalue.js"></script>
    
    <script type="text/javascript">
    $(function(){
    	// 获取参数userId
		var userId=getCookie("userId");
    	/* alert(userId); */
		//判断userId是否有效
		if(userId==null){
			/* window.location.href="../rcb-ms/login.do"; */
		}
    });
    </script> 
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head">
    <strong>
      <span class="icon-key"></span> 
      修改管理员密码
    </strong></div>
  <div class="body-content">
    <div class="form-x">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
             <span id="pass_account_span"></span>
          </label>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="sentitle" value="" />
          <div class="tips"></div>
        </div>
      </div>   
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="tel" name="sentitle" value="" />
          <div class="tips"></div>
        </div>
      </div>    
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  id="email" name="sentitle" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码"/>     
          <div class="tips"></div>   
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="newPassword" name="newPassword" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位"/> 
          <div class="tips"></div>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="renewpass" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newPassword:两次输入的密码不一致"/> 
          <div class="tips"></div>          
        </div>
      </div>
  <!-- 提交按钮     -->
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="pass_submit"> 提交</button>   
        </div>
      </div>      
    </div>
  </div>
</div>
</body></html>