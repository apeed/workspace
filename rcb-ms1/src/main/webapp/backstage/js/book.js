$(function(){
    	loadBook(1);
    	// 获取参数userId
		var userId=getCookie("userId");
});
var now_page=1;
var max_page=1;
function del(id){
	if(confirm("您确定要删除吗?")){
		$.ajax({
			url : "book/delBook.do",
			type : "post",
			data : {
				"id" : id,
				"now_page" : now_page
			},
			dataType : "json",
			success : function(result) {
				alert("删除成功!!!");
				max_page = result.message;
				if(now_page > max_page){now_page = max_page;}
				reload(result.data);
			},
			error : function() {
				alert("删除失败!!!");
			}
		});
	}
}

function dels(id){
	//var formData = $("input[name='id']");
	$.ajax({
		url : "book/delBooks.do",
		type : "post",
		data :/*formData*/{
				"id":id,
				"now_page" : now_page
		},
		traditional :true,
		dataType : "json",
		success : function(result) {
			alert("删除成功!!!");
			max_page = result.message;
			if(now_page > max_page){now_page = max_page;}
			reload(result.data);
		},
		error : function() {
			alert("删除失败!!!");
		}
	});
}

/*$("#checkall").click(function(){
  $("input[name='id']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
});*/
function checkAll() {
	$("input[name='id']").each(function(){
		  if (this.checked) {
			  this.checked = false;
		  }
		  else {
			  this.checked = true;
		  }
	  });
}
function DelSelect(){
	var Checkbox=false;
	//var id;
	var dropIds = new Array();
	 $("input[name='id']").each(function(){
		 dropIds.push($(this).val());
		 //id+="id="+$(this).val()+"&";
		 //alert($(this).val());
		 
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==true){ dels(dropIds);}
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
function tiaozhuan(){
	var page = new Number($("#page_tz").val());
	loadBook(page);
}
function loadBook(page) {
	if(page <= 0 || page > max_page){return;}
	now_page=page;
	$.ajax({
		url : "book/loadBook.do",
		type : "post",
		data : {
			"page" : page,
		},
		dataType : "json",
		success : function(result) {
			max_page = result.message;
			reload(result.data);
		},
		error : function() {
			alert("失败!!!");
			reload(result.data);
		}
	});
}
function reload(json) {
	var booktable = $("#booktable");
	booktable.empty();
	var books = '<tr><th width="120">ID</th><th>姓名</th><th>电话</th><th width="30%">内容</th><th width="120">留言时间</th><th>操作</th></tr>';
	for (var i = 0; i < json.length; i++) {
		var book = json[i];
		var id = book.id;
		books += "<tr>";
		books += '<td><input type="checkbox" name="id" value="'+id+'" />'+id+'</td>';
		books += '<td>'+book.name+'</td>';
		books += '<td>'+book.tel+'</td>';
		books += '<td><span style="width:200px;display:inline-block;text-overflow:ellipsis;overflow:hidden;">'+book.content+'</span></td>';
		books += '<td>'+new Date(book.creatTime).format('MM-dd hh:mm')+'</td>';
		books += '<td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="del('+id+')"><span class="icon-trash-o"></span> 删除</a>';
		books += '<a class="button border-yellow" href="leavemessage/more.do?id='+id+'"><span class="icon-plus-square-o"></span>查看更多</a>';
		books += '</div></td>';
		books += '</tr>';
	}
	books += '<tr id = "page_tr">';
	books += '<td colspan="8"><div class="pagelist"><a class="bookpage" onclick="loadBook(1)">首页</a> <a class="bookpage" onclick="loadBook('+(now_page-1)+')"><</a>';
	
	if(max_page>5){
		if(now_page<=3){
			books += '<a class="bookpage" onclick="loadBook(1)">1</a><a class="bookpage" onclick="loadBook(2)">2</a><a class="bookpage" onclick="loadBook(3)">3</a><a class="bookpage" onclick="loadBook(4)">4</a><a class = "bookpage" onclick="loadBook(5)">5</a>...';
		}else if(now_page>=4 && now_page<=max_page-3){
			books += '...<a class="bookpage" onclick="loadBook('+(now_page-2)+')">'+(now_page-2)+'</a><a class="bookpage" onclick="loadBook('+(now_page-1)+')">'+(now_page-1)+'</a>';
			books += '<a class="bookpage" onclick="loadBook('+now_page+')">'+now_page+'</a>';
			books += '<a class = "bookpage" onclick="loadBook('+(now_page+1)+')">'+(now_page+1)+'</a><a class = "bookpage" onclick="loadBook('+(now_page+2)+')">'+(now_page+2)+'</a>...';
		}else if(now_page>max_page-3){
			books += '...<a class="bookpage" onclick="loadBook('+(max_page-4)+')">'+(max_page-4)+'</a><a class="bookpage" onclick="loadBook('+(max_page-3)+')">'+(max_page-3)+'</a><a class="bookpage" onclick="loadBook('+(max_page-2)+')">'+(max_page-2)+'</a><a class="bookpage" onclick="loadBook('+(max_page-1)+')">'+(max_page-1)+'</a><a class = "bookpage" onclick="loadBook('+max_page+')">'+max_page+'</a>';
		}
	}else{
		var i = 1;
		while (i <= max_page) {
			if(i==1){
				books += '<a class="bookpage" onclick="loadBook(1)">1</a>';
			}else{
				books += '<a class = "bookpage" onclick="loadBook('+i+')">'+i+'</a>';
			}
			i++;
		}
	}
	
	books += '<a class="bookpage" onclick="loadBook('+(now_page+1)+')">></a><a class="bookpage" onclick="loadBook('+max_page+')">尾页</a> <input id="page_tz" style="border-radius: 3px;border: 1px solid #dfdfdf;width: 3em; height: 28px;"/> <a class="bookpage" onclick="tiaozhuan()">跳转</a></div></td>';
	books += '</tr>';
	booktable.append(books);
	$(".bookpage:contains('"+now_page+"')").addClass("now_page");
}
Date.prototype.format = function(format) {
    var date = {
           "M+": this.getMonth() + 1,
           "d+": this.getDate(),
           "h+": this.getHours(),
           "m+": this.getMinutes(),
           "s+": this.getSeconds(),
           "q+": Math.floor((this.getMonth() + 3) / 3),
           "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
           format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
           if (new RegExp("(" + k + ")").test(format)) {
                  format = format.replace(RegExp.$1, RegExp.$1.length == 1
                         ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
           }
    }
    return format;
}