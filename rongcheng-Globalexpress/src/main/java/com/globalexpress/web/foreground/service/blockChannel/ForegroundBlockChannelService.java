package com.globalexpress.web.foreground.service.blockChannel;

import java.util.List;
import java.util.Map;

import com.globalexpress.web.entity.BlockChannel;

public interface ForegroundBlockChannelService {

	/**
	 * 查询某个类型的栏目及其子栏目
	 * 
	 * @return
	 */
	Map<BlockChannel,List<BlockChannel>> mapNavigationBars(Long ownerId, Integer recordType);
}
