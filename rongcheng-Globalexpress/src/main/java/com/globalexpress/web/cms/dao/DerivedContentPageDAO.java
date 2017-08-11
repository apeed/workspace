package com.globalexpress.web.cms.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.DerivedContentPage;

public interface DerivedContentPageDAO {

	DerivedContentPage getSelective(DerivedContentPage record);
    int insertSelective(DerivedContentPage record);
    int updateSelective(DerivedContentPage record);   
	int deleteByOwnerIdAndIdArray(Long ownerId, String[] idArray);
	int countByBlockIdAndKeyword(Long ownerId, String blockChannelId, String keyword);
    List<DerivedContentPage> limitByBlockIdAndKeyword(Map<String, Object> map);
}