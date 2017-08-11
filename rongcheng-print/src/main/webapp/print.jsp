<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>打印审核</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="leftnav" style="top:0;">
	<h2>
  	<a href="audit/to_print.jsp" target="right">
      	<span class="icon-caret-right"></span>
      	待打印订单
      </a>
	</h2>
  <h2>
    <a href="audit/have_print.jsp" target="right">
        <span class="icon-caret-right"></span>
        已打印订单
      </a>
  </h2>
	<h2>
		<a href="audit/not_refund.jsp" target="right">
        <span class="icon-caret-right"></span>
        未付款订单
    	</a>
	</h2>
  <h2>
    <a href="audit/refund_of.jsp" target="right">
        <span class="icon-caret-right"></span>
        退款中订单
      </a>
  </h2>
</div>
</body>
<script src="js/leftnav.js"></script>
</html>
