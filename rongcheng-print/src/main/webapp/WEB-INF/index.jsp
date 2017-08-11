<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta http-equiv="Pragma" content="Mon,1 Jan 2001 0:0:0 UTC" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>��̨��������</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>  
     <script src="js/cookie_util.js"></script> 
    <script type="text/javascript">
    $(function() {
    	var userName1=getCookie("userName");
    	$('#account_span').html(getCookie("userName"));
    
    	$("#cleanCookie").click(function() {
        	 delCookie("ownerId"); 
        	window.location.href="admin.do";
    	});
    	/*  if(getCookie("ownerId")==null){
    		window.location.href="admin.do";
    	}  */
	});
    </script> 
</head>
<body style="background-color:#f2f9fd;">
  <div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
      <h1>
        <img src="images/logo.png" class="" height="50" alt="" />
        �ڳɴ�ӡ���
      </h1>
    </div>
    
    <div class="head-l" style="float: right;margin-right: 50px;">
      <a class="button button-little bg-red" id="cleanCookie"  >
        <span class="icon-power-off"></span> 
        �˳���¼
      </a> 
    </div>
    <div class="head-l" style="float: right;line-height: 35px;color: #fff;font-size:16px;margin-right: 20px;">
      ��ã�<span id="account_span"> </span>
    </div>
  </div>
  <div class="leftnav">
    <div class="leftnav-title">
      <strong>
        <span class="icon-list"></span>
        �˵��б�
      </strong>
    </div>
    <iframe scrolling="auto" rameborder="0" src="settings.do" name="left" width="100%" height="100%"></iframe>
  </div>
  <ul class="bread" style="margin-top: 0px;padding:0 15px;margin-bottom:0px;">
    <li>
      <a href="settings.do"  class=" icon-cog" target="left"> ��Ϣ����</a>
    </li>
    <li>
      <a href="audit.jsp" id="a_leader_txt" class="icon-list-alt" target="left">�������</a>
    </li>
    <li>
      <a href="print.jsp" id="a_leader_txt" class="icon-inbox" target="left"> ������ӡ</a>
    </li>
    <li>
      <a href="settings.do" id="a_leader_txt" class="icon-shopping-cart" target="left"> �������</a>
    </li>
    <li>
      <a href="settings.do" id="a_leader_txt" class="icon-align-left" target="left"> ����ͳ��</a>
    </li>
    <li>
      <a href="account.do" id="a_leader_txt" class="icon-file" target="left"> �˺�����</a>
    </li>
  </ul>
  <div class="admin">
    <iframe scrolling="auto" rameborder="0" src="show.jsp" name="right" width="100%" height="100%"></iframe>
  </div>
</body>
<script src="js/topnav.js"></script>
</html>