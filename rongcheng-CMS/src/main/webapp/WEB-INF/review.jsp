<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/cookie_util.js"></script> 
<script src="js/review.js"></script>   
</head>
<body style="position:relative;">
<form id="fm1">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 评论管理</strong></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o" href="reviewAdd.do"> 添加评论</a> </li>
          <li>
            <input type="text" placeholder="可输入商品编号/客户账户/姓名/电话/邮箱/评论内容/备注信息" name="keywords" id="keywords" class="input" style="width:450px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
          <li> <a class="button border-main icon-plus-square-o modify_reviewList"> 评论不显示</a> </li>
          <li> <a class="button border-main noReply" href="javascript:;"> 不予回复</a> <li/>
        </ul>
      </div>
      <table class="table table-hover text-center" id="review_table">
      </table>
    </div>
  </div>
</form>
</body>
</html>