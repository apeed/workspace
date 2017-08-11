package com.globalexpress.web.cms.service.UserInfo;

import com.globalexpress.web.entity.UserInfo;

/**
 * 
 * @author jxb
 *
 */
public interface UserInfoService_JXB {

	/**
	 * 获取单个主账号下的所有用户信息
	 *
	 * @param ownerId
	 *            主账号id
	 * @param page
	 *            要查询的页码
	 * @param rows
	 *            每页的条数
	 * @return	[int 最大页数，List<UserInfo>用户数据]
	 */
	Object[] listByOwnerIdAndPage(Long ownerId, Byte[] arr_userType, int page, int rows);

	/**
	 * 登录验证
	 * 
	 * @param account
	 * @param password
	 * @param yzm
	 * @param imgCode
	 * @return
	 * @throws RuntimeException
	 */
	UserInfo checkLogin(String account, String password, String yzm, String imgCode) throws RuntimeException;
}