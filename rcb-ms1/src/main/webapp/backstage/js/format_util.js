//是否加0
function add0(m){
	return m<10?'0'+m:m 
}
//时间戳转换为指定格式
function format(timestamp){
	//shijianchuo是整数，否则要parseInt转换
	var time = new Date(timestamp);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}