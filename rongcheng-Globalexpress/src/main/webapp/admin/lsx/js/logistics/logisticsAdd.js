$(function(){
	$(".logisticsAdd_btn").click(logisticsAddBtn);
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
function logisticsAddBtn(){
	var s1= editor.html();
	var logisticsAdd_orderId=$("#logisticsAdd_orderId").val();
	var logisticsAdd_platformId=$("#logisticsAdd_platformId").val();
	var logisticsAdd_shopId=$("#logisticsAdd_shopId").val();
	var logisticsAdd_carrierId=$("#logisticsAdd_carrierId").val();
	var logisticsAdd_carrierUrl=$("#logisticsAdd_carrierUrl").val();
	var logisticsAdd_trackingNum=$("#logisticsAdd_trackingNum").val();
	var logisticsAdd_happenTime=$("#some_class_1").val();
	var logisticsAdd_currentAddress=$("#logisticsAdd_currentAddress").val();
	var logisticsAdd_terminalId=$("#logisticsAdd_terminalId").val();
	var logisticsAdd_operatorTel=$("#logisticsAdd_operatorTel").val();
	var logisticsAdd_staffId=$("#logisticsAdd_staffId").val();
	var logisticsAdd_cargoStatus=$("#logisticsAdd_cargoStatus").val();
	var logisticsAdd_facilityId=$("#logisticsAdd_facilityId").val();
	var logisticsAdd_complete=$("#logisticsAdd_complete").val().trim();
	var logisticsAdd_nextAddress=$("#logisticsAdd_nextAddress").val();
	var logisticsAdd_nextTerminal=$("#logisticsAdd_nextTerminal").val();
	var logisticsAdd_transferCarrierId=$("#logisticsAdd_transferCarrierId").val();
	var logisticsAdd_transferCarrierUrl=$("#logisticsAdd_transferCarrierUrl").val();
	var logisticsAdd_transferTrackingNum=$("#logisticsAdd_transferTrackingNum").val();
	var logisticsAdd_userTrackingInfo=$("#logisticsAdd_userTrackingInfo").val();
	var logisticsAdd_note=$("#logisticsAdd_note").val();
	var logisticsAdd_show=$("input[name='qt']:checked").val();
	var ok=true;
	/*if(logisticsAdd_platformId==""){
		ok=false;
		$("#logisticsAdd_platformId_ts").html("电商平台为空");
	}
	if(logisticsAdd_shopId==""){
		ok=false;
		$("#logisticsAdd_shopId_ts").html("店铺名称为空");
	}
    var regEx = /[^\d]/;
	if(logisticsAdd_orderId==""){
		ok=false;
		$("#logisticsAdd_orderId_ts").html("订单编号为空");
	}else if(regEx.test(logisticsAdd_orderId)){
		ok=false;
		$("#logisticsAdd_orderId_ts").html("订单编号必须为数字！");
	}else{
		$("#logisticsAdd_orderId_ts").html("");
	}
	if(logisticsAdd_carrierId==""){
		ok=false;
		$("#logisticsAdd_carrierId_ts").html("物流公司名称为空");
	}else{
		$("#logisticsAdd_carrierId_ts").html("");
	}
	if(logisticsAdd_carrierUrl==""){
		ok=false;
		$("#logisticsAdd_carrierUrl_ts").html("物流公司网址为空");
	}else{
		$("#logisticsAdd_carrierUrl_ts").html("");
	}*/
//	var reg = /^[a-z]{2}\d{5}$/i;
    var regEx = /^(\d{1,2}|[a-zA-Z]{1,2})\d+$/;
	if(logisticsAdd_trackingNum==""){
		ok=false;
		$("#logisticsAdd_trackingNum_ts").html("物流单号为空");
	}else if(!regEx.test(logisticsAdd_trackingNum)){
		ok=false;
		$("#logisticsAdd_trackingNum_ts").html("物流单号必须为最多两个字母开头+数字！");
	}else{
		$("#logisticsAdd_trackingNum_ts").html("");
	}
	/*
	if(logisticsAdd_happenTime==""){
		ok=false;
		$("#logisticsAdd_happenTime_ts").html("发生时间为空");
	}else{
		$("#logisticsAdd_happenTime_ts").html("");
	}
	if(logisticsAdd_currentAddress==""){
		ok=false;
		$("#logisticsAdd_currentAddress_ts").html("订单当前位置为空");
	}else{
		$("#logisticsAdd_currentAddress_ts").html("");
	}
	if(logisticsAdd_terminalId==""){
		ok=false;
		$("#logisticsAdd_terminalId_ts").html("订单所在站点为空");
	}else{
		$("#logisticsAdd_terminalId_ts").html("");
	}
	
	if(logisticsAdd_staffId==""){
		ok=false;
		$("#logisticsAdd_staffId_ts").html("操作人为空");
	}else{
		$("#logisticsAdd_staffId_ts").html("");
	}
	if(logisticsAdd_cargoStatus==""){
		ok=false;
		$("#logisticsAdd_cargoStatus_ts").html("物流状态为空");
	}else{
		$("#logisticsAdd_cargoStatus_ts").html("");
	}
	if(logisticsAdd_facilityId==""){
		ok=false;
		$("#logisticsAdd_facilityId_ts").html("运输工具编号为空");
	}else if(regEx.test(logisticsAdd_facilityId)){
		ok=false;
		$("#logisticsAdd_facilityId_ts").html("运输工具编号必须为数字！");	
	}else{
		$("#logisticsAdd_facilityId_ts").html("");
	}
	if(logisticsAdd_complete==""){
		ok=false;
		$("#logisticsAdd_complete_ts").html("物流是否完成为空");
	}else if(logisticsAdd_complete!=1 && logisticsAdd_complete!=0){
		$("#logisticsAdd_complete_ts").html("物流是否完成输入0或1");
	}else{
		$("#logisticsAdd_complete_ts").html("");
	}
	if(logisticsAdd_nextAddress==""){
		ok=false;
		$("#logisticsAdd_nextAddress_ts").html("下一站地理位置为空");
	}else{
		$("#logisticsAdd_nextAddress_ts").html("");
	}
	if(logisticsAdd_nextTerminal==""){
		ok=false;
		$("#logisticsAdd_nextTerminal_ts").html("下一站点名称为空");
	}else{
		$("#logisticsAdd_nextTerminal_ts").html("");
	}
	if(logisticsAdd_transferCarrierId==""){
		ok=false;
		$("#logisticsAdd_transferCarrierId_ts").html("转运公司名称为空");
	}else{
		$("#logisticsAdd_transferCarrierId_ts").html("");
	}
	if(logisticsAdd_transferCarrierUrl==""){
		ok=false;
		$("#logisticsAdd_transferCarrierUrl_ts").html("转运公司网址为空");
	}else{
		$("#logisticsAdd_transferCarrierUrl_ts").html("");
	}
	if(logisticsAdd_transferTrackingNum==""){
		ok=false;
		$("#logisticsAdd_transferTrackingNum_ts").html("转运物流单号为空");
	}else if(regEx.test(logisticsAdd_transferTrackingNum)){
		ok=false;
		$("#logisticsAdd_transferTrackingNum_ts").html("转运物流单号必须为数字！");
	}else{
		$("#logisticsAdd_transferTrackingNum_ts").html("");
	}
	if(s1==""){
		ok=false;
		$("#logisticsAdd_userTrackingInfo_ts").html("自定义物流记录为空");
	}else{
		$("#logisticsAdd_userTrackingInfo_ts").html("");
	}
	if(logisticsAdd_note==""){
		ok=false;
		$("#logisticsAdd_note_ts").html("备注为空");
	}else{
		$("#logisticsAdd_note_ts").html("");
	}
	if(logisticsAdd_show==null){
		ok=false;
		$("#logisticsAdd_show_ts").html("显示为空");
	}else{
		$("#logisticsAdd_show_ts").html("");
	}*/
	if(logisticsAdd_operatorTel==""){
		ok=false;
		$("#logisticsAdd_operatorTel_ts").html("操作人电话为空");
	}else if(!/^(0|1)\d{10,11}$/.test(logisticsAdd_operatorTel)){
		ok=false;
		$("#logisticsAdd_operatorTel_ts").html("请输入正确的格式!");
	}else{
		$("#logisticsAdd_operatorTel_ts").html("");
	}
	if(ok){
			$.ajax({
				url : "/admin/add_cargoTracking.do",
				type : "post",
				data : {
					"platformId":logisticsAdd_platformId,
					"shopId":logisticsAdd_shopId,
					"staffId":logisticsAdd_staffId,
					"orderId":logisticsAdd_orderId,
					"carrierId":logisticsAdd_carrierId,
					"carrierUrl":logisticsAdd_carrierUrl,
					"trackingNum":logisticsAdd_trackingNum,
					"happenTime":logisticsAdd_happenTime,
					"currentAddress":logisticsAdd_currentAddress,
					"terminalId":logisticsAdd_terminalId,
					"operatorTel":logisticsAdd_operatorTel,
					"cargoStatus":logisticsAdd_cargoStatus,
					"facilityId":logisticsAdd_facilityId,
					"complete":logisticsAdd_complete,
					"nextAddress":logisticsAdd_nextAddress,
					"nextTerminal":logisticsAdd_nextTerminal,
					"transferCarrierId":logisticsAdd_transferCarrierId,
					"transferCarrierUrl":logisticsAdd_transferCarrierUrl,
					"transferTrackingNum":logisticsAdd_transferTrackingNum,
					"userTrackingInfo":s1,
					"show":logisticsAdd_show,
					"note":logisticsAdd_note
					},
				dataType : "json",
				success : function(result) {
					if(result.state==0){
						alert("添加物流信息成功！");
							window.location.href ="logistics.do";	
					}
				},
				error : function() {
					alert("添加失败!");
				}
			});
		}
}
