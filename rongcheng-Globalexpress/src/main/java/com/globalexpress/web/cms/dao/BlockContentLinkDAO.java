package com.globalexpress.web.cms.dao;

import java.util.List;

import com.globalexpress.web.entity.BlockContentLink;

public interface BlockContentLinkDAO {
	int insertSelective(BlockContentLink record);
	
	int insertListSelective(List<BlockContentLink> record);
	
    int deleteByArrContentIdAndcontentType(String[] arr_str_id, Byte contentType, Long ownerId);
    
    int deleteSelectiveByList(List<BlockContentLink> record);
    
    List<Long> listBlockIdByContentIdAndContentType(Long contentId, Byte contentType, Long ownerId);

    int updateByPrimaryKeySelective(BlockContentLink record);

}