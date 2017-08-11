package com.rongcheng_tech.cms.service.ItemInfo;

import java.util.List;

import com.rongcheng_tech.cms.entity.ItemInfo;

/**
 * 
 * @author jxb
 *
 */
public interface ItemInfoService {

	/**
	 * 分页查询
	 *
	 * @param ownerId
	 * @param page
	 * @param rows
	 * @return
	 */
	Object[] pageByOwnerIdAndKeyword(Long ownerId, int page, int rows, String blockChannelId, String keyword);
	//模糊查找商品编号
	List<ItemInfo> getItemSku(String keyword,Long ownerId);
}