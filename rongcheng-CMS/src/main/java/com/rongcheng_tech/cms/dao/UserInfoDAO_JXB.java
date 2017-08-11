package com.rongcheng_tech.cms.dao;

import java.util.List;

import com.rongcheng_tech.cms.entity.UserInfo;

/**
 * 
 * @author jxb
 *
 */
public interface UserInfoDAO_JXB {

	/**
	 * 获取单个用户信息
	 *
	 * @param ownerId
	 *            主账号id
	 * @param id
	 *            账号id
	 * @return
	 */
	UserInfo getById(Long ownerId, Long id);

	/**
	 * 获取单个用户全部信息
	 *
	 * @param ownerId
	 *            主账号id
	 * @param accountNum
	 *            账号
	 * @return
	 */
	UserInfo getByOwnerIdAndAccountNum(Long ownerId, String accountNum);
	
	/**
	 * 获取单个用户全部信息
	 *
	 * @param accountNum
	 *            账号
	 * @return
	 */
	UserInfo getByAccountNum(String accountNum);

	/**
	 * 获取单个主账号下的所有用户数量
	 *
	 * @param ownerId
	 *            主账号id
	 * @return
	 */
	int countByOwnerId(Long ownerId);

	/**
	 * 获取单个主账号下的所有用户信息
	 *
	 * @param ownerId
	 *            主账号id
	 * @return
	 */
	List<UserInfo> listByOwnerIdLimit(Long ownerId, int start, int rows);

	/**
	 * 删除用户
	 *
	 * @param ownerId
	 *            主账号id
	 * @param idArray
	 *            被删账号id
	 * @return
	 */
	int deleteByOwnerIdAndIds(Long ownerId, String[] idArray);

	/**
	 * 添加一个管理员用户
	 *
	 * @param record
	 *            ownerId、accountNum、userPassword必须为非空参数
	 * @return
	 */
	int insertSelective(UserInfo record);

	/**
	 * 修改当前用户信息
	 *
	 * @param record
	 *            要修改的值set进UserInfoDO（ownerId、id、userPassword作为修改条件必须为非空参数，其他不修改的内容设为null）
	 * @return
	 */
	int updateNowUserSelective(UserInfo record);
	/**
	 * 修改当前用户下子账号信息
	 *
	 * @param record
	 *            要修改的值set进UserInfoDO（ownerId、id作为修改条件必须为非空参数，其他不修改的内容设为null）
	 * @return
	 */
	int updateSelective(UserInfo record);

}