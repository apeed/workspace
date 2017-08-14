<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<script src="/admin/js/logistics.js"></script>
<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/logistics/logistics.js"></script>
<script src="/admin/jxb/js/jiml-utils.js"></script>
<style type="text/css">
.wlxq_wk:hover .wlxq_nk{
		display: block;
	}
/* #logistics_divP p {
	display: inline-block;
	color: black;
	text-decoration: underline;
	font
} */
</style>
</head>
<body style="position:relative;">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 物流管理</strong></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o logisticsAdd_btn" href="logisticsAdd.do "> 添加物流信息</a> </li>
          <li>
            <input type="text" placeholder="可输入订单编号/物流公司/物流单号/物流记录/标签/备注信息" name="keywords" id="keywords" class="input" style="width:450px; line-height:17px;display:inline-block" />
            <a class="button border-main icon-search" href="javascript:0" onclick="changesearch()" > 搜索</a></li>
        </ul>
      </div>
      <table class="table table-hover text-center" id="logistics_table">
        
      </table>
    </div>
  </div>
</body>
</html>