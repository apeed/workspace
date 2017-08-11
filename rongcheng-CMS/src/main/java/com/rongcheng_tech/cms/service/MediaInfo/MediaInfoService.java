package com.rongcheng_tech.cms.service.MediaInfo;

/**
 * 
 * @author jxb
 *
 */
public interface MediaInfoService {

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