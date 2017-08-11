$(function(){
	$(".add_btn").click(addNoticeBtn);
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

function addNoticeBtn(){
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
	/*var ok=true;
	if(notice_statementTitle==""){
		ok=false;
		$("#notice_statementTitle_ts").html("公告名称为空");	
	}
	if(notice_note==""){
		ok=false;
		$("#notice_note_ts").html("备注为空");	
	}
	if(s1==""){
		ok=false;
		$("#editor1_ts").html("公告内容为空");	
	}
	if(s2==""){
		ok=false;
		$("#editor2_ts").html("注意事项为空");	
	}*/
	
			$.ajax({
				url : "/admin/add_statementNotice.do",
				type : "post",
				data : {
					"statementTitle":notice_statementTitle,
					"statement":s1,
					"notice":s2,
					"note":notice_note
					},
				dataType : "json",
				success : function(result) {
					if(result.state==0){
						if(confirm("添加成功！是否继续添加？")){
							window.location.href ="noticeAdd.do";	
							return;
						}
						window.location.href ="notice.do";	
					}
				},
				error : function() {
					alert("添加失败!!!");
				}
			});
}