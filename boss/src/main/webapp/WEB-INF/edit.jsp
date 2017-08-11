<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="ctx" value="${pageContext.request.contextPath}" />  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
  <head>  
    <title>xheditor</title>    
    <base href="<%=basePath%>"/>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">   
    <link rel="stylesheet" type="text/css" href="css/style.css">   
    <link rel="stylesheet" type="text/css" href="css/main.css">   
    <script type="text/javascript" src="${ctx}/xheditor-1.1.7/jquery/jquery-1.4.2.min.js"></script>  
    <script type="text/javascript" src="${ctx}/xheditor-1.1.7/xheditor-1.1.7-zh-cn.min.js"></script>  
    <script type="text/javascript" src="${ctx}/js/yz.js"></script>   
    <script type="text/javascript">  
    $(document).ready(function() {  
        //初始化xhEditor编辑器插件  
        $('#xh_editor').xheditor({  
            tools:'full',  
            skin:'default',  
            upMultiple:true,  
            upImgUrl: "servlet/UploadFileServlet",  
            upImgExt: "jpg,jpeg,gif,bmp,png",  
            onUpload:insertUpload,  
            html5Upload:false  
        });   
        //xbhEditor编辑器图片上传回调函数  
        function insertUpload(msg) {    
            var _msg = msg.toString();  
            //var _picture_name = _msg.substring(_msg.lastIndexOf("/")+1);  
            //var _picture_path = Substring(_msg);  
            //var _str = "<input type='checkbox' name='_pictures' value='"+_picture_path+"' checked='checked' onclick='return false'/><label>"+_picture_name+"</label><br/>";  
            //alert("xh_editor==before="+$("#xh_editor").val());   
            $("#xh_editor").append(_msg);   
            //$(""+_msg).appendTo($("#clubDesc"));        
            //alert("xh_editor==end="+$("#xh_editor").val());     
        }  
        //处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.  
        function Substring(s){  
            return s.substring(s.substring(0,s.lastIndexOf("/")).lastIndexOf("/"),s.length);  
        }  
        //save  
         $("#save").bind("click",function(){  
               // var xh_editor = $("#xh_editor").val().replace(/\s/g, "");   
                //alert("last=="+xh_editor);     
                document.getElementById("froms").submit();  
         });    
     });  
    </script>   
  </head>  
  <body>   
  
  <div class="contents">    
    <form method="POST" name ="froms" id="froms"  action="test/add.html" class="dataForm">   
        <div class="form">   
            <ul>  
                <li><label>简介：</label>   
                <div class="fields-box">  
                    <em></em><textarea rows="25" cols="160" name="clubDesc" id="xh_editor"    
                    style="border: 1px"></textarea>    
                </div>
                </li>  
            
                <li><label></label>  
                    <div class="fields-box">  
                        <input class="button_blue inputS" type="button" id="save"   
                            value="确定保存">   
                    </div>
                </li>  
                 </ul> 
          
        </div>  
    </form>  
</div>  


    <!-- <div id="uploadList"></div> -->   
  </body>  
</html> 