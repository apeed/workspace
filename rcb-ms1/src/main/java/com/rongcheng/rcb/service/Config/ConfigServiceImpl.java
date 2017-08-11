package com.rongcheng.rcb.service.Config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.ConfigDao;
import com.rongcheng.rcb.entity.Config;

@Service("configService")
public class ConfigServiceImpl implements ConfigService {

	@Resource
	private ConfigDao dao;
	public List<Config> listConfig() {
		List<Config> c=dao.listConfig();
		return c;
	}
	public int modifyConfig(Map<String,String[]> map) {
		Set<String> ks = map.keySet();
		int n = 0;
		for (String key : ks) {
			String value = map.get(key)[0];
			int i=dao.modifyConfig(key,value,"","");
			n+=i;
		}
		
		return n;
	}
	/**
	 * 
	 * @author jxb
	 *
	 * @return
	 */
	public HashMap<String, Config>  mapConfig() {
		List<Config> configList = dao.listConfig();
		HashMap<String, Config> configMap = new HashMap<String, Config>();
		for (Config config : configList) {
			configMap.put(config.getParamName(), config);
		}
		return configMap;
	}
	
}

