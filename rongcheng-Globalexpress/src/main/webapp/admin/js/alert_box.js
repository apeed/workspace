var checkcolumn=document.querySelectorAll(".checkcolumn");
for (var i = checkcolumn.length - 1; i >= 0; i--) {
	checkcolumn[i].index=i;
	checkcolumn[i].onclick=function(){
		for (var j = checkcolumn.length - 1; j >= 0; j--) {
			checkcolumn[j].checked=false;
		};
		checkcolumn[this.index].checked=true;
	}
};

var change_column=$(".change_column");
var change_column_box=$(".change_column_box");
var change_column_del=$(".change_column_del");
change_column.click(function(){
	change_column_box.css("display","block");
})
change_column_del.click(function(){
	setTimeout(function(){
		change_column_box.css("display","");
	},0)
})
var xiala_box=document.querySelectorAll(".xiala_box")
for (var i = xiala_box.length - 1; i >= 0; i--) {
	xiala_box[i].index=i;
	xiala_box[i].style.cursor="pointer";
	xiala_box[i].onmouseover=function(){
		for (var j=xiala_box.length-1;j>=0;j--){
			xiala_box[j].style.background="";
		}
		xiala_box[this.index].style.background="#f4f4f4";
	}
};