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
<script src="js/addresser.js"></script> 
</head>
<body style="position:relative;">
<form id="fm1">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 发件人管理</strong></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o" href="addresserAdd.do"> 添加发件人</a> </li>
          <li>
            <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
            <button type="button" class="button border-red addresser_delList"><span class="icon-trash-o"></span> 批量删除</button>
          </li>
          <li>
            <input type="text" placeholder="可输入发件人姓名/电话/地址/备注信息" name="keywords" id="keywords"  class="input" style="width:300px; line-height:17px;display:inline-block" />
            <a class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
        </ul>
      </div>
      <table class="table table-hover text-center"  id="addresser_table">
      </table>
    </div>
  </div>
</form>
</body>
<script type="text/javascript">

  var flag=true;
  $("#checkall").click(function(){ 
    if(flag){
        flag=false;
        $('tr').find('input').prop('checked',true);
    }else{
      flag=true;
        $('tr').find('input').prop('checked',false);
    }
  })

</script>
</html>