<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<link rel="stylesheet" href="/admin/css/first.css">
<%-- <script src="/admin/jxb/js/jiml-utils.js"></script>
<script type="text/javascript">
$(function(){
	loadBlockChannel(1);
});
var now_page=0;
var max_page=1;
function loadBlockChannel(page) {
	now_page=0;
	if(page<= 0||page> max_page||page==now_page){return;}
	now_page=page;
	$.ajax({
		url : "/admin/first/heat.do",
		type : "post",
		data : {"page":page},
		dataType : "json",
		success : function(result) {
			max_page = result.message;
			reload(result.data);
		},
		error : function() {
			showMessage("热度内容加载失败，请刷新重试。");
		}
	});
}
function reload(data) {
	$(".clearTr").remove();
	var tr = '';
	if(data != null){
		for (var i = 0; i < data.length; i++) {
			var obj = data[i];
			tr += '<tr class="clearTr"><td style="padding-left:20px;">';
			tr += obj.seq;
			tr += '</td><td>';
			switch (obj.recordType) {
			case 1:
				tr += '区块栏目标题';
				break;
			case 2:
				tr += '外链';
				break;
			case 3:
				tr += '类目导航';
				break;
			case 4:
				tr += '其他';
				break;
			default:
				tr += '未知';
				break;
			}
			tr += '</td><td>';
			tr += obj.click;
			tr += '</td></tr>';
		}
		$("#reloadTable").append(tr);
		pagination(max_page,now_page,"pagelist","loadBlockChannel");
	}
}
</script> --%>
</head>
<body style="position:relative;">
  <div id="listform">
    <div class="panel admin-panel content_first">
      <div class="panel-head"><strong class="icon-reorder"> 登录信息</strong></div>
      <ul class="left_first">
        <li>
          <span>用户账户</span>
          <span>${user.accountNum }</span>
        </li>
        <li>
          <span>用户姓名</span>
          <span>${user.userName }</span>
        </li>
        <li>
          <span>用户电话</span>
          <span>${user.userTelephone }</span>
        </li>
        <li>
          <span>用户身份</span>
          <span>
          		<c:choose>
	          		<c:when test="${user.userType==1 }">主账号</c:when>
	          		<c:when test="${user.userType==2 }">管理员</c:when>
	          		<c:when test="${user.userType==3 }">普通用户</c:when>
	          		<c:when test="${user.userType==4 }">外部客户</c:when>
	          	</c:choose>
          </span>
        </li>
      </ul>
      <ul class="right_first">
        <li>
          <span>网站名称</span>
          <span>${siteTitle }</span>
        </li>
        <li>
          <span>后台系统版本</span>
          <span>${version }</span>
        </li>
        <li>
          <span>登录ip</span>
          <span>${ip }</span>
        </li>
        <li>
          <span>登录时间</span>
          <span><fmt:formatDate value="${loginTime }" type="both"/></span>
        </li>
      </ul>
    </div>
    <div class="panel admin-panel" style="border: 0;">
      <%-- <div class="panel-head"><strong class="icon-reorder"> 点击热度分析</strong></div>
      <table class="table table-hover text-center" id="reloadTable">
        <tr>
          <th style="padding-left:20px;">序号</th>
          <th>被访问栏目</th>
          <th>点击量 </th>
        </tr>
        </table> --%>
        <table class="table table-hover text-center">
        <tr>
          <td colspan="9" style="padding: 3px;border-top: 0;">
            <p style="margin-bottom: 0;line-height: 14px;margin-top:20px;">
              技术支持：<a href="javascript:;">support@rongcheng-tech.com</a>&nbsp;&nbsp;&nbsp;联系电话：18920294357
            </p>
          </td>
        </tr>
        <tr>
          <td colspan="9" style="border-top:0;padding: 3px;">
            <p style="margin-bottom: 0;line-height: 14px;">版权所有 &copy; 融成（天津）信息技术有限公司 2015-2017  所有权利保留</p>
          </td>
        </tr>
        <tr>
          <td colspan="9" style="border-top:0;">
            <p style="line-height: 0;">Copyright &copy; Rongcheng(Tianjin) Information Technology Co. Ltd. 2015-2017 All Rights Reserved. Powered by Rongcheng-Tech</p>
          </td>
        </tr>
      </table>
      <div class="ewm" style="height: 80px;text-align:center;margin-bottom:20px;">
        <img src="images/ewm.png" alt="" style="height: 100%">
      </div>
    </div>
  </div>
</body>
</html>