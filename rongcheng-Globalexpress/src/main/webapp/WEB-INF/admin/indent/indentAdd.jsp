<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<script src="/admin/js/logistics.js"></script>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
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

<script src="/admin/lsx/js/cookie_util.js"></script> 
<script src="/admin/lsx/js/indent/indentAdd.js"></script>
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
            <input type="text" class="input" value=""  id="indentAdd_consigneeTel" name="title" placeholder="请按格式输入0开头的数字"/>
            <div class="tips" id="indentAdd_consigneeTel_ts" style="color:red"></div>
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
        <input type="text" class="input" id="indentAdd_carrierId" name="s_title" value="" />
          <div class="transfer_company"  style="display:none;">
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
                <ul>
                  <li>顺丰</li>
				  <li style="display:none">12</li>
                  <li>EMS</li>
                  <li>中通</li>
                  <li>申通</li>
                  <li>圆通</li>
                  <li>韵达</li>
                  <li>百世汇通</li>
                  <li>天天快递</li>
                  <li>邮政小包</li>
                  <li>全峰</li>
                  <li>快捷快递</li>
                  <li>国通</li>
                  <li>德邦快递</li>
                  <li>速尔</li>
                  <li>fedex国内</li>
                  <li>德邦物流</li>
                </ul>
                <ul>
                  <li>安捷快递</li>
                  <li>安能物流</li>
                  <li>安信达快递</li>
                  <li>澳邮专线</li>
                  <li>百福东方</li>
                  <li>百世快运</li>
                  <li>北青小红帽</li>
                  <li>CCES快递</li>
                  <li>CNPEX中邮快递</li>
                  <li>COE东方快递</li>
                  <li>成都善途速运</li>
                  <li>城际快递</li>
                  <li>城市100</li>
                  <li>长沙创一</li>
                  <li>D速物流</li>
                  <li>大田物流</li>
                  <li>EMS</li>
                  <li>FEDEX联邦(国际件)</li>
                  <li>FEDEX联邦(国内件)</li>
                  <li>泛捷快递</li>
                  <li>飞康达</li>
                  <li>高铁速递</li>
                  <li>共速达</li>
                  <li>广东邮政</li>
                  <li>海派通物流公司</li>
                  <li>好来运快递</li>
                  <li>恒路物流</li>
                  <li>鸿桥供应链</li>
                  <li>华强物流</li>
                  <li>华夏龙物流</li>
                  <li>汇丰物流</li>
                  <li>汇强快递</li>
                  <li>急先达</li>
                  <li>加运美</li>
                  <li>佳吉快运</li>
                  <li>佳怡物流</li>
                  <li>嘉里物流</li>
                  <li>捷特快递</li>
                  <li>晋越快递</li>
                  <li>京广速递</li>
                  <li>九曳供应链</li>
                  <li>跨越物流</li>
                  <li>快客速递</li>
                  <li>联昊通速递</li>
                  <li>龙邦快递</li>
                  <li>民航快递</li>
                  <li>明亮物流</li>
                  <li>能达速递</li>
                  <li>PCA Express</li>
                  <li>平安达腾飞快递</li>
                  <li>全晨快递</li>
                  <li>全日通快递</li>
                  <li>全一快递</li>
                  <li>如风达</li>
                  <li>瑞丰速递</li>
                  <li>赛澳递</li>
                  <li>上大物流</li>
                  <li>圣安物流</li>
                  <li>盛邦物流</li>
                  <li>盛丰物流</li>
                  <li>盛辉物流</li>
                  <li>速必达物流</li>
                  <li>速腾快递</li>
                  <li>速通物流</li>
                  <li>唐山申通</li>
                  <li>天地华宇</li>
                  <li>UEQ Express</li>
                  <li>万家物流</li>
                  <li>万象物流</li>
                  <li>希优特</li>
                  <li>新邦物流</li>
                  <li>新杰物流</li>
                  <li>信丰快递</li>
                  <li>亚风快递</li>
                  <li>亚马逊物流</li>
                  <li>亿翔快递</li>
                  <li>义达国际物流</li>
                  <li>优速快递</li>
                  <li>原飞航物流</li>
                  <li>源安达快递</li>
                  <li>远成物流</li>
                  <li>越丰物流</li>
                  <li>运通快递</li>
                  <li>增益快递</li>
                  <li>宅急送</li>
                  <li>中铁快运</li>
                  <li>中铁物流</li>
                  <li>中邮物流</li>
                  <li>众通快递</li>
                </ul>
              </div>
            </div>
          </div>
           <div class="tips" id="indentAdd_carrierId_ts" style="color:red"></div> 
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
                  <!-- <div class="re_cha change_column_del">×</div> -->
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
      <div class="delete_btn">×
      </div>
    </div>
  </div>
  </form>
</body>
<script src="js/alert_box.js"></script>
</html>