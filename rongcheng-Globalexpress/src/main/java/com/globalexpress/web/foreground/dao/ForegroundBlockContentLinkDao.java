package com.globalexpress.web.foreground.dao;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.BlockContentLink;

public interface ForegroundBlockContentLinkDao {

	List<Long> listContentIdSelective(BlockContentLink bcl);
	Map<String, List<Long>> listMapContentIdSelective(Long blockChannelId, Long ownerId);
	List<BlockContentLink> listSelective(BlockContentLink bcl);

	int countSelective(BlockContentLink bcl, Byte[] contentType);
	List<BlockContentLink> limitSelective(BlockContentLink bcl, Byte[] contentType, int start, int rows);
}