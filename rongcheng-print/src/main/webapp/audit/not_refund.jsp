<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>待打印订单</title>  
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>  
</head>
<body>
  <div class="panel admin-panel" style="margin-bottom: 20px;">
    <div class="panel-head"><strong class="icon-reorder">订单查询</strong></div>
    <div class="body-content" style="padding-bottom:0;">
      <div class="form-x">  
        <div class="form-group">
          <div class="label">
            <label>时间：</label>
          </div>
          <ul class="field">
            <li class="button border-main">当日订单</li>
            <li class="button border-main">3日内订单</li>
            <li class="button border-main">7日内订单</li>
            <li class="button border-main">30日内订单</li>
            <li class="button border-main"><input type="text" class="input" style="width:50px;display:inline-block;height:20px;"><span>日到</span><input type="text" class="input" style="width:50px;display:inline-block;height:20px;">日订单</li>
          </ul>
        </div>
        <div class="form-group">
          <div class="label">
            <label>默认项：</label>
          </div>
          <ul class="field">
            <li class="button border-main">有留言备注</li>
            <li class="button border-main">有发票</li>
            <li class="button border-main">有退款</li>
            <li class="button border-main">村镇订单</li>
            <li class="button border-main">货到付款</li>
            <li class="button border-main">无退款</li>
          </ul>
        </div>  
        <div class="form-group">
          <div class="label">
            <label>快递公司：</label>
          </div>
          <ul class="field">
            <li class="button border-main">百世快递</li>
            <li class="button border-main">EMS</li>
            <li class="button border-main">申通</li>
            <li class="button border-main">圆通</li>
            <li class="button border-main">中通</li>
            <li class="button border-main">韵达</li>
            <li class="button border-main">百世快递</li>
            <li class="button border-main">EMS</li>
            <li class="button border-main">申通</li>
            <li class="button border-main">圆通</li>
            <li class="button border-main">中通</li>
            <li class="button border-main">韵达</li>
            <li class="button border-main">EMS</li>
            <li class="button border-main">申通</li>
            <li class="button border-main">圆通</li>
            <li class="button border-main">中通</li>
            <li class="button border-main">韵达</li>
          </ul>
        </div>  
        <div class="form-group ">
          <div class="label">
            <label></label>
          </div>
          <div class="field">
            <button class="button bg-main" style="margin-left:20px;"><span class="icon-search"></span> 查询</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">未付款订单</strong></div>
    <div class="table table-hover text-center">
      <ul class="table-ul">
        <li>系统单号</li>     
        <li>来源</li>  
        <li>买家呢称</li>
        <li>收件地址</li> 
        <li>快递</li>  
        <li>下发仓库</li>
        <li>审核关注点</li>
        <li>留言备注</li>
        <li title="普通面单需要输入单号,电子面单自动获取">快递单号</li>
        <li>付款时间</li>
        <li>操作</li>
      </ul>
      <ul class="table-ul">
        <li><input type="checkbox" name="id[]" value="" />T35335779</li>      
        <li>美国专柜</li>  
        <li>张三丰</li> 
        <li>天津市天津区天津县天津村天津街天津门</li> 
        <li>
          <div class="button border-main xialaBtn">
            <span class="icon-plus"></span> 中通
            <ul>
              <li>百世快递</li>
              <li>圆通</li>
              <li>申通</li>
              <li>中通</li>
              <li>韵达</li>
              <li>顺丰</li>
              <li>急宅送</li>
              <li>EMS</li>
              <li>快捷</li>
              <li>全峰</li>
              <li>国通</li>
              <li>EMS经济</li>
              <li>邮政小包</li>
              <li>天天</li>
              <li>优速</li>
              <li>速尔</li>
              <li>龙邦</li>
              <li>德邦快递</li>
              <li>中国邮政</li>
              <li>京东</li>
              <li>百世物流</li>
              <li>自提</li>
              <li>百世保价</li>
              <li>安能物流</li>
              <li>UPS</li>
              <li>联邦快递</li>
              <li>美国邮政</li>
              <li>风火天地</li>
              <li>联合快递</li>
              <li>众焱速递</li>
              <li>高宏铁快递</li>
              <li>高铁快递</li>
              <li>德邦物流</li>
              <li>佳龙快运</li>
              <li>邮政标准</li>
            </ul>
          </div> 
        </li>  
        <li>二号仓库</li> 
        <li>属于城镇订单</li>
        <li>这个件买家很着急</li>   
        <li><input type="text" class="input" title="普通面单需要输入单号,电子面单自动获取" placeholder="普通面单需要输入单号,电子面单自动获取"></li>
        <li>2017/06/09/14:39</li>
        <li>
          <div class="button-group">
            <a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>
          </div>
        </li>
        <div class="table-ul-son erzi">
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>新生成的订单号（这里是数字）</li>
            <li>总重：0 kg</li>
          </ul>
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>新生成的订单号（这里是数字）</li>
            <li>总重：0 kg</li>
          </ul>  
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>新生成的订单号（这里是数字）</li>
            <li>总重：0 kg</li>
          </ul> 
          <ul>
            <li>总数量： <span>1</span></li>
            <li>总价： <span>￥1.65元</span></li>
          </ul>  
        </div>
      </ul> 
      <ul class="table-ul">
        <li><input type="checkbox" name="id[]" value="" />T35335779</li>      
        <li>美国专柜</li>  
        <li>张三丰</li> 
        <li>天津市天津区天津县天津村天津街天津门</li> 
        <li>
          <div class="button border-main xialaBtn">
            <span class="icon-plus"></span> 中通
            <ul>
              <li>百世快递</li>
              <li>圆通</li>
              <li>申通</li>
              <li>中通</li>
              <li>韵达</li>
              <li>顺丰</li>
              <li>急宅送</li>
              <li>EMS</li>
              <li>快捷</li>
              <li>全峰</li>
              <li>国通</li>
              <li>EMS经济</li>
              <li>邮政小包</li>
              <li>天天</li>
              <li>优速</li>
              <li>速尔</li>
              <li>龙邦</li>
              <li>德邦快递</li>
              <li>中国邮政</li>
              <li>京东</li>
              <li>百世物流</li>
              <li>自提</li>
              <li>百世保价</li>
              <li>安能物流</li>
              <li>UPS</li>
              <li>联邦快递</li>
              <li>美国邮政</li>
              <li>风火天地</li>
              <li>联合快递</li>
              <li>众焱速递</li>
              <li>高宏铁快递</li>
              <li>高铁快递</li>
              <li>德邦物流</li>
              <li>佳龙快运</li>
              <li>邮政标准</li>
            </ul>
          </div> 
        </li> 
        <li>二号仓库</li> 
        <li>属于城镇订单</li>
        <li>这个件买家很着急</li>   
        <li><input type="text" class="input" title="普通面单需要输入单号,电子面单自动获取"placeholder="普通面单需要输入单号,电子面单自动获取"></li>
        <li>2017/06/09/14:39</li>
        <li>
          <div class="button-group">
            <a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>
          </div>
        </li>
        <div class="table-ul-son erzi">
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>总重：0 kg</li>
          </ul>
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>总重：0 kg</li>
          </ul>  
          <ul>
            <li><img src="../images/abc.png" alt=""></li>      
            <li>正品 Kiehl‘s科颜氏高保湿.</li>  
            <li>T35335770</li>  
            <li>￥199.00</li>     
            <li>1</li>
            <li>0 kg</li>
            <li>总重：0 kg</li>
          </ul>   
          <ul>
            <li>总数量： <span>1</span></li>
            <li>总价： <span>￥1.65元</span></li>
          </ul>  
        </div>
      </ul>   
      <!-- <ul class="table-ul">
        <li><input type="checkbox" id="checkall"/>
          全选 </li>      
        <li style="width: 90%">
          <a class="button border-main" href="javascript:;"><span class="icon-edit"></span> 重复打印</a> 
          <a class="button border-main" href="javascript:;"><span class="icon-edit"></span> 拆单打印</a>
          <a class="button border-main" href="javascript:;"><span class="icon-edit"></span> 快速发货</a>
        </li>  
      </ul>  -->
      <ul class="table-ul">
        <li style="width: 100%">
          <div class="pagelist" style="height: 50px;">
            <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> 
          </div>
        </li>
      </ul>
    </div>
  </div>
</body>
</html>
<script>

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
    if (this.checked) {
      this.checked = false;
    }
    else {
      this.checked = true;
    }
  });
})

</script>