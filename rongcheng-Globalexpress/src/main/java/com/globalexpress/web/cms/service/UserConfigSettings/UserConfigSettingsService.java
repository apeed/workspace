package com.globalexpress.web.cms.service.UserConfigSettings;

import java.util.HashMap;

import com.globalexpress.web.entity.UserConfigSettings;
/**
 * 
 * @author jxb
 *
 */
public interface UserConfigSettingsService {
	
	/**
	 * 获取单用户下的所有配置信息
	 *
	 * @param record
	 *            ownerId 必须为非空参数
	 * @return
	 */
	public HashMap<String, Object>  getMapConfig(UserConfigSettings record);

}