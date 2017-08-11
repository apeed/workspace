package com.globalexpress.web.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.cms.dao.VisitorDAO;

/**
 * 访客信息表 ServiceImpl层
 * 
 * <p>访客信息表在JAVA中处理具体业务逻辑。
 * 
 * @author 赵滨
 */
@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

    /**
     * 访客信息表 DAO层 对象
     */
    @Resource
    VisitorDAO visitorDAO;
    
    /**
     * 加载页面
     * 
     * <p>根据页面类型进行不同的加载
     * 
     * @return Map<String, Object> 数据的集合
     * @author 赵滨
     */
    public Map<String, Object> loadSiteAnalysis(String siteAnalysisType, String nowPage1, String nowPage2, 
            String startTime1, String endTime1, String startTime2, String endTime2, String yearSearch1, 
            String yearSearch2, String timeSearch1, String terminalSearch1, String timeSearch2, 
            String terminalSearch2, Long ownerId, int rows) {
        
//        System.out.println("loadSiteAnalysisServiceImpl()");
        
        //创建返回参数map
        Map<String, Object> map = new HashMap<String, Object>();
        
        //如果是实时数据
        if ("timeData".equals(siteAnalysisType)) {
            
            //是否加载第一部分
            if (!"".equals(nowPage1) || !"".equals(startTime1) || !"".equals(endTime1) || 
                    !"".equals(yearSearch1) || !"".equals(timeSearch1) || !"".equals(terminalSearch1)) {
                
                //基础信息 总体概览
                Map<String, Object> mapAllMessage = visitorDAO.getVisitorAllMessageByTimeTerminal(timeSearch1, 
                        terminalSearch1, startTime1, endTime1, yearSearch1, ownerId);
                map.put("mapAllMessage", mapAllMessage);
                
            }
            
            //是否加载第二部分
            if (!"".equals(nowPage2) || !"".equals(startTime2) || !"".equals(endTime2) || 
                    !"".equals(yearSearch2) || !"".equals(timeSearch2) || !"".equals(terminalSearch2)) {
                
                //开始条数
                int start = (Integer.valueOf(nowPage2) - 1) * rows;
                
                //访客信息 实时观察
                List<Map<String, Object>> listVisitorInfo = visitorDAO.listVisitorInfoByPage(start, rows, ownerId);
                map.put("listVisitorInfo", listVisitorInfo);
                
                //访客信息 最大条数
                int listVisitorInfoMaxPage = visitorDAO.countVisitorInfo(ownerId);
                map.put("listVisitorInfoMaxPage", (int) Math.ceil((double)listVisitorInfoMaxPage/(double)rows));
                
            }
            
        //如果是流量分析
        } else if ("flowAnalysis".equals(siteAnalysisType)) {
            
            //是否加载第一部分
            if (!"".equals(nowPage1) || !"".equals(startTime1) || !"".equals(endTime1) || 
                    !"".equals(yearSearch1) || !"".equals(timeSearch1) || !"".equals(terminalSearch1)) {
            
                //开始条数
                int start = (Integer.valueOf(nowPage1) - 1) * rows;
                
                //来源地区流量分析
                List<Map<String, Object>> listVisitorLocation = visitorDAO.listVisitorLocationByTimeTerminal
                        (timeSearch1, terminalSearch1, startTime1, endTime1, yearSearch1, ownerId, start, rows);
                map.put("listVisitorLocation", listVisitorLocation);
                
                //来源地区 最大条数
                int listVisitorLocationMaxPage = visitorDAO.countVisitorLocation(timeSearch1, terminalSearch1, 
                        startTime1, endTime1, yearSearch1, ownerId);
                map.put("listVisitorLocationMaxPage", 
                        (int) Math.ceil((double)listVisitorLocationMaxPage/(double)rows));
                
            }
            
            //是否加载第二部分
            if (!"".equals(nowPage2) || !"".equals(startTime2) || !"".equals(endTime2) || 
                    !"".equals(yearSearch2) || !"".equals(timeSearch2) || !"".equals(terminalSearch2)) {
                
                //星期几流量分析
                List<Map<String, Object>> listVisitorDayOfWeek = visitorDAO.listVisitorDayOfWeekByTimeTerminal
                        (timeSearch2, terminalSearch2, startTime2, endTime2, yearSearch2, ownerId);
                map.put("listVisitorDayOfWeek", listVisitorDayOfWeek);
                
            }
            
            
            
        //如果是页面分析
        } else if ("pageAnalysis".equals(siteAnalysisType)) {
            
            //是否加载第一部分
            if (!"".equals(nowPage1) || !"".equals(startTime1) || !"".equals(endTime1) || 
                    !"".equals(yearSearch1) || !"".equals(timeSearch1) || !"".equals(terminalSearch1)) {
              
                //开始条数
                int start = (Integer.valueOf(nowPage1) - 1) * rows;
                
                //页面名称页面分析
                List<Map<String, Object>> listVisitorWebPage = visitorDAO.listVisitorWebPageByTimeTerminal
                        (timeSearch1, terminalSearch1, startTime1, endTime1, yearSearch1, ownerId, start, rows);
                map.put("listVisitorWebPage", listVisitorWebPage);
                
                //页面名称 最大条数
                int listVisitorWebPageMaxPage = visitorDAO.countVisitorWebPage(timeSearch1, terminalSearch1, 
                        startTime1, endTime1, yearSearch1, ownerId);
                map.put("listVisitorWebPageMaxPage", (int) Math.ceil((double)listVisitorWebPageMaxPage/(double)rows));
                
            }
            
            //是否加载第二部分
            if (!"".equals(nowPage2) || !"".equals(startTime2) || !"".equals(endTime2) || 
                    !"".equals(yearSearch2) || !"".equals(timeSearch2) || !"".equals(terminalSearch2)) {
                
                //开始条数
                int start = (Integer.valueOf(nowPage2) - 1) * rows;
                
                //栏目分组访客信息
                List<Map<String, Object>> listVisitorAccessColumn = visitorDAO.listVisitorAccessColumnByTimeTerminal
                        (timeSearch2, terminalSearch2, startTime2, endTime2, yearSearch2, ownerId, start, rows);
                map.put("listVisitorAccessColumn", listVisitorAccessColumn);
                
                //栏目分组 最大条数
                int listVisitorAccessColumnMaxPage = visitorDAO.countVisitorAccessColumn(timeSearch2, terminalSearch2, 
                        startTime2, endTime2, yearSearch2, ownerId);
                map.put("listVisitorAccessColumnMaxPage", 
                        (int) Math.ceil((double)listVisitorAccessColumnMaxPage/(double)rows));
                
            }
            
            
        //如果是关键词分析
        } else if ("keywordAnalysis".equals(siteAnalysisType)) {
          
            //是否加载第一部分
            if (!"".equals(nowPage1) || !"".equals(startTime1) || !"".equals(endTime1) || 
                    !"".equals(yearSearch1) || !"".equals(timeSearch1) || !"".equals(terminalSearch1)) {
                
                //开始条数
                int start = (Integer.valueOf(nowPage1) - 1) * rows;
                
                //来源关键词分组
                List<Map<String, Object>> listVisitorExternalSourceKeyword = 
                        visitorDAO.listVisitorExternalSourceKeywordByTimeTerminal
                        (timeSearch1, terminalSearch1, startTime1, endTime1, yearSearch1, ownerId, start, rows);
                map.put("listVisitorExternalSourceKeyword", listVisitorExternalSourceKeyword);
                
                //来源关键词 最大条数
                int listVisitorExternalSourceKeywordMaxPage = visitorDAO.countVisitorExternalSourceKeyword
                        (timeSearch1, terminalSearch1, startTime1, endTime1, yearSearch1, ownerId);
                map.put("listVisitorExternalSourceKeywordMaxPage", 
                        (int) Math.ceil((double)listVisitorExternalSourceKeywordMaxPage/(double)rows));
            }
            
            //是否加载第二部分
            if (!"".equals(nowPage2) || !"".equals(startTime2) || !"".equals(endTime2) || 
                    !"".equals(yearSearch2) || !"".equals(timeSearch2) || !"".equals(terminalSearch2)) {
             
                //开始条数
                int start = (Integer.valueOf(nowPage2) - 1) * rows;
                
                //站内关键词分组
                List<Map<String, Object>> listVisitorInsideSourceKeyword = 
                        visitorDAO.listVisitorInsideSourceKeywordByTimeTerminal
                        (timeSearch2, terminalSearch2, startTime2, endTime2, yearSearch2, ownerId, start, rows);
                map.put("listVisitorInsideSourceKeyword", listVisitorInsideSourceKeyword);
                
                //站内关键词 最大条数
                int listVisitorInsideSourceKeywordMaxPage = visitorDAO.countVisitorInsideSourceKeyword
                        (timeSearch2, terminalSearch2, startTime2, endTime2, yearSearch2, ownerId);
                map.put("listVisitorInsideSourceKeywordMaxPage", 
                        (int) Math.ceil((double)listVisitorInsideSourceKeywordMaxPage/(double)rows));
                
            }
            
            
        }
        
        //返回
        return map;
    }
}
