var text_block=$(".text_block")
var picture_block=$(".picture_block")
var selectCid=$("select[name='twocid']");
if (selectCid.val()=="1") {
	picture_block.css("display","none")
	text_block.css("display","block")
}
selectCid.change(function(){
	if (selectCid.val()=="1") {
		picture_block.css("display","none")
		text_block.css("display","block")
	}else if (selectCid.val()=="2") {
		text_block.css("display","none")
		picture_block.css("display","block")
	}else if (selectCid.val()=="3") {
		text_block.css("display","none")
		picture_block.css("display","block")
	};
})
