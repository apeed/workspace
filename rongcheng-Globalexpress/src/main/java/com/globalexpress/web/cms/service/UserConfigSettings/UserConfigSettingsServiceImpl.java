package com.globalexpress.web.cms.service.UserConfigSettings;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.cms.dao.UserConfigSettingsDAO;
import com.globalexpress.web.entity.UserConfigSettings;

/**
 * 
 * @author jxb
 *
 */
@Service("configService")
public class UserConfigSettingsServiceImpl implements UserConfigSettingsService {

	@Resource
	private UserConfigSettingsDAO dao;

	public HashMap<String, Object> getMapConfig(UserConfigSettings record) {
		List<UserConfigSettings> configList = dao.list(record);
		HashMap<String, Object> configMap = new HashMap<String, Object>();
		for (UserConfigSettings config : configList) {
			configMap.put(config.getParameterName(), config);
		}
		return configMap;
	}

}
