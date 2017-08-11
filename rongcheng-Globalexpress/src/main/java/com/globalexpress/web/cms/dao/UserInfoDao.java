package com.globalexpress.web.cms.dao;
import java.util.List;
import com.globalexpress.web.entity.UserInfo;

public interface UserInfoDao {
	//分页
	 List<UserInfo> findUserInfoByPage(int start,int rows,Long ownerId);
	 String findUserInfoCount(Long ownerId);
	 //发件人
	 List<UserInfo> findUserInfoByPage1(int start,int rows,Long ownerId);
	 String findUserInfoCount1(Long ownerId);
	 UserInfo findByUserInfoId(Long id,Long ownerId);
	//修改，添加,删除方法
	 int modifyUserInfo(UserInfo sn);
	 int addUserInfo(UserInfo sn);
	 int delUserInfo(Long id,Long ownerId);
	 //模糊查询
	 List<UserInfo> findListByUserInfo(String keyword,Long ownerId);
	 List<UserInfo> findListsByUserInfo(String keyword,Long ownerId);
	 //查询所有的用户账户
	 List<UserInfo> getAccountNum(String keyword,Long ownerId);
	 //通过账号查找信息
	 UserInfo findByAccountNum(String accountNum,Long ownerId);
}
