<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head><META HTTP-EQUIV="expires" CONTENT="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>融成内容管理系统</title>  
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>   
    <script src="/admin/zb/js/contentManagement/cookie_util.js"></script>
    <script src="/admin/zb/js/websiteAnalysis/siteAnalysisType.js"></script>
    
    <script type="text/javascript">
    	$(function(){
    		//点击栏目管理，转换栏目属性
    		$("#columnType_column").click(function(){
    			addCookie("columnType", "column");
    		});
    		//点击类目关键，转换类目属性
    		$("#columnType_type").click(function(){
    			addCookie("columnType", "type");
    		});
    	})
    </script>
</head>
<body style="background-color:#f2f9fd;">
  <div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
      <h1 style="float: left;">
        <img src="/admin/images/head.jpg" class="radius-circle rotate-hover" height="50" alt="" />
	融成内容管理系统
      </h1>
      <span style="margin: 10px 0 0 10px;float: left;">${version }</span>
    </div>
    <div class="head-l">
      <a class="button button-little bg-green" href="/" target="_blank">
        <span class="icon-home"></span> 
        前台首页
      </a> &nbsp;&nbsp;
      <a href="##" class="button button-little bg-blue">
        <span class="icon-wrench"></span> 
        清除缓存
      </a> &nbsp;&nbsp;
      <a class="button button-little bg-red" href="/admin.do">
        <span class="icon-power-off"></span> 
        退出登录
      </a> 
    </div>
  </div>
<div class="leftnav" style="overflow:auto;padding-bottom:80px;">
  <div class="leftnav-title">
    <strong>
      <span class="icon-list"></span>
      菜单列表
    </strong>
  </div>
  <h2>
    <span class="icon-user"></span>
    基本设置
  </h2>
  <ul style="display:block">
    <li class="pmx">
      <a href="/admin/config/siteconfig.do" target="right">
        <span class="icon-caret-right"></span>
        <span>网站设置</span>
      </a>
    </li>
    <li class="pmx">
      <a href="/admin/config/userconfig.do" target="right">
        <span class="icon-caret-right"></span>
        <span>用户设置</span>
      </a>
    </li>
    <c:if test="${type == 1 }">
	    <li class="pmx">
	      <a href="/admin/config/usersconfig.do" target="right">
	        <span class="icon-caret-right"></span>
	        <span>管理员设置</span>
	      </a>
	    </li>  
    </c:if>
    <li class="pmx">
      <a href="/admin/config/contactus.do" target="right">
        <span class="icon-caret-right"></span>
        <span>有问题戳我</span>
      </a>
    </li>
  </ul>   
   <h2>
    <span class="icon-pencil-square-o"></span>
    内容管理
  </h2>
  <ul>
    <li class="pmx">
      <a href="/admin/column.do" target="right"  id="columnType_column">
        <span class="icon-caret-right"></span>
        <span>栏目管理</span>
      </a>
    </li>
    <li class="pmx">
      <div class="threeNav">
        <h3 style="padding-left: 30px;line-height: 30px;font-size:13px;cursor:pointer;" class="click_h3">
          <span class="icon-caret-right"></span>
          <span>内容管理</span>
        </h3>
        <a href="/admin/content/content.do" target="right">
          <span style="padding-left:26px;">内容管理</span>
        </a>
        <a href="/admin/content/media.do" target="right">
          <span style="padding-left:26px;">媒体管理</span>
        </a>
      </div>
    </li> 
    <li class="pmx">
      <a href="/admin/notice.do" target="right">
        <span class="icon-caret-right"></span>
        <span>公告管理</span>
      </a>
    </li>  
    <li class="pmx">
      <a href="/admin/book.do" target="right">
        <span class="icon-caret-right"></span>
        <span>留言管理</span>
      </a>
    </li>   
  </ul>  
  <h2>
    <span class="icon-pencil-square-o"></span>
    网站数据分析
  </h2>
  <ul>
    <li class="pmx" id="timeData">
      <a href="/admin/siteAnalysis.do" target="right">
        <span class="icon-caret-right"></span>
        <span>实时数据</span>
      </a>
    </li>
    <li class="pmx" id="flowAnalysis">
      <a href="/admin/siteAnalysis.do" target="right">
        <span class="icon-caret-right"></span>
        <span>流量分析</span>
      </a>
    </li>  
    <li class="pmx" id="pageAnalysis">
      <a href="/admin/siteAnalysis.do" target="right">
        <span class="icon-caret-right"></span>
        <span>页面分析</span>
      </a>
    </li>   
    <li class="pmx" id="keywordAnalysis">
      <a href="/admin/siteAnalysis.do" target="right">
        <span class="icon-caret-right"></span>
        <span>关键词分析</span>
      </a>
    </li> 
  </ul> 
  <h2>
    <span class="icon-shopping-cart"></span>
    购物管理
  </h2>
  <ul>
    <li class="pmx">
      <a href="/admin/clientele.do" target="right">
        <span class="icon-caret-right"></span>
        <span>客户管理</span>
      </a>
    </li> 
    <li class="pmx">
      <a href="/admin/addresser.do" target="right">
        <span class="icon-caret-right"></span>
        <span>发件人管理</span>
      </a>
    </li> 
    <li class="pmx">
      <a href="/admin/column.do" target="right" id="columnType_type">
        <span class="icon-caret-right"></span>
        <span>类目管理</span>
      </a>
    </li> 
    <li class="pmx">
      <a href="/admin/item/list.do" target="right">
        <span class="icon-caret-right"></span>
        <span>商品管理</span>
      </a>
    </li>
    <li class="pmx">
      <a href="/admin/indent.do" target="right">
        <span class="icon-caret-right"></span>
        <span>订单管理</span>
      </a>
    </li> 
    <li class="pmx">
      <a href="/admin/logistics.do" target="right">
        <span class="icon-caret-right"></span>
        <span>物流管理</span>
      </a>
    </li> 
    <li class="pmx">
      <a href="/admin/review.do" target="right">
        <span class="icon-caret-right"></span>
        <span>评论管理</span>
      </a>
    </li>    
  </ul> 
</div>
<ul class="bread">
  <li class="pmx_index">
    <a href="/admin/first.do" target="right" class="icon-home"> 首页</a>
  </li>
  <li>
    <a href="##" id="a_leader_txt"  target="right">欢迎来到融成后台管理系统</a>
  </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="/admin/first.do" name="right" width="100%" height="100%"></iframe>
</div>
</body>
<script src="js/index_nav.js"></script>
</html>