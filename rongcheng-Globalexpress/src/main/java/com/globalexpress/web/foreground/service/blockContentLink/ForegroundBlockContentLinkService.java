package com.globalexpress.web.foreground.service.blockContentLink;

import com.globalexpress.web.entity.BlockContentLink;

/**
 * 
 * @author jxb
 *
 */
public interface ForegroundBlockContentLinkService {

	/**
	 * 分页查询
	 *
	 * @param bcl
	 * @param contentType
	 * @param page
	 * @param rows
	 * @return
	 */
	Object[] pageSelective(BlockContentLink bcl, Byte[] contentType, int page, int rows);
}