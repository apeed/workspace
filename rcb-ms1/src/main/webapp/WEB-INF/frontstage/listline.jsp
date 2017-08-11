<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" flush="true" />
	<link rel="stylesheet" href="frontstage/css/page.css">
	<link rel="stylesheet" href="/css/admin.css">
	<link rel="stylesheet" href="/css/pinture.css">

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
				<span>您的位置：</span><a href="javascript:;"></a><span>&gt;</span><a href="/">首页</a><span>&gt;</span><a href="javascript:;">${oneMenuTitle }</a>
				<c:if test="${twoMenuTitle!=null}"><span>&gt;</span><a href="javascript:;" id = "weizhi_twomenutitle">${twoMenuTitle }</a></c:if>
				
				
			</div>
			<ul class="page-content-text" id="reload">
				<c:forEach items="${singlePageList}" var="singlePage">
					<li class="page-news" >
						<a href="show.php?id=${singlePage.id}" target="_blank">${singlePage.title }</a>
							<span>${singlePage.createTime }</span>
						<p style="color: #999999;padding-left: 2px;">${singlePage.profile }</p>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- page页面的内容结束 -->
	
	<script type="text/javascript">
	var oneId=${twoMenuList[0].oneMenuId};
	var twoId=${twoMenuId};
	var now_page=1;
	var max_page=${max_page };
	$(function(){
	    loadLeaveMessageByPage(1);
	});
	function tiaozhuan(){
		var page = new Number($("#page_tz").val());
		loadLeaveMessageByPage(page);
	}
	function loadLeaveMessageByPage(page) {
		if(page <= 0 || page > max_page){return;}
		now_page=page;
		$.ajax({
			url : "loadsinglepagebypage.php",
			type : "post",
			data : {
				"page" : page,
				"oneMenuId" : oneId,
				"twoMenuId" : twoId,
			},
			dataType : "json",
			success : function(result) {
				max_page = result.message;
				reload(result.data);
			},
			error : function() {
				alert("失败!!!");
				reload(result.data);
			}
		});
	}
	function reload(singlePageList) {
		var ul = $("#reload");
		ul.empty();
		var lis = '';
		for (var i = 0; i < singlePageList.length; i++) {
			var singlePage = singlePageList[i];
			lis += '<li class="page-news" ><a href="show.php?id='+singlePage.id+'" target="_blank">'+singlePage.title+'</a><span>'+new Date(singlePage.createTime).format('yyyy-MM-dd hh:mm:ss')+'</span><p style="color: #999999;padding-left: 2px;">'+singlePage.profile+'</p></li>';
		}
		lis += '<tr id = "page_tr">';
		lis += '<td colspan="8"><div class="pagelist"><a class="bookpage" onclick="loadLeaveMessageByPage(1)">首页</a> <a class="bookpage" onclick="loadLeaveMessageByPage('+(now_page-1)+')"><</a>';
		
		if(max_page>5){
			if(now_page<=3){
				lis += '<a class="bookpage" onclick="loadLeaveMessageByPage(1)">1</a><a class="bookpage" onclick="loadLeaveMessageByPage(2)">2</a><a class="bookpage" onclick="loadLeaveMessageByPage(3)">3</a><a class="bookpage" onclick="loadLeaveMessageByPage(4)">4</a><a class = "bookpage" onclick="loadLeaveMessageByPage(5)">5</a>...';
			}else if(now_page>=4 && now_page<=max_page-3){
				lis += '...<a class="bookpage" onclick="loadLeaveMessageByPage('+(now_page-2)+')">'+(now_page-2)+'</a><a class="bookpage" onclick="loadLeaveMessageByPage('+(now_page-1)+')">'+(now_page-1)+'</a>';
				lis += '<a class="bookpage" onclick="loadLeaveMessageByPage('+now_page+')">'+now_page+'</a>';
				lis += '<a class = "bookpage" onclick="loadLeaveMessageByPage('+(now_page+1)+')">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadLeaveMessageByPage('+(now_page+2)+')">'+(now_page+2)+'</a>...';
			}else if(now_page>max_page-3){
				lis += '...<a class="bookpage" onclick="loadLeaveMessageByPage('+(max_page-4)+')">'+(max_page-4)+'</a><a class="bookpage" onclick="loadLeaveMessageByPage('+(max_page-3)+')">'+(max_page-3)+'</a><a class="bookpage" onclick="loadLeaveMessageByPage('+(max_page-2)+')">'+(max_page-2)+'</a><a class="bookpage" onclick="loadLeaveMessageByPage('+(max_page-1)+')">'+(max_page-1)+'</a><a class = "bookpage" onclick="loadLeaveMessageByPage('+max_page+')">'+max_page+'</a>';
			}
		}else{
			var i = 1;
			while (i <= max_page) {
				if(i==1){
					lis += '<a class="bookpage" onclick="loadLeaveMessageByPage(1)">1</a>';
				}else{
					lis += '<a class = "bookpage" onclick="loadLeaveMessageByPage('+i+')">'+i+'</a>';
				}
				i++;
			}
		}
		
		lis += '<a class="bookpage" onclick="loadLeaveMessageByPage('+(now_page+1)+')">></a><a class="bookpage" onclick="loadLeaveMessageByPage('+max_page+')">尾页</a> <input id="page_tz"/> <a class="bookpage" onclick="tiaozhuan()">跳转</a></div></td>';
		lis += '</tr>';
		ul.append(lis);
		$(".bookpage:contains('"+now_page+"')").addClass("now_page");
	}
	
	Date.prototype.format = function(format) {
	    var date = {
	           "M+": this.getMonth() + 1,
	           "d+": this.getDate(),
	           "h+": this.getHours(),
	           "m+": this.getMinutes(),
	           "s+": this.getSeconds(),
	           "q+": Math.floor((this.getMonth() + 3) / 3),
	           "S+": this.getMilliseconds()
	    };
	    if (/(y+)/i.test(format)) {
	           format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
	    }
	    for (var k in date) {
	           if (new RegExp("(" + k + ")").test(format)) {
	                  format = format.replace(RegExp.$1, RegExp.$1.length == 1
	                         ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
	           }
	    }
	    return format;
	}
	</script>
	
	
<jsp:include page="footer.jsp" flush="true" />