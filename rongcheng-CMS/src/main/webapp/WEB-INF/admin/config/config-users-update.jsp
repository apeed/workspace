<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/admin/jxb/js/config/config-users-update.js"></script>
<script src="/admin/jxb/js/jiml-utils.js"></script> 
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改用户信息</strong></div>
  <div class="body-content">
    <div class="form-x">  
      <div class="form-group">
      <div class="form-group">
        <div class="label">
          <label>账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${user.accountNum }" disabled="disabled"/>
          <div class="tips"></div>
        </div>
      </div> 
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${user.userName }" name="userName"/>
          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="newPassword" value="" />
          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="userTelephone" value="${user.userTelephone }" />
          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="accountEmail" value="${user.accountEmail }" />
          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="note" value="${user.note }"/>
          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>可用：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
              <input name="accountStatus" value="true" type="radio" <c:if test="${user.accountStatus==true }">checked="checked"</c:if>>是
              <span><span class="icon-check" style="color:#2c7; display: none"></span></span>
              <input name="accountStatus" value="false"  type="radio" <c:if test="${user.accountStatus==false }">checked="checked"</c:if>>否
              <span><span class="icon-check" style="color:#2c7; display: none"></span></span>
          </div>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" id="subButton" > 提交</button>
          <form id="subForm"><input name="userId" value="${user.id }" style="display: none;"/></form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>