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
  <style>
    textarea {
      display: block;
    }
  </style>
  <link rel="stylesheet" href="/editor/themes/default/default.css" />
  <script charset="utf-8" src="/editor/kindeditor-min.js"></script>
  <script charset="utf-8" src="/editor/lang/zh_CN.js"></script>
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/notice/noticeAdd.js"></script>
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
          <input type="text" class="input"  id="notice_statementTitle" name="authour" value=""  />
          <div class="tips" id="notice_statementTitle_ts" style="color:red"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea name="content1" class="input" style="padding: 0;"></textarea> 
          <div class="tips"  id="editor1_ts" style="color:red"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>注意事项：</label>
        </div>
        <div class="field">
          <textarea name="content2" class="input" style="padding: 0;"></textarea> 
          <div class="tips" id="editor2_ts" style="color:red"></div> 
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
          <button class="button bg-main icon-check-square-o add_btn"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
  <script>
    /* var editor;
    KindEditor.ready(function(K) {
      editor = K.create('textarea[name="content"]', {
        allowFileManager : true
      });
      editor.sync();
      $('textarea[name="content1"]').change(function(){
        alert(editor.text());
      })
    }); */
  </script>
</body>
</html>