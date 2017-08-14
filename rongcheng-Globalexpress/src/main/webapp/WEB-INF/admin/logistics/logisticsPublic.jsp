<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<link rel="stylesheet" href="/admin/css/logistics.css">
  <style>
    textarea {
      display: block;
    }
  </style>
  <link rel="stylesheet" href="/editor/themes/default/default.css" />
  <script charset="utf-8" src="/editor/kindeditor-min.js"></script>
  <script charset="utf-8" src="/editor/lang/zh_CN.js"></script>
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/admin/js/logistics.js"></script>
<link rel="stylesheet" href="/admin/css/double-date.css">
<script src="/admin/js/double-date.js"></script>
<link rel="stylesheet" href="/data/jquery.datetimepicker.css">
<script src="/data/build/jquery.datetimepicker.full.js"></script>    
<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/logistics/logisticsPublic.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改物流</strong></div>
  <div class="body-content">
    <div class="form-x">
     <div class="form-group">
        <div class="label">
          <label>电商平台：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <span id="logisticsPublic_platformId"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>店铺名称：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <span id="logisticsPublic_shopId"></span>
          <div class="tips"></div>
        </div>
      </div>   
      <div class="form-group">
        <div class="label">
          <label>订单编号：</label>
        </div>
        <div class="field" style="line-height: 35px;">
          <span id="logisticsPublic_orderId"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>物流公司名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" id="logisticsPublic_carrierId" name="title"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>物流公司网址：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value="" id="logisticsPublic_carrierUrl"  name="title"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>物流单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" value=""  id="logisticsPublic_trackingNum" name="title"/>
          <div class="tips" id="logisticsPublic_trackingNum_ts" style="color:red"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>自定义物流记录 ：</label>
        </div>
        <div class="field">
          <textarea  id="logisticsPublic_userTrackingInfo" name="content" class="input" style="padding: 0;"></textarea> 
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group outer clearfix">
        <div class="label">
          <label>发生时间：</label>
        </div>
        <div class="field ">
          <input  id="some_class_1" type="text" class="input some_class"/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>订单当前位置：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_currentAddress" name="s_keywords" value=""/>
          <div class="tips"></div> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>订单所在站点：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_terminalId" name="sort" value=""/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>操作人：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_staffId" name="authour" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>操作人电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_operatorTel" name="views" value="" placeholder="0或1开头的11,12位数字"/>
          <div class="tips" id="logisticsPublic_operatorTel_ts" style="color:red"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>物流状态：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_cargoStatus" name="views" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>运输工具编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_facilityId" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>物流是否完成：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_complete" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>下一站地理位置：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_nextAddress" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>下一站点名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_nextTerminal" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>转运公司名称：</label>
        </div>
          <div class="field">
          <input type="text" class="input" id="logisticsPublic_transferCarrierId"  name="views" style="display: none;"/>
          <div class="transfer_company">
            <div class="transfer_btn"></div>
            <div class="transfer_list">
              <ul class="transfer_left">
                <li>常用</li>
                <li>A-C</li>
                <li>C-F</li>
                <li>F-H</li>
                <li>H-J</li>
                <li>J-M</li>
                <li>N-S</li>
                <li>S-T</li>
                <li>U-Y</li>
                <li>Y-Z</li>
                <li>Z</li>
              </ul>
              <div class="transfer_right">
                <ul id="often_use_express">
                	<!-- loadOftenUseExpress() -->
                </ul>
                <ul id="all_express">
                	<!-- loadAllExpress() -->
                </ul>
              </div>
            </div>
          </div>
          <div class="tips" id="logisticsAdd_transferCarrierId_ts" style="color:red"></div>
          </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>转运公司网址：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_transferCarrierUrl" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>转运物流单号：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_transferTrackingNum" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  id="logisticsPublic_note" name="views" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
            <input  value="1" type="radio" name="qt">是          
            <input  value="0"  type="radio" name="qt">否
          </div>      
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o logisticsPublic_btn logisticsPublic_btn"> 提交</button>
        </div>
      </div>
    </div>
  </div>
</div>
  <script>
      /* var editor1;
    KindEditor.ready(function(K) {
      editor = K.create('textarea[name="content"]', {
        allowFileManager : true
      });
      editor.sync();
      $('textarea[name="content"]').change(function(){
        alert(editor.text());
      })
    });   */
    $('.some_class').datetimepicker();
    var some_class=$(".some_class");
    some_class.change(function(){
    	var num=some_class.val();
    	var newnum=num.split('/');
    	var zhnum=newnum.join('-');
    	some_class.val(zhnum)
    })
  </script>
</body>
</html>