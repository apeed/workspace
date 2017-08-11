package com.globalexpress.web.foreground.service.mediaInfo;

import java.util.List;

import com.globalexpress.web.entity.MediaInfo;

/**
 * 
 * @author jxb
 *
 */
public interface ForegroundMediaInfoService {

	/**
	 * 分页查询
	 *
	 * @param ownerId
	 * @param page
	 * @param rows
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
	List<MediaInfo> pageByBlockIdAndKeyword(Long ownerId, int start, int rows, Long blockId, String keyword);
}