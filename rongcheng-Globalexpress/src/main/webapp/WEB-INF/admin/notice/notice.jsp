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
    <script src="/admin/lsx/js/cookie_util.js"></script> 
	<script src="/admin/lsx/js/notice/notice.js"></script>
    <!-- <script src="js/startUsing.js"></script> -->
</head>
<body>
<form id="fm1">
  <div class="panel admin-panel" style="min-width:900px;">
    <div class="panel-head"><strong class="icon-reorder"> 公告管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="noticeAdd.do"> 添加公告</a> </li>
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="button" class="button border-red notice_delList"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
        <li>
          <input type="text" placeholder="可输入公告名称/公告内容/注意事项/备注信息" id="keywords" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center" id="statementNotice_table">
       <!-- <tr>
        <th width="50">ID</th>
        <th>名称</th>       
        <th>作者</th>
        <th width="400">公司公告</th>
        <th>备注</th>
        <th width="120">修改时间</th>
        <th width="200">操作</th>       
      </tr>      
      <tr>
        <td>1</td>
        <td>公司公告</td>
        <td>张三</td>
        <td><div class="w400_gsgg">张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话</div></td>  
         <td>备注</td>
        <td>2016-07-01</td>
        <td><div class="button-group"> 
          <a type="button" class="button border-main" href="noticePublic.html"><span class="icon-edit"></span>修改</a>
          <a class="button border-red" href="javascript:;"><span class="icon-trash-o"></span>清空</a> 
        </div></td>
      </tr>
      <tr>
        <td>1</td>
        <td>注意事项</td>
        <td>张三</td>
        <td><div class="w400_gsgg">张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话张三说了一句话</div></td>  
         <td>备注</td>
        <td>2016-07-01</td>
        <td><div class="button-group"> 
          <a type="button" class="button border-main" href="noticePublic.html"><span class="icon-edit"></span>修改</a>
          <a class="button border-red" href="javascript:;"><span class="icon-trash-o"></span>清空</a> 
        </div></td>
      </tr>
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>  -->
    </table>
  </div>
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
</form>
</body></html>