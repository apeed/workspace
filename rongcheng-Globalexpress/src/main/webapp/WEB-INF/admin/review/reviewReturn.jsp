<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/review/reviewReturn.js"></script>
  
</head>
<body>
<div class="panel admin-panel" style="height: 300px;overflow: auto;">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>评论回复</strong></div>
  <div class="body-content">
    <div class="form-x" id="reviewReturn_div1"></div>
  </div>
</div>
<div class="panel admin-panel" style="margin-top: 10px;">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>评论回复</strong></div>
  <div class="body-content">
    <div class="form-x">  
      <div class="form-group">
        <div class="label">
          <label>回复：</label>
        </div>
        <div class="field">
          <textarea id="review_adminReply"  name="content" class="input" style="padding: 0;height: 300px;"></textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o reviewReturn_btn"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
 <%-- var account1 = <%=session.getAttribute("account")%>;
	alert(account1); --%>
</body>
</html>