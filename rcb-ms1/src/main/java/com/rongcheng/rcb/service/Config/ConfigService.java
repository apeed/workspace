package com.rongcheng.rcb.service.Config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rongcheng.rcb.entity.Config;

public interface ConfigService {/*
	public Config findConfigById(String userId);//通过id查询一条信息 
	public Config addConfig(String userId,String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content);//添加设置
	public int modifySettings(String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content);//修改
*/
	List<Config> listConfig();
	int modifyConfig(Map<String,String[]> map);//修改
	/**
	 * 
	 * @author jxb
	 *
	 * @return
	 */
	HashMap<String, Config> mapConfig();
}
