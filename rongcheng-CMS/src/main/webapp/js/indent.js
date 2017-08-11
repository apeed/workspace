//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
var orderType=1;
$(function(){
	loadIndent(1);
	//监听修改事件
	$("#indent_table").on("click",".modify_btn",modifyIndentPublic);
	//监听批量删除
	$(".indent_delList").off("click").on("click",DelSelect);
	//根据订单状态查询
	$("#fukuancit").change(fukuancit);
	//监听备注点击事件
	$("#indent_table").on("click",".indent_bz",indentBZ);
	//监听发货点击事件
	$("#indent_table").on("click",".indent_fh",indentFh);
	//监听下拉点击事件
	$("#indent_table").on("click",".laozi",laoZi);
	//监听退款点击事件
	$("#indent_table").on("click",".indent_tkcl",tkcl);
	//提交修改备注
	$("#indent_table").on("click",".sub_bz",sub);
	$("#indent_table").on("click",".sub_fh",sub1);
	//备注取消
	$("#indent_table").on("click",".indent_bz_qx",function(){
		$(".indent_bz_box").css("display","none"); 
	});
	//发货取消
	$("#indent_table").on("click",".indent_fh_qx",function(){
		$(".indent_fh_box").css("display","none"); 
	});
});

function sub() {
	var note = $("#tnote").val();
//	console.log(note);
	$(".indent_bz_box").css("display","none"); 
	$.ajax({
		url:"updateOrderInfo.do",
		type:"post",
		dataType:"json",
		data:{"id":id,
			  "note":note},
		 success:function(result){
			if(result.state==0){
				window.location.href="indent.do";
			}
		},
		error:function(){
			alert("提交失败！"); 
		}
	});
}
function sub1() {
	$(".indent_fh_box").css("display","none"); 
	var carrierId=$("#selCarrier").find("option:selected").val();
	var trackingNum=$("#trackNum").val();
	$.ajax({
	url:"updateOrderInfo1.do",
	type:"post",
	dataType:"json",
	data:{"id":id,
		  "carrierId":carrierId,
		  "trackingNum":trackingNum},
	 success:function(result){
		if(result.state==0){
			window.location.href="indent.do";
		}
	},
	error:function(){
		alert("提交失败！"); 
	}
});
}
function laoZi() {
	var $tr1=$(this).parent();
//	console.log($tr1.parent().children(".erzi").children());
	var $tr2=$(this).parent().next().children();
	if($tr2.length != 0){
		$(this).parent().next().children().remove();
		return;
	}
	var str="";
	var $tr=$(this).parent();
	var orderNum=$tr.data("orderNum");
	var id=$tr.data("oid");
	var totalShippingFee=$tr.data("totalShippingFee");
    	$(".erzi").css("display","block"); 
	$.ajax({
		url:"findOrderItemIds.do",
		type:"post",
		
		dataType:"json",
		data:{"orderId":orderNum},
		 success:function(result){
			if(result.state==0){
				 $tr1.parent().children(".erzi").children().remove();
				var list=result.data;
				//总金额
				var sum = 0;
				for (var i = 0; i < list.length; i++) {
					var orderItemId=list[i].orderItemId;
					var quantity=list[i].quantity;//数量
					$.ajax({
						url:"findItemInfoId.do",
						type:"post",
						async:false,
						dataType:"json",
						data:{"id":orderItemId},
						 success:function(result){
							if(result.state==0){
								var ItemInfo=result.data;
								 var itemSku=ItemInfo.itemSku;//编码
								 var iconUrl=ItemInfo.iconUrl;//缩略图
								 var itemName=ItemInfo.itemName;//名称
								 var normalPrice=ItemInfo.normalPrice;//单价
								 
								 var totalMoney=normalPrice*quantity;
								 sum += totalMoney;
//								console.log(itemSku+","+iconUrl+","+itemName);
								var str="";
								//商品信息
								str+='<ol class="indent_son_ol">';
								str+='<li><img src="'+iconUrl+'" alt="" width="60" height="40" /></li>';
								str+='<li>'+itemSku+'</li>';
								str+='<li>'+itemName+'</li>';
								str+='<li>'+normalPrice+'</li>';
								str+='<li>'+quantity+'</li>';
								str+='</ol>';
								$tr1.next().append(str);
							}
						},
						error:function(){
							alert("加载失败！"); 
						}
					});
				}
				var strs="";
				strs+='<ol class="indent_son_ol">';
				strs+='<li style="text-align:right;width: 50%;">总运费：<span>'+totalShippingFee+'</span></li>';
				strs+='<li style="text-align:right;width: 50%;padding-right: 50px;">订单总金额：<span>'+sum+'</span></li>';
				strs+='</ol>';
				$tr1.next().append(strs);
			}
		},
		error:function(){
			alert("加载失败！"); 
		}
	});
}
function tkcl() {
	var $tr=$(this).parent();
	var id=$tr.data("oid");
	$.ajax({
		url:"updateOrderInfo2.do",
		type:"post",
		dataType:"json",
		data:{"id":id},
		 success:function(result){
			if(result.state==0){
				alert("退款成功！"); 
				window.location.href="indent.do";
			}
		},
		error:function(){
			alert("提交失败！"); 
		}
	});
}
function indentBZ() {
	var $tr=$(this).parent();
	 id=$tr.data("oid");
	$(".indent_bz_box").css("display","block"); 
	$.ajax({
		url:"load_modify_orderInfo.do",
		type:"post",
		dataType:"json",
		data:{"id":id},
		 success:function(result){
			if(result.state==0){
				var OrderInfo=result.data;
				var note=OrderInfo.note;
				$("#note").val(note);
			}
		},
		error:function(){
			alert("加载失败！"); 
		}
	});
}
function indentFh() {
//	console.log("发货");
	var $tr=$(this).parent();
	id=$tr.data("oid");
	$(".indent_fh_box").css("display","block"); 
}
function fukuancit() {
	 orderType=$("#fukuancit").find("option:selected").val();
	$.ajax({
		url:"findListByOrderType.do",
		type:"post",
		dataType:"json",
		data:{"orderType":orderType},
		 success:function(result){
			if(result.state==0){
				var list=result.data;
				reload(list);
			}
		},
		error:function(){
			alert("查找订单失败！"); 
		}
	});
	if(orderType==""){
		loadIndent(1);
		 orderType=1;
	}
}
function DelSelect(){
	var id1 = new Array();
	var Checkbox=false;
	 $("input[name='id1']").each(function(){
		 id1.push($(this).val());
//		 console.log(id1);
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 
		$.ajax({
			url:"delOrderInfoList.do",
			type:"post",
			dataType:"json",
			data:$('#fm1').serialize(),
			 success:function(result){
				if(result.state==0){
					alert("批量删除成功！"); 	
					window.location.href="indent.do";
				}
			},
			error:function(){
				alert("批量删除失败！"); 
			}
		});
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
function modifyIndentPublic(){
	var $tr = $(this).parent();
	var id = $tr.data("oid");
	var orderNum=$tr.data("orderNum");
	addCookie("oid", id, 1);
	addCookie("orderNum", orderNum, 1);
}
function changesearch(){
	var keywords=$("#keywords").val().trim();
	$.ajax({
		url : "findListByOrderInfo.do",
		type : "post",
		data : {
			"keyword" : keywords
		},
		dataType : "json",
		success : function(result) {
			var list=result.data;
			reload(list);
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
}
function del(id) {
	if(confirm("您确定要删除吗?")){
		$.ajax({
			url:"delOrderInfo.do",
			type:"post",
			dataType:"json",
			data:{"id":id},
			 success:function(result){
				if(result.state==0){
					window.location.href="indent.do";
				}
			},
			error:function(){
				alert("删除失败！"); 
			}
		});   
    }
}

function loadIndent(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "loadList_indent.do",
		type : "post",
		data : {
			"page" : page
		},
		dataType : "json",
		success : function(result) {
			max_page = result.message;
			var list=result.data;
			reload(list);
			
		},
		error : function() {
			alert("加载失败!!!");
		}
	});
	}
function reload(list) {
	var indentTable = $("#indent_table");
	indentTable.empty();
	var sa="";
	sa+='<ol class="indent_ol">';
	sa+='<li>序号</li>';
	sa+='<li>订单号</li>';
	sa+='<li>收件人</li>';
	sa+='<li>电话</li>';
	sa+='<li>地址</li>';
	sa+='<li>备注</li>';
	sa+='<li>物流公司</li>';
	sa+='<li>物流单号</li>';
	sa+='<li width="">操作</li>';
	sa+='</ol>';
	$("#indent_table").append(sa);
//	console.log(list.length);
	for(var i=0;i<list.length;i++){
		var OrderInfo = list[i];
//		console.log(OrderInfo);
		var id = OrderInfo.id;
		var orderNum = OrderInfo.orderNum;
		var consigneeId = OrderInfo.consigneeId;
		var consigneeTel = OrderInfo.consigneeTel;
		var consigneeAddress = OrderInfo.consigneeAddress;
		var note = OrderInfo.note;
		var carrierId = OrderInfo.carrierId;
		var trackingNum = OrderInfo.trackingNum;
		var totalShippingFee = OrderInfo.totalShippingFee;
		var refundApply = OrderInfo.refundApply;
		var orderClosed = OrderInfo.orderClosed;
//		console.log(id+","+orderNum+" "+consigneeId+" "+consigneeTel+" "+consigneeAddress+" "+note+" "+carrierId+" "+trackingNum);
		var str="";
		str+='<ol class="indent_ol indentOL">';
		str+='<li><input type="checkbox" name="id1" value="'+id+'" />'+id+'</li>';
		str+='<li>'+orderNum+'</li>';
		str+='<li>'+consigneeId+'</li>';
		str+='<li>'+consigneeTel+'</li>';
		str+='<li>'+consigneeAddress+'</li>';
		str+='<li>'+note+'</li>';
		str+='<li>'+carrierId+'</li>';
		str+='<li>'+trackingNum+'</li>';
//		console.log(orderType);
		str+='<li>';
	//备注
		str+='<div class="indent_bz_box" style="display:none;">';
		str+='<div class="panel admin-panel">';
		str+='<div class="body-content" style="padding-bottom:0;">';
		str+='<div class="form-x">';
		str+='<div class="form-group">';
		str+='<div class="label" style="width:100px;">';
		str+='<label>备注：</label>';
		str+='</div>';
		str+='<div class="field tsnote" style="width:390px;">';
		str+='<textarea class="input"  name="note" id="tnote" value="" style=" height:90px;width:100%"></textarea>';
		str+='<div class="tips"></div>';
		str+='</div>';
		str+='</div>';
		str+='<div class="form-group">';
		str+='<div class="label" style="width:100px;">';
		str+='</div>';
		str+='<div class="field" style="width:390px;">';
		str+='<button  type="button" class="button border-main icon-check-square-o sub_bz"> 提交</button>';
		str+='<button  type="button" class="button border-red icon-check-square-o indent_bz_qx"> 取消</button>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</li>';
	//发货	
		str+='<li>';
		str+='<div class="indent_fh_box" style="display:none;">';
		str+='<div class="panel admin-panel">';
		str+='<div class="body-content" style="padding-bottom:0;">';
		str+='<div class="form-x">';
		str+='<div class="form-group">';
		str+='<div class="label" style="width:100px;">';
		str+='<label>快递公司：</label>';
		str+='</div>';
		str+='<div class="field" style="width:390px;">';
		str+='<select id="selCarrier" name="twocid" class="input" style="width: 100%">';
		str+='<option value="顺丰">顺丰</option>';
		str+='<option value="中通">中通</option>';
		str+='<option value="申通">申通</option>';
		str+='<option value="圆通">圆通</option>';
		str+='<option value="韵达">韵达</option>';
		str+='<option value="EMS">EMS</option>';
		str+='<option value="汇通">汇通</option>';
		str+='<option value="宅急送">宅急送</option>';
		str+='<option value="京东快递">京东快递</option>';
		str+='<option value="天天快递">天天快递</option>';
		str+='<option value="德邦快递">德邦快递</option>';
		str+='<option value="德邦物流">德邦物流</option>';
		str+='<option value="邮政小包">邮政小包</option>';
		str+='<option value="EMS经济快递">EMS经济快递</option>';
		str+='<option value="百世物流">百世物流</option>';
		str+='<option value="龙邦">龙邦</option>';
		str+='<option value="速尔">速尔</option>';
		str+='<option value="全峰">全峰</option>';
		str+='<option value="国通">国通</option>';
		str+='<option value="快捷快递">快捷快递</option>';
		str+='<option value="优速">优速</option>';
		str+='<option value="中国邮政">中国邮政</option>';
		str+='<option value="安能物流">安能物流</option>';
		str+='<option value="佳龙快运">佳龙快运</option>';
		str+='</select>';
		str+='<div class="tips"></div>';
		str+='</div>';
		str+='</div>';
		str+='<div class="form-group">';
		str+='<div class="label" style="width:100px;">';
		str+='<label>快递单号：</label>';
		str+='</div>';
		str+='<div class="field" style="width:390px;">';
		str+='<input type="text" id="trackNum" class="input" value="" style="width:100%"/>';
		str+='<div class="tips"></div>';
		str+='</div>';
		str+='</div>';
		str+='<div class="form-group">';
		str+='<div class="label" style="width:100px;">';
		str+='</div>';
		str+='<div class="field" style="width:390px;">';
		str+='<button type="button" class="button border-main icon-check-square-o sub_fh"> 发货</button>';
		str+='<button type="button" class="button border-red icon-check-square-o indent_fh_qx"> 取消</button>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</div>';
		str+='</li>';
	
		if(orderType==1){
			str+='<a class="button border-main indent_xg modify_btn" href="indentPublic.do"><span class="icon-edit"></span> 修改</a>';
			str+='<a class="button border-red indent_del_button" href="javascript:;" onclick="return del('+id+')"><span class="icon-trash-o"></span> 删除</a>';
			str+='<a class="button border-black laozi"  href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';	
		}
		if(orderType==2){
			str+='<span class="button border-main indent_fh" style="cursor: pointer;"><span class="icon-edit"></span> 发货</span>';
			str+='<a class="button border-main indent_xg modify_btn" href="indentPublic.do"><span class="icon-edit"></span> 修改</a>';
			str+='<a class="button border-black laozi"  href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';
		}
		if(orderType==3){
			str+='<span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>';
			str+='<a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';
		}
		if(orderType==4){
			str+='<span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>';
			str+='<a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';	
		}
		if(orderType==5){
			str+='<a href="javascript:;" class="button border-main indent_tkcl"><span class="icon-edit"></span> 退款处理</a>';
			str+='<span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>';
			str+='<a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';
		}
		if(orderType==6){
			str+='<span class="button border-main indent_bz" style="cursor: pointer;"><span class="icon-edit"></span> 备注</span>';
			str+='<a class="button border-black laozi" href="javascript:void(0)"><span class="icon-chevron-down"></span>下拉</a>';
		}
		str+='</ol>';
//		console.log(itemSku);
		str+='<div class="erzi" style="display:none;">';
		str+='</div>';
		//转jquery对象
		var $tr=$(str);
		//把id加到 这条数据上
		$tr.data("oid",id);
		$tr.data("orderNum",orderNum);
		$tr.data("totalShippingFee",totalShippingFee);
		$("#indent_table").append($tr);
	}
	
	/////页码////////////
	var trs="";
	trs += '<li><div class="pagelist"><a onclick="loadIndent(1)" href="javascript:;" >首页</a><a class="bookpage" onclick="loadIndent('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadIndent('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadIndent('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadIndent(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadIndent(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadIndent('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadIndent('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadIndent('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadIndent('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadIndent('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadIndent('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadIndent('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadIndent('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadIndent('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadIndent('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadIndent('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadIndent('+max_page+')">尾页</a></div>';
	trs += '</li>';
	$("#indent_table").append(trs);
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}
	
		