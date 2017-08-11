//页面高度大于110的时候，头部变成固定定位

window.onscroll=function(){
var headNav=document.querySelector(".head-nav-box");
var sTop = document.documentElement.scrollTop==0?document.body:document.documentElement;
var STop=sTop.scrollTop;
	if (STop>110) {
		headNav.className="head-nav-box navBH"
	}else{
		headNav.className='head-nav-box'
	}
}



//收藏页面
function AddFavorite(sURL, sTitle)
{	
    try
    {
        window.external.addFavorite(sURL, sTitle);
    }
    catch (e)
    {
        try
        {
            window.sidebar.addPanel(sTitle, sURL, "");
        }
        catch (e)
        {
            alert("加入收藏失败，请使用Ctrl D进行添加");
        }
    }
}
