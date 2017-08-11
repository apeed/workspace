<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>信息设置</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script> 
    <script src="js/cookie_util.js"></script> 
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
    	<a href="http://www.baidu.com" target="_bleak">
        	<span class="icon-caret-right"></span>
        	添加店铺（授权）
        </a>
  	</h2>
  	<h2>
  		<a href="accredit.do" target="right">
	        <span class="icon-caret-right"></span>
	        店铺信息设置
      	</a>
  	</h2>
  	<h2>
      	<a href="storeMessage.do" target="right">
        <span class="icon-caret-right"></span>
        商品信息设置
      	</a>
    </h2>
    <h2 class="leftnavH2">
    	<a href="javascript:;">
	    <span class="icon-caret-right"></span>
	    模板设置/打印机设置
	  	</a>
	</h2>   
	<ul style="display:none;" class="leftnav_ul">
	    <li>
	      	<a href="settings/expressTemplate.jsp" target="right">
	        <span class="icon-caret-right"></span>
	        快递面单模板
	      </a>
	    </li>
	    <li>
	      	<a href="settings/invoiceTemplate.jsp" target="right">
	        <span class="icon-caret-right"></span>
	        自定义单据模板
	      </a>
	    </li>   
	    <!-- <li>
	      	<a href="printer.html" target="right">
	        <span class="icon-caret-right"></span>
	        打印机设置
	      </a>
	    </li>  -->    
	</ul> 
	<h2>
		<a href="ExpressPartition.do" target="right">
	    <span class="icon-caret-right"></span>
	    快递分区设置
	  	</a>
	</h2>     
</div>
</body>
</html>
<script src="js/leftnav.js"></script>
<script type="text/javascript">
$(function(){
  $(".leftnav .leftnavH2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>