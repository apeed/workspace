<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" flush="true" />
	<link rel="stylesheet" href="frontstage/css/page.css">

<body>
	<!-- page页面的图片开始 -->
	<div class="page-img-box">
		<img src="images/big1.jpg" alt="">
	</div>
	<!-- page页面的图片结束 -->
	<!-- page页面的内容开始 -->
	<div class="page-content-box">
		<div class="page-list">
			<h3>${oneMenuTitle }</h3>
			<ul>
				<c:forEach items="${twoMenuList}" var="twoMenu">
					<c:choose>
						<c:when test="${twoMenu.title== twoMenuTitle}">
							<li><a href="list.php?oneMenuId=${twoMenu.oneMenuId }&oneMenuTitle=${oneMenuTitle }&twoMenuId=${twoMenu.id }" style="background: #19B4EA; padding-left: 20px; color: #fff;">${twoMenu.title }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="list.php?oneMenuId=${twoMenu.oneMenuId }&oneMenuTitle=${oneMenuTitle }&twoMenuId=${twoMenu.id }" >${twoMenu.title }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
		<div class="page-content">
			<div class="froth">
				<span>您的位置：</span><a href="javascript:;"></a><span>&gt;</span><a href="/">首页</a><span>&gt;</span><a href="javascript:;">${oneMenuTitle }</a><span>&gt;</span><span id="weizhi_twomenuid" style="display: none;">${twoMenuId }</span><a href="javascript:;" id = "weizhi_twomenutitle">${twoMenuTitle }</a>
			</div>
			<ul class="page-content-text">
				<c:forEach items="${singlePageList}" var="singlePage">
					<li class="page-case">
						<a href="show.php?id=${singlePage.id}" target="_blank">
							<div class="caseli-img">
								<img src="${singlePage.imgUrl}" alt="${singlePage.profile }"><br>
							</div>
							${singlePage.title }
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- page页面的内容结束 -->
<jsp:include page="footer.jsp" flush="true" />