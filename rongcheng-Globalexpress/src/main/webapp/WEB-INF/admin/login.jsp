<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	
	<title>登录</title>
	
	<link rel="stylesheet" href="/admin/css/pintuer.css">
	<link rel="stylesheet" href="/admin/css/admin.css">
	<script src="/admin/js/jquery.js"></script>
	<script src="/admin/jxb/js/jiml-utils.js"></script>
	<script type="text/javascript">
	$(function(){
		$("input").keydown(emptyMessage);
	});
	function emptyMessage() {
		$("#err").html("");
	}
	function sub(e) {
		if (e == "sub") {
			showLoadingImg("/media/images/public/loading.gif");
			$.ajax({
				url : "login.do",
				data : $('#loginForm').serialize(),
				type : "post",
				async : "true",
				dataType : "json",
				success : function(result) {
					hideLoadingImg();
					if (result.data != "ok") {
						$("#err").html(result.data);
					} else {
						window.location.assign("/admin/index.do");
					}
				},
				error : function(result) {
					hideLoadingImg();
					$("#err").html(result.data);
				}
			});
		} else {
			var keynum;
			if (window.event) { // IE
				keynum = e.keyCode;
			} else if (e.which) { // Netscape/Firefox/Opera
				keynum = e.which;
			}
			if (keynum == 13) {
				showLoadingImg("/media/images/public/loading.gif");
				$.ajax({
					url : "login.do",
					data : $('#loginForm').serialize(),
					type : "post",
					async : "true",
					dataType : "json",
					success : function(result) {
						hideLoadingImg();
						if (result.data != "ok") {
							$("#err").html(result.data);
						} else {
							window.location.assign("admin/index.do");
						}
					},
					error : function(result) {
						hideLoadingImg();
						$("#err").html(result.data);
					}
				});
			}
		}
	}
	</script>
<style type="text/css">
.input{
	width: 100%;
}
</style>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<div class="panel loginbox">
					<div class="text-center margin-big padding-big-top">
						<h1>融成内容管理系统<span style="margin: 0 0 0 10px;font-size:14px;">${version }</span></h1></div>
					<div class="panel-body" style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
						<form id="loginForm">
							<div>
								<div class="field field-icon-right">
									<input class="input input-big" name="account" placeholder="账号" />
									<span class="icon icon-user margin-small" style=""></span>
								</div>
							</div>
							<br>
							<div>
								<div class="field field-icon-right">
									<input class="input input-big" name="password" placeholder="密码" type="password" />
									<span class="icon icon-key margin-small"></span>
								</div>
							</div>
							<br>
							<div>
								<div class="field">
									<input class="input input-big" name="yzm" placeholder="验证码" onkeypress="sub(event)" />
									<img src="createImg.do" onclick="this.setAttribute('src','createImg.do?x='+Math.random())" alt="验证码" title="点击更换" width="100" height="32" class="passcode" style="height: 43px; cursor: pointer;" /></div>
							</div>
						</form>
						<span style="color: red; display: block; height: 20px;" id="err"></span>
					</div>
					<div>
						<input type="button" id="login" class="button button-block bg-main text-big input-big" value="登录" onclick="sub('sub')"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>