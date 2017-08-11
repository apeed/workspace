package com.globalexpress.web.cms.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.globalexpress.web.cms.dao.BlockChannelDAO;
import com.globalexpress.web.entity.BlockChannel;
import com.globalexpress.web.util.FileTool;
import com.globalexpress.web.cms.exception.ExistChildrenBlockChannelException;

/**
 * 栏目通道管理表 ServiceImpl层
 * 
 * <p>栏目表在JAVA中处理具体业务逻辑。
 * 
 * @author 赵滨
 */
@Service("blockService")
public class BlockChannelServiceImpl implements BlockChannelService {

    /**
     * 栏目通道管理表 DAO层 对象
     */
    @Resource
    BlockChannelDAO blockChannelDAO;
    
    /**
     * 查询 栏目通道管理表
     * 
     * <p>根据页数查找对象集合，是否授权暂时不用。
     * 
     * @param ownerId 主账号ID
     * @param operatorId 操作人ID
     * @param authorization 是否授权
     * @param keywords 关键字
     * @param recordType 类型数组
     * @return List<BlockChannel> 栏目通道管理表 集合
     * @author 赵滨
     */
    public List<BlockChannel> listBlockChannel(Integer[] recordType, Long ownerId, Long operatorId, 
            Boolean authorization, String keywords) {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued  
       
        //创建参数map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("recordType", recordType);
        map.put("ownerId", ownerId);
        
        //如果没有关键字
        System.out.println(keywords);
        if (keywords == null) {
            //查找返回
            return blockChannelDAO.listBlockChannelByRecordType(map);
            
        } else {
            map.put("keywords", keywords);
            //查找返回
            return blockChannelDAO.listBlockChannelByRecordTypeLike(map);
        }
        
    }

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
    public int removeBlockChannelById(Long[] blockChannelId, Long ownerId, Long operatorId, Boolean authorization, 
            HttpServletRequest request) throws ExistChildrenBlockChannelException {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued
        
        //删除的行数
        int row = 0;
        
        //遍历栏目 判断是否有子栏目
        for (int i = 0; i < blockChannelId.length; i++) {
            //子类个数
            int num = blockChannelDAO.countBlockChannelByParentId(blockChannelId[i], ownerId, authorization);
            
            //如果子类个数大于零
            if (num > 0) {
                //抛出异常
                throw new ExistChildrenBlockChannelException("请先删除该栏目下的子栏目");
            }
        }
        //遍历栏目 删除
        for (int j = 0; j < blockChannelId.length; j++) {
            //获取路径
            String url = blockChannelDAO.getBlockChannelById(blockChannelId[j], ownerId, authorization).getIconUrl();
            //删除
            row += blockChannelDAO.removeBlockChannelById(blockChannelId[j], ownerId, authorization);
            //删除图片
            FileTool.deleteFile(request, url);
        }
        
        return row;
    }
    
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
    public int getBlockChannelMaxUserSequenceByParentId(Integer[] recordType, Long parentId, Long ownerId, 
            Long operatorId, Boolean authorization) {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued
        
        //创建查找参数map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", parentId);
        map.put("ownerId", ownerId);
        map.put("authorization", authorization);
        map.put("recordType", recordType);
        
        //查询返回
        return blockChannelDAO.getBlockChannelMaxUserSequenceByParentId(map);
    }
    
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
    public BlockChannel getBlockChannelById(Long blockChannelId, Long ownerId, Long operatorId, Boolean authorization) {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued
        
        //查询返回
        return blockChannelDAO.getBlockChannelById(blockChannelId, ownerId, authorization);
    }

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
    public int saveBlockChannel(String blockTitle, String blockSubtitle, String enTitle, String blockProfile, 
            String blockLabel, String blockKeyword, String iconUrl, String iconDirectLink, Long parentId, 
            Integer recordType, Integer userSequence, Boolean show, Long ownerId, Long operatorId, 
            Boolean authorization, String note) {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued
        
        //创建时间
        Timestamp gmtCreate = new Timestamp(System.currentTimeMillis());  
        
        //接口显示名称
        String interfaceName = null;
        
        //点击量
        Integer click = 0;
        
        //自定义内容1
        String reserved1 = null;

        //该记录是否已被应用或调用
        Boolean apply = null;

        //记录修改时间
        Date gmtModified = null;
        
        //创建对象
        BlockChannel blockChannel = new BlockChannel(null, blockTitle, blockSubtitle, enTitle, interfaceName, 
                blockProfile, blockLabel, blockKeyword, iconUrl, iconDirectLink, click, parentId, recordType, 
                userSequence, show, reserved1, note, ownerId, operatorId, authorization, apply, gmtCreate, 
                gmtModified);
        
        //保存返回
        return blockChannelDAO.saveBlockChannel(blockChannel);
    }
    
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
    public int modifyBlockChannel(Long id, String blockTitle, String blockSubtitle, String enTitle, 
            String blockProfile, String blockLabel, String blockKeyword, String iconUrl, 
            String iconDirectLink, Long parentId, Integer recordType, Integer userSequence, 
            Boolean show, Long ownerId, Long operatorId, Boolean authorization, String note) 
                    throws ExistChildrenBlockChannelException {
        //判断主账号是否存在
        // To Be Continued
        
        //判断操作人是否存在
        // To Be Continued
        
        //判断是否授权
        // To Be Continued
        
        //如果父类ID等与当前ID，会报错
        if (id == parentId) {
            throw new ExistChildrenBlockChannelException("当前栏目不能当作上级栏目");
        }
        
        //修改时间
        Timestamp gmtModified = new Timestamp(System.currentTimeMillis());  
        
        //查找对象
        BlockChannel blockChannel = blockChannelDAO.getBlockChannelById(id, ownerId, authorization);
        
        //设置栏目标题
        blockChannel.setBlockTitle(blockTitle);
        
        //设置栏目子标题
        blockChannel.setBlockSubtitle(blockSubtitle);
        
        //设置栏目英文标题
        blockChannel.setEnTitle(enTitle);
        
        //设置栏目简介（摘要）
        blockChannel.setBlockProfile(blockProfile);
        
        //设置栏目标签
        blockChannel.setBlockLabel(blockLabel);
        
        //设置栏目关键字
        blockChannel.setBlockKeyword(blockKeyword);
        
        //设置缩略图地址
        blockChannel.setIconUrl(iconUrl);
        
        //设置点击缩略图的跳转地址
        blockChannel.setIconDirectLink(iconDirectLink);
        
        //设置父类id
        blockChannel.setParentId(parentId);
        
        //设置该条记录类型
        blockChannel.setRecordType(recordType);
        
        //设置用户自定义排序号
        blockChannel.setUserSequence(userSequence);
        
        //设置是否显示
        blockChannel.setShow(show);
        
        //设置操作人ID
        blockChannel.setOperatorId(operatorId);
        
        //设置是否被授权
        blockChannel.setAuthorization(authorization);
        
        //设置修改时间
        blockChannel.setGmtModified(gmtModified);
        
        //设置备注
        blockChannel.setNote(note);
        
        //修改返回
        return blockChannelDAO.modifyBlockChannel(blockChannel);
    }
}
