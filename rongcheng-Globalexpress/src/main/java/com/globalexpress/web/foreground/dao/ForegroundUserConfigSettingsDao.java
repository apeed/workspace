package com.globalexpress.web.foreground.dao;

import java.util.List;

import com.globalexpress.web.entity.UserConfigSettings;

/**
 * 
 * @author jxb
 *
 */
public interface ForegroundUserConfigSettingsDao {
	/**
	 * 查询单个配置信息
	 * 
	 * @param record
	 *            只有parameterName 和 ownerId 为有效条件
	 * @return
	 */
	UserConfigSettings getSelective(UserConfigSettings record);

	/**
	 * 获取单用户下的所有配置信息
	 *
	 * @param record
	 *            ownerId 必须为非空参数
	 * @return
	 */
	List<UserConfigSettings> list(UserConfigSettings record);
}