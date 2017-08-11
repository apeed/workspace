<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/backstage/css/pintuer.css">
    <link rel="stylesheet" href="/backstage/css/admin.css">
    <script src="/backstage/js/jquery.js"></script>
    <script src="/backstage/js/pintuer.js"></script>
    <script src="/backstage/js/cookie_util.js"></script>
    <script src="/backstage/js/basevalue.js"></script>
    <script src="/backstage/js/publicColumn.js"></script>
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改栏目</strong></div>
  <div class="body-content">
  <form method="post" class="form-x"  id="publicColum_form">   
    <input type="hidden" name="id"  value="" />  
    <div class="form-group">
      <div class="label">
        <label>栏目名称：</label>
      </div>
      <div class="field">
        <input type="text" class="input w50" name="title" value="" />         
        <div class="tips"></div>
      </div>
    </div> 
    <div class="form-group">
      <div class="label">
        <label>栏目图片：</label>
      </div>
      <div class="field">
        <input type="text" readonly="readonly" id="publicColumn_link" name="link" class="input tips" style="width:25%; float:left;background: #FFF;"  value=""/>
        <button type="button" class="btn btn-warning btn-s file-button"  onclick="publicColumn_myfile.click();" style="float: left;">
          <span class="glyphicon glyphicon-ban-circle"></span>十上传
        </button>
        <input type="file" id="publicColumn_myfile" name="upfile"  class="file-btn">
        <div class="tips"></div>
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>url链接：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="iconUrl" value="" />         
        <div class="tips"></div>
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>标题简介：</label>
      </div>
      <div class="field">
        <textarea type="text" class="input" name="profile" style="height:100px;" ></textarea>
        <div class="tips"></div>         
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>栏目关键字：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="keyword" value=""/>  
        <div class="tips"></div>        
      </div>
    </div>     
    <div class="form-group">
      <div class="label">
        <label>备注：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="remark" value="" /> 
        <div class="tips"></div>         
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>显示：</label>
      </div>
      <div class="field">
        <div class="button-group radio">
          <label class="button active" id="publicColumn_yes">
            <span class="icon icon-check"></span>             
              <input name="display" value="1" type="radio" checked="checked">是             
          </label>             
          <label class="button active" id="publicColumn_no">
          	  <span class="icon icon-times"></span>            
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
        <input type="text" class="input w50" name="seq" value="100" />
        <div class="tips"></div>
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label></label>
      </div>
      <div class="field">
        <button class="button bg-main icon-check-square-o" type="button" id="publicColumn_button"> 提交</button>
      </div>
    </div>
  </form>
  </div>
  </div>
</body>
</html>