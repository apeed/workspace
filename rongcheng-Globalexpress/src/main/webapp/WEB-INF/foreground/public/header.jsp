<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--头部-->
<div class="header">
    <!--logo与nav-->
    <div class="logo_nav">
        <div class="logo fl">
            <a href="/">
                <img src="${configMap.siteLogo.parameterValue1 }" alt="">
            </a>
        </div>
        <ul class="nav fl" id="navUl">
            <li class="fl">
                <a href="/">
                    <i></i>
                    网站首頁
                </a>
            </li>
            <%-- <c:forEach items="${BCList }" var="bc">
            	<c:if test="${bc.parentId==0 }">
		            <li class="fl">
		                <a href="show.do">
		                    <i></i>
							${bc.blockTitle }
							<c:forEach items="${BCList }" var="zbc">
								<c:if test="${zbc.parentId==bc.id }">
									<li class="fl">
									    <a href="show.do">
									        <i></i>
									       ${zbc.blockTitle }
									    </a>
									</li>
								</c:if>
							</c:forEach>
		                </a>
		            </li>
            	</c:if>
            </c:forEach> --%>
        </ul>
        <div class="jt_ft_qh fl">
            <a id="switcher_link" href="#" >繁体中文</a>
        </div>
    </div>
</div>
<script type="text/javascript">
var BCList = ${BCList };
var navUl = $("#navUl");
var str = '';
for(var i = 0;i<BCList.length;i++){
	var BC = BCList[i];
	if(BC.parentId == 0){
		var oneId = BC.id;
		str += '<li class="fl">';
		if($.isEmptyObject( $.trim(BC.iconDirectLink) )){
			str += '<a href="javascript:;" onclick="toPage(\''+ BC.id +'\',\''+ BC.blockTitle +'\')">';
		}else{
			str += '<a href="'+ BC.iconDirectLink +'"target="_block">';
		}
		str += '<i></i>'+ BC.blockTitle +'</a>';
		var flag = 0;//标志有没有二级栏目
		for(var j = 0;j<BCList.length;j++){
			BC = BCList[j];
			if(BC.parentId == oneId){
				flag++;
				var twoId = BC.id;
				if(flag == 1){
					str += '<ol>';
				}
				str += '<li>';
				if($.isEmptyObject( $.trim(BC.iconDirectLink) )){
					str += '<a href="javascript:;" onclick="toPage(\''+ BC.id +'\',\''+ BC.blockTitle +'\')">';
				}else{
					str += '<a href="'+ BC.iconDirectLink +'"target="_block">';
				}
				str += BC.blockTitle +'</a>';
				for(var k = 0;k<BCList.length;k++){
					BC = BCList[k];
					if(BC.parentId == twoId){
						var threeId = BC.id;
						str += '<div class="son_nav_box"><div class="son_nav">';
						if($.isEmptyObject( $.trim(BC.iconDirectLink) )){
							str += '<a href="javascript:;" onclick="toPage(\''+ BC.id +'\',\''+ BC.blockTitle +'\')">';
						}else{
							str += '<a href="'+ BC.iconDirectLink +'"target="_block">';
						}
						str += BC.blockTitle +'</a></div>';
						str += '</div>';
					}
				}
                   str += '</li>';
			}
		}
		if(flag>0){
			str += '</ol>';
		}
		str += '</li>';
	}
}
navUl.append(str);
function toPage(BCId,BCTitle) {
	if (BCTitle.indexOf("运单跟踪") != -1) {
		window.location.href='page.do?id='+ BCId +'&blockTitle='+ BCTitle;
	}
	$.ajax({
		url:"/isHaveContent.do",
		type:"post",
		data:{"id":BCId},
		dataType:"json",
		success : function(result) {
			if (result > 1) {
				window.location.href='page.do?id='+ BCId +'&blockTitle='+ BCTitle;
			}else if(result == 1){
				window.open('page.do?id='+ BCId +'&blockTitle='+ BCTitle);
			}
		},
		error : function(data) {
			showMessage("内容加载失败，请刷新重试。");
		}
		});
	}
</script>
<script src='/foreground/js/transfrom.js'></script>
<link rel="stylesheet" href="/foreground/css/base.css">
<link rel="stylesheet" href="/foreground/css/style.css">