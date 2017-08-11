$(function(){
	loadModify();
	$(".modify_btn").click(modifyNoticeBtn);
	
});
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content1"]', {
		ccssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
});
var editor2;
KindEditor.ready(function(K) {
	editor2 = K.create('textarea[name="content2"]', {
		ccssPath : '/editor/plugins/code/prettify.css',
		uploadJson : '/editor/jsp/upload_json.jsp',
		fileManagerJson : '/editor/jsp/file_manager_json.jsp',
		allowFileManager : true,
	});
});

function modifyNoticeBtn(){
	
	var statementNoticeId = getCookie("id");
	var notice_statementTitle=$("#notice_statementTitle").val();
	if(notice_statementTitle.length>10){
		$("#notice_statementTitle_ts").html("公告名称不能超过10个字符");	
	}else{
		$("#notice_statementTitle_ts").html("");
	}
	var notice_note=$("#notice_note").val();
	/*if(notice_note.length>100){
		$("#notice_note_ts").html("备注过长！");	
	}else{
		$("#notice_note_ts").html("");	
	}*/
	var s1= editor1.html();
	var s2= editor2.html();
	var ok=true;
		if(ok){
			$.ajax({
				url:"/admin/modify_statementNotice.do",
				type:"post",
				dataType:"json",
				data:{"id":statementNoticeId,
					"statementTitle":notice_statementTitle,
					"statement":s1,
					"notice":s2,
					"note":notice_note
					},
				 success:function(result){
					if(result.state==0){
						alert("修改成功！"); 	
						window.location.href ="notice.do";	
					}
				},
				error:function(){
					alert("修改失败！"); 
				}
			});	
		}
}
function loadModify(){
		var statementNoticeId = getCookie("id");
		$.ajax({
			url : "/admin/load_modify_notice.do",
			type : "post",
			data : {"id":statementNoticeId},
			dataType : "json",
			success:function(result){
				if (result.state == 0) {
					var StatementNotice = result.data;
					var snStatementTitle = StatementNotice.statementTitle;
					var snStatement = StatementNotice.statement;
					var snNotice = StatementNotice.notice;
					var note = StatementNotice.note;
					var notice_statementTitle=$("#notice_statementTitle").val(snStatementTitle);
					var notice_note=$("#notice_note").val(note);
					editor1.html(snStatement);
					editor2.html(snNotice);
				}
			},
			error:function(){
				alert("加载失败！"); 
			}
		});
}