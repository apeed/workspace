$(function(){
    // 订单点击效果
    var search_btn=$('.search_button');
    var search_text=$('.search_input');
    var search_alert=$('.search_alert');
    var content=$('.content');
    var jiaz=$('.jiaz');
    search_btn.click(function(){
        if(search_text.children('input').val()==''){
            search_alert.html("不能为空");
            search_alert.css("top",0);
            setTimeout(function(){
                search_alert.css("top","-100%");
            },3000)
        }else{
            var str=/^(\d{1,2}|[a-zA-Z]{1,2})\d+$/;
            if (str.test(search_text.children('input').val())){
                jiaz.css('display','block');
                /* setTimeout(function(){
                    jiaz.css('display','none');
                    content.css('display','block');
                },2000)*/
                search(search_text.children('input').val().trim());
            }else{
                search_alert.html("输入错误");
                search_alert.css("top",0);
                setTimeout(function(){
                    search_alert.css("top","-100%");
                },3000)
            }
        }
    })
    search_text.children('input').keyup(function(e){
        var event=e||window.event;
        if (event.keyCode == 13) {
            if(search_text.children('input').val()==''){
                search_alert.html("不能为空");
                search_alert.css("top",0);
                setTimeout(function(){
                    search_alert.css("top","-100%");
                },3000)
            }else{
                var str=/^(\d{1,2}|[a-zA-Z]{1,2})\d+$/;
                if (str.test(search_text.children('input').val())){
                    jiaz.css('display','block');
                    /* setTimeout(function(){
	                    jiaz.css('display','none');
	                    content.css('display','block');
	                },2000)*/
	                search(search_text.children('input').val().trim());
                }else{
                    search_alert.html("输入错误");
                    search_alert.css("top",0);
                    setTimeout(function(){
                        search_alert.css("top","-100%");
                    },3000)
                }
            }
        };
    })
})