 
$(function(){
	loadModify();
	$(".logisticsPublic_btn").click(modifyBtn);
	
});
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		ccssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
});
function modifyBtn(){
	var s1= editor.html();
	var CargoTrackingId = getCookie("cid");
	var logisticsPublic_carrierId=$("#logisticsPublic_carrierId").val();
	var logisticsPublic_carrierUrl=$("#logisticsPublic_carrierUrl").val();
	var logisticsPublic_trackingNum=$("#logisticsPublic_trackingNum").val();
	var logisticsPublic_happenTime=$("#some_class_1").val();
	var logisticsPublic_currentAddress=$("#logisticsPublic_currentAddress").val();
	var logisticsPublic_terminalId=$("#logisticsPublic_terminalId").val();
	var logisticsPublic_operatorTel=$("#logisticsPublic_operatorTel").val();
	var logisticsPublic_staffId=$("#logisticsPublic_staffId").val();
	var logisticsPublic_cargoStatus=$("#logisticsPublic_cargoStatus").val();
	var logisticsPublic_facilityId=$("#logisticsPublic_facilityId").val();
	var logisticsPublic_complete=$("#logisticsPublic_complete").val();
	var logisticsPublic_nextAddress=$("#logisticsPublic_nextAddress").val();
	var logisticsPublic_nextTerminal=$("#logisticsPublic_nextTerminal").val();
	var logisticsPublic_transferCarrierId=$("#logisticsPublic_transferCarrierId").val();
	var logisticsPublic_transferCarrierUrl=$("#logisticsPublic_transferCarrierUrl").val();
	var logisticsPublic_transferTrackingNum=$("#logisticsPublic_transferTrackingNum").val();
//	var logisticsPublic_userTrackingInfo=$("#logisticsPublic_userTrackingInfo").val();
	var logisticsPublic_note=$("#logisticsPublic_note").val();
	var logisticsPublic_show=$("input[name='qt']:checked").val();
	var ok=true;
	var re = /^(0|1)\d{10,11}$/;
	if(logisticsPublic_operatorTel==""){
		ok=false;
		$("#logisticsPublic_operatorTel_ts").html("操作人电话为空");
	}else if(!re.test(logisticsPublic_operatorTel)){
		ok=false;
		$("#logisticsPublic_operatorTel_ts").html("请输入正确的格式!");
	}else{
		$("#logisticsPublic_operatorTel_ts").html("");
	}
		if(ok){
			$.ajax({
				url:"/admin/modify_cargoTracking.do",
				type:"post",
				dataType:"json",
				data:{
					"id":CargoTrackingId,
					"carrierId":logisticsPublic_carrierId,
					"carrierUrl":logisticsPublic_carrierUrl,
					"trackingNum":logisticsPublic_trackingNum,
					"happenTime":logisticsPublic_happenTime,
					"currentAddress":logisticsPublic_currentAddress,
					"terminalId":logisticsPublic_terminalId,
					"staffId":logisticsPublic_staffId,
					"operatorTel":logisticsPublic_operatorTel,
					"cargoStatus":logisticsPublic_cargoStatus,
					"facilityId":logisticsPublic_facilityId,
					"complete":logisticsPublic_complete,
					"nextAddress":logisticsPublic_nextAddress,
					"nextTerminal":logisticsPublic_nextTerminal,
					"transferCarrierId":logisticsPublic_transferCarrierId,
					"transferCarrierUrl":logisticsPublic_transferCarrierUrl,
					"transferTrackingNum":logisticsPublic_transferTrackingNum,
					"userTrackingInfo":s1,
					"show":logisticsPublic_show,
					"note":logisticsPublic_note
					},
				 success:function(result){
					if(result.state==0){
						alert("修改成功！"); 	
						window.location.href ="logistics.do";	
					}
				},
				error:function(){
					alert("修改失败！"); 
				}
			});	}
}
function loadModify(){
		var CargoTrackingId = getCookie("cid");
		$.ajax({
			url : "/admin/load_modify_cargoTracking.do",
			type : "post",
			data : {"id":CargoTrackingId},
			dataType : "json",
			success:function(result){
				if (result.state == 0) {
					var CargoTracking = result.data;
					var orderId = CargoTracking.orderId;
					var carrierId = CargoTracking.carrierId;
					var carrierUrl = CargoTracking.carrierUrl;
					var trackingNum = CargoTracking.trackingNum;
					var happenTime = CargoTracking.happenTime;
					var currentAddress = CargoTracking.currentAddress;
					var terminalId = CargoTracking.terminalId;
					var operatorTel = CargoTracking.operatorTel;
					var staffId = CargoTracking.staffId;
					var cargoStatus = CargoTracking.cargoStatus;
					var facilityId = CargoTracking.facilityId;
					var complete = CargoTracking.complete;
					var nextAddress = CargoTracking.nextAddress;
					var nextTerminal = CargoTracking.nextTerminal;
					var transferCarrierId = CargoTracking.transferCarrierId;
					var transferCarrierUrl = CargoTracking.transferCarrierUrl;
					var transferTrackingNum = CargoTracking.transferTrackingNum;
					var userTrackingInfo = CargoTracking.userTrackingInfo;
					var show = CargoTracking.show;
					var note = CargoTracking.note;
					var platformId = CargoTracking.platformId;
					var shopId = CargoTracking.shopId;
					$("#logisticsPublic_orderId").html(orderId);
					$("#logisticsPublic_platformId").html(platformId);
					$("#logisticsPublic_shopId").html(shopId);
					var logisticsPublic_carrierId=$("#logisticsPublic_carrierId").val(carrierId);
					var logisticsPublic_carrierUrl=$("#logisticsPublic_carrierUrl").val(carrierUrl);
					var logisticsPublic_trackingNum=$("#logisticsPublic_trackingNum").val(trackingNum);
					Date.prototype.Format = function (fmt) { //author: meizz 
					    var o = {
					        "M+": this.getMonth() + 1, //月份 
					        "d+": this.getDate(), //日 
					        "h+": this.getHours(), //小时 
					        "m+": this.getMinutes(), //分 
					        "s+": this.getSeconds(), //秒 
					        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
					        "S": this.getMilliseconds() //毫秒 
					    };
					    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
					    for (var k in o)
					    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
					    return fmt;
					}
					var time = new Date(happenTime).Format("yyyy-MM-dd hh:mm:ss");
					var logisticsPublic_happenTime=$("#some_class_1").val(time);
					var logisticsPublic_currentAddress=$("#logisticsPublic_currentAddress").val(currentAddress);
					var logisticsPublic_terminalId=$("#logisticsPublic_terminalId").val(terminalId);
					var logisticsPublic_operatorTel=$("#logisticsPublic_operatorTel").val(operatorTel);
					var logisticsPublic_staffId=$("#logisticsPublic_staffId").val(staffId);
					var logisticsPublic_cargoStatus=$("#logisticsPublic_cargoStatus").val(cargoStatus);
					var logisticsPublic_facilityId=$("#logisticsPublic_facilityId").val(facilityId);
					var logisticsPublic_complete=$("#logisticsPublic_complete").val(complete);
					var logisticsPublic_nextAddress=$("#logisticsPublic_nextAddress").val(nextAddress);
					var logisticsPublic_nextTerminal=$("#logisticsPublic_nextTerminal").val(nextTerminal);
					$("#logisticsPublic_transferCarrierId").val(transferCarrierId);
					var index = $.inArray(transferCarrierId,oftenUseExpress);
					if(transferCarrierId == "EMS"){
						$(".transfer_btn").html(transferCarrierId);
					}else if(index == -1){
						index = $.inArray(transferCarrierId,allExpress);
						if(index == -1){
							$(".transfer_btn").html(transferCarrierId);
						}else {
							$(".transfer_btn").html(allExpress[index-1]);
						}
					}else{
						$(".transfer_btn").html(oftenUseExpress[index-1]);
					}
					var logisticsPublic_transferCarrierUrl=$("#logisticsPublic_transferCarrierUrl").val(transferCarrierUrl);
					var logisticsPublic_transferTrackingNum=$("#logisticsPublic_transferTrackingNum").val(transferTrackingNum);
//					var logisticsPublic_userTrackingInfo=$("#logisticsPublic_userTrackingInfo").val(userTrackingInfo);
					editor.html(userTrackingInfo);
					var logisticsPublic_note=$("#logisticsPublic_note").val(note);
					$(".radio").find('input[value="'+show+'"]').prop("checked", true);
				}
			},
			error:function(){
				alert("加载失败！"); 
			}
		});
}