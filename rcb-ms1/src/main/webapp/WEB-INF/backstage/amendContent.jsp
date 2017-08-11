<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/backstage/css/pintuer.css">
<link rel="stylesheet" href="/backstage/css/admin.css">
<style>
  textarea {
    display: block;
  }
</style>

<link rel="stylesheet" href="/backstage/editor/themes/default/default.css" />
<link rel="stylesheet" href="/backstage/editor/plugins/code/prettify.css" />
<script charset="utf-8" src="/backstage/editor/kindeditor.js"></script>
<script charset="utf-8" src="/backstage/editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="/backstage/editor/plugins/code/prettify.js"></script>

<script src="/backstage/js/jquery.js"></script>
<script src="/backstage/js/pintuer.js"></script>
<script src="/backstage/js/cookie_util.js"></script>  
<script src="/backstage/js/basevalue.js"></script>  
<script src="/backstage/js/amendContent.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
  <div class="body-content">
    <form class="form-x" id="amendContent_form">  
      <input type="hidden" name="id"  value="" />
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="title"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>短标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="shortTitle"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="text" readonly="readonly" name="link" id="amendContent_link" class="input tips" style="width:25%; float:left;background: #FFF;"  value="" />
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="amendContent_myfile.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="amendContent_myfile" name="upfile" class="file-btn">
        </div>
      </div>     
      <div class="form-group">
        <div class="label">
          <label>分类标题：</label>
        </div>
        <div class="field">
          <select name="cid" class="input w50" id="amendContent_menu">
            <option value="">请选择分类</option>
            <!-- 加载菜单Menu -->
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>简介：</label>
        </div>
        <div class="field">
          <textarea class="input" name="profile" style=" height:90px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容1：</label>
        </div>
        <div class="field">
          <textarea name="con1" class="input" style="padding: 0;height: 400px;"></textarea> 
          <div class="tips"></div> 
        </div>
      </div>
     <div class="form-group">
        <div class="label">
          <label>内容2：</label>
        </div>
        <div class="field">
          <textarea name="con2" class="input" style="padding: 0;height: 400px;"></textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容3：</label>
        </div>
        <div class="field">
          <textarea name="con3" class="input" style="padding: 0;height: 400px;"></textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>关键字：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="keyword" value="" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="remark" value=""/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="seq" value="100"  data-validate="number:排序必须为数字" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="author" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>点击次数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="click" value="0" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <label class="button active"  id="addSonColumn_yes">
              <span class="icon icon-check"></span>             
                <input name="display" value="1" type="radio" checked="checked">是             
            </label>             
            <label class="button active" id="addSonColumn_no">
            	<span class="icon icon-times"></span>            
                <input name="display" value="0"  type="radio" checked="checked">否
            </label>         
          </div>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="amendContent_button"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>