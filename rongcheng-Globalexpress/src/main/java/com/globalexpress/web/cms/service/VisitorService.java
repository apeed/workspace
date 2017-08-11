package com.globalexpress.web.cms.service;

import java.util.Map;

/**
 * 访客信息表 Service层
 * 
 * <p>访客信息表在JAVA中处理具体业务逻辑。
 * 
 * @author 赵滨
 */
public interface VisitorService {

    /**
     * 加载页面
     * 
     * <p>根据页面类型进行不同的加载
     * 
     * @return Map<String, Object> 数据的集合
     * @author 赵滨
     */
    Map<String, Object> loadSiteAnalysis(String siteAnalysisType, String nowPage1, String nowPage2, String startTime1, 
            String endTime1, String startTime2, String endTime2, String yearSearch1, String yearSearch2, 
            String timeSearch1, String terminalSearch1, String timeSearch2, String terminalSearch2, Long ownerId, 
            int rows);
}
