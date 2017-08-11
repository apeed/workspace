<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
    <script src="/admin/jxb/js/config/config-site.js"></script>
    <script src="/admin/jxb/js/jiml-utils.js"></script>
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
						<input type="text" class="input" id="title" name="siteTitle" value="${configMap.siteTitle.parameterValue1}" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
			        <div class="label">
			          <label>网站英文标题：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" id="siteEnTitle" name="siteEnTitle" value="${configMap.siteEnTitle.parameterValue1}" />
			          <div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
			        </div>
		      	</div>
				<div class="form-group">
					<div class="label">
						<label>网站LOGO：</label></div>
					<div class="field">
						<input type="text" id="logoImgName" class="input " style="width:25%; float:left;" disabled="disabled"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
						<button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="logo.click();">
							<span class="glyphicon glyphicon-ban-circle"></span>十上传</button>
						<input type="file" id="logo" name="siteLogo" class="file-btn" accept="image/*" >
						<img src="${configMap.siteLogo.parameterValue1}" height="42px">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站关键字：</label></div>
					<div class="field">
						<textarea class="input" id="keyword" name="siteKeyword"  style="height:80px" >${configMap.siteKeyword.parameterValue1}</textarea>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>网站描述：</label></div>
					<div class="field">
						<textarea class="input" id="description" name="siteDescription" >${configMap.siteDescription.parameterValue1}</textarea>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系人：</label></div>
					<div class="field">
						<input type="text" class="input" id="name" name="siteContactName" value="${configMap.siteContactName.parameterValue1}"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>手机：</label></div>
					<div class="field">
						<input type="text" class="input" id="phone" name="siteContactPhone" value="${configMap.siteContactPhone.parameterValue1}"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电话：</label></div>
					<div class="field">
						<input type="text" class="input" id="tel1" name="siteContactTell" value="${configMap.siteContactTell.parameterValue1}" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group" style="display:none;">
					<div class="label">
						<label>400电话：</label></div>
					<div class="field">
						<input type="text" class="input" name="siteContactTell400" value="${configMap.siteContactTell400.parameterValue1}"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>QQ：</label></div>
					<div class="field">
						<input type="text" class="input" id="qq" name="siteContactQQ" value="${configMap.siteContactQQ.parameterValue1}"/>
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>Email：</label></div>
					<div class="field">
						<input type="text" class="input" id="email" name="siteContactEmail" value="${configMap.siteContactEmail.parameterValue1}" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>地址：</label></div>
					<div class="field">
						<input type="text" class="input" id="address" name="siteContactAddress" value="${configMap.siteContactAddress.parameterValue1}" />
						<div class="tips"><span class="icon-check" style="color:#2c7; display: none"></span></div>
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
	<form id="subForm"></form>
</body>
</html>