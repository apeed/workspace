$(function(){
    // 订单点击效果
    var search_btn=$('.search_btn');
    var search_text=$('.search_text');
    var search_alert=$('.search_alert');
    search_btn.click(function(){
        if(search_text.children('textarea').val()==''){
            search_alert.html("不能为空");
            search_alert.css("bottom",0);
            setTimeout(function(){
                search_alert.css("bottom","-100%");
            },3000)
        }else{
            var str=/^(\d{1,2}|[a-zA-Z]{1,2})\d+$/;
            if (str.test(search_text.children('textarea').val())){
                //search_alert.html("跳转查询页面接口");
                search(search_text.children('textarea').val().trim());
            }else{
                search_alert.html("输入错误");
                search_alert.css("bottom",0);
                setTimeout(function(){
                    search_alert.css("bottom","-100%");
                },3000)
            }
        }
    })
});
//轮播图效果
var banner_tu=$(".banner_tu");
var banner_btn=$('.banner_btn');
var num=0;
banner_tu[0].style.zIndex=2;
for (var i = banner_btn.length - 1; i >= 0; i--) {
    banner_btn[i].index=i;
    banner_btn[i].onclick=function(){
        for (var j = banner_tu.length - 1; j >= 0; j--) {
            banner_tu[j].style.zIndex=0;
            banner_btn[j].className="banner_btn";
        };
        banner_tu[this.index].style.zIndex=2;
        banner_btn[this.index].className="banner_btn active";
        num=this.index;
    }
};
var t=setInterval(move,3000)
function move(){
    num++;
    if (num>=banner_tu.length) {
        num=0;
    };
    for (var i = banner_tu.length - 1; i >= 0; i--) {
        banner_tu[i].style.zIndex=0;
        banner_btn[i].className="banner_btn";
    };
    banner_tu[num].style.zIndex=2;
    banner_btn[num].className="banner_btn active";
}
for (var i = banner_tu.length - 1; i >= 0; i--) {
    banner_tu[i].onmouseover=function(){
        clearInterval(t)
    }
    banner_tu[i].onmouseout=function(){
        t=setInterval(move,3000)
    }
};
