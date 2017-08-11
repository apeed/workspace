package com.globalexpress.web.cms.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.VisitorBehavior;
import com.globalexpress.web.entity.VisitorInfo;

/**
 * 访客信息表 DAO层
 * 
 * <p>访客信息表的增删改查一系列的方法，是JAVA使用MyBatis来完成与MySQL的交互。
 * 
 * @author 赵滨
 */
public interface VisitorDAO {

    /**
     * 保存 访客行为表
     * 
     * <p>传入访客行为对象，MyBatis使用对象保存栏目表。
     * 
     * @param VisitorBehavior 访客行为对象
     * @return row 存储的行数
     * @author 赵滨
     */
    int saveVisitorBehavior(VisitorBehavior visitorBehavior);
    
    /**
     * 保存 访客信息表
     * 
     * <p>传入访客信息对象，MyBatis使用对象保存栏目表。
     * 
     * @param VisitorInfo 访客信息对象
     * @return row 存储的行数
     * @author 赵滨
     */
    int saveVisitorInfo(VisitorInfo visitorInfo);
    
    /**
     * 获取 访客信息表 集合
     * 
     * <p>根据页数获取访客
     * 
     * @param start 开始位置
     * @param rows 查询行数
     * @param ownerId 主账号ID
     * @return  List<Map<String, Object>> 访客信息表 集合
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorInfoByPage(int start, int rows, Long ownerId);
    
    /**
     * 获取 访客信息表 条数
     * @param ownerId 主账号ID
     * @return maxPage 最大条数
     * @author 赵滨
     */
    int countVisitorInfo(Long ownerId);
    
    /**
     * 获取 总体概览
     * 
     * <p>根据时间和终端获取总体概览
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return map 总体概览
     * @author 赵滨
     */
    Map<String, Object> getVisitorAllMessageByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId);
    
    /**
     * 获取 来源地区流量分析
     * 
     * <p>根据时间和终端获取来源地区流量分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @param start 开始位置
     * @param rows 查询行数
     * @return list 来源地区流量分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorLocationByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId, int start, int rows);
    
    /**
     * 获取 来源地区 最大条数
     * 
     * <p>根据时间和终端获取来源地区流量分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return maxPage 来源地区 最大条数
     * @author 赵滨
     */
    int countVisitorLocation(String timeSearch, String terminalSearch, String startTime, String endTime, 
            String yearSearch, Long ownerId);
    /**
     * 获取 星期几流量分析
     * 
     * <p>根据时间和终端获取星期几流量分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return list 星期几流量分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorDayOfWeekByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId);
    
    /**
     * 获取 页面名称页面分析
     * 
     * <p>根据时间和终端获取页面名称页面分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @param start 开始位置
     * @param rows 查询行数
     * @return list 页面名称页面分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorWebPageByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId, int start, int rows);
    
    /**
     * 获取 页面名称 最大条数
     * 
     * <p>根据时间和终端获取页面名称页面分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return maxPage 页面名称 最大条数
     * @author 赵滨
     */
    int countVisitorWebPage(String timeSearch, String terminalSearch, String startTime, String endTime, 
            String yearSearch, Long ownerId);
    /**
     * 获取 访问栏目页面分析
     * 
     * <p>根据时间和终端获取访问栏目页面分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @param start 开始位置
     * @param rows 查询行数
     * @return list 访问栏目页面分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorAccessColumnByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId, int start, int rows);
    
    /**
     * 获取 访问栏目 最大条数
     * 
     * <p>根据时间和终端获取访问栏目页面分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return maxPage 访问栏目 最大条数
     * @author 赵滨
     */
    int countVisitorAccessColumn(String timeSearch, String terminalSearch, String startTime, String endTime, 
            String yearSearch, Long ownerId);
    /**
     * 获取 来源关键词分析
     * 
     * <p>根据时间和终端获取来源关键词分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @param start 开始位置
     * @param rows 查询行数
     * @return list 来源关键词分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorExternalSourceKeywordByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId, int start, int rows);
    
    /**
     * 获取 来源关键词 最大条数
     * 
     * <p>根据时间和终端获取来源关键词分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return maxPage 来源关键词 最大条数
     * @author 赵滨
     */
    int countVisitorExternalSourceKeyword(String timeSearch, String terminalSearch, String startTime, String endTime, 
            String yearSearch, Long ownerId);
    /**
     * 获取 站内关键词分析
     * 
     * <p>根据时间和终端获取站内关键词分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @param start 开始位置
     * @param rows 查询行数
     * @return list 站内关键词分析
     * @author 赵滨
     */
    List<Map<String, Object>> listVisitorInsideSourceKeywordByTimeTerminal(String timeSearch, String terminalSearch, 
            String startTime, String endTime, String yearSearch, Long ownerId, int start, int rows);
    
    /**
     * 获取 站内关键词 最大条数
     * 
     * <p>根据时间和终端获取站内关键词分析
     * 
     * @param timeSearch 时间搜索
     * @param terminalSearch 终端搜索
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @param yearSearch 年搜索
     * @param ownerId 主账号ID
     * @return maxPage 站内关键词 最大条数
     * @author 赵滨
     */
    int countVisitorInsideSourceKeyword(String timeSearch, String terminalSearch, String startTime, String endTime, 
            String yearSearch, Long ownerId);
}
