package com.globalexpress.web.foreground.service.derivedContentPage;

import java.util.List;

import com.globalexpress.web.entity.DerivedContentPage;

/**
 * 
 * @author jxb
 *
 */
public interface ForegroundDerivedContentPageService {

	/**
	 * 分页查询
	 *
	 * @param ownerId
	 * @param seq
	 * @param page
	 * @param rows
	 * @param blockChannelId
	 * @param keyword
	 * 
	 * @return
	 */
	Object[] pageByBlockIdAndKeyword(Long ownerId, String seq, int page, int rows, Long blockId, String keyword);
	/**
	 * 分页查询
	 *
	 * @param ownerId
	 * @param start
	 * @param rows
	 * @param blockChannelId
	 * @param keyword
	 * @return
	 */
	List<DerivedContentPage> pageByBlockIdAndKeyword(Long ownerId, int start, int rows, Long blockId, String keyword);
}