<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>融成（天津）信息技术有限公司</title>
	<link rel="prefetch icon" href="images/favicon.ico"/>
	<!-- 浏览器内核默认选择最高的 -->
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <!-- 这是base默认样式 -->
	<link rel="stylesheet" href="frontstage/css/base.css">
	<!-- 头部样式表 -->
	<link rel="stylesheet" href="frontstage/css/header.css">
	<!-- 调用了外部矢量图片库iconfont -->
	<link rel="stylesheet" type="text/css" href="frontstage/font/iconfont.css">
	<script src="frontstage/js/header.js"></script>
	<script src="frontstage/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<!-- $头部开始 -->
	<div class="head-box">
		<!-- $头部顶部链接开始 -->
		<div class="head-top-box">
			<div class="head-top">
				<a href="javascript:;">手机版</a>
				<i></i>
				<a href="#foot">留言板</a>
				<i></i>
				<a href="javascript:;">收藏本站</a>
			</div>
		</div>
		<!-- $头部顶部链接结束 -->
		<!-- $头部logo开始 -->
		<div class="head-logo-box">
			<div class="head-logo">
				<a href="javascript:;"><img src="${configMap.logo.paramValue1 }" alt=""></a>
				<div class="input-box">
				<form action="search.php" method="post" id="index_search">
					<input type="text" placeholder="产品搜索" name = "keyword">
					<a href="javascript:;" onclick="index_search()" class="iconfont icon-fangdajing"></a>
					<script type="text/javascript">
						function index_search() {
							$('#index_search').submit();
						}
					</script>
				</form>
			</div>
			</div>
		</div>
		<!-- $头部logo结束 -->
		<!-- $头部导航开始 -->
		<div class="head-nav-box">
			<ul class="head-nav" id = "head_nav">
			<c:choose>
			    <c:when test="${oneMenuTitle==null }">
					<li class="first-nav" id="click-nav">
						<a href="/">首页</a>
					</li>
				</c:when>
			    <c:otherwise>
					<li class="first-nav" >
						<a href="/">首页</a>
					</li>
			    </c:otherwise>
			</c:choose>
				<c:forEach items="${oneTwoMenuMap }" var="oneTwoMenu">
				<c:choose>
					<c:when test="${oneTwoMenu.key.title==oneMenuTitle }">
					<li id="click-nav">
							<a href="list.php?oneMenuId=${oneTwoMenu.key.id }">${oneTwoMenu.key.title }</a>
							<ul>
							<c:forEach items="${oneTwoMenu.value }" var="twoMenu">
								<li>
									<%-- <a href="listline.php?oneMenuId=${oneTwoMenu.key.id }&id=${twoMenu.id }">${twoMenu.title }</a> --%>
									<a href="list.php?oneMenuId=${oneTwoMenu.key.id }&oneMenuTitle=${oneTwoMenu.key.title }&twoMenuId=${twoMenu.id }">${twoMenu.title }</a>
								</li>
							</c:forEach>
						</ul>
					</li>
					</c:when>
					<c:otherwise>
					<li>
							<a href="list.php?oneMenuId=${oneTwoMenu.key.id }">${oneTwoMenu.key.title }</a>
							<ul>
							<c:forEach items="${oneTwoMenu.value }" var="twoMenu">
								<li>
									<%-- <a href="listline.php?oneMenuId=${oneTwoMenu.key.id }&id=${twoMenu.id }">${twoMenu.title }</a> --%>
									<a href="list.php?oneMenuId=${oneTwoMenu.key.id }&oneMenuTitle=${oneTwoMenu.key.title }&twoMenuId=${twoMenu.id }">${twoMenu.title }</a>
								</li>
							</c:forEach>
						</ul>
					</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</ul>
		</div>
		<!-- $头部导航结束 -->
	</div>
	<!-- $头部结束 -->