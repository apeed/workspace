$(function(){
	$(".reviewAdd_btn").click(reviewAddbtn);
	loadSome();
	$("input[name='itemSku_input']").keyup(fun);//监听键盘事件
	$("input[name='accountNum_input']").keyup(fun1);
	$("#review_itemSku").on("click","li",clickUl);//监听选择编码事件
	$("#review_accountNum").on("click","li",clickTwo);
});
function clickUl() {
	$("input[name='itemSku_input']").val($(this).html());
	$(this).parent().css("display","none");
	 sn=$(this).val();
	
}
function clickTwo() {
	$("input[name='accountNum_input']").val($(this).html());
	$(this).parent().css("display","none");
	var an=$(this).html();
	 an1=$(this).val();
	
	$.ajax({
		url : "findByAccountNum.do",
		type : "post",
		data : {"accountNum":an},
		dataType : "json",
		success : function(result) {
			if(result.state==0){
				var UserInfo=result.data;
				var userName=UserInfo.userName;
				var userTelephone=UserInfo.userTelephone;
				var accountEmail=UserInfo.accountEmail;
//				console.log(userName+","+userTelephone+","+accountEmail);
				$("#review_userName").val(userName);
				$("#review_userTel").val(userTelephone);
				$("#review_accountEmail").val(accountEmail);
			}
		},
		error : function() {
			alert("失败!");
		}
	});
	
}
function fun() {
	$(this).next().css("display","block");
	var keywords=$("input[name='itemSku_input']").val().trim();
	var str="";
	$.ajax({
		url : "/admin/item/getItemSku.do",
		type : "post",
		data : {"keyword":keywords},
		dataType : "json",
		success : function(result) {
			if(result.state==0){
				var list=result.data;
				var reviewItemSku = $("#review_itemSku");
				reviewItemSku.empty();
				for (var i = 0; i < list.length; i++) {
					var id=list[i].id;
					var itemSku=list[i].itemSku;
					str+='<li value="'+id+'">'+itemSku+'</li>';
//					var $tr=$(str);
//					$tr.attr("id",id);
				}
				$("#review_itemSku").append(str);
			}
		},
		error : function() {
			alert("失败!");
		}
	});
}
function fun1() {
	$(this).next().css("display","block");
	var keywords=$("input[name='accountNum_input']").val().trim();
	var str="";
	$.ajax({
		url : "getAccountNum.do",
		type : "post",
		data : {"keyword":keywords},
		dataType : "json",
		success : function(result) {
			if(result.state==0){
				var list=result.data;
				var reviewAccountNum = $("#review_accountNum");
				reviewAccountNum.empty();
				for (var i = 0; i < list.length; i++) {
					var accountNum=list[i].accountNum;
					var id=list[i].id;
					str+='<li value="'+id+'">'+accountNum+'</li>';
				}
				$("#review_accountNum").append(str);
			}
		},
		error : function() {
			alert("失败!");
		}
	});
}
function loadSome() {
	var strs="";
	strs+='<input type="text" class="input" value="" name="itemSku_input" placeholder="输入编号搜索"/>';
	strs+='<ul class="search_xiala_box" id="review_itemSku">';
	strs+='</ul>';
	$("#itemSku_div").append(strs);
	var st="";
	st+='<input type="text" class="input" value="" name="accountNum_input"  placeholder="输入账户搜索"/>';
	st+='<ul class="search_xiala_box" id="review_accountNum">';
	st+='</ul>';
	$("#accountNum_div").append(st);
}

function reviewAddbtn(){
	var review_itemSku=$("input[name='itemSku_input']").val();
	var review_userAccount=$("input[name='accountNum_input']").val();
	var review_userWord=$("#review_userWord").val();
	var review_userSequence=$("#review_userSequence").val();
	var review_remarkType = $("#twocid").find("option:selected").val();
	var review_show=$("input[name='qt']:checked").val();
	var review_note=$("#review_note").val();
	var ok=true;
	if(review_itemSku==""){
		ok=false;
	}
	if(/[^\d]/.test(review_itemSku)){
		ok=false;
	}
	if(review_userAccount==""){
		ok=false;
	}
	/*if(review_userName==""){
		ok=false;
		$("#review_userName_ts").html("客户姓名为空");
	}else{
		$("#review_userName_ts").html("");
	}
	if(review_userTel==""){
		ok=false;
		$("#review_userTel_ts").html("客户电话为空");
	}else if(!/^0\d{2,3}-?\d{7,8}$/.test(review_userTel)){
		ok=false;
		$("#review_userTel_ts").html("请按客户电话格式输入！");
	}else{
		$("#review_userTel_ts").html("");
	}
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	if(review_userEmail==""){
		ok=false;
		$("#review_userEmail_ts").html("客户邮箱为空");
	}else if(!re.test(review_userEmail)){
		ok=false;
		$("#review_userEmail_ts").html("请输入正确 客户邮箱格式！");
	}else if(review_userEmail.length>10){
		ok=false;
		$("#review_userEmail_ts").html("邮箱长度不超过10个字符！");
	}else{
		$("#review_userEmail_ts").html("");
	}*/
	if(review_userWord==""){
		ok=false;
		$("#review_userWord_ts").html("评论内容为空");
	}else{
		$("#review_userWord_ts").html("");
	}
	/*if(review_userSequence==""){
		ok=false;
		$("#review_userSequence_ts").html("排序为空");
		//如果排序不是数字
	}else if (isNaN(review_userSequence)) {
		$("#review_userSequence_ts").html("排序内格式输入错误，必须为数字。");
		ok=false;
	//如果排序不是正整数
	} else if (!/^\d+$/.test(review_userSequence)) {
		$("#review_userSequence_ts").html("排序内格式输入错误，必须为正整数。");
		ok=false;
	}else{
		$("#review_userSequence_ts").html("");	
	}*/
	if(review_show==null){
		ok=false;
		$("#review_show_ts").html("是否显示为空");
	}else{
		$("#review_show_ts").html("");
	}
	if(review_note==""){
		$("#review_note_ts").html("备注为空");
	}else{
		$("#review_note_ts").html("");
	}
	if(ok){
			$.ajax({
				url : "addUserRemark.do",
				type : "post",
				data : {
					"contentType":4,
					"contentId":sn,
					"userAccount":review_userAccount,
					"userId":an1,
					"userWord":review_userWord,
					"userSequence":review_userSequence,
					"remarkType":review_remarkType,
					"show":review_show,
					"note":review_note,
					},
				dataType : "json",
				success : function(result) {
					if(result.state==0){
						alert("添加评论成功！");
							window.location.href ="review.do";	
					}
				},
				error : function() {
					alert("添加失败!!!");
				}
			});
		}
}