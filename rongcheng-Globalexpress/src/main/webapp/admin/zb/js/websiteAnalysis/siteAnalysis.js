
//0.1.全局变量 最大页数
var max_page1 = null;

//0.1.全局变量 当前页数
var now_page1 = 1;

//0.1.全局变量，时间搜索
var time_search1 = 7;

//0.1.全局变量，本年搜索
var year_search1 = null;

//0.1.全局变量，终端搜索
var terminal_search1 = null;

//0.1.全局变量，起始时间
var start_time1 = null;

//0.1.全局变量，结束时间
var end_time1 = null;

//0.2.全局变量 最大页数
var max_page2 = null;

//0.2.全局变量 当前页数
var now_page2 = 1;

//0.2.全局变量，时间搜索
var time_search2 = 7;

//0.2.全局变量，本年搜索
var year_search2 = null;

//0.2.全局变量，终端搜索
var terminal_search2 = null;

//0.2.全局变量，起始时间
var start_time2 = null;

//0.2.全局变量，结束时间
var end_time2 = null;

$(function(){
	
	//1.加载校验
	loadCheckpoint("../");
	
	//2.加载页面
	loadSiteAnalysis(now_page1, now_page2, start_time1, end_time1, start_time2, end_time2, 
			year_search1, year_search2, time_search1, terminal_search1, time_search2, terminal_search2);
	
	//3.监听页码1点击事件
	$("#webPage_div1").on("click", ".pagelist a", pageClick1);
	
	//4.监听页码2点击事件
	$("#webPage_div2").on("click", ".pagelist a", pageClick2);
	
	//5.监听筛选条件1点击事件
	$("#webPage_div1").on("click", ".screening_condition", screeningCondition1);
	
	//6.监听筛选条件2点击事件
	$("#webPage_div2").on("click", ".screening_condition", screeningCondition2);
	
	//7.加载选中按钮事件
	checkedButton();
	
});

/**
 * 7.加载选中按钮事件
 * @returns
 * @author 赵滨
 */
function checkedButton() {
	
	//page1的第一行
	for (var i = 0; i < $(".time_search1").length; i++) {
		$(".time_search1").eq(i).css("background-color", "#fff");
		$(".time_search1").eq(i).css("color", "#0ae");
	}
	//选中当日
	if (time_search1 == 0) {
		
		//改变样式
		$("#today1").css("background-color", "#0ae");
		$("#today1").css("color", "#fff");
		
	//选中7天
	} else if (time_search1 == 7) {
		
		//改变样式
		$("#sevenday1").css("background-color", "#0ae");
		$("#sevenday1").css("color", "#fff");
		
	//选中30 天
	} else if (time_search1 == 30) {
		
		//改变样式
		$("#thirtyday1").css("background-color", "#0ae");
		$("#thirtyday1").css("color", "#fff");
		
	//选中本年
	} else if (year_search1 == 0) {
		
		//改变样式
		$("#thisyear1").css("background-color", "#0ae");
		$("#thisyear1").css("color", "#fff");
		
	//选中搜索
	} else if (start_time1 != null && end_time1 != null) {
		
		//改变样式
		$("#time_search1").css("background-color", "#0ae");
		$("#time_search1").css("color", "#fff");
		
	}
	
	//page1的第二行
	for (var i = 0; i < $(".terminal_search1").length; i++) {
		$(".terminal_search1").eq(i).css("background-color", "#fff");
		$(".terminal_search1").eq(i).css("color", "#0ae");
	}
	//选中所有
	if (terminal_search1 == null) {
		
		//改变样式
		$("#terminalAll1").css("background-color", "#0ae");
		$("#terminalAll1").css("color", "#fff");
		
	//选中手机
	} else if (terminal_search1 == 1) {
		
		//改变样式
		$("#terminalPhone1").css("background-color", "#0ae");
		$("#terminalPhone1").css("color", "#fff");
		
	//选中PC端
	} else if (terminal_search1 == 2) {
		
		//改变样式
		$("#terminalPC1").css("background-color", "#0ae");
		$("#terminalPC1").css("color", "#fff");
		
	//选中平板
	} else if (terminal_search1 == 3) {
		
		//改变样式
		$("#terminalFlat1").css("background-color", "#0ae");
		$("#terminalFlat1").css("color", "#fff");
		
	}
	
	
	//page2的第一行
	for (var i = 0; i < $(".time_search2").length; i++) {
		$(".time_search2").eq(i).css("background-color", "#fff");
		$(".time_search2").eq(i).css("color", "#0ae");
	}
	//选中当日
	if (time_search2 == 0) {
		
		//改变样式
		$("#today2").css("background-color", "#0ae");
		$("#today2").css("color", "#fff");
		
	//选中7天
	} else if (time_search2 == 7) {
		
		//改变样式
		$("#sevenday2").css("background-color", "#0ae");
		$("#sevenday2").css("color", "#fff");
		
	//选中30 天
	} else if (time_search2 == 30) {
		
		//改变样式
		$("#thirtyday2").css("background-color", "#0ae");
		$("#thirtyday2").css("color", "#fff");
		
	//选中本年
	} else if (year_search2 == 0) {
		
		//改变样式
		$("#thisyear2").css("background-color", "#0ae");
		$("#thisyear2").css("color", "#fff");
		
	//选中搜索
	} else if (start_time2 != null && end_time2 != null) {
		
		//改变样式
		$("#time_search2").css("background-color", "#0ae");
		$("#time_search2").css("color", "#fff");
		
	}
	
	//page1的第二行
	for (var i = 0; i < $(".terminal_search2").length; i++) {
		$(".terminal_search2").eq(i).css("background-color", "#fff");
		$(".terminal_search2").eq(i).css("color", "#0ae");
	}
	//选中所有
	if (terminal_search2 == null) {
		
		//改变样式
		$("#terminalAll2").css("background-color", "#0ae");
		$("#terminalAll2").css("color", "#fff");
		
	//选中手机
	} else if (terminal_search2 == 1) {
		
		//改变样式
		$("#terminalPhone2").css("background-color", "#0ae");
		$("#terminalPhone2").css("color", "#fff");
		
	//选中PC端
	} else if (terminal_search2 == 2) {
		
		//改变样式
		$("#terminalPC2").css("background-color", "#0ae");
		$("#terminalPC2").css("color", "#fff");
		
	//选中平板
	} else if (terminal_search2 == 3) {
		
		//改变样式
		$("#terminalFlat2").css("background-color", "#0ae");
		$("#terminalFlat2").css("color", "#fff");
		
	}
}

/**
 * 6.监听筛选条件2点击事件
 * @returns
 * @author 赵滨
 */
function screeningCondition2() {
	
	//筛选内容
	var screeningHtml = $(this).html();
	
	//如果点击当日
	if (screeningHtml == "当日") {
		//赋值
		now_page2 = 1;
		time_search2 = 0;
		year_search2 = null;
		start_time2 = null;
		end_time2 = null;
		
	//如果点击7 天
	} else if (screeningHtml == "7 天") {
		//赋值
		now_page2 = 1;
		time_search2 = 7;
		year_search2 = null;
		start_time2 = null;
		end_time2 = null;
		
	//如果点击30 天
	} else if (screeningHtml == "30 天") {
		//赋值
		now_page2 = 1;
		time_search2 = 30;
		year_search2 = null;
		start_time2 = null;
		end_time2 = null;
		
	//如果点击本年
	} else if (screeningHtml == "本年") {
		//赋值
		now_page2 = 1;
		time_search2 = null;
		year_search2 = 0;
		start_time2 = null;
		end_time2 = null;
		
	//如果点击搜索
	} else if (screeningHtml == "搜索") {
		
		//获取日期
		var start = $("#start_time2").val();
		var end = $("#end_time2").val();
		
		//如果没有选择日期
		if (start == "" || end == "") {
			alert("请选择日期");
			return;
		}
		
		//获取正确格式的日期
		start = $("#start_time2").val().replace(/\//g,"-")+":00";
		end = $("#end_time2").val().replace(/\//g,"-")+":00";
		
		//赋值
		now_page2 = 1;
		time_search2 = null;
		year_search2 = null;
		start_time2 = start;
		end_time2 = end;
		
	//如果点击所有
	} else if (screeningHtml == "所有") {
		//赋值
		now_page2 = 1;
		terminal_search2 = null;
		
	//如果点击手机
	} else if (screeningHtml == "手机") {
		//赋值
		now_page2 = 1;
		terminal_search2 = 1;
		
	//如果点击PC端
	} else if (screeningHtml == "PC端") {
		//赋值
		now_page2 = 1;
		terminal_search2 = 2;
		
	//如果点击平板
	} else if (screeningHtml == "平板") {
		//赋值
		now_page2 = 1;
		terminal_search2 = 3;
		
	}
	
	//选中按钮
	checkedButton();

	//加载页面2
	loadSiteAnalysis(null, now_page2, null, null, start_time2, end_time2, 
			null, year_search2, null, null, time_search2, terminal_search2);
}

/**
 * 5.监听筛选条件1点击事件
 * @returns
 * @author 赵滨
 */
function screeningCondition1() {
	
	//筛选内容
	var screeningHtml = $(this).html();
	
	//如果点击当日
	if (screeningHtml == "当日") {
		//赋值
		now_page1 = 1;
		time_search1 = 0;
		year_search1 = null;
		start_time1 = null;
		end_time1 = null;
		
	//如果点击7 天
	} else if (screeningHtml == "7 天") {
		//赋值
		now_page1 = 1;
		time_search1 = 7;
		year_search1 = null;
		start_time1 = null;
		end_time1 = null;
		
	//如果点击30 天
	} else if (screeningHtml == "30 天") {
		//赋值
		now_page1 = 1;
		time_search1 = 30;
		year_search1 = null;
		start_time1 = null;
		end_time1 = null;
		
	//如果点击本年
	} else if (screeningHtml == "本年") {
		//赋值
		now_page1 = 1;
		time_search1 = null;
		year_search1 = 0;
		start_time1 = null;
		end_time1 = null;
		
	//如果点击搜索
	} else if (screeningHtml == "搜索") {
		
		//获取日期
		var start = $("#start_time1").val();
		var end = $("#end_time1").val();
		
		//如果没有选择日期
		if (start == "" || end == "") {
			alert("请选择日期");
			return;
		}
		
		//获取正确格式的日期
		start = $("#start_time1").val().replace(/\//g,"-")+":00";
		end = $("#end_time1").val().replace(/\//g,"-")+":00";
		
		//赋值
		now_page1 = 1;
		time_search1 = null;
		year_search1 = null;
		start_time1 = start;
		end_time1 = end;
		
	//如果点击所有
	} else if (screeningHtml == "所有") {
		//赋值
		now_page1 = 1;
		terminal_search1 = null;
		
	//如果点击手机
	} else if (screeningHtml == "手机") {
		//赋值
		now_page1 = 1;
		terminal_search1 = 1;
		
	//如果点击PC端
	} else if (screeningHtml == "PC端") {
		//赋值
		now_page1 = 1;
		terminal_search1 = 2;
		
	//如果点击平板
	} else if (screeningHtml == "平板") {
		//赋值
		now_page1 = 1;
		terminal_search1 = 3;
		
	}
	
	//选中按钮
	checkedButton();
	
	//加载页面1
	loadSiteAnalysis(now_page1, null, start_time1, end_time1, null, null, 
			year_search1, null, time_search1, terminal_search1, null, null);
}

/**
 * 4.监听页码2点击事件
 * @returns
 * @author 赵滨
 */
function pageClick2() {

	var aHtml = $(this).html();
	//判断当前页的值
	if(aHtml == "首页"){
		now_page2 = 1;
	}else if(aHtml == "上一页"){
		if(now_page2 > 1){
			now_page2--;
		}
	}else if(aHtml=="下一页"){
		if(now_page2 < max_page2){
			now_page2++;
		}
	}else if(aHtml=="尾页"){
		now_page2 = parseInt(max_page2);
	}else{
		now_page2 = parseInt(aHtml);
	}
	//加载页面2
	loadSiteAnalysis(null, now_page2, null, null, start_time2, end_time2, 
			null, year_search2, null, null, time_search2, terminal_search2);

}

/**
 * 3.监听页码1点击事件
 * @returns
 * @author 赵滨
 */
function pageClick1() {

	var aHtml = $(this).html();
	//判断当前页的值
	if(aHtml == "首页"){
		now_page1 = 1;
	}else if(aHtml == "上一页"){
		if(now_page1 > 1){
			now_page1--;
		}
	}else if(aHtml=="下一页"){
		if(now_page1 < max_page1){
			now_page1++;
		}
	}else if(aHtml=="尾页"){
		now_page1 = parseInt(max_page1);
	}else{
		now_page1 = parseInt(aHtml);
	}
	//加载页面1
	loadSiteAnalysis(now_page1, null, start_time1, end_time1, null, null, 
			year_search1, null, time_search1, terminal_search1, null, null);

}

/**
 * 2.加载页面
 * @returns
 * @author 赵滨
 */
function loadSiteAnalysis(nowPage1, nowPage2, startTime1, endTime1, startTime2, endTime2, 
		yearSearch1, yearSearch2, timeSearch1, terminalSearch1, timeSearch2, terminalSearch2) {
	
	/*console.log(nowPage1, nowPage2, startTime1, endTime1, startTime2, 
		endTime2, yearSearch1, yearSearch2, timeSearch1, terminalSearch1, timeSearch2, terminalSearch2);*/
	//获取页面类型
	var siteAnalysisType = getCookie("siteAnalysisType");
	
	//如果是实时数据
	if (siteAnalysisType == "timeData") {
		//修改提示标题
		$("#div_title1").html(" 总体概览");
		$("#div_title2").html(" 实时观察");
		
		//隐藏选择框
		$("#content_titele2").css("display", "none");
		
	//如果是流量分析
	} else if (siteAnalysisType == "flowAnalysis") {
		//修改提示标题
		$("#div_title1").html(" 访客分析");
		$("#div_title2").html(" 流量分析");
		
	//如果是页面分析
	} else if (siteAnalysisType == "pageAnalysis") {
		//修改提示标题
		$("#div_title1").html(" 页面访问实时概况");
		$("#div_title2").html(" 栏目点击热度");
		
	//如果是关键词分析
	} else if (siteAnalysisType == "keywordAnalysis") {
		//修改提示标题
		$("#div_title1").html(" 来源关键词分析");
		$("#div_title2").html(" 站内关键词分析");
		
	}
	
	
	//发送请求，获取数据
	$.ajax({
		url : path+"/siteAnalysis/loadSiteAnalysis.do",
		type : "post",
		data : {
			"siteAnalysisType" : siteAnalysisType,
			"nowPage1" : nowPage1,
			"nowPage2" : nowPage2,
			"startTime1" : startTime1,
			"endTime1" : endTime1,
			"startTime2" : startTime2,
			"endTime2" : endTime2,
			"yearSearch1" : yearSearch1,
			"yearSearch2" : yearSearch2,
			"timeSearch1" : timeSearch1,
			"terminalSearch1" : terminalSearch1,
			"timeSearch2" : timeSearch2,
			"terminalSearch2" : terminalSearch2
		},
		dataType : "json",
		success : function(result) {
			
			//获取集合map
			var map = result.data;

			//创建当前页面
			createSiteAnalysis(map);
			
		},
		error : function() {
			alert("页面加载失败!");
		}
	});
}

/**
 * 2.1.创建当前页面
 * @returns
 * @author 赵滨
 */
function createSiteAnalysis(map) {
	
	//获取页面类型
	var siteAnalysisType = getCookie("siteAnalysisType");
	
	//如果是实时数据
	if (siteAnalysisType == "timeData") {
		
		//基础信息 总体概览	第一部分 
		var mapAllMessage = map.mapAllMessage;
		
		//如果有返回值
		if (mapAllMessage != undefined) {
			
			//创建总体概览
			createMapAllMessage(mapAllMessage);
		}
		
		//访客信息 实时观察 第二部分
		var listVisitorInfo = map.listVisitorInfo;
		
		//最大页数
		var listVisitorInfoMaxPage = map.listVisitorInfoMaxPage;
		
		//如果有返回值
		if (listVisitorInfo != undefined) {
			
			//创建访客信息
			createListVisitorInfo(listVisitorInfo, listVisitorInfoMaxPage);
			
		}
		
		
	//如果是流量分析
	} else if (siteAnalysisType == "flowAnalysis") {
		
		//访客分析流量分析 第一部分
		var listVisitorLocation = map.listVisitorLocation;
		
		//最大页数
		var listVisitorLocationMaxPage = map.listVisitorLocationMaxPage;
		
		//如果有返回值
		if (listVisitorLocation != undefined) {
			
			//创建访客分析
			createListVisitorLocation(listVisitorLocation, listVisitorLocationMaxPage);
			
		}
		
		//星期几流量分析 第二部分
		var listVisitorDayOfWeek = map.listVisitorDayOfWeek;
		
		//如果有返回值
		if (listVisitorDayOfWeek != undefined) {
			
			//创建流量分析
			createListVisitorDayOfWeek(listVisitorDayOfWeek);
			
		}
		
		
	//如果是页面分析
	} else if (siteAnalysisType == "pageAnalysis") {
		
		//页面名称 页面分析 第一部分
		var listVisitorWebPage = map.listVisitorWebPage;
		
		//最大页数
		var listVisitorWebPageMaxPage = map.listVisitorWebPageMaxPage;
		
		//如果有返回值
		if (listVisitorWebPage != undefined) {
			
			//创建页面名称 页面分析
			createListVisitorWebPage(listVisitorWebPage, listVisitorWebPageMaxPage);
			
		}
		
		//访问栏目 页面分析 第二部分
		var listVisitorAccessColumn = map.listVisitorAccessColumn;
		
		//最大页数
		var listVisitorAccessColumnMaxPage = map.listVisitorAccessColumnMaxPage;
		
		//如果有返回值
		if (listVisitorAccessColumn != undefined) {
			
			//创建访问栏目 页面分析
			createListVisitorAccessColumn(listVisitorAccessColumn, listVisitorAccessColumnMaxPage);
			
		}
		
		
	//如果是关键词分析
	} else if (siteAnalysisType == "keywordAnalysis") {
		
		//来源关键词分析 第一部分
		var listVisitorExternalSourceKeyword = map.listVisitorExternalSourceKeyword;
		
		//最大页数
		var listVisitorExternalSourceKeywordMaxPage = map.listVisitorExternalSourceKeywordMaxPage;
		
		//如果有返回值
		if (listVisitorExternalSourceKeyword != undefined) {
			
			//创建关键词分析
			createListVisitorExternalSourceKeyword(listVisitorExternalSourceKeyword, 
					listVisitorExternalSourceKeywordMaxPage);
			
		}
		
		//站内关键词分析 第二部分
		var listVisitorInsideSourceKeyword = map.listVisitorInsideSourceKeyword;

		//最大页数
		var listVisitorInsideSourceKeywordMaxPage = map.listVisitorInsideSourceKeywordMaxPage;
		
		//如果有返回值
		if (listVisitorInsideSourceKeyword != undefined) {
			
			//创建站内关键词分析
			createListVisitorInsideSourceKeyword(listVisitorInsideSourceKeyword, 
					listVisitorInsideSourceKeywordMaxPage);
			
		}

	}
}

/**
 * 2.2.创建总体概览
 * @param mapAllMessage
 * @returns
 * @author 赵滨
 */
function createMapAllMessage(mapAllMessage) {
	
	//清空内容
	$("#siteAnalysis_content1").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<ul class="top6">';
	put += '<li>访客数UV</li>';
	put += '<li>浏览量PV</li>';
	put += '<li>人均浏览量</li>';
	put += '<li>人均停留时长</li>';
	put += '<li>收藏人数</li>';
	put += '<li>关注人数</li>';
	put += '</ul>';
    
	
	put += '<ul class="bottom6">';
	put += '<li>';
	put += '<p>';
	put += mapAllMessage.visitorNumber;		//访客数
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '<li>';
	put += '<p>';
	put += mapAllMessage.pageViews;		//浏览量
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '<li>';
	put += '<p>';
	put += mapAllMessage.perPersonPageViews;		//人均浏览量
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '<li>';
	put += '<p>';
	put += mapAllMessage.perPersonStayDuration;		//人均停留时长
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '<li>';
	put += '<p>';
	put += 0;										//收藏人数
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '<li>';
	put += '<p>';
	put += 0;										//关注人数
	put += '</p>';
//	put += '<p>昨日全天 : <i>55</i>%</p>';
//	put += '<p>PC占比 : <i>48</i>%</p>';
	put += '<p><i><br></i></p>';
	put += '<p><i><br></i></p>';
	
	put += '</li>';
	put += '</ul>';
    
    //追加到页面中
	$("#siteAnalysis_content1").append(put);

}

/**
 * 2.3.创建访客信息
 * @param listVisitorInfo
 * @returns
 * @author 赵滨
 */
function createListVisitorInfo(listVisitorInfo, listVisitorInfoMaxPage) {
	
	//加载最大页数
	max_page2 = listVisitorInfoMaxPage;
	
	//清空内容
	$("#siteAnalysis_table2").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<tr>';
	put += '<th style="padding-left:20px;">编号</th>';
	put += '<th>访客账号</th>';
	put += '<th>ip </th>';
	put += '<th width="100">地区 </th>';
	put += '<th>新老客户</th>';
	put += '<th width="200">入站来源</th>';
	put += '<th width="150">入站时间</th>';
	put += '<th width="200">被访页面</th>';
	put += '<th>当前状态</th>';
	put += '</tr>';
	
	//追加到页面中
	$("#siteAnalysis_table2").append(put);
	
	//遍历集合，循环加载
	for (var i = 0; i < listVisitorInfo.length; i++) {
		
		put = "";
		
		put += '<tr>';
		put += '<td style="padding-left:20px;">';
		put += i + 1;		//编号
		put += '</td>';
		put += '<td>';
		put += listVisitorInfo[i].visitorAccount;		//访客账号
		put += '</td>';
		put += '<td>';
		
		//获取ip
		var ip = listVisitorInfo[i].visitorIp;		//ip
		
		//转换格式
		put += ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "."  + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
		
		put += '</td>';
		put += '<td><p class="data_p1" title="';
		put += listVisitorInfo[i].visitorLocation;		//地区
		put += '">';
		put += listVisitorInfo[i].visitorLocation;		//地区
		put += '</p></td>';
		put += '<td>';
		
		//新客户
		if (listVisitorInfo[i].visitorType == 1) {
			put += '新';
			
		//老客户
		} else if (listVisitorInfo[i].visitorType == 2) {
			put += '老';
			
		}
			
		put += '</td>';
		put += '<td><p><a href="javascript:;">';
		put += listVisitorInfo[i].parentId;			//入站来源
		put += '</a></p></td>';
		put += '<td>';
		
		//获取日期时间戳
		var timestamp = listVisitorInfo[i].gmtCreate;		//入站时间
		
		//创建日期对象
	    var date = new Date(timestamp);
	    
	    //加入日期
	    put += date.getFullYear() + '年 ' + (date.getMonth()+ 1) + '月 ' + date.getDate() + '日</br>' + 
	    		date.getHours() + '时 ' + date.getMinutes() + '分 ' + date.getSeconds() + '秒';
		
		put += '</td>';
		put += '<td><p><a href="javascript:;">';
		put += listVisitorInfo[i].visitedPage;			//被访页面
		put += '</a></p></td>';
		put += '<td>';
		
		//获取当前状态
		var currentState = listVisitorInfo[i].currentState;
		
		//如果离线
		if (currentState == 0) {
			put += '离开';		
			
	    //如果在线
		} else if (currentState == 1) {
			put += '在线';			
			
		}
		
		put += '</td>';
		put += '</tr>';
		
		//追加到页面中
		$("#siteAnalysis_table2").append(put);
	}
	
	put = "";
    
	//创建页码2
	put = createPage2(true);
	
	//追加到页面中
    $("#siteAnalysis_table2").append(put);
}

/**
 * 2.4.创建创建流量分析
 * @param listVisitorLocation
 * @returns
 * @author 赵滨
 */
function createListVisitorLocation(listVisitorLocation, listVisitorLocationMaxPage) {

	//加载最大页数
	max_page1 = listVisitorLocationMaxPage;
	
	//清空内容
	$("#siteAnalysis_table1").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<tr>';
	put += '<th>来源地区</th>';
	put += '<th>访客数</th>';
	put += '<th>访客数全国占比</th>';
	put += '<th>浏览量PV</th>';
	put += '<th>人均浏览量</th>';
	put += '<th>人均停留时长</th>';
	put += '<th>新客户数</th>';
	put += '<th>新客户占比</th>';
	put += '</tr>';
	
	//追加到页面中
	$("#siteAnalysis_table1").append(put);
	
	for (var i = 0; i < listVisitorLocation.length; i++) {
		
		put = "";
		
		put += '<tr>';
		put += '<td>';
		put += listVisitorLocation[i].visitorLocation;		//来源地区
        put += '</td>';
        put += '<td>';
		
        put += listVisitorLocation[i].visitorNumber;		//访客数
        
        put += '</td>';
        put += '<td>';
		put += (listVisitorLocation[i].visitorNumberNationalProportion * 100).toFixed(2) + "%";		//访客数全国占比
        put += '</td>';
        put += '<td>';
		put += listVisitorLocation[i].pageViews;		//浏览量
        put += '</td>';
        put += '<td>';
		put += listVisitorLocation[i].perPersonPageViews;		//人均浏览量
        put += '</td>';
        put += '<td>';
		put += listVisitorLocation[i].perPersonStayDuration;		//人均停留时长
        put += '</td>';
        put += '<td>';
		put += listVisitorLocation[i].newVisitorNumber;		//新客户数
        put += '</td>';
        put += '<td>';
		put += (listVisitorLocation[i].newVisitorProportion * 100).toFixed(2) + "%";		//新客户占比
        put += '</td>';
        put += '</tr>';
        
        //追加到页面中
		$("#siteAnalysis_table1").append(put);
	}
	
	put = "";
    
	//创建页码1
	put = createPage1(true);
	
	//追加到页面中
    $("#siteAnalysis_table1").append(put);

}

/**
 * 2.5.创建访客分析
 * @param listVisitorDayOfWeek
 * @returns
 * @author 赵滨
 */

function createListVisitorDayOfWeek(listVisitorDayOfWeek) {

	
	//清空内容
	$("#siteAnalysis_table2").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<tr>';
	put += '<th>星期</th>';
	put += '<th>访客数</th>';
	put += '<th>星期数全部占比</th>';
	put += '<th>浏览量</th>';
	put += '<th>人均浏览量</th>';
	put += '<th>人均停留时长</th>';
	put += '<th>新客户数</th>';
	put += '<th>新客户占比</th>';
	put += '</tr>';
  
	//追加到页面中
	$("#siteAnalysis_table2").append(put);
	
	for (var i = 0; i < listVisitorDayOfWeek.length; i++) {
		
		put = "";
		
		put += '<tr>';
		put += '<td>';
		
		//获取星期
		var week = listVisitorDayOfWeek[i].dayOfWeek;
		
		//转换星期格式
		if (week == 1) {
			
			put += "星期日";
			
		} else if (week == 2) {
			
			put += "星期一";
			
		} else if (week == 3) {
			
			put += "星期二";
			
		} else if (week == 4) {
			
			put += "星期三";
			
		} else if (week == 5) {
			
			put += "星期四";
			
		} else if (week == 6) {
			
			put += "星期五";
			
		} else if (week == 7) {
			
			put += "星期六";
			
		}
		
        put += '</td>';
        put += '<td>';
		put += listVisitorDayOfWeek[i].visitorNumber;		//访客数
        put += '</td>';
        put += '<td>';
		put += (listVisitorDayOfWeek[i].dayOfWeekAllProportion * 100).toFixed(2) + "%";		//星期数全部占比
        put += '</td>';
        put += '<td>';
		put += listVisitorDayOfWeek[i].pageViews;		//浏览量
        put += '</td>';
        put += '<td>';
		put += listVisitorDayOfWeek[i].perPersonPageViews;		//人均浏览量
        put += '</td>';
        put += '<td>';
		put += listVisitorDayOfWeek[i].perPersonStayDuration;		//人均停留时长
        put += '</td>';
        put += '<td>';
		put += listVisitorDayOfWeek[i].newVisitorNumber;		//新客户数
        put += '</td>';
        put += '<td>';
		put += (listVisitorDayOfWeek[i].newVisitorProportion * 100).toFixed(2) + "%";		//新客户占比
        put += '</td>';
        put += '</tr>';
        
        //追加到页面中
		$("#siteAnalysis_table2").append(put);
	}
	
}

/**
 * 2.6.创建页面名称 页面分析
 * @param listVisitorWebPage
 * @returns
 * @author 赵滨
 */
function createListVisitorWebPage(listVisitorWebPage, listVisitorWebPageMaxPage) {
	
	//加载最大页数
	max_page1 = listVisitorWebPageMaxPage;
	
	//清空内容
	$("#siteAnalysis_content1").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<ul class="top7">';
	put += '<li>页面名称</li>';
	put += '<li>访客数</li>';
	put += '<li>浏览量</li>';
	put += '<li>浏览量占比</li>';
	put += '<li>人均停留时长</li>';
	put += '<li>收藏人数</li>';
	put += '<li>关注人数</li>';
	put += '</ul>';
	
	//追加到页面中
	$("#siteAnalysis_content1").append(put);
	
	for (var i = 0; i < listVisitorWebPage.length; i++) {
		
		put = "";
		
		put += '<ul class="bottom7">';
		put += '<li style="height:92px;">';
		put += '<p style="font-size:12px;"><a href="javascript:;">';
		put += listVisitorWebPage[i].pageName;		//页面名称
		put += '</a></p>';
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorWebPage[i].visitorNumber;		//访客数
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorWebPage[i].pageViews;		//浏览量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += (listVisitorWebPage[i].pageViewsProportion * 100).toFixed(2) + "%";		//浏览量占比
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorWebPage[i].perPersonStayDuration;		//人均停留时长
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;		//收藏人数
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;		//关注人数
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '</ul>';
        
        //追加到页面中
		$("#siteAnalysis_content1").append(put);
	}
	
    put = "";
    
    //创建页码1
    put = createPage1(false);

    //追加到页面中
	$("#siteAnalysis_content1").append(put);
	
}

/**
 * 2.7.创建访问栏目 页面分析
 * @param listVisitorAccessColumn
 * @returns
 * @author 赵滨
 */
function createListVisitorAccessColumn(listVisitorAccessColumn, listVisitorAccessColumnMaxPage) {

	//加载最大页数
	max_page2 = listVisitorAccessColumnMaxPage;
	
	//清空内容
	$("#siteAnalysis_table2").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<tr>';
	put += '<th>被访问栏目</th>';
	put += '<th>访客数</th>';
	put += '<th>访客位置</th>';
	put += '<th>点击量 </th>';
	put += '<th>人均点击量</th>';
	put += '</tr>';
  
	//追加到页面中
	$("#siteAnalysis_table2").append(put);
	
	for (var i = 0; i < listVisitorAccessColumn.length; i++) {
		
		put = "";
		
		put += '<tr>';
		put += '<td>';
		put += listVisitorAccessColumn[i].accessColumn;		//被访问栏目
		put += '</td>';
		put += '<td>';
		put += listVisitorAccessColumn[i].visitorNumber;		//访客数
		put += '</td>';
		put += '<td>';
		put += listVisitorAccessColumn[i].visitorLocation;		//访客位置
		put += '</td>';
		put += '<td>';
		put += listVisitorAccessColumn[i].clickedNumber;		//点击量
		put += '</td>';
		put += '<td>';
		put += listVisitorAccessColumn[i].perPersonclickedNumber;	//人均点击量
		put += '</td>';
		put += '</tr>';
        
        //追加到页面中
		$("#siteAnalysis_table2").append(put);
	}
	
    put = "";
    
    //创建页码1
    put = createPage2(true);

    //追加到页面中
	$("#siteAnalysis_table2").append(put);

}

/**
 * 2.8.创建关键词分析
 * @param listVisitorExternalSourceKeyword
 * @returns
 * @author 赵滨
 */
function createListVisitorExternalSourceKeyword(listVisitorExternalSourceKeyword, 
		listVisitorExternalSourceKeywordMaxPage) {
	
	//加载最大页数
	max_page1 = listVisitorExternalSourceKeywordMaxPage;
	
	//清空内容
	$("#siteAnalysis_content1").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<ul class="top7">';
	put += '<li>来源关键词</li>';
	put += '<li>关键词占比</li>';
	put += '<li>搜索访客数量</li>';
	put += '<li>搜索量增幅</li>';
	put += '<li>搜索次数</li>';
	put += '<li>搜索点击量</li>';
	put += '<li>人均搜索点击量</li>';
	put += '</ul>';
  
	//追加到页面中
	$("#siteAnalysis_content1").append(put);
	
	for (var i = 0; i < listVisitorExternalSourceKeyword.length; i++) {
		
		put = "";
		
		put += '<ul class="bottom7">';
		put += '<li style="height:92px;">';
		put += '<p style="font-size:12px;">';
		put += listVisitorExternalSourceKeyword[i].sourceKeyword;	//来源关键词
		put += '</p>';
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += (listVisitorExternalSourceKeyword[i].keywordProportion * 100).toFixed(2) + "%";	//关键词占比
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorExternalSourceKeyword[i].visitorNumber;	//搜索访客数量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;	//搜索量增幅
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;	//搜索次数
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorExternalSourceKeyword[i].clickedNumber;	//搜索点击量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorExternalSourceKeyword[i].perPersonClickedNumber;	//人均搜索点击量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '</ul>';
        
        //追加到页面中
		$("#siteAnalysis_content1").append(put);
	}
	
    put = "";
    
    put = createPage1(false);

    //追加到页面中
	$("#siteAnalysis_content1").append(put);
	
}

/**
 * 2.9.创建站内关键词分析
 * @param listVisitorInsideSourceKeyword
 * @returns
 * @author 赵滨
 */
function createListVisitorInsideSourceKeyword(listVisitorInsideSourceKeyword, 
		listVisitorInsideSourceKeywordMaxPage) {

	//加载最大页数
	max_page2 = listVisitorInsideSourceKeywordMaxPage;
	
	//清空内容
	$("#siteAnalysis_content2").children().remove();
	
	//拼接块
	var put = "";
	
	put += '<ul class="top8">';
	put += '<li>站内搜索关键词</li>';
	put += '<li>关键词占比</li>';
	put += '<li>搜索访客数量</li>';
	put += '<li>搜索量增幅</li>';
	put += '<li>搜索次数</li>';
	put += '<li>搜索点击量</li>';
	put += '<li>搜索点击率</li>';
	put += '<li>点击量增幅</li>';
	put += '</ul>';
  
	//追加到页面中
	$("#siteAnalysis_content2").append(put);
	
	for (var i = 0; i < listVisitorInsideSourceKeyword.length; i++) {
		
		put = "";
		
		put += '<ul class="bottom8">';
		put += '<li style="height:92px;">';
		put += '<p style="font-size:12px;">';
		put += listVisitorInsideSourceKeyword[i].sourceKeyword;	//站内搜索关键词
		put += '</p>';
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += (listVisitorInsideSourceKeyword[i].keywordProportion * 100).toFixed(2) + "%";	//关键词占比
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorInsideSourceKeyword[i].visitorNumber;	//搜索访客数量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;	//搜索量增幅
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;	//搜索次数
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorInsideSourceKeyword[i].clickedNumber;	//搜索点击量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += listVisitorInsideSourceKeyword[i].perPersonClickedNumber;	//人均搜索点击量
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '<li>';
		put += '<p>';
		put += 0;	//点击量增幅
		put += '</p>';
//		put += '<p>昨日全天 : <i>55</i>%</p>';
//		put += '<p>PC占比 : <i>48</i>%</p>';
		put += '<p><i><br></i></p>';
		put += '<p><i><br></i></p>';
		
		put += '</li>';
		put += '</ul>';
        
        //追加到页面中
		$("#siteAnalysis_content2").append(put);
	}
	
    put = "";
    
    put = createPage2(false);

    //追加到页面中
	$("#siteAnalysis_content2").append(put);
	
}

/**
 * 2.10.创建页码1
 * @param isTr
 * @returns
 * @author 赵滨
 */
function createPage1(isTr) {
	
	//如果没有内容，就加载页码
	if (max_page1 == 0) {
		return "";
	}
	
	var tr = '';
	//如果是tr
	if (isTr) {
		tr += '<tr><td colspan="9">';
	}
	
	//尾页开始部分
	tr += '<div class="pagelist"> <a style="cursor: pointer;">首页</a>';
	tr += '<a style="cursor: pointer;">上一页</a> ';
	/*console.log(now_page);*/
	//尾页中间部分
	if (max_page1 > 5) {
		//如果是页码前两个
		if (now_page1 <= 3) {
			//循环前三页码
			for (var i = 1; i < 4; i++) {
				
				//如果选中当前页码，则变成蓝色背景
				if(i==now_page1){
					tr += '<span class="current" style="cursor: default;">';
					tr += i;
					tr += '</span>';
					
				//否则页码为白色背景
				}else{
					tr += '<a style="cursor: pointer;">';
					tr += i;
					tr += '</a>';
				}
			}
			//写出最后两个
			tr += '<a style="cursor: pointer;">';
			tr += 4;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += 5;
			tr += '</a>……';
			
		//如果是页码最中间
		} else if (now_page1 >= 4 && now_page1 <= max_page1 - 3) {
			//页码前两个
			tr += '……<a style="cursor: pointer;">';
			tr += now_page1 - 2;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += now_page1 - 1;
			tr += '</a>';
			
			//页码中间选中的
			tr += '<span class="current" style="cursor: default;">';
			tr += now_page1;
			tr += '</span>';
			
			//页码后两个
			tr += '<a style="cursor: pointer;">';
			tr += now_page1 + 1;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += now_page1 + 2;
			tr += '</a>……';
		//如果是页码后两个
		} else if (now_page1 > max_page1 - 3) {
			//页码前两个
			tr += '……<a style="cursor: pointer;">';
			tr += max_page1 - 4;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += max_page1 - 3;
			tr += '</a>';
			
			//循环后三页
			for (var i = max_page1 - 2; i <= max_page1; i++) {
				//如果选中当前页码，则变成蓝色背景
				if(i==now_page1){
					tr += '<span class="current" style="cursor: default;">';
					tr += i;
					tr += '</span>';
					
				//否则页码为白色背景
				}else{
					tr += '<a style="cursor: pointer;">';
					tr += i;
					tr += '</a>';
				}
			}
		}
	
	//否则页数小于5页
	} else {
		var i = 1;
		//循环页码
		while (i <= max_page1) {
			//如果选中当前页码，则变成蓝色背景
			if(i==now_page1){
				tr += '<span class="current" style="cursor: default;">';
				tr += i;
				tr += '</span>';
				
			//否则页码为白色背景
			}else{
				tr += '<a style="cursor: pointer;">';
				tr += i;
				tr += '</a>';
			}
			i++;
		}
	}

	//尾页结束部分
	tr += '<a style="cursor: pointer;">下一页</a><a style="cursor: pointer;">尾页</a> </div>';
	//如果是tr
	if (isTr) {
		tr += '</td></tr>';
	}
	
	return tr;
}

/**
 * 2.11.创建页码2
 * @param isTr
 * @returns
 * @author 赵滨
 */
function createPage2(isTr) {
	
	//如果没有内容，就加载页码
	if (max_page2 == 0) {
		return "";
	}
	
	var tr = '';
	//如果是tr
	if (isTr) {
		tr += '<tr><td colspan="9">';
	}
	
	//尾页开始部分
	tr += '<div class="pagelist"> <a style="cursor: pointer;">首页</a>';
	tr += '<a style="cursor: pointer;">上一页</a> ';
	/*console.log(now_page);*/
	//尾页中间部分
	if (max_page2 > 5) {
		//如果是页码前两个
		if (now_page2 <= 3) {
			//循环前三页码
			for (var i = 1; i < 4; i++) {
				
				//如果选中当前页码，则变成蓝色背景
				if(i==now_page2){
					tr += '<span class="current" style="cursor: default;">';
					tr += i;
					tr += '</span>';
					
				//否则页码为白色背景
				}else{
					tr += '<a style="cursor: pointer;">';
					tr += i;
					tr += '</a>';
				}
			}
			//写出最后两个
			tr += '<a style="cursor: pointer;">';
			tr += 4;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += 5;
			tr += '</a>……';
			
		//如果是页码最中间
		} else if (now_page2 >= 4 && now_page2 <= max_page2 - 3) {
			//页码前两个
			tr += '……<a style="cursor: pointer;">';
			tr += now_page2 - 2;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += now_page2 - 1;
			tr += '</a>';
			
			//页码中间选中的
			tr += '<span class="current" style="cursor: default;">';
			tr += now_page2;
			tr += '</span>';
			
			//页码后两个
			tr += '<a style="cursor: pointer;">';
			tr += now_page2 + 1;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += now_page2 + 2;
			tr += '</a>……';
		//如果是页码后两个
		} else if (now_page2 > max_page2 - 3) {
			//页码前两个
			tr += '……<a style="cursor: pointer;">';
			tr += max_page2 - 4;
			tr += '</a>';
			tr += '<a style="cursor: pointer;">';
			tr += max_page2 - 3;
			tr += '</a>';
			
			//循环后三页
			for (var i = max_page2 - 2; i <= max_page2; i++) {
				//如果选中当前页码，则变成蓝色背景
				if(i==now_page2){
					tr += '<span class="current" style="cursor: default;">';
					tr += i;
					tr += '</span>';
					
				//否则页码为白色背景
				}else{
					tr += '<a style="cursor: pointer;">';
					tr += i;
					tr += '</a>';
				}
			}
		}
	
	//否则页数小于5页
	} else {
		var i = 1;
		//循环页码
		while (i <= max_page2) {
			//如果选中当前页码，则变成蓝色背景
			if(i==now_page2){
				tr += '<span class="current" style="cursor: default;">';
				tr += i;
				tr += '</span>';
				
			//否则页码为白色背景
			}else{
				tr += '<a style="cursor: pointer;">';
				tr += i;
				tr += '</a>';
			}
			i++;
		}
	}

	//尾页结束部分
	tr += '<a style="cursor: pointer;">下一页</a><a style="cursor: pointer;">尾页</a> </div>';
	//如果是tr
	if (isTr) {
		tr += '</td></tr>';
	}
	
	return tr;
}