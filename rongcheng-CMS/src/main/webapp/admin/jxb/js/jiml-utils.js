/////////格式化时间 start////////////////////////////////
/**
 * 格式化时间
 * 对Date的扩展，将 Date 转化为指定格式的字符串
 * 
 * 年(y)																可以用 1-4 个占位符
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)	可以用 1-2 个占位符
 * 毫秒(S)															只能用  1  个占位符(是 1-3 位的数字)
 * eg: 
 * (new Date()).format("yyyy-MM-dd hh:mm:ss.S")==> 2006-07-02 08:09:04.423      
 * (new Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04      
 * (new Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04      
 * (new Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04      
 * (new Date()).format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18      
 */
Date.prototype.format=function(fmt) {         
    var o = {         
    "M+" : this.getMonth()+1, //月份         
    "d+" : this.getDate(), //日         
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
    "H+" : this.getHours(), //小时         
    "m+" : this.getMinutes(), //分         
    "s+" : this.getSeconds(), //秒         
    "q+" : Math.floor((this.getMonth()+3)/3), //季度         
    "S" : this.getMilliseconds() //毫秒         
    };         
    var week = {         
    "0" : "/u65e5",         
    "1" : "/u4e00",         
    "2" : "/u4e8c",         
    "3" : "/u4e09",         
    "4" : "/u56db",         
    "5" : "/u4e94",         
    "6" : "/u516d"        
    };         
    if(/(y+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
    }         
    if(/(E+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);         
    }         
    for(var k in o){         
        if(new RegExp("("+ k +")").test(fmt)){         
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
        }         
    }         
    return fmt;         
}
/////////格式化时间 end////////////////////////////////

/////////分页 start////////////////////////////////
//3种样式
/**
 * 
 * @param maxPage				总页数
 * @param nowPage				当前页
 * @param tagId					分页所在标签id值
 * @param onclickFunctionName	页码点击事件触发的方法名
 * @param pagesize				分页大小（忽略此参数时，默认值为5）
 */
var functionName;
function pagination(maxPage,nowPage,tagId,onclickFunctionName,pagesize) {
	if(!pagesize){
		pagesize = 5;
	}
	if(maxPage<2){return;}
	if(nowPage<1 || nowPage>maxPage){
		showMessage("页码超出范围");
		return;
	}
	functionName = onclickFunctionName;
	var parentTag = $("#"+tagId);
	parentTag.empty();
	var pageDiv="";
	pageDiv += '<div id="pageDiv"><a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage-1)+')" href="javascript:;">上一页</a>';
	if(maxPage>pagesize+3){
		if(nowPage<pagesize){
			for(var i=1;i<=pagesize;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			pageDiv += '<span class="_dddspan">...</span>';
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+maxPage+')" href="javascript:;">'+maxPage+'</a>';
		}else if(nowPage>maxPage-pagesize){
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">1</a>';
			pageDiv += '<span class="_dddspan">...</span>';
			for (i=maxPage-pagesize-1;i<=maxPage;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}else {
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">1</a>';
			pageDiv += '<span class="_dddspan">...</span>';
			for (i=1;i<=pagesize;i++){
				if(nowPage-Math.ceil(pagesize/2)+i==nowPage){
					pageDiv += '<a class="a_nowPage" onclick="'+onclickFunctionName+'('+nowPage+')" href="javascript:;">'+nowPage+'</a>';
				}else{
					pageDiv += '<a class = "a_page" onclick="'+onclickFunctionName+'('+(nowPage-Math.ceil(pagesize/2)+i)+')" href="javascript:;">'+(nowPage-Math.ceil(pagesize/2)+i)+'</a>';
				}
			}
			pageDiv += '<span class="_dddspan">...</span>';
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+maxPage+')" href="javascript:;">'+maxPage+'</a>';
		}
	}else{
		var i = 1;
		while (i <= maxPage) {
			if(i==nowPage){
				pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}else{
				pageDiv += '<a class = "a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage+1)+')" href="javascript:;">下一页</a><input id="page_tz" value="'+(maxPage/2).toFixed(0)+'" style="vertical-align:middle;border-radius: 3px;border: 1px solid #dfdfdf;padding: 5px 10px;width: 3em;font: inherit;text-align: center;"/> <a class="a_page" onclick="tiaozhuan()" href="javascript:;">跳转</a></div>';
	parentTag.append(pageDiv);
	$("#pageDiv").css({"user-select": "none","-webkit-user-select":"none","-moz-user-select":"none","-ms-user-select":"none"});
	$(".a_nowPage").css({"vertical-align":"middle","background":"#09F","color":"#FFF","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #09f","display":"inline-block","padding":"5px 10px"});
	$(".a_page").css({"vertical-align":"middle","color":"#000","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	$(".a_page").hover(function(){
		$(this).css({"vertical-align":"middle","background":"#09F","color":"#FFF","text-decoration":"none","border-radius":"3px","border":"1px solid #09F","display":"inline-block","padding":"5px 10px"});
	},function(){
		$(this).css({"vertical-align":"middle","background":"#fff","color":"#000","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	});
	$("._dddspan").each(function(){
		$(this).css("padding","0 "+(($(this).prev().width()-$(this).width())/2+10+1+3)+"px");
		console.log($(this).prev().width());
	})
}
/**
 * 
 * @param maxPage				总页数
 * @param nowPage				当前页
 * @param tagId					分页所在标签id值
 * @param onclickFunctionName	页码点击事件触发的方法名
 * @param pagesize				分页大小（忽略此参数时，默认值为5）
 */
function pagination1(maxPage,nowPage,tagId,onclickFunctionName,pagesize) {
if(!pagesize){
	pagesize = 5;
}
	if(maxPage<2){return;}
	if(nowPage<1 || nowPage>maxPage){
		showMessage("页码超出范围");
		return;
	}
	functionName = onclickFunctionName;
	var parentTag = $("#"+tagId);
	parentTag.empty();
	var pageDiv="";
	pageDiv += '<div id="pageDiv"><a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage-1)+')" href="javascript:;">上一页</a>';
	if(maxPage>pagesize+3){
		if(parseInt((nowPage-1)/pagesize) == 0){
			for(var i=1;i<=pagesize;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			pageDiv += '<span class="_dddspan">...</span>';
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+maxPage+')" href="javascript:;">'+maxPage+'</a>';
		//}else if(parseInt((nowPage-1)/pagesize) == parseInt(maxPage/pagesize)){
			//pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">1</a>';
			//pageDiv += '...';
			//for(i=parseInt(maxPage/pagesize)*pagesize+1;i<=maxPage;i++){	
			//	if(i==nowPage){
			//		pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			//	}else{
			//		pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			//	}
			//}
		}else if(parseInt((nowPage-1)/pagesize) == parseInt(maxPage/pagesize)){
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">1</a>';
			pageDiv += '<span class="_dddspan">...</span>';
			for (i=maxPage-pagesize-1;i<=maxPage;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}else {
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">1</a>';
			pageDiv += '<span class="_dddspan">...</span>';
			for (i=parseInt((nowPage-1)/pagesize)*pagesize+1;i<=parseInt((nowPage-1)/pagesize)*pagesize+pagesize;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			pageDiv += '<span class="_dddspan">...</span>';
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+maxPage+')" href="javascript:;">'+maxPage+'</a>';
		}
	}else{
		var i = 1;
		while (i <= maxPage) {
			if(i==nowPage){
				pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}else{
				pageDiv += '<a class = "a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage+1)+')" href="javascript:;">下一页</a><input id="page_tz" value="'+(maxPage/2).toFixed(0)+'" style="vertical-align:middle;border-radius: 3px;border: 1px solid #dfdfdf;padding: 5px 10px;width: 3em;font: inherit;text-align: center;"/> <a class="a_page" onclick="tiaozhuan()" href="javascript:;">跳转</a></div>';
	parentTag.append(pageDiv);
	$("#pageDiv").css({"user-select": "none","-webkit-user-select":"none","-moz-user-select":"none","-ms-user-select":"none"});
	$(".a_nowPage").css({"vertical-align":"middle","background":"#09F","color":"#FFF","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #09f","display":"inline-block","padding":"5px 10px"});
	$(".a_page").css({"vertical-align":"middle","color":"#000","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	$(".a_page").hover(function(){
		$(this).css({"vertical-align":"middle","background":"#09F","color":"#FFF","text-decoration":"none","border-radius":"3px","border":"1px solid #09F","display":"inline-block","padding":"5px 10px"});
	},function(){
		$(this).css({"vertical-align":"middle","background":"#fff","color":"#000","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	});
	$("._dddspan").each(function(){
		$(this).css("padding","0 "+(($(this).prev().width()-$(this).width())/2+10+1+3)+"px");
		console.log($(this).prev().width());
	})
}
/**
 * 
 * @param maxPage				总页数
 * @param nowPage				当前页
 * @param tagId					分页所在标签id值
 * @param onclickFunctionName	页码点击事件触发的方法名
 */
function pagination2(maxPage,nowPage,tagId,onclickFunctionName) {
	if(maxPage<2){return;}
	functionName = onclickFunctionName;
	var parentTag = $("#"+tagId);
	parentTag.empty();
	var pageDiv="";
	pageDiv += '<div id="pageDiv"><a class="a_page" onclick="'+onclickFunctionName+'(1)" href="javascript:;">首页</a> <a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage-1)+')" href="javascript:;"><</a>';
	if(maxPage>5){
		if(nowPage<=3){
			for(var i=1;i<4;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
			pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'(4)" href="javascript:;">4</a><a class = "a_page" onclick="'+onclickFunctionName+'(5)" href="javascript:;">5</a>...';
		}else if(nowPage>=4 && nowPage<=maxPage-3){
			pageDiv += '...<a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage-2)+')" href="javascript:;">'+(nowPage-2)+'</a><a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage-1)+')" href="javascript:;">'+(nowPage-1)+'</a>';
			pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+nowPage+'</a>';
			pageDiv += '<a class = "a_page" onclick="'+onclickFunctionName+'('+(nowPage+1)+')" href="javascript:;">'+(nowPage+1)+'</a><a class = "a_page" onclick="'+onclickFunctionName+'('+(nowPage+2)+')" href="javascript:;">'+(nowPage+2)+'</a>...';
		}else if(nowPage>maxPage-3){
			pageDiv += '...<a class="a_page" onclick="'+onclickFunctionName+'('+(maxPage-4)+')" href="javascript:;">'+(maxPage-4)+'</a><a class="a_page" onclick="'+onclickFunctionName+'('+(maxPage-3)+')" href="javascript:;">'+(maxPage-3)+'</a>';
			for(var i=maxPage-2;i<=maxPage;i++){
				if(i==nowPage){
					pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}else{
					pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
				}
			}
		}
	}else{
		var i = 1;
		while (i <= maxPage) {
			if(i==nowPage){
				pageDiv += '<a class = "a_nowPage" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}else{
				pageDiv += '<a class = "a_page" onclick="'+onclickFunctionName+'('+i+')" href="javascript:;">'+i+'</a>';
			}
			i++;
		}
	}
	pageDiv += '<a class="a_page" onclick="'+onclickFunctionName+'('+(nowPage+1)+')" href="javascript:;">></a><a class="a_page" onclick="'+onclickFunctionName+'('+maxPage+')" href="javascript:;">尾页</a> <input id="page_tz" value="'+(maxPage/2).toFixed(0)+'" style="vertical-align:middle;border-radius: 3px;border: 1px solid #dfdfdf;padding: 5px 10px;width: 3em;font: inherit;text-align: center;"/> <a class="a_page" onclick="tiaozhuan()" href="javascript:;">跳转</a></div>';
	parentTag.append(pageDiv);
	$("#pageDiv").css({"user-select": "none","-webkit-user-select":"none","-moz-user-select":"none","-ms-user-select":"none"});
	$(".a_nowPage").css({"vertical-align":"middle","background":"#09F","color":"#FFF","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #09f","display":"inline-block","padding":"5px 10px"});
	$(".a_page").css({"vertical-align":"middle","color":"#000","margin":"0 3px","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	$(".a_page").hover(function(){
		$(this).css({"vertical-align":"middle","background":"#09F","color":"#FFF","text-decoration":"none","border-radius":"3px","border":"1px solid #09F","display":"inline-block","padding":"5px 10px"});
	},function(){
		$(this).css({"vertical-align":"middle","background":"#fff","color":"#000","text-decoration":"none","border-radius":"3px","border":"1px solid #dfdfdf","display":"inline-block","padding":"5px 10px"});
	});
}
function tiaozhuan() {
	$("#tzTemp").remove();
	var parentTag = $("#pageDiv");
	var tzTemp = '<a id="tzTemp" onclick="'+functionName+'('+$("#page_tz").val()+')" href="javascript:;" style="display:none;"></a>';
	parentTag.append(tzTemp);
	$("#tzTemp").click(); 
}
/////////分页 end////////////////////////////////

/////////加载动画 start////////////////////////////////
/**
 * 显示加载动画
 * @param imgUrl	动画图片路径（以“/”开头的路径）
 */
function showLoadingImg(imgUrl) {
	var w = window.innerWidth;
	var h = window.innerHeight;;
	if($("#jiml_loadingAnimation").length==0){
		var imgTag = document.createElement('img'); 
		imgTag.setAttribute("id", "jiml_loadingAnimation");
		$("body:first").append(imgTag);
	}
	$("#jiml_loadingAnimation").attr("src", imgUrl);
	var imgH = $("#jiml_loadingAnimation").width();
	var imgW = $("#jiml_loadingAnimation").height();
	$("#jiml_loadingAnimation").css({"position":"fixed", "top":(h/2-imgH/2)+"px", "left":(w/2-imgW/2)+"px", "z-index":"9999999"});
	$("#jiml_loadingAnimation").show();
}
/**
 * 隐藏加载动画
 */
function hideLoadingImg() {
	$("#jiml_loadingAnimation").hide();
}
/////////加载动画 end////////////////////////////////

/////////显示提示信息 start////////////////////////////////
/**
 * 短暂显示提示信息（队列显示）
 * @param message	提示内容
 */
var messageArray = new Array();
var myInterval;
var showEnd = true;//队列显示时，当前消息是否已显示完成。
function queueShowMessage(message){
	messageArray.unshift(message);
	if(messageArray.length==1){
		myInterval = setInterval(
			function(){
				if(showEnd){
					if(messageArray.length==0){
						clearInterval(myInterval);
						return;
					}
					showMessage(messageArray.pop());
					showEnd = false;
				}
			}
			,1
		);
	}
}
/**
 * 短暂显示提示信息（及时显示）
 * @param message	提示内容
 */
var myTimeout;
var time1 = 1500;
var time2 = 500;
function showMessage(message) {
	var w = window.innerWidth;
	var h = window.innerHeight;
	var messageLength = message.length;
	if($("#jiml_showMessage").length==0){
		var messageDiv = document.createElement('div'); 
		messageDiv.setAttribute("id", "jiml_showMessage");
		$("body:first").append(messageDiv);
	}
	$("#jiml_showMessage").css({"background-color":"rgba(0, 153, 255, 0.42)","color":"white","border-radius":"5px","position":"fixed","font-size":"20px","line-higth":"30px","top":"1.5px","left":(w/2-messageLength*10)+"px","padding":"5px","z-index":"999999999", "display":"none"});
	$("#jiml_showMessage").html(message);
	$("#jiml_showMessage").fadeIn(time2);
	clearTimeout(myTimeout);
	myTimeout = setTimeout(
					function(){
						$("#jiml_showMessage").fadeOut(time2);
						setTimeout("showEnd = true",time2);//队列显示时使用的标志。
					}
					,time1
				);
}
/////////显示提示信息 end////////////////////////////////