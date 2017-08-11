<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 发货单模板</strong></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o add_template"> 添加模板</a> </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">ID</th>
        <th>名称</th>
        <th>模板类型</th>
        <th>操作</th>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
 		  <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td>顺丰菜鸟面单</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_invoiceTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>       
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">


//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})




</script>
<div class="template_shade">
  <div class="template_btn"></div>
  <div class="template_content_box">
    <div class="template_content_title">选择模板类型</div>
    <div class="template_content">
      <ul class="template_content_list1">
        <li style="width:10%;text-align: right;">类  型：</li>
        <li class="radio_checked"><input type="radio" name="type">发货单</li>
        <li class="radio_checked"><input type="radio" name="type">入库单</li>
        <li class="radio_checked"><input type="radio" name="type">备货单</li>
      </ul>
      <ul class="template_content_list2">
        <li style="width:10%;text-align: right;">模板图片:</li>
        <li class="img_checked">
          <input type="radio" name="picture"><img src="../images/abc.png" alt=""><br>
          <span>发货单模板1</span>
        </li>
        <li class="img_checked">
          <input type="radio" name="picture"><img src="../images/abc.png" alt=""><br>
          <span>发货单模板2</span>
        </li>
      </ul>
      <ul class="template_content_list3">
        <li style="width:10%;text-align: right;">模板名称:</li>
        <li style="width:60%"><input type="text" class="input"></li>
      </ul>
      <ul class="search search_btn" style="padding-top:20px;">
        <li> <a class="button border-main icon-plus-square-o shade_btn" href="add_invoiceTemplate.jsp"> 下一步</a> </li>
      </ul>
    </div>
  </div>
</div>


</body>
</html>