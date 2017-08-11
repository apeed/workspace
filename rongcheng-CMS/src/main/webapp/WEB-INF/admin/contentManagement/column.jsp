<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    
    <script src="/admin/zb/js/contentManagement/cookie_util.js"></script>
    <script src="/admin/zb/js/contentManagement/basevalue.js"></script>
    <script src="/admin/zb/js/contentManagement/column.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"></strong></div>
  <div class="padding border-bottom after">  
    <ul class="search" style="padding-left:10px;">
      <li style="float: left;"><a class="button border-yellow column_addParent" style="float: left;" href="javascript:void(0)"><span class="icon-plus-square-o"></span></a></li>
      <li>
        <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
        <button type="button" class="button border-red" id="column_batch_del"><span class="icon-trash-o"></span> 批量删除</button>
      </li>
      <li style="float: left;">
        <input type="text" placeholder="" id="column_search_keywords" name="keywords" class="input" style="width:350px; line-height:17px;display:inline-block" />
        <a href="javascript:void(0)" class="button border-main icon-search" id="column_search"> 搜索</a></li>
      <li style="color:#f00;margin-left: 10px;line-height:30px;" id="column_prompt">
        
      </li>
    </ul>
  </div> 
  <div class="table table-hover text-center" id="column_table">
    <!-- 加载栏目 -->    
  </div>
</div>
  <script type="text/javascript">
  var flag=true;
  $("#checkall").click(function(){ 
    if(flag){
        flag=false;
        $('li').find('input').prop('checked',true);
    }else{
      flag=true;
        $('li').find('input').prop('checked',false);
    }
  })
  </script>
</body>
</html>