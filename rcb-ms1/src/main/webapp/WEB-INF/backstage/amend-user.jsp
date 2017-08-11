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
<script src="/js/amend-user.js"></script>
<script src="/js/cookie_util.js"></script>
<script src="/js/basevalue.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改用户信息</strong></div>
  <div class="body-content">
    <div class="form-x"> 
    <div class="form-group">
        <div class="label">
          <label>账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" id="user_account" name="title" disabled="disabled"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="user_password" name="s_title" value="" />
          <div class="tips"></div> 
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" id="user_name" name="title"/>
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="user_tel" name="s_title" value="" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="user_email" name="s_title" value="" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="user_remark" name="s_keywords" value=""/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>可用：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <label class="button" id="label1">
              <span class="icon icon-check"></span>             
                <input name="isshow"  value="1" type="radio" >是             
            </label>             
            <label class="button" id="label2"><span class="icon icon-times"></span>            
                <input name="isshow" value="0"  type="radio" checked="checked">否
            </label>         
          </div>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" id="amend_user_button"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>