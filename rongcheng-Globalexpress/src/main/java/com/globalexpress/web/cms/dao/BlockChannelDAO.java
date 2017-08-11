package com.globalexpress.web.cms.dao;


import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.BlockChannel;

/**
 * 栏目通道管理表 DAO层
 * 
 * <p>栏目表的增删改查一系列的方法，是JAVA使用MyBatis来完成与MySQL的交互。
 * 
 * @author 赵滨
 */
public interface BlockChannelDAO {
    
    /**
     * 查询 栏目通道管理表 条数
     * 
     * <p>根据父类ID查找栏目所有内容的条数，是否授权暂时不用。
     * 
     * @param parentId 父类ID
     * @param ownerId 主账号ID
     * @param authorization 是否授权
     * @return 条数
     * @author 赵滨
     */
    int countBlockChannelByParentId(Long parentId, Long ownerId, Boolean authorization);
    
    /**
     * 查询 栏目通道管理表
     * 
     * <p>查找对象集合，是否授权暂时不用。
     * 
     * @param params 是否授权, 主账户ID, 栏目类型[]
     * @return List<BlockChannel> 栏目通道管理表 集合
     * @author 赵滨
     */
    List<BlockChannel> listBlockChannelByRecordType(Map<String, Object> params);
    
    /**
     * 查询 栏目通道管理表
     * 
     * <p>根据模糊查询对象集合，是否授权暂时不用。
     * 
     * @param params 是否授权, 主账户ID, 栏目类型[], 查询关键内容
     * @returnList<BlockChannel> 栏目通道管理表 集合
     * @author 赵滨
     */
    List<BlockChannel> listBlockChannelByRecordTypeLike(Map<String, Object> params);
    
    /**
     * 移除 栏目通道管理表
     * 
     * <p>根据ID删除指定栏目，是否授权暂时不用。
     * 
     * @param blockChannelId 栏目ID
     * @param ownerId 主账号ID
     * @param authorization 是否授权
     * @return row 删除的行数
     * @author 赵滨
     */
    int removeBlockChannelById(Long blockChannelId, Long ownerId, Boolean authorization);
    
    /**
     * 查询 栏目通道管理表 序号
     * 
     * <p>根据父类ID查找最大序号，是否授权暂时不用
     * 
     * @param params 父类ID, 是否授权, 主账户ID, 栏目类型[]
     * @return userSequence 序号
     * @author 赵滨
     */
    int getBlockChannelMaxUserSequenceByParentId(Map<String, Object> params);
    
    /**
     * 查询 栏目通道管理表
     * 
     * <p>根据栏目ID查找单条栏目，是否授权暂时不用
     * 
     * @param blockChannelId 栏目ID
     * @param ownerId 主账号ID
     * @param authorization 是否授权
     * @return blockChannel 栏目
     * @author 赵滨
     */
    BlockChannel getBlockChannelById(Long blockChannelId, Long ownerId, Boolean authorization);

    /**
     * 保存 栏目通道管理表
     * 
     * <p>传入栏目对象，MyBatis使用对象保存栏目表。
     * 
     * @param BlockChannel 栏目对象
     * @return row 存储的行数
     * @author 赵滨
     */
    int saveBlockChannel(BlockChannel blockChannel);
    
    /**
     * 修改 栏目通道管理表
     * 
     * <p>传入栏目对象修改栏目内容
     * 
     * @param blockChannel 栏目
     * @return row 行数
     * @author 赵滨
     */
    int modifyBlockChannel(BlockChannel blockChannel);
    
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
//    List<BlockChannel> listBlockChannelByParentId(Long parentId, Long ownerId, Boolean authorization);
}
