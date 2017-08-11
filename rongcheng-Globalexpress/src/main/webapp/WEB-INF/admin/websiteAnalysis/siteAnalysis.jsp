<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<link rel="stylesheet" href="/admin/css/dataAnalysis.css">
<link rel="stylesheet" href="/data/jquery.datetimepicker.css">

<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/pintuer.js"></script>
<script src="/data/build/jquery.datetimepicker.full.js"></script>

    <script src="/admin/zb/js/contentManagement/cookie_util.js"></script>
    <script src="/admin/zb/js/contentManagement/basevalue.js"></script>
    <script src="/admin/zb/js/websiteAnalysis/siteAnalysis.js"></script>
</head>
<body style="position:relative;">
  <div id="listform">
    <div class="panel admin-panel" id="webPage_div1">
      <div class="panel-head"><strong class="icon-reorder" id="div_title1"></strong></div>
      <div class="content_titele" id="content_titele1">
        <ul class="search">
          <li style="width: 100px;">按时间搜索:</li>
          <li> <a class="button border-main screening_condition time_search1"  id="today1" href="javascript:;">当日</a> </li>
          <li> <a class="button border-main screening_condition time_search1"  id="sevenday1" href="javascript:;">7 天</a> </li>
          <li> <a class="button border-main screening_condition time_search1"  id="thirtyday1" href="javascript:;">30 天</a> </li>
          <li> <a class="button border-main screening_condition time_search1"  id="thisyear1" href="javascript:;">本年</a> </li>
          <li>
	          <input type="text" class="input_search some_class" id="start_time1" style="cursor: pointer;">
	          <span style="margin: 0 5px;">至</span>
	          <input type="text" class="input_search some_class" id="end_time1" style="cursor: pointer;">
	      </li>
          <li> <a class="button border-main screening_condition time_search1" href="javascript:;" id="time_search1">搜索</a> </li>
        </ul>
        <ul class="search">
          <li style="width: 100px;">按终端/渠道搜索:</li>
          <li> <a class="button border-main screening_condition terminal_search1" id="terminalAll1" href="javascript:;">所有</a> </li>
          <li> <a class="button border-main screening_condition terminal_search1" id="terminalPhone1" href="javascript:;">手机</a> </li>
          <li> <a class="button border-main screening_condition terminal_search1" id="terminalPC1" href="javascript:;">PC端</a> </li>
          <li> <a class="button border-main screening_condition terminal_search1" id="terminalFlat1" href="javascript:;">平板</a> </li>
        </ul>
      </div>
      <div class="content" id="siteAnalysis_content1">
        <!-- 加载第一部分内容 -->
      </div>
      <table class="table table-hover text-center" id="siteAnalysis_table1">
        <!-- 加载第一部分内容 -->
      </table>
    </div>
    <div class="panel admin-panel" style="margin-top:20px;"  id="webPage_div2">
      <div class="panel-head"><strong class="icon-reorder" id="div_title2"></strong></div>
      <div class="content_titele" id="content_titele2">
        <ul class="search">
          <li style="width: 100px;">按时间搜索:</li>
          <li> <a class="button border-main screening_condition time_search2" id="today2" href="javascript:;">当日</a> </li>
          <li> <a class="button border-main screening_condition time_search2" id="sevenday2" href="javascript:;">7 天</a> </li>
          <li> <a class="button border-main screening_condition time_search2" id="thirtyday2" href="javascript:;">30 天</a> </li>
          <li> <a class="button border-main screening_condition time_search2" id="thisyear2" href="javascript:;">本年</a> </li>
          <li>
              <input type="text" class="input_search some_class" id="start_time2" style="cursor: pointer;">
              <span style="margin: 0 5px;">至</span>
              <input type="text" class="input_search some_class" id="end_time2" style="cursor: pointer;">
          </li>          
          <li> <a class="button border-main screening_condition time_search2" href="javascript:;" id="time_search2">搜索</a> </li>
        </ul>
        <ul class="search">
          <li style="width: 100px;">按终端/渠道搜索:</li>
          <li> <a class="button border-main screening_condition terminal_search2" id="terminalAll2" href="javascript:;">所有</a> </li>
          <li> <a class="button border-main screening_condition terminal_search2" id="terminalPhone2" href="javascript:;">手机</a> </li>
          <li> <a class="button border-main screening_condition terminal_search2" id="terminalPC2" href="javascript:;">PC端</a> </li>
          <li> <a class="button border-main screening_condition terminal_search2" id="terminalFlat2" href="javascript:;">平板</a> </li>
        </ul>
      </div>
      <div class="content" id="siteAnalysis_content2">
        <!-- 加载第二部分内容 -->
      </div>
      <table class="table table-hover text-center" id="siteAnalysis_table2">
        <!-- 加载第二部分内容 -->
      </table>
    </div>
  </div>
</body>
<script>
    $('.some_class').datetimepicker();
</script>
</html>