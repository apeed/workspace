package com.rongcheng.print.dao;

import java.math.BigInteger;
import java.util.List;

import com.rongcheng.print.entity.UserInfo;

public interface UserInfoDao {
	public UserInfo findByUserInfoId(BigInteger id);
	public int modifyUserInfo(UserInfo ui);
	public int addUserInfo(UserInfo ui);
	public int delUserInfo(BigInteger id);
	public List<UserInfo> findUserInfoByPage(int start,int rows);
	public String findUserInfoCount();	
	public UserInfo getUserByAccountNum(String accountNum);
}
