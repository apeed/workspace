var pmx=document.querySelectorAll(".pmx a");
var a_leader_txt=document.querySelector("#a_leader_txt");
var pmx_index=document.querySelector(".pmx_index");
for (var i = pmx.length - 1; i >= 0; i--) {
	pmx[i].index=i;
	pmx[i].onclick=function(){
		a_leader_txt.innerText=this.innerText;
		a_leader_txt.href=this.href;
	}
};
pmx_index.onclick=function(){
	a_leader_txt.innerText="欢迎来到融成后台管理系统";
}


var click_h3=document.querySelector(".click_h3");
var threeNav=document.querySelector(".threeNav");
var flag=true;
threeNav.style.height="32px";
threeNav.style.overflow="hidden";
click_h3.onclick=function(){
	if (flag) {
		threeNav.style.height="";
		
		flag=false;
	}else{
		threeNav.style.height="32px";
		flag=true;
	}
}