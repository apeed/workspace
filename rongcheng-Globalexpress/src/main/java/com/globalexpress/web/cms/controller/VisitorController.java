package com.globalexpress.web.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globalexpress.web.cms.service.VisitorService;
import com.globalexpress.web.entity.UserInfo;
import com.globalexpress.web.util.JsonResult;

/**
 * 栏目通道管理表 Controller层
 * 
 * <p>栏目表在JAVA中处理交互。
 * 
 * @author 赵滨
 */
@Controller
@RequestMapping("/admin")
public class VisitorController {

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
    private VisitorService visitorInfoService;
    
    /**
     * 跳转栏目管理页面
     * 
     * @return jsp页面
     * @author 赵滨
     */
    @RequestMapping("/siteAnalysis.do")
    public String siteAnalysis() {
        return "admin/websiteAnalysis/siteAnalysis";
    }
    
    
    @ResponseBody
    @RequestMapping("/siteAnalysis/loadSiteAnalysis.do")
    public JsonResult loadSiteAnalysis(String siteAnalysisType, String nowPage1, String nowPage2, String startTime1, 
            String endTime1, String startTime2, String endTime2, String yearSearch1, String yearSearch2, 
            String timeSearch1, String terminalSearch1, String timeSearch2, String terminalSearch2, HttpSession session) {
    	Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
        System.out.println(endTime1 == null);
        System.out.println(endTime1.equals(""));
        
        //返回
        return new JsonResult(visitorInfoService.loadSiteAnalysis( siteAnalysisType,  nowPage1,  nowPage2, 
                 startTime1,  endTime1,  startTime2,  endTime2,  yearSearch1, yearSearch2,  timeSearch1,  
                 terminalSearch1,  timeSearch2, terminalSearch2,  ownerId,  rows));
    }
    
}
