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
  <style>
    textarea {
      display: block;
    }
  </style>
 <link rel="stylesheet" href="editor/themes/default/default.css" />
<link rel="stylesheet" href="editor/plugins/code/prettify.css" />
<script charset="utf-8" src="editor/kindeditor.js"></script>
<script charset="utf-8" src="editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="editor/plugins/code/prettify.js"></script>
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/cookie_util.js"></script> 
<script src="js/noticePublic.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <div class="form-x">
      <div class="form-group">
        <div class="label">
          <label>公告名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="notice_statementTitle" name="authour" value=""  />
          <div class="tips" id="notice_statementTitle_ts" style="color:red"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea name="content1" id="a1" value="" class="input" style="padding: 0;"></textarea> 
          <div class="tips"  id="notice_statement_ts" style="color:red"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>注意事项：</label>
        </div>
        <div class="field">
          <textarea   name="content2" class="input" value="" style="padding: 0;"></textarea> 
          <div class="tips"  id="notice1_ts" style="color:red"></div> 
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="notice_note" name="authour" value=""  />
          <div class="tips" id="notice_note_ts" style="color:red"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o modify_btn"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
  <script>
    /* var editor1;
    KindEditor.ready(function(K) {
      editor1 = K.create('textarea[name="content1"]', {
        allowFileManager : true
      });
      editor1.sync();
      $('textarea[name="content1"]').change(function(){
        alert(editor1.text());
      })
    });
    var editor2;
    KindEditor.ready(function(K) {
      editor2 = K.create('textarea[name="content2"]', {
        allowFileManager : true
      });
      editor2.sync();
      $('textarea[name="content2"]').change(function(){
        alert(editor2.text());
      })
    }); */
  </script>
</body>
</html>