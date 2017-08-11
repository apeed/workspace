package com.globalexpress.web.foreground.service.userConfigSettings;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.globalexpress.web.entity.UserConfigSettings;
import com.globalexpress.web.foreground.dao.ForegroundUserConfigSettingsDao;


/**
 * 
 * @author jxb
 *
 */
@Service("fconfigService")
public class ForegroundUserConfigSettingsServiceImpl implements ForegroundUserConfigSettingsService {

	@Resource
	private ForegroundUserConfigSettingsDao dao;

	public HashMap<String, Object> getMapConfig(UserConfigSettings record) {
		List<UserConfigSettings> configList = dao.list(record);
		HashMap<String, Object> configMap = new HashMap<String, Object>();
		for (UserConfigSettings config : configList) {
			configMap.put(config.getParameterName(), config);
		}
		return configMap;
	}

}
