<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="public/head.jsp" flush="true" />
    <link rel="stylesheet" href="/foreground/css/index.css">

    <script type="text/javascript">
	    function search(trackingNum) {
	    	window.location.href='page.do?id=-1&blockTitle=运单跟踪&trackingNum='+trackingNum;
	    }
    </script>
</head>
<body>
<!--头部-->
<jsp:include page="public/header.jsp" flush="true" />
<!--banner-->
<div class="banner_box">
    <div class="banner_tu_box">
    	<c:forEach items="${type2BlockChannelContentlList[0] }" var="t2BC" end="2">
	        <div class="banner_tu" style="background: url(${t2BC.mediaUrl })no-repeat center center/cover;"></div>
    	</c:forEach>
    </div>
    <div class="banner_btn_box">
    	<c:forEach items="${type2BlockChannelContentlList[0] }" var="t2BC" end="2" varStatus="status">
    		<c:if test="${status.index == 0 }">
	        	<div class="banner_btn active"></div>
    		</c:if>
    		<c:if test="${status.index != 0 }">
	        	<div class="banner_btn"></div>
    		</c:if>
    	</c:forEach>
    </div>
</div>
<!--主体部分-->
<div class="main">
    <div class="about">
        <div class="about_img">
            <img src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>${type1BlockChannelList[0].iconUrl }" alt="">
        </div>
        <div class="about_text">
 <%--           <h2>${type1BlockChannelContentlList[0][0].contentTitle }</h2>
            <p>
				${type1BlockChannelContentlList[0][0].content1 }
            </p> --%>
            <h2>${type1BlockChannelList[0].blockTitle }</h2>
            <p>
				${type1BlockChannelList[0].blockProfile }
            </p>
        </div>
    </div>
    <div class="affiche">
        <div class="center fl">
            <div class="img_box">
                <img src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>${type1BlockChannelList[1].iconUrl }" alt="">
            </div>
            <div class="content">
                <h2>${type1BlockChannelList[1].blockTitle }</h2>
                <ul class="content_ul">
                	<c:forEach items="${type1BlockChannelContentlList[1] }" var="content" end="9">
                		<c:catch var="e">
                			<c:if test="${content.content1 }"></c:if>
                		</c:catch>
                		<c:if test="${e == null }">
                			<c:set var="contentType" value="1"/>
		                    <li>
		                        <a href="/show.do?id=${content.id }&blockTitle=${type1BlockChannelList[1].blockTitle }&contentType=${contentType }" target="_blank">${content.contentTitle }</a>
		                        <span><fmt:formatDate value="${content.gmtCreate }" pattern="yyyy-MM-dd"/></span>
		                    </li>
                		</c:if>
                		<c:if test="${e != null }">
                			<c:set var="contentType" value="23"/>
                		</c:if>
                	</c:forEach>
                </ul>
            </div>
            <div class="link">
                <a href="page.do?id=${type1BlockChannelList[1].id }&blockTitle=${type1BlockChannelList[1].blockTitle }"><i></i>更多</a>
            </div>
        </div>
        <div class="center fl">
            <div class="img_box">
                <img src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>${type1BlockChannelList[2].iconUrl }" alt="">
            </div>
            <div class="content">
                <h2>${type1BlockChannelList[2].blockTitle }</h2>
                <ul class="content_ul">
                	<c:forEach items="${type1BlockChannelContentlList[2] }" var="content" end="9">
                	
                	    <c:catch var="e">
                			<c:if test="${content.content1 }"></c:if>
                		</c:catch>
                		<c:if test="${e == null }">
                			<c:set var="contentType" value="1"/>
		                    <li>
		                        <a href="/show.do?id=${content.id }&blockTitle=${type1BlockChannelList[2].blockTitle }&contentType=${contentType }" target="_blank">${content.contentTitle }</a>
		                        <span><fmt:formatDate value="${content.gmtCreate }" pattern="yyyy-MM-dd"/></span>
		                    </li>
                		</c:if>
                		<c:if test="${e != null }">
                			<c:set var="contentType" value="23"/>
                		</c:if>
                		
                	</c:forEach>
                </ul>
            </div>
            <div class="link">
                <a href="page.do?id=${type1BlockChannelList[2].id }&blockTitle=${type1BlockChannelList[2].blockTitle }"><i></i>更多</a>
            </div>
        </div>
        <%-- <div class="right fl">
            <div class="search_text">
                <textarea name="" id="" cols="30" rows="10" placeholder="請輸入包裹運單號、訂單號跟蹤狀態"></textarea>
                <div class="search_alert"></div>
            </div>
            <div class="search_btn">
                点击跟踪包裹
            </div>
            <ul class="list_ul">
            	<div class="list_ul_title">
					${type1BlockChannelList[3].blockTitle }
                </div>
                <c:forEach items="${type1BlockChannelContentlList[3] }" var="content" end="11">
	                <li>
	                    <a href="${content.iconDirectLink }" target="_blank">
	                        <img src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>${content.iconUrl }" alt="${content.contentTitle }" >
	                    </a>
	                </li>
                </c:forEach>
            </ul>
        </div>
    </div> --%>
    <div class="right fl">
            <div class="search_text" style="background: url(${configMap.siteLogo.parameterValue1 }) no-repeat center;">
                <textarea name="" id="" cols="30" rows="10" placeholder="請輸入包裹運單號、訂單號跟蹤狀態"></textarea>
                <div class="search_alert"></div>
            </div>
            <div class="search_btn">
                點擊跟蹤包裹
            </div>
            <ul class="list_ul">
                <div class="list_ul_title">
                    建议留言区
                </div>
                <li>
                    <input type="text" class="input_text" placeholder="您的姓名">
                </li>
                <li>
                    <input type="text" class="input_text" placeholder="您的E-mail">
                </li>
                <li>
                    <input type="text" class="input_text" placeholder="您的联系电话">
                </li>
                <li>
                    <textarea name="" id="" cols="30" rows="10" placeholder="请输入您的留言内容..."></textarea>
                </li>
                <li>
                    <input type="button" value="提交" class="input_button">
                </li>
            </ul>
        </div>
    </div>
    <div class="myLink">
        <span>${type1BlockChannelList[3].blockTitle }：</span>
        <c:forEach items="${type1BlockChannelContentlList[3] }" var="content" end="11">
        	<a href="${content.iconDirectLink }" target="_blank" style="margin-right: 10px;">
        		${content.contentTitle }
            </a>
        </c:forEach>
    </div>
    
</div>
<!--底部-->
<script src="/foreground/js/index.js"></script>
<jsp:include page="public/footer.jsp" flush="true" />
</body>
</html>