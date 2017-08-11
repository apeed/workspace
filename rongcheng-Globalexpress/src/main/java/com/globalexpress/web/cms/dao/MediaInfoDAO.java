package com.globalexpress.web.cms.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.MediaInfo;

public interface MediaInfoDAO {
	
	MediaInfo getSelective(MediaInfo record);
    int insertSelective(MediaInfo record);
    int updateSelective(MediaInfo record);   
	int deleteByOwnerIdAndIdArray(Long ownerId, String[] idArray);
	int countByBlockIdAndKeyword(Long ownerId, String blockChannelId, String keyword);
	List<MediaInfo> limitByBlockIdAndKeyword(Map<String, Object> map);
}