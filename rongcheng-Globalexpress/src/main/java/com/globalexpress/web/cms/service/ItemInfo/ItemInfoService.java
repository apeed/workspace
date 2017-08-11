package com.globalexpress.web.cms.service.ItemInfo;

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
}