package com.globalexpress.web.foreground.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.DerivedContentPage;

public interface ForegroundDerivedContentPageDao {

	DerivedContentPage getSelective(DerivedContentPage record);
	
	/**
	 * 根据id集合查找内容（按排序从小到大再按id从大到小）
	 * 
	 * @param ownerId
	 * @param idArray
	 * @return
	 */
	List<DerivedContentPage> listByIdList(Long ownerId, List<Long> idList);

	int countByOwnerIdAndKeyword(Long ownerId, Long blockId, String keyword);

	List<DerivedContentPage> limitByBlockIdAndKeyword(Map<String, Object> map);
}