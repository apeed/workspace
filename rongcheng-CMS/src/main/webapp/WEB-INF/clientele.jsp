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
<script src="js/clientele.js"></script> 
<script src="js/alert_box.js"></script> 
</head>
<body style="position:relative;">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 客户管理</strong></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o clientele_add_btn" href="clienteleAdd.do"> 添加客户</a> </li>
          <!-- <li>
            <div class="change_column" style="width:100px;">
              <span>选择分类</span>
              <ul class="change_column_box">
                <li class="change_column_fu">
                  <ol>
                    <li>ID</li>
                    <li>栏目名称</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 30px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 30px;">└─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 60px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 60px;">└─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 90px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 90px;">└─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 30px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 30px;">└─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 60px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 60px;">└─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 90px;">├─公司简介</li>
                  </ol>
                </li>
                <li class="change_column_fu xiala_box">
                  <ol>
                    <li>1</li>
                    <li style="padding-left: 90px;">└─公司简介</li>
                  </ol>
                </li>
                <li style="margin-bottom:10px;" class="change_column_fu">
                  <button class="button border-black change_column_del" style="margin-left:10px;">提交</button>
                  <button class="button border-black change_column_del" style="margin-left:10px;">取消</button>
                </li>
              </ul>
            </div>
          </li> -->
          <li>
            <input type="text" placeholder="可输入账户名称/昵称/客户姓名/电话/手机/地址/备注信息" name="keywords" id="keywords" class="input" style="width:400px; line-height:17px;display:inline-block" />
            <a class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
        </ul>
      </div>
      <table class="table table-hover text-center" id="clientele_table">
        
   		  
      </table>
    </div>
  </div>
</body>
</html>