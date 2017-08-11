<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="public/head.jsp" flush="true" />
    <link rel="stylesheet" href="/foreground/css/inquire.css">
    <script src="/foreground/js/inquire.js"></script>
    <script src="/admin/jxb/js/jiml-utils.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		var trackingNum = "${trackingNum }";
    		if(!$.isEmptyObject( trackingNum )){
    			search(trackingNum);
    		}
    	});
    	function search(trackingNum) {
    		$('.content').css('display','none');
    		$.ajax({
    			url:"/express/inquire.do",
    			type:"post",
    			data:{"trackingNum":trackingNum},
    			dataType:"json",
    			success : function(result) {
    				if (result == -1) {
    					message("运单格式错误");
    				}else if(result == 0){
    					message("运单不存在");
    				}else{
    					var cargoTracking = result.cargoTracking;
    					var kdniaoTrack = result.kdniaoTrack[0];
    					$("#platformName").html(cargoTracking.platformId);
    					$("#shopName").html(cargoTracking.shopId);
    					$("#orderId").html(cargoTracking.orderId);
    					$("#trackingNum").html(cargoTracking.trackingNum);
    					$("#userTrackingInfo").html(cargoTracking.userTrackingInfo);
    					if(kdniaoTrack.Traces.length != 0){
    						var str = '';
    						for (var int = 0; int < kdniaoTrack.Traces.length; int++) {
    							str +='<p>'+kdniaoTrack.Traces[int].AcceptTime+'&nbsp;&nbsp;&nbsp;'+kdniaoTrack.Traces[int].AcceptStation+'</p>';
							}
	    					$("#tracking2").html(str);
    					}
	    				$('.content').css('display','block');
    				}
        			$('.jiaz').css('display','none');
    			},
    			error : function(data) {
        			$('.jiaz').css('display','none');
        			message("查询失败");
    			}
    		});
		}
    	
    	function message(message){
    		$(".search_alert").html(message);
			$(".search_alert").css("top",0);
			setTimeout(function(){
				$(".search_alert").css("top","-100%");
			},2000);
    	}
    </script>
</head>
<body>
<!--頭部-->
<jsp:include page="public/header.jsp" flush="true" />
<!--主體部分-->
<div class="main">
    <h1>订单跟踪</h1>
    <div class="search_input">
        <input type="text" placeholder="请输入包裹运单号">
        <div class="search_button fr" >
           点击跟踪
        </div>
        <div class="search_alert">
			
        </div>
    </div>
    <div class="content" style="display: none;">
        <ul class="text_div">
            <li>
                <div class="left_text">
					平台：<span id="platformName"></span>
                </div>
                <div class="right_text">
					店铺名称：<span id="shopName"></span>
                </div>
            </li>
            <li>
                <div class="left_text">
					订单编号：<span id="orderId"></span>
                </div>
                <div class="right_text">
					物流编号：<span id="trackingNum"></span>
                </div>
            </li>
        </ul>
        <h5>运单跟踪记录</h5>
        <div class="div_box" id="userTrackingInfo" style="margin-bottom:0;"></div>
        <div class="div_box div_color" id="tracking2" style="margin-top:0;border-top:0;"></div>
    </div>
    <div class="jiaz" style="display: none;">
        <img src="/foreground/images/loading.gif" alt="">
    </div>
</div>
<!--底部-->
<jsp:include page="public/footer.jsp" flush="true" />
</body> 
</html>