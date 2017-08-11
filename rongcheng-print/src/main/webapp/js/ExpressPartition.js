//全局变量 最大页数
var max_page=1;
//全局变量 当前页数
var now_page=1;
//var regionAreaId1;
var carrierId3; 
var regionCityName;
var regionCityName1;
var regionAreaName;
var regionAreaName1;
$(function(){
	loadRegion(1);
	//地区下拉（无街道）
    $('#addrDiv').citys({
        required:false,
        nodata:'disabled',
        onChange:function(data){
            var text = data['direct']?'(直辖市)':'';
            $('#place').text('当前选中地区：'+text+' '+data['city']+' '+data['area']);
//            storeInfo_userAddress=(data['city']+","+data['area']); 
            regionCityCode = $("#city").find("option:selected").val();	
            regionAreaCode = $("#area").find("option:selected").val();
//            console.log(regionAreaCode);
        }
    });
	$("#region_table").on("click",".shade_button",addRegion);
	$("#region_table").on("click","#ddm li",clickUl);
	$("#region_table").on("click","#ulList li",clickUlTwo);
	$("#region_table").on("click",".xz_mb",optionMod);
	$(".modifyArea_btn").click(modifyArea);
	$("#carrier_name").change(function(){//选择模板
		 carrierId3 = $("#carrier_name").find("option:selected").val();
//		 console.log(carrierId3);
		 var optionstr2="";
			optionstr2+='<option value="qingxuanze">请选择</option>';
			$("#select_mod").append(optionstr2);
			$.ajax({//
				url : "findtemplateId.do",
				type : "post",
				data : {"carrierId":carrierId3},
				dataType : "json",
				success:function(result){
					if (result.state == 0) {
						var list = result.data;
						var optionModTable = $("#select_mod");
						optionModTable.empty();	
						for(var i=0; i<list.length; i++){
							var PrintTemplate = list[i];
							var templateName = PrintTemplate.templateName;//模板名称
							var id = PrintTemplate.id;
							optionstr2+='<option name="" value="'+ id +'">'+ templateName +'</option>';
							}
						$("#select_mod").append(optionstr2);
							}
							},
							error:function(){
								alert("失败了！")
							}
						});
			
					});
	$("#select_mod").change(function(){
		id = $("#select_mod").find("option:selected").val();
	});
	$(".mod2").click(mod2);
});
//单个删除
function delM(acaRegionAreaCode){
	if(confirm("您确定要删除吗?")){
		  $.ajax({
				url : "modifyRegionArea1.do",
				type : "post",
				data : {
					"regionCode" : acaRegionAreaCode,
					"carrierId" : "",
					"reserved1" : ""
				},
				dataType : "json",
				success : function(result) {
					if (result.state == 0) {
						alert("删除成功!!!");
						window.location.href="ExpressPartition.do";
					}
				},
				error : function() {
					alert("删除失败!!!");
				}
			});
	  }
}
function del(regionCode){//删除子级
	 var substr4=(regionCode+"").substring(0,2);
	 var substr5=(regionCode+"").substring((regionCode+"").length-2,(regionCode+"").length+1);
$.ajax({
		url : "modifyRegionArea3.do",
		type : "post",
		data : {
			"i" : substr4,
			"j" : substr5,
			"carrierId" : ""
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0) {
				alert("删除成功!");
				window.location.href="ExpressPartition.do";
			}
		},
		error : function() {
			alert("删除失败!");
		}
	});
}
function optionMod(){
	var $tr=$(this).parent().parent();
	regionCode1=$tr.attr("regionCode");
	$(".express_box").css("display","block");
//	console.log(regionCarrierId);
		$.ajax({//
		url : "findtemplateId.do",
		type : "post",
		async : false, 
		data : {"carrierId":regionCarrierId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var list = result.data;
				var mp="";
				mp+='<li>';
				mp+='<span style="padding-left: 50px;">名称</span><span>类型</span>';
				mp+='</li>';
				$(".mod_print").append(mp);
				for(var i=0; i<list.length; i++){
					var PrintTemplate = list[i];
					var templateName = PrintTemplate.templateName;//模板名称
					var templateType = PrintTemplate.templateType;
					var id = PrintTemplate.id;
					var mp1="";
					mp1+='<li id="ul" value="">';
						if(templateType==7){
							mp1+='<span><input type="radio" name="oneprint" checked="true">'+templateName+'</span><span id="exp_templateType" value="">普通</span>';
						}else if(templateType==8){
							mp1+='<span><input type="radio" name="oneprint">'+templateName+'</span><span id="exp_templateType" value="">热敏</span>';
						}else if(templateType==9){
							mp1+='<span><input type="radio" name="oneprint">'+templateName+'</span><span id="exp_templateType" value="">菜鸟</span>';
						}
						mp1+='</li>';
						$mp1 = $(mp1);
						$mp1.data("id",id);
						$(".mod_print").append($mp1);
						/*console.log($mp1.data("id"));*/
//						var $tr=$("#exp_templateName");
//						$tr.attr("id",id);
					}
					}
					},
					error:function(){
						alert("失败了！")
					}
				});
}
function mod2(){
	var tempA = $("input[name='oneprint']:checked");
	var printTemplateId=tempA.parent().parent().data("id");
//	console.log(regionId1+","+printTemplateId);
	 $.ajax({
			url : "modifyRegionArea2.do",
			type : "post",
			async : false, 
			data : {
				"regionCode" : regionCode1,
				"reserved1" : printTemplateId
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("修改成功!");
				}
			},
			error : function() {
				alert("修改失败!");
			}
		});
}
function clickUl(){
	var $tr = $(this).parent().parent().parent().parent().parent();
	var regionCode2=$tr.attr("regionCode");
	var carrierId1=$(this).val();//li的value
//	console.log(regionCode2+","+carrierId1);
		$.ajax({
			url : "modifyProvince.do",
			type : "post",
			async : false, 
			data : {"regionCode":regionCode2,
				"carrierId":carrierId1},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					window.location.href="ExpressPartition.do";
				}
			},
			error : function() {
				alert("物流修改失败!!!");
			}
		});
}
//批量修改操作
function clickUlTwo(){
	var carrierId2=$(this).attr("value");
//	alert($("#sort").length);
	if($("#sort").length>0){
	$("#sort").remove();
	}
	var inputTag = document.createElement('input'); 
    inputTag.setAttribute("type", "hidden");
    inputTag.setAttribute("id", "sort");
    inputTag.setAttribute("name", "sort"); 
    inputTag.setAttribute("value", carrierId2); 
	$("#fm1").append(inputTag);
//	alert("快递公司"+carrierId2);
//	console.log(rc1+","+carrierId2); 
	if(confirm("您确定要修改吗？请稍等...")){
		$.ajax({
			url : "modify_regions.do",
			type : "post",
			async : false,
			data : $('#fm1').serialize(),
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					alert("批量修改成功!!!");
					window.location.href="ExpressPartition.do";
				}
			},
			error : function() {
				alert("批量修改失败!!!");
			}
		});
	}
}

function modifyArea(){
	
	regionCityCode1=(regionCityCode+"").substring(0,4);
//	console.log(regionCityCode1+"--"+carrierId3+"--"+id);
	if(regionAreaCode==""){//例外1：改市
		$.ajax({
				url : "modify_regionList.do",
				type : "post",
				async : false,
				data : {"regionCode":regionCityCode1,"carrierId":carrierId3,"reserved1":id},
				dataType : "json",
				success : function(result){
					if (result.state == 0) {
					alert("市保存成功");
					}
			},
			error:function(){
				alert("市保存失败");
			}
		});
		return;
	}
	var substr6=(regionAreaCode+"").substring(0,4);
//	console.log(substr7);
	var code=getCookie("regionCode");
	if(code==110000 || code==120000 || code==310000 || code==500000){
	$.ajax({
		url : "modifyRegionCity1.do",
		type : "post",
		async : false,
		data : {"i":substr6,
				"j":"00",	
				"carrierId":carrierId3,
				"reserved1":id},
		dataType : "json",
		success : function(result){
			if (result.state == 0) {
			}
	},
	error:function(){
		alert("市保存失败");
	}
});
	}else{
		$.ajax({//修改市2>
			url : "modifyRegionCity.do",
			type : "post",
			async : false,
			data : {"regionCode":regionCityCode,
				"carrierId":carrierId3,
				"reserved1":id},
			dataType : "json",
 			success : function(result){
				if (result.state == 0) {
				}
		},
		error:function(){
			alert("保存失败");
		}
	});
	}
	
//	if(carrierId3!=regionCarrierId){
	
		/*$.ajax({//修改市1>
			url : "modifyRegionCity.do",
			type : "post",
			async : false,
			data : {"regionCode":code,
				"carrierId":carrierId3,
				"reserved1":id},
			dataType : "json",
			success : function(result){
				if (result.state == 0) {
				}
		},
		error:function(){
			alert("保存失败");
		}
	});*/
		
		$.ajax({//修改区
			url : "modifyRegionArea.do",
			type : "post",
			async : false,
			data : {"regionCode":regionAreaCode,
				"carrierId":carrierId3,
				"reserved1":id},
			dataType : "json",
			success : function(result){
				if (result.state == 0) {
				alert("保存成功！");
				}
		},
		error:function(){
			alert("保存失败");
		}
	});		
	
		
		
}
function addRegion(){
	var $tr = $(this).parent().parent();
	var regionAddCode=$tr.attr("regionCode");
	 addCookie("regionCode", regionAddCode);
	
//	console.log(regionAddCode);
	$(".shade_wai").css("display","block");
	$('#addrDiv').citys({
        code:regionAddCode,
	    required:false,
	    nodata:'disabled',
	    onChange:function(data){
	        var text = data['direct']?'(直辖市)':'';
	        $('#place').text('当前选中地区：'+text+' '+data['city']+' '+data['area']);
	    }
	});
	
}
function selectAll(){
	$("input[name='rc1']").each(function(){  
		if (this.checked) {
		      this.checked = false;
		    }else {
			      this.checked = true;
		    }
	});
}

function loadRegion(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "loadList_region.do",
		type : "post",
		async : false,
		data : {
			"page" : page,
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
	var regionTable = $("#region_table");
	regionTable.empty();
	var sa="";
	sa+='<li>';
	sa+='<div>地区</div>';
	sa+='<div>默认物流</div>';
	sa+='<div>例外</div>';
	sa+='<div>快递模板选择</div>';
	sa+='</li>';
	$("#region_table").append(sa);
	for(var i=0; i<list.length; i++){
		var Region = list[i];
		 regionId = Region.regionId;
		 regionCode=Region.regionCode;
		
//		 console.log(regionCode+"我");
		var regionName = Region.regionName;
		 regionCarrierId=Region.carrierId;
		 regionReserved1=Region.reserved1;
	 	 substr1=(regionCode+"").substring(0,2);
		 substr2=(regionCode+"").substring((regionCode+"").length-2,(regionCode+"").length+1);
//		console.log(regionName+","+regionCarrierId+","+regionReserved1);
		$.ajax({//显示快递公司
		url : "find_CarrierInfoName.do",
		type : "post",
		async : false, 
		data : {
			"carrierId" : regionCarrierId
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0) {
				var CarrierInfo=result.data;
				carrierName1=CarrierInfo.carrierName;
//				console.log(carrierName);
			}
		},
		error : function() {
			alert("查找失败!!!");
		}
	});
//		console.log(regionReserved1);
		$.ajax({
			url : "findtemplateName.do",
			type : "post",
			async : false, 
			data : {"id":regionReserved1},
			dataType : "json",
			success : function(result){
				if (result.state == 0) {
				var PrintTemplate=result.data;	
				 ptTemplateName2=PrintTemplate.templateName;
//				 console.log(ptTemplateName2);
				}
		},
		error:function(){
			alert("失败");
		}
	});
		var str="";
		str+='<li>';
		str+='<div width="160"><input type="checkbox" name="rc1" value="'+regionCode+'" />';
		str+=regionName;
		str+='</div>';
		str+='<div>';
		str+='<div class="button-group">';
		str+='<div class="button border-main xialaBtn">';
		str+='<span class="icon-plus"></span>';
		str+=carrierName1;
		str+='<ul id="ddm">';
		str+='<li value="1">顺丰</li>';
		str+='<li value="2">中通</li>';
		str+='<li value="3">申通</li>';
		str+='<li value="4">圆通</li>';
		str+='<li value="5">韵达</li>';
		str+='<li value="6">EMS</li>';
		str+='<li value="7">汇通</li>';
		str+='<li value="8">宅急送</li>';
		str+='<li value="9">京东快递</li>';
		str+='<li value="10">天天快递</li>';
		str+='<li value="11">德邦快递</li>';
		str+='<li value="12">德邦物流</li>';
		str+='<li value="13">邮政小包</li>';
		str+='<li value="14">EMS经济快递</li>';
		str+='<li value="15">百世物流</li>';
		str+='<li value="16">龙邦</li>';
		str+='<li value="17">速尔</li>';
		str+='<li value="18">全峰</li>';
		str+='<li value="19">国通</li>';
		str+='<li value="20">快捷快递</li>';
		str+='<li value="21">优速</li>';
		str+='<li value="22">中国邮政</li>';
		str+='<li value="23">安能物流</li>';
		str+='<li value="24">佳龙快运</li>';
		str+='</ul>';  
		str+='</div>';
		str+='<a class="button border-red"  onclick="del('+regionCode+')"><span class="icon-trash-o"></span> 删除</a>';
		str+='</div>';
		str+='</div>';
		str+='<div><a class="button border-green shade_button"><span class="icon-plus"></span> 添加</a></div>';
		str+='<div>';
		str+='<a class="button border-green xz_mb"><span class="icon-plus"></span> 选择</a>';
		str+='<span>'+ptTemplateName2+'</span>';
		str+='</div>';
//		 console.log(substr1+'--'+substr2+"--"+regionCarrierId);
		var carrier = ["顺丰","中通","申通","圆通","韵达","EMS","汇通","宅急送","京东快递","天天快递","德邦快递","德邦物流","邮政小包","EMS经济快递","百世物流","龙邦","速尔","全峰","国通","快捷快递","优速","中国邮政","安能物流","佳龙快运"];	
//		console.log(substr1+","+substr2+","+regionCarrierId);
		
		$.ajax({//1.加载市
			url : "findAddressCarrierAllocation.do",
			type : "post",
			async : false,
			data : {
				"i":substr1,
				"j":substr2,
				"carrierId" : regionCarrierId
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var list1=result.data;
//					console.log(list1.length);
					for(var j=0; j<list1.length; j++){
						 
						var AddressCarrierAllocation = list1[j];
						var acaRegionCityName=AddressCarrierAllocation.regionName;
					    var acaRegionCityCode=AddressCarrierAllocation.regionCode;
					    var acaRegionCityCarrierId=AddressCarrierAllocation.carrierId;
					   var substr3=(acaRegionCityCode+"").substring(0,4);
//					    console.log(regionCarrierId);
					    $.ajax({//2.加载区
							url : "findAddressCarrierAllocationArea.do",
							type : "post",
							async : false,
							data : {
								"i":substr3,
								"carrierId" : acaRegionCityCarrierId
							},
							dataType : "json",
							success : function(result) {
								if (result.state == 0) {
									var list2=result.data;
//									console.log(list2.length);
//									console.log(list2);
									for(var k=0; k<list2.length; k++){
										var AddressCarrierAllocation1 = list2[k];
											var acaRegionAreaName=AddressCarrierAllocation1.regionName;
											var acaRegionAreaCode=AddressCarrierAllocation1.regionCode;
//											console.log(acaRegionAreaCode);
											
											$.ajax({//3.加载快递
											url : "findByRegionCode.do",
											type : "post",
											async : false,
											data : {
												"regionCode" : acaRegionAreaCode
											},
											dataType : "json",
											success : function(result) {
												if (result.state == 0) {
												
													var AddressCarrierAllocation2=result.data;
													 acaCarrierId=AddressCarrierAllocation2.carrierId;
													var acaReserved1=AddressCarrierAllocation2.reserved1;
//													 	console.log(acaCarrierId+","+acaReserved1);
														 $.ajax({//4.查区的reserved1,存的是模板id
																url : "findtemplateName.do",
																type : "post",
																async : false,
																data : {"id":acaReserved1},
																dataType : "json",
																success : function(result){
																	if (result.state == 0) {
//																	console.log(66);
																	var PrintTemplate=result.data;	
																	ptTemplateName=PrintTemplate.templateName;
																	
																	}
															},
															error:function(){
																alert("查找失败");
															}
														});
														 
												}
											},
											error : function() {
												alert("查找快递失败!!!");
											}
										});
	//四个同时锁定，性能有待优化					
//											console.log(acaRegionCityName,acaRegionAreaName,carrier[acaCarrierId-1],ptTemplateName);
											str+='<ol>';
											str+='<li>例外情况:</li>';
											str+='<li>';
											str+=acaRegionCityName;
											str+='</li>';	
											str+='<li>';
											str+=acaRegionAreaName;
											str+='</li>';
											str+='<li>';
											str+=carrier[acaCarrierId-1];
											str+='</li>';
											str+='<li>';
											str+=ptTemplateName;
											str+='</li>';
											str+='<li>';
											str+='<a style="color: red;border:1px solid #f00;border-radius: 3px;padding:2px 10px;" href="javascript:;" onclick="delM('+acaRegionAreaCode+')"><span class="icon-trash-o"></span> 删除</a>';
											str+='</li>';
											str+='</ol>';		
									}
								}
							},
							error : function() {
								alert("查找地区失败!!!");
							}
						});
	//-----------				    
					}
				}
			},
			error : function() {
				alert("查找城市失败!!!");
			}
		});
						
		str+='</li>';
		//转jquery对象
		var $tr=$(str);
		//把id加到 这条数据上
//		$tr.attr("regionId",regionId);	
		$tr.attr("regionCode",regionCode);
		//最后加到table上
		$("#region_table").append($tr);
		
	}

	var sdr="";
	sdr+='<li>';   
	sdr+='<div width="160"><input type="checkbox" id="checkall" onclick="selectAll()" value=""/>';  
	sdr+='全选 </div>';  
	sdr+='<div colspan="7" style="text-align:left;padding-left:20px;">';  
	sdr+='<div class="button border-main xialaBtn" style="margin-left: 80px;">';  
	sdr+='<span class="icon-plus"></span> 批量选择快递';  
	sdr+='<ul id="ulList">';  
	sdr+='<li value="1">顺丰</li>';
	sdr+='<li value="2">中通</li>';
	sdr+='<li value="3">申通</li>';
	sdr+='<li value="4">圆通</li>';
	sdr+='<li value="5">韵达</li>';
	sdr+='<li value="6">EMS</li>';
	sdr+='<li value="7">汇通</li>';
	sdr+='<li value="8">宅急送</li>';
	sdr+='<li value="9">京东快递</li>';
	sdr+='<li value="10">天天快递</li>';
	sdr+='<li value="11">德邦快递</li>';
	sdr+='<li value="12">德邦物流</li>';
	sdr+='<li value="13">邮政小包</li>';
	sdr+='<li value="14">EMS经济快递</li>';
	sdr+='<li value="15">百世物流</li>';
	sdr+='<li value="16">龙邦</li>';
	sdr+='<li value="17">速尔</li>';
	sdr+='<li value="18">全峰</li>';
	sdr+='<li value="19">国通</li>';
	sdr+='<li value="20">快捷快递</li>';
	sdr+='<li value="21">优速</li>';
	sdr+='<li value="22">中国邮政</li>';
	sdr+='<li value="23">安能物流</li>';
	sdr+='<li value="24">佳龙快运</li>';
	sdr+='</ul>';  
	sdr+='</div>';
	sdr+='</div>';  
	sdr+='</li>';  
	$("#region_table").append(sdr);
	/////页码////////////
	var trs="";
	trs += '<li>';
	trs += '<p class="pagelist"><a class="current" onclick="loadRegion(1)" href="javascript:;">首页</a><a class="bookpage" onclick="loadRegion('+(now_page-1)+')" href="javascript:;">上一页</a>';
	if(max_page>5){
		if(now_page<=3){
			for(var i=1;i<4;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadRegion('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadRegion('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			trs += '<a class="bookpage" onclick="loadRegion(4)" href="javascript:;">4</a><a class = "bookpage" onclick="loadRegion(5)" href="javascript:;">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			trs += '...<a class="bookpage" onclick="loadRegion('+(now_page-2)+')" href="javascript:;">'+(now_page-2)+'</a><a class="bookpage" onclick="loadRegion('+(now_page-1)+')" href="javascript:;">'+(now_page-1)+'</a>';
			trs += '<span class="bookpage">'+now_page+'</span>';
			trs += '<a class = "bookpage" onclick="loadRegion('+(now_page+1)+')" href="javascript:;">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadRegion('+(now_page+2)+')" href="javascript:;">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			trs += '...<a class="bookpage" onclick="loadRegion('+(max_page-4)+')" href="javascript:;">'+(max_page-4)+'</a><a class="bookpage" onclick="loadRegion('+(max_page-3)+')" href="javascript:;">'+(max_page-3)+'</a>';
			for(var i=max_page-2;i<=max_page;i++){
				if(i==now_page){
					trs += '<span class="bookpage" onclick="loadRegion('+i+')">'+i+'</span>';
				}else{
					trs += '<a class="bookpage" onclick="loadRegion('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==now_page){
				trs += '<span class="bookpage" onclick="loadRegion('+i+')">'+i+'</span>';
			}else{
				trs += '<a class = "bookpage" onclick="loadRegion('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	trs += '<a class="bookpage" onclick="loadRegion('+(now_page+1)+')">下一页</a><a class="bookpage" onclick="loadRegion('+max_page+')">尾页</a></p>';
	trs += '</li>';
	$("#region_table").append(trs);
	$(".bookpage:contains('"+now_page+"')").addClass("current");
	}
	//////////////////////////
/*$.ajax({
url : path+"/mod_reserved1.do",
type : "post",
data : {
	"regionId" : id1,
	"reserved1":regionCityName1+"->"+regionAreaName1+"->"+carrierName3
},
dataType : "json",
success : function(result) {
	$("#inVal").val(regionCityName1+"->"+regionAreaName1+"->"+carrierName3);
},
error : function() {
}
});
$.ajax({//显示快递公司
url : path+"/find_CarrierInfoName.do",
type : "post",
async : false, 
data : {
	"carrierId" : regionCarrierId
},
dataType : "json",
success : function(result) {
	if (result.state == 0) {
		var CarrierInfo=result.data;
		carrierName=CarrierInfo.carrierName;
	}
},
error : function() {
	alert("查找失败!!!");
}
});*/
