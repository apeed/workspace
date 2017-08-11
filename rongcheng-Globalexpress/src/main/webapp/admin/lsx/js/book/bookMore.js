$(function(){
	loadBookMore();
	$("#modify_button").click(modifyBtn);
});
function modifyBtn(){
	var bookId = getCookie("id");
	var bookMore_adminReply=$("#bookMore_adminReply").val();
	var bookMore_note=$("#bookMore_note").val();
	var display=$("input[name='isshow']:checked").val();
	var bookMore_userSequence=$("#bookMore_userSequence").val();
	var ok=true;
	if(bookMore_adminReply==""){
		$("#bookMore_adminReply_ts").html("回复内容为空");
		ok=false;
	}
	/*if(bookMore_note==""){
		$("#bookMore_note_ts").html("备注为空");
		ok=false;
	}*/
	if(ok){
		$.ajax({
			url:"/admin/modifyUserRemark.do",
			type:"post",
			dataType:"json",
			data:{
				"id":bookId,
				"adminReply":bookMore_adminReply,
				"note":bookMore_note,
				"show":display,
				"userSequence":bookMore_userSequence
				},
			 success:function(result){
				if(result.state==0){
					alert("修改成功！"); 	
					window.location.href = "book.do";	
				}
			},
			error:function(){
				alert("修改失败！"); 
			}
		});
	}
}

function loadBookMore() {
	var bookId = getCookie("id");
	$.ajax({
		url : "/admin/findByUserRemarkId.do",
		type : "post",
		data : {"id":bookId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var UserRemark = result.data;
				var userName = UserRemark.userName;
				var userTel = UserRemark.userTel;
				var userEmail = UserRemark.userEmail;
				var userWord = UserRemark.userWord;
				var userWordTime = UserRemark.userWordTime;
				var adminReply = UserRemark.adminReply;
				var note = UserRemark.note;
				var show = UserRemark.show;
				var userSequence = UserRemark.userSequence;
				/*console.log(userName+"--"+userTel+"--"+userEmail
						+"--"+userWord+"--"+userWordTime+"--"+adminReply+"--"+note+"--"+show+"--"+userSequence);*/
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
				var time = new Date(userWordTime).Format("yyyy-MM-dd hh:mm:ss");
				$("#bookMore_userName").val(userName);
				$("#bookMore_userTel").val(userTel);
				$("#bookMore_userEmail").val(userEmail);
				$("#bookMore_userWord").val(userWord);
				$("#bookMore_userWordTime").val(time);
				$("#bookMore_adminReply").val(adminReply);
				$("#bookMore_note").val(note);
//				var Display=$("input[name='isshow']:checked").val(show);
				
				if(show==0){
					$("#label2").click();
				}else if(show==1){
					$("#label1").click();
				}
				$("#bookMore_userSequence").val(userSequence);
				
			}
		},
		error:function(){
			alert("加载失败！"); 
		}
	});
}