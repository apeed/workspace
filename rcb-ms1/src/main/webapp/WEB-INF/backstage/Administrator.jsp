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
<script src="/js/Administrator.js"></script>
<script src="/js/cookie_util.js"></script>
<script src="/js/basevalue.js"></script>
</head>
<body>
<div id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="add-user.do"> 添加用户</a> </li> 
      </ul>
    </div>
    <table class="table table-hover text-center" id="user_table">
      <tr>
        <th width="100" >ID</th>
        <th>账号</th>
        <th>姓名</th>
        <th>电话</th> 
        <th>邮箱</th>
        <th>状态</th>
        <th>备注</th>
        <th width="310">操作</th>
      </tr>
    </table>
  </div>
</div>
<script type="text/javascript">

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
</body>
</html>