package com.rongcheng_tech.cms.dao;

import java.util.List;
import java.util.Map;

import com.rongcheng_tech.cms.entity.ItemInfo;

public interface ItemInfoDAO {

	/**
	 * 根据条件查询记录数
	 * 
	 * @param ownerId
	 * @param blockChannelId
	 * @param keyword
	 * @return
	 */
	int countByOwnerIdAndKeyword(Long ownerId, String blockChannelId, String keyword);

	/**
	 * 根据条件查询商品列表
	 * 
	 * @param map
	 * @return
	 */
	List<ItemInfo> listByOwnerIdAndKeyword(Map<String, Object> map);

	/**
	 * 获取单个商品信息
	 * 
	 * @param record
	 * @return
	 */
	ItemInfo getSelective(ItemInfo record);

	/**
	 * 插入一个商品
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(ItemInfo record);

	/**
	 * 修改单个商品
	 * 
	 * @param record
	 * @return
	 */
	int updateSelective(ItemInfo record);

	/**
	 * 删除满足条件的商品
	 * 
	 * @param ownerId
	 * @param idArray
	 * @return
	 */
	int deleteByOwnerIdAndIdArray(Long ownerId, String[] idArray);
	//模糊查找商品编号
	List<ItemInfo> getItemSku(String keyword,Long ownerId);
}