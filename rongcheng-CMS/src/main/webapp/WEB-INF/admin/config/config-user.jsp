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
	<script src="/admin/js/jquery.js"></script>
	<script src="/admin/js/pintuer.js"></script>
	<script src="/admin/jxb/js/config/config-user.js"></script>
	<script src="/admin/jxb/js/jiml-utils.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong>
				<span class="icon-key"></span>修改会员密码</strong>
		</div>
		<div class="body-content">
			<div class="form-x">
				<div class="form-group">
					<div class="label">
						<label for="sitename">管理员帐号：</label></div>
					<div class="field">
						<label style="line-height:33px;">${user.accountNum }</label></div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>姓名：</label></div>
					<div class="field">
						<input type="text" class="input w50 jxb_inputChange" name="userName" value="${user.userName }" autocomplete="off" />
						<div class="tips">
							<span class="icon-check" style="color:#2c7; display: none"></span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电话：</label></div>
					<div class="field">
						<input type="text" class="input  w50 jxb_inputChange" name="userTelephone" value="${user.userTelephone }" autocomplete="off" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>邮箱：</label></div>
					<div class="field">
						<input type="text" class="input  w50 jxb_inputChange" name="accountEmail" value="${user.accountEmail }" autocomplete="off" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>原始密码：</label></div>
					<div class="field">
						<input type="password" class="input w50" id="password" name="password" size="50" placeholder="请输入原始密码" autocomplete="off" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>新密码：</label></div>
					<div class="field">
						<input type="password" class="input w50 newPassword" id="newPassword1" name="newPassword" size="50" placeholder="请输入新密码" autocomplete="off" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>确认新密码：</label></div>
					<div class="field">
						<input type="password" class="input w50 newPassword" id="newPassword2" size="50" placeholder="请再次输入新密码" autocomplete="off" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户手机：</label></div>
					<div class="field">
						<input type="text" class="input jxb_inputChange" name="userMobile" value="${user.userMobile }" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>用户地址：</label></div>
					<div class="field">
						<input type="text" class="input jxb_inputChange" name="userAddress" value="${user.userAddress }"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的问题1">
						<label>密码找回问题：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userQuestion" name="userQuestion1" value="${user.userQuestion1 }"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的答案1">
						<label>密码找回答案：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userAnswer" name="userAnswer1" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的问题2">
						<label>密码找回问题：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userQuestion" name="userQuestion2" value="${user.userQuestion2 }"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的答案2">
						<label>密码找回答案：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userAnswer" name="userAnswer2" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的问题3">
						<label>密码找回问题：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userQuestion" name="userQuestion3" value="${user.userQuestion3 }"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" title="用户设置的答案3">
						<label>密码找回答案：</label></div>
					<div class="field">
						<input type="text" class="input jxb_userAnswer" name="userAnswer3" />
						<div class="tips"></div>
					</div>
				</div>
				<!-- 提交按钮 -->
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" id="subButton" type="buttom">提交</button></div>
					<form id="subForm"></form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>