<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/pintuer.js"></script>  
    <script src="/js/info.js"></script>
    <script src="/js/cookie_util.js"></script>
    <script src="/js/basevalue.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong>
				<span class="icon-pencil-square-o"></span>网站信息</strong>
		</div>
		<div class="body-content">
			<form class="form-x" id="form-x">
				<div class="form-group">
					<div class="label">
						<label>网站标题：</label></div>
					<div class="field">
						<input type="text" class="input" id="title" name="title" value="${configList[0].paramValue1 }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站LOGO：</label></div>
					<div class="field">
						<input type="text" id="logoImgName" class="input " style="width:25%; float:left;" disabled="disabled"/>
						<button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="logo.click();">
							<span class="glyphicon glyphicon-ban-circle"></span>十上传</button>
						<input type="file" id="logo" name="logo" class="file-btn" accept="image/*" >
						<img src="/${configList[1].paramValue1 }" height="42px"></div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站关键字：</label></div>
					<div class="field">
						<textarea class="input" id="keyword" name="keyword"  style="height:80px">${configList[2].paramValue1 }</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站描述：</label></div>
					<div class="field">
						<textarea class="input" id="description" name="description" >${configList[3].paramValue1 }</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系人：</label></div>
					<div class="field">
						<input type="text" class="input" id="name" name="name" value="${configList[4].paramValue1 }"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>手机：</label></div>
					<div class="field">
						<input type="text" class="input" id="phone" name="phone" value="${configList[5].paramValue1 }"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电话：</label></div>
					<div class="field">
						<input type="text" class="input" id="tel1" name="tel1" value="${configList[6].paramValue1 }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group" style="display:none;">
					<div class="label">
						<label>400电话：</label></div>
					<div class="field">
						<input type="text" class="input" name="tel400" value="${configList[7].paramValue1 }"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>QQ：</label></div>
					<div class="field">
						<input type="text" class="input" id="qq" name="qq" value="${configList[8].paramValue1 }"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>Email：</label></div>
					<div class="field">
						<input type="text" class="input" id="email" name="email" value="${configList[9].paramValue1 }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>地址：</label></div>
					<div class="field">
						<input type="text" class="input" id="address" name="address" value="${configList[10].paramValue1 }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="button" id="setinfo_button">提交</button></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>