<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/backstage/css/pintuer.css">
<link rel="stylesheet" href="/backstage/css/admin.css">
<script src="/backstage/js/jquery.js"></script>
<script src="/backstage/js/pintuer.js"></script>
<script src="/backstage/js/cookie_util.js"></script>
<script src="/backstage/js/basevalue.js"></script>  
<script src="/backstage/js/list.js"></script></head>
<script src="/backstage/js/format_util.js"></script></head>
<body>
<div id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="addContent.do"> 添加内容</a> </li>
        <li>
          <select id="list_menu" name="cid" class="input" style="width:200px; line-height:17px;">
            <option value="">请选择分类</option>
            <!-- 自动加载menu -->
          </select>
        </li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a  class="button border-main icon-search" id="list_search" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center" id="list_table">
     
     <!--  <volist name="list" id="vo"> -->
        <!-- tr区域，循环显示内容 -->
      
    </table>
  </div>
</div>
</body>
</html>