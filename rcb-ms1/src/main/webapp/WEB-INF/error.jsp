<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误</title>
<script type="text/javascript">
onload = function addr() {
		var time=3;
		document.getElementById("time").innerHTML=time--;
		setInterval(function(){
			document.getElementById("time").innerHTML=time--;
			if(time==-1){
				window.location.href="/";
			}
		},1000);
	}
</script>
</head>
<body>
<%System.out.println("访问的页面不存在"+new Date());%>
<div style="text-align: center;">
	<br>
	<h1>参数错误或系统内部错误。</h1><p><span id="time"></span>秒后<a href="/">跳转</a>主页。<span></span></p>
</div>
</body>
</html>