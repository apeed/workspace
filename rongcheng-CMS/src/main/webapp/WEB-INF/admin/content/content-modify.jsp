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
<link rel="stylesheet" href="/editor/themes/default/default.css" />
<script charset="utf-8" src="/editor/kindeditor-min.js"></script>
<script charset="utf-8" src="/editor/lang/zh_CN.js"></script>
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
<script src="/admin/jxb/js/jiml-utils.js"></script>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content1"]',{
		cssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		height : '400px',
	});
	prettyPrint();
	
});



function modify() {
	var data = new FormData($("#subForm")[0]);
	data.append("content1",editor1.html());
	$.ajax({
		url : "/admin/content/modifycontent/modify.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result.modify == 1) {
				queueShowMessage("修改成功");
				$("#iconUrlTemp").val(result.iconUrlTemp);
			} else {
				queueShowMessage("未进行修改");
			}
		},
		error : function() {
			queueShowMessage("修改失败");
		}
	});
}
function fileChange(){
	var file=$("#iconUrl").val();
	var filename=file.replace(/.*(\/|\\)/, "");  
	$("#fileName").val(filename);
}
</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <div class="form-x">
    <form id="subForm">
    <input name="id" value="${dcp.id }" style="display: none;">
      <div class="form-group">
        <div class="label">
          <label>内容页标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.contentTitle }" name="contentTitle"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容页子标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.contentSubtitle }" name="contentSubtitle"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容页英文标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.contentEnTitle }" name="contentEnTitle"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>接口显示名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.interfaceName }" name="interfaceName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.author }" name="author"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>缩略图：</label>
        </div>
        <div class="field">
          <input name="iconUrlTemp" id="iconUrlTemp" value="${dcp.iconUrl }" style="display: none;">
          <input type="text" id="fileName" class="input" style="width:25%; float:left;" value="${dcp.iconUrl }" disabled="disabled"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="iconUrl.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="iconUrl" name="iconUrl" uploader="uploader" class="file-btn" onchange="fileChange()">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>缩略图跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${dcp.iconDirectLink }" name="iconDirectLink"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>简介：</label>
        </div>
        <div class="field">
          <textarea class="input" name="contentProfile" style=" height:90px;">${dcp.contentProfile }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容：</label>
        </div>
        <div class="field">
          <textarea class="input" id="content1_id" name="content1" style="padding: 0;" disabled="disabled">${dcp.content1 }</textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容页标签：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${dcp.contentLabel }" name="contentLabel" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内部分类关键字：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${dcp.contentKeyword }" name="contentKeyword"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${dcp.note }" name="note"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${dcp.userSequence }" name="userSequence"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input value="1" type="radio" name="show" <c:if test="${dcp.show }">checked="checked"</c:if> />是
            <input value="0" type="radio" name="show" <c:if test="${!dcp.show }">checked="checked"</c:if> />否
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