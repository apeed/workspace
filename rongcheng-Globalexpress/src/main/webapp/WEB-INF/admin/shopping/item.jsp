<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
    <script src="/admin/jxb/js/jiml-utils.js"></script>
    <script src="/admin/jxb/js/column/item-column.js"></script>
    <script src="/admin/jxb/js/shopping/item.js"></script>
</head>
<body style="position:relative;min-height: 600px;">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o" href="/admin/item/additem.do"> 添加内容</a> </li>
          <li>
            <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
            <button type="button" class="button border-red" onclick="del(-1)"><span class="icon-trash-o"></span> 批量删除</button>
            <button type="button" class="button border-black  recommend_btn" onclick="recommendBtn(1,-1,1)"> 批量归类</button>
            <button type="button" class="button border-yellow  recommend_btn" onclick="recommendBtn(1,-1,2)"> 批量删除归类</button>
          </li>
          <li>
            <div class="change_column_inner" style="width:100px;">
              <div class="change_column" id="jxb_xzfl">选择分类</div>
              <ul class="change_column_box">
                <li class="change_column_fu">
                  <ol>
                    <li>选择</li>
                    <li>栏目名称</li>
                  </ol>
                </li>
                <li class="change_column_fu">
                  <ol class="xiala_box">
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                  <div>
                    <ol class="xiala_box">
                      <li>1</li>
                      <li style="padding-left: 30px;">├─公司简介</li>
                    </ol>
                    <div>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">├─公司简介</li>
                      </ol>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">└─公司简介</li>
                      </ol>
                    </div>
                    <ol class="xiala_box">
                      <li>1</li>
                      <li style="padding-left: 30px;">└─公司简介</li>
                    </ol>
                    <div>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">└─公司简介</li>
                      </ol>
                    </div>
                  </div>
                  <ol class="xiala_box">
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                </li>
                <li style="margin-bottom:10px;" class="change_column_fu">
                  <button class="button border-black change_column_del" style="margin-left:10px;">提交</button>
                  <button class="button border-black change_column_del" style="margin-left:10px;">取消</button>
                </li>
              </ul>
            </div>
          </li>
          <li>
            <input type="text" placeholder="可输入内容页标题/子标题/作者/详情/简介/标签/备注信息" id="keyword" class="input" style="width:400px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" class="button border-main icon-search" onclick="loadItem(1)" > 搜索</a></li>
        </ul>
      </div>
      		<form id="subForm">
	      <table class="table table-hover text-center" id="reloadTable">
	        <tr>
	          <th width="50">序号</th>
	          <th>商品编号</th>
	          <th>名称</th>
	          <th>图片(点击预览)</th>
	          <th>商品类型</th>
	          <th>规格</th>
	          <th>条码</th>
	          <th>售价</th>
	          <th>数量</th>
	          <th>推荐</th>
	          <th width="180">操作</th>
        	</tr>
	      </table>
      		</form>
    </div>
  </div>
<!-- 推荐到 -->
  <div class="recommend_box">
    <div class="recommend_content">
      <form id="subForms">
      <div class="recommend_del" onclick="recommendDel()">×</div>
      <h3 id="saveOrDeleteGuiLei"></h3>
      <ul class="recommend">
        <li class="change_column_fu">
          <ol>
            <li>选择</li>
            <li>栏目名称</li>
          </ol>
        </li>
        <li class="change_column_fu">
          <ol>
            <li><input type="checkbox"></li>
            <li>公司简介</li>
          </ol>
          <div>
            <ol>
              <li><input type="checkbox"></li>
              <li style="padding-left: 30px;">├─公司简介</li>
            </ol>
            <div>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">├─公司简介</li>
              </ol>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">└─公司简介</li>
              </ol>
            </div>
            <ol>
              <li><input type="checkbox"></li>
              <li style="padding-left: 30px;">└─公司简介</li>
            </ol>
            <div>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">└─公司简介</li>
              </ol>
            </div>
          </div>
          <ol>
            <li><input type="checkbox"></li>
            <li>公司简介</li>
          </ol>
        </li>
      </ul>
      </form>
      <div class="recommend_tj">
        <button class="button border-main"style="margin-right: 50px;" onclick="guilei()"><span class="icon-print"></span> 确定</button> 
      </div>
    </div>
  </div>
<script>

var flag=true;
$("#checkall").click(function(){ 
  if(flag){
      flag=false;
      $('tr').find('input').prop('checked',true);
  }else{
    flag=true;
      $('tr').find('input').prop('checked',false);
  }
})
</script>
<!-- 图片放大弹出 -->
  <div class="img_alert">
    <div class="img_content">
      <div class="img_del">×</div>
      <img src="" alt="">
    </div>
  </div>
</body>
<!-- <script src="/admin/js/img_td.js"></script> -->
<script src="/admin/js/alert_box.js"></script>

</html>