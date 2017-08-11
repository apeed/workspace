<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/pintuer.js"></script>  
    <script src="/js/adv.js"></script>  
    <script src="/js/cookie_util.js"></script>  
    <script src="/js/basevalue.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 轮播列表</strong></div>
  <div class="padding border-bottom">  
    <a class="button border-yellow" href="addAdv_title.do"><span class="icon-plus-square-o"></span> 添加轮播图栏目</a>
  </div> 
  <div class="table table-hover text-center" id="aimMenu_table">
    <ul class="table-ul" id="first_table-ul">
      <!-- <li class="">ID</li>  -->    
      <li class="">排序</li>
      <li class="">栏目名称</li>  
      <li class="">备注</li>   
      <li class="">操作</li>
    </ul>
    <!-- <ul class="table-ul">
      <li>01</li>      
      <li>轮播图1</li>  
      <li>1</li>  
      <li>备注</li>     
      <li>
      <div class="button-group">
        <a type="button" class="button border-main" href="amend-advTitle.html"><span class="icon-edit"></span>修改</a>
        <a class="button border-red" href="javascript:void(0)" onclick="return deleteAIM(17)"><span class="icon-trash-o"></span> 删除</a>
        <a class="button border-yellow" href="addadv.html"><span class="icon-plus-square-o"></span> 添加轮播图</a>
      </div>
      </li>
    </ul> 
     <ul class="table-ul table-ul-son">
       <li>1</li>      
       <li> ├─公司简介</li>  
       <li>1</li>  
       <li>备注</li>     
       <li>
       <div class="button-group">
         <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
         <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
       </div>
       </li>
     </ul>
     <ul class="table-ul table-ul-son">
       <li>2</li>      
       <li> ├─公司简介</li>  
       <li>2</li>  
       <li>备注</li>     
       <li>
       <div class="button-group">
         <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
         <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
       </div>
       </li>
     </ul>  
     <ul class="table-ul table-ul-son">
       <li>3</li>      
       <li> └─公司简介</li>  
       <li>3</li>  
       <li>备注</li>     
       <li>
       <div class="button-group">
         <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
         <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
       </div>
       </li>
     </ul>   
    <ul class="table-ul">
      <li>01</li>      
      <li>轮播图2</li>  
      <li>1</li>  
      <li>备注</li>     
      <li>
      <div class="button-group">
        <a type="button" class="button border-main" href="amend-advTitle.html"><span class="icon-edit"></span>修改</a>
        <a class="button border-yellow" href="addadv.html"><span class="icon-plus-square-o"></span> 添加轮播图</a>
      </div>
      </li>
    </ul> 
    <ul class="table-ul table-ul-son">
      <li>1</li>      
      <li> ├─公司简介</li>  
      <li>1</li>  
      <li>备注</li>     
      <li>
      <div class="button-group">
        <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
        <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </li>
    </ul>
    <ul class="table-ul table-ul-son">
      <li>2</li>      
      <li> ├─公司简介</li>  
      <li>2</li>  
      <li>备注</li>     
      <li>
      <div class="button-group">
        <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
        <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </li>
    </ul>  
    <ul class="table-ul table-ul-son">
      <li>3</li>      
      <li> └─公司简介</li>  
      <li>3</li>  
      <li>备注</li>     
      <li>
      <div class="button-group">
        <a type="button" class="button border-main" href="amend-adv.html"><span class="icon-edit"></span>修改</a>
        <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </li>
    </ul>  -->  
      
  </div>
</div>
<!-- <script>
function del(id){
  if(confirm("您确定要删除吗?")){  
  }
}
</script> -->
</body></html>