<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<body>
  <div class="panel admin-panel" style="margin-bottom: 20px;">
    <div class="panel-head"><strong class="icon-reorder">打印机设置</strong></div>
    <div class="body-content" style="padding-bottom:0;">
      <div class="form-x">   
        <div class="form-group">
          <div class="label">
            <label>打印机选择：</label>
          </div>
          <div class="field">
            <select name="cid" class="input w50">
              <option value="">请选择分类</option>
              <option value="">打印机1</option>
              <option value="">打印机2</option>
              <option value="">打印机3</option>
              <option value="">打印机4</option>
              <option value="">打印机5</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>打印份数：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value="" name="title" value="1" />
            <div class="tips"></div>
          </div>
        </div>
        <!--
        <div class="form-group">
          <div class="label">
            <label>用户名：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value="" name="title"/>
            <div class="tips"></div>
          </div>
        </div>  
        <div class="form-group">
          <div class="label">
            <label>姓名：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value="" name="title"/>
            <div class="tips"></div>
          </div>
        </div>  
        <div class="form-group">
          <div class="label">
            <label>电话：</label>
          </div>
          <div class="field">
            <input type="text" class="input" value="" name="title"/>
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
        -->
      </div>
    </div>
  </div>
  <div class="panel admin-panel" style="border:none;">
    <div class="body-content">
      <div class="form-x">  
        <div class="form-group">
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
</body>
</html>