package com.rongcheng.rcb.dao;


import java.util.List;

import com.rongcheng.rcb.entity.Config;

public interface ConfigDao {
	List<Config> listConfig();
	int modifyConfig(String name,String value1,String value2,String value3);//修改
}
