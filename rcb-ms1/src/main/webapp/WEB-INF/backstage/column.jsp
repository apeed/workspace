<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/backstage/css/pintuer.css">
    <link rel="stylesheet" href="/backstage/css/admin.css">
    <script src="/backstage/js/jquery.js"></script>
    <script src="/backstage/js/pintuer.js"></script>  
    <script src="/backstage/js/column.js"></script>  
    <script src="/backstage/js/cookie_util.js"></script>  
    <script src="/backstage/js/basevalue.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 栏目列表</strong></div>
  <div class="padding border-bottom">  
    <a class="button border-yellow" href="addColumn.do"><span class="icon-plus-square-o"></span> 添加栏目</a>
  </div> 
  <div class="table table-hover text-center" id="column_table">
    <ul class="table-ul">
      <li class="">序号</li>     
      <li class="">栏目名称</li>  
     <!--  <li class="">排序</li> -->
      <li class="">备注</li>   
      <li class="">操作</li>
    </ul>
    
</div>

</body></html>