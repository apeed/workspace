<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="/backstage/css/pintuer.css">
    <link rel="stylesheet" href="/backstage/css/admin.css">
    <script src="/backstage/js/jquery.js"></script>
    <script src="/backstage/js/pintuer.js"></script>  
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>更多留言</strong></div>
  <div class="body-content">
  <div class="form-x">   
    <div class="form-group">
      <div class="label">
        <label>姓名：</label>
      </div>
      <div class="field">
        <input type="text" class="input w50" name="title" value="${leaveMessage.name }" readonly style="border: 0 ;background-color: white;"/>
        <div class="tips"></div>          
      </div>
    </div> 
    <div class="form-group">
      <div class="label">
        <label>电话：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="entitle" value="${leaveMessage.tel }" readonly style="border: 0 ;background-color: white;"/>
        <div class="tips"></div> 
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>邮箱：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="entitle" value="${leaveMessage.email }" readonly style="border: 0 ;background-color: white;"/>
        <div class="tips"></div> 
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>留言内容：</label>
      </div>
      <div class="field">
        <textarea type="text" class="input" name="s_desc" style="height:100px;" readonly style="border: 0 ;background-color: white;">${leaveMessage.content }</textarea>    
        <div class="tips"></div>     
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>留言时间：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="s_keywords" value="${leaveMessage.creatTime }"readonly style="border: 0 ;background-color: white;"/>  
        <div class="tips"></div>        
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>回复内容：</label>
      </div>
      <div class="field">
        <textarea type="text" class="input" name="reply" style="height:100px;" form="form1">${leaveMessage.reply }</textarea>     
        <div class="tips"></div>    
      </div>
    </div>  
    <div class="form-group">
      <div class="label">
        <label>回复时间：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="s_keywords" value="${leaveMessage.replyTime }"readonly style="border: 0 ;background-color: white;"/>  
        <div class="tips"></div>        
      </div>
    </div>     
    <form id="form1">
    <input type="hidden" name="id"  value="${leaveMessage.id }" /> 
    <div class="form-group">
      <div class="label">
        <label>备注：</label>
      </div>
      <div class="field">
        <input type="text" class="input" name="remark" value="${leaveMessage.remark }" />    
        <div class="tips"></div>      
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>显示：</label>
      </div>
      <div class="field">
        <div class="button-group radio">
          <label class="button <c:if test="${leaveMessage.display==1 }">active</c:if>">
            <span class="icon icon-check"></span>             
              <input name="display" value="1" type="radio" <c:if test="${leaveMessage.display==1 }">checked="checked"</c:if>>是
          </label>             
          <label class="button <c:if test="${leaveMessage.display==0 }">active</c:if>"><span class="icon icon-times"></span>            
              <input name="display" value="0"  type="radio" <c:if test="${leaveMessage.display==0 }">checked="checked"</c:if>>否
          </label>
        </div>       
      </div>
    </div>
    <div class="form-group">
      <div class="label">
        <label>排序：</label>
      </div>
      <div class="field">
        <input type="text" class="input w50" name="seq" value="${leaveMessage.seq }"  data-validate="required:,number:排序必须为数字" />
        <div class="tips"></div>
      </div>
    </div>
    </form>  
    <div class="form-group">
      <div class="label">
        <label></label>
      </div>
      <div class="field">
        <a class="button bg-main icon-check-square-o" href="javascript:;" onclick="updateDisplay()">处理留言</a>
      </div>
    </div>
  </div>
  </div>
  </div>
  <script>
  	function updateDisplay() {
  		$.ajax({
  			url : "/admin/leavemessage/update.do",
  			type : "post",
  			data : $("#form1").serialize(),
  			dataType : "json",
  			success : function(result) {
  				if(result.data==1){
  					alert("处理成功");
  				}
  			},
  			error : function() {
  				alert("处理失败!!!");
  			}
  		});
	}
  </script>
</body>
</html>