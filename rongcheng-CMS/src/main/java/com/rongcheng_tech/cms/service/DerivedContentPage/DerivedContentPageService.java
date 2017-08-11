package com.rongcheng_tech.cms.service.DerivedContentPage;

/**
 * 
 * @author jxb
 *
 */
public interface DerivedContentPageService {

	/**
	 * 分页查询栏目热度排行
	 *
	 * @param ownerId
	 * @param seq
	 * @param page
	 * @param rows
	 * @return
	 */
	Object[] pageByOwnerIdAndKeyword(Long ownerId, String seq, int page, int rows, String blockChannelId, String keyword);
}