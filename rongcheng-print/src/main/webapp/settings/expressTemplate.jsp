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
    <div class="panel-head"><strong class="icon-reorder"> 快递面单</strong></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o shade_btn" href="javascript:;"> 添加模板</a> </li>
        <!-- add_expressTemplate.html -->
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">ID</th>
        <th>图片</th>
        <th>名称</th>
        <th>物流公司</th>
        <th>模板类型</th>
        <th width="310">操作</th>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
 		  <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="id[]" value="1" class="check_coding" />1</td>
        <td width="10%"><img src="../images/abc.png" alt="" width="70" height="50" /></td>
        <td>菜鸟中通面单</td>
        <td>中通</td>
        <td>纸质模板</td>
        <td><div class="button-group"> <a class="button border-main" href="amend_expressTemplate.jsp"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
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


<!-- 点击遮罩 -->
<div class="shade">
  <div class="shade_box"></div>
  <div class="celect_menu">
    <ul class="logistics_company">
      <li class="company_head">快递公司</li>
      <li>百世快递</li>
      <li>圆通</li>
      <li>申通</li>
      <li>中通</li>
      <li>韵达</li>
      <li>顺丰</li>
      <li>急宅送</li>
      <li>EMS</li>
      <li>快捷</li>
      <li>全峰</li>
      <li>国通</li>
      <li>EMS经济</li>
      <li>邮政小包</li>
      <li>天天</li>
      <li>优速</li>
      <li>速尔</li>
      <li>龙邦</li>
      <li>德邦快递</li>
      <li>中国邮政</li>
      <li>京东</li>
      <li>百世物流</li>
      <li>安能物流</li>
      <li>德邦物流</li>
      <li>佳龙快运</li>
    </ul>
    <ul class="picture_menu">
      <li class="picture_head">面单图片</li>
      <li><img src="../images/abc.png" alt=""></li>
      <li><img src="../images/abc.png" alt=""></li>
      <li><img src="../images/abc.png" alt=""></li>
      <li><img src="../images/abc.png" alt=""></li>
    </ul>
    <ul class="search search_btn">
      <li> <a class="button border-main icon-plus-square-o shade_btn" href="add_expressTemplate.jsp"> 下一步</a> </li>
    </ul>
  </div>
</div>

</body>
</html>