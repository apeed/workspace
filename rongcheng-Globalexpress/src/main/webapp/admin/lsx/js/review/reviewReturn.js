$(function(){
	$(".reviewReturn_btn").click(modifyReviewReturn);
	loadReviewReturn();
});

function loadReviewReturn(){
	var itemSku = getCookie("itemSku");
	var accountNum=getCookie("accountNum");	
	
	$.ajax({
			url : "/admin/findByUserRemarkAccount.do",
			type : "post",
			data : {"accountNum":accountNum,
				"itemSku":itemSku},
			dataType : "json",
			success:function(result){
				if (result.state == 0) {
					var list = result.data;
					for (var i = 0; i < list.length; i++) {
						var UserRemark=list[i];
						var operatorId = UserRemark.operatorId;
						var userWord = UserRemark.userWord;
						var userWordTime = UserRemark.userWordTime;
						var adminReply = UserRemark.adminReply;
						var replyTime = UserRemark.replyTime;
					
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
						var time1 = new Date(userWordTime).Format("yyyy-MM-dd hh:mm:ss");
						var time2 = new Date(replyTime).Format("yyyy-MM-dd hh:mm:ss");
					//登录账号？
					 var str="";
						str+='<div class="form-group" style="margin-bottom:0;padding-bottom:0;">';
						str+='<div class="label" style="padding: 0 7px 0 0;">';
						str+='<label>'+accountNum+'：</label>';
						str+='</div>';
						str+='<div class="field" style="line-height:22px;">';
						str+='<span>'+userWord+'</span><br>';
						str+='<span style="float:right;"><i style="font-style:normal;">评论时间：</i>'+time1+'</span>';
						str+='</div>';
						 if(operatorId==null){return;}
						 if(operatorId!=null){  
						str+='<div class="form-group" style="margin-bottom:0;padding-bottom:0;">';
						str+='<div class="label" style="padding: 0 7px 0 0;">';
//						console.log(operatorId);
						$.ajax({
							url : "/admin/getByOperatorId.do",
							type : "post",
							async : false, 
							data : {"id":operatorId},
							dataType : "json",
							success:function(result){
								if (result.state == 0) {
									var list1 = result.data;
								for (var j = 0; j < list1.length; j++) {
									 accountNum1 = list1[j].accountNum;
								}	
							}
						},
						error:function(){
							alert("加载失败！"); 
						}
					});
						str+='<label>'+accountNum1+'：</label>';
						str+='</div>';
						if(replyTime!=null||adminReply!=null){
							str+='<div class="field" style="line-height:22px;">';
							str+='<span>'+adminReply+'</span><br>';
							str+='<span style="float:right;"><i style="font-style:normal;">回复时间：</i>'+time2+'</span>';	
							str+='</div>';
						}
					
						}
						$("#reviewReturn_div1").append(str);
					}
				}
			},
			error:function(){
				alert("加载失败！"); 
			}
		});
}

function modifyReviewReturn(){
	var reviewReturnId1 = getCookie("rid");
	var review_adminReply=$("#review_adminReply").val();
			$.ajax({
				url : "/admin/modifyUserRemark1.do",
				type : "post",
				data : {
					"id":reviewReturnId1,
					"adminReply":review_adminReply,
					"reply":1,
					},
				dataType : "json",
				success : function(result) {
					if(result.state==0){
							alert("评论回复成功！");
							window.location.href ="review.do";	
					}
				},
				error : function() {
					alert("回复失败!!!");
				}
			});
}