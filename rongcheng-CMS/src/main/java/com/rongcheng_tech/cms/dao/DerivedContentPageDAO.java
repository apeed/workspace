package com.rongcheng_tech.cms.dao;

import java.util.List;
import java.util.Map;

import com.rongcheng_tech.cms.entity.DerivedContentPage;

public interface DerivedContentPageDAO {

	DerivedContentPage getSelective(DerivedContentPage record);
    int insertSelective(DerivedContentPage record);
    int updateSelective(DerivedContentPage record);   
    int countByOwnerIdAndKeyword(Long ownerId, String blockChannelId, String keyword);
	int deleteByOwnerIdAndIdArray(Long ownerId, String[] idArray);
    List<DerivedContentPage> listByOwnerIdAndKeyword(Map<String, Object> map);
}