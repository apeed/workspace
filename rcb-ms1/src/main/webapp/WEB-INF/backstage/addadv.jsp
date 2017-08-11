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
<script src="/js/pintuer.js"></script>
<script src="/js/addadv.js"></script>  
<script src="/js/cookie_util.js"></script>  
<script src="/js/basevalue.js"></script> 
</head>
<body>
	<div class="panel admin-panel margin-top" id="add">
	  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 轮播图片添加</strong></div>
	  <div class="body-content">
	   <form id="addAdv_form">
	    <div class="form-x">    
		    <div class="form-group">
		        <div class="label">
		          <label>标题：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" value="" id="addAdv_title" name="title" />
		            
		          <div class="tips" id="addAdv_title_span"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>链接：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50"  id="addAdv_link" name="link" value=""  />
		          <div class="tips"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>关键字：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" id="addAdv_keyword" name="keyword" value=""  />
		          <div class="tips"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>图片：</label>
		        </div>
		        <div class="field">
		          <input type="text" id="url1" name="imgUrl" class="input" style="width:25%; float:left;"  value=""/>
		       
		          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="addAdv_myfile.click();" style="float: left;">
		            <span class="glyphicon glyphicon-ban-circle"></span>十上传
		          </button>
		          <input type="file" name="qwe" id="addAdv_myfile" uploader="uploader" class="file-btn">
		          <div class="tips" id="addAdv_imgUrl_span"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>备注：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input" id="addAdv_remark" name="remark" value=""  />
		          <div class="tips"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>简介：</label>
		        </div>
		        <div class="field">
		          <textarea type="text" class="input" id="addAdv_profile" name="profile" style="height:120px;" value=""></textarea>
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
		              <input name="display" value="1" type="radio" checked="checked">是             
		          </label>             
		          <label class="button active"><span class="icon icon-times"></span>            
		              <input name="display" value="0"  type="radio" checked="checked">否
		          </label>         
		        </div>       
		      </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label>排序：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" id="addAdv_seq" name="seq" value="0"/>
		          
				<div class="tips" id="addAdv_seq_span"></div>
		        </div>
		    </div>
		    <div class="form-group">
		        <div class="label">
		          <label></label>
		        </div>
		        <div class="field">
		          <button class="button bg-main icon-check-square-o" id="addAdv_button" type="button"> 提交</button>
		        </div>
		    </div>
	    </div>
	    </form>
	  </div>
	  
	</div>
</body>
</html>