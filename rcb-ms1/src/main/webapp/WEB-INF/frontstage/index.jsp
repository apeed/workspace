<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<jsp:include page="header.jsp" flush="true" />
	<link rel="stylesheet" href="frontstage/css/index.css">
	<!-- $banner图开始 -->
	<div class="banner-box">
		<div class="banner-tuBox">
		<c:set var="module1" value="${alternateImgMap.module1}"></c:set>
		<c:set var="imgList" value="${module1[1]}"></c:set>
		<%-- <c:set var="imgList" value="${alternateImgMap.module1[1]}"></c:set> --%>
		<c:forEach items="${imgList}" var="img">
			<a href="${img.link }"><img src="${img.imgUrl }" alt=""></a>
		</c:forEach>
		</div>
		<div class="banner-btn">
			<c:forEach items="${imgList}" varStatus="vs">
				<c:choose>
					<c:when test="${vs.index == 0 }">
						<i class="clickBtn"></i>
					</c:when>
					<c:otherwise><i></i></c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
	<!-- $banner图结束 -->





	<!-- $我们的业务开始 -->
	<div class="business-box">
		<div class="business">
			<h3>${YeWuOneMenuTitle }</h3>
			<ul class="business-content">
				<c:forEach items="${YeWuTwoMenuList}" var="yw">
				<li>
					<a href="list.php?oneMenuId=${YeWuOneMenuId }&twoMenuId=${yw.id}">
						<i>
							<img src="${yw.iconUrl}" alt="">
						</i>
						<h4>${yw.title}</h4>
						<p>${yw.profile}</p>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- $我们的业务结束 -->





	<!-- $我们的优势开始 -->
	<div class="advantage-box">
		<div class="advantage">
			<h3>${YouShiOneMenuTitle }</h3>
			<ul class="advantage-content">
				<c:forEach items="${YouShiTwoMenuList}" var="youShi">
				<li>
					<a href="javascript:;">
					<%-- <a href="list.do?oneMenuId=${YouShiOneMenuId }&twoMenuId=${youShi.id}"> --%>
						<img src="${youShi.iconUrl}" alt=""><br>
						<span></span>
						<h4>${youShi.title}</h4>
						<p>${youShi.profile}</p>
					</a>
				</li>
				</c:forEach>
			</ul>
			<!-- <h3>我们的优势</h3>
			<ul class="advantage-content">
				<li>
					<a href="javascript:;">
						<img src="images/icon-1.png" alt=""><br>
						<span>TECHNICAL TEAM</span>
						<h4>我们的优秀团队</h4>
						<p>拥有丰富经验的系统架构师、研发工程师、前后端工程师和系统测试运维工程师，保障提供稳定可靠的高价值产品</p>
					</a>
				</li>
				<li>
					<a href="javascript:;">
						<img src="images/icon-1.png" alt=""><br>
						<span>RESPONSE TIME</span>
						<h4>快速响应客户能力</h4>
						<p>专业的核心技术体系和客户服务团队，最短时间内响应客户需求，给予可靠的技术支持</p>
					</a>
				</li>
				<li>
					<a href="javascript:;">
						<img src="images/icon-1.png" alt=""><br>
						<span>CUSTOMER SERVICE</span>
						<h4>终生售后服务</h4>
						<p>基于同客户的长期合作，提供满意服务，提供一年免费售后服务，终身售后服务制</p>
					</a>
				</li>
			</ul> -->
		</div>
	</div>
	<!-- $我们的优势结束 -->






	<!-- $案例展示开始 -->
	<div class="case-box">
		<div class="case">
			<h3>案例展示</h3>
			<a href="list.do?oneMenuId=${AnLiOneMenuId }" id = "gd_anli">更多案例展示>></a>
			<div class="case-content">
				
	<c:forEach items="${ALSinglePageList }" var="singlePage">
				<div class="case-img-box">
					<img src="${singlePage.imgUrl }" alt="">
					<div class="shade">
						<h1>${singlePage.title }</h1>
						<p>${singlePage.profile }</p>
					</div>
				</div>
	</c:forEach>

			</div>
		</div>
	</div>
	<!-- $案例展示结束 -->







	<!-- $公司动态开始 -->
	<div class="dynamic-box">
		<ul class="dynamic">
		<c:forEach items="${twoMenuList}" var="twoMenu" varStatus="i" end="2">
			<li>
				<h3><a href="list.do?oneMenuId=${twoMenu.oneMenuId }&oneMenuTitle=${oneMenuTitle }&twoMenuId=${twoMenu.id }" >${twoMenu.title }</a></h3>
				<ul>
				<c:set var="y" value="${i.index }"></c:set>
				<c:forEach items="${singlePageListList[y]}" var="singlePage" end="4">
					<li>
						<a href="show.do?id=${singlePage.id }">${singlePage.title }</a><span><fmt:formatDate pattern="MM.dd" value="${singlePage.createTime }" /></span>
						<p>${singlePage.profile }</p>
					</li>
				</c:forEach>
				</ul>
			</li>
		</c:forEach>
		</ul>	
	</div>
	<!-- $新闻动态结束 -->
<script src="frontstage/js/index.js"></script>
<jsp:include page="footer.jsp" flush="true" />