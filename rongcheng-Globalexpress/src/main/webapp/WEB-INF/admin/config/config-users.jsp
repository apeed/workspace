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
<script src="/admin/jxb/js/jiml-utils.js"></script>
<script src="/admin/jxb/js/config/config-users.js"></script>

</head>
<body>
<div id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="/admin/config/toadduser.do"> 添加用户</a> </li> 
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="button" class="button border-red" onclick="deleteUser(-1)"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <form id="subForm">
    <table class="table table-hover text-center" id = "usersTable">
      <tr>
        <th width="80">ID</th>
        <th>账号</th>
        <th>姓名</th>
        <th>电话</th> 
        <th>邮箱</th>
        <th>状态</th>
        <th>备注</th>
        <th width="310">操作</th>
      </tr>
    </table>
    </form>
  </div>
</div>
</body>
</html>