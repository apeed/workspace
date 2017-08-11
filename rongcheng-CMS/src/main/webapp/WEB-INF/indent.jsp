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
<link rel="stylesheet" href="css/indent.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/indent.js"></script>  
<script src="js/cookie_util.js"></script> 
</head>
<body style="position:relative;">
<form id="fm1">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 订单管理</strong></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o" href="indentAdd.do"> 添加订单</a> </li>
          <li>
            <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          </li>
          <li>
          <button type="button" class="button border-red indent_delList"><span class="icon-trash-o" ></span> 批量删除</button>
          </li>
          <li>
            <select name="fukuancit" id="fukuancit" class="input" style="width: 150px;">
              <option value="">选择订单</option>
              <option value="1">未付款订单</option>
              <option value="2">已付款订单</option>
              <option value="3">已发货订单</option>
              <option value="4">已完成订单</option>
              <option value="5">退款中订单</option>
              <option value="6">关闭的订单</option>
            </select>
          </li>
          <li>
            <input type="text" placeholder="可输入订单编号/收件人/电话/地址/订单商品/物流公司 /物流单号/标签/备注信息" id="keywords" name="keywords" class="input" style="width:500px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
        </ul>
      </div>
      <div class="table table-hover text-center" id="indent_table">
        <!-- 弹出框 -->
          <!-- <ol class="indent_ol">
          <li>
            <div class="button-group"> 
              <a href="javascript:;" class="button border-main indent_tkcl"><span class="icon-edit"></span> 退款处理</a>
              <div class="indent_fh_div">
                <span class="button border-main indent_fh" style="cursor: pointer;"><span class="icon-edit"></span> 发货</span>
                <div class="indent_fh_box">
                  <div class="panel admin-panel">
                    <div class="body-content" style="padding-bottom:0;">
                      <div class="form-x"> 
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>快递公司：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <select name="twocid" class="input" style="width: 100%">
                              <option value="1">中通</option>
                              <option value="2">申通</option>
                              <option value="3">圆通</option>
                            </select>
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>快递单号：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <input type="text" class="input" value="" style="width:100%"/>
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label></label>
                          </div>
                          <div class="field" style="width:390px;">
                            <button class="button border-main icon-check-square-o"> 发货</button>
                            <button class="button border-red icon-check-square-o indent_fh_qx"> 取消</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div> 
              <a class="button border-main indent_xg" href="indentPublic.do"><span class="icon-edit"></span> 修改</a> 
              <div class="indent_fh_div" style="display:block;">
                 <span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>
                <div class="indent_bz_box">
                  <div class="panel admin-panel">
                    <div class="body-content" style="padding-bottom:0;">
                      <div class="form-x"> 
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>备注：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <textarea class="input" name="note" style=" height:90px;width:100%"></textarea>
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label></label>
                          </div>
                          <div class="field" style="width:390px;">
                            <button class="button border-main icon-check-square-o"> 提交</button>
                            <button class="button border-red icon-check-square-o indent_bz_qx"> 取消</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>  
              <a class="button border-red indent_del_button" href="javascript:;" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> 
              <a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>
            </div>
          </li>
        </ol>
        <div class="erzi">
          <ol class="indent_son_ol">
            <li><img src="../images/11.jpg" alt="" width="60" height="40" /></li>
            <li>15641864684</li>
            <li>名称名称名称名称名称名称</li>
            <li>10000.55555</li>
            <li>10</li>
          </ol>
          <ol class="indent_son_ol">
            <li><img src="../images/11.jpg" alt="" width="60" height="40" /></li>
            <li>15641864684</li>
            <li>名称名称名称名称名称名称</li>
            <li>10000.55555</li>
            <li>10</li>
          </ol>
          <ol class="indent_son_ol">
            <li><img src="../images/11.jpg" alt="" width="60" height="40" /></li>
            <li>15641864684</li>
            <li>名称名称名称名称名称名称</li>
            <li>10000.55555</li>
            <li>10</li>
          </ol>
          <ol class="indent_son_ol">
            <li style="text-align:right;width: 50%;">总运费：<span>1541</span></li>
            <li style="text-align:right;width: 50%;padding-right:50px;">订单总金额：<span>2654</span></li>
          </ol>
        </div>
   		  <ol class="indent_ol">
          <li>
            <div class="button-group"> 
              <a href="javascript:;" class="button border-main indent_tkcl"><span class="icon-edit"></span> 退款处理</a>
              <div class="indent_fh_div">
                <span class="button border-main indent_fh" style="cursor: pointer;"><span class="icon-edit"></span> 发货</span>
                <div class="indent_fh_box">
                  <div class="panel admin-panel">
                    <div class="body-content" style="padding-bottom:0;">
                      <div class="form-x"> 
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>快递公司：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <input type="text" class="input" value="" style="width:100%" />
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>快递单号：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <input type="text" class="input" value="" style="width:100%"/>
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label></label>
                          </div>
                          <div class="field" style="width:390px;">
                            <button class="button border-main icon-check-square-o"> 发货</button>
                            <button class="button border-red icon-check-square-o indent_fh_qx"> 取消</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <a class="button border-main indent_xg" href="indentPublic.html"><span class="icon-edit"></span> 修改</a> 
              <div class="indent_fh_div">
                <span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>
                <div class="indent_bz_box">
                  <div class="panel admin-panel">
                    <div class="body-content" style="padding-bottom:0;">
                      <div class="form-x"> 
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label>备注：</label>
                          </div>
                          <div class="field" style="width:390px;">
                            <textarea class="input" name="note" style=" height:90px;width:100%"></textarea>
                            <div class="tips"></div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="label" style="width:100px;">
                            <label></label>
                          </div>
                          <div class="field" style="width:390px;">
                            <button class="button border-main icon-check-square-o"> 提交</button>
                            <button class="button border-red icon-check-square-o indent_bz_qx"> 取消</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>  
              <a class="button border-red indent_del_button" href="javascript:;" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> 
              <a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>
            </div>
          </li>
        </ol> -->
        <!-- <div class="erzi">
          <ol class="indent_son_ol">
            <li><img src="../images/11.jpg" alt="" width="60" height="40" /></li>
            <li>15641864684</li>
            <li>名称名称名称名称名称名称</li>
            <li>10000.55555</li>
            <li>10</li>
          </ol>
          <ol class="indent_son_ol">
            <li><img src="../images/11.jpg" alt="" width="60" height="40" /></li>
            <li>15641864684</li>
            <li>名称名称名称名称名称名称</li>
            <li>10000.55555</li>
            <li>10</li>
          </ol>
          <ol class="indent_son_ol">
            <li style="text-align:right;width: 50%;">总运费：<span>1541</span></li>
            <li style="text-align:right;width: 50%;padding-right: 50px;">订单总金额：<span>2654</span></li>
          </ol>
        </div> -->
     	

      </div>
    </div>
  </div>
  </form>
  	
</body>
<script type="text/javascript">

 var flag=true;
$("#checkall").click(function(){ 
  if(flag){
      flag=false;
      $('li').find('input').prop('checked',true);
  }else{
    flag=true;
      $('li').find('input').prop('checked',false);
  } 
})

</script>
<script src="js/alert_box.js"></script>
</html>