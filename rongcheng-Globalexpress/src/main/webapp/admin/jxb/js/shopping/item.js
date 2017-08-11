    $(function(){
    	loadData(1);
	})
	
	// 内容页列表推荐位
	function recommendDel(){
		$(".recommend_box").css("display","none");
	}
	
	
   	var blockChannelId = -1;
   	var nowPage = 0;
   	var maxPage = 1;
   	function loadData(page) {
   		if(page<1 || page>maxPage && maxPage!=0){return;}
   		var data = "&page="+page;
   		if($("#keyword").val().trim()){
	   		data+="&keyword="+$("#keyword").val();
   		}
   		if(blockChannelId!=-1){
	   		data+="&blockChannelId="+blockChannelId;
   		}
   		$.ajax({
   			url:"/admin/item/loaditem.do",
   			type:"post",
   			data:data,
   			dataType:"json",
   			success : function(result) {
   				maxPage = result.maxPage;
   				if(page>maxPage){page = maxPage;}
   				
   					nowPage = page;
   					reloadTable(result);
   					pagination(maxPage,page,"pageTd","loadData");
   			},
   			error : function(data) {
   				showMessage("内容加载失败，请刷新重试。");
   			}
   		});
   	}
   	function reloadTable(data){
		$(".jxb_removeTr").remove();
		var iiLength = data.itemInfoList.length;
		var itemInfoList = data.itemInfoList;
 		for(var i = 0;i<iiLength;i++){
 			
 			var itemInfo = itemInfoList[i];
 			
 			var str='<tr class="jxb_removeTr">';
 			str+='<td><input type="checkbox" name="id" value="'+itemInfo.id+'"/>'+(!itemInfo.userSequence?"":itemInfo.userSequence)+'</td>';
 			str+='<td>'+(!itemInfo.id?"":itemInfo.id)+'</td>';
 			str+='<td>'+(!itemInfo.itemName?"":itemInfo.itemName)+'</td>';
 			str+='<td class="img_td" title="点击预览"><img src="'+(!itemInfo.itemImage1?"":itemInfo.itemImage1)+'" alt="" width="80" height="50" /></td>'
 			
 			var type = itemInfo.itemType;
 	        str+='<td>'+(type==1?"上架在售商品":type==2?"仓库下架商品":"未知")+'</td>';
 	        
 	        str+='<td>'+(!itemInfo.itemColor?"":itemInfo.itemColor)+(!itemInfo.itemSize?"":itemInfo.itemSize)+'</td>';
 	        str+='<td>'+(!itemInfo.barCode?"":itemInfo.barCode)+'</td>';
 	        str+='<td>'+(!itemInfo.normalPrice?"":"￥"+itemInfo.normalPrice)+'</td>';
 	        str+='<td>'+(!itemInfo.stockQuantity?"":itemInfo.stockQuantity)+'</td>';
 	        
 	        str+='<td><button class="button border-main recommend_btn" onclick="openGuilei(0,'+itemInfo.id+')" type="button">归类到</button></td>';
 	        str+='<td>';
 	          str+='<div class="button-group"> ';
 	        	str+='<a class="button border-main" href="/admin/item/modifyitem.do?id='+itemInfo.id+'"><span class="icon-edit"></span> 修改</a>';
 	        	str+='<a class="button border-red" href="javascript:void(0)" onclick="del('+itemInfo.id+')"><span class="icon-trash-o"></span> 删除</a>';
 	       	  str+='</div>';
 	        str+='</td>';
 	        str+='</tr>';
 			$("#reloadTable").append(str);
		}
		$("#reloadTable").append('<tr class="jxb_removeTr"><td colspan="11" id="pageTd"></td></tr>');
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
   			url:"/admin/item/delete.do",
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
   				maxPage = result.maxPage;
   				if(nowPage>maxPage){nowPage = maxPage;}
   				if (maxPage != 0){
   					reloadTable(result);
   					pagination(maxPage,nowPage,"pageTd","loadData");
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
   	
   	var GLTypeTemp;//批量归类1/单独归类0
	var idTemp;//单独归类时的内容id，批量时为-1
	var contentType = 4;//内容类型，1：页面内容，23：媒体内容，4：商品内容
	var piLiangGuiLeiTypeTemp;//批量归类时的标志，1归类，2删除归类
   	function guilei() {
   		var data;
  		data = new FormData($("#subForms")[0]);
  		data.append("contentType",contentType);
   		if(GLTypeTemp == 0){//单独归类
   			data.append("id",idTemp);
   		}else if(GLTypeTemp == 1){//批量归类
   			data.append("piLiangGuiLeiType",piLiangGuiLeiTypeTemp);
   			idTemp = new Array();
   			$("input[name=id]:checked").each(function(){
   				data.append("id",$(this).val());
   	   		});
   		}
   		$.ajax({
   			url:"/admin/item/itemguilei.do",
   			type:"post",
   			data:data,
   			async: false,
   	        cache: false,  
   	        contentType: false,  
   	        processData: false,
   			dataType:"json",
   			success : function(result) {
   				recommendDel();
   				if(result==-1){
	   				queueShowMessage("归类失败");
					return;   					
   				}
	   			queueShowMessage("更新成功");
   			},
   			error : function(data) {
   				recommendDel();
   				showMessage("更新失败，或系统异常。");
   			}
   		});
	}
	//单独归类时，此条内容所在归类id
	var blockIdList = {};
   	function selectGuilei() {
   		data = new FormData();
   		data.append("contentId",idTemp);
   		data.append("contentType",contentType);
   		$.ajax({
   			url:"/admin/content/selectcontentguilei.do",
   			type:"post",
   			data:data,
   			async: false,
   	        cache: false,  
   	        contentType: false,  
   	        processData: false,
   			dataType:"json",
   			success : function(result) {
   				blockIdList = result;
   			},
   			error : function(data) {
   				showMessage("查询归类失败。");
   			}
   		});
   	}
   	function openGuilei(GLTypeTemp,contentId) {
   		recommendBtn(GLTypeTemp,contentId);
   		selectGuilei();
	}