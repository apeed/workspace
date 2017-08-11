<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/cookie_util.js"></script> 
	<script src="js/clientelePublic.js"></script>  
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改客户</strong></div>
    <div class="body-content">
      <div class="form-x" >   
        <div class="form-group">
          <div class="label">
            <label>客户账户：</label>
          </div>
          <div class="field" style="line-height: 35px;">
            <span id="clientele_accountNum_ts"></span>       
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>账户密码：</label>
          </div>
          <div class="field">
            <input type="text" class="input" id="clientele_password"  name="title" value=""/>         
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>确认账户密码：</label>
          </div>
          <div class="field">
            <input type="text" class="input" id="clientele_repassword"  name="title" value=""/>         
            <div class="tips" id="clientele_repassword_ts" style="color:red"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>账户邮箱：</label>
          </div>
          <div class="field">
            <input type="text" class="input" id="clientele_accountEmail" name="title" value=""/>         
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>客户昵称：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userNickname" name="entitle" value="" />         
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>客户姓名：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userName" name="s_title" value="" />     
            <div class="tips"></div>     
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>客户电话：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userTelephone" name="s_keywords" value="" />     
            <div class="tips"></div>     
          </div>
        </div>     
        <div class="form-group">
          <div class="label">
            <label>客户手机：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userMobile" name="s_title" value="" />     
            <div class="tips"></div>     
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>客户地址：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userAddress" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的问题1">
            <label>密码找回问题：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userQuestion1" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的答案1">
            <label>密码找回答案：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userAnswer1" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的问题2">
            <label>密码找回问题：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userQuestion2" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的答案2">
            <label>密码找回答案：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userAnswer2" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的问题3">
            <label>密码找回问题：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userQuestion3" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label" title="客户设置的答案3">
            <label>密码找回答案：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_userAnswer3" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>账户状态：</label>
          </div>
          <div class="field">
            <div class="button-group radio">
              <input  value="1" type="radio" name="qt">启用       
              <input  value="0"  type="radio" name="qt">停用
            </div>       
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>备注：</label>
          </div>
          <div class="field">
            <input type="text" class="input"  id="clientele_note" name="sort"/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label></label>
          </div>
          <div class="field">
            <button class="button bg-main icon-check-square-o clientelePublic_btn" type="button"> 提交</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>