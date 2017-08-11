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
<link rel="stylesheet" href="/admin/css/search_xiala.css">
<link rel="stylesheet" href="/admin/css/admin.css">
  <style>
    textarea {
      display: block;
    }
  </style>
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/review/reviewAdd.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加评论</strong></div>
  <div class="body-content">
    <div class="form-x">  
      <div class="form-group">
        <div class="label">
          <label>商品编号：</label>
        </div>
        <div class="field" style="position: relative;" id="itemSku_div">
        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>客户账户：</label>
        </div>
        <div class="field" style="position: relative;" id="accountNum_div">
        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>客户姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value=""  id="review_userName" disabled="disabled" style="background: #fff;"/>
          <div class="tips" id="review_userName_ts" style="color:red"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>客户电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value=""  id="review_userTel" disabled="disabled" style="background: #fff;"  placeholder="请按格式输入0开头的 11,12位数字|1开头的手机号"/>
          <div class="tips" id="review_userTel_ts" style="color:red"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>客户邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value=""  id="review_accountEmail" disabled="disabled" style="background: #fff;" />
          <div class="tips" id="review_accountEmail_ts" style="color:red"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>评论内容 ：</label>
        </div>
        <div class="field">
          <textarea  id="review_userWord" name="content" class="input" style="padding: 0;"></textarea> 
          <div class="tips" id="review_userWord_ts" style="color:red"></div> 
        </div>
      </div>
      <!-- <div class="form-group">
        <div class="label">
          <label>评论时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="" name="s_title" value="" />
          <div class="tips" id="" ></div> 
        </div>
      </div> -->
      <div class="form-group">
        <div class="label">
          <label>评分：</label>
        </div>
        <div class="field">
          <select name="twocid" id="twocid" class="input w50">
            <option value="10">10</option>
            <option value="9">9</option>
            <option value="8">8</option>
            <option value="7">7</option>
            <option value="6">6</option>
            <option value="5">5</option>
            <option value="4">4</option>
            <option value="3">3</option>
            <option value="2">2</option>
            <option value="1">1</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="review_note" name="s_keywords" value=""/>
          <span class="tips" id="review_note_ts" style="color:red"></span> 
        </div>
      </div>
      <!-- <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="review_userSequence" name="s_keywords" value="" />
          <div class="tips" id="review_userSequence_ts" style="color:red"></div> 
        </div>
      </div> -->
      <div class="form-group">
        <div class="label">
          <label>是否显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input  value="1" type="radio" name="qt">是          
            <input  value="0"  type="radio" name="qt">否
             <span id="review_show_ts" style="color:red"></span> 
          </div>
        </div>
      </div>
       <span id="review_show_ts"></span>   
      <!-- <div class="form-group">
        <div class="label">
          <label>显示方式：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <input type="radio" name="iconUrl" id="listl" value="listline"> 列表        
          <input type="radio" name="iconUrl" id="listq" value="listsquare">图标
          <div class="tips" title=""></div>
        </div>
      </div> -->
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o reviewAdd_btn"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- <script>
    var editor;
    KindEditor.ready(function(K) {
      editor = K.create('textarea[name="content"]', {
        allowFileManager : true
      });
      editor.sync();
      $('textarea[name="content1"]').change(function(){
        alert(editor.text());
      })
    });
  </script> -->
</body>
</html>