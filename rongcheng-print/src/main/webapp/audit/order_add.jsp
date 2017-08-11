<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>  
</head>
<body style="position:relative;">
  <div class="content_box">
    <div class="panel admin-panel" style="margin-bottom: 20px;">
      <div class="panel-head"><strong class="icon-reorder">手动新建订单</strong></div>
      <div class="body-content" style="padding-bottom:0;">
        <div class="form-x">  
          <div class="form-group">
            <div class="label">
              <label>收件人：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" value="" name="title"/>
              <div class="tips"></div>
            </div>
          </div>  
          <div class="form-group">
            <div class="label">
              <label>联系电话/手机：</label>
            </div>
            <div class="field">
              <input type="text" class="input w50" value="" name="title"/>
              <div class="tips"></div>
            </div>
          </div>  
          <div class="form-group">
            <div class="label">
              <label>地址：</label>
            </div>
            <div class="field">
              <input type="text" class="input" value="" name="title"/>
              <div class="tips"></div>
            </div>
          </div>  
          <div class="form-group">
            <div class="label">
              <label>备注：</label>
            </div>
            <div class="field">
              <input type="text" class="input" value="" name="title"/>
              <div class="tips"></div>
            </div>
          </div>  
        </div>
      </div>
    </div>
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder">添加商品</strong></div>
      <div class="padding border-bottom">
        <ul class="search">
          <li>
            <a class="button border-main alert_page" href="javascript:;"><span class="icon-edit"></span> 添加商品</a>
          </li>
        </ul>
      </div>
      <table class="table table-hover text-center">
        <tr>
          <th width="120">商品编码</th>

          <th>商品名称</th>       
          <th>商品规格</th>
          <th>商品价格</th>
          <th>数量</th>
          <th>编辑</th>       
        </tr>      
          <tr>
            <td>T35335779</td>
            <td>美国专柜 Bite限量口红唇笔套</td>
            <td>二代亚光眼影盘础款</td>  
            <td>￥189.00</td>
            <td><input type="text" name="sort[1]" value="22" style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>
            <td><div class="button-group"><a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
          </tr>
          <tr>
            <td>T35335779</td>
            <td>美国专柜 Bite限量口红唇笔套</td>
            <td>二代亚光眼影盘基础款</td>  
            <td>￥189.00</td>
            <td><input type="text" name="sort[1]" value="22" style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>
            <td><div class="button-group"><a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
          </tr>
            <tr>
            <td>T35335779</td>
            <td>美国专柜 Bite限量口红唇笔套</td>
            <td>二代亚光眼影盘基础款</td>  
            <td>￥189.00</td>
            <td><input type="text" name="sort[1]" value="22" style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>
            <td><div class="button-group"><a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
          </tr>
            <tr>
            <td>T35335779</td>
            <td>美国专柜 Bite限量口红唇笔套</td>
            <td>二代亚光眼影盘基础款</td>  
            <td>￥189.00</td>
            <td><input type="text" name="sort[1]" value="22" style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>
            <td><div class="button-group"><a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>        </tr>
            <tr>
            <td>T35335779</td>
            <td>美国专柜 Bite限量口红唇笔套</td>
            <td>二代亚光眼影盘基础款</td>  
            <td>￥189.00</td>
            <td><input type="text" name="sort[1]" value="22" style="width:50px; text-align:center; border:1px solid #ddd; padding:7px 0;" /></td>
            <td><div class="button-group"><a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
          </tr>
        <tr>
          <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
        </tr>
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
              <button class="button bg-main icon-check-square-o"> 提交</button>
            </div>
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
            <li>品牌：</li>
            <li>
              <select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                <option value="">请选择分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
              </select>
            </li>
            <li>类目：</li>
            <li>
              <select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                <option value="">请选择分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
                <option value="">产品分类</option>
              </select>
            </li>
            <li>搜索框：</li>
            <li>
              <input type="text" placeholder="请输入编码/名称/规格搜索" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
              <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
          </ul>
        </div>
        <table class="table table-hover text-center">
          <tr>
            <th width="120">商品编码</th>

            <th>商品名称</th>
            <th>商品品牌</th>
            <th>商品类目</th>        
            <th>商品规格</th>
            <th>商品价格</th>     
          </tr>      
            <tr>
              <td><input type="checkbox" name="id[]" value="1" />T35335779</td>
              <td>美国专柜 Bite限量口红唇笔套</td>
              <td>二代亚光眼影盘础款</td>
              <td>二代亚</td>
              <td>二代亚光眼影盘础款</td>  
              <td>￥189.00</td>
              
            </tr>
            <tr>
              <td><input type="checkbox" name="id[]" value="1" />T35335779</td>
              <td>美国专柜 Bite限量口红唇笔套</td>
              <td>二代亚光眼影盘础款</td>
              <td>二代亚</td>
              <td>二代亚光眼影盘基础款</td>  
              <td>￥189.00</td>
            </tr>
            <tr>
              <td><input type="checkbox" name="id[]" value="1" />T35335779</td>
              <td>美国专柜 Bite限量口红唇笔套</td>
              <td>二代亚光眼影盘础款</td>
              <td>二代亚</td>
              <td>二代亚光眼影盘基础款</td>  
              <td>￥189.00</td>
            </tr>
            <tr>
              <td><input type="checkbox" name="id[]" value="1" />T35335779</td>
              <td>美国专柜 Bite限量口红唇笔套</td>
              <td>二代亚光眼影盘础款</td>
              <td>二代亚</td>
              <td>二代亚光眼影盘基础款</td>  
              <td>￥189.00</td>
            </tr>
            <tr>
              <td><input type="checkbox" name="id[]" value="1" />T35335779</td>
              <td>美国专柜 Bite限量口红唇笔套</td>
              <td>二代亚光眼影盘础款</td>
              <td>二代亚</td>
              <td>二代亚光眼影盘基础款</td>  
              <td>￥189.00</td>
            </tr>
          <tr>
            <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
          </tr>
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
                <button class="button bg-main icon-check-square-o"> 提交</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="delete_btn">
        ×
      </div>
    </div>
  </div>
</body>
</html>