var fukuancit=$("select[name='fukuancit']");
var indent_del_button=$(".indent_del_button");
var indent_tkcl=$(".indent_tkcl");
var indent_xg=$(".indent_xg");
var indent_bz=$(".indent_bz");
var indent_fh=$(".indent_fh");
var indent_fh_qx=$(".indent_fh_qx");
var indent_fh_box=$(".indent_fh_box");
var indent_bz_box=$(".indent_bz_box");
var indent_bz_qx=$(".indent_bz_qx")

if (fukuancit.val()=="1") {
	indent_del_button.css("display","");
	indent_tkcl.css("display","none");
	indent_xg.css("display","");
	indent_bz.css("display","none");
	indent_fh.css("display","none");
}else if(fukuancit.val()=="2"){
	indent_del_button.css("display","none");
	indent_tkcl.css("display","none");
	indent_xg.css("display","");
	indent_bz.css("display","none");
	indent_fh.css("display","");
}else if(fukuancit.val()=="3"){
	indent_del_button.css("display","none");
	indent_tkcl.css("display","none");
	indent_xg.css("display","none");
	indent_bz.css("display","");
	indent_fh.css("display","none");
}else if(fukuancit.val()=="4"){
	indent_del_button.css("display","none");
	indent_tkcl.css("display","none");
	indent_xg.css("display","none");
	indent_bz.css("display","");
	indent_fh.css("display","none");
}else if(fukuancit.val()=="5"){
	indent_del_button.css("display","none");
	indent_tkcl.css("display","");
	indent_xg.css("display","none");
	indent_bz.css("display","");
	indent_fh.css("display","none");
}else if(fukuancit.val()=="6"){
	indent_del_button.css("display","none");
	indent_tkcl.css("display","none");
	indent_xg.css("display","none");
	indent_bz.css("display","");
	indent_fh.css("display","none");
}
fukuancit.change(function(){
	if (fukuancit.val()=="1") {
		indent_del_button.css("display","");
		indent_tkcl.css("display","none");
		indent_xg.css("display","");
		indent_bz.css("display","none");
		indent_fh.css("display","none");
	}else if(fukuancit.val()=="2"){
		indent_del_button.css("display","none");
		indent_tkcl.css("display","none");
		indent_xg.css("display","");
		indent_bz.css("display","none");
		indent_fh.css("display","");
	}else if(fukuancit.val()=="3"){
		indent_del_button.css("display","none");
		indent_tkcl.css("display","none");
		indent_xg.css("display","none");
		indent_bz.css("display","");
		indent_fh.css("display","none");
	}else if(fukuancit.val()=="4"){
		indent_del_button.css("display","none");
		indent_tkcl.css("display","none");
		indent_xg.css("display","none");
		indent_bz.css("display","");
		indent_fh.css("display","none");
	}else if(fukuancit.val()=="5"){
		indent_del_button.css("display","none");
		indent_tkcl.css("display","");
		indent_xg.css("display","none");
		indent_bz.css("display","");
		indent_fh.css("display","none");
	}else if(fukuancit.val()=="6"){
		indent_del_button.css("display","none");
		indent_tkcl.css("display","none");
		indent_xg.css("display","none");
		indent_bz.css("display","");
		indent_fh.css("display","none");
	}
})

indent_fh.click(function(){
	$(this).next().css("display","block")
})
indent_fh_qx.click(function(){
	indent_fh_box.css("display","none");
})
indent_bz.click(function(){
	$(this).next().css("display","block")
})
indent_bz_qx.click(function(){
	indent_bz_box.css("display","none");
})