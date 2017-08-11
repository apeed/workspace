<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="public/head.jsp" flush="true" />
    <link rel="stylesheet" href="/foreground/css/list.css">
    <script type="text/javascript" src="/admin/jxb/js/jiml-utils.js"></script>
</head>
<body>
<!--头部-->
<jsp:include page="public/header.jsp" flush="true" />
<!--主体部分-->
<div class="main">
    <h3>${blockChannelTitle }</h3>
    <div class="content">
        <div class="top">
            <div class="title">
				栏目
            </div>
            <ul id="T1BCUl">
            	<%-- 栏目区 --%>
            </ul>
        </div>
        <ul class="bottom" id="contentListUl">
        	<%-- 内容列表区
																											 	<c:forEach items="${allContentList }" var="content">
																											      <li>
																											          <a href="javascript:;">${content.contentTitle }</a>
																											          <span>[<i><fmt:formatDate value="${content.gmtCreate }" pattern="yyyy-MM-dd"/> </i>]</span>
																											      </li>
																											 	</c:forEach> --%>
        </ul>
        <div id="pageLi" style="text-align: center;padding-top: 5px;"></div>
    </div>
</div>
<!--底部-->
<jsp:include page="public/footer.jsp" flush="true" />
<script type="text/javascript">
$(function(){
	loadT1BCList();
	loadContentList(CList);
});
//加载内容列表区上面的栏目区
function loadT1BCList(){
	var T1BCList = ${type1BlockChannelList };
	var ul = $("#T1BCUl");
	var str = '';
	for(var i = 0;i<T1BCList.length;i++){
		var T1BC = T1BCList[i];
		str += '<li>';
		if($.isEmptyObject( $.trim(T1BC.iconDirectLink) )){
			str += '<a href="javascript:;" onclick="toPage(\''+ T1BC.id +'\',\''+ T1BC.blockTitle +'\')">';
		}else{
			str += '<a href="'+ T1BC.iconDirectLink +'"target="_blank">';
		}
		str += T1BC.blockTitle;
		str += '</a></li>';
	}
	ul.append(str);
}
//加载内容列表区
var CList = ${map[0].allContentList};
function loadContentList(CList){
	var ul = $("#contentListUl");
	ul.empty();
	var str = '';
	for(var i = 0;i<CList.length;i++){
		var content = CList[i];
		if(!$.isEmptyObject(content.contentTitle)){//是页面内容
			str += '<li>';
			str += '<a href="';
			if($.isEmptyObject( $.trim(content.iconDirectLink) )){
				str += 'show.do?id='+ content.id +'&contentTitle='+ content.contentTitle +'&contentType=1" target="_blank">';
			}else{
				str += content.iconDirectLink +'"target="_blank">';
			}
			str += content.contentTitle;
			str += '</a>';
			if(flag){
				str += '<span>[<i>'+new Date(content.gmtCreate).format("yyyy-MM-dd")+'</i>]</span>';
			}else{
				var myDate=new Date();
				myDate.setFullYear(content.gmtCreate.year+1900);
				myDate.setMonth(content.gmtCreate.month+1);
				myDate.setDate(content.gmtCreate.date);
				str += '<span>[<i>'+myDate.format("yyyy-MM-dd")+'</i>]</span>';
			}
			str += '</li>';
		}else if(!$.isEmptyObject(content.mediaUrl)){//是媒体内容
			str += '<li>';
			str += '<a href="';
			if($.isEmptyObject( $.trim(content.iconDirectLink) )){
				str += content.mediaUrl +'" target="_blank">';
			}else{
				str += content.iconDirectLink +'"target="_blank">';
			}
			str += content.interfaceName;
			str += '</a>';
			if(flag){
				str += '<span>[<i>'+new Date(content.gmtCreate).format("yyyy-MM-dd")+'</i>]</span>';
			}else{
				var myDate=new Date();
				myDate.setFullYear(content.gmtCreate.year+1900);
				myDate.setMonth(content.gmtCreate.month+1);
				myDate.setDate(content.gmtCreate.date);
				str += '<span>[<i>'+myDate.format("yyyy-MM-dd")+'</i>]</span>';
			}
			str += '</li>';
		}
	}
	ul.append(str);
	pagination(maxPage,nowPage,"pageLi","loadByPage");
}
var nowPage = 1;
var maxPage = ${map[0].maxPage};
//是否通过翻页按钮查询列表
var flag = false;
function loadByPage(page) {
	flag = true;
	if(page<1 || page>maxPage && maxPage!=0){return;}
		var data = "&page="+page;
   		data+="&blockChannelId=${blockChannelId }";
		$.ajax({
			url:"/byPage.do",
			type:"post",
			data:data,
			dataType:"json",
			success : function(result) {
					nowPage = page;
					loadContentList(result);
					pagination(maxPage,nowPage,"pageLi","loadByPage");
			},
			error : function(data) {
				showMessage("内容加载失败，请刷新重试。");
			}
		});
}
</script>
</body>
</html>