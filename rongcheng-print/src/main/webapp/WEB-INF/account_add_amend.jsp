<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
     <script src="js/basevalue.js"></script>
    <script src="js/cookie_util.js"></script> 
    <script src="js/account_add_amend.js"></script>  
    <script type="text/javascript">
     $(function() {
    	if(getCookie("ownerId")==null){
    		top.location.href="admin.do";
    	}
	}); 
    </script> 
</head>
<body style="position: relative;">
  	<div class="panel admin-panel accredit-height">
	    <div class="panel-head"><strong class="icon-reorder"> 商品信息设置</strong></div>
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="submit" class="button border-main accredit_add_amend"><span class="icon-plus"></span> 新建用户</button>
	        </li>
	      </ul>
	    </div>
	    <table class="table table-hover text-center" id="userInfo_table">
			<!-- <tr>
				<th width="50">序号</th>
				<th>用户名</th>       
				<th>创建时间</th>
				<th>账号类型</th>
				<th>启用/停用</th>
				<th width="350">操作</th>       
			</tr>  -->     
			<!-- <tr>
				<td>1</td>
				<td>盘础款</td>  
				<td>1991/10/11</td>
				<td>二代亚</td>
				<td>停用</td>
				<td>
					<button type="submit" class="button border-blue accredit_add_amend"><span class="icon-edit"></span> 修改</button>
					<button type="submit" class="button border-green"><span class="icon-check"></span> 启用</button>
				  	<button type="submit" class="button border-black"><span class="icon-minus"></span> 停用</button>
				  	<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 删除</button>
				</td>
			</tr>
	      	<tr>
				<td>1</td>
				<td>盘础款</td>
				<td>2019/10/89</td>
				<td>二代亚</td>
				<td>停用</td>
				<td>
					<button type="submit" class="button border-blue accredit_add_amend"><span class="icon-edit"></span> 修改</button>
					<button type="submit" class="button border-green"><span class="icon-check"></span> 启用</button>
				  	<button type="submit" class="button border-black"><span class="icon-minus"></span> 停用</button>
				  	<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 删除</button>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td>盘础款</td>  
				<td>1991/10/11</td>
				<td>二代亚</td>
				<td>停用</td>
				<td>
					<button type="submit" class="button border-blue accredit_add_amend"><span class="icon-edit"></span> 修改</button>
					<button type="submit" class="button border-green"><span class="icon-check"></span> 启用</button>
				  	<button type="submit" class="button border-black"><span class="icon-minus"></span> 停用</button>
				  	<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 删除</button>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td>盘础款</td>  
				<td>1991/10/11</td>
				<td>二代亚</td>
				<td>停用</td>
				<td>
					<button type="submit" class="button border-blue accredit_add_amend"><span class="icon-edit"></span> 修改</button>
					<button type="submit" class="button border-green"><span class="icon-check"></span> 启用</button>
				  	<button type="submit" class="button border-black"><span class="icon-minus"></span> 停用</button>
				  	<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 删除</button>
				</td>
			</tr>
			<tr>
				<td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
			</tr> -->
		</table>
 	</div>


  <!-- 添加修改弹出框 -->
  <div class="shade_accredit">
    <div class="accreait_beij">

    </div>
    <div class="accreait_content" style="height: 400px;">
		<div class="panel admin-panel" style="margin-bottom: 20px;border:none;">
		    <div class="panel-head"><strong class="icon-reorder">账号设置</strong></div>
		    <div class="body-content" style="padding-bottom:0;">
			    <div class="form-x">  
			        <div class="form-group">
				        <div class="label">
				            <label>用户名：</label>
				        </div>
				        <div class="field">
				            <input type="text" class="input" value="" id="account_name" name="title"/>
				            <div class="tips" id="account_name_div" style="color:red;"></div>
				        </div>
			        </div>
			        <div class="form-group">
				        <div class="label">
				            <label>账号：</label>
				        </div>
				        <div class="field">
				            <input type="text" class="input" value="" id="account_accountNum" name="title"/>
				            <div class="tips" id="account_accountNum_div" style="color:red;"></div>
				        </div>
			        </div>  
			        <div class="form-group">
				        <div class="label">
				            <label>密码：</label>
				        </div>
				        <div class="field">
				            <input type="text" class="input" value=""  id="account_password" name="title"/>
				            <div class="tips" id="account_password_div" style="color:red;"></div>
				        </div>
			        </div>  
			        <div class="form-group">
				        <div class="label">
				            <label>电话：</label>
				        </div>
				        <div class="field">
				            <input type="text" class="input" value=""   id="account_telephone" name="title"/>
				            <div class="tips" id="account_telephone_div" style="color:red;"></div>
				        </div>
			        </div>  
			    </div>
		    </div>
		</div>
		<div class="panel admin-panel" style="border:none;">
		    <div class="body-content">
			    <div class="form-x">  
			        <div class="form-group ">
				        <div class="label">
				            <label></label>
				        </div>
				        <div class="field">
				            <button class="button bg-main icon-check-square-o add_amend_btn"> 提交</button>
				        </div>
			        </div>
			    </div>
		    </div>
		</div>
	</div>
  </div>
  <script>
    //全选
    $("#checkall").click(function(){ 
      $("input[name='id[]']").each(function(){
        if (this.checked) {
          this.checked = false;
        }
        else {
          this.checked = true;
        }
      });
    })
  </script>
</body>
</html>