<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
function add() {
	var data = new FormData($("#subForm")[0]);
	$.ajax({
		url : "/admin/content/addmedia/add.do",
		type : "post",
		dataType : "json",
		data : data,
		async: false,
        cache: false,  
        contentType: false,  
        processData: false,
		success : function(result) {
			if (result == 1) {
				queueShowMessage("新增成功");
			} else {
				queueShowMessage("新增失败");
			}
		},
		error : function() {
			queueShowMessage("新增失败");
		}
	});
}
function fileChange(obj){
	var filename=$(obj).val().replace(/.*(\/|\\)/, "");  
	$("#"+$(obj).attr("id")+"FileName").val(filename);
}
</script>


</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <div class="form-x">
    <form id="subForm">
      <div class="form-group">
	      <div class="label">
	          <label>内容类型：</label>
	        </div>
	        <div class="field">
	          <select name="mediaType" class="input w50">
	            <option value="1">图片</option>
	            <option value="2">视频</option>
	          </select>
	          <div class="tips"></div>
	        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="mediaName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>接口显示名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="interfaceName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件：</label>
        </div>
        <div class="field">
          <input type="text" id="mediaUrlFileName" class="input" style="width:25%; float:left;" value="" disabled="disabled"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="mediaUrl.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="mediaUrl" name="mediaUrl" uploader="uploader" class="file-btn" onchange="fileChange(this)">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>媒体文件跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" name="mediaDirectLink"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文案：</label>
        </div>
        <div class="field">
          <textarea class="input" name="wordDesign" style=" height:90px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>缩略图：</label>
        </div>
        <div class="field">
          <input type="text" id="iconUrlFileName" class="input" style="width:25%; float:left;" value="" disabled="disabled"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="iconUrl.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" name="iconUrl" id="iconUrl" uploader="uploader" class="file-btn" onchange="fileChange(this)">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>缩略图跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" name="iconDirectLink"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>媒体文件标签：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" name="mediaLabel"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内部分类关键字：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" name="mediaKeyword"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" name="note"/>
          <div class="tips"></div> 
        </div>
      </div>
      <%-- <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="userSequence"/>
          <div class="tips"></div>
        </div>
      </div> --%>
      <div class="form-group">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input  value="1" type="radio" name="show">是          
            <input  value="0"  type="radio" name="show">否
          </div>    
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" onclick="add()"> 提交</button>
        </div>
      </div>
      </form>
    </div>
  </div>
</div>
<script src="../js/alert_box.js"></script>
</body>
</html>