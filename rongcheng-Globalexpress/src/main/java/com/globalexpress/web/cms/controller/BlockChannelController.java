package com.globalexpress.web.cms.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globalexpress.web.entity.UserInfo;
import com.globalexpress.web.util.FileTool;
import com.globalexpress.web.util.JsonResult;
import com.globalexpress.web.cms.exception.ExistChildrenBlockChannelException;
import com.globalexpress.web.cms.service.BlockChannelService;

/**
 * 栏目通道管理表 Controller层
 * 
 * <p>栏目表在JAVA中处理交互。
 * 
 * @author 赵滨
 */
@Controller
@RequestMapping("/admin")
public class BlockChannelController {
    
    
    //分页相关（每页多少条）
    @Value("#{config['rows']}")
    private int rows;
    
    //ownerId（放在每个controller全局变量位置，在方法里直接用）
//    @Value("#{config['ownerId']}")
//    private Long ownerId;
    
    /**
     * 栏目通道管理表 Service层 对象
     */
    @Resource
    private BlockChannelService blockService;
    

    
    /**
     * 加载栏目管理页面(jxb修改适配自己页面)
     * 
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @param keywords 关键字
     * @param recordType 类型数组
     * @return
     * @author 赵滨
     */
    @ResponseBody
    @RequestMapping("/column/loadColumn-jxb.do")
    public JsonResult loadColumn(Integer[] recordType, String keywords, HttpSession session) {
    	Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
    	Long operatorId =  ((UserInfo) session.getAttribute("user")).getId();
    	Boolean authorization = true; 
        //定义返回集合
        Map<String, Object> map = new HashMap<String, Object>();
        //添加显示行数
        map.put("rows", rows);
        //添加栏目集合
        map.put("blockChannelList", 
                blockService.listBlockChannel(recordType, ownerId, operatorId, authorization, keywords));
        //返回
        return new JsonResult(map);
    }
    
    /**
     * 跳转栏目管理页面
     * 
     * @return jsp页面
     * @author 赵滨
     */
    @RequestMapping("/column.do")
    public String column() {
        return "admin/contentManagement/column";
    }
    
    /**
     * 加载栏目管理页面
     * 
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @param keywords 关键字
     * @param recordType 类型数组
     * @return
     * @author 赵滨
     */
    @ResponseBody
    @RequestMapping("/column/loadColumn.do")
    public JsonResult loadColumn(Integer[] recordType, Long operatorId, Boolean authorization, String keywords, HttpSession session) {
    	Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
    	operatorId =  ((UserInfo) session.getAttribute("user")).getId();
        //定义返回集合
        Map<String, Object> map = new HashMap<String, Object>();
        //添加显示行数
        map.put("rows", rows);
        //添加栏目集合
        map.put("blockChannelList", 
                blockService.listBlockChannel(recordType, ownerId, operatorId, authorization, keywords));
        //返回
        return new JsonResult(map);
    }
   
    /**
     * 移除 栏目通道管理表
     * 
     * @param blockChannelId 栏目ID[]
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @return
     * @author 赵滨
     */
    @ResponseBody
    @RequestMapping("/column/removeBlockChannel.do")
    public JsonResult removeBlockChannel(Long[] blockChannelId, Long operatorId, Boolean authorization, 
            HttpServletRequest request, HttpSession session) {
    	Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
    	operatorId =  ((UserInfo) session.getAttribute("user")).getId();
        //删除内容
        int row = blockService.removeBlockChannelById(blockChannelId, ownerId, operatorId, 
                authorization, request);
        //删除
        return new JsonResult(row);
    }
    
    /**
     * 存在子类栏目异常
     * 
     * @param e 异常
     * @return
     * @author 赵滨
     */
    @ExceptionHandler(ExistChildrenBlockChannelException.class)
    @ResponseBody
    public JsonResult existChildrenBlockChannelException(ExistChildrenBlockChannelException e){
        e.printStackTrace();
        return new JsonResult(1,e);
    }
    
    /**
     * 跳转栏目添加修改页面
     * 
     * @return jsp页面
     * @author 赵滨
     */
    @RequestMapping("/columnAddPublic.do")
    public String columnAddPublic() {
        return "admin/contentManagement/columnAddPublic";
    }
    
    /**
     * 加载栏目添加修改页面
     * @param recordType 类型数组
     * @param blockChannelId 栏目ID
     * @param blockChannelParentId 父类ID
     * @param buttonType 按钮类型
     * @param authorization 是否授权
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @return
     * @author 赵滨
     */
    @ResponseBody
    @RequestMapping("/columnAddPublic/loadColumnAddPublic.do")
    public JsonResult loadColumnAddPublic(Integer[] recordType, Long blockChannelId, Long blockChannelParentId, 
            String buttonType, Boolean authorization, Long operatorId, HttpSession session) {
    	Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
    	operatorId =  ((UserInfo) session.getAttribute("user")).getId();
        //创建返回map
        Map<String, Object> map = new HashMap<String, Object>();
        
        //根据父类ID查找最大序号
        map.put("userSequence", blockService.
                getBlockChannelMaxUserSequenceByParentId(recordType, blockChannelParentId, ownerId, operatorId, authorization));
        
        //如果是修改
        if ("column_publicParent".equals(buttonType) || "column_publicChildren".equals(buttonType) || 
                "type_publicParent".equals(buttonType) || "type_publicChildren".equals(buttonType)) {
            //根据栏目ID查找单条栏目
            map.put("blockChannel", blockService.getBlockChannelById(blockChannelId, ownerId, operatorId, authorization));
            
            //如果是修改子栏目
//            if ("column_publicChildren".equals(buttonType)) {
//                //查找上级栏目
//                map.put("blockChannelList", );
//            }
        }
        
        return new JsonResult(map);
    }
    
    /**
     * 栏目添加修改页面 提交按钮
     * @param request
     * @return
     * @author 赵滨
     */
    @ResponseBody
    @RequestMapping("/columnAddPublic/columnAddPublicCommit.do")
    public JsonResult columnAddPublicCommit(HttpServletRequest request, HttpSession session) {
    	Long ownerId = ((UserInfo)session.getAttribute("user")).getOwnerId();
        // 转型为MultipartHttpRequest
        MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);
        
        //获取各项参数
        Integer recordType = Integer.valueOf(multipartRequest.getParameter("recordType"));
        String blockTitle = multipartRequest.getParameter("blockTitle");
        String blockSubtitle = multipartRequest.getParameter("blockSubtitle");
        String enTitle = multipartRequest.getParameter("enTitle");
        String iconDirectLink = multipartRequest.getParameter("iconDirectLink");
        String blockProfile = multipartRequest.getParameter("blockProfile");
        String blockLabel = multipartRequest.getParameter("blockLabel");
        String blockKeyword = multipartRequest.getParameter("blockKeyword");
        String note = multipartRequest.getParameter("note");
        Integer userSequence = Integer.valueOf(multipartRequest.getParameter("userSequence"));
        Boolean show = Boolean.valueOf(multipartRequest.getParameter("show"));
        
//        Long ownerId = Long.valueOf(multipartRequest.getParameter("ownerId"));
        Long operatorId = ((UserInfo) session.getAttribute("user")).getId();
        Boolean authorization = Boolean.valueOf(multipartRequest.getParameter("authorization"));
        Long blockChannelId = Long.valueOf(multipartRequest.getParameter("blockChannelId"));
        Long blockChannelParentId = Long.valueOf(multipartRequest.getParameter("blockChannelParentId"));
        String buttonType = multipartRequest.getParameter("buttonType");

        //相对项目根路径
        String imgPath = "";
        System.out.println(ownerId+","+operatorId+","+authorization+","+
                    blockChannelId+","+blockChannelParentId+","+buttonType);
        System.out.println(recordType+","+blockTitle+","+blockSubtitle+","+enTitle+","+
                iconDirectLink+","+blockProfile+","+blockLabel+","+
                blockKeyword+","+userSequence+","+show+","+imgPath);
        
        
        // 获取项目路径
        String projectPath = FileTool.getProjectPath(multipartRequest, "/");
        
        //定义类型路径
        String typeUrl = null;
        
        //如果是栏目
        if ("column_addParent".equals(buttonType) || "column_addChildren".equals(buttonType) || 
                "column_publicParent".equals(buttonType) || "column_publicChildren".equals(buttonType)) {
            typeUrl = "media/icon/block/";
        //如果是类目
        } else if ("type_addParent".equals(buttonType) || "type_addChildren".equals(buttonType) || 
                "type_publicParent".equals(buttonType) || "type_publicChildren".equals(buttonType)) {
            typeUrl = "media/icon/categorie/";
        }
        
        //保存文件，获取路径     
        imgPath = typeUrl + FileTool.fileSaveSrc(multipartRequest, projectPath, typeUrl, "", "");
        
        int row = 0;
        
        //如果是添加
        if ("column_addParent".equals(buttonType) || "column_addChildren".equals(buttonType) || 
                "type_addParent".equals(buttonType) || "type_addChildren".equals(buttonType)) {
            //添加
            row = blockService.saveBlockChannel(blockTitle, blockSubtitle, enTitle, blockProfile, 
                    blockLabel, blockKeyword, imgPath, iconDirectLink, blockChannelParentId, recordType, userSequence, 
                    show, ownerId, operatorId, authorization, note);
            
        //如果是修改
        } else if ("column_publicParent".equals(buttonType) || "column_publicChildren".equals(buttonType) || 
                "type_publicParent".equals(buttonType) || "type_publicChildren".equals(buttonType)) {
            
        	System.out.println(imgPath);
        	
            //如果没有更新图片，返回的是error
            if(imgPath.equals("media/icon/block/error") || imgPath.equals("media/icon/categorie/error")){
                
            	//获取路径
                imgPath = blockService.getBlockChannelById(blockChannelId, 
                        ownerId, operatorId, authorization).getIconUrl();
                
            } else {
            	
            	//获取路径
                String url = blockService.getBlockChannelById(blockChannelId, 
                        ownerId, operatorId, authorization).getIconUrl();
                
                //删除
                FileTool.deleteFile(request, url);
                
            }
            
            
            //修改
            row = blockService.modifyBlockChannel(blockChannelId, blockTitle, blockSubtitle, enTitle, 
                    blockProfile, blockLabel, blockKeyword, imgPath, iconDirectLink, blockChannelParentId, 
                    recordType, userSequence, show, ownerId, operatorId, authorization, note);
                    
        }
        
        return new JsonResult(row);
    }
    
}
