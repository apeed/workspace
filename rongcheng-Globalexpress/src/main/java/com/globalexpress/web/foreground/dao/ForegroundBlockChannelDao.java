package com.globalexpress.web.foreground.dao;

import java.util.List;

import com.globalexpress.web.entity.BlockChannel;

public interface ForegroundBlockChannelDao {

	List<BlockChannel> listSelective(BlockChannel bc);
	List<BlockChannel> listByIdList(Long ownerId, List<Long> idList);
}
