<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>注册</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    <script src="js/basevalue.js"></script>
    <script src="js/cookie_util.js"></script> 
    <script src="js/sign.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>打印软件注册页面</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" id="sign_accountNum" name="name" placeholder="注册账号" data-validate="required:请输入注册账号"/>
                                <span class="icon icon-user margin-small" id="sign_accountNum_span"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" id="sign_password" name="regPassword" placeholder="注册密码"  data-validate="required:请输入注册密码"/>
                                <span class="icon icon-key margin-small" id="sign_password_span"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" id="" name="password" placeholder="确认密码" data-validate="required:请输入确认密码,repeat#regPassword:两次输入的密码不一致"/>
                                <span class="icon icon-key margin-small" id=""></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" id="sign_email" name="password" placeholder="邮箱"  data-validate="required:请输入邮箱"/>
                                <span class="icon icon-envelope margin-small" id="sign_email_span"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" id="sign_telephone" name="password" placeholder="手机号"  data-validate="required:请输入手机号"/>
                                <span class="icon icon-leaf margin-small glyphicon glyphicon-phone" id="sign_telephone_span"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码"/>
                               <!-- <img src="images/passcode.jpg" alt="" width="100" height="32" class="" style="">   -->
                               <input type="button" class="button passcode text-big input-big" value="获取短信验证码
" style="height:44px;cursor:pointer;width:150px;line-height:20px;" >      
								<span id=""></span>              
                            </div>
                        </div>
                    </div>
                    <div style="padding:0 30px 30px;">
                        <input type="button" class="button button-block bg-main text-big input-big sign_reg_btn" value="注册" style="margin-bottom: 10px;">
                    </div>
                </div>
        </div>
    </div>
</div>

</body>
</html>