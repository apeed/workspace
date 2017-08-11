<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
    <script src="/admin/jxb/js/jiml-utils.js"></script>
    <script src="/admin/jxb/js/column/content_media-column.js"></script>
    <script type="text/javascript">
    $(function(){
    	loadMedia(1);
	})
	
	// 内容页列表推荐位
	function recommendDel(){
		$(".recommend_box").css("display","none");
	}
	
	
   	var blockChannelId = -1;
   	var nowPage = 0;
   	var maxPage = 1;
   	function loadMedia(page) {
   		if(page<1 || page>maxPage && maxPage!=0){return;}
   		var data = "&page="+page;
   		if($("#keyword").val().trim()){
	   		data+="&keyword="+$("#keyword").val();
   		}
   		if(blockChannelId!=-1){
	   		data+="&blockChannelId="+blockChannelId;
   		}
   		$.ajax({
   			url:"/admin/content/loadmedia.do",
   			type:"post",
   			data:data,
   			dataType:"json",
   			success : function(result) {
   				maxPage = result.mediaInfoMaxPage;
   				if(page>maxPage){page = maxPage;}
   				
   					nowPage = page;
   					reloadTable(result);
   					pagination(maxPage,page,"pageTd","loadMedia");
   			},
   			error : function(data) {
   				showMessage("内容加载失败，请刷新重试。");
   			}
   		});
   	}
   	function reloadTable(data){
		$(".jxb_removeTr").remove();
 		for(var i = 0;i<data.mediaInfo.length;i++){
 			
 			var mi = data.mediaInfo[i];
 			
 			var str='<tr class="jxb_removeTr">';
 			str+='<td><input type="checkbox" name="id" value="'+mi.id+'"/>'+mi.id+'</td>';
 			str+='<td>'+mi.mediaName+'</td>';
 			var type = mi.mediaType;
 			
 			type==1?
 			str+='<td class="img_td" title="点击预览"><img src="'+mi.mediaUrl+'" alt="" width="80" height="50" /></td>'
				:type==2?
 			str+='<td class="img_td" title="点击预览"><img src="'+mi.iconUrl+'" alt="" width="80" height="50" /></td>'
 			:str+='<td class="img_td">其他</td>'
 			
 	        str+='<td>'+(type==1?"图片":type==2?"视频":"其他")+'</td>';
 	        str+='<td>'+(!mi.note?"":mi.note)+'</td>';
 	        str+='<td>'+new Date(mi.gmtModified).format("yyyy-MM-dd hh:mm:ss")+'</td>';
 	        str+='<td><button class="button border-main recommend_btn" onclick="recommendBtn(0,'+mi.id+')" type="button">归类到</button></td>';
 	        str+='<td>';
 	          str+='<div class="button-group"> ';
 	        	str+='<a class="button border-main" href="/admin/content/modifymedia.do?id='+mi.id+'"><span class="icon-edit"></span> 修改</a>';
 	        	str+='<a class="button border-red" href="javascript:void(0)" onclick="del('+mi.id+')"><span class="icon-trash-o"></span> 删除</a>';
 	       	  str+='</div>';
 	        str+='</td>';
 	        str+='</tr>';
 			$("#reloadTable").append(str);
		}
		$("#reloadTable").append('<tr class="jxb_removeTr"><td colspan="8" id="pageTd"></td></tr>');
		var td_img=$(".img_td>img");
		var img_content_img=$(".img_content>img");
		var img_content=$(".img_content");
		var img_alert=$(".img_alert");
		var img_del=$(".img_del");
		td_img.click(function(){
			img_alert.css("display","block");
			var imgsrc=$(this).attr("src");
			img_content_img.attr('src',imgsrc);
			img_content.width(img_content_img.width());
		})
		img_del.click(function(){
			img_alert.css("display","none");
		})
	}
   	function del(id){
   	  if(confirm("您确定要删除吗?")){
   		var data;
   		if(id==-1){
			data = new FormData($("#subForm")[0]);
     		data.append("page",nowPage);
   		}else{
   			data = new FormData();
   			data.append("id",id);
   			data.append("page",nowPage);
   		}
   		$.ajax({
   			url:"/admin/content/deletemedia.do",
   			type:"post",
   			data:data,
   			async: false,
   	        cache: false,  
   	        contentType: false,  
   	        processData: false,
   			dataType:"json",
   			success : function(result) {
	   			queueShowMessage("成功删除"+result.message+"条记录");
	   		flag=true;
   				maxPage = result.mediaInfoMaxPage;
   				if(nowPage>maxPage){nowPage = maxPage;}
   				if (maxPage != 0){
   					reloadTable(result);
   					pagination(maxPage,nowPage,"pageTd","loadMedia");
   				}else{
   					$(".jxb_removeTr").remove();
   				}
   			},
   			error : function(data) {
   				showMessage("内容加载失败，请刷新重试。");
   			}
   		});
   	  }
   	}
   	
   	var GLTypeTemp;//批量归类/单独归类
	var idTemp;//单独归类时的内容id
   	function guilei() {
   		var data;
  		data = new FormData($("#subForms")[0]);
   		if(GLTypeTemp == 0){//单独归类
   			data.append("id",idTemp);
   		}else if(GLTypeTemp == 1){//批量归类
   			idTemp = new Array();
   			$("input[name=id]:checked").each(function(){
   				data.append("id",$(this).val());
   	   		});
   		}
   		$.ajax({
   			url:"/admin/content/contentguilei.do",
   			type:"post",
   			data:data,
   			async: false,
   	        cache: false,  
   	        contentType: false,  
   	        processData: false,
   			dataType:"json",
   			success : function(result) {
   				if(result==-1){
	   				queueShowMessage("归类失败，有重复归类");
					return;   					
   				}
	   			queueShowMessage("成功归类"+result+"条记录");
   				
   			},
   			error : function(data) {
   				showMessage("归类失败。");
   			}
   		});
	}
</script>
</head>
<body style="position:relative;">
  <div id="listform">
    <div class="panel admin-panel">
      <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
      <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
          <li> <a class="button border-main icon-plus-square-o" href="/admin/content/addmedia.do"> 添加内容</a> </li>
          <li>
            <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
            <button type="button" class="button border-red" onclick="del(-1)"><span class="icon-trash-o"></span> 批量删除</button>
            <button type="button" class="button border-black  recommend_btn" onclick="recommendBtn(1,-1)"> 批量归类</button>
          </li>
          <li>
            <div class="change_column_inner" style="width:100px;">
              <div class="change_column">选择分类</div>
              <ul class="change_column_box">
                <li class="change_column_fu">
                  <ol>
                    <li>选择</li>
                    <li>栏目名称</li>
                  </ol>
                </li>
                <li class="change_column_fu">
                  <ol class="xiala_box">
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                  <div>
                    <ol class="xiala_box">
                      <li>1</li>
                      <li style="padding-left: 30px;">├─公司简介</li>
                    </ol>
                    <div>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">├─公司简介</li>
                      </ol>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">└─公司简介</li>
                      </ol>
                    </div>
                    <ol class="xiala_box">
                      <li>1</li>
                      <li style="padding-left: 30px;">└─公司简介</li>
                    </ol>
                    <div>
                      <ol class="xiala_box">
                        <li>1</li>
                        <li style="padding-left: 60px;">└─公司简介</li>
                      </ol>
                    </div>
                  </div>
                  <ol class="xiala_box">
                    <li>1</li>
                    <li>公司简介</li>
                  </ol>
                </li>
                <li style="margin-bottom:10px;" class="change_column_fu">
                  <button class="button border-black change_column_del" style="margin-left:10px;">提交</button>
                  <button class="button border-black change_column_del" style="margin-left:10px;">取消</button>
                </li>
              </ul>
            </div>
          </li>
          <li>
            <input type="text" placeholder="可输入内容页标题/子标题/作者/详情/简介/标签/备注信息" id="keyword" class="input" style="width:400px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" class="button border-main icon-search" onclick="loadMedia(1)" > 搜索</a></li>
        </ul>
      </div>
      		<form id="subForm">
	      <table class="table table-hover text-center" id="reloadTable">
	        <tr>
	          <th>序号</th>
	          <th>名称</th>
	          <th>多媒体图片(点击预览)</th>
	          <th>内容类型</th>
	          <th>备注</th>
	          <th width="10%">创建时间</th>
	          <th>推荐</th>
	          <th width="180">操作</th>
        	</tr>
	      </table>
      		</form>
    </div>
  </div>
<!-- 推荐到 -->
  <div class="recommend_box">
    <div class="recommend_content">
      		<form id="subForms">
      <div class="recommend_del" onclick="recommendDel()">×</div>
      <h3>归类到：</h3>
      <ul class="recommend">
        <li class="change_column_fu">
          <ol>
            <li>选择</li>
            <li>栏目名称</li>
          </ol>
        </li>
        <li class="change_column_fu">
          <ol>
            <li><input type="checkbox"></li>
            <li>公司简介</li>
          </ol>
          <div>
            <ol>
              <li><input type="checkbox"></li>
              <li style="padding-left: 30px;">├─公司简介</li>
            </ol>
            <div>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">├─公司简介</li>
              </ol>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">└─公司简介</li>
              </ol>
            </div>
            <ol>
              <li><input type="checkbox"></li>
              <li style="padding-left: 30px;">└─公司简介</li>
            </ol>
            <div>
              <ol>
                <li><input type="checkbox"></li>
                <li style="padding-left: 60px;">└─公司简介</li>
              </ol>
            </div>
          </div>
          <ol>
            <li><input type="checkbox"></li>
            <li>公司简介</li>
          </ol>
        </li>
      </ul>
      </form>
      <div class="recommend_tj">
        <button class="button border-main"style="margin-right: 50px;" onclick="guilei()"><span class="icon-print"></span> 确定</button> 
      </div>
    </div>
  </div>
<script>

var flag=true;
$("#checkall").click(function(){ 
  if(flag){
      flag=false;
      $('tr').find('input').prop('checked',true);
  }else{
    flag=true;
      $('tr').find('input').prop('checked',false);
  }
})
</script>
<!-- 图片放大弹出 -->
  <div class="img_alert">
    <div class="img_content">
      <div class="img_del">×</div>
      <img src="" alt="">
    </div>
  </div>
</body>
<!-- <script src="/admin/js/img_td.js"></script> -->
<script src="/admin/js/alert_box.js"></script>

</html>