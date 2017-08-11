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
<script src="js/ExpressPartition.js"></script> 
<script type="text/javascript" src="/region/js/jquery.citys.js"></script>
<script type="text/javascript">
      $(function() {
    	/* if(getCookie("ownerId")==null){
    		top.location.href="admin.do";
    	} */
    	
	});  
</script>
</head>
<body>
<form id = "fm1">
<div id="listform">
  <div class="panel admin-panel kdfq">
    <div class="panel-head"><strong class="icon-reorder"> 快递分区设置</strong></div>
    <ol class="table table-hover text-center" id="region_table">
     
    </ol>
  </div>
</div>
<script type="text/javascript">

</script>
<div class="shade_wai">
  <div class="shade_hei"></div>
<div class="shade_content" style="height:260px;">
    <h2>选择地区/快递</h2>
    <div class="shade_list">
      <!-- <span>市：</span>
      <select name="" id="city">
      <option value="qingxuanze">请选择</option>
      </select>
      <span>区：</span> 
      <select name="" id="area">
      <option value="qingxuanze">请选择</option>
      </select> -->
      <div id="addrDiv">
	        <!-- <select id="province" name="province"class="input" style="width:200px; line-height:17px;display:inline-block;"></select> -->  
			<select id="city" name="city" class="input" style="width:200px; line-height:17px;display:inline-block;"></select>  
			<select id="area" name="area"class="input" style="width:200px; line-height:17px;display:inline-block;"></select> 
      </div>
    </div>
    <div class="shade_list">
      <span>快递：</span>
      <select name="" id="carrier_name">
        <option value="qingxuanze">请选择</option>
        <option value="1">顺丰</option>
        <option value="2">中通</option>
        <option value="3">申通</option>
        <option value="4">圆通</option>
        <option value="5">韵达</option>
        <option value="6">EMS</option>
        <option value="7">汇通</option>
        <option value="8">宅急送</option>
        <option value="9">京东快递</option>
        <option value="10">天天快递</option>
        <option value="11">德邦快递</option>
        <option value="12">德邦物流</option>
        <option value="13">邮政小包</option>
        <option value="14">EMS经济快递</option>
        <option value="15">百世物流</option>
        <option value="16">龙邦</option>
        <option value="17">速尔</option>
        <option value="18">全峰</option>
        <option value="19">国通</option>
        <option value="20">快捷快递</option>
        <option value="21">优速</option>
        <option value="22">中国邮政</option>
        <option value="23">安能物流</option>
        <option value="24">佳龙快运</option>
      </select> 
    </div>
     <div class="shade_list" style="margin-top: 10px;">
      <span>选择模板：</span>
      <select name="" id="select_mod" style="width: 200px;">
        <option value="qingxuanze">请选择</option>
      </select>
    </div>
    <div class="panel admin-panel" style="border:none;">
      <div class="body-content">
        <div class="form-x">  
          <div class="form-group form-padding">
            <div class="label">
              <label></label>
            </div>
            <div class="field">
              <button class="button bg-main icon-check-square-o modifyArea_btn"> 提交</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- 快递分区-快递模板选择 -->
<div class="express_box">
  <div class="express_content">
    <h1>普通面单打印</h1>
    <ul class="express_list mod_print">
      <!-- <li>
        <span style="padding-left: 50px;">名称</span><span>类型</span>
      </li>
      <li id="ul" value="">
        <span><input type="radio" id="exp_templateName" name="one" checked="true"> 张三设置的模板</span><span id="exp_templateType">热敏的</span>
      </li> -->
      
    </ul>
    <div class="express_tj">
        <button class="button border-main mod2" href="javascript:;" style="margin-right: 50px;"><span class="icon-print"></span> 提交</button> 
        <button class="button border-main del_express_btn" href="javascript:;"><span class="icon-trash-o"></span> 取消</button> 
    </div>
  </div>
</div>
</form>
</body>
</html>