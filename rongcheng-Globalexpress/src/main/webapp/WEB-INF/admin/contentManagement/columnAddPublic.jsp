<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
        <link rel="stylesheet" href="/admin/css/pintuer.css">
    <link rel="stylesheet" href="/admin/css/admin.css">
    <script src="/admin/js/jquery.js"></script>
    <script src="/admin/js/pintuer.js"></script>  
    
    <script src="/admin/zb/js/contentManagement/cookie_util.js"></script>
    <script src="/admin/zb/js/contentManagement/basevalue.js"></script>
    <script src="/admin/zb/js/contentManagement/columnAddPublic.js"></script>
	<style type="text/css">
	</style>
</head>
<body>
  <div class="panel admin-panel margin-top">
  <div class="panel-head"><strong><span class="icon-pencil-square-o" id="columnAddPublic_webPageType"></span></strong></div>
    <div class="body-content">
      <form class="form-x" id="columnAddPublic_form">   
        <input type="hidden" name="id"  value="" /> 
        <div class="form-group">
          <div class="label">
            <label>类型：</label>
          </div>
          <div class="field">
            <select name="recordType" class="input w50" style="cursor: pointer;">
              <option value="1">栏目区</option>
              <option value="2">轮播区</option>
              <option value="3">视频区</option>
              <option value="4">商品页面</option>
              <option value="5">首页导航</option>
            </select>
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group" id="columnAddPublic_parentBlockChannel" style="display: none;">
          <div class="label">
            <label>上级栏目：</label>
          </div>
          <div class="field">
            <div class="change_column_inner">
              <div class="change_column" style="cursor:pointer;"></div>
              <ul class="change_column_box">
              <!-- 加载栏目列表 -->
              </ul>
            </div>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>标题：</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" name="blockTitle" value=""/>
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>子标题：</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" name="blockSubtitle" value=""/>         
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>英文标题：</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" name="enTitle" value=""/>         
            <div class="tips"></div>
          </div>
        </div> 
        <div class="form-group">
          <div class="label">
            <label>缩略图：</label>
          </div>
          <div class="field">
            <input type="text" id="columnAddPublic_fileName" readonly="readonly" class="input" style="width:25%; float:left;background: #FFF;cursor: default;"  value="" />
            <button type="button" class="btn btn-warning btn-s file-button"  id="btn1" onclick="columnAddPublic_myfile.click();" style="float: left;">
              <span class="glyphicon glyphicon-ban-circle"></span>十上传
            </button>
            <input type="file" id="columnAddPublic_myfile" name="iconUrl" class="file-btn">
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>跳转链接：</label>
          </div>
          <div class="field">
            <input type="text" class="input" name="iconDirectLink" value="" />         
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>标题简介：</label>
          </div>
          <div class="field">
            <textarea class="input" name="blockProfile" style="height:100px;" ></textarea>    
            <div class="tips"></div>     
          </div>
        </div>  
        <div class="form-group">
          <div class="label">
            <label>标签：</label>
          </div>
          <div class="field">
            <input type="text" class="input" name="blockLabel" value=""/>     
            <div class="tips"></div>     
          </div>
        </div>     
        <div class="form-group">
          <div class="label">
            <label>内部分类关键字：</label>
          </div>
          <div class="field">
            <input type="text" class="input" name="blockKeyword" value="" />     
            <div class="tips"></div>     
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>备注：</label>
          </div>
          <div class="field">
            <input type="text" class="input" name="note"/>
            <div class="tips"></div>     
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>排序：</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" name="userSequence" value="0" />
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>显示：</label>
          </div>
          <div class="field">
            <div class="button-group radio">
              <label class="button active">
                <span class="icon icon-check"></span>             
                  <input name="show" value="true" type="radio" checked="checked">是             
              </label>
              <label class="button active"><span class="icon icon-times"></span>            
                  <input name="show" value="false"  type="radio" checked="checked">否
              </label>         
            </div>       
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label></label>
          </div>
          <div class="field">
            <button class="button bg-main icon-check-square-o" type="button" id="columnAddPublic_commit"> 提交</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>