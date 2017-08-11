var some_class=$(".some_class");
some_class.change(function(){
	var num=some_class.val();
	var newnum=num.split('/');
	var zhnum=newnum.join('-');
	some_class.val(zhnum)
})


/* 下边的代码是用来执行物流添加和修改页面的转运公司名称下拉框
*里边新建了flag开关，初始值是true;
*点击transfer_btn按钮弹出，再次点击transfer_btn按钮或者点击transfer_list_li里边的任意一个li关闭。
*里边现在共有105个li，可以使用transfer_list_li.length来获取到它的数量。
*/

var flag=true;
var oftenUseExpress = ["顺丰","SF","EMS","EMS","中通","ZTO","申通","STO","圆通","YTO","韵达","YD","百世汇通","BTWL","天天快递","HHTT","邮政小包","YZPY","全峰","QFKD","快捷快递","FAST","国通","GTO","速尔","SURE","fedex国内","FEDEX",
                       "德邦快递","DBL","德邦物流","DBL"];
var allExpress = ["安捷快递","AJ","安能物流","ANE","安信达快递","AXD","澳邮专线","AYCA","百福东方","BFDF","百世快运","BTWL","北青小红帽","BQXHM","CCES快递","CCES","CNPEX中邮快递","CNPEX","COE东方快递","COE","成都善途速运","CDSTKY","城际快递","CJKD","城市100","CITY100","长沙创一","CSCY","D速物流","DSWL","大田物流","DTWL","EMS","EMS","FEDEX联邦(国际件)","FEDEX_GJ","FEDEX联邦(国内件)","FEDEX","泛捷快递","PANEX","飞康达","FKD","高铁速递","GTSD","共速达","GSD","广东邮政","GDEMS","海派通物流公司","HPTEX","好来运快递","HYLSD","恒路物流","HLWL","鸿桥供应链","HOTSCM","华强物流","hq568","华夏龙物流","HXLWL","汇丰物流","HFWL","汇强快递","ZHQKD","急先达","JXD","加运美","JYM","佳吉快运","JJKY","佳怡物流","JYWL","嘉里物流","JLDT","捷特快递","JTKD","晋越快递","JYKD","京广速递","JGSD","九曳供应链","JIUYE","跨越物流","KYWL","快客速递","QUICK","联昊通速递","LHT","龙邦快递","LB","民航快递","MHKD","明亮物流","MLWL","能达速递","NEDA","PCA Express","PCA","平安达腾飞快递","PADTF","全晨快递","QCKD","全日通快递","QRT","全一快递","UAPEX","如风达","RFD","瑞丰速递","RFEX","赛澳递","SAD","上大物流","SDWL","圣安物流","SAWL","盛邦物流","SBWL","盛丰物流","SFWL","盛辉物流","SHWL","速必达物流","SUBIDA","速腾快递","STWL","速通物流","ST","唐山申通","TSSTO","天地华宇","HOAU","UEQ Express","UEQ","万家物流","WJWL","万象物流","WXWL","希优特","XYT","新邦物流","XBWL","新杰物流","XJ","信丰快递","XFEX","亚风快递","YFSD","亚马逊物流","AMAZON","亿翔快递","YXKD","义达国际物流","YDH","优速快递","UC","原飞航物流","YFHEX","源安达快递","YADEX","远成物流","YCWL","越丰物流","YFEX","运通快递","YTKD","增益快递","ZENY","宅急送","ZJS","中铁快运","ZTKY","中铁物流","ZTWL","中邮物流","ZYWL","众通快递","ZTE"];
$(function() {
	loadOftenUseExpress();
	loadAllExpress();
	var transfer_btn=$(".transfer_btn");
	var transfer_list=$(".transfer_list");
	transfer_btn.click(function() {
		if (flag) {
			transfer_list.css("display", "block");
			flag = false;
		} else {
			transfer_list.css("display", "none");
			flag = true;
		}

	})
	var transfer_list_li = $(".transfer_right li");
	transfer_list_li.click(function() {
		transfer_btn.html($(this).html())
		$("#logisticsAdd_transferCarrierId").val($(this).next().html());
		$("#logisticsPublic_transferCarrierId").val($(this).next().html());
		transfer_list.css("display", "none");
		flag = true;
	})
})
function loadOftenUseExpress() {
	var li = '';
	for (var i = 0; i < oftenUseExpress.length; i += 2) {
//		console.log(oftenUseExpress[i]);
		li += '<li>' + oftenUseExpress[i] + '</li>';
		li += '<li style="display:none">' + oftenUseExpress[i + 1] + '</li>';
	}
	$("#often_use_express").append(li);
}
function loadAllExpress() {
	var li = '';
	for (var i = 0; i < allExpress.length; i += 2) {
//		console.log(allExpress[i]);
		li += '<li>' + allExpress[i] + '</li>';
		li += '<li style="display:none">' + allExpress[i + 1] + '</li>';
	}
	$("#all_express").append(li);
}


