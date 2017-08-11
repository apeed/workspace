<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>账号设置</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>  
    <script type="text/javascript">
	 	$(function() {
	    	if(getCookie("ownerId")==null){
	    		top.location.href="admin.do";
	    	}
	 
		}); 
    </script> 
</head>
<body style="background-color:#f2f9fd;">
<div class="leftnav" style="top:0;">
	<h2>
		<a href="account_add_amend.do" target="right">
		  <span class="icon-caret-right"></span>
		  账号设置
		</a>
	</h2>
</div>
</body>
<script src="js/leftnav.js"></script>
</html>
