<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
    <script src="/admin/lsx/js/cookie_util.js"></script> 
	<script src="/admin/lsx/js/book/bookMore.js"></script>    
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>更多留言</strong></div>
  <div class="body-content">
  <div class="form-x">   
    <input type="hidden" name="id"  value="" />  
    <div class="form-group">
      <div class="label">
        <label>姓名：</label>
      </div>
      <div class="field">
        <input type="text" class="input w50" id="bookMore_userName" name="title" value="" readonly="readonly" style="background: #fff;cursor:default;" />
        <div class="tips"></div>          
      </div>
    </div> 
    <div class="form-group">
      <div class="label">
        <label>电话：</label>
      </div>
      <div class="field">
        <input type="text" class="input" id="bookMore_userTel" name="entitle" value=""  readonly="readonly" style="background: #fff;cursor:default;" />
        <div class="tips"></div> 
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>邮箱：</label>
      </div>
      <div class="field">
        <input type="text" class="input" id="bookMore_userEmail"  name="entitle" value=""  readonly="readonly" style="background: #fff;cursor:default;" />
        <div class="tips"></div> 
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>留言内容：</label>
      </div>
      <div class="field">
        <textarea class="input" id="bookMore_userWord" name="s_desc" style="height:100px;background: #fff;cursor:default;"  readonly="readonly"cursor:default;></textarea>    
        <div class="tips"></div>     
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>留言时间：</label>
      </div>
      <div class="field">
        <input type="text" class="input" id="bookMore_userWordTime"  name="s_keywords" value="" readonly="readonly" style="background: #fff;cursor:default;" />  
        <div class="tips"></div>        
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>回复内容：</label>
      </div>
      <div class="field">
        <textarea class="input" id="bookMore_adminReply" name="s_desc" style="height:100px;" ></textarea>     
        <div class="tips" id="bookMore_adminReply_ts" style="color:red"></div>    
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>备注：</label>
      </div>
      <div class="field">
        <input type="text" class="input" id="bookMore_note"  name="s_title" value="" />    
        <div class="tips" id="bookMore_note_ts" style="color:red"></div>      
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>显示：</label>
      </div>
      <div class="field">
        <div class="button-group radio">
          <label class="button active" id="label1">
            <span class="icon icon-check"></span>             
              <input name="isshow" value="1" type="radio" checked="checked">是             
          </label>             
          <label class="button active" id="label2"><span class="icon icon-times"></span>            
              <input name="isshow" value="0"  type="radio" checked="checked">否
          </label>         
        </div>       
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>排序：</label>
      </div>
      <div class="field">
        <input type="text" class="input w50" id="bookMore_userSequence" name="sort" value="0"  data-validate="required:,number:排序必须为数字" />
        <div class="tips"></div>
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label></label>
      </div>
      <div class="field">
        <a class="button bg-main icon-check-square-o" href="javascript:;" id="modify_button"> 提交</a>
      </div>
    </div>
  </div>
  </div>
  </div>
</body>
</html>