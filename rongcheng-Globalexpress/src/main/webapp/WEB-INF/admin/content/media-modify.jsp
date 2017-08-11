<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
  <style>
    textarea {
      display: block;
    }
  </style>
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
<script src="/admin/jxb/js/jiml-utils.js"></script>
<script src="/admin/jxb/js/content/media-modify.js"></script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <div class="form-x">
    <form id="subForm">
    <input name="id" value="${mi.id }" style="display: none;">
      <div class="form-group">
	      <div class="label">
	          <label>内容类型：</label>
	        </div>
	        <div class="field">
	          <select name="mediaType" class="input w50">
	            <option value="1" <c:if test="${mi.mediaType==1 }">selected="selected"</c:if> >图片</option>
	            <option value="2" <c:if test="${mi.mediaType==2 }">selected="selected"</c:if> >视频</option>
	          </select>
	          <div class="tips"></div>
	        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${mi.mediaName }" name="mediaName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>接口显示名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${mi.interfaceName }" name="interfaceName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件：</label>
        </div>
        <div class="field">
          <input name="mediaUrlTemp" id="mediaUrlTemp" value="${mi.mediaUrl }" style="display: none;">
          <input type="text" id="mediaUrlFileName" class="input" style="width:25%; float:left;" value="${mi.mediaUrl }" disabled="disabled"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="mediaUrl.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="mediaUrl" name="mediaUrl" class="file-btn" onchange="fileChange(this)">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>媒体文件跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${mi.mediaDirectLink }" name="mediaDirectLink"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文案：</label>
        </div>
        <div class="field">
          <textarea class="input" name="wordDesign" style=" height:90px;">${mi.wordDesign }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>缩略图：</label>
        </div>
        <div class="field">
          <input name="iconUrlPath" id="iconUrlPath" value="${mi.iconUrl }" style="display: none;">
          <input type="text" id="iconUrlFileName" class="input" style="width:25%; float:left;" value="${mi.iconUrl }" disabled="disabled"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="iconUrl.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" name="iconUrl" id="iconUrl" class="file-btn" onchange="fileChange(this)">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>缩略图跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${mi.iconDirectLink }" name="iconDirectLink"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件标签：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${mi.mediaLabel }" name="mediaLabel"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内部分类关键字：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${mi.mediaKeyword }" name="mediaKeyword"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${mi.note }" name="note"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${mi.userSequence }" name="userSequence"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group" style="display: none;">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input  value="1" type="radio" name="show" <c:if test="${mi.show }">checked="checked"</c:if> >是          
            <input  value="0" type="radio" name="show" <c:if test="${!mi.show }">checked="checked"</c:if> >否
          </div>    
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" onclick="modify()"> 提交</button>
        </div>
      </div>
      </form>
    </div>
  </div>
</div>
<script src="../js/alert_box.js"></script>
</body>
</html>