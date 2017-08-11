package com.rongcheng_tech.cms.dao;

import java.util.List;
import java.util.Map;

import com.rongcheng_tech.cms.entity.MediaInfo;

public interface MediaInfoDAO {
	
	int countByOwnerIdAndKeyword(Long ownerId, String blockChannelId, String keyword);
    List<MediaInfo> listByOwnerIdAndKeyword(Map<String, Object> map);
	MediaInfo getSelective(MediaInfo record);
    int insertSelective(MediaInfo record);
    int updateSelective(MediaInfo record);   
	int deleteByOwnerIdAndIdArray(Long ownerId, String[] idArray);
}