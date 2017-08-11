$(function(){
	
	//实时数据
	$("#timeData").click(function(){
		addCookie("siteAnalysisType", "timeData");
	});
	
	//流浪分析
	$("#flowAnalysis").click(function(){
		addCookie("siteAnalysisType", "flowAnalysis");
	});
	
	//页面分析
	$("#pageAnalysis").click(function(){
		addCookie("siteAnalysisType", "pageAnalysis");
	});
	
	//关键词分析
	$("#keywordAnalysis").click(function(){
		addCookie("siteAnalysisType", "keywordAnalysis");
	});
});