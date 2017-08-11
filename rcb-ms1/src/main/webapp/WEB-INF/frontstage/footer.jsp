<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link rel="stylesheet" href="frontstage/css/footer.css">
	<script src="frontstage/js/footer.js"></script>

	<!-- $底部联系我们开始 -->
	<div class="footer-box">
		<div class="footer-width">
			<div class="footer-ajax">
				<div class="footer-ajax-input">
				<a name="foot"></a>
					<form id="leave_word">
						<label>
							<input type="text" placeholder="您的姓名" name="name" id="footer_name">
							<input type="email" placeholder="您的E-mail" name="email" id="footer_email">
							<input type="text" placeholder="您的联系方式" name="tel" id="footer_tel">
						</label>
						<textarea name="content" id="footer_content" placeholder="请输入您的留言内容..."></textarea>
						<input type="button" id="footer_tj" value="提交" onclick="leaveWord()">
					</form>
				</div>
				<div class="footer-ajax-contact">
					<h3>联系我们</h3>
					<p><c:choose>
						<c:when test="${configMap.tel400!=null&&configMap.tel400.paramValue1!=null&&configMap.tel400.paramValue1!='' }">${configMap.tel400.paramValue1 }</c:when>
						<c:when test="${configMap.tel1!=null&&configMap.tel1.paramValue1!=null&&configMap.tel1.paramValue1!='' }">${configMap.tel1.paramValue1 }</c:when>
						<c:otherwise>${configMap.phone.paramValue1 }</c:otherwise>
					</c:choose></p>
					<span>软件项目对接：<c:choose>
						<c:when test="${configMap.tel400!=null&&configMap.tel400.paramValue1!=null&&configMap.tel400.paramValue1!='' }">${configMap.tel400.paramValue1 }</c:when>
						<c:when test="${configMap.tel1!=null&&configMap.tel1.paramValue1!=null&&configMap.tel1.paramValue1!='' }">${configMap.tel1.paramValue1 }</c:when>
						<c:otherwise>${configMap.phone.paramValue1 }</c:otherwise>
					</c:choose></span>
					<a href="javascript:;">contact us</a>
				</div>
			</div>
		</div>
	</div>
	<!-- $底部联系我们结束 -->
	<!-- $底部结尾开始 -->
	<div class="footer-ending-box">
		<!-- $友情链接开始 -->
		<div class="blogroll-box">
			<div class="blogroll">
				<span>友情链接：</span>
				<a href="javascript:;">融成信息技术有限公司</a>
				<a href="${configMap.forum.paramValue2 }">${configMap.forum.paramValue1 }</a>
				<a href="${configMap.erp.paramValue2 }">${configMap.erp.paramValue1 }</a>
				<a href="${configMap.TEcenter.paramValue2 }">${configMap.TEcenter.paramValue1 }</a>
			</div>
		</div>
		<!-- $友情链接结束 -->
		<div class="footer-ending">
			<div class="ending-link">
				<c:forEach items="${oneTwoMenuMap }" var="oneTwoMenu">
					<a href="list.php?oneMenuId=${oneTwoMenu.key.id }">${oneTwoMenu.key.title }</a>
						<i>
						<%-- <c:forEach items="${oneTwoMenu.value }" var="twoMenu">
							<li>
								<a href="listline.php?oneMenuId=${oneTwoMenu.key.id }&id=${twoMenu.id }">${twoMenu.title }</a>
								<a href="list.php?oneMenuId=${oneTwoMenu.key.id }&oneMenuTitle=${oneTwoMenu.key.title }&twoMenuId=${twoMenu.id }">${twoMenu.title }</a>
							</li>
						</c:forEach> --%>
					</i>
				</c:forEach>
			</div>
			<div class="ending-name">
				© ${configMap.title.paramValue1 } 2017 All Rights Reserved.
			</div>
			<div class="ending-contact">
				<c:if test="${configMap.email!=null&&configMap.email.paramValue1!=null&&configMap.email.paramValue1!='' }" >E-mail：${configMap.email.paramValue1 }&nbsp;&nbsp;</c:if>
				<c:choose>
					<c:when test="${configMap.tel400!=null&&configMap.tel400.paramValue1!=null&&configMap.tel400.paramValue1!='' }">联系电话：${configMap.tel400.paramValue1 }</c:when>
					<c:when test="${configMap.tel1!=null&&configMap.tel1.paramValue1!=null&&configMap.tel1.paramValue1!='' }">联系电话：${configMap.tel1.paramValue1 }</c:when>
					<c:otherwise>联系电话：${configMap.phone.paramValue1 }</c:otherwise>
				</c:choose>
			</div>
			<div class="ending-QR-code">
				<img src="${configMap.erweima.paramValue1 }" alt="">
			</div>
		</div>
	</div>
	<!-- $底部结尾结束 -->
	<!-- $QQ交谈固定定位开始 -->
	<div class="qq-box">
		<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=837442643&site=qq&menu=yes">
			<img border="0" src="${configMap.qqbox.paramValue1 }" alt="点击这里给我发消息" title="点击这里给我发消息"/>
		</a>
	</div>
	<!-- $QQ交谈固定定位结束 -->
</body>
</html>