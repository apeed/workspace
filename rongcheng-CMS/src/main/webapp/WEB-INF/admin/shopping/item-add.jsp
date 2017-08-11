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
	editor1 = K.create('textarea[name="itemDetail"]',{
		cssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
	prettyPrint();
});

function add() {
	var data = new FormData($("#subForm")[0]);
	data.append("itemDetail",editor1.html());
	$.ajax({
		url : "/admin/item/additem/add.do",
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
function fileChange(){
	var file=$("#itemImage1").val();
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
      <div class="form-group">
        <div class="label">
          <label>商品sku：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <input type="text" class="input" value="" name="itemSku"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemName }" name="itemName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品简称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemShortName }" name="itemShortName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>接口显示名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.interfaceName }" name="interfaceName"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品品牌：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemBrand }" name="itemBrand"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品系列：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemSeries }" name="itemSeries"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品颜色：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemColor }" name="itemColor"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品尺码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.itemSize }" name="itemSize"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品条码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="${item.barCode }" name="barCode"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品图片：</label>
        </div>
        <div class="field">
          <input type="text" id="fileName" class="input" style="width:25%; float:left;"  value="${item.itemImage1 }"/>
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="itemImage1.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="itemImage1" name="itemImage1" class="file-btn" onchange="fileChange()">
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>商品简介：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="itemProfile" value="${item.itemProfile }" />
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品类型：</label>
        </div>
        <div class="field">
          <select name="itemType" class="input">
            <option value="1" <c:if test="${item.itemType==1 }">selected="selected"</c:if> >上架在售商品</option>
            <option value="2" <c:if test="${item.itemType==2 }">selected="selected"</c:if> >仓库下架商品</option>
          </select>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品详情：</label>
        </div>
        <div class="field">
          <textarea name="itemDetail" class="input" style="padding: 0;" disabled="disabled">${item.itemDetail }</textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品进价：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="costPrice" value="${item.costPrice }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品售价：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="normalPrice" value="${item.normalPrice }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品所在地：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="itemLocation" value="${item.itemLocation }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>库存数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="stockQuantity" value="${item.stockQuantity }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品标签：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="labelId" value="${item.labelId }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品关键词：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="itemKeyword" value="${item.itemKeyword }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="note" value="${item.note }"/>
          <div class="tips"></div> 
        </div>
      </div>
      <%-- <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="userSequence" value="${item.userSequence }"/>
          <div class="tips"></div>
        </div>
      </div> --%>
      <div class="form-group">
        <div class="label">
          <label>是否显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input  value="1" type="radio" name="show" <c:if test="${item.show }">checked="checked"</c:if> > 是&emsp;&emsp;
            <input  value="0" type="radio" name="show" <c:if test="${!item.show }">checked="checked"</c:if> > 否
          </div>      
        </div>
      </div>
      <%-- <div class="form-group">
        <div class="label">
          <label>显示方式：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <input type="radio" id="listl" value="listline"> 列表&emsp;
          <input type="radio" id="listq" value="listsquare"> 图标
          <div class="tips" title=""></div>
        </div>
      </div> --%>
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