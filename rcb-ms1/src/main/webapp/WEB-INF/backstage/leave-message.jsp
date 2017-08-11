<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit"></meta>
    <title></title>  
    <link rel="stylesheet" href="/backstage/css/pintuer.css"/>
    <link rel="stylesheet" href="/backstage/css/admin.css"/>
    <script src="/backstage/js/jquery.js"></script>
    <script src="/backstage/js/pintuer.js"></script>  
    <script src="/backstage/js/cookie_util.js"></script>
    <script src="/backstage/js/book.js"></script>
</head>
<body>
<form id = "fm1">
	<input type="hidden" name="now_page" /> 
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall" onclick="checkAll()"><span class="icon-check"></span>  反选</button>
          <button type="button"  class="button border-red" onclick="DelSelect()"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center" id = "booktable">

    </table>
  </div>
</form>

</body></html>