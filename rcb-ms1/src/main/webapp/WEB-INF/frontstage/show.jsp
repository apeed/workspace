<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="true" />
	<link rel="stylesheet" href="frontstage/css/page.css">
	<!-- page页面的图片开始 -->
	<div class="page-img-box">
		<img src="images/big1.jpg" alt="">
	</div>
	<!-- page页面的图片结束 -->
	<!-- page页面的内容开始 -->
	<div class="page-content-box">
		<div class="page-list">
			<h3>${oneMenuTitle}</h3><!-- 一级标题 -->
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
				<span>您的位置：</span><a href="javascript:;"></a><span>&gt;</span><a href="/">首页</a><span>&gt;</span><a href="javascript:;">${oneMenuTitle}</a><c:if test="${twoMenuTitle!=null}"> <span>&gt;</span><a href="javascript:;">${twoMenuTitle}</a></c:if>
			</div>
			<div class="page-content-text">
				<div class="page-show">
					<h3>${singlePage.title }</h3>
					<p style="float: right; color: rgb(165, 165, 165);"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${singlePage.createTime }" /> &nbsp;&nbsp;点击量：${singlePage.click }</p>
					<br>
					<div class="page-show-text">
						${singlePage.content1 }
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- page页面的内容结束 -->
<jsp:include page="footer.jsp" flush="true" />