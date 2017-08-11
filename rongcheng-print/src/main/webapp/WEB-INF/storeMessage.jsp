<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script> 
    <script src="js/basevalue.js"></script>
    <script src="js/cookie_util.js"></script> 
    <script src="js/storeMessage.js"></script>  
    <script type="text/javascript">
     $(function() {
    	if(getCookie("ownerId")==null){
    		top.location.href="admin.do";
    	}
	}); 
</script>
</head>
<body>
<form id = "fm1">
<!-- <input type="hidden" name="now_page" /> -->
  <div class="panel admin-panel">
	<div class="panel-head"><strong class="icon-reorder"> 商品信息设置</strong></div>
	<div class="padding border-bottom">
	<ul class="search">
	<li>
	<button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
	<button type="button" class="button border-main batch"><span class="icon-edit"></span> 批量编辑</button>
	<button type="button" class="button" onclick="saveItemCommonInfos()"><span class="icon-edit"></span> 批量保存</button>
	</li>
	</ul>
	</div>
	<table class="table table-hover text-center" id="storeMessage_table">
   	
	
	</table>
	</div>
</form>

  <!-- 批量编辑弹出框 -->
  <div class="shade_compile">
    <div class="shade_beij">
      
    </div>
    <div class="shade_content">
      <div class="panel admin-panel" style="border:none;">
        <div class="body-content">
          <div class="form-x">  
            <div class="form-group">
              <div class="label" style="width: 20%;">
                <label>短标题：</label>
              </div>
              <div class="field" style="width: 80%;">
                <input type="text" class="input shade_compile_text" value="" name="title"/>
                <div class="tips"></div>
              </div>
            </div> 
            <div class="form-group ">
              <div class="label" style="width: 20%;">
                <label></label>
              </div>
              <div class="field" style="width: 80%;">
                <button class="button bg-main icon-check-square-o shade_compile_button"> 提交</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
    //全选
   /*  var ids = new Array();
    ids.push($(this).val()); */
    
    $("#checkall").click(function(){ 
      $("input[name='id1']").each(function(){
        if (this.checked) {
          this.checked = false;
        }
        else {
          this.checked = true;
        }
      });
    })
  </script>
</body></html>