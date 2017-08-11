<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/css/pintuer.css">
<link rel="stylesheet" href="/css/admin.css">
<script src="/js/jquery.js"></script>
<script src="/js/addAdv-title.js"></script>
<script src="/js/basevalue.js"></script>
<script src="/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel margin-top" id="add">
	  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 轮播图标题添加</strong></div>
	  <div class="body-content">
	    <div class="form-x">    
		    <div class="form-group">
		        <div class="label">
		          <label>名称：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50"  id="addAdv_title_moduleName" name="url" value=""  />
		           <span id="addAdv_title_moduleName_span" style="color:red;"></span>
		          <div class="tips"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>备注：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input" id="addAdv_title_remark" name="url" value=""  />
		          <span id="addAdv_title_remark_span" style="color:red;"></span> 
				<div class="tips"></div>
		        </div>
		    </div>
		    <div class="form-group">
		      <div class="label">
		        <label>显示：</label>
		      </div>
		      <div class="field">
		        <div class="button-group radio">
		          <label class="button active">
		            <span class="icon icon-check"></span>             
		              <input name="isshow" value="1" type="radio" checked="checked">是             
		          </label>             
		          <label class="button active"><span class="icon icon-times"></span>            
		              <input name="isshow" value="0"  type="radio" checked="checked">否
		          </label>         
		        </div>
		        <span id="addAdv_title_display_span" style="color:red;"></span>        
		      </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label></label>
		        </div>
		        <div class="field">
		          <button class="button bg-main icon-check-square-o" id="addAdv_title_button"> 提交</button>
		        </div>
		    </div>
	    </div>
	  </div>
	</div>
</body>
</html>