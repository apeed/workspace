package com.rongcheng_tech.cms.dao;

import java.util.List;

import com.rongcheng_tech.cms.entity.UserConfigSettings;

/**
 * 
 * @author jxb
 *
 */
public interface UserConfigSettingsDAO {
	/**
	 * 查询单个配置信息
	 * 
	 * @param record
	 *            只有parameterName 和 ownerId 为有效条件
	 * @return
	 */
	UserConfigSettings getSelective(UserConfigSettings record);

	/**
	 * 删除单个配置信息
	 * 
	 * @param record
	 *            只有parameterName 和 ownerId 为有效条件
	 * @return
	 */
	int deleteSelective(UserConfigSettings record);

	/**
	 * 新增单个配置信息
	 * 
	 * @param record
	 *            parameterName 、 ownerId 、gmtCreate 必须为非空参数，且 parameterName 与
	 *            ownerId 的组合唯一
	 * @return
	 */
	int insertSelective(UserConfigSettings record);

	/**
	 * 修改单用户下的配置信息
	 * 
	 * @param configList
	 *              要修改的值set进UserConfigSettings（ownerId 和 parameterName作为修改条件必须为非空参数，id值修改无效，其他不修改的内容设为null）
	 * @return
	 */
	int updateSelective(List<UserConfigSettings> configList);

	/**
	 * 获取单用户下的所有配置信息
	 *
	 * @param record
	 *            ownerId 必须为非空参数
	 * @return
	 */
	List<UserConfigSettings> list(UserConfigSettings record);
}