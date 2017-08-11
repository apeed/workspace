	var flag=true;
    $(function(){
    	loadMedia(1);
		$("#checkall").click(function(){ 
		  if(flag){
		      flag=false;
		      $('tr').find('input').prop('checked',true);
		  }else{
		    flag=true;
		      $('tr').find('input').prop('checked',false);
		  }
		})
	})
	
	// 内容页列表推荐位
	function recommendBtn(){
    	$(".recommend_box").css("display","block");
	}
	function recommendDel(){
		$(".recommend_box").css("display","none");
	}


	var nowPage = 0;
	var maxPage = 1;
	function loadMedia(page) {
		if(page<1 || page>maxPage){return;}
		$.ajax({
			url:"/admin/content/loadmedia.do",
			type:"post",
			data:{"page":page},
			dataType:"json",
			success : function(result) {
				maxPage = result.mediaInfoMaxPage;
				if(page>maxPage){page = maxPage;}
				if (maxPage != 0){
					nowPage = page;
					reloadTable(result);
					pagination(maxPage,page,"pageTd","loadMedia");
				}
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
 	        str+='<td><button class="button border-main recommend_btn" onclick="recommendBtn()">归类到</button></td>';
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
