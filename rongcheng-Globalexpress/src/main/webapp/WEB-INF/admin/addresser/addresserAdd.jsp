<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
	<script src="/admin/lsx/js/cookie_util.js"></script> 
	<script src="/admin/lsx/js/addresser/addresserAdd.js"></script>
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加发件人</strong></div>
    <div class="body-content">
      <div class="form-x" >   
        <div class="form-group">
          <div class="label">
            <label>发件人姓名：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="addresser_userName" name="title" value=""/>         
            <div class="tips" id="addresser_userName_ts" style="color:red"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>发件人电话：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="addresser_userTelephone" name="title" value="" placeholder="请按格式输入0开头的数字" />         
            <div class="tips" id="addresser_userTelephone_ts" style="color:red"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>发件地址：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="addresser_userAddress" name="title" value=""/>         
            <div class="tips" id="addresser_userAddress_ts" style="color:red"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>备注：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="addresser_note" name="title" value=""/>         
            <div class="tips" id="addresser_note_ts" style="color:red"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label></label>
          </div>
          <div class="field">
            <button class="button bg-main icon-check-square-o addresser_addBtn" type="button"> 提交</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>