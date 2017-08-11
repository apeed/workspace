<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="public/head.jsp" flush="true" />
    <link rel="stylesheet" href="/foreground/css/about.css">
    <link rel="stylesheet" href="/foreground/css/show.css">
</head>
<body>
<!--头部-->
<jsp:include page="public/header.jsp" flush="true" />
<!--主体部分-->
<div class="main">
    <h3 style="height: 60px;">${blockChannelTitle }</h3>
    <div class="content">
        <h1>${content.contentTitle }</h1>
        <c:if test="${statementNotice.statement != null && statementNotice.statement != ''}">
	        <div class="content_box gonggao">
	        	${statementNotice.statement }
	        </div>
	    </c:if>
        <div class="content_box">
			${content.content1 }
		</div>
		<c:if test="${statementNotice.notice != null && statementNotice.notice != ''}">
			<div class="content_box gonggao">
				${statementNotice.notice }
	        </div>
        </c:if>
    </div>
</div>
<!--底部-->
<jsp:include page="public/footer.jsp" flush="true" />
</body>
</html>