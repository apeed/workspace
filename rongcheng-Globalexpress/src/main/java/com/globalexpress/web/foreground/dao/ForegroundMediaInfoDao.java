package com.globalexpress.web.foreground.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.MediaInfo;

public interface ForegroundMediaInfoDao {

	/**
	 * 根据id集合查找内容（按排序从小到大再按id从大到小）
	 * 
	 * @param ownerId
	 * @param idArray
	 * @return
	 */
	List<MediaInfo> listByIdList(Long ownerId, List<Long> idList);

	int countByBlockIdAndKeyword(Long ownerId, Long blockId, String keyword);

	List<MediaInfo> limitByBlockIdAndKeyword(Map<String, Object> map);
}