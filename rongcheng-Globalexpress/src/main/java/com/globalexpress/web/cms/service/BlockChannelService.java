package com.globalexpress.web.cms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.globalexpress.web.entity.BlockChannel;
import com.globalexpress.web.cms.exception.ExistChildrenBlockChannelException;

/**
 * 栏目通道管理表 Service层
 * 
 * <p>栏目表在JAVA中处理具体业务逻辑。
 * 
 * @author 赵滨
 */
public interface BlockChannelService {

    /**
     * 查询 栏目通道管理表
     * 
     * <p>查找对象集合，是否授权、操作人ID暂时不用。
     * 
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @param keywords 关键字
     * @param recordType 类型数组
     * @return List<BlockChannel> 栏目通道管理表 集合
     * @author 赵滨
     */
    List<BlockChannel> listBlockChannel(Integer[] recordType, Long ownerId, Long operatorId, 
            Boolean authorization, String keywords);
    
    /**
     * 移除 栏目通道管理表
     * 
     * <p>根据ID删除指定栏目，不允许删除存在子类的父类，是否授权、操作人ID暂时不用。
     * 
     * @param blockChannelId 栏目ID[]
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @return request 请求
     * @return row 删除的行数
     * @author 赵滨
     */
    int removeBlockChannelById(Long[] blockChannelId, Long ownerId, Long operatorId, Boolean authorization, 
            HttpServletRequest request) throws ExistChildrenBlockChannelException;
    
    /**
     * 查询 栏目通道管理表 序号
     * 
     * <p>根据父类ID查找最大序号，是否授权暂时不用
     * 
     * @param recordType 类型数组
     * @param parentId 父类ID
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @return userSequence 序号
     * @author 赵滨
     */
    int getBlockChannelMaxUserSequenceByParentId(Integer[] recordType, Long parentId, Long ownerId, Long operatorId,
            Boolean authorization);
    
    /**
     * 查询 栏目通道管理表
     * 
     * <p>根据栏目ID查找单条栏目，是否授权暂时不用
     * 
     * @param blockChannelId 栏目ID
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @return blockChannel 栏目
     * @author 赵滨
     */
    BlockChannel getBlockChannelById(Long blockChannelId, Long ownerId, Long operatorId, Boolean authorization);
    
    /**
     * * 保存栏目通道管理表
     * 
     * <p>传入参数，封装成对象然后保存栏目表。
     * 
     * @param blockTitle 栏目标题
     * @param blockSubtitle 栏目子标题
     * @param enTitle 栏目英文标题
     * @param blockProfile 栏目简介（摘要）
     * @param blockLabel 栏目标签
     * @param blockKeyword 栏目关键字
     * @param iconUrl 缩略图地址
     * @param iconDirectLink 点击缩略图的跳转地址
     * @param parentId 父类id
     * @param recordType 该条记录类型
     * @param userSequence 用户自定义排序号
     * @param show 是否显示
     * @param ownerId 用户主账户ID
     * @param operatorId 操作人ID
     * @param authorization 是否被授权
     * @param note 备注
     * @return row 行数
     * @author 赵滨
     */
    int saveBlockChannel(String blockTitle, String blockSubtitle, String enTitle, String blockProfile, 
            String blockLabel, String blockKeyword, String iconUrl, String iconDirectLink, Long parentId, 
            Integer recordType, Integer userSequence, Boolean show, Long ownerId, Long operatorId, 
            Boolean authorization, String note);
    
    /**
     * 修改 栏目通道管理表
     * 
     * <p>传入栏目参数，查找对象，然后修改栏目内容
     * 
     * @param id 栏目ID
     * @param blockTitle 栏目标题
     * @param blockSubtitle 栏目子标题
     * @param enTitle 栏目英文标题
     * @param blockProfile 栏目简介（摘要）
     * @param blockLabel 栏目标签
     * @param blockKeyword 栏目关键字
     * @param iconUrl 缩略图地址
     * @param iconDirectLink 点击缩略图的跳转地址
     * @param parentId 父类id
     * @param recordType 该条记录类型
     * @param userSequence 用户自定义排序号
     * @param show 是否显示
     * @param ownerId 用户主账户ID
     * @param operatorId 操作人ID
     * @param authorization 是否被授权
     * @param note 备注
     * @return row 行数
     * @author 赵滨
     */
    int modifyBlockChannel(Long id, String blockTitle, String blockSubtitle, String enTitle, String blockProfile, 
            String blockLabel, String blockKeyword, String iconUrl, String iconDirectLink, Long parentId, 
            Integer recordType, Integer userSequence, Boolean show, Long ownerId, Long operatorId, 
            Boolean authorization, String note) throws ExistChildrenBlockChannelException;
    
    /**
     * 查询 栏目通道管理表 集合
     * 
     * <p>根据父类ID查找栏目集合，是否授权暂时不用。
     * 
     * @param parentId 父类ID
     * @param ownerId 主账号ID
     * @param authorization 是否授权
     * @return List<BlockChannel> 栏目集合
     * @author 赵滨
     */
//    List<BlockChannel> listBlockChannelByParentId(Long parentId, Long ownerId, Long operatorId, Boolean authorization);
}
