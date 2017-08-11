package com.rongcheng_tech.cms.service.UserConfigSettings;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng_tech.cms.dao.UserConfigSettingsDAO;
import com.rongcheng_tech.cms.entity.UserConfigSettings;

/**
 * 
 * @author jxb
 *
 */
@Service
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
