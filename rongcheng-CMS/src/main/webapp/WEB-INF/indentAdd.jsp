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
  <style>
    textarea {
      display: block;
    }
  </style>
  <link rel="stylesheet" href="editor/themes/default/default.css" />
  <script charset="utf-8" src="editor/kindeditor-min.js"></script>
  <script charset="utf-8" src="editor/lang/zh_CN.js"></script>
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/indentAdd.js"></script>
<script src="js/cookie_util.js"></script>   
</head>
<body style="position: relative;">
<form id="fm1">
  <div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
      <div class="form-x">  
        <div class="form-group">
          <div class="label">
            <label>订单编号：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value="" id="orderId" name="orderId"/>
            <div class="tips" id="indentAdd_orderNum_ts" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>发件人：</label>
          </div>
          <div class="field">
            <select  id="indentAdd_consignorId" name="twocid" class="input">
              <option value="">发件人</option>
            </select>
            <div class="tips" id="" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>收件人：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value=""  id="indentAdd_consigneeId" name="title"/>
            <div class="tips" id="indentAdd_consigneeId" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>收件人电话：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value=""  id="indentAdd_consigneeTel" name="title"/>
            <div class="tips" id="indentAdd_consigneeTel" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>收件人地址：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value=""  id="indentAdd_consigneeAddress" name="title"/>
            <div class="tips" id="indentAdd_consigneeAddress" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>订单标签：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value=""  id="indentAdd_orderLabel" name="title"/>
            <div class="tips" id="indentAdd_orderLabel" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>内部分类关键字：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value=""  id="indentAdd_orderKeyword" name="title"/>
            <div class="tips" id="indentAdd_orderKeyword_ts" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>订单商品：</label>
          </div>
          <div class="field">
            <a href="javascript:;" class="button border-main icon-search alert_page"> 添加商品</a>
            <div class="tips" id="" style="color:red"></div> 
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>物流公司名称：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_carrierId" name="s_title" value="" />
            <div class="tips" id="indentAdd_carrierId" style="color:red"></div> 
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>物流单号：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_trackingNum" name="s_keywords" value=""/>
            <div class="tips" id="indentAdd_trackingNum" style="color:red"></div> 
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>包裹重量：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_packageWeight" name="sort" value=""/>
            <div class="tips" id="indentAdd_packageWeight" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>订单总运费：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_totalShippingFee" name="authour" value=""  />
            <div class="tips" id="indentAdd_totalShippingFee" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>保价金额：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_supportValue" name="views" value="" />
            <div class="tips" id="indentAdd_supportValue_ts" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>备注：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="indentAdd_note" name="views" value="" />
            <div class="tips" id="indentAdd_note" style="color:red"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label></label>
          </div>
          <div class="field">
            <button type="button" class="button bg-main icon-check-square-o indent_add_btn"> 提交</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <div class="alert_data-box">
    <div class="alert_data">
      <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">添加商品</strong></div>
        <div class="padding border-bottom">
          <ul class="search" style="padding-left:10px;">
            <li>类目：</li>
            <li>
              <div class="change_column_inner" style="width:100px;">
                <div class="change_column">选择分类</div>
                <ul class="change_column_box">
                	<!-- 加载类目 -->
                  <div class="re_cha change_column_del"></div>
                </ul>
              </div>
            </li>
            <li>搜索框：</li>
            <li>
              <input type="text" placeholder="请输入编码/名称/规格搜索" id="keywords" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
              <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
          </ul>
        </div>
        <table class="table table-hover text-center itemInfo_table">
        </table>
      </div>
      <div class="panel admin-panel" style="border:none;">
        <div class="body-content">
          <div class="form-x">  
            <div class="form-group ">
              <div class="label">
                <label></label>
              </div>
              <div class="field">
                <button  type="button" class="button bg-main icon-check-square-o getItemID"> 提交</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="delete_btn">
      </div>
    </div>
  </div>
  </form>
</body>
<script src="js/alert_box.js"></script>
</html>